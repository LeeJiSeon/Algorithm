import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sol2750 {
  static int N;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = new int[N];

    for(int i = 0; i < N; i++)
      arr[i] = Integer.parseInt(br.readLine());

    quickSort(0, N-1);

    for(int i : arr)
      System.out.println(i);
  }

  private static void quickSort(int left, int right) {
    if(left >= right)   return;

    int pi = partition(left, right);

    quickSort(left, pi-1);
    quickSort(pi+1, right);
  }

  private static int partition(int left, int right) {
    int pivot = arr[left];
    int i = left, j = right;

    while(i < j) {
        while(j > left && pivot < arr[j])   j--;
        while(i < j && pivot >= arr[i])     i++;
        if(i < j)   swap(i, j);
    }
    swap(i, left);
    return i;
  }

  private static void swap(int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
