
public class Edge {

     Node node1, node2;
     int distance;
     float weight;

    public Edge (Node node1, Node node2, int distance,float val) {
        this.node1 = node1;
        this.node2 = node2;
        this.distance = distance;
        this.weight = val;
    }

    public Node getAdjacentNode (Node node) {
        return node.num != node1.num ? node1 : node2; 
    }

    public int getDistance() {
        return distance;
    }

    public void print() {
       System.out.println("Node1:" + node1.num + " Node2:" + node2.num + " Weight:" + this.weight);
    }
    

}
