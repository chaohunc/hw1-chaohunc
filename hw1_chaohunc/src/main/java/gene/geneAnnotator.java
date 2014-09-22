package gene;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import com.aliasi.*;
import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;
import com.aliasi.util.AbstractExternalizable;
public class geneAnnotator  extends JCasAnnotator_ImplBase{
   
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    String docText = aJCas.getDocumentText();
    //System.out.println(docText);        
    File modelFile = new File("ne-en-bio-genetag.HmmChunker");
    
    String[] str = docText.split("\n");
    int nowPos = 0;
    try {
      Chunker chunker = (Chunker) AbstractExternalizable.readObject(modelFile);
      for (int i=0;i<str.length;i++)
      {
        System.out.println(str[i]);        
        String id = str[i].substring(0, 14);
        String sentence = str[i].substring(15,str[i].length());
        Chunking chunking = chunker.chunk(sentence);
        System.out.println(chunking);
        
        for (Chunk ch:chunking.chunkSet())
        {
            GeneObj g = new GeneObj(aJCas);
            g.setBegin(nowPos+15+ch.start());
            g.setEnd(nowPos+15+ch.end());
            g.setPosStart(ch.start());
            g.setPosEnd(ch.end());
            g.setID(id);
            g.setConfidence(ch.score());
            g.setGeneName(sentence.substring(ch.start(),ch.end()));
            g.addToIndexes();
            System.out.print(str[i].substring(ch.start()+15, ch.end()+15)+" ");
        }
        System.out.println(" ");
        nowPos += str[i].length()+1;
        
      }
      
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    } catch (ClassNotFoundException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    
    /*
    try {
      PosTagNamedEntityRecognizer ptner = new  PosTagNamedEntityRecognizer();
      Map<Integer,Integer> map=ptner.getGeneSpans(docText);
      Set<Integer> keys= map.keySet();
      
      
      
      for (Integer key : keys)
      {
          GeneObj g = new GeneObj();
          g.setBegin(key);
          g.setEnd(map.get(key));
          g.addToIndexes();
         
          
      }
    
    } catch (ResourceInitializationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
*/
    
  }

}
