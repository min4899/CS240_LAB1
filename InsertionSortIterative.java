/**
   An iterative insertion sort that organizes integer arrays in ascending order.
   @author Minwoo Soh
*/
public class InsertionSortIterative
{
  private static int countMove = 0;
  private static int countCompare = 0;

  /** Sorts the integer array in ascending order.
      @param a  The array of integers to be sorted. */
  public static void sort(int[] a)
  {
    for(int unsorted = 1; unsorted < a.length; unsorted++)
    {
      int nextToInsert = a[unsorted];
      insertInOrder(nextToInsert, a, unsorted - 1);
    } // end for
    System.out.println("countMove: " + countMove);
    System.out.println("countCompare: " + countCompare);
  } // end sort

  /** Inserts entry into sorted section of array.
      @param entry  The value to be inserted in proper position.
      @param a  The array of integers to be sorted.
      @param end  The index where sorted section ends. */
  private static void insertInOrder(int entry, int[] a, int end)
  {
    int index = end;
    while( (index >= 0) && (entry < a[index]) )
    {
      countCompare++;
      a[index + 1] = a[index];
      countMove++;
      index--;
    } // end while
    a[index + 1] = entry;
    countMove++;
  } // end insertInOrder
} // end of InsertionSortIterative
