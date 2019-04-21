package org.aksw.fox.utils;

public class FoxConst {

    // spotlight
    public static final String CFG_KEY_SPOTLIGHT_URL        = "spotlight.url";
    public static final String CFG_KEY_SPOTLIGHT_CONFIDENCE = "spotlight.confidence";
    public static final String CFG_KEY_SPOTLIGHT_SUPPORT    = "spotlight.support";
    public static final String CFG_KEY_SPOTLIGHT_TYPES      = "spotlight.types";
    public static final String CFG_KEY_SPOTLIGHT_SPARQL     = "spotlight.sparql";

    public static String       NER_EN_EXAMPLE_1             = "The foundation of the University of Leipzig in 1409 initiated the city's development into a " +
                                                                    "centre of German law and the publishing industry, and towards being a location of the " +
                                                                    "Reichsgericht (High Court), and the German National Library (founded in 1912)." +
                                                                    " The philosopher and mathematician Gottfried Wilhelm Leibniz was born in Leipzig in 1646," +
                                                                    " and attended the university from 1661-1666.";

    public static String       NER_EN_EXAMPLE_2             =
                                                                    "Cologne German: Köln, Kölsch: Kölle is Germany's fourth-largest city (after Berlin, Hamburg, and Munich)" +
                                                                            "and is the largest city both in the German Federal State of North Rhine-Westphalia and within the Rhine-Ruhr Metropolitan Area, " +
                                                                            "one of the major European metropolitan areas with more than ten million inhabitants. " +
                                                                            "Cologne is located on both sides of the Rhine River. " +
                                                                            "The city's famous Cologne Cathedral (Kölner Dom) is the seat of the Catholic Archbishop of Cologne. " +
                                                                            "The University of Cologne (Universität zu Köln) is one of Europe's oldest and largest universities.";
    public static String       NER_EN_EXAMPLE_3             = "Berlin is an American New Wave band. Despite its name, Berlin did not have any known major connections " +
                                                                    "with Germany, but instead was formed in Los Angeles, California in 1978.";

    public static String       NER_GER_EXAMPLE_1            = "Nachdem infolge von Streitigkeiten an der (Karls-Universität Prag) im Zusammenhang mit der "
                                                                    + "Hussiten-Bewegung der böhmische König Wenzel IV.";

    public static String       NER_ES_EXAMPLE_1             = "Leipzig (en alemán estándar [ˈlaɪpʦɪç]) o Lipsia, en español, es una ciudad alemana en el noroeste del estado de Sajonia. " +
                                                                    "Con más de 520 000 habitantes1 a finales de 2012 es la segunda ciudad más poblada de ese estado federado (tras Dresde, " +
                                                                    "la capital de Sajonia) y tras Berlín, la tercera de todo el este de Alemania. Ya en el año 1165 recibió el derecho de " +
                                                                    "ciudad y de mercado (ahora recinto ferial). Desde entonces, Leipzig se convirtió en uno de los centros de comercio más " +
                                                                    "importantes de la Europa central. La ciudad tiene una larga tradición de recinto ferial y una de las ferias más antiguas (1190) de Europa. " +
                                                                    "Junto con Fráncfort del Meno es Leipzig el centro histórico de la imprenta y el comercio. Además, cuenta con una de las universidades " +
                                                                    "-tanto clásica como de música- más antiguas de Alemania. En las últimas décadas, Leipzig fue el centro de las manifestaciones de los " +
                                                                    "lunes (Montagsdemonstrationen) de 1989, las cuales dieron el impulso necesario a la reunificación alemana. La ciudad de Leipzig " +
                                                                    "tiene una gran tradición musical, la cual debe agradecer, entre otros, a Johann Sebastian Bach, Richard Wagner y Felix Mendelssohn. " +
                                                                    "La Orquesta de la Gewandhaus y el Coro de Santo Tomás han sólo engrandecido la fama de la ciudad en el mundo de la música. Leipzig es " +
                                                                    "la cuna de muchas personalidades famosas, tales como el filósofo y científico Gottfried Wilhelm Leibniz (1646), " +
                                                                    "el compositor Richard Wagner (1813), el historiador de arte Nikolaus Pevsner (1902), el tipógrafo Jan Tschichold (1902), " +
                                                                    "el pintor Max Beckmann o el socialista Karl Liebknecht (1871).";
    public static String       RE_EN_EXAMPLE_1              =
                                                                    "The philosopher and mathematician Gottfried Wilhelm Leibniz was born in Leipzig in 1646, and attended the university from 1661 to 1666. "
                                                                            + "Nobel Prize laureate Werner Heisenberg worked here as a physics professor (from 1927 to 1942), "
                                                                            + "as did Nobel Prize laureates Gustav Ludwig Hertz (physics), Wilhelm Ostwald (chemistry) and Theodor Mommsen (Nobel Prize in literature). ";
    public static String       NER_FR_EXAMPLE_1             = "La chancelière allemande Angela Merkel a salué dimanche à Moscou la mémoire des soldats soviétiques tués"
                                                                    + " lors de la Seconde guerre mondiale, appelant à la coopération avec la Russie sur fond de tensions à propos de l'Ukraine.";

