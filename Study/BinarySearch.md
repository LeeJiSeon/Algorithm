# 이분탐색

* 자바에서는 **_Arrays.binarySearch(배열, 값)_** 함수를 이용하여 이분탐색을 실행할 수 있다.

#### <**_Arrays.binarySerach()_** 함수 구현코드>
<pre>
<code>
public static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
		rangeCheck(a.length, fromIndex, toIndex);
		return binarySearch0(a, fromIndex, toIndex, key);
	}

// Like public version, but without range checks.
private static int binarySearch0(int[] a, int fromIndex, int toIndex, int key) {
  int low = fromIndex;
  int high = toIndex - 1;

  while (low <= high) {
    int mid = (low + high) >>> 1;
    int midVal = a[mid];

    if (midVal < key)
      low = mid + 1;
    else if (midVal > key)
      high = mid - 1;
    else
      return mid; // key found
  }
  return -(low + 1); // key not found.
}
</code>
</pre>
* 함수를 사용하지 않더라고 위와 같이 코드를 작성하면 이분탐색을 쉽게 구현할 수 있다.
