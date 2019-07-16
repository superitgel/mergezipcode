import java.util.LinkedList;
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    int[][] zip = {{94133,94133}, {94200,94299}, {94600,94699}};
    int[][] zip2 = {{94133,94133}, {94200,94299}, {94226,94399}};

    
    System.out.println(Arrays.deepToString(Util.merge(zip)));
    System.out.println(Arrays.deepToString(Util.merge(zip2)));
  }
}

class Util {
  /**
  * Will return new merged array
  */
  public static int[][] merge(int[][] ranges) {
        if (ranges.length <= 1) {
          return ranges.clone();
        }
        Arrays.sort(ranges, (a,b) -> a[0] - b[0]);

        LinkedList<int[]> res = new LinkedList<int[]>();
        int[] prev = ranges[0];
        for(int i = 1; i < ranges.length; i++){
            if(prev[1] >= ranges[i][0]) {
                prev = new int[] { prev[0], Math.max(prev[1], ranges[i][1]) };
            } else {
                res.add(prev);
                prev = ranges[i];
            }   
        }
        res.add(prev);
        return res.toArray(new int[res.size()][]);
    }
}