    public static String       NER_FR_EXAMPLE_2             = "La ville de Berlin se situe dans le nord-est de l'Allemagne, dans la plaine germano-polonaise, "
                                                                    + "à 33 m d'altitude, au confluent de la Spree et de la Havel. "
                                                                    + "Une particularité de la ville est la présence de nombreux lacs et rivières, "
                                                                    + "le long des cours d'eau. On en trouve plusieurs à l'ouest, mais aussi à l'est avec le Müggelsee. "
                                                                    + "Berlin est égayée par plusieurs rivières, canaux, parcs et lacs (Havel, Wannsee, Müggelsee, Spree, Dahme, Landwehrkanal). "
                                                                    + "Elle possède en outre une architecture ancienne et classique très riche.";

    public static String       NER_NL_EXAMPLE_1             = "Momenteel wordt in de binnenstad van Leipzig een nieuwe campus voor de universiteit gebouwd, naar ontwerp van de Nederlandse architect Erick van Egeraat.";

    public static String       NER_NL_EXAMPLE_2             = "Het Wilhelmus is het Nederlandse volkslied. Het is inhoudelijk geschreven als een lied dat Willem van Oranje gezongen zou kunnen hebben, alhoewel er geen enkel bewijs is dat hij het daadwerkelijk gezongen heeft. Het Wilhelmus weerspiegelt Willem van Oranjes tweestrijd inzake de opstand in de Nederlanden. Enerzijds probeert hij trouw te zijn aan de Spaanse koning, anderzijds is hij boven alles trouw aan zijn geweten, dat hem voorschrijft God en het Nederlandse volk te dienen.";

    public static String       NER_IT_EXAMPLE_1             = "Barack Hussein Obama II (Honolulu, 4 agosto 1961) è un politico statunitense, 44º e attuale presidente degli Stati Uniti d'America. "
                                                                    + "Primo afroamericano a ricoprire la carica, Obama è stato senatore junior per lo Stato dell'Illinois dal gennaio 2005 al "
                                                                    + "novembre 2008, quando si è dimesso dopo la vittoria delle elezioni presidenziali statunitensi del 4 novembre 2008.";

public static String NER_PT_EXAMPLE_1 =
"A Residência de Würzburgo,[1] de Wurtzburgo ou de Vurzburgo (em alemão Würzburger Residenz) é um palácio da Alemanha localizado em Wurtzburgo (Würzburg), uma cidade situada na região administrativa da Baixa Francónia, estado da Baviera. Foi mandada construir pelo príncipe-bispo de Würzburg, Johann Philipp Franz von Schönborn, e pelo seu irmão Friedrich Carl von Schönborn, entre 1720 e 1744.\n"
        + "Foi desenhada por vários dos principais arquitectos do barroco. Lucas von Hildebrandt e Maximilian von Welsch, representantes de proa do barroco da Áustria/Sul da Alemanha, estiveram envolvidos na sua construção, assim como Robert de Cotte e Germain Boffrand, proeminentes arquitectos do estilo francês. Balthasar Neumann, arquitecto da corte do bispo de Würzburg, foi o principal arquitecto da residência.";

        public static String NER_PT_EXAMPLE_2 =
"Nascido em uma família de judeus alemães, mudou-se para a Suíça ainda jovem e iniciou seus estudos na Escola Politécnica de Zurique. Após dois anos procurando emprego, obteve um cargo no escritório de patentes suíço enquanto ingressava no curso de doutorado da Universidade de Zurique. Em 1905 publicou uma série de artigos acadêmicos revolucionários. Uma de suas obras era o desenvolvimento da teoria da relatividade especial. Percebeu, no entanto, que o princípio da relatividade também poderia ser estendido para campos gravitacionais, e com a sua posterior teoria da gravitação, de 1916, publicou um artigo sobre a teoria da relatividade geral. Enquanto acumulava cargos em universidades e instituições, continuou a lidar com problemas da mecânica estatística e teoria quântica, o que levou às suas explicações sobre a teoria das partículas e o movimento browniano. Também investigou as propriedades térmicas da luz, o que lançou as bases da teoria dos fótons. Em 1917, aplicou a teoria da relatividade geral para modelar a estrutura do universo como um todo. Suas obras renderam-lhe o status de celebridade mundial enquanto tornava-se uma nova figura na história da humanidade, recebendo prêmios internacionais e sendo convidado de chefes de estado e autoridades.\n"
        + "Estava nos Estados Unidos quando Adolf Hitler chegou ao poder na Alemanha, em 1933, e não voltou para o seu país de origem, onde tinha sido professor da Academia de Ciências de Berlim. Estabeleceu-se então no país, onde naturalizou-se em 1940. Na véspera da Segunda Guerra Mundial, ajudou a alertar o presidente Franklin Delano Roosevelt que a Alemanha poderia estar desenvolvendo uma arma atômica, recomendando aos norte-americanos a começar uma pesquisa semelhante, o que levou ao que se tornaria o Projeto Manhattan. Apoiou as forças aliadas, denunciando no entanto a utilização da fissão nuclear como uma arma. Mais tarde, com o filósofo britânico Bertrand Russell, assinou o Manifesto Russell-Einstein, que destacou o perigo das armas nucleares. Foi afiliado ao Instituto de Estudos Avançados de Princeton, onde trabalhou até sua morte em 1955.";
                                                        

}
