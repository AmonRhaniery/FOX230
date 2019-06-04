package org.aksw.fox.nerlearner.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.aksw.fox.data.Entity;
import org.aksw.fox.data.EntityClassMap;
import org.aksw.fox.data.TokenManager;
import org.aksw.fox.utils.FoxCfg;
import org.aksw.fox.utils.FoxTextUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * 
 * Classe que le os conjuntos de treino de input
 * @author NataliaGodot
 * 
 */

public class HaremPtTrainerReader implements INERReader {

    //Declara membro da classe responsavel por logar mensagens
    public static Logger LOG = LogManager.getLogger(HaremPtTrainerReader.class);

    //Funcao main usada para testar a classe
    public static void main(String[] aa) throws Exception {
        PropertyConfigurator.configure(FoxCfg.LOG_FILE);

        List<String> files = new ArrayList<>();
        File file = new File("input/haremPt");
        if (!file.exists()) {
            throw new IOException("Can't find file or directory.");
        } else {
            if (file.isDirectory()) {
                //Le todos os arquivos no diretorio
                for (File fileEntry : file.listFiles()) {
                    if (fileEntry.isFile() && !fileEntry.isHidden()) {
                        files.add(fileEntry.getAbsolutePath());
                    }
                }
            } else if (file.isFile()) {
                files.add(file.getAbsolutePath());
            } else {
                throw new IOException("Input isn't a valid file or directory.");
            }
        }

        String[] a = files.toArray(new String[files.size()]);

        INERReader haremPtTrainerReader = new HaremPtTrainerReader(a);
        haremPtTrainerReader.LOG.info("input: ");
        haremPtTrainerReader.LOG.info(haremPtTrainerReader.getInput());
        haremPtTrainerReader.LOG.info("oracle: ");
        for (Entry<String, String> e : haremPtTrainerReader.getEntities().entrySet()) {
            haremPtTrainerReader.LOG.info(e.getValue() + "-" + e.getKey());
        }
    }

    /**
     * 
     * Campos da classe 
     * 
     */

    protected File[]                  inputFiles;				//Arquivos de input
    protected StringBuffer            taggedInput = new StringBuffer();		//Texto lido dos arquivos de input
    protected String                  input       = "";
    protected HashMap<String, String> entities    = new HashMap<>();		//HashMap com entidade e classificacao

    /**
     * 
     * Metodos da classe 
     * 
     */

    //Construtor com parametro (array com strings que sao os caminhos dos inputs)
    public HaremPtTrainerReader(String[] inputPaths) throws IOException {
        initFiles(inputPaths);
    }

    //Construtor sem parametro. Vazio (???)
    public HaremPtTrainerReader() { }

    //Inicializa os arquivos de input a partir do caminho do diretorio que os contem
    public void initFiles(String folder) throws IOException {
        List<String> files = new ArrayList<>();

        File file = new File(folder);
        if (!file.exists()) {
            throw new IOException("Can't find directory.");
        } else {
            if (file.isDirectory()) {
                //Le todos os arquivos no diretorio
                for (File fileEntry : file.listFiles()) {
                    if (fileEntry.isFile() && !fileEntry.isHidden()) {
                        files.add(fileEntry.getAbsolutePath());
                    }
                }
            } else {
                throw new IOException("Input isn't a valid directory.");
            }
        }
	
	//Chama o metodo logo abaixo passando uma lista de strings com os caminhos dos arquivos de input
        initFiles(files.toArray(new String[files.size()]));
    }

    //Inicializa os arquivos de input a partir de uma lista de strings com seus nomes. Chamada no contrutor
    public void initFiles(String[] initFiles) throws IOException {
        if (LOG.isDebugEnabled())
            LOG.debug("Starting HaremPtTrainerReader...");

        inputFiles = new File[initFiles.length];

        if (LOG.isDebugEnabled())
            LOG.debug("Searching input files...");

        for (int i = 0; i < initFiles.length; i++) {
            inputFiles[i] = new File(initFiles[i]);
            if (!inputFiles[i].exists())
                throw new FileNotFoundException(initFiles[i]);
        }

	//Pega o texto a partir dos arquivos de input
        readInputFromFiles();
	//Le as entidades do texto pego na funcao acima
        parse();

    }

    //Usada apenas na funcao main de teste da classe, para logar
    public String getInput() {
        // DEBUG
        if (LOG.isDebugEnabled())
            LOG.debug("Input:\n " + input + "\n");

        // INFO
        LOG.info("Input length: " + input.length());

        return input;
    }

