package org.aksw.fox.tools.ner.pt;

import org.aksw.fox.data.EntityClassMap;
import org.aksw.fox.tools.ner.common.OpenNLPCommon;
import org.aksw.fox.utils.FoxConst;

public class OpenNLPPT extends OpenNLPCommon {

    static final String[] modelPath = {"data/openNLP/pt-ner.bin"};

    public OpenNLPPT() {
        super(modelPath);
        entityClasses.put("Organizacao", EntityClassMap.O);
        entityClasses.put("Localizacao", EntityClassMap.L);
        entityClasses.put("Pessoa", EntityClassMap.P);
        entityClasses.put("O", EntityClassMap.N);
    }

    public static void main(final String[] a) {
        LOG.info(new OpenNLPPT().retrieve(FoxConst.NER_PT_EXAMPLE_2));
    }
}