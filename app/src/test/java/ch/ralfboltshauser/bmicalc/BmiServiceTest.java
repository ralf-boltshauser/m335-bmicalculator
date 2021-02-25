package ch.ralfboltshauser.bmicalc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BmiServiceTest {
    @Test
    public void singletonFunctionalityTest() {
        BmiCalculatorService bmiCalculatorService1 = BmiCalculatorService.getInstance();
        bmiCalculatorService1.setWeight(10);

        BmiCalculatorService bmiCalculatorService2 = BmiCalculatorService.getInstance();
        assertEquals(10, bmiCalculatorService2.getWeight(), 0);
    }


    @Test
    public void bmiCalculatorFromPropertiesTest() {
        BmiCalculatorService bmiCalculatorService = BmiCalculatorService.getInstance();
        bmiCalculatorService.setWeight(75);
        bmiCalculatorService.setHeight(180);

        System.out.println(bmiCalculatorService.getBmi());

        assertEquals(23, bmiCalculatorService.getBmi(), 0.2);

    }

    @Test
    public void bmiCalculatorFromInputTest() {
        BmiCalculatorService bmiCalculatorService = BmiCalculatorService.getInstance();

        assertEquals(23, bmiCalculatorService.getBmi(75, 180), 0.2);

    }

    @Test
    public void bmiClassificationFromPropertiesTest() {
        BmiCalculatorService bmiCalculatorService = BmiCalculatorService.getInstance();
        bmiCalculatorService.setWeight(75);
        bmiCalculatorService.setHeight(180);

        assertEquals("normal", bmiCalculatorService.getBmiClassification());

    }

    @Test
    public void bmiClassificationFromInputTest() {
        BmiCalculatorService bmiCalculatorService = BmiCalculatorService.getInstance();

        assertEquals("obese", bmiCalculatorService.getBmiClassification(75, 150));

    }
}
