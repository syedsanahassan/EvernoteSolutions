package evernote;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class TopFour {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("case.txt"));
        int k = 4;
        try {
        	int arraySize = Integer.parseInt(br.readLine());
        	int[] array = new int[arraySize];
            for (int i=0;i<arraySize;i++) {
                array[i] = Integer.parseInt(br.readLine());
            }
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            
    	    for (int x : array) { 
    	        if (pq.size() < k) pq.add(x);
    	        else if (pq.peek() < x) {
    	            pq.poll();
    	            pq.add(x);
    	        }
    	    }
    	    
    	    int res[] = new int[k];
    	    for (int i=0;i<k;i++) 
    	    	res[i]=pq.poll();
    	    for (int i=k-1;i>=0;i--) 
    	    	System.out.println(res[i]);
    	    
        }
        finally {
            br.close();
        }
	}

}