    //Usado apenas na funcao main de teste da classe, para pegar as entidades nomeadas
    //AINDA NAO ALTERADO!!
    public HashMap<String, String> getEntities() {
        {
            // DEBUG
            if (LOG.isDebugEnabled()) {
                LOG.debug("Starting getEntities...");
                for (Entry<String, String> e : entities.entrySet())
                    LOG.debug(e.getKey() + " -> " + e.getValue());
            }
            // INFO
            LOG.info("Oracle raw size: " + entities.size());
        }

        {
            // remove oracle entities aren't in input
            Set<Entity> set = new HashSet<>();

            for (Entry<String, String> oracleEntry : entities.entrySet())
                set.add(new Entity(oracleEntry.getKey(), oracleEntry.getValue()));

            // repair entities (use fox token)
            TokenManager tokenManager = new TokenManager(input);
            tokenManager.repairEntities(set);

            // use
            entities.clear();
            for (Entity e : set)
                entities.put(e.getText(), e.getType());
        }

        {
            // INFO
            LOG.info("oracle cleaned size: " + entities.size());
            int l = 0, o = 0, p = 0;
            for (Entry<String, String> e : entities.entrySet()) {
                if (e.getValue().equals(EntityClassMap.L))
                    l++;
                if (e.getValue().equals(EntityClassMap.O))
                    o++;
                if (e.getValue().equals(EntityClassMap.P))
                    p++;
            }
            LOG.info("oracle :");
            LOG.info(l + " LOCs found");
            LOG.info(o + " ORGs found");
            LOG.info(p + " PERs found");

            l = 0;
            o = 0;
            p = 0;
            for (Entry<String, String> e : entities.entrySet()) {
                if (e.getValue().equals(EntityClassMap.L))
                    l += e.getKey().split(" ").length;
                if (e.getValue().equals(EntityClassMap.O))
                    o += e.getKey().split(" ").length;
                if (e.getValue().equals(EntityClassMap.P))
                    p += e.getKey().split(" ").length;
            }
            LOG.info("oracle (token):");
            LOG.info(l + " LOCs found");
            LOG.info(o + " ORGs found");
            LOG.info(p + " PERs found");
            LOG.info(l + o + p + " total found");
        }

        return entities;
    }

