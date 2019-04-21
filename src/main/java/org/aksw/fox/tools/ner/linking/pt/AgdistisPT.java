package org.aksw.fox.tools.linking.pt;

import org.aksw.fox.tools.linking.common.Agdistis;
import org.aksw.fox.utils.CfgManager;

/**
 * This class uses the Agdistis web service.
 *
 * @author Ren&eacute; Speck <speck@informatik.uni-leipzig.de>
 *
 */
public class AgdistisPT extends Agdistis {
  public AgdistisPT() {
    super(CfgManager.getCfg(AgdistisPT.class));
  }
}
