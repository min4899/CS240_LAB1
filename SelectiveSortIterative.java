/**
   An iterative selective sort that organizes integer arrays in ascending order.
   @author Minwoo Soh
*/
public class SelectiveSortIterative
{
  private static int countMove = 0;
  private static int countCompare = 0;

  /** Sorts the integer array in ascending order.
      @param a  The array of integers to be sorted. */
  public static void sort(int[] a)
  {
    for (int i = 0; i < a.length - 1; i++)
    {
      int indexOfNextSmallest = getIndexOfSmallest(a, i, a.length - 1);
      swap(a, i, indexOfNextSmallest);
    } // end for
    System.out.println("countMove: " + countMove);
    System.out.println("countCompare: " + countCompare);
  } // end sort

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
        countCompare++;
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
    countMove++;
  } // end swap
} // end of SelectiveSortIterative
