package algos;

import java.util.ArrayList;

//requires the list to be sorted
public class BinarySearch {
	boolean search(ArrayList<Object> pL, String pKey){
		int high = pL.size() - 1;
		int low = 0;
		int mid;
		
		while (low <= high){
			mid = (low + high) / 2;
			
	        if (pL.get(mid).toString().compareTo(pKey) < 0) {
	            low = mid + 1;
	        } else if (pL.get(mid).toString().compareTo(pKey) > 0) {
	            high = mid - 1;
	        } else {
	        	return true;
	        }
		}
		return false;
	}
}
