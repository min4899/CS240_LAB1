/**
   A recursive radix sort that organizes integer arrays in ascending order.
   Only entries of 0 - 999 are allowed.
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
    // Sorts second digit when digit = 10.
    // Sorts first digit when digit = 100.
    if(100/digit > 0)
    {
      int temp[] = new int[a.length]; // temp array
      int count[] = new int[10]; // Counter for digits.

      countSort(a, digit, temp, count);
      digit *= 10;
      sort(a, digit);
    } // end for
  } // end sort

  /** Orgnaizes array according to current digit.
      @param a The array of integers to be sorted.
      @param digit  The digit that the array will sorted with.
      @param temp  The temporary array to store ordered values according the current digit.
      @param count  The array that stores digit counts. */
  private static void countSort(int[] a, int digit, int[] temp, int[] count)
  {
    trackOcurrences(a, digit, count, 0);
    setIndex(a, digit, count, 1);
    buildTemp(a, digit, temp, count, a.length - 1);
    copyArray(a, temp, 0);
  } // end countSort

  /** Tracks occurences of the current digit and increments count accordingly.
      @param a  The array of integers to be sorted.
      @param digit  The digit that the array will be sorted with.
      @param count  The array that stores digit counts.
      @param index  The index that will track and go through the integer array. */
  private static void trackOcurrences(int[] a, int digit, int[] count, int index)
  {
    if(index < a.length)
    {
    count[ (a[index]/digit)%10 ]++;
    trackOcurrences(a, digit, count, index + 1);
    } // end if
  } // end trackOcurrences

  /** Changes count to contain indexes for temp array.
      @param a  The array of integers to be sorted.
      @param digit  The digit that the array will be sorted with.
      @param count  The array that stores digit counts.
      @param index  The index that will track and go through the integer array. */
  private static void setIndex(int[] a, int digit, int[] count, int index)
  {
    if(index < 10)
    {
      count[index] += count[index - 1];
      setIndex(a, digit, count, index + 1);
    } // end if
  } // end setIndex

  /** Stores values according to digit into the temp array.
      @param a  The array of integers to be sorted.
      @param digit  The digit that the array will be sorted with.
      @param temp  The temporary array to store ordered values according the current digit.
      @param count  The array that stores digit counts.
      @param index  The index that will track and go through the integer array. */
  private static void buildTemp(int[] a, int digit, int[] temp, int[] count, int index)
  {
    if(index >= 0)
    {
      temp[count[ (a[index]/digit)%10 ] - 1] = a[index];
      count[ (a[index]/digit)%10 ]--;
      buildTemp(a, digit, temp, count, index - 1);
    } // end if
  } // end buildTemp

  /** Stores values from temp array to original integer array.
      @param a  The array of integers to be sorted.
      @param temp  The temporary array to store ordered values according the current digit.
      @param index  The index that will track and go through the integer array. */
  private static void copyArray(int[] a, int[] temp, int index)
  {
    if(index < a.length)
    {
      a[index] = temp[index];
      copyArray(a, temp, index + 1);
    } // end if
  } // end copyArray
} // end of RadixSortRecursive
