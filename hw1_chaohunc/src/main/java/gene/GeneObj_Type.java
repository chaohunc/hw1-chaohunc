
/* First created by JCasGen Sun Sep 21 16:52:23 EDT 2014 */
package gene;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Mon Sep 22 17:31:58 EDT 2014
 * @generated */
public class GeneObj_Type extends Annotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (GeneObj_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = GeneObj_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new GeneObj(addr, GeneObj_Type.this);
  			   GeneObj_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new GeneObj(addr, GeneObj_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = GeneObj.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("gene.GeneObj");



  /** @generated */
  final Feature casFeat_geneName;
  /** @generated */
  final int     casFeatCode_geneName;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getGeneName(int addr) {
        if (featOkTst && casFeat_geneName == null)
      jcas.throwFeatMissing("geneName", "gene.GeneObj");
    return ll_cas.ll_getStringValue(addr, casFeatCode_geneName);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setGeneName(int addr, String v) {
        if (featOkTst && casFeat_geneName == null)
      jcas.throwFeatMissing("geneName", "gene.GeneObj");
    ll_cas.ll_setStringValue(addr, casFeatCode_geneName, v);}
    
  
 
  /** @generated */
  final Feature casFeat_ID;
  /** @generated */
  final int     casFeatCode_ID;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getID(int addr) {
        if (featOkTst && casFeat_ID == null)
      jcas.throwFeatMissing("ID", "gene.GeneObj");
    return ll_cas.ll_getStringValue(addr, casFeatCode_ID);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setID(int addr, String v) {
        if (featOkTst && casFeat_ID == null)
      jcas.throwFeatMissing("ID", "gene.GeneObj");
    ll_cas.ll_setStringValue(addr, casFeatCode_ID, v);}
    
  
 
  /** @generated */
  final Feature casFeat_posStart;
  /** @generated */
  final int     casFeatCode_posStart;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getPosStart(int addr) {
        if (featOkTst && casFeat_posStart == null)
      jcas.throwFeatMissing("posStart", "gene.GeneObj");
    return ll_cas.ll_getIntValue(addr, casFeatCode_posStart);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPosStart(int addr, int v) {
        if (featOkTst && casFeat_posStart == null)
      jcas.throwFeatMissing("posStart", "gene.GeneObj");
    ll_cas.ll_setIntValue(addr, casFeatCode_posStart, v);}
    
  
 
  /** @generated */
  final Feature casFeat_posEnd;
  /** @generated */
  final int     casFeatCode_posEnd;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getPosEnd(int addr) {
        if (featOkTst && casFeat_posEnd == null)
      jcas.throwFeatMissing("posEnd", "gene.GeneObj");
    return ll_cas.ll_getIntValue(addr, casFeatCode_posEnd);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setPosEnd(int addr, int v) {
        if (featOkTst && casFeat_posEnd == null)
      jcas.throwFeatMissing("posEnd", "gene.GeneObj");
    ll_cas.ll_setIntValue(addr, casFeatCode_posEnd, v);}
    
  
 
  /** @generated */
  final Feature casFeat_confidence;
  /** @generated */
  final int     casFeatCode_confidence;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public double getConfidence(int addr) {
        if (featOkTst && casFeat_confidence == null)
      jcas.throwFeatMissing("confidence", "gene.GeneObj");
    return ll_cas.ll_getDoubleValue(addr, casFeatCode_confidence);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setConfidence(int addr, double v) {
        if (featOkTst && casFeat_confidence == null)
      jcas.throwFeatMissing("confidence", "gene.GeneObj");
    ll_cas.ll_setDoubleValue(addr, casFeatCode_confidence, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public GeneObj_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_geneName = jcas.getRequiredFeatureDE(casType, "geneName", "uima.cas.String", featOkTst);
    casFeatCode_geneName  = (null == casFeat_geneName) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_geneName).getCode();

 
    casFeat_ID = jcas.getRequiredFeatureDE(casType, "ID", "uima.cas.String", featOkTst);
    casFeatCode_ID  = (null == casFeat_ID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_ID).getCode();

 
    casFeat_posStart = jcas.getRequiredFeatureDE(casType, "posStart", "uima.cas.Integer", featOkTst);
    casFeatCode_posStart  = (null == casFeat_posStart) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_posStart).getCode();

 
    casFeat_posEnd = jcas.getRequiredFeatureDE(casType, "posEnd", "uima.cas.Integer", featOkTst);
    casFeatCode_posEnd  = (null == casFeat_posEnd) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_posEnd).getCode();

 
    casFeat_confidence = jcas.getRequiredFeatureDE(casType, "confidence", "uima.cas.Double", featOkTst);
    casFeatCode_confidence  = (null == casFeat_confidence) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_confidence).getCode();

  }
}



    