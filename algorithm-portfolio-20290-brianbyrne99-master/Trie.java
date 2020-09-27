

public class Trie{

// Alphabet size (# of symbols) we pick 26 for English alphabet
static final int ALPHABET_SIZE = 26; 


// class for Trie node 
static class TrieNode { 
TrieNode[] children = new TrieNode[ALPHABET_SIZE]; 
// isEndOfWord is true if the node represents end of a word i.e. leaf node
boolean isEndOfWord; 

TrieNode(){ 
isEndOfWord = false; 

for (int i = 0; i < ALPHABET_SIZE; i++) 
children[i] = null; 
} 
}

static TrieNode root;
// If not key present, inserts into trie 
// If the key is prefix of Trie node,  
//  marks leaf node
static void insert(String key){ 
   int idx;
   int size=key.length();
   TrieNode searcher = root;
   
   for(int i=0;i<size;i++) {
	   idx=key.charAt(i)-'a';
	   if(searcher.children[idx]==null)
		   searcher.children[idx]=new TrieNode();   //searches the existing tree for the available child space
	   
	   searcher=searcher.children[idx];  //moves through the tree
   }
	searcher.isEndOfWord=true;

} 

// Returns true if key presents in trie, else false 
static boolean search(String key) { 
	 int idx;
	   int size=key.length();
	   TrieNode searcher = root;
	   
	   for(int i=0;i<size;i++) {
		   idx=key.charAt(i)-'a';
		   if(searcher.children[idx]==null)
			   return false;               //key is not present in the current tree
		   
		   searcher=searcher.children[idx];  //moves through the tree
	   }
	   return searcher!=null && searcher.isEndOfWord;   //returns true only if the key exists in the tree  
} 


// Driver 
public static void main(String args[]) { 

// Input keys (use only 'a' through 'z' and lower case) 
String keys[] = {"bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver"};


String output[] = {"Not present in trie", "Present in trie"}; 

root = new TrieNode(); 

// Construct trie 
int i; 
for (i = 0; i < keys.length ; i++) {
insert(keys[i]); 
}
//Some tests to ensure the trie is working
long start=System.nanoTime();
if(search("bank") == true) 
    System.out.println("\"bank\" " + output[1]); 
else 
	System.out.println("\"bank\" "  + output[0]); 
System.out.println("Time taken to complete Trie Search: "+(System.nanoTime()-start)+" Nanoseconds");

start=System.nanoTime();
if(search("filter") == true) 
    System.out.println("\"filter\" " + output[1]); 
else 
	System.out.println("\"filter\" "  + output[0]); 
System.out.println("Time taken to complete Trie Search: "+(System.nanoTime()-start)+" Nanoseconds");

start=System.nanoTime();
if(search("silver") == true) 
    System.out.println("\"silver\" " + output[1]); 
else 
	System.out.println("\"silver\" "  + output[0]); 
System.out.println("Time taken to complete Trie Search: "+(System.nanoTime()-start)+" Nanoseconds");

//Tests to show failure
start=System.nanoTime();
if(search("brian") == true) 
    System.out.println("\"brian\" " + output[1]); 
else 
	System.out.println("\"brian\" "  + output[0]); 
System.out.println("Time taken to complete Trie Search: (failure) "+(System.nanoTime()-start)+" Nanoseconds");

start=System.nanoTime();
if(search("aardvark") == true) 
    System.out.println("\"aardvark\" " + output[1]); 
else 
	System.out.println("\"aardvark\" "  + output[0]); 
System.out.println("Time taken to complete Trie Search: (failure) "+(System.nanoTime()-start)+" Nanoseconds");





} 

//end of class
} 