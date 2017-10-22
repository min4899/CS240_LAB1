/**
   An recursive insertion sort that organizes integer arrays in ascending order.
   @author Minwoo Soh
*/
public class InsertionSortRecursive
{
  /** Invokes the recursive method that sorts the integer array in ascending order.
      @param a  The array of integers to be sorted. */
  public static void insertionSort(int[] a)
  {
    insertionSort(a, 0); // Invoke iterative method
  } // end selectionSort

  /** Sorts the integer array in ascending order after being invoked.
      @param a  The array of integers to be sorted.
      @param first  The index to start sorting. */
  private static void insertionSort(int[] a, int first)
  {
    int unsorted = first + 1;
    if(unsorted < a.length)
    {
      int nextToInsert = a[unsorted];
      insertInOrder(nextToInsert, a, unsorted - 1);
      insertionSort(a, first + 1);
    } // end if
  } // end insertionSort

  /** Inserts entry into sorted section of array.
      @param entry  The value to be inserted in proper position.
      @param a  The array of integers to be sorted.
      @param end  The index where sorted sction ends. */
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
} // end of InsertionSortRecursive
