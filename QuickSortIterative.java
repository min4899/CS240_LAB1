/**
   An iterative quick sort that organizes integer aays in ascending order.
   @author Minwoo Soh
*/
public class QuickSortIterative
{
  /** Sorts the integer array in ascending order.
      @param a  The aay of integers to be sorted. */
  public static void sort(int[] a)
  {
    // Create a stack to temporarily store indexes of partitions.
    int stack[] = new int[a.length];
    int top = -1; // Initialize top of stack.

    // Set initial indexes of array.
    int last = a.length - 1;
    int first = 0;
    // Push initial values in the stack.
    stack[++top] = first;
    stack[++top] = last;

    // Sorts each partition until no indexes are left in the stack.
    while (top >= 0)
    {
      // Pop last then first.
      last = stack[top--];
      first = stack[top--];

      int partitionIndex = partition(a, first, last); // Set pivot.

      // If elements are still on left side of pivot, create new partition.
      if (partitionIndex - 1 > first)
      {
        // First and last indexes of new partition before pivot.
        stack[++top] = first;
        stack[++top] = partitionIndex - 1;
      } // end if

      // If elements are still on right side of pivot, create new partition.
      if (partitionIndex + 1 < last)
      {
        // First and last indexes of new partition after pivot.
        stack[++top] = partitionIndex + 1;
        stack[++top] = last;
      } // end if
    } // end while
  } // end sort

  /** Sets last element of array as pivot. Then places all values lower than
      pivot to the left and all values greater than pivot on the right.
      @param a  The array of integers to be sorted.
      @param first  The index to start sorting.
      @param last  The index to stop sorting. */
  private static int partition(int[] a, int first, int last)
  {
    int pivot = a[last]; // Pivot is last element.
    int lower = (first - 1); // Index of smaller elements.

    // Compares values of each element with the pivot's value.
    for (int i = first; i < last; i++)
    {
      if (a[i] <= pivot) // Current element is smllaer that pivot
      {
        lower++;
        // Swap a[lower] and a[i].
        int temp = a[lower];
        a[lower] = a[i];
        a[i] = temp;
      } // end if
    } // end for

    // swap a[lower+1] and pivot.
    int temp = a[lower + 1];
    a[lower + 1] = a[last];
    a[last] = temp;

    // Every value after index lower should be smaller than pivot's value.
    return lower + 1;
  } // end partition
} // end of QuickSortIterative
