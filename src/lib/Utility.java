package lib;

public class Utility {

    public static int calculateAdjustedSalary(int grade, boolean isForeigner) {
        int salary = 0;
        switch (grade) {
            case 1:
                salary = 3000000;
                break;
            case 2:
                salary = 5000000;
                break;
            case 3:
                salary = 7000000;
                break;
            default:
                // Handle invalid grade
                break;
        }
        if (isForeigner) {
            salary *= 1.5;
        }
        return salary;
    }
}
