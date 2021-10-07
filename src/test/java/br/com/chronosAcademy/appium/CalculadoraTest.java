package br.com.chronosAcademy.appium;
import io.appium.java_client.MobileBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;


public class CalculadoraTest {
    DriverFactory driverFactory = new DriverFactory();
    @BeforeEach
    public void inicializarDriver() throws MalformedURLException {
        driverFactory = new DriverFactory();
        driverFactory.setCapabilities("Android", "ChronosMobile", "uiautomator2", "com.android.calculator2",
                "com.android.calculator2.Calculator");
        driverFactory.setDriver();

    }

    @AfterEach
    public void finalizarDriver(){
        driverFactory.getDriver().quit();
    }

    @Test
    public void validarMutiplicacao()  {

        clickid("digit_7");
        clickid("op_mul");
        clickid("digit_9");
        clickid("eq");
        String resultado = driverFactory.getDriver().findElement(MobileBy.id("result")).getText();

        assertEquals("63", resultado);
        driverFactory.getDriver().quit();

    }


    @Test
    public void validarSoma()throws MalformedURLException {
        clickid("digit_7");
        clickid("op_add");
        clickid("digit_9");
        clickid("eq");


        //driverFactory.getDriver().findElement(MobileBy.id("digit_7")).click();
        //driverFactory.getDriver().findElement(MobileBy.id("op_add")).click();
        //driverFactory.getDriver().findElement(MobileBy.id("digit_9")).click();
        //driverFactory.getDriver().findElement(MobileBy.id("eq")).click();
        String resultado = driverFactory.getDriver().findElement(MobileBy.id("result")).getText();

        assertEquals("16", resultado);
        driverFactory.getDriver().quit();

    }

    @Test
    public void validarSubtracao(){
        clickid("digit_7");
        clickid("op_sub");
        clickid("digit_9");
        clickid("eq");

        String resultado = driverFactory.getDriver().findElement(MobileBy.id("result")).getText();

        assertEquals("−2", resultado);


    }

    @Test
    public void validarDivisao()throws MalformedURLException {

        clickid("digit_7");
        clickid("op_div");
        clickid("digit_9");
        clickid("eq");

        // driverFactory.getDriver().findElement(MobileBy.id("digit_7")).click();
       // driverFactory.getDriver().findElement(MobileBy.id("op_div")).click();
       // driverFactory.getDriver().findElement(MobileBy.id("digit_9")).click();
       // driverFactory.getDriver().findElement(MobileBy.id("eq")).click();
        String resultado = driverFactory.getDriver().findElement(MobileBy.id("result")).getText();

        assertEquals("0.777777777777", resultado);
        driverFactory.getDriver().quit();

    }

    public void clickid(String id){
        driverFactory.getDriver().findElement(MobileBy.id(id)).click();

    }

}