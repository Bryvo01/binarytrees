package binarytrees;

public class RedBlackTree<T extends Comparable<T>> extends Tree {

    /* creates a new empty Tree and returns a pointer to it */
    public RedBlackTree()
    {
        //Set the root to NULL using constructor of Tree
        super();
    }

    /* Returns the root node of this tree */
    @SuppressWarnings("unchecked") //Suppresses warning for this cast
    public RedBlackNode<T> getRoot()
    {
        return (RedBlackNode<T>)this.root;
    }

    /* Stores the passed String in the Tree */
    public void insertRedBlack( T info )
    {
        boolean flag = true;
        RedBlackNode<T> current = this.getRoot();
        RedBlackNode<T> newNode = new RedBlackNode<T>( info );

        if(current == null)
        {
            this.setRoot( newNode );
            flag = false;
        }

        // find the location to insert at
        while(flag)
        {
            if( newNode.compareTo( current )==0 )
            {
                return; // ignore insertion of duplicates
            }
            else if( newNode.compareTo( current )<0 )
            {
                if( current.getLeft() == null)
                {
                    current.setLeft( newNode );
                    flag = false;
                }
                else // still not at bottom of tree
                {
                    current = current.getLeft();
                }
            }
            else
            {
                if (current.getRight() == null)
                {
                    current.setRight( newNode );
                    flag = false;
                }
                else // still not at bottom of tree
                {
                    current = current.getRight();
                }
            }
        }
        rebalanceTree( newNode );
    }

    /* Checks if this Tree is correctly formatted.  Prints when errors occur. */
    public void checkRedBlackTree( ){
        /*int blackHeight =*/ this.getRoot().checkRedBlackStructure( );

        if( this.getRoot().color == Color.RED )
            System.out.println( "ERROR - root node is RED" );
    }

    /* TODO
     * rebalanceTree
     * input: node to start fixing the tree from (climbing up towards the root)
     * output: none
     *
     * Modifies the tree to ensure it follows the 5 rules of red-black trees
     */
    void rebalanceTree( RedBlackNode<T> x )
    {
        //System.out.println(x == this.getRoot());
        /* Check if x is the root and recolor it if it's RED (you can return after fixing it) */
        if (x == this.getRoot())
        {
            x.color = Color.BLACK;
        }
        // loop that rebalances up the tree until you reach the root
        /* while ( fill in your condition ) */
        while (x != this.getRoot())
        {

            /* Check if parent is the root and recolor it if it's RED (you can return after fixing it) */
            if (x.getParent() == this.getRoot())
                {
                    x.color = Color.BLACK;
                }
            //if this node and its parent are both red, do the following:
            if (x.color == Color.RED && x.getParent().color == Color.RED)
            {
                //System.out.println(String.format("%s %s", x.color, x.getParent().color));
            //if case 1 - recolor parent and parent's sibling node
                //System.out.println(x.getParent().getSibling());
                if (x.getParent().getSibling() != null && x.getParent().getSibling().color == Color.RED)
                {
                    x.getParent().color = Color.BLACK;
                    x.getParent().getSibling().color = Color.BLACK;
                    x.getParent().getParent().color = Color.RED;
                }
            //if case 2 & 3 - fix the zigzag/straight cases with rotations/recolors (you can return after fixing them)
                //Case 2, check for a zigzag
                if((x.getParent().getParent().getLeft() == x.getParent() && x.getParent().getRight() == x) ||
                        (x.getParent().getParent().getRight() == x.getParent() && x.getParent().getLeft() == x))
                {
                    if(x.getParent().getRight() == x) //left rotate on parent
                    {
                        if(x.getParent()!=null && x.getParent().getRight()!=null)
                        {
                            super.leftRotate(x.getParent());
                        }
                    }
                }
                //Case 3, check if red nodes are in a straight line.
                if ((x.getParent().getParent().getLeft() == x.getParent() && x.getParent().getLeft() == x) ||
                        (x.getParent().getParent().getRight() == x.getParent() && x.getParent().getRight() == x))
                {
                    if (x.getParent().getParent().getLeft() == x.getParent()) //if parent is left child, right rotate
                    {
                        if (x.getParent()!=null && x.getParent().getLeft()!=null)
                        {
                            super.rightRotate(x.getParent());
                        }
                    }
                    if (x.getParent().getParent().getLeft() == x.getParent()) // if parent is right child, left rotate
                    {
                        if (x.getParent()!=null && x.getParent().getRight()!=null)
                        {
                            super.leftRotate(x);
                        }
//                        x.getParent().setLeft(x.getParent().getParent()); //set the grandparent as the parent's left child.
//                        if (x.getParent().getParent().getParent() != null)//check if there is a great grandparent.
//                        {
//                            x.getParent().getParent().getParent().setRight(x.getParent());//set the parent as the great grandparent's right child.
//                        }
                    }
                }
            }
            //move up the tree
            x = x.getParent();
        }
    }


    /* Prints the tree starting at the root of this tree. */
    public void drawTree( ){
        RedBlackNode<T> root = this.getRoot();
        root.drawTree( 0 );
    }

}