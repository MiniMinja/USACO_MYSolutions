public class simple{
  public static void main(String[] args){
    int x = 0b1101;
    System.out.println(Integer.toBinaryString(x));
    x >>= 4;
    System.out.println(Integer.toBinaryString(x));
  }
}
