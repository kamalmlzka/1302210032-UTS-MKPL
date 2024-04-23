package lib;

public class TaxFunction {
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
}
