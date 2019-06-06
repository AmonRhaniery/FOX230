package org.aksw.fox.tools.ner.pt;

import java.util.Properties;

import org.aksw.fox.data.EntityClassMap;
import org.aksw.fox.tools.ner.common.StanfordCommon;
import org.aksw.fox.utils.FoxConst;

/**
 * @author Stefan Heid
 */
public class StanfordPT extends StanfordCommon {

    private static Properties props = new Properties();

    static {
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner");
        props.setProperty("ner.applyNumericClassifiers", "false");
        props.setProperty("ner.useSUTime", "false");
        props.setProperty("ner.model", "../data/stanford/models/pt-ner-model-tolerance_1e-3.ser.gz");
    }

    public StanfordPT() {
        super(props);
        entityClasses.put("Organizacao", EntityClassMap.O);
        entityClasses.put("Localizacao", EntityClassMap.L);
        entityClasses.put("Pessoa", EntityClassMap.P);
        entityClasses.put("O", EntityClassMap.N);
    }

    public static void main(final String[] a) {
        LOG.info(new StanfordPT().retrieve(FoxConst.NER_PT_EXAMPLE_1));
    }
}
