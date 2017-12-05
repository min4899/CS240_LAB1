import java.util.Random;

public class Demo
{
  public static void main(String[] args)
  {
    Random randomObj = new Random();

    //Creating array of random numbers

    //CHANGE SIZE FOR TESTING
    int[] test = new int[10];

    for(int i = 0; i < test.length; i++)
    {
      test[i] = randomObj.nextInt(1000);
    }

    //print out array
    for(int i = 0; i < test.length; i++)
    {
      System.out.print(test[i] + " ");
    }
    System.out.println();

    //run sort
    System.out.println("Sorted array:");
    //CHANGE NAME OF CLASS AND SIZE NUMBER FOR TESTING
    ShellSortIterative.sort(test);

    for(int i = 0; i < test.length; i++)
    {
      System.out.print(test[i] + " ");
    }
    System.out.println();

  }
}
