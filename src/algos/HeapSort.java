package algos;

import java.util.ArrayList;
import java.util.Collections;

public class HeapSort {

	private int parent(int i){
		return i / 2;
	}
	
	private int left(int i){
		return i * 2;
	}
	
	private int right(int i){
		return (i * 2) + 1;
	}
	
	public void maxHeapify(ArrayList<Object> pL, int i){
		int l = left(i);
		int r = right(i);
		int largest = 0;
		if (l < pL.size() && pL.get(l).toString().compareTo(pL.get(i).toString()) > 0){
			largest = l;
		} else {
			largest = i;
		}
		if (r < pL.size() && pL.get(r).toString().compareTo(pL.get(largest).toString()) > 0){
			largest = r;
		} 
		if (largest != r) {
			Collections.swap(pL, i, largest);
			maxHeapify(pL, largest);
		}
	}
	
	public void buildMaxHeap(ArrayList<Object> pL){
		for (int i = pL.size() / 2; i > 0; i--){
			maxHeapify(pL, i);
		}
	}
	
	public void heapIncreaseKey(ArrayList<Object> pL, int i, Object key){
		if (pL.get(i).toString().compareTo(key.toString()) < 0){
			System.out.println("!!! Error: new key is smaller than current key !!!");
		}
		pL.set(i, key);
		while (i > 0 && pL.get(parent(i)).toString().compareTo(pL.get(i).toString()) < 0){
			Collections.swap(pL, i, parent(i));
			i = parent(i);
		}
	}
	
	public void maxHeapInsert(ArrayList<Object> pL, Object key){
		pL.add("");
		heapIncreaseKey(pL, pL.size() - 1, key);
	}
	
	public void heapSort(ArrayList<Object> pL){
		for (int i = pL.size() - 1; i > 1; i--){
			Collections.swap(pL, 0, i);
			maxHeapify(pL, 0);
		}
	}
	
	public Object heapMax(ArrayList<Object> pL){
		return pL.get(0);
	}
	
	public Object heapExtractMax(ArrayList<Object> pL){
		if (pL.size() < 0){
			System.out.println("!!! Error: Heap underflow !!!");
		}
		Object max = pL.get(0);
		pL.set(0, pL.get(pL.size() - 1));
		maxHeapify(pL, 0);
		return max;
	}
		
}