    //Le o PREAMBLE ou o conteudo da tag TEXT para taggedInput
    //OBS: Para o nosso leitor tudo se encaixa como TEXT mas nao tem tag de abertura ou fechamento
    protected void readInputFromFiles() throws IOException {
        if (LOG.isDebugEnabled())
            LOG.debug("Starting readInputFromFiles...");

        for (File file : inputFiles) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            //boolean includeLine = false;
            while ((line = br.readLine()) != null) {
		/*
                // open
                if (line.contains("<PREAMBLE>")) {
                    includeLine = true;
                    line = line.substring(line.indexOf("<PREAMBLE>") + "<PREAMBLE>".length());
                } else if (line.contains("<TEXT>")) {
                    includeLine = true;
                    line = line.substring(line.indexOf("<TEXT>") + "<TEXT>".length());
                }
                // close
                if (includeLine) {
                    if (line.contains("</PREAMBLE>")) {
                        includeLine = false;
                        if (line.indexOf("</PREAMBLE>") > 0)
                            taggedInput.append(line.substring(0, line.indexOf("</PREAMBLE>")) + "\n");

                    } else if (line.contains("</TEXT>")) {
                        includeLine = false;
                        if (line.indexOf("</TEXT>") > 0)
                            taggedInput.append(line.substring(0, line.indexOf("</TEXT>")) + "\n");

                    } else {
                        taggedInput.append(line + "\n");
                    }
                }
		*/
		taggedInput.append(line + "\n");
            }
            br.close();
        }
    }

    //Le as entidades a partir do taggedInput
    //Principal funcao a ser alterada para o nosso leitor!
    protected String parse() {
        if (LOG.isDebugEnabled())
            LOG.debug("Starting parse ...");

        //input = taggedInput.toString().replaceAll("<p>|</p>", "");
	input = taggedInput.toString();

        while (true) {

            //int openTagStartIndex = input.indexOf("<ENAMEX");
            int openTagStartIndex = input.indexOf("<EM");
            if (openTagStartIndex == -1)
                break;
            else {
		int openTagCategStartIndex = input.indexOf("CATEG=\"", openTagStartIndex);
		int openTagCategCloseIndex = input.indexOf("\"", openTagStartIndex);
                int openTagCloseIndex = input.indexOf(">", openTagStartIndex);
                int closeTagIndex = input.indexOf("</EM>");

                try {
		    //String taggedWords pega todo o conteudo de uma tag <EM> ate seu fechamento em </EM>
                    String taggedWords = input.substring(openTagCloseIndex + 1, closeTagIndex);

		    taggedWords.replaceAll("<adj>", "");
		    taggedWords.replaceAll("<adv>", "");
		    taggedWords.replaceAll("<art>", "");
		    taggedWords.replaceAll("<conj-c>", "");
		    taggedWords.replaceAll("<conj-s>", "");
		    taggedWords.replaceAll("<n>", "");
		    taggedWords.replaceAll("<num>", "");
		    taggedWords.replaceAll("<pp>", "");
		    taggedWords.replaceAll("<prop>", "");
		    taggedWords.replaceAll("<pron-det>", "");
		    taggedWords.replaceAll("<pron-indp>", "");
		    taggedWords.replaceAll("<pron-pers>", "");
		    taggedWords.replaceAll("<prp>", "");
		    taggedWords.replaceAll("<punc>", "");
		    taggedWords.replaceAll("<v-fin>", "");
		    taggedWords.replaceAll("<v-ger>", "");
		    taggedWords.replaceAll("<v-inf>", "");
		    taggedWords.replaceAll("<v-pcp>", "");

                    String categoriesString = input.substring(openTagCategStartIndex + "CATEG=\"".length(), openTagCategCloseIndex);
                    String[] categories = categoriesString.split("\\|");

                    //Relação entre as categorias dispostas no HAREM para as da ferramenta FOX
                    for (String cat : categories) {
                        if (EntityClassMap.oracel(cat) != EntityClassMap.getNullCategory()) {

                            String[] token = FoxTextUtil.getSentenceToken(taggedWords + ".");
                            String word = "";
                            for (String t : token) {

                                if (!word.isEmpty() && t.isEmpty()) {
                                    put(word, cat);
                                    word = "";
                                } else
                                    word += t + " ";
                            }
                            if (!word.isEmpty())
                                put(word, cat);
                        }
                    }
                    //limpar CATEG="..."
                    String escapedCategoriesString = "";
                    for (String cat : categories)
                        escapedCategoriesString += cat + "\\|";

                    escapedCategoriesString = escapedCategoriesString.substring(0, escapedCategoriesString.length() - 1);

                    input = input.replaceFirst("<CATEG=\"" + escapedCategoriesString + "\"", "");
                    input = input.replaceFirst("<EM ", "");
                    input = input.replaceFirst("</EM>", "");

                } catch (Exception e) {
                    LOG.error("\n", e);
                }
            }
        }
        //limpar ID="..."
        while (true) {
            int openTagStartIndex = input.indexOf("ID=\"");
            if (openTagStartIndex == -1) {
                break;
            } else {
                int openTagCloseIndex = input.indexOf("\"", openTagStartIndex);
                String id = input.substring(openTagStartIndex + "ID=\"".length(), openTagCloseIndex - 1);
                input = input.replaceFirst("ID=\"" + id + "\"", "");
            }
        }
        //limpar TIPO="..." >
        while (true) {
            int openTagStartIndex = input.indexOf("TIPO=\"");
            if (openTagStartIndex == -1) {
                break;
            } else {
                int openTagCloseIndex = input.indexOf("\" >", openTagStartIndex);
                String tipo = input.substring(openTagStartIndex + "TIPO=\"".length(), openTagCloseIndex - 1);
                input = input.replaceFirst("TIPO=\"" + tipo + "\" >", "");
            }
        }
        /*while (true) {
            int openTagStartIndex = input.indexOf("<TIMEX");
            if (openTagStartIndex == -1) {
                break;
            } else {
                int openTagCloseIndex = input.indexOf(">", openTagStartIndex);
                String category = input.substring(openTagStartIndex + "<TIMEX TYPE=\"".length(), openTagCloseIndex - 1);
                input = input.replaceFirst("<TIMEX TYPE=\"" + category + "\">", "");
                input = input.replaceFirst("</TIMEX>", "");
            }
        }*/

        input = input.trim();
        // input = input.replaceAll("``|''", "");
        // input = input.replaceAll("\\p{Blank}+", " ");
        // input = input.replaceAll("\n ", "\n");
        // input = input.replaceAll("\n+", "\n");
        // input = input.replaceAll("[.]+", ".");
        return input;
    }

    protected void put(String word, String classs) {
        word = word.trim();
        if (!word.isEmpty()) {
            if (entities.get(word) != null) {
                if (!entities.get(word).equals(classs) && !entities.get(word).equals(EntityClassMap.getNullCategory())) {
                    LOG.debug("Oracle with a token with diff. annos. No disamb. for now. Ignore token.");
                    LOG.debug(word + " : " + classs + " | " + entities.get(word));
                    entities.put(word, EntityClassMap.getNullCategory());
                }
            } else
                entities.put(word, classs);
        }
    }

}

