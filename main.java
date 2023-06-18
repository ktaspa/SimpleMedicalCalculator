import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Medical Risk Calculator");
        System.out.println("Please enter the following information:");

        System.out.print("Age: ");
        int age = scanner.nextInt();

        System.out.print("Gender (M/F): ");
        String gender = scanner.next();

        System.out.print("Height (in cm): ");
        double height = scanner.nextDouble();

        System.out.print("Weight (in kg): ");
        double weight = scanner.nextDouble();

        // Calculate BMI
        double bmi = weight / ((height / 100) * (height / 100));

        // Calculate risk based on input factors
        String disease = calculateRisk(age, gender, bmi);

        System.out.println("Based on the provided information, you may be at risk of: " + disease);

        scanner.close();
    }

    public static String calculateRisk(int age, String gender, double bmi) {
        String disease = "";

        // Risk assessment algorithm
        if (age > 40 && gender.equalsIgnoreCase("M") && bmi >= 30) {
            disease = "Heart Disease";
        } else if (age > 50 && gender.equalsIgnoreCase("F") && bmi >= 25) {
            disease = "Type 2 Diabetes";
        } else if (age > 60 && gender.equalsIgnoreCase("M") && bmi >= 28) {
            disease = "Hypertension";
        } else {
            disease = "No significant risk identified";
        }

        return disease;
    }
}
