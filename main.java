import java.util.Scanner;

public class MedicalRiskCalculator {
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

        System.out.print("Do you smoke? (Y/N): ");
        String smokeInput = scanner.next();
        boolean smoke = smokeInput.equalsIgnoreCase("Y");

        System.out.print("Do you have a family history of heart disease? (Y/N): ");
        String familyHistoryInput = scanner.next();
        boolean familyHistory = familyHistoryInput.equalsIgnoreCase("Y");

        // Calculate BMI
        double bmi = calculateBMI(height, weight);

        // Calculate risk based on input factors
        String disease = calculateRisk(age, gender, bmi, smoke, familyHistory);

        System.out.println("Based on the provided information, you may be at risk of: " + disease);

        scanner.close();
    }

    public static double calculateBMI(double height, double weight) {
        return weight / ((height / 100) * (height / 100));
    }

    public static String calculateRisk(int age, String gender, double bmi, boolean smoke, boolean familyHistory) {
        String disease = "";

        // Risk assessment algorithm
        if (age > 40 && gender.equalsIgnoreCase("M") && bmi >= 30 && smoke && familyHistory) {
            disease = "Heart Disease";
        } else if (age > 50 && gender.equalsIgnoreCase("F") && bmi >= 25 && smoke && familyHistory) {
            disease = "Type 2 Diabetes";
        } else if (age > 60 && gender.equalsIgnoreCase("M") && bmi >= 28 && smoke && familyHistory) {
            disease = "Hypertension";
        } else if (age > 45 && gender.equalsIgnoreCase("F") && bmi >= 28 && smoke && familyHistory) {
            disease = "Breast Cancer";
        } else if (age > 55 && gender.equalsIgnoreCase("M") && bmi >= 28 && smoke && familyHistory) {
            disease = "Prostate Cancer";
        } else if (age > 40 && gender.equalsIgnoreCase("M") && bmi >= 25 && smoke && !familyHistory) {
            disease = "Lung Cancer";
        } else if (age > 30 && gender.equalsIgnoreCase("F") && bmi >= 25 && smoke && !familyHistory) {
            disease = "Cervical Cancer";
        } else {
            disease = "No significant risk identified";
        }

        return disease;
    }
}