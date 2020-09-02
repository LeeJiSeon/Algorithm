# 이분탐색

* 자바에서는 **_Arrays.binarySearch(배열, 값)_** 함수를 이용하여 이분탐색을 실행할 수 있다.

#### <**_Arrays.binarySerach()_** 함수 구현코드>
```java
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
```
* a의 원소 중 key가 존재하면 그 원소의 인덱스를 (0 또는 양수), 존재하지 않는다면 음수를 반환한다.

* 함수를 사용하지 않더라고 위와 같이 코드를 작성하면 이분탐색을 쉽게 구현할 수 있다.
