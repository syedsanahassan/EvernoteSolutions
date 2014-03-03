package evernote;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CircularBuffer {

	static int indexAdd = 0, indexRemove = 0, bufferSize = 0, noOfElementsAdded = 0;
	static BufferedReader br = null;
	public static void main(String[] args) throws Exception {
		 br = new BufferedReader(new InputStreamReader(System.in));
        
        try {
        	bufferSize = Integer.parseInt(br.readLine());
            String[] buf = new String[bufferSize];
            String line = null;
            while(true) {
            	line = br.readLine();
                if (line.startsWith("A")) {
                	add(buf, line);
                } else if (line.startsWith("R")) {
                	remove(buf, line);
                } else if (line.startsWith("L")) {
                	list(buf);
                } else if (line.startsWith("Q")) {
                	return;
                }
            }
        }
        finally {
            br.close();
        }
	}
	
	static void add(String[] buf, String data) throws Exception {
		String[] d = data.split(" ");
		int n = Integer.parseInt(d[1]);
		String line = null;
		for (int i=0;i<n;i++) {
			line = br.readLine();
			
			if (buf[indexAdd] != null) 
				indexRemove++;
			
			buf[indexAdd++] = line;
			
			if (noOfElementsAdded < bufferSize)
				noOfElementsAdded++;
			
			if (indexAdd > bufferSize - 1)
				indexAdd %= bufferSize;
			
			if (indexRemove > bufferSize - 1)
				indexRemove %= bufferSize;
		}
	}
	
	static void remove(String[] buf, String data) {
		String[] d = data.split(" ");
		if (bufferSize ==0) return;
		int toRemove = Integer.parseInt(d[1]);
		
		while (toRemove-- > 0 && noOfElementsAdded > 0) {
			buf[indexRemove++] = null;
		
			if (noOfElementsAdded > 0)
				noOfElementsAdded--;
			
			if (indexRemove > bufferSize - 1)
				indexRemove %= bufferSize;
		}
	}
	
	static void list(String[] buf) {
		if (bufferSize ==0) return;
		int i = indexRemove;
		while (i < bufferSize && buf[i] != null) {
			System.out.println(buf[i]);
			i++;
		}
		i %= bufferSize;
		while (i < indexRemove && buf[i] != null) {
			System.out.println(buf[i]);
			i++;
		}
	}
}
