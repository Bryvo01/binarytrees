package binarytrees;

public class HuffmanNode extends TNode implements Comparable<HuffmanNode>{
    protected String characters; /* the chars associated with this node */
    protected int frequency; /* the total frequency of the stored chars */

    public HuffmanNode( String characters, int frequency ){
        //Set the parent, left, and right connections to NULL using constructor of TNode
        super( );

        this.characters = characters;
        this.frequency = frequency;
    }

    /* Returns the String of the characters associated with this Huffman node */
    public String getCharacters( )
    {
        return this.characters;
    }

    /* Returns the frequency of the characters associated with this Huffman node */
    public int getFrequency( )
    {
        return this.frequency;
    }

    /* Returns the left child of this node */
    public HuffmanNode getLeft( )
    {
        return (HuffmanNode)super.getLeft();
    }

    /* Returns the right child of this node */
    public HuffmanNode getRight( )
    {
        return (HuffmanNode)super.getRight();
    }

    /* Returns the parent of this node */
    public HuffmanNode getParent( )
    {
        return (HuffmanNode)super.getParent();
    }

    /* Sets the left child of this node to node */
    public void setLeft( HuffmanNode node )
    {
        super.setLeft( node );
    }

    /* Sets the right child of this node to node */
    public void setRight( HuffmanNode node )
    {
        super.setRight( node );
    }

    /* finds the Huffman code for the char c in the Huffman Tree */
    protected String charToHuffmanString( char c )
    {
        HuffmanNode left = this.getLeft();
        HuffmanNode right = this.getRight();

        if( left==null && right==null )
            return "";

        if( left.characters.indexOf( c ) != -1 )
        {
            return "0" + left.charToHuffmanString(c);
        }
        else if( right.characters.indexOf( c ) != -1 )
        {
            return "1" + right.charToHuffmanString(c);
        }
        else
            return "";
    }

    /* Prints the tree starting at this node.  The int is to track the current level of the tree we're on. */
    public void drawTree( int level ){
        if( this == null )
            return ;

        HuffmanNode lchild = this.getLeft();
        HuffmanNode rchild = this.getRight();

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
        return "(" + this.characters + ", " + this.frequency + " )";
    }

    public int compareTo(HuffmanNode node)
    {
        if( this.frequency < node.frequency )
            return -1;
        else if( this.frequency == node.frequency )
            return 0;
        else
            return 1;
    }
}