package cracking;

public class BinaryTree {
	int temp;
	int cnt=0;
		 public enum State{
		  Visited, Unvisited,Visiting;
		   
		 }
		 //this is the Node used in the tree
		    static class Node{
		        private int data;
		        private Node left;
		        private Node right;
		        public Node(int data){
		            this.data = data;
		            left = null;
		            right = null;
		        }
		        public void setLeft(Node left){
		            this.left = left;
		        }
		        public void setRight(Node right){
		            this.right = right;
		        }
		        public Node getLeft(){
		            return this.left;
		        }       
		        public Node getRight(){
		            return this.right;
		        }
		        public int getData(){
		            return this.data;
		        }
		        public boolean equals(Node n){
		            if(this.data ==(int) n.getData()) return true;
		            else
		                return false;
		        }
		    }
		    
		    public int previousElement(Node root,int item){
		    	if(root==null){
		    		return 0;
		    	}
		    	
		    	while(root != null){
		    		if(root.getData() > item){
		    			temp=root.getData();
		    			root=root.getLeft();

		    		}else if(root.getData() < item){
		    			root=root.getRight();
		    		}else{
		    			break;
		    		}
		    	}
		    	return temp;
		    }
		    
		    Node lca(Node root, int n1, int n2)
		    {
		        while (root!=null)
		        {
		             // If both n1 and n2 are smaller than root, then LCA lies in left
		            if (root.getData() > n1 && root.getData() > n2)
		               root = root.getRight();
		     
		            // If both n1 and n2 are greater than root, then LCA lies in right
		            else if (root.getData() < n1 && root.getData() < n2)
		               root = root.getRight();
		            else break;
		        }
		        return root;
		    }
		    public static void main(String[] args){
		        BinaryTree bts = new BinaryTree();
		        bts.run();
		        //bts.previousElement();
		    }
		    //execute the test case
		    public void run(){
		    	int item =5;
		        Node root = new Node(10);
		        insert(root,new Node(20));
		        insert(root,new Node(5));
		        insert(root,new Node(4));
		        insert(root,new Node(7));
		        insert(root,new Node(3));
		        insert(root,new Node(6));
		        insert(root,new Node(15));
		        insert(root,new Node(21));
		        insert(root,new Node(14));
		        insert(root,new Node(17));
		        previousElement(root,item);
		        System.out.println("Item is"+temp);
		        System.out.println(""+root.getData());
		        inOrderTraverse(root);
		        Node res=lca(root,4,17);
		        System.out.println("\n" + binarySearch(root,new Node(10)));
		        System.out.println("\nleast Common ancestor" + res.getData());
		    }
		     
		    // insert a node to the binary search tree
		    public void insert(Node root, Node n){
		        if(root == null|| n == null) return;
		         
		        if(root.getData() > n.getData()){
		            if(root.getLeft() == null){
		                root.setLeft(n);
		                 System.out.println("Added node to left of "+root.getData()+" of value "+n.getData());           
		            }else{
		                insert(root.getLeft(),n);
		            }
		 
		        }else if(root.getData() < n.getData()){
		            if(root.getRight() == null){
		                root.setRight(n);
		                System.out.println("Added node to Right of "+root.getData()+" of value "+n.getData());     
		            }else{
		                insert(root.getRight(),n);
		            }
		             
		        }
		    }
		    //in-order Traversal
		    public void inOrderTraverse(Node root){
		        if(root != null){
		            inOrderTraverse(root.getLeft());
		            System.out.print("  "+root.getData());
		            inOrderTraverse(root.getRight());
		        }
		         
		    }
		    //binary search
		    public boolean binarySearch(Node root,Node n){
		        if(root == null || n == null) {
		            return false;
		        }
		        System.out.println("  Testing out "+root.getData()+" for value "+n.getData());
		        if(root.getData() > n.getData()){
		           return  binarySearch(root.getLeft(),n);
		        }else if(root.getData() < n.getData()){
		           return  binarySearch(root.getRight(),n);
		        }
		        return true;
		    }
		}

