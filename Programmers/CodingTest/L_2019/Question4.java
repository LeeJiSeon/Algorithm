import java.util.*;
class Question4 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] seats = new int[sc.nextInt()];
    List<Integer> noempty = new ArrayList<>();
    List<Integer> dist = new ArrayList<>();

    for(int i = 0 ; i < seats.length ; i++) {
        seats[i] = sc.nextInt();
        if(seats[i] != 0)
            noempty.add(i);
    }

    for(int i = 0 ; i < noempty.size() ; i++) {
        if(i == 0) {
            if(noempty.get(i) != 0) {
                dist.add(noempty.get(i));
                continue;
            }
        }
        if(i == noempty.size() - 1) {
            if(noempty.get(i) != 0) {
                dist.add(seats.length - 1 - noempty.get(i));
            }
            break;
        }

        dist.add((noempty.get(i+1) - noempty.get(i)) / 2);
    }
    Collections.sort(dist);
    
    System.out.println(dist.get(dist.size() - 1));
  }  
}