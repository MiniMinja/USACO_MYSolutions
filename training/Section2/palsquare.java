/*
ID: Minyoung Heo
LANG: JAVA
TASK: palsquare
*/
import java.io.*;
import java.util.*;

public class palsquare{
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new FileReader("palsquare.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("palsquare.out"));

    int B = Integer.parseInt(in.readLine());
    for(int N = 1;N<=300;N++){
      String number = convertTo(N, B);
      int n2 = N*N;
      String number2 = convertTo(n2, B);
      if(number2.equals(reverse(number2))){
        pw.println(number+" "+number2);
      }
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
