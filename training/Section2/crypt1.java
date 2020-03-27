/*
ID: Minyoung Heo
LANG: JAVA
TASK: crypt1
*/
import java.io.*;
import java.util.*;

public class crypt1{

  //public static PrintWriter pw2;

  public static int N;
  public static int[] digits;

  static class combinator{
    int[] num;
    int base;
    int[] arr;
    boolean hasNext;
    combinator(int base, int digits, int[] arr){
      num = new int[digits];
      this.base = base;
      this.arr = arr;
      hasNext = true;
    }

    void tick(){
      int i = 0;
      while(i < num.length && num[i] + 1 >= base){
        num[i] = 0;
        i++;
      }
      if(i < num.length){
        num[i]++;
      }
      else
        hasNext = false;
    }

    boolean hasNext(){
      return hasNext;
    }

    int getNum(){
      int ret = 0;
      for(int i =num.length-1;i>=0;i--){
        ret += arr[num[i]];
        ret*=10;
      }
      return ret/10;
    }

    public String toString(){
      return "num: "+getNum()+" base: " + base + " arr: "+Arrays.toString(arr);
    }
  }

  public static int solve(){
    combinator c = new combinator(N, 5, digits);
    //System.out.println(c);
    int count = 0;
    do{
      int num = c.getNum();
      int num1 = num / 100;
      int num2 = num % 100;
      int ones = num2 % 10;
      int tens = num2 / 10;
      int a = num1 * ones;
      int b = num1 * tens;
      int p = num1 * num2;
      if(matches(digits, a) && matchesSize(a, 3)){
        if(matches(digits, b) && matchesSize(b, 3)){
          if(matches(digits, p) && matchesSize(p, 4)){
            //pw2.println(c);
            //pw2.println(num1 + " * " + num2 + " = " + a + (matchesSize(a, 3) ? " ":"") + " + " + b + (matchesSize(b, 3) ? " ":"") + " = " + num1 * num2);
            count++;
          }
        }
      }
      c.tick();
    }while(c.hasNext());
    return count;
  }

  public static void main(String[] args) throws IOException{
    //pw2 = new PrintWriter(new FileWriter("output.out"));
    BufferedReader in = new BufferedReader(new FileReader("crypt1.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("crypt1.out"));

    N = Integer.parseInt(in.readLine());
    String[] line = in.readLine().split(" ");
    digits = new int[N];
    for(int i = 0;i<N;i++){
      digits[i] = Integer.parseInt(line[i]);
    }

    pw.println(solve());
    in.close();
    pw.close();
    //pw2.close();
  }
  public static boolean matches(int[] nums, int a){
    while(a > 0){
      if(!contains(digits, a%10)){
        return false;
      }
      a/=10;
    }
    return true;
  }
  public static boolean contains(int[] nums, int a){
    for(int i = 0;i<nums.length;i++){
      if(nums[i] == a) return true;
    }
    return false;
  }

  public static boolean matchesSize(int a, int size){
    return (int)Math.log10(a) + 1 <= size;
  }
}
