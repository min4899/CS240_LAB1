/**
   A recursive selective sort that organizes integer arrays in ascending order.
   @author Minwoo Soh
*/
public class SelectiveSortRecursive
{
  /** Invokes the recursive method that sorts the integer array in ascending order.
      @param a  The array of integers to be sorted. */
  public static void sort(int[] a)
  {
    sort(a, 0, a.length - 1); // Invoke recursive method
  } // end sort

  /** Sorts the integer array in ascending order after being invoked.
      @param a  The array of integers to be sorted.
      @param first  The index to start sorting.
      @param last  The index to stop sorting. */
  private static void sort(int[] a, int first, int last)
  {
    if(first < last)
    {
      int indexOfNextSmallest = getIndexOfSmallest(a, first, last, first);
      swap(a, first, indexOfNextSmallest);
      sort(a, first + 1, last);
    } // end if
  } // end sort

  /** Finds the index of the smallest value in a section of the array.
      @param a  An array of integers.
      @param first  The index to begin comparison.
      @param last  The index to stop comparison.
      @param indexOfMin  The index with the lowest array value.
      @return  Returns the index of the smallest integer value. */
  private static int getIndexOfSmallest(int[] a, int first, int last, int indexOfMin)
  {
    if(first == last) // If the search reached end of array.
    {
      if(a[first] < a[indexOfMin])
      {
        indexOfMin = first;
      } // end if
      return indexOfMin;
    }
    else
    {
      if(a[first] < a[indexOfMin])
      {
        indexOfMin = first; // Replace with new index.
      } // end if
    } // end if
    return getIndexOfSmallest(a, first + 1, last, indexOfMin); // Repeat until it reaches last element of array.

  } // end getIndexOfSmallest

  /** Swaps the array entries.
      @param a  An array of integers.
      @param i  The index of array to swap with.
      @param j  The index of array to swap with. */
  private static void swap(int[] a, int i, int j)
  {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  } // end swap
} // end of SelectiveSortRecursive
