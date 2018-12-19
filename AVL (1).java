public class AVL extends BST {

	/*
	 * override insert and delete methods from BST to make the tree AVL
	 */
	//=============================================================Insert
	//add the balancing logic here
	    
            public void insert(Node n)
	{
		root=recursive_insert(root, n);
	}
            
            @Override
            protected Node recursive_insert(Node node, Node n){
                    if(node == null){
                        return n;
                    }
                    else
                    if(node.key > n.key){
                        node.left = recursive_insert(node.left, n);
                    }
                    else
                    if(node.key < n.key){
                        node.right = recursive_insert(node.right, n);
                    }
                    
                    int bal = Balance(node);
                    
                    if(bal > 1 && n.key < node.left.key){
                        return rightRotate(node);
                    }
                    
                    if(bal < -1 && n.key > node.right.key){
                        return leftRotate(node);
                    }
                    
                    if (bal > 1 && n.key > node.left.key) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Left Rotate
		if (bal < -1 && n.key < node.right.key) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
                    
                return node;
                    
                }
                
                public Node leftRotate(Node x) {
		Node y = x.right;
		Node z = y.left;

		y.left = x;
		x.right = z;

		return y;
	}

                public Node rightRotate(Node y) {
		Node x = y.left;
		Node z = x.right;

		x.right = y;
		y.left = z;

		return x;
	}
		
                public int Height(Node n) {
                    if (n == null) {
                        return -1;
                    }

                    int left = Height(n.left);
                    int right = Height(n.right);

                    if (left > right) {
                        return left + 1;
                    } else {
                        return right + 1;
    }
}
                
                public int Balance(Node root){
                    if(root != null){
                        return Height(root.left) - Height(root.right);
                    }
                    return 0;
                }
                
                
		//===========================================================Delete
}		
