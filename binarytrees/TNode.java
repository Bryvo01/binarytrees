/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytrees;

public class TNode {
    protected TNode pLeft;
    protected TNode pRight;
    protected TNode pParent;


    /* Constructor to build new TNodes.  All of the pointers are initially null. */
    public TNode( ){
        //All nodes start with no connections
        this.pParent = null;
        this.pLeft = null;
        this.pRight = null;
    }

    /* Returns the left child of this node */
    public TNode getLeft( )
    {
        return pLeft;
    }

    /* Returns the right child of this node */
    public TNode getRight( )
    {
        return pRight;
    }

    /* Returns the parent of this node */
    public TNode getParent( )
    {
        return pParent;
    }

    /* Returns the sibling of this node */
    public TNode getSibling( )
    {
        if( this.pParent == null )
            return null;

        else if( this.pParent.pLeft == this )
            return this.pParent.pRight;

        else if( this.pParent.pRight == this )
            return this.pParent.pLeft;

        return null;
    }

    /* Sets the left child of this node to node */
    public void setLeft( TNode node )
    {
        this.pLeft = node;
        if( node!=null )
            node.pParent = this;
    }

    /* Sets the right child of this node to node */
    public void setRight( TNode node )
    {
        this.pRight = node;
        if( node!=null )
            node.pParent = this;
    }
}