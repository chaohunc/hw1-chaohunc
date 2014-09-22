

/* First created by JCasGen Sun Sep 21 16:52:23 EDT 2014 */
package gene;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.tutorial.RoomNumber_Type;


/** 
 * Updated by JCasGen Mon Sep 22 17:31:58 EDT 2014
 * XML source: /Users/chaohunc/Documents/workspace/hw1_chaohunc/src/main/resources/geneDescriptor.xml
 * @generated */
public class GeneObj extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(GeneObj.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected GeneObj() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public GeneObj(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public GeneObj(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public GeneObj(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
  public String getGeneName() {
    if (GeneObj_Type.featOkTst && ((GeneObj_Type)jcasType).casFeat_geneName == null)
      jcasType.jcas.throwFeatMissing("GeneName", "geneObj");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeneObj_Type)jcasType).casFeatCode_geneName);}
    
  /** setter for geneName - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setGeneName(String v) {
    if (GeneObj_Type.featOkTst && ((GeneObj_Type)jcasType).casFeat_geneName == null)
      jcasType.jcas.throwFeatMissing("geneName", "gene.GeneObj");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeneObj_Type)jcasType).casFeatCode_geneName, v);}    
   
    
  //*--------------*
  //* Feature: ID

  /** getter for ID - gets 
   * @generated
   * @return value of the feature 
   */
  public String getID() {
    if (GeneObj_Type.featOkTst && ((GeneObj_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "gene.GeneObj");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeneObj_Type)jcasType).casFeatCode_ID);}
    
  /** setter for ID - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setID(String v) {
    if (GeneObj_Type.featOkTst && ((GeneObj_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "gene.GeneObj");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeneObj_Type)jcasType).casFeatCode_ID, v);}    
   
    
  //*--------------*
  //* Feature: posStart

  /** getter for posStart - gets 
   * @generated
   * @return value of the feature 
   */
  public int getPosStart() {
    if (GeneObj_Type.featOkTst && ((GeneObj_Type)jcasType).casFeat_posStart == null)
      jcasType.jcas.throwFeatMissing("posStart", "gene.GeneObj");
    return jcasType.ll_cas.ll_getIntValue(addr, ((GeneObj_Type)jcasType).casFeatCode_posStart);}
    
  /** setter for posStart - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setPosStart(int v) {
    if (GeneObj_Type.featOkTst && ((GeneObj_Type)jcasType).casFeat_posStart == null)
      jcasType.jcas.throwFeatMissing("posStart", "gene.GeneObj");
    jcasType.ll_cas.ll_setIntValue(addr, ((GeneObj_Type)jcasType).casFeatCode_posStart, v);}    
   
    
  //*--------------*
  //* Feature: posEnd

  /** getter for posEnd - gets 
   * @generated
   * @return value of the feature 
   */
  public int getPosEnd() {
    if (GeneObj_Type.featOkTst && ((GeneObj_Type)jcasType).casFeat_posEnd == null)
      jcasType.jcas.throwFeatMissing("posEnd", "gene.GeneObj");
    return jcasType.ll_cas.ll_getIntValue(addr, ((GeneObj_Type)jcasType).casFeatCode_posEnd);}
    
  /** setter for posEnd - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setPosEnd(int v) {
    if (GeneObj_Type.featOkTst && ((GeneObj_Type)jcasType).casFeat_posEnd == null)
      jcasType.jcas.throwFeatMissing("posEnd", "gene.GeneObj");
    jcasType.ll_cas.ll_setIntValue(addr, ((GeneObj_Type)jcasType).casFeatCode_posEnd, v);}    
   
    
  //*--------------*
  //* Feature: confidence

  /** getter for confidence - gets 
   * @generated
   * @return value of the feature 
   */
  public double getConfidence() {
    if (GeneObj_Type.featOkTst && ((GeneObj_Type)jcasType).casFeat_confidence == null)
      jcasType.jcas.throwFeatMissing("confidence", "gene.GeneObj");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((GeneObj_Type)jcasType).casFeatCode_confidence);}
    
  /** setter for confidence - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setConfidence(double v) {
    if (GeneObj_Type.featOkTst && ((GeneObj_Type)jcasType).casFeat_confidence == null)
      jcasType.jcas.throwFeatMissing("confidence", "gene.GeneObj");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((GeneObj_Type)jcasType).casFeatCode_confidence, v);}    
  }

    