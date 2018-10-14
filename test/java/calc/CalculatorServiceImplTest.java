/**
 * 
 */
package calc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

import junit.framework.Assert;

/**
 * Created 14/10/2018
 * 
 * @author Mergin
 *
 */
public class CalculatorServiceImplTest {

	@Test
	public void gatherOperandsCheck() {
		CalculatorServiceImpl calcServ = new CalculatorServiceImpl();
		Assert.assertEquals("", "9", calcServ.gatherOperands("", "9*8", 0, '9'));
	}

	@Test
	public void gatherOperatorsCheck() {
		CalculatorServiceImpl calcServ = new CalculatorServiceImpl();
		Assert.assertEquals("", "123", calcServ.gatherOperators("123",'1'));
	}
	
	@Test
	public void performSubtractionTest() {
		CalculatorServiceImpl calcServ = new CalculatorServiceImpl();
		ArrayList<Double> operands= new ArrayList<Double>();
		ArrayList<Character> operators= new ArrayList<Character>();
		operands.add(100.0);
		operands.add(97.0);
		operators.add('-');
		calcServ.setOperands(operands);
		calcServ.setOperators(operators);
		Assert.assertEquals("", 3.0, calcServ.performSubtraction());
	}
	
	@Test
	public void performAdditionTest() {
		CalculatorServiceImpl calcServ = new CalculatorServiceImpl();
		ArrayList<Double> operands= new ArrayList<Double>();
		ArrayList<Character> operators= new ArrayList<Character>();
		operands.add(8.0);
		operands.add(5.0);
		operators.add('+');
		calcServ.setOperands(operands);
		calcServ.setOperators(operators);
		Assert.assertEquals("", 13.0, calcServ.performAddition());
	}
	@Test
	public void performMultiplicationTest() {
		CalculatorServiceImpl calcServ = new CalculatorServiceImpl();
		ArrayList<Double> operands= new ArrayList<Double>();
		ArrayList<Character> operators= new ArrayList<Character>();
		operands.add(9.0);
		operands.add(5.0);
		operators.add('*');
		calcServ.setOperands(operands);
		calcServ.setOperators(operators);
		Assert.assertEquals("", 45.0, calcServ.performMultiplication());
	}
	@Test
	public void performDivisionTest() {
		CalculatorServiceImpl calcServ = new CalculatorServiceImpl();
		ArrayList<Double> operands= new ArrayList<Double>();
		ArrayList<Character> operators= new ArrayList<Character>();
		operands.add(10.0);
		operands.add(5.0);
		operators.add('/');
		calcServ.setOperands(operands);
		calcServ.setOperators(operators);
		Assert.assertEquals("", 2.0, calcServ.performDivision());
	}
	
}
