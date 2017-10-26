/**
   A recursive radix sort that organizes integer arrays in ascending order.
   @author Minwoo Soh
*/
public class RadixSortRecursive
{
  /** Invokes the recursive method that sorts the integer array in ascending order.
      @param a  The array of integers to be sorted. */
  public static void sort(int[] a)
  {
    int digit = 1;
    sort(a, digit);
  } // end sort

  /** Sorts the integer array with integers size of 0 - 999 in ascending order.
      @param a  The array of integers to be sorted.
      @param digit  The digit that the array will sorted with. */
  public static void sort(int[] a, int digit)
  {
    // Sorts third/last digit when digit = 1.
    // Sorts second digit when digit = 2.
    // Sorts first digit when digit = 3.
    if(100/digit > 0)
    {
      countSort(a, digit);
      digit *= 10;
      sort(a, digit);
    } // end for
  } // end sort

  /** Orgnaizes array according to sinle digit.
      @param a The array of integers to be sorted.
      @param digit  The digit that the array will sorted with. */
  private static void countSort(int[] a, int digit)
  {
    int temp[] = new int[a.length]; // temp array
    int count[] = new int[10]; // Counter for digits.

    for (int i = 0; i < a.length; i++) // Tracks occurrnces.
    {
      count[ (a[i]/digit)%10 ]++;
    } // end for

    for (int i = 1; i < 10; i++) // Changes count to to contain actual indexes of array.
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
} // end of RadixSortRecursive
