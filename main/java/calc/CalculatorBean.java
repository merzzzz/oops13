package calc;

/**
 * Created 13/10/2018
 * 
 * @author Mergin
 *
 */

public class CalculatorBean {
	public static void main(String[] args) {
		CalculatorService calculatorService = new CalculatorServiceImpl();
		calculatorService.segregateOperatorAndOperands(args);
		Double output = calculatorService.performCalculation();
		System.out.println("output : " + output);
	}
}