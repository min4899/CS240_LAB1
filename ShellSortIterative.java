/**
   An iterative shell sort using Hibbard sequences that organizes integer arrays in ascending order.
   @author Minwoo Soh
*/
public class ShellSortIterative
{
  /** Sorts the integer array in ascending order.
      @param a  The array of integers to be sorted. */
  public static void sort(int[] a)
  {
    int first = 0;
    int last = a.length - 1;
    int k = (int)(Math.log(a.length)/Math.log(2));
    int space = (int)(Math.pow(2,k) - 1);

    while(space > 0)
    {
      for(int begin = 0; begin <= space - 1; begin++)
      {
        incrementalInsertionSort(a, begin, last, space);
      } // end for
      k--;
      space = (int)(Math.pow(2,k) - 1);
    } // end while
  } // end sort

  /** Sorts equally spaced entries of an array into ascending order.
      @param a  The array of integers to be sorted.
      @param first  Index where sequence begins.
      @param last  Index of last array element.
      @param space  Difference between the indices of the entries to sort. */
  private static void incrementalInsertionSort(int[] a, int first, int last, int space)
  {
    for(int unsorted = first + space; unsorted <= last; unsorted += space)
    {
      int nextToInsert = a[unsorted];
      int index = unsorted - space;
      while( (index >= first) && (nextToInsert < a[index]) ) // Only when sorted element is greater.
      {
        a[index + space] = a[index];
        index = index - space;
      } // end while
      a[index + space] = nextToInsert; // Set smaller element before index.
    } // end for
  } // end incrementalInsertionSort
} // end of ShellSortIterative
