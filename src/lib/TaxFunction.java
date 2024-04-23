package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	
	 public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
		int taxableIncome = calculateTaxableIncome(monthlySalary, otherMonthlyIncome, numberOfMonthWorking, deductible, isMarried, numberOfChildren);
		int tax = calculateTaxAmount(taxableIncome);
		return tax;
	}
	
	private static int calculateTaxableIncome(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
		int totalIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
		int taxFreeAllowance = calculateTaxFreeAllowance(isMarried, numberOfChildren);
		return totalIncome - deductible - taxFreeAllowance;
	}
	
	private static int calculateTaxFreeAllowance(boolean isMarried, int numberOfChildren) {
		int taxFreeAllowance = 54000000;
		if (isMarried) {
			taxFreeAllowance += 4500000;
		}
		taxFreeAllowance += Math.min(numberOfChildren, 3) * 1500000;
		return taxFreeAllowance;
	}
	
	private static int calculateTaxAmount(int taxableIncome) {
		double taxRate = 0.05;
		int tax = (int) Math.round(taxRate * taxableIncome);
		return Math.max(tax, 0); // Ensure tax is non-negative
	}	
	
}
