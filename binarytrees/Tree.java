/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytrees;

public class Tree {
    protected TNode root;

    /* creates a new empty Tree with a null root */
    public Tree()
    {
        this.root = null;
    }

    /* Returns the root node of this tree */
    public TNode getRoot()
    {
        return this.root;
    }

    /* Updates the root node of this tree */
    public void setRoot( TNode root )
    {
        this.root = root;
    }

    /* Performs a left rotation at node oldRoot */
    void leftRotate(TNode oldRoot)
    {
        if( oldRoot==null || oldRoot.getRight()==null )
            throw new NullPointerException("ERROR - Attempt to rotate using null pointers");

        TNode newRoot = oldRoot.getRight();
        TNode oldRootParent = oldRoot.getParent();

        if( oldRootParent != null)
        {
            if ( oldRootParent.getRight() == oldRoot )
                oldRootParent.setRight( newRoot );
            else
                oldRootParent.setLeft( newRoot );
        }
        else{
            this.root = newRoot;
            newRoot.pParent = null;
        }
        oldRoot.setRight( newRoot.getLeft() );
        newRoot.setLeft( oldRoot );
    }

    /* Performs a right rotation at node oldRoot */
    void rightRotate(TNode oldRoot)
    {
        if( oldRoot==null || oldRoot.getLeft()==null )
            throw new NullPointerException("ERROR - Attempt to rotate using null pointers");

        TNode newRoot = oldRoot.getLeft();
        TNode oldRootParent = oldRoot.getParent();

        if( oldRootParent != null)
        {
            if ( oldRootParent.getLeft() == oldRoot )
                oldRootParent.setLeft( newRoot );
            else
                oldRootParent.setRight( newRoot );
        }
        else{
            this.root = newRoot;
            newRoot.pParent = null;
        }
        oldRoot.setLeft( newRoot.getRight() );
        newRoot.setRight( oldRoot );
    }
}