package evernote;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class FrequentTerms {

	public static void main(String[] args) throws Exception{

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("case.txt"));
        try {
        	int setSize = Integer.parseInt(br.readLine());
        	
            for (int i=0;i<setSize;i++) {
                String s = br.readLine();
                if (map.containsKey(s)) {
                	int val = map.get(s);
                	map.put(s, val+1);
                } else {
                	map.put(s, 1);
                }
            }
            int k = Integer.parseInt(br.readLine());
    	    
            ArrayList<Map.Entry<String, Integer>> topKItems = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
            Collections.sort(topKItems, new Comparator<Map.Entry<String, Integer>>() {
				@Override
				public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
					if (e1.getValue() == e2.getValue()) {
						return e1.getKey().compareTo(e2.getKey());
					} else {
						return e2.getValue().compareTo(e1.getValue());
					}
				}
			});
            Iterator<Map.Entry<String, Integer>> it = topKItems.iterator();
            while(it.hasNext() && k > 0) {
            	Entry<String, Integer> e = it.next();
            	System.out.println(e.getKey());
            	k--;
            }
        }
        finally {
            br.close();
        }
	}
}
