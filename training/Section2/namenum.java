/*
ID: Minyoung Heo
LANG: JAVA
TASK: namenum
*/
import java.io.*;
import java.util.*;

public class namenum{
  public static HashMap<Character, ArrayList<Character>> letters = new HashMap<Character, ArrayList<Character>>();
  public static void main(String[] args) throws IOException{
    char c = 'A';
    for(int i = 0;i<8;i++){
      ArrayList<Character> toPutIn = new ArrayList<Character>(3);
      for(int j = 0;j<3;j++){
        if(c == 'Q' || c == 'Z') c++;
        toPutIn.add(c++);
      }
      letters.put((char)(i+'2'), toPutIn);
    }

    BufferedReader in = new BufferedReader(new FileReader("namenum.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("namenum.out"));

    HashSet<String> acceptableNames = new HashSet<String>();
    BufferedReader br = new BufferedReader(new FileReader("dict.txt"));
    for(String line = br.readLine();line != null;line = br.readLine()){
      acceptableNames.add(line);
    }

    String num = in.readLine();
    StringBuilder out = new StringBuilder();
    printCombo("", num, acceptableNames, out);
    if(out.length() == 0)
      pw.println("NONE");
    else
      pw.print(out);

    in.close();
    pw.close();
  }
  public static void printCombo(String combo, String num, HashSet<String> acceptableNames, StringBuilder pw){
    char c = num.charAt(0);
    ArrayList<Character> letterList = letters.get(c);
    if(num.length() == 1){
      for(int i = 0;i<letterList.size();i++){
        if(acceptableNames.contains(combo+letterList.get(i)))
          pw.append(combo+letterList.get(i)+'\n');
      }
    }
    else{
      for(int i = 0;i<letterList.size();i++){
        printCombo(combo+letterList.get(i), num.substring(1), acceptableNames, pw);
      }
    }
  }
}
