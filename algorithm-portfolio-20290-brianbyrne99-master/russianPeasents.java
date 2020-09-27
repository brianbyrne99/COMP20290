
public class russianPeasents {
	public static void main(String[] args) 
	{
		long start = System.nanoTime();
		System.out.println("69*138: "+russianPeasent(68,139)+"\nNanotime:"+(System.nanoTime()-start));
		start = System.nanoTime();
		System.out.println("88*190: "+russianPeasent(88,190)+"\nNanotime:"+(System.nanoTime()-start));
		start = System.nanoTime();
		System.out.println("500*1000: "+russianPeasent(600,1000)+"\nNanotime:"+(System.nanoTime()-start));
	}
	
	public static int russianPeasent(int x, int y)
	{
		int accum=0;
		while(x>=1)
		{
			if(x%2==0) {
			  x=x/2;            //halves x value and doubles y
			  y=y*2;
			}
			else {
				x=x/2;          //carries the remainder
				accum=y+accum;
				y*=2;
			    
			}
		}
      return accum;  //returns final multiplication 
	}

}

