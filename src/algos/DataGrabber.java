package algos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DataGrabber {
	//public ArrayList<Object> list = new ArrayList<>( );
	private static final char DEFAULT_DELIMITER = ',';
	private static final String DEFAULT_FILE = "C:/Users/geoff/Google Drive/workspace/data/bible.txt";

	public ArrayList<Object> loadData(int option){
		return loadData(option,DEFAULT_FILE);
	}
	
	public ArrayList<Object> loadData(String filename){
		return loadData(0,filename);
	}
	
	public ArrayList<Object> loadData(int option, String filename){
		return loadData(option,filename,DEFAULT_DELIMITER);
	}
	
	public ArrayList<Object> loadData(int option, String filename, char delimiter){
		String data = ""; 
		try { 
			data = new String(Files.readAllBytes(Paths.get(filename))); 
		} catch (IOException e) { 
			//e.printStackTrace();\
			System.out.println("!!! ERROR: No such file found !!! Exiting ... ");
		} 
		ArrayList<Object> list;
		switch(option){
			case 0: { //words split by " "
				list = new ArrayList<Object>();
				for (String val : data.split(Character.toString(DEFAULT_DELIMITER))){
					list.add(val);
				}
				return list;
			} case 1: { //words split by custom delimiter (ie comma)
				list = new ArrayList<Object>();
				for (String val : data.split(Character.toString(delimiter))){
					list.add(val.trim());
				}
				return list;
			} case 2: { //words split by whitespace, case insensitive, no leading or trailing punctuation
				list = cleanCaseAndPuncList(data);
				return list;
			} case 3: {//words split by custom delimiter, case insensitive, no leading or trailing punctuation
				list = cleanCaseAndPuncList(data, delimiter);
				return list;
			} case 4: {//unique words split by whitespace, case insensitive, and no leading or trailing punctuation
				ArrayList<Object> tempList = cleanCaseAndPuncList(data);
				Set<Object> tempSet = new HashSet<Object>(tempList);
				list = new ArrayList<Object>(tempSet);
				return list;
			} case 5: {//unique words split by custom delimiter and case insensitive
				ArrayList<Object> tempList = new ArrayList<Object>();
				data = data.toLowerCase();
				for (String val : data.split(Character.toString(delimiter))){
					tempList.add(val);
				}
				Set<Object> tempSet = new HashSet<Object>(tempList);
				list = new ArrayList<Object>(tempSet);
				return list;
			}
		}
		list = new ArrayList<Object>();
		return list;
	}
	
	//Returns list from string with no leading or trailing punctuation
	//Interior punctuation remains (ie can't)
	public ArrayList<Object> cleanCaseAndPuncList(String s){
		ArrayList<Object> l = new ArrayList<>();
    	s = s.toLowerCase();
    	boolean start= false;
    	boolean end = false;
    	int left = -1;
    	int right = -1;
        for (int i = 0; i < s.length(); i++) {  // get list of strings
        	if (start == false && Character.isLetterOrDigit(s.charAt(i))){
        		start = true;
        		left = i;
        		right = i;
        	} else if (start == true && Character.isLetterOrDigit(s.charAt(i))) {
        		right = i;
        	} else if (start == true && end == false && Character.isWhitespace(s.charAt(i))){
        		end = true;
        	}
        	if (start == true && end == true){
        		l.add(s.substring(left, right+1));  // add to list
        		start = false;
        		end = false;
        	}
        }
		return l;
	}
	
	//Returns list from string with no leading or trailing punctuation
	//Interior punctuation remains (ie can't)
	public ArrayList<Object> cleanCaseAndPuncList(String s, char delimiter){
		ArrayList<Object> l = new ArrayList<>();
    	s = s.toLowerCase();
    	boolean start= false;
    	boolean end = false;
    	int left = -1;
    	int right = -1;
        for (int i = 0; i < s.length(); i++) {  // get list of strings
        	if (start == false && Character.isLetterOrDigit(s.charAt(i))){
        		start = true;
        		left = i;
        		right = i;
        	} else if (start == true && Character.isLetterOrDigit(s.charAt(i))) {
        		right = i;
        	} else if (start == true && end == false && s.charAt(i) == delimiter){
        		end = true;
        	}
        	if (start == true && end == true){
        		l.add(s.substring(left, right+1));  // add to list
        		start = false;
        		end = false;
        	}
        }
		return l;
	}
}