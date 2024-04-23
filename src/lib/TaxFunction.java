package lib;

public class TaxFunction {
	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
        int taxableIncome = calculateTaxableIncome(monthlySalary, otherMonthlyIncome, numberOfMonthWorking, deductible, isMarried, numberOfChildren);
        return calculateTaxAmount(taxableIncome);
    }

	private static int calculateTaxableIncome(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
        // Calculate taxable income based on the adjusted monthly salary and other parameters
    }

    public static int calculateTax(TaxCalculationInput input) {
        int taxableIncome = calculateTaxableIncome(input);
        int tax = calculateTaxAmount(taxableIncome);
        return tax;
    }

    private static int calculateTaxableIncome(TaxCalculationInput input) {
        int totalIncome = (input.getMonthlySalary() + input.getOtherMonthlyIncome()) * input.getNumberOfMonthWorking();
        int taxFreeAllowance = calculateTaxFreeAllowance(input);
        return totalIncome - input.getDeductible() - taxFreeAllowance;
    }

    private static int calculateTaxFreeAllowance(TaxCalculationInput input) {
        int taxFreeAllowance = 54000000;
        if (input.isMarried()) {
            taxFreeAllowance += 4500000;
        }
        taxFreeAllowance += Math.min(input.getNumberOfChildren(), 3) * 1500000;
        return taxFreeAllowance;
    }

    private static int calculateTaxAmount(int taxableIncome) {
        double taxRate = 0.05;
        int tax = (int) Math.round(taxRate * taxableIncome);
        return Math.max(tax, 0);
    }

	public static int calculateTax(int grade, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren, boolean isForeigner) {
        int monthlySalary = Utility.calculateAdjustedSalary(grade, isForeigner);
        return calculateTax(monthlySalary, otherMonthlyIncome, numberOfMonthWorking, deductible, isMarried, numberOfChildren);
    }
}
