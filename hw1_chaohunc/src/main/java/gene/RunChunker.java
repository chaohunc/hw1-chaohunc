package gene;

import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;

import com.aliasi.util.AbstractExternalizable;

import java.io.File;

public class RunChunker {

  public static void main(String[] args) throws Exception {
    File modelFile = new File("ne-en-bio-genetag.HmmChunker");

    System.out.println("Reading chunker from file=" + modelFile);
    Chunker chunker = (Chunker) AbstractExternalizable.readObject(modelFile);
    Chunking chunking = chunker.chunk("P00001606T0076 Comparison with alkaline phosphatases and 5-nucleotidase.");
    System.out.println("Chunking=" + chunking);

    for (int i = 1; i < args.length; ++i) {
    }

  }

}