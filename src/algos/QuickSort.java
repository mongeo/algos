package algos;

import java.util.ArrayList;
import java.util.Collections;

public class QuickSort {

	public ArrayList<Object> lomutoQS(ArrayList<Object> pL, int lo, int hi){
		if (lo < hi){
			int pIndex = lomutoPartition(pL, lo, hi);
			lomutoQS(pL, lo, pIndex - 1);
			lomutoQS(pL, pIndex + 1, hi);
		}
		return pL;
	}
	
	private int lomutoPartition(ArrayList<Object> pL, int lo, int hi){
		Object pivotElement = pL.get(hi);  //x
		int i = lo - 1;
		for (int j = lo; j < hi; j++){
			if (pL.get(j).toString().compareTo(pivotElement.toString()) <= 0){
				i++;
				Collections.swap(pL, i, j);
			}
		}
		Collections.swap(pL, i + 1, hi);
		return i + 1;
	}
	
	public ArrayList<Object> lomutoQSMo3(ArrayList<Object> pL, int lo, int hi){
		if (lo < hi){
			int pIndex = lomutoPartitionMo3(pL, lo, hi);
			lomutoQS(pL, lo, pIndex - 1);
			lomutoQS(pL, pIndex + 1, hi);
		}
		return pL;
	}
	
	private int lomutoPartitionMo3(ArrayList<Object> pL, int lo, int hi){
		Object pivotElement = medianOf3(pL, lo, hi);  //x
		int i = lo - 1;
		for (int j = lo; j < hi; j++){
			if (pL.get(j).toString().compareTo(pivotElement.toString()) <= 0){
				i++;
				Collections.swap(pL, i, j);
			}
		}
		Collections.swap(pL, i + 1, hi);
		return i + 1;
	}
	
	private Object medianOf3(ArrayList<Object> pL, int lo, int hi){
		int center = (lo + hi) / 2;
		if (pL.get(lo).toString().compareTo(pL.get(center).toString()) > 0){
			Collections.swap(pL, lo, center);
		}	
		if (pL.get(lo).toString().compareTo(pL.get(hi).toString()) > 0){
			Collections.swap(pL, lo, hi);
		}
		if (pL.get(center).toString().compareTo(pL.get(hi).toString()) > 0){
			Collections.swap(pL, center, hi);
		}
		Collections.swap(pL, center, hi - 1);
		return pL.get(hi - 1);
	}
}


