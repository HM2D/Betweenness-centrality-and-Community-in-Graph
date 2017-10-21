import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {

	public static void main(String[] args) {

		 String tmp;
		 String firstline;
		 //String[] Nodes = new String[391];
		 String[] splited = new String[3];
		 //Edge[] Edges = new Edge[391]; 
		 int[] Path = new int[300];

		 int EdgeCounter = 0;
		 int NodeCounter = 0;
		 
		 LinkedList[] L = new LinkedList[300];
		 for (int i = 0; i < L.length; i++) {
			 Node temp = new Node(i,0);
			L[i] = new LinkedList(temp);
		}
		 String fileName = "part3_300.txt";

		 String line = null;

		 try {
		 FileReader fileReader = new FileReader(fileName);

		 BufferedReader bufferedReader = new BufferedReader(fileReader);
		 
		 

		 firstline = bufferedReader.readLine();
		 String[] splitStrings = firstline.split(" ");
		 

		 while((line = bufferedReader.readLine()) != null) {
			 splited = line.split(" ");
        	 Node tempnode = new Node(Integer.parseInt(splited[1]), Float.parseFloat(splited[2]));
        	 //Edges[EdgeCounter++] = new Edge(L[NodeCounter].head,tempnode,0,Float.parseFloat(splited[2]));
    		 
         if(Integer.parseInt(splited[0]) == NodeCounter){
        	 L[NodeCounter].append(tempnode);
        	 
        	 
         }
         else
         {NodeCounter++;
         L[NodeCounter].append(tempnode);
    	 
         }

		 
		 } 

		 bufferedReader.close(); 
		 }
		 catch(FileNotFoundException ex) {
		 System.out.println(
		 "Unable to open file '" + 
		 fileName + "'"); 
		 }
		 catch(IOException ex) {
		 System.out.println(
		 "Error reading file '" 
		 + fileName + "'"); 
		 // Or we could just do this: 
		 // ex.printStackTrace();
		 }

		 System.out.println("Number of Edges:" +EdgeCounter);
		 System.out.println("Number of Nodes:" +(NodeCounter+1));
		 /////Print Adjacency List
		 /*for(int i=0;i<=NodeCounter;i++){
		  L[i].print();
		  System.out.println();
		 
		 }
		 ///Print Edges
		 /*for (int i = 0; i < Edges.length-1; i++) {
			Edges[i].print();
		}*/
		 
		 
		 
		 //////////////Show Nodes Edges
		/* for(int i= 0;i<Edges.length-1;i++){
			 
			 if(Edges[i].node1.num == 0)
			 System.out.println(Edges[i].node2.num);
			 
		 }*/
		 
		 long startTime = System.nanoTime();
		 dijkstra(L,NodeCounter);
		 long endTime = System.nanoTime();
       int betweennes= 0;
       int Snode=0,Dnode=0;
		for (int j = 0; j < L.length; j++) {
			int[] tmp1 = L[j].getMaxSP();
			if(tmp1[0]>betweennes){
				betweennes = tmp1[0];
				Snode = j;
				Dnode = tmp1[1]; 
			}
		   
}
		 System.out.println("Destination Node: " + Dnode + " SourceNode: " + Snode + " Betweennes:" + betweennes);

		 System.out.println("Took "+(endTime - startTime)/1000000 + " ms");
		 
		 }
	
	public static void dijkstra(LinkedList[] L,int NodeCounter){
		Node EndNode = new Node(-1,-1);
		int temp = -1;
		for (int i = 0; i < L.length; i++) {
			   L[i].head.distance = 0;
			   MinHeap MH = new MinHeap(NodeCounter+1,EndNode);
			   MH.insert(L[i].head);
			   //System.out.println("Head:" + MH.Heap[0].distance);
			   for (int j = 0; j < L.length; j++) {
				if(j!=i){
					 L[j].head.distance = 9999999;
					 	MH.insert(L[j].head);
			       }
				
			}
			   
			 
		       while(true){
		    	   
		    	  Node u = MH.remove(); //Extract Min
		    	  //System.out.println(temp);
		    	  if(u.num==-1){
		    		  break;
		    	  }
		    	  if(temp != -1 && u.Parent != -1){
		    	    //System.out.println("U.parent: " + u.Parent + " U.num: " + u.num);
		    		  Node tmp2 = u;
		    		  for (int j = 0; j < L.length; j++) {
		    			  if(L[tmp2.Parent].head.distance != 0){
			    		  L[tmp2.Parent].getNode(tmp2.num).shortestPathCount++;
			    		  tmp2 = L[tmp2.Parent].head;
			    		  }
		    			  else{
				    		  L[tmp2.Parent].getNode(tmp2.num).shortestPathCount++;
				    		  break;
			    		  }
					}
		    	  }
		    	  //System.out.println("Unum" + u.num);
		    	  
		    	  
		    	  Node tmpNode = L[u.num].head.next;
		    	  Node headNode = L[u.num].head;
		    	  
		    	  
		    	 // System.out.println("headNode" + headNode.distance);
		    	  while(tmpNode!= null){
		    		  if(L[tmpNode.num].head.distance > headNode.distance + tmpNode.edge )
		    		  {
		    			  L[tmpNode.num].head.distance = headNode.distance + tmpNode.edge;
		    			  L[tmpNode.num].head.Parent = headNode.num;
		    		     tmpNode = tmpNode.next;
		    		  }else tmpNode =tmpNode.next;
		    		  
		    		  
		    	  }
		    	   MH.minHeap();
		    	   temp = 1;
		       }
		       for (int j = 0; j < L.length; j++) {
				L[j].head.Parent=-1;
			}
		       temp  = -1;
		       
		}

		
	}
		 }