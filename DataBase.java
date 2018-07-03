package ispit_zad_7_v2;

import java.util.HashMap;

public class DataBase {

	private static HashMap<Integer, Student> baza = new HashMap<>();

	public DataBase() {
		
	}

	public void addToBase(Student st, int id) {
		baza.put(id, st);
	}

	public static HashMap<Integer, Student> getBaza() {
		return baza;
	}


	
	
}
