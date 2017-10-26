/**
   A recursive insertion sort that organizes integer arrays in ascending order.
   @author Minwoo Soh
*/
public class InsertionSortRecursive
{
  /** Invokes the recursive method that sorts the integer array in ascending order.
      @param a  The array of integers to be sorted. */
  public static void sort(int[] a)
  {
    sort(a, 0, a.length - 1); // Invoke iterative method
  } // end selectionSort

  /** Sorts the integer array in ascending order after being invoked.
      @param a  The array of integers to be sorted.
      @param first  The index to start sorting.
      @param last  The index to stop sorting */
  private static void sort(int[] a, int first, int last)
  {
    if(first < last)
    {
      sort(a, first, last - 1);
      insertInOrder(a[last], a, first, last - 1);
    } // end if
  } // end sort

  /** Inserts entry into sorted section of array.
      @param entry  The value to be inserted in proper position.
      @param a  The array of integers to be sorted.
      @param begin The index where the sorted section begins.
      @param end  The index where entry's value is compared with. */
  private static void insertInOrder(int entry, int[] a, int begin, int end)
  {
    if(entry >= a[end]) // If entry is greater, set it after a[end].
    {
      a[end + 1] = entry;
    }
    else if(begin < end) // Entry value is lower than a[end]
    {
      a[end + 1] = a[end];
      insertInOrder(entry, a, begin, end - 1);
    }
    else // Reached front of sorted section so entry is lowest value, set it at front.
    {
      a[end + 1] = a[end];
      a[end] = entry;
    } // end if
  } // end insertInOrder
} // end of InsertionSortRecursive
