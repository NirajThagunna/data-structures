package coreJavaPrograms;

public class AlgorithmOfSuccess {
	public static void tryAgain() {
		System.out.println("Work Hard!");
	}
	public static void main(String[] args) {
		try {
			boolean success = false;
			
			while (!success) {
				tryAgain();
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
