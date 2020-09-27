
public class Hanoi {

	public static void main(String[] args) {
		long start = System.nanoTime();
		moveDisk(4,"Source","Destination", "Auxillary");
		System.out.println("Nanoseonds taken :(4) "+(System.nanoTime()-start));
		start = System.nanoTime();
		moveDisk(10,"Source","Destination", "Auxillary");
		System.out.println("Nanoseonds taken :(7) "+(System.nanoTime()-start));
		start = System.nanoTime();
	}
	
	//recursive implementation of towers of hanoi
	public static void moveDisk(int disk, String source, String destination, String auxillary)
	{
		if (disk == 1)    //if there is only one disk than only one move is needed 
        { 
            System.out.println("Move disk 1 from "+source+" to "+destination); 
            return; 
        }
		
        moveDisk(disk-1, source, auxillary,destination); //disks should always be moved the auxillary temporarily
        System.out.println("Move disk "+disk+" from "+source+" to "+destination); 
        moveDisk(disk-1, auxillary, destination, source);//repeat the process using the remaining disks at the source
	}

}
