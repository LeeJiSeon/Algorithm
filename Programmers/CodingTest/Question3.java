//Line
import java.util.*;

class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] pair = new int[sc.nextInt()][2];
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < pair.length ; i++)
            for(int j = 0 ; j < pair[i].length ; j++)
                pair[i][j] = sc.nextInt();
        
        Arrays.sort(pair, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // if(o1[0] == o2[0])  return Integer.compare(o1[1], o2[1]);
                // else    
                return Integer.compare(o1[0], o2[0]);
            }
        });
 
        for(int i = 0 ; i < pair.length ; i++) {
            if(i == 0)
                list.add(pair[i][1]);
            else {
                Collections.sort(list);
                if(list.get(list.size() - 1) > pair[i][0])
                    list.add(pair[i][1]);
                else{
                    for(int j = 0 ; j < list.size() ; j++) {
                        list.set(j, pair[i][1]);
                    }
            }
            }
            
        }
        System.out.println(list.size());
    }
}