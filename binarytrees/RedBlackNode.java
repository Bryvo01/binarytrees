package binarytrees;

/*
 * Node for red-black trees which contains info of type T
 */

enum Color
{
    RED, BLACK;
}

public class RedBlackNode<T extends Comparable<T>> extends TNode {
    protected Color color;
    protected T info; /* my stored data */

    /* Constructor to build new nodes.  Nodes are created as red and contain the given info. */
    public RedBlackNode( T info ){
        //Set the parent, left, and right connections to NULL using constructor of TNode
        super( );

        //All nodes start as red
        this.color = Color.RED;
        this.info = info;
    }

    /*
     * Compares the data in the given node to the data in this node
     * Returns -1 if this node comes first
     * Returns 0 if these nodes have equal keys
     * Returns 1 if the given node comes first
     */
    public int compareTo( RedBlackNode<T> node ){
        return info.compareTo( node.info );
    }

    /* Returns the left child of this node */
    @SuppressWarnings("unchecked") //Suppresses warning for this cast
    public RedBlackNode<T> getLeft( )
    {
        return (RedBlackNode<T>)super.getLeft();
    }

    /* Returns the right child of this node */
    @SuppressWarnings("unchecked") //Suppresses warning for this cast
    public RedBlackNode<T> getRight( )
    {
        return (RedBlackNode<T>)super.getRight();
    }

    /* Returns the parent of this node */
    @SuppressWarnings("unchecked") //Suppresses warning for this cast
    public RedBlackNode<T> getParent( )
    {
        return (RedBlackNode<T>)super.getParent();
    }

    /* Returns the sibling of this node */
    @SuppressWarnings("unchecked") //Suppresses warning for this cast
    public RedBlackNode<T> getSibling( )
    {
        return (RedBlackNode<T>)super.getSibling();
    }

    /* Sets the left child of this node to the given node */
    public void setLeft( RedBlackNode<T> node )
    {
        super.setLeft( node );
    }

    /* Sets the right child of this node to the given node */
    public void setRight( RedBlackNode<T> node )
    {
        super.setRight( node );
    }

    /* Checks if this Tree is correctly formatted.  Prints when errors occur.  Returns the number of black nodes on path down to leaf. */
    public int checkRedBlackStructure( ){
        if( this == null )
            return 1;

        int leftcnt = 0;
        int rightcnt = 0;

        RedBlackNode<T> lchild = this.getLeft();
        RedBlackNode<T> rchild = this.getRight();
        if( lchild != null )
            leftcnt =  lchild.checkRedBlackStructure( );
        if( rchild != null )
            rightcnt = rchild.checkRedBlackStructure( );

        if( leftcnt != rightcnt )
            System.out.println( "ERROR - left and right nodes have different black height.  Left count = " + leftcnt + " Right count = " + rightcnt );

        if( (lchild != null && this.color == Color.RED && lchild.color == Color.RED) ||
                (rchild != null && this.color == Color.RED && rchild.color == Color.RED) )
            System.out.println( "ERROR - red node with red child.");

        if( this.color == Color.BLACK )
            return leftcnt + 1;
        else
            return leftcnt;
    }

    /* Prints the tree starting at this node.  The int is to track the current level of the tree we're on. */
    public void drawTree( int level ){
        if( this == null )
            return ;

        RedBlackNode<T> lchild = this.getLeft();
        RedBlackNode<T> rchild = this.getRight();

        if( lchild != null )
            lchild.drawTree( level+1 );
        for( int i=0; i<level; i++ ){
            System.out.print("   ");
        }
        System.out.println( this );
        if( rchild != null )
            rchild.drawTree( level+1 );
    }

    public String toString()
    {
        if( this.color == Color.BLACK )
            return this.info + " BLACK";
        return this.info + " RED";
    }
}