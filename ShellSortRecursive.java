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
    sort(a, k, first, last);
  } // end sort

  /** Sorts the integer array in ascending order after being invoked.
      @param a  The array of integers to be sorted.
      @param k  The Hibbard sequence value.
      @param first  The index of first element in array.
      @param last  The incdes of last element in array. */
  public static void sort(int[] a, int k, int first, int last)
  {
    int begin = first;
    int space = (int)(Math.pow(2,k) - 1);
    if(space > 0)
    {
      if(begin <= first + space - 1)
      {
        incrementalInsertionSort(a, begin, last, space);
        k--;
        sort(a, k, first, last);
      } // end if
    } // end if
  } // end sort

  /** Sorts equally spaced entries of an array into ascending order.
      @param a  The array of integers to be sorted.
      @param first  Index of first array element.
      @param last  Index of last array element.
      @param space  Difference between the indices of the entries to sort. */
  private static void incrementalInsertionSort(int[] a, int first, int last, int space)
  {
    for(int unsorted = first + space; unsorted <= last; unsorted += space)
    {
      int nextToInsert = a[unsorted];
      int index = unsorted - space;
      while( (index >= first) && (nextToInsert < a[index]) )
      {
        a[index + space] = a[index];
        index = index - space;
      } // end while
      a[index + space] = nextToInsert;
    } // end for
  } // end incrementalInsertionSort
} // end of ShellSortRecursive
