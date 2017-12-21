package MyFirstTestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class OurCoolTest {

    /*@BeforeMethod
    public void before() {
        System.out.println("Before method");
    }*/

    /**
     * Данный метод использует параметризацию.
     * Суть:А если класс Calculator станет принимать в конструкторе не 2, а 3 параметра?
     * Придется пройтись по всем 400 методов и поправить везде код. Не лень? Да и сколько времени потребуется потратить.
     * А каково будет разобраться в том, какие реально варианты проверяются, а какие нет?
     * Дойдя до пятидесятого метода можно уже и забыть, а что было в первом?
     * @return
     */
    @DataProvider(name = "calculatorDataProvider")
    public Object[][] simpleDataProvider() {
        return new Object[][]{
                {2, 2, 4},
                {2, 0, 0},
                {-1, 2, -2},
                {0, 2, 0}
        };
    }

    @Test(dataProvider = "calculatorDataProvider")
    public void checkParameters(int firstParam, int secondParam, int expectedResult) {
        Calculator calculator = new Calculator(firstParam, secondParam);
        int result = calculator.getResult();
        /**
         * метод assertTrue проверяет, что переданное условие равно true, и если это не так - выводится сообщение.
         */
        assertTrue("Результат(" + result + ") не равен " + expectedResult, result == expectedResult);
        //assertFalse("Результат(" + result + ") не равен " + expectedResult, result == expectedResult);
    }

    /*@AfterMethod
    public void after() {
        System.out.println("After method");
    }*/
}