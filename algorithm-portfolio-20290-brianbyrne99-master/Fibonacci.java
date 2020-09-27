
public class Fibonacci {

	public static void main(String[] args)
	{
		//Test that demonstrate the efficiency of the algorithms
		// by measuing them in nanoseconds
		System.out.println("Fibonacci of 6");
		long start = System.nanoTime();
		recursion(6);
		System.out.println("Recursive Fibonnacci in Nanoseconds: "+(System.nanoTime()-start));
		System.out.println("Result: "+recursion(6));
		
		long start2 = System.nanoTime();
		iterative(6);
		System.out.println("Iterattive Fibonnacci in Nanoseconds: "+(System.nanoTime()-start2));
		System.out.println("Result: "+iterative(6));
		
		System.out.println("\nFibonacci of 25");
		long start3 = System.nanoTime();
		recursion(25);
		System.out.println("Recursive Fibonnacci in Nanoseconds: "+(System.nanoTime()-start));
		System.out.println("Result: "+recursion(25));
		
		long start4 = System.nanoTime();
		iterative(25);
		System.out.println("Iterattive Fibonnacci in Nanoseconds: "+(System.nanoTime()-start2));
		System.out.println("Result: "+iterative(25));
		
		System.out.println("\nTesting Large result for: \nrecursive "+recursion(46));
		System.out.println("\niterative "+iterative(46));
	}
	
	//Recursive implementation of the Fibonacci algorithm
	public static int recursion(int n)
	{
		if(n==0)
		{
			return 0;
		}
		if(n==1)
		{
			return 1;
		}       //above: base cases
		else
		{
			n=recursion(n-1)+recursion(n-2); //recursive call
			return n;
		}
	}
	
	//iterative version of the Fibonacci algorithm
	public static int iterative(int n)
	{
		int curr=1, prev=1,temp;
		if(n==0)
		{
			curr=0;
		}
		if(n==1)//base cases
		{
			;//do nothing 
		}
			else {
				for(int i=2;i<n;i++) {      //iterativley adding the previous 2 numbers
				temp=curr;
				curr+=prev;
				prev=temp;
				}
			}
		return curr;
	}
	
	
}
