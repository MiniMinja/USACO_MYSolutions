/*
ID: Minyoung Heo
LANG: JAVA
TASK: dualpal
*/
import java.io.*;
import java.util.*;

public class dualpal{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new FileReader("dualpal.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("dualpal.out"));

    String line[] = in.readLine().split(" ");
    int N = Integer.parseInt(line[0]);
    int S = Integer.parseInt(line[1])+1;

    while(N > 0){
      int baseCount = 0;
      for(int base = 2;base<=10 && baseCount < 2;base++){
        String num = convertTo(S,base);
        if(num.equals(reverse(num)))
          baseCount++;
      }
      if(baseCount > 1){
        N--;
        pw.println(S);
      }
      S++;
    }

    in.close();
    pw.close();
  }

  public static String convertTo(int num, int b){
    StringBuilder ret = new StringBuilder();
    while(num > 0){
      if(num % b >= 10 && num % b < b){
        ret.append((char)(num%b-10+'A'));
      }
      else{
        ret.append(num%b);
      }
      num/=b;
    }
    return reverse(ret.toString());
  }
  public static String reverse(String str){
    StringBuilder ret = new StringBuilder(str.length());
    for(int i = str.length()-1;i>=0;i--){
      ret.append(str.charAt(i));
    }
    return ret.toString();
  }
}
