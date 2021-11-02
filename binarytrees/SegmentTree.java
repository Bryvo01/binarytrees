package binarytrees;
import java.util.*;

public class SegmentTree extends Tree {

    /* TODO:
     *
     * creates a Segment Tree from the input array of 1d line segments
     */
    public SegmentTree(ArrayList < Pair < Integer, Integer >> lineSegments) {
        super();
        /* I used HashSet to figure out the unique set of points given by the line segments */
        /* You can assume the Pairs (x,y) given in lineSegments will all be of the form x<=y */

        /* I put my unique points into an ArrayList and used Collections.sort to sort them but you can try a different approach */

        buildBalancedTreeFromArray( /* pass in your sorted data */ );

        /* insert the line segments into your tree */

        //this.getRoot().drawTree( 0 ); /* You can use this to draw your tree */
    }

    /* TODO:
     *
     * Builds a balanced tree from a given sorted array
     */
    protected void buildBalancedTreeFromArray( /* I used a Linked List of SegmentNodes but you might find a different DS easier to work with */ ) {

    }

    /* Returns the number of line segments that intersect the query point  */
    public int lineStabQuery(int point) {
        return this.getRoot().lineStabQuery(point);
    }

    /* Returns the root node of this tree */
    public SegmentNode getRoot() {
        return (SegmentNode) this.root;
    }

}