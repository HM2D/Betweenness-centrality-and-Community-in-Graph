
public class LinkedList {

    Node head;

    public LinkedList(Node Node1) {
        head = Node1;
    }

    public void append(Node Node1) {
        Node tmpNode = head;
        while (tmpNode.next != null) {
            tmpNode = tmpNode.next;
        }
        tmpNode.next = Node1;
    }
    public Node getHead(LinkedList L){
    	return L.head;
    }
    public void insert(Node Node1) {
        Node currentNode = head;
        Node nextNode = head.next;

        if (currentNode.num > Node1.num) {
            Node tmpNode = head;
            head = Node1;
            head.next = tmpNode;
            return;
        }

        if (nextNode != null && nextNode.num > Node1.num) {
            currentNode.next = Node1;
            currentNode.next.next = nextNode;
            return;
        }

        while (nextNode != null && nextNode.num < Node1.num) {
            currentNode = nextNode;
            nextNode = nextNode.next;
        }

        currentNode.next = Node1;
        currentNode.next.next = nextNode;
    }

    public void delete(int val) {
        Node prevNode = null;
        Node currNode = head;

        if (head.num == val) {
            head = head.next;
            return;
        }

        while (currNode != null && currNode.num != val) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        if (currNode == null) {
            System.out.println("A node with that value does not exist.");
        }
        else {
            prevNode.next = currNode.next;
        }
    }
    public Node  getNode(int val) {
        Node prevNode = null;
        Node currNode = head;

        while (currNode != null && currNode.num != val) {
            prevNode = currNode;
            currNode = currNode.next;
        }

        if (currNode == null) {
            //System.out.println("A node with that value does not exist.");
            return new Node(-1,-1);
        }
        else {
            return currNode;
        }
    }    
    public Node  getNodewithIndex(int val) {
        Node prevNode = null;
        Node currNode = head;
        int counter=0;
        while (currNode != null && counter<=val) {
            prevNode = currNode;
            currNode = currNode.next;
            counter++;
        }

        if (currNode == null) {
            System.out.println("A node with that value does not exist.");
            return currNode;
        }
        else {
            return currNode;
        }
    }
    public void print() {
        Node tmpNode = head;
        int max=0,nodenumber=0;
        while (tmpNode != null) {
        	if(tmpNode.shortestPathCount>max)
        	{	max = tmpNode.shortestPathCount;
        	   nodenumber = tmpNode.num;
        	}
        	//System.out.print(" Shortest path count: " + tmpNode.shortestPathCount +   " -> ");
        	System.out.print(tmpNode.num + " Max: " + max + " Nodenum: " + nodenumber);
            
            tmpNode = tmpNode.next;
        }
        
    }
    public void print2() {
        Node tmpNode = head;
        int max=0,nodenumber=0;
        System.out.println(tmpNode.num +" :  ");
        while (tmpNode != null) {
        	
        	System.out.print(" Num: " + tmpNode.num + "SPCount:" + tmpNode.shortestPathCount +    " -> ");
        	
            tmpNode = tmpNode.next;
        }
        System.out.println();
        
    }
    public int[] getMaxSP() {
        Node tmpNode = head;
        int[] node = new int[2];
        
        while (tmpNode != null) {
        	if(tmpNode.shortestPathCount>node[0])
        	{	node[0] = tmpNode.shortestPathCount;
        	    node[1] = tmpNode.num;
        	    
        	}
        	//System.out.print(" Shortest path count: " + tmpNode.shortestPathCount +   " -> ");
            
            tmpNode = tmpNode.next;
        }
        //System.out.print("Max: " + max + " Nodenum: " + nodenumber);
        return node;
    }
    
}
