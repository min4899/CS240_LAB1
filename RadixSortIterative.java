/**
   An iterative radix sort that organizes integer arrays in ascending order.
   Only entries of 0 - 999 are allowed.
   @author Minwoo Soh
*/
public class RadixSortIterative
{
  /** Sorts the integer array with integers size of 0 - 999 in ascending order.
      @param a  The array of integers to be sorted. */
  public static void sort(int[] a)
  {
    // Sorts third/last digit when digit = 1.
    // Sorts second digit when digit = 2.
    // Sorts first digit when digit = 3.
    for (int digit = 1; 100/digit > 0; digit *= 10)
    {
      countSort(a, digit);
    } // end for
  } // end sort

  /** Orgnaizes array according to sinle digit.
      @param a The array of integers to be sorted.
      @param digit  The digit that the array will be sorted with. */
  private static void countSort(int[] a, int digit)
  {
    int temp[] = new int[a.length]; // temp array
    int count[] = new int[10]; // Counter for digits.

    for (int i = 0; i < a.length; i++) // Tracks occurrences.
    {
      count[ (a[i]/digit)%10 ]++;
    } // end for

    for (int i = 1; i < 10; i++) // Changes count to contain actual indexes of array.
    {
      count[i] += count[i - 1];
    } // end for

    for (int i = a.length - 1; i >= 0; i--) // Build temp array
    {
      temp[count[ (a[i]/digit)%10 ] - 1] = a[i];
      count[ (a[i]/digit)%10 ]--;
    } // end for

    for (int i = 0; i < a.length; i++) // Copy temp to array. Sorted according to current digit.
    {
      a[i] = temp[i];
    } // end for
  } // end countSort
} // end of RadixSortIterative
