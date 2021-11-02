import binarytrees.*;
import java.util.*;

public class Driver {

    public static final int MAX_VALUE = 500000;
    public static void main(String[] args) {
        System.out.println("TEST RED-BLACK TREE: ");
        System.out.println("---------------------");
        testTreeRebalanceString( 20, true );
        testTreeRebalanceString( MAX_VALUE, false );
        testTreeRebalanceInteger( 20, true );
        testTreeRebalanceInteger( MAX_VALUE, false );
        System.out.println( );

        System.out.println("TEST HUFFMAN TREE: ");
        System.out.println("---------------------");
        String testHuffman = "aabacccadadadadda";
        HuffmanTree T = new HuffmanTree( testHuffman );
        System.out.println( T );
        System.out.println( );
        System.out.println( );

        System.out.println("TEST SEGMENT TREE: ");
        System.out.println("---------------------");
        int[] startPoints = {  0, -7, -7, -10, -10, -2, -2,  5,  5, 43,  9,  9, 14, 14, -2, 43, -2, 26 };
        int[] endPoints   = { 25, 25, -2,  -2,   5,  5, 26, 26, 52, 52, 46, 25, 25, 18, 18, 46, 38, 38 };
        ArrayList<Pair<Integer,Integer>> lineSegments = new ArrayList<Pair<Integer,Integer>>( );
        for(int i=0; i<startPoints.length; i++ )
            lineSegments.add( new Pair<Integer,Integer>(startPoints[i],endPoints[i]) );

        SegmentTree S = new SegmentTree( lineSegments );

        int[] queryPoints  = { -10, -7, -2, 0, 5, 9, 14, 18, 25, 26, 38, 43, 46, 52 };
        if( S.getRoot()!=null )
            for(int i=0; i<queryPoints.length; i++ )
                System.out.println("Line Stab Query for " + queryPoints[i] + " returns " + S.lineStabQuery( queryPoints[i] ) );
        else
            System.out.println( "ERROR - Root of Segment Tree is null" );
        System.out.println( );
        System.out.println( );
    }

    public static void testTreeRebalanceString( int numInserts, boolean check ) {
        int i = 0;
        String data;
        long start, end;

        //Create Red-Black Tree that contains Strings
        RedBlackTree<String> t = new RedBlackTree<String>();

        // Time the insert function
        start = System.currentTimeMillis();
        for (i = 1; i < numInserts; i++)
        {
            data = createName( i, (int)Math.log(numInserts) );
            t.insertRedBlack( data );
            if( check ){
                System.out.println("Insert #" + i + " inserting " + data);
                //Uncomment the following line to print errors if your tree violates one of the 5 properties
                //t.checkRedBlackTree( );
                //Uncomment the following lines to print your tree
                //t.drawTree( );
                //System.out.println();
            }
        }
        end = System.currentTimeMillis();
        if( check )
            System.out.println("Time to insert " + numInserts + " numbers with debugging (in seconds): " + ((end - start) / 1000.0));
        else
            System.out.println("Time to insert " + numInserts + " numbers without debugging (in seconds): " + ((end - start) / 1000.0));
        System.out.println( );
    }

    static String createName( int key, int digits )
    {
        int i;
        String str = "";
        for (i = digits; i > 0 ; i--)
        {
            str += (char) ('0' + key%10);
            key = key / 10;
        }
        return str;
    }

    public static void testTreeRebalanceInteger( int numInserts, boolean check ) {
        int i = 0;
        Integer data;
        long start, end;
        Random random = new Random();

        //Create Red-Black Tree that contains Strings
        RedBlackTree<Integer> t = new RedBlackTree<Integer>();

        // Time the insert function
        start = System.currentTimeMillis();
        for (i = 1; i < numInserts; i++)
        {
            data = random.nextInt();
            t.insertRedBlack( data );
            if( check ){
                System.out.println("Insert #" + i + " inserting " + data);
                //Uncomment the following line to print errors if your tree violates one of the 5 properties
                //t.checkRedBlackTree( );
                //Uncomment the following lines to print your tree
                //t.drawTree( );
                //System.out.println();
            }
        }
        end = System.currentTimeMillis();
        if( check )
            System.out.println("Time to insert " + numInserts + " numbers with debugging (in seconds): " + ((end - start) / 1000.0));
        else
            System.out.println("Time to insert " + numInserts + " numbers without debugging (in seconds): " + ((end - start) / 1000.0));
        System.out.println( );
    }

}