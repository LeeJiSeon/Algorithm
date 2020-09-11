import java.util.*;

class RootGame {
    private int[] pre, post;
    int idx = 0;
    Node left, right;
    
    public int[][] solution(int[][] nodeinfo) { 
        pre = new int[nodeinfo.length];
        post = new int[nodeinfo.length];
        List<Node> list = new ArrayList<>();
        for(int i = 0 ; i < nodeinfo.length ; i++)
            list.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i+1));
        Collections.sort(list);
        
        Tree tree = new Tree(list.get(0));
        for(int i = 1 ; i < list.size() ; i++)
            tree.insert(list.get(i));
        
        preorder(tree.root);
        idx = 0;
        postorder(tree.root);
        
        return new int[][]{pre, post};
    }
    
    private void preorder(Node node) {
        if(node == null)    return;
        
        pre[idx++] = node.vertex;
        preorder(node.left);
        preorder(node.right);
    }
    
    private void postorder(Node node) {
        if(node == null)    return;
        postorder(node.left);
        postorder(node.right);
        post[idx++] = node.vertex;
    }
}

class Node implements Comparable<Node> {
    int x, y, vertex;
    Node left, right;
    
    Node(int x, int y, int vertex) {
        this.x = x;
        this.y = y;
        this.vertex = vertex;
    }

    @Override
    public int compareTo(Node n) {
        if(this.y == n.y)   return this.x - n.x;
        else    return n.y - this.y;
    }
}

class Tree {
    Node root;
    Tree(Node root) {
        this.root = root;
    }
    public void insert(Node node) {
        Node thisnode = root;
        while(true) {
            if(node.x < thisnode.x) {
                if(thisnode.left != null)   thisnode = thisnode.left;
                else {
                    thisnode.left = node;
                    break;
                }
            } else {
                if(thisnode.right != null)  thisnode = thisnode.right;
                else {
                    thisnode.right = node;
                    break;
                }            
            }
        }
    }
}
