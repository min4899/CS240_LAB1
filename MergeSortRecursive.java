/**
   An recursive merge sort that organizes integer arrays in ascending order.
   @author Minwoo Soh
*/
public class MergeSortRecursive
{
  /** Invokes the recursive method that sorts the integer array in ascending order.
      @param a  The array of integers to be sorted. */
  public static void mergeSort(int[] a)
  {
    mergeSort(a, 0, a.length - 1);
  } // end mergeSort

  /** Sorts the integer array in ascending order after being invoked.
      @param a  The array of integers to be sorted.
      @param first  The index to start sorting.
      @param last  The index to stop sorting. */
  private static void mergeSort(int[] a, int first, int last)
  {
    if(first < last)
    {
      int mid = (first + last) / 2;
      mergeSort(a, first, mid);
      mergeSort(a, mid + 1, last);
      merge(a, first, mid, last);
    } // end if
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
    int[] left = new int[firstHalf];
    int[] right = new int[secondHalf];
    for(int i = 0; i < firstHalf; i++)
    {
      left[i] = a[first + i];
    } // end for
    for(int i = 0; i < secondHalf; i++)
    {
      right[i] = a[mid + 1 + i];
    } // end for

    // Pointer for each temp arrays.
    int leftIndex = 0;
    int rightIndex = 0;

    // Compares the value at the pointed indexes of each array and sets them from least to greatest.
    int index = first;
    while(leftIndex < firstHalf && rightIndex < secondHalf)
    {
      if(left[leftIndex] <= right[rightIndex]) // Pointed value of left array is lower.
      {
        a[index] = left[leftIndex];
        leftIndex++;
      }
      else // Pointed value of right array is lower
      {
        a[index] = right[rightIndex];
        rightIndex++;
      } // end if
      index++;
    } // end while

    // Sets remaining items if all values in right array are listed.
    while(leftIndex < firstHalf)
    {
      a[index] = left[leftIndex];
      leftIndex++;
      index++;
    } // end while

    // Sets remaining items if all values in leftt array are listed.
    while(rightIndex < secondHalf)
    {
      a[index] = right[rightIndex];
      rightIndex++;
      index++;
    } // end while
  } // end merge
} // end of MergeSortIterative
