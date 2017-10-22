/**
   An recursive selective sort that organizes integer arrays in ascending order.
   @author Minwoo Soh
*/
public class SelectiveSortRecursive
{
  /** Invokes the recursive method that sorts the integer array in ascending order.
      @param a  The array of integers to be sorted.
      @param n  The size of the array. */
  public static void selectionSort(int[] a, int n)
  {
    selectionSort(a, 0, n - 1); // Invoke recursive method
  } // end selectionSort

  /** Sorts the integer array in ascending order after being invoked.
      @param a  The array of integers to be sorted.
      @param first  The index to start sorting.
      @param n  The size of the array. */
  private static void selectionSort(int[] a, int first, int n)
  {
    if(first < n)
    {
      int indexOfNextSmallest = getIndexOfSmallest(a, first, n - 1);
      swap(a, first, indexOfNextSmallest);
      selectionSort(a, first + 1, n);
    }
  } // end selectionSort

  /** Finds the index of the smallest value in a section of the array.
      @param a  An array of integers.
      @param first  The index to begin comparison.
      @param last  The index to stop comparison.
      @return  Returns the index of the smallest integer value. */
  private static int getIndexOfSmallest(int[] a, int first, int last)
  {
    int min = a[first];
    int indexOfMin =  first;
    for(int i = first + 1; i <= last; i++)
    {
      if (a[i] < min)
      {
        min = a[i];
        indexOfMin = i;
      } // end if
    } // end for
    return indexOfMin;
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
