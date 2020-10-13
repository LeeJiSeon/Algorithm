import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int x, y;
    
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Customer implements Comparable<Customer> {
    int dis = Integer.MAX_VALUE, dis2 = Integer.MAX_VALUE;
    Node dep, des;
    
    Customer(Node dep, Node des) {
        this.dep = dep;
        this.des = des;
    }
    
    @Override
    public int compareTo(Customer c) {
        if(this.dis == c.dis) {
           if(this.dep.x == c.dep.x) {
               return this.dep.y - c.dep.y;
           } else {
               return this.dep.x - c.dep.x;
           }
        } else {
            return this.dis - c.dis;
        }
    }
}

class Sol19238
{
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int N, M, fuel;
    static int[][] map;
    static Node taxi;
    static List<Customer> list;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
        
        map = new int[N+1][N+1];
        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N ; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        taxi = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        
        list = new ArrayList<Customer>();
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Customer(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())),
                                    new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))));
        }
        
        for(int i = 0 ; i < M ; i++) {
            PriorityQueue<Customer> pq = new PriorityQueue<>();
            if(!findCustomer(pq)) {
                System.out.println(-1);
                return;
            }
            Customer pick = pq.poll();
            list.remove(pick);
            
            if(!goDestination(pick)) {
                System.out.println(-1);
                return;
            }
            
            if(pick.dis2 + pick.dis > fuel) {
                System.out.println(-1);
                return;
            }
            
            taxi = new Node(pick.des.x, pick.des.y);
            fuel = fuel + pick.dis2 - pick.dis;
        }
		
		System.out.println(fuel);
		br.close();
	}
	
	private static boolean goDestination(Customer c) {
	    int depx = c.dep.x, depy = c.dep.y;
	    int desx = c.des.x, desy = c.des.y;
	    
	    int d = 1;
	    boolean[][] visited = new boolean[N+1][N+1];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(depx, depy));
        visited[depx][depy] = true;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int s = 0 ; s < size ; s++) {
                Node n = queue.poll();
                
                for(int i = 0 ; i < 4 ; i++) {
                    int nx = n.x + dx[i];
                    int ny = n.y + dy[i];
                    
                    if(nx <= 0 || nx > N || ny <= 0 || ny > N || map[nx][ny] == 1 || visited[nx][ny])
                        continue;
                        
                    if(nx == desx && ny == desy) {
                        c.dis2 = d;
                        return true;
                    }
                    
                    queue.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
            
            d++;
        }
        
        return false;
	}
	
	private static boolean findCustomer(PriorityQueue<Customer> pq) {
	    int[][] length = new int[N+1][N+1];
	    findDistance(length);
	    
	    for(Customer c : list) {
	        if(taxi.x == c.dep.x && taxi.y == c.dep.y) {
    	        c.dis = 0;
    	        pq.offer(c);
    	        continue;
    	    }
    	    if(length[c.dep.x][c.dep.y] == 0)
    	        return false;
    	    c.dis = length[c.dep.x][c.dep.y];
    	    pq.offer(c);
	    }
	    
	    return true;
	}
	
	private static boolean findDistance(int[][] length) {
	    int d = 1;
	    boolean[][] visited = new boolean[N+1][N+1];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(taxi.x, taxi.y));
        visited[taxi.x][taxi.y] = true;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int s = 0 ; s < size ; s++) {
                Node n = queue.poll();
                
                for(int i = 0 ; i < 4 ; i++) {
                    int nx = n.x + dx[i];
                    int ny = n.y + dy[i];
                    
                    if(nx <= 0 || nx > N || ny <= 0 || ny > N || map[nx][ny] == 1 || visited[nx][ny])
                        continue;
                    
                    queue.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                    length[nx][ny] = d;
                }
            }
            
            d++;
        }
        
        return false;
	}
}
