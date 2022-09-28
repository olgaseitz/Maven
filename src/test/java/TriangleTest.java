import HW4.NegativeOrNullTriangleSideException;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import HW4.TriangleFunction;
import static HW4.TriangleCalculation.calculateTriangleSquare;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class TriangleTest {
    TriangleFunction triangleFunction=new TriangleFunction();
    private static Logger logger= LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAll(){
        logger.info("Выполнится перед всем тестовым набором");
    }

    @BeforeEach
    void setUp(){
        logger.info("Выполниться перед каждым тестом");
    }
    @Test
    @DisplayName("Первая позитивная проверка")
    void positiveSquareCalcTest1() throws NegativeOrNullTriangleSideException {
        double result = calculateTriangleSquare(5, 5, 5);
        Assertions.assertEquals(10.825317547305483, result);
    }

    @Test
    @DisplayName("Вторая позитивная проверка")
    void positiveSquareCalcTest2() throws NegativeOrNullTriangleSideException {
        double result = calculateTriangleSquare(2, 4, 5);
        Assertions.assertEquals(3.872983346207417, result);
    }

    @Test
    @DisplayName("Первая негативная проверка")
    void negativeSquareCalcTest1() {
        boolean result= triangleFunction.main(3);
        Assertions.assertFalse(result,"Проверяем, что число нечетное");
    }

    @Test
    @DisplayName("Проверить функцию на положительное число")
    void testIsNumberPositive(){
        Assertions.assertTrue(triangleFunction.main(1));
    }

    @Test
    void testIsPrimeFunctionWithNegativeNumber(){
        Assertions.assertFalse(triangleFunction.main(-1));
    }

    private org.assertj.core.api.NotThrownAssert assertThatExceptionOfType(Class<NegativeOrNullTriangleSideException> NegativeOrNullTriangleSideException) {
        return null;
    }

    @AfterEach
    void tearDown(){
        logger.debug("Выполниться после каждого теста");
    }
    @AfterAll
    static void AfterAll(){
        logger.debug("Выпонится после всех тестовых наборов");
    }
}
