package gene;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Measurement {
    HashMap<String,Integer> map = new HashMap();
    Measurement() throws IOException
    {
      InputStream in = this.getClass().getClassLoader().getResourceAsStream("main/resources/data/sample.out");
      BufferedReader reader = new BufferedReader(new InputStreamReader(in));
      String str;
      while ((str = reader.readLine())!=null)
      {
          String[] token = str.split("\\|");
          String[] cS = token[1].split(" ");
          map.put(new String(token[0]+" "+token[2]), 1);
          System.out.println(token[0]+" "+ cS[0] +" "+token[2]);
          
         // System.exit(1);
          //Scanner rr = new Scanner(System.in);
      }
    }
}
