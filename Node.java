class Node {
    Node next;
    int num;
    float distance;
    float edge;
    int Parent;
    int shortestPathCount;
    public Node(int val,float val2) {
        num = val;
        edge = val2;
        next = null;
        this.shortestPathCount=0;
        
    }
}
