import java.util.Scanner;

public class GradingSystem {
	public static void main(String[] args) {
		System.out.print("Enter your mark: ");
		Scanner scanner = new Scanner(System.in);
		float mark = scanner.nextFloat();
		String grade = "";
		
		if (mark >= 80 && mark <= 100) grade = "A+";
		else if (mark >= 75 && mark <= 79) grade = "A";
		else if (mark >= 70 && mark <= 74) grade = "A-";
		else if (mark >= 65 && mark <= 69) grade = "B+";
		else if (mark >= 60 && mark <= 64) grade = "B";
		else if (mark >= 55 && mark <= 59) grade = "B-";
		else if (mark >= 50 && mark <= 54) grade = "C+";
		else if (mark >= 45 && mark <= 49) grade = "C";
		else if (mark >= 40 && mark <= 44) grade = "D";
		else if (mark >= 0 && mark < 40) grade = "F";
		else System.out.println("Invalid Mark!");
		
		if (grade != "") System.out.printf("With %.2f marks you got %s grade!", mark, grade);
	}
}
