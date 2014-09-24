package gene;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;


import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;
import com.aliasi.chunk.ConfidenceChunker;
import com.aliasi.util.AbstractExternalizable;

public class geneAnnotator extends JCasAnnotator_ImplBase {

  private static final double confidenceThreshold = 0.6;

  @Override
  /**
   * Processes the CAS which was populated by the CollectionReader. <br>
   * Used the training model to predict the geneTag
   * 
   * 
   * @param JCAS
   *          aJCAS which has been processed by the CollectionReader
   * 
   * @throws AnalysisEngineProcessException
   */
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    String docText = aJCas.getDocumentText();
    // System.out.println(docText);
    // File modelFile = new File("ne-en-bio-genetag.HmmChunker");

    InputStream in = this.getClass().getClassLoader()
            .getResourceAsStream("src/main/resources/models/ne-en-bio-genetag.HmmChunker");
    ObjectInputStream objIn = null;
    try {
      objIn = new ObjectInputStream(in);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    String[] str = docText.split("\n");
    int nowPos = 0;
    double[] hit = new double[10];
    double[] miss = new double[10];
    for (int i = 0; i < 10; i++) {
      hit[i] = 0;
      miss[i] = 0;
    }
    Measurement m = null;
    try {
      m = new Measurement();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      ConfidenceChunker chunker = (ConfidenceChunker) objIn.readObject();
      for (int i = 0; i < str.length; i++) {
        System.out.println(str[i]);
        String id = str[i].substring(0, 14);
        String sentence = str[i].substring(15, str[i].length());
        Iterator<Chunk> chunking = chunker.nBestChunks(sentence.toCharArray(), 0,
                sentence.length(), 5);
        System.out.println(chunking);

        for (int n = 0; chunking.hasNext(); ++n) {
          Chunk ch = chunking.next();
          double tempScore = Math.pow(2, ch.score());
          System.out.println(ch.score());

          double nowConf = 0;
          for (int j = 0; j < 10; j++) {
            if (tempScore > nowConf) {
              if (m.map.containsKey(id + " " + sentence.substring(ch.start(), ch.end())))
                hit[j]++;
              else
                miss[j]++;
            }
            nowConf += 0.1;

          }
          if (tempScore > confidenceThreshold) {
            GeneObj g = new GeneObj(aJCas);
            g.setBegin(nowPos + 15 + ch.start());
            g.setEnd(nowPos + 15 + ch.end());
            g.setPosStart(ch.start());
            g.setPosEnd(ch.end());
            g.setID(id);
            g.setConfidence(tempScore);
            g.setGeneName(sentence.substring(ch.start(), ch.end()));
            g.addToIndexes();
            System.out.print(str[i].substring(ch.start() + 15, ch.end() + 15) + " ");
          }
        }
        System.out.println(" ");
        nowPos += str[i].length() + 1;

      }

      // used to output the experiment result
      for (int j = 0; j < 10; j++) {
        System.out.println("0." + j);
        Double d = hit[j] / (m.map.size());
        Double d2 = hit[j] / (hit[j] + miss[j]);
        Double f1 = 2 * d * d2 / (d + d2);
        System.out.println("hit" + hit[j]);
        System.out.println("miss" + miss[j]);
        System.out.println("F1" + f1);
        System.out.println("Recall" + d);
        System.out.println("Precision" + d2);
        System.out.println(f1);
        System.out.println(d2);
        System.out.println(d);
      }
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    } catch (ClassNotFoundException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

  }

}
