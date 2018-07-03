package ispit_zad_7_v2;

public class Student {

	private String first;
	private String last;
	private int id;
	private String dep;
	private String cit;

	public Student(String first, String last, int id, String dep, String cit) {
		this.first = first;
		this.last = last;
		this.id = id;
		this.dep = dep;
		this.cit = cit;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getCit() {
		return cit;
	}

	public void setCit(String cit) {
		this.cit = cit;
	}

}
