import org.testng.annotations.Test;

public class TestCases {


    @Test
    void setup() {
        System.out.println(" I inside setup ");
    }

    @Test
    void testSteps(){
        System.out.println(" I am inside testSteps ");
    }

    @Test
    void tearDown(){
        System.out.println(" I am inside tearDown ");
    }
}
