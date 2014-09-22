package gene;
/* 
 *******************************************************************************************
 * N O T E :     The XML format (XCAS) that this Cas Consumer outputs, is eventually 
 *               being superceeded by the more standardized and compact XMI format.  However
 *               it is used currently as the expected form for remote services, and there is
 *               existing tooling for doing stand-alone component development and debugging 
 *               that uses this format to populate an initial CAS.  So it is not 
 *               deprecated yet;  it is also being kept for compatibility with older versions.
 *               
 *               New code should consider using the XmiWriterCasConsumer where possible,
 *               which uses the current XMI format for XML externalizations of the CAS
 *******************************************************************************************               
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.impl.XCASSerializer;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.examples.SourceDocumentInformation;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.XMLSerializer;
import org.apache.xml.serialize.TextSerializer;
import org.xml.sax.SAXException;

/**
 * A simple CAS consumer that generates XCAS (XML representation of the CAS) files in the
 * filesystem.
 * <p>
 * This CAS Consumer takes one parameters:
 * <ul>
 * <li><code>OutputDirectory</code> - path to directory into which output files will be written</li>
 * </ul>
 * 
 * 
 */
public class CopyOfgeneCASconsumer extends CasConsumer_ImplBase {
  /**
   * Name of configuration parameter that must be set to the path of a directory into which the
   * output files will be written.
   */
  public static final String PARAM_OUTPUTDIR = "OutputDirectory";

  private File mOutputDir;

  private int mDocNum;

  public void initialize() throws ResourceInitializationException {
    mDocNum = 0;
    mOutputDir = new File((String) getConfigParameterValue(PARAM_OUTPUTDIR));
    if (!mOutputDir.exists()) {
      mOutputDir.mkdirs();
    }
  }

  /**
   * Processes the CasContainer which was populated by the TextAnalysisEngines. <br>
   * In this case, the CAS is converted to XML and written into the output file .
   * 
   * @param aCAS
   *          CasContainer which has been populated by the TAEs
   * 
   * @throws ResourceProcessException
   *           if there is an error in processing the Resource
   * 
   * @see org.apache.uima.collection.base_cpm.CasObjectProcessor#processCas(org.apache.uima.cas.CAS)
   */
  public void processCas(CAS aCAS) throws ResourceProcessException {
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }

    // retrieve the filename of the input file from the CAS
    FSIterator it = jcas.getAnnotationIndex(SourceDocumentInformation.type).iterator();
    FSIterator<Annotation> iter = jcas.getAnnotationIndex(GeneObj.type).iterator();

    File outFile = null;
    BufferedWriter oFile2 = null;
    if (it.hasNext()) {
      SourceDocumentInformation fileLoc = (SourceDocumentInformation) it.next();
      File inFile;
      try {
        inFile = new File(new URL(fileLoc.getUri()).getPath());
        String outFileName = inFile.getName();
        if (fileLoc.getOffsetInSource() > 0) {
          outFileName += fileLoc.getOffsetInSource();
        }
        outFile = new File(mOutputDir, outFileName);
        oFile2 = new BufferedWriter(new FileWriter(new File (mOutputDir, new String("gene"+outFileName)).getAbsoluteFile()));
      } catch (MalformedURLException e1) {
        // invalid URL, use default processing below
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    int count = 0;
    while (iter.hasNext()) {

      GeneObj annotator = (GeneObj) iter.next();

      String output = annotator.getID() + "|" + annotator.getPosStart() + " "
              + annotator.getPosEnd() + "|" + annotator.getGeneName();
      System.out.println(annotator.getGeneName());
      try {
        oFile2.write(output);
        oFile2.newLine();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      count++;
    //  sortedAnnotations.put(annotator.getSortOrder(), output);

    }
    System.out.println("Count: " + count);
    try {
      oFile2.close();
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    //for (Map.Entry<Long, String> m : sortedAnnotations.entrySet()) {
    //}
    
   
    if (outFile == null) {
      outFile = new File(mOutputDir, "doc" + mDocNum++);
    }
    // serialize XCAS and write to output file
    try {
      writeXCas(jcas.getCas(), outFile);
    } catch (IOException e) {
      throw new ResourceProcessException(e);
    } catch (SAXException e) {
      throw new ResourceProcessException(e);
    }
  }

  /**
   * Serialize a CAS to a file in XCAS format
   * 
   * @param aCas
   *          CAS to serialize
   * @param name
   *          output file
   * 
   * @throws IOException
   *           if an I/O failure occurs
   * @throws SAXException
   *           if an error occurs generating the XML text
   */
  private void writeXCas(CAS aCas, File name) throws IOException, SAXException {
    FileOutputStream out = null;

    try {
      out = new FileOutputStream(name);
      XCASSerializer ser = new XCASSerializer(aCas.getTypeSystem());
      XMLSerializer xmlSer = new XMLSerializer(out, false);
      ser.serialize(aCas, xmlSer.getContentHandler());
    } finally {
      if (out != null) {
        out.close();
      }
    }
  }
}
