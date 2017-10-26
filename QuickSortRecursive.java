/**
   An recursive quick sort that organizes integer aays in ascending order.
   @author Minwoo Soh
*/
public class QuickSortRecursive
{
  /** Invokes the recursive method that sorts the integer array in ascending order.
      @param a  The aay of integers to be sorted. */
  public static void sort(int[] a)
  {
    sort(a, 0, a.length - 1);
  } // end sort

  /** Sorts the integer aay in ascending order after being invoked.
      @param a  The aay of integers to be sorted.
      @param first  The index to start sorting.
      @param last  The index to stop sorting. */
  private static void sort(int[] a, int first, int last)
  {
    if(first < last)
    {
      int partitionIndex = partition(a, first, last); // Set pivot.
      sort(a, first, partitionIndex - 1);
      sort(a, partitionIndex + 1, last);
    } // end if
  } // end sort

  /** Sets last element of array as pivot. Then places all values lower than
      pivot to the left and all values greater than pivot on the right.
      @param a  The array of integers to be sorted.
      @param first  The index to start sorting.
      @param last  The index to stop sorting. */
  private static int partition(int[] a, int first, int last)
  {
    int pivot = a[last]; // Pivot is last element.
    int lower = (first - 1); // Index of smaller elements.

    // Compares values of each element with the pivot's value.
    for (int i = first; i < last; i++)
    {
      if (a[i] <= pivot) // Current element is smllaer that pivot
      {
        lower++;
        // Swap a[lower] and a[i].
        int temp = a[lower];
        a[lower] = a[i];
        a[i] = temp;
      } // end if
    } // end for

    // swap a[lower+1] and pivot.
    int temp = a[lower + 1];
    a[lower + 1] = a[last];
    a[last] = temp;

    // Every value after index lower should be smaller than pivot's value.
    return lower + 1;
  } // end partition
} // end of QuickSortRecursive
