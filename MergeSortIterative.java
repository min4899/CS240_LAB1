/**
   An iterative merge sort that organizes integer arrays in ascending order.
   @author Minwoo Soh
*/
public class MergeSortIterative
{
  /** Sorts the integer array in ascending order.
      @param a  The array of integers to be sorted. */
  public static void mergeSort(int[] a)
  {
    int divSize; // Size of divided arrays.
    int start; // First index of divided arrays.

    // Starts with 2 divided arrays. Subarrays eventually build up to original size.
    for (divSize = 1; divSize <= a.length - 1; divSize = 2 * divSize)
    {
      // Starting point of different subarrays.
      for (start = 0; start < a.length - 1; start += 2 * divSize)
      {
        int mid = Math.min(start + divSize - 1, a.length - 1); // Mid index.
        int end = Math.min(start + 2 * divSize - 1, a.length - 1); // End index of divded arrays.
        //System.out.println("Running: merge(a, " + start + ", " + mid + ", " + end + ")");
        merge(a, start, mid, end);
      } // end for
    } // end for
  } // end mergeSort

  /** Combines 2 divided arrays into one sorted section of array.
      @param a  The array of integers to be sorted.
      @param first  The first index of the section of array.
      @param mid  The middle index of the section of array.
      @param last  The index where section of array ends. */
  private static void merge(int[] a, int first, int mid, int last)
  {
    int firstHalf = mid - first + 1;
    int secondHalf = last - mid;

    // Create 2 arrays that will temporarily store values from original array.
    int[] start = new int[firstHalf];
    int[] right = new int[secondHalf];
    for(int i = 0; i < firstHalf; i++)
    {
      start[i] = a[first + i];
    } // end for
    for(int i = 0; i < secondHalf; i++)
    {
      right[i] = a[mid + 1 + i];
    } // end for

    // Pointer for each temp arrays.
    int startIndex = 0;
    int rightIndex = 0;

    // Compares the value at the pointed indexes of each array and sets them from least to greatest.
    int index = first;
    while(startIndex < firstHalf && rightIndex < secondHalf)
    {
      if(start[startIndex] <= right[rightIndex]) // Pointed value of start array is lower.
      {
        a[index] = start[startIndex];
        startIndex++;
      }
      else // Pointed value of right array is lower
      {
        a[index] = right[rightIndex];
        rightIndex++;
      } // end if
      index++;
    } // end while

    // Sets remaining items if all values in right array are listed.
    while(startIndex < firstHalf)
    {
      a[index] = start[startIndex];
      startIndex++;
      index++;
    } // end while

    // Sets remaining items if all values in startt array are listed.
    while(rightIndex < secondHalf)
    {
      a[index] = right[rightIndex];
      rightIndex++;
      index++;
    } // end while
  } // end merge
} // end of MergeSortIterative
