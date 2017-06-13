package algos;

import java.util.ArrayList;

public class LinearSearch {
	boolean search(ArrayList<Object> pL, String pKey){
		//using ArrayList.contains()
		//return pL.contains(pKey);
		for (int i = 0; i < pL.size(); i++){
			if (pL.get(i).equals(pKey))
				return true;
		}
		return false;
	}
}
