import java.util.*;
import java.io.*;

public class guess{
  public static ArrayList<String> animals;
  public static HashMap<String, Set<String>> data;
  public static int[][] likenessFactor;
  public static int N;

  public static int findIntersectSize(Set<String> a, Set<String> b){
    int ret = 0;
    Iterator<String> iter = a.iterator();
    while(iter.hasNext())
      if(b.contains(iter.next())) ret++;
    return ret;
  }

  public static int findLikenessFactor(int i, int j){
    return findIntersectSize(data.get(animals.get(i)), data.get(animals.get(j)));
  }

  public static int solve(){
    int max = 0;
    for(int i = 0;i<N-1;i++){
      for(int j = i+1;j<N;j++){
        max = Math.max(findLikenessFactor(i, j), max);
      }
    }
    return max + 1;
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new FileReader("guess.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("guess.out"));
    N = Integer.parseInt(br.readLine());
    data = new HashMap<String, Set<String>>();
    animals = new ArrayList<String>();
    likenessFactor = new int[N][];
    for(int i = 0;i<N;i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      String animal = st.nextToken();
      int K = Integer.parseInt(st.nextToken());
      Set<String> toAdd = new HashSet<String>();
      animals.add(animal);
      for(int j = 0;j<K;j++){
        toAdd.add(st.nextToken());
      }
      data.put(animal, toAdd);
      likenessFactor[i] = new int[N-i-1];
    }
    pw.println(solve());
    br.close();
    pw.close();
  }
}
