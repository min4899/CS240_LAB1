/**
   A recursive shell sort using Hibbard sequence that organizes integer arrays in ascending order.
   @author Minwoo Soh
*/
public class ShellSortRecursive
{
  /** Invokes the recursive method that sorts the integer array in ascending order.
      @param a  The array of integers to be sorted. */
  public static void sort(int[] a)
  {
    int first = 0;
    int last = a.length - 1;
    int k = (int)(Math.log(a.length)/Math.log(2));
    //int space = (int)(Math.pow(2,k) - 1);
    sort(a, k, first, last, 0);
  } // end sort

  /** Sorts the integer array in ascending order after being invoked.
      @param a  The array of integers to be sorted.
      @param k  The Hibbard sequence value.
      @param first  The index of first element in array.
      @param last  The index of last element in array.
      @param index  The index that will be compared and sorted in the insertion sort. */
  public static void sort(int[] a, int k, int first, int last, int index)
  {
    int space = (int)(Math.pow(2,k) - 1);
    if(space > 0)
    {
      if(index <= last)
      {
        incrementalInsertionSort(a[index], a, index + space, last, space);
        //incrementalInsertionSort(a, begin, last, space);
        sort(a, k, first, last, index + space);
      } // end if
      k--;
      sort(a, k, first, last, 0);
    } // end if
  } // end sort

  /** Sorts equally spaced entries of an array into ascending order.
      @param entry  The element that is being compared and inserted.
      @param a  The array of integers to be sorted.
      @param begin  Index where unsorted section begins.
      @param last  Index of last array element.
      @param space  Difference between the indices of the entries to sort. */
  private static void incrementalInsertionSort(int entry, int[] a, int begin, int last, int space)
  {
    if(begin <= last)
    {
      if(entry >= a[begin]) // If entry is bigger than the unsorted array element (a[begin]).
      {
        // Set unsorted element before index begin, and set entry in index begin.
        a[begin - space] = a[begin];
        a[begin] = entry;
        incrementalInsertionSort(entry, a, begin + space, last, space);
      } // end if
    } // end if
  } // end incrementalInsertionSort
} // end of ShellSortRecursive
