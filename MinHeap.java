public class MinHeap

    {

        Node[] Heap;

         int size;

        private int maxsize;

     

        static final int FRONT = 1;

     

        public MinHeap(int maxsize, Node N)

        {

            this.maxsize = maxsize;

            this.size = 0;

            Heap = new Node[this.maxsize + 1];

            Heap[0] =  N;

        }

     

        private int parent(int pos)

        {

            return pos / 2;

        }

     

        private int leftChild(int pos)

        {

            return (2 * pos);

        }

     

        private int rightChild(int pos)

        {

            return (2 * pos) + 1;

        }

     

        private boolean isLeaf(int pos)

        {

            if (pos >=  (size / 2)  &&  pos <= size)

            { 

                return true;

            }

            return false;

        }

     

        private void swap(int fpos, int spos)

        {

            Node tmp;

            tmp = Heap[fpos];

            Heap[fpos] = Heap[spos];

            Heap[spos] = tmp;

        }

     

        private void minHeapify(int pos)

        {

            if (!isLeaf(pos))

            { 

                if ( Heap[pos].distance > Heap[leftChild(pos)].distance  || Heap[pos].distance > Heap[rightChild(pos)].distance)

                {

                    if (Heap[leftChild(pos)].distance < Heap[rightChild(pos)].distance)

                    {

                        swap(pos, leftChild(pos));

                        minHeapify(leftChild(pos));

                    }else

                    {

                        swap(pos, rightChild(pos));

                        minHeapify(rightChild(pos));

                    }

                }

            }

        }

     

        public void insert(Node element)

        {

            Heap[++size] = element;

            int current = size;

     

            while (Heap[current].distance < Heap[parent(current)].distance)

            {

                swap(current,parent(current));

                current = parent(current);

            }	

        }

     

        public void print()

        {

            for (int i = 1; i <= size / 2; i++ )

            {

                System.out.print(" PARENT : " + Heap[i].num + " LEFT CHILD : " + Heap[2*i].num 

                    + " RIGHT CHILD :" + Heap[2 * i  + 1]);

                System.out.println();

            } 

        }

     

        public void minHeap()

        {

            for (int pos = (size / 2); pos >= 1 ; pos--)

            {

                minHeapify(pos);

            }

        }

     

        public Node remove()

        {

            Node popped = Heap[FRONT];
          if(size==1){
        	  Node n = new Node(-1,-1);
        	  return n;
          }else Heap[FRONT] = Heap[size--]; 

            minHeapify(FRONT);
           
            return popped;

        }

     

       

    }
