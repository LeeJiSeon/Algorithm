# 다익스트라 Dijkstra

## 1. _인접리스트_ 를 통한 다익스트라 알고리즘 구현

1) 도착 정점과 가중치를 저장하는 클래스를 선언한다.

```java
class Node implements Comparable<Node> {
    int end, weight;
    Node(int end, int weight) {
      this.end = end;
      this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
      return weight - o.weight;
    }
}
```

2) 두 정점 사이의 간선을 저장하기 위한 리스트 배열과 최단경로를 저장하기 위한 배열을 선언한다.

```java
 List<Node>[] adj = new ArrayList[N+1];
 int[] dist = new int[N+1];
 Arrays.fill(dist, Integer.MAX_VALUE); //배열 값을 최대로 초기화
```
 
3) 간선들을 선언한 리스트에 추가한다
> 방향이 있을 때는 단방향, 방향이 없을 때는 양방향을 저장해야 한다.
 
```java
 for(int[] edge : road) {
    adj[edge[0]].add(new Node(edge[1], edge[2]));
    adj[edge[1]].add(new Node(edge[0], edge[2]));
}
```

4) 최단 경로를 찾는 함수를 구현한다.

```java
private void dijkstra(int start) {
    PriorityQueue<Node> queue = new PriorityQueue<>();
    dist[start] = 0;
    queue.offer(new Node(start, 0));

    while(!queue.isEmpty()) {
        Node node = queue.poll();
        for(Node n : adj[node.end]) {
            if(dist[n.end] > dist[node.end] + n.weight) {
                dist[n.end] = dist[node.end] + n.weight;
                queue.offer(n);
            }
        }
    }
}
```
