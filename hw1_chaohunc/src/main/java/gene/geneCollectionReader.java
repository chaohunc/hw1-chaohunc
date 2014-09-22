package gene;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.util.Progress;

/**
 * This class represents a Collection Reader in the CPE pipeline.
 * 
 * 
 */
public class geneCollectionReader extends CollectionReader_ImplBase {

  public static boolean hasNextfile = true;
  public static String inputFile = "";
  /**
   * This variable holds the input file.
   */
  public BufferedReader readfile;

  public void getNext(CAS aCAS) throws IOException, CollectionException {
    StringBuilder totstr = new StringBuilder();
   String str;
    JCas jcas = null;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      e.printStackTrace();
    }
    System.out.println("hi");
    try {

      readfile = new BufferedReader(new FileReader((String) getConfigParameterValue("InputFile")));
      while ((str= readfile.readLine())!=null) {
        totstr.append(str);
        totstr.append("\n");
        System.out.println(str);
      }

      //Store the text from the file in the CAS
      jcas.setDocumentText(totstr.toString());
      hasNextfile=false;
      readfile.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }


  public Progress[] getProgress() {
    return null;
  }


  @Override
  public void close() throws IOException {
    // TODO Auto-generated method stub
    
  }


  @Override
  public boolean hasNext() throws IOException, CollectionException {
    // TODO Auto-generated method stub
    return hasNextfile;
  }


}