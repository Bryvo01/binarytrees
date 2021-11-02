package binarytrees;

/*
 * Node for segment trees which contains info of type T
 */


public class SegmentNode extends TNode implements Comparable < SegmentNode > {
    protected Pair < Integer,
            Integer > range; /* the range of this node (you can change this if you want) */
    /* TODO: Add a variable to track the number of line segments that cover this node's range (but not its parent's range) */

    /* Constructor to build new nodes.  Nodes are created with all pointers as null and with the specified range */
    public SegmentNode(Pair < Integer, Integer > range) {
        //Set the parent, left, and right connections to NULL using constructor of TNode
        super();

        this.range = range;
    }

    public SegmentNode(Integer x, Integer y) {
        //Set the parent, left, and right connections to NULL using constructor of TNode
        super();

        this.range = new Pair < Integer, Integer > (x, y);
    }

    /*
     * Compares the data in the given node to the data in this node
     * Returns -1 if this node comes first
     * Returns 0 if these nodes have equal keys
     * Returns 1 if the given node comes first
     *
     * You can change the following methods if you really want to but I found them handy
     */
    public int compareTo(SegmentNode node) {
        return range.compareTo(node.range);
    }

    public boolean equals(SegmentNode node) {
        return this.compareTo(node) == 0;
    }

    @Override //Useful for using HashSet
    public boolean equals(Object aThat) {
        if (this == aThat) //Shortcut the future comparisons if the locations in memory are the same
            return true;
        if (!(aThat instanceof SegmentNode))
            return false;
        SegmentNode that = (SegmentNode) aThat;
        return this.equals(that); //Use above equals method
    }

    @Override //Useful for using HashSet
    public int hashCode() {
        return range.hashCode();
    }


    /* Returns the left child of this node */
    public SegmentNode getLeft() {
        return (SegmentNode) super.getLeft();
    }

    /* Returns the right child of this node */
    @SuppressWarnings("unchecked") //Suppresses warning for this cast
    public SegmentNode getRight() {
        return (SegmentNode) super.getRight();
    }

    /* Sets the left child of this node to the given node */
    public void setLeft(SegmentNode node) {
        super.setLeft(node);
    }

    /* Sets the right child of this node to the given node */
    public void setRight(SegmentNode node) {
        super.setRight(node);
    }

    /* TODO:
     *
     *Inserts the given line segment into the segment tree rooted at this node
     */
    protected void insertLineSegment(Pair < Integer, Integer > lineSegment) {
        return; //Currently does nothing
    }

    /* TODO:
     *
     * Returns the number of line segments that intersect the query point
     */
    protected int lineStabQuery(int point) {
        return -1; /* replace this once you're calculating the correct value */
    }

    /* Prints the tree starting at this node.  The int is to track the current level of the tree we're on. */
    public void drawTree(int level) {
        if (this == null)
            return;

        SegmentNode lchild = this.getLeft();
        SegmentNode rchild = this.getRight();

        if (lchild != null)
            lchild.drawTree(level + 1);
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        System.out.println(this); //TODO (Optional): For this print to be more useful you should complete toString below.
        if (rchild != null)
            rchild.drawTree(level + 1);
    }

    public String toString() {
        return range + "<your other data here>"; /* TODO (Optional): Return a string with the data in this node. Useful for debugging. */
    }
}