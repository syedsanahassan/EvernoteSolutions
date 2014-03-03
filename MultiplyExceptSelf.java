package evernote;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MultiplyExceptSelf {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("case.txt"));
        long prod = 1;
        int indexOfNumberThatWasZero = -1;
        int numofzeros = 0;
        
        try {
        	int inputSize = Integer.parseInt(br.readLine());
        	long a[] = new long[inputSize];
            for (int i=0;i<inputSize;i++) {
            	a[i] = Long.parseLong(br.readLine());
            	if (a[i] == 0) {
            		indexOfNumberThatWasZero = i;
            		numofzeros++;
            		if (numofzeros > 1)
            			break;
            	} else {
            		prod *= a[i];
            	}
            }
            
            if (numofzeros >= 2) {
            	for (int i=0;i<inputSize;i++) {
            		System.out.println(0);
            	}
            } else if (numofzeros == 1){
            	for (int i=0;i<inputSize;i++) {
            		if (i==indexOfNumberThatWasZero)
            			System.out.println(prod);
            		else
            			System.out.println(0);
            	}
            } else {
            	for (int i=0;i<inputSize;i++) {
            		System.out.println(prod/a[i]);
            	}
            }
        }
        finally {
            br.close();
        }
	}
}
