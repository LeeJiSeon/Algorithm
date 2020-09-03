# 크루스칼

* 최소 비용 신장 트리를 찾는 알고리즘 
* 가장 적은 비용으로 모든 노드를 연결하기 위해 사용하는 알고리즘
* 최소 스패닝 트리(MST, Minimum Spanning Tree)를 찾음으로서 간선의 가중치의 합이 최솟값이 되도록 하는 알고리즘  
   ▶ 스패닝 트리 : 그래프에서 일부 간선을 선택해서 만든 트리  
   ▶ 최소 스패닝 트리 : 스패닝 트리 중에 선택한 간선의 가중치의 합이 최소인 트리  
* 변의 개수 E(간선), 꼭짓점의 개수 V(노드)라고 하면 이 알고리즘은 O (E log V)의 시간복잡도를 가짐  

_1. 정점과 간선을 저장하기 위한 클래스를 선언한다._
```java
class Edge implements Comparable<Edge>{
        int v1, v2, cost;
        Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }
```

_2. find, union 함수를 구현한다_
```java
private int find(int v) {
        if(parent[v] == v)  return v;
        return parent[v] = find(parent[v]);
    }
    
    private void union(int v1, int v2) {
        int f1 = find(v1);
        int f2 = find(v2);
        if(f1 != f2)    parent[f2] = f1;
    }
```

_<전체코드>_
```java
import java.util.*;
class Solution {
    class Edge implements Comparable<Edge>{
        int v1, v2, cost;
        Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }
    int[] parent;
    PriorityQueue<Edge> adj;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        adj = new PriorityQueue<>();
        
        for(int[] cost : costs)
            adj.offer(new Edge(cost[0], cost[1], cost[2]));
        for(int i = 0 ; i < n ; i++)    parent[i] = i;
        
        while(!adj.isEmpty()) {
            Edge edge = adj.poll();
            if(find(edge.v1) != find(edge.v2)) {
                union(edge.v1, edge.v2);
                answer += edge.cost;
            }
        }
        return answer;
    }
    
    private int find(int v) {
        if(parent[v] == v)  return v;
        return parent[v] = find(parent[v]);
    }
    
    private void union(int v1, int v2) {
        int f1 = find(v1);
        int f2 = find(v2);
        if(f1 != f2)    parent[f2] = f1;
    }
}
```
