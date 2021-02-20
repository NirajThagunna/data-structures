package coreJavaPrograms;

public class SimpleLocation {
	
	private int id;
	private String name;
	
	public SimpleLocation(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public static void main(String[] args) {
		SimpleLocation loc = new SimpleLocation(80, "Niraj Thagunna");
		loc.name = "Niru";
		System.out.println(loc.name);
	}
}
