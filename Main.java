package algos;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	
	private int option;
	private Scanner scan = new Scanner(System.in);
	
	private void menu(){
		System.out.println("Enter the full path to the data file you'd like to use: ");
		String filename = scan.nextLine();	
		System.out.println("");
		System.out.println(" ============Welcome!============ ");
		System.out.println("| 1. Linear Search                |");
		System.out.println("| 2. Binary Search                |");
		System.out.println("| 3. Quick Sort                   |");
		System.out.println("| 4. Selection Sort               |");
		System.out.println("| 5. Insertion Sort               |");
		System.out.println("| 6. Merge Sort                   |");
		System.out.println("| 7. Heap Sort                    |");
		System.out.println("| 8. Hash Tables                  |");
		System.out.println("| 9. Disjoint Sets                |");
		System.out.println("| 10. Binary Search Tree          |");
		System.out.println("==================================");
		System.out.println("");
		String input = "";
		int val = -1;
		boolean validChoice = false;
		while(!validChoice){
			System.out.println("Enter choice from 0 - 10 (0 to exit): ");
			input = scan.nextLine();
			if (input != "" && isNumeric(input)){
				val = Integer.parseInt(input);
				if (val >= 0 && val <= 10){
					validChoice = true;
					option = val;
				} 
			} else {
				System.out.println("!!! Error: Enter a valid choice !!!");
			}
		}
		DataGrabber d = new DataGrabber();

		switch(option){
			case 1 : {
				String searchTerm = "";
				System.out.println("Enter they key you would like to search for: ");
				searchTerm = scan.next();
				ArrayList<Object> l = d.loadData(0, filename);
				LinearSearch lS = new LinearSearch();
				System.out.println(lS.search(l, searchTerm));
				break;
			} case 2 : {
				String searchTerm = "";
				System.out.println("Enter they key you would like to search for: ");
				searchTerm = scan.next();
				//binary search requires the data to be sorted
				ArrayList<Object> t = d.loadData(0, filename);
				QuickSort qS = new QuickSort();
				ArrayList<Object> l = qS.LomutoQSMo3(t, 0, t.size() - 1);
				BinarySearch bS = new BinarySearch();
				System.out.println(bS.search(l, searchTerm));
				break;
			} case 3: {
				ArrayList<Object> l = d.loadData(4, filename);
				QuickSort qS = new QuickSort();
				System.out.println(qS.LomutoQSMo3(l, 0, l.size() - 1));
				break;
			}
		}
		scan.close();
	}
	
	public static void main(String args[]) {
		Main m = new Main();
		m.menu();
	}
	
	private boolean isNumeric(String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}  
}