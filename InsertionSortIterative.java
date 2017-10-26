/**
   An iterative insertion sort that organizes integer arrays in ascending order.
   @author Minwoo Soh
*/
public class InsertionSortIterative
{
  /** Sorts the integer array in ascending order.
      @param a  The array of integers to be sorted. */
  public static void insertionSort(int[] a)
  {
    for(int unsorted = 1; unsorted < a.length; unsorted++)
    {
      int nextToInsert = a[unsorted];
      insertInOrder(nextToInsert, a, unsorted - 1);
    } // end for
  } // end insertionSort

  /** Inserts entry into sorted section of array.
      @param entry  The value to be inserted in proper position.
      @param a  The array of integers to be sorted.
      @param end  The index where sorted section ends. */
  private static void insertInOrder(int entry, int[] a, int end)
  {
    int index = end;
    while( (index >= 0) && (entry < a[index]) )
    {
      a[index + 1] = a[index];
      index--;
    } // end while
    a[index + 1] = entry;
  } // end insertInOrder
} // end of InsertionSortIterative
