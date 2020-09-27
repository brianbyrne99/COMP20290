
public class KMPsearch {


	public static void main(String[] args) {
		//testing strings of various lengths
		  String txt = "ABABDABACDABABCABAB"; 
	        String pat = "ABABCABAB"; 
	        String txt1 = "JAVAJAVAJ";
		    String pat1 = "JAVA";
		    String txt2 = "ahahahahaahahahahahaahahahaahhhaaahaha";
		    String pat2 = "aha";
	        
	        long start=System.nanoTime();
	        new KMPsearch().KMPSearch(pat, txt);
	        System.out.println("Time taken to complete KMP Search: (Medium sized entry) "+(System.nanoTime()-start)+" Nanoseconds");
	        
	        start=System.nanoTime();
	        new KMPsearch().KMPSearch(pat1, txt1);
	        System.out.println("Time taken to complete KMP Search: (smaller sized entry) "+(System.nanoTime()-start)+" Nanoseconds");
	        
	        start=System.nanoTime();
	        new KMPsearch().KMPSearch(pat2, txt2);
	        System.out.println("Time taken to complete KMP Search: (larger sized entry) "+(System.nanoTime()-start)+" Nanoseconds");
         
	}
	
	//Knuth-Morris-Pratt Algorithm

	void KMPSearch(String pat, String txt) 
    { 
        int M = pat.length(); 
        int N = txt.length(); 
  
        // create lps[] that will hold the longest 
        // prefix suffix values for pattern 
        int lps[] = new int[M]; 
        int j = 0; // index for pat[] 
  
        // Preprocess the pattern (calculate lps[] 
        // array) 
        computeLPSArray(pat, M, lps);
        int i=0;
        while(i<N) {
        	if(pat.charAt(j) == txt.charAt(i)) {    
        		i++;
        		j++;
        	}
        	
        	if(j==M) {                                         // if j is equal to length of pattern, than pattern beginning is present j places back
        		System.out.println("Index of pattern : "+(i-j));
        		j=lps[j-1];
        	}
        	
        	else if(i<N && pat.charAt(j) != txt.charAt(i) ){  //i<N stops out of bounds char comparisons
        		 if (j != 0)                              //pattern is not present
                     j = lps[j - 1]; 
                 else
                     i = i + 1;
        	}
        }
        
    }
	
	 void computeLPSArray(String pat, int M, int lps[]) 
	    { 
	        // length of the previous longest prefix suffix 
	        int len = 0; 
	        int i = 1; 
	        lps[0] = 0; // lps[0] is always 0 
	  
	        // the loop calculates lps[i] for i = 1 to M-1 
	        while (i < M) { 
	            if (pat.charAt(i) == pat.charAt(len)) { 
	                len++; 
	                lps[i] = len; 
	                i++; 
	            } 
	            else // (pat[i] != pat[len]) 
	            { 
	                // This is tricky. Consider the example. 
	                // AAACAAAA and i = 7. The idea is similar 
	                // to search step. 
	                if (len != 0) { 
	                    len = lps[len - 1]; 
	  
	                    // Also, note that we do not increment 
	                    // i here 
	                } 
	                else // if (len == 0) 
	                { 
	                    lps[i] = len; 
	                    i++; 
	                } 
	            } 
	        } 
	    } 
}



