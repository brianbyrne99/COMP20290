
public class StringSearches {

	public static void main(String[] args) {
		//testing strings of various lengths
		        String txt = "ABABDABACDABABCABAB"; 
			    String pat = "ABABCABAB"; 
			    String txt1 = "JAVAJAVAJ";
			    String pat1 = "JAVA";
			    String txt2 = "ahahahahaahahahahahaahahahaahhhaaahaha";
			    String pat2 = "aha";
			    
			     long start = System.nanoTime();
		        search(txt, pat); 
		        System.out.println("Time taken to complete Brute Force String Search(Medium sized strings): "+(System.nanoTime()-start)+" Nanoseconds");
		        
		        start = System.nanoTime();
		        search(txt1, pat1); 
		        System.out.println("Time taken to complete Brute Force String Search(Smaller sized strings): "+(System.nanoTime()-start)+" Nanoseconds");
		        
		        start = System.nanoTime();
		        search(txt2, pat2); 
		        System.out.println("Time taken to complete Brute Force String Search(larger sized strings): "+(System.nanoTime()-start)+" Nanoseconds");
		        
		        
	}
	
    //Brute force approach
	public static void search(String txt, String pat) {
		int m=pat.length();
		int n=txt.length();
		
		for(int i=0;i<=n-m;i++) {
			int j;
			for(j=0;j<m;j++) 
				if(txt.charAt(i+j) != pat.charAt(j)) //search every index for the beginning of the pattern 1 by 1
					break;
				
				if(j==m)                                       //if j is equal to m the pattern exists at i
					System.out.println("Index of pattern : "+i);
			
		}
	}
	

}
