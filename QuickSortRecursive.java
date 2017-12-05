/**
   A recursive quick sort that organizes integer aays in ascending order.
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
      //int pivot = a[last]; // Pivot is last element.
      //int lower = first - 1; // Index of smaller elements.
      int partitionIndex = partition(a, first, last); // Set pivot.
      sort(a, first, partitionIndex - 1);
      sort(a, partitionIndex + 1, last);
    } // end if
  } // end sort

  /** Sets last element of array as pivot and set the index of elements that will be lower than the pivot.
      Then set the pivot in between the lower and larger sections.
      @param a  The array of integers to be sorted.
      @param first  The index to start sorting.
      @param last  The index to stop sorting.
      @return  Returns the index where the pivot was placed. */
  private static int partition(int[] a, int first, int last)
  {
    int pivot = a[last]; // Pivot is last element.
    int lower = (first - 1); // Index of smaller elements.

    lower = swap(a, first, last, lower, pivot); // Find the index of the last elements that are lower than pivot.

    // Set the pivot after all the elements that are lower than it.
    a[last] = a[lower + 1];
    a[lower + 1] = pivot;

    return lower + 1;
  } // end partition

  /** Places all values lower than pivot to the left and all values greater than pivot on the right.
      @param a  The array of integers to be sorted.
      @param first  The index to start sorting.
      @param last  The index to stop sorting.
      @param lower  The last index of elements that are lower than pivot.
      @param pivot  The element that is used to compare and sort the array.
      @return  Returns index of last element that is lower than pivot. */
  private static int swap(int[] a, int first, int last, int lower, int pivot)
  {
    if(a[first] <= pivot) // Place elements before pivot index (lower) if they are less than pivot.
    {
      lower++;
      int temp = a[lower];
      a[lower] = a[first];
      a[first] = temp;
    } // end if
    first++;
    if(first < last) // Go through entire array.
    {
      lower = swap(a, first, last, lower, pivot);
    } // end if
    return lower;
  } // end swap
} // end of QuickSortRecursive
