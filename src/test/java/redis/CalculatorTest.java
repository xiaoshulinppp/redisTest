package redis;

import static org.junit.Assert.*;//静态包含，调用包含累的静态方法时就不用写类名了。

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;//还得手动引入
import org.junit.runners.Parameterized.Parameters;//还得手动引入。
@RunWith(Parameterized.class)
public class CalculatorTest {
	private static Calculator calculator = new Calculator();//首先建立一个测试类的实例。
	private int param;
	private int result;
	@Parameters   
	public static Collection data() {
	        return Arrays.asList(new Object[][]{
	                {2, 4},
	                {0, 4},
	                {-3, 9},
	        });
	}
	//构造函数，对变量进行初始化
	public CalculatorTest(int param, int result) {
	        this.param = param;
	        this.result = result;
	}
	@Before
	public void setUp() throws Exception {
		calculator.clear();//每一个测试方法执行前都回先执行这个。
	}

	@Test
	public void testAdd() {//测试中的测试方法不能有输入参数，返回值必须是void。
		//calculator.add(2);
        //calculator.add(3);
        //assertEquals(5, calculator.getResult());//调用测试类的结果比较，看方法结果是否一致
		calculator.add(param);
        assertEquals(result, calculator.getResult());
	
	
	}

	/*@Test
	public void testSubstract() {
		 calculator.add(10);
	        calculator.substract(2);
	        assertEquals(8, calculator.getResult());
	}

	@Test
	public void testMultiply() {
		fail("Not yet implemented");
	}

	@Test
	public void testDivide() {
		 calculator.add(8);
	        calculator.divide(2);
	        assertEquals(4, calculator.getResult());
	}*/
//如果“在任何测试执行之后需要进行的收尾工作”也是一个Fixture，使用@After来标注
}
