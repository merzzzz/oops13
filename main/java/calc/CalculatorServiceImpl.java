package calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created 13/10/2018
 * 
 * @author Mergin
 *
 */
public class CalculatorServiceImpl implements CalculatorService {

	ArrayList<Double> operands = new ArrayList<Double>();
	ArrayList<Character> operators = new ArrayList<Character>();

	/**
	 * This method is used to segregate operator and operand values from user
	 * input user input is provided as input
	 * 
	 * @return void
	 */
	public void segregateOperatorAndOperands(String[] userInputVal) {
		String number = Constants.NULL_STRING;
		String userInput = Arrays.toString(userInputVal);
		userInput = userInput.substring(1, userInput.length() - 1);
		for (int i = 0; i < userInput.length(); i++) {
			char num = userInput.charAt(i);
			try {
				if ((num == Constants.ADDITION || num == Constants.SUBTRACTION || num == Constants.MULTIPLICATION
						|| num == Constants.DIVISION)) {
					number = gatherOperators(number, num);
					number = Constants.NULL_STRING;;
				} else {
					number = gatherOperands(number, userInput, i, num);
				}
				// To notify user on entering invalid input
			} catch (Exception exception) {
				System.out.println("Invalid entry. Please enter valid Operands and Operators");
				System.exit(0);
			}
		}
	}

	/**
	 * This method is used to collect the numbers
	 * 
	 * @return String operands
	 */
	public String gatherOperands(String number, String userInput, int i, char num) {
		number += num;
		if (i == userInput.length() - 1) {
			operands.add(Double.parseDouble(number));
		}
		return number;
	}

	/**
	 * This method is used to collect operators
	 * 
	 * @return String operators
	 */
	public String gatherOperators(String number, char num) {
		operators.add(num);
		operands.add(Double.parseDouble(number));
		return number;
	}

	/**
	 * This method performs addition, subtraction, multiplication, division,
	 * square of number and square root operators and operands are provided as
	 * inputs to perform operation
	 * 
	 * @return ArrayList<Double>
	 */
	public double performCalculation() {
		try {
			performDivision();
			performMultiplication();
			prioritiseAdditionAndSubtraction();
			performAddition();
			performSubtraction();
		} catch (Exception e) {
			System.out.println("Exception while performing calculation");
		}
		return operands.size() > 0 ? operands.get(0) : 0;
	}

	/**
	 * This method performs calculator subtraction
	 * 
	 * @return void
	 */
	public double performSubtraction() {
		int indexSub;
		double output = 0;
		while ((indexSub = operators.indexOf(Constants.SUBTRACTION)) != -1) {
			output = operands.get(indexSub) - operands.get(indexSub + 1);
			resetValues(indexSub, output);
		}
		return output;
	}

	/**
	 * This method performs calculator Addition
	 * 
	 * @return void
	 */
	public double performAddition() {
		int indexAdd;
		double output = 0;
		while ((indexAdd = operators.indexOf(Constants.ADDITION)) != -1) {
			output = operands.get(indexAdd) + operands.get(indexAdd + 1);
			resetValues(indexAdd, output);
		}
		return output;
	}

	/**
	 * This method performs calculator multiplication
	 * 
	 * @return void
	 */
	public double performMultiplication() {
		int indexMul;
		double output = 0;
		while ((indexMul = operators.indexOf(Constants.MULTIPLICATION)) != -1) {
			output = operands.get(indexMul) * operands.get(indexMul + 1);
			resetValues(indexMul, output);
		}
		return output;
	}

	/**
	 * This method performs calculator division
	 * 
	 * @return void
	 */
	public double performDivision() {
		int indexDiv;
		double output = 0;
		while ((indexDiv = operators.indexOf(Constants.DIVISION)) != -1) {
			output = operands.get(indexDiv) / operands.get(indexDiv + 1);
			resetValues(indexDiv, output);
		}
		return output;
	}

	/**
	 * This method decides whether to prioritize Addition or Subtraction
	 * 
	 * @return void
	 */
	public double prioritiseAdditionAndSubtraction() {
		int indexAdd;
		int indexSub;
		double output = 0;
		while ((indexAdd = operators.indexOf(Constants.ADDITION)) != -1
				&& (indexSub = operators.indexOf(Constants.SUBTRACTION)) != -1) {

			if (indexAdd < indexSub) {
				output = operands.get(indexAdd) + operands.get(indexAdd + 1);
				resetValues(indexAdd, output);
			} else if (operators.indexOf(Constants.SUBTRACTION) < operators.indexOf(Constants.ADDITION)) {
				output = operands.get(indexSub) - operands.get(indexSub + 1);
				resetValues(indexSub, output);
			}

		}
		return output;
	}

	/**
	 * This method is used to reset the instance of operators and operands
	 * 
	 * @return void
	 */
	public void resetValues(int index, Double output) {
		operators.remove(index);
		operands.remove(index);
		operands.remove(index);
		operands.add(index, output);
	}

	public ArrayList<Double> getOperands() {
		return operands;
	}

	public void setOperands(ArrayList<Double> operands) {
		this.operands = operands;
	}

	public ArrayList<Character> getOperators() {
		return operators;
	}

	public void setOperators(ArrayList<Character> operators) {
		this.operators = operators;
	}

}