//package testes_Selenium_IDE;
//
//import java.util.ArrayList;
//import java.util.concurrent.TimeUnit;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.junit.*;
//import static org.junit.Assert.*;
//import org.openqa.selenium.*;
//import org.openqa.selenium.phantomjs.PhantomJSDriverService;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.Select;
//
//public class RegistoProfissionalTest {
//
//    private WebDriver driver;
//    private String baseUrl;
//    private boolean acceptNextAlert = true;
//    private StringBuffer verificationErrors = new StringBuffer();
//
//    @Before
//    public void setUp() throws Exception {
//        ArrayList<String> cliArgsCap = new ArrayList<>();
//        cliArgsCap.add("--proxy=127.0.0.1:1024");
//
//        cliArgsCap.add("--proxy-type=socks5");
//
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setJavascriptEnabled(true);
//        caps.setCapability("takesScreenshot", true);
//        caps.setCapability("screen-resolution", "1280x1024");
//        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/phantomjs.exe");
//
//        caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsCap);
//
//        Logger.getLogger(PhantomJSDriverService.class.getName()).setLevel(Level.OFF);
//
//        driver = new org.openqa.selenium.phantomjs.PhantomJSDriver(caps);
//        baseUrl = "http://deti-tqs-vm3.ua.pt/encontreJa-1.0/";
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    }
//
//    @Test
//    public void testRegistoProfissional() throws Exception {
//        driver.get(baseUrl + "/encontreJa-1.0/");
//        driver.findElement(By.linkText("Registo")).click();
//        driver.findElement(By.linkText("Registo Profissional")).click();
//        driver.findElement(By.id("name")).clear();
//        driver.findElement(By.id("name")).sendKeys("Franciso Melo");
//        driver.findElement(By.id("name")).clear();
//        driver.findElement(By.id("name")).sendKeys("Franciso Melo Andrade");
//        driver.findElement(By.id("email")).clear();
//        driver.findElement(By.id("email")).sendKeys("francisco_melo@gmail.com");
//        driver.findElement(By.id("phone")).clear();
//        driver.findElement(By.id("phone")).sendKeys("934578963");
//        new Select(driver.findElement(By.name("location"))).selectByVisibleText("Coimbra");
//        driver.findElement(By.id("password")).clear();
//        driver.findElement(By.id("password")).sendKeys("fmc");
//        new Select(driver.findElement(By.xpath("//section[@id='content']/div/div/div/div/form/div/div[7]/select"))).selectByVisibleText("canalizador");
//        driver.findElement(By.xpath("//section[@id='content']/div/div/div/div/form/div/div[8]/textarea")).clear();
//        driver.findElement(By.xpath("//section[@id='content']/div/div/div/div/form/div/div[8]/textarea")).sendKeys("Serviço de canalização completo. Desde pequenas reparações até a instalação de raiz.");
//        driver.findElement(By.id("hourPrice")).clear();
//        driver.findElement(By.id("hourPrice")).sendKeys("15");
//        driver.findElement(By.id("feePrice")).clear();
//        driver.findElement(By.id("feePrice")).sendKeys("10");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        driver.findElement(By.linkText("Home")).click();
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        driver.quit();
//        String verificationErrorString = verificationErrors.toString();
//        if (!"".equals(verificationErrorString)) {
//            fail(verificationErrorString);
//        }
//    }
//
//    private boolean isElementPresent(By by) {
//        try {
//            driver.findElement(by);
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }
//
//    private boolean isAlertPresent() {
//        try {
//            driver.switchTo().alert();
//            return true;
//        } catch (NoAlertPresentException e) {
//            return false;
//        }
//    }
//
//    private String closeAlertAndGetItsText() {
//        try {
//            Alert alert = driver.switchTo().alert();
//            String alertText = alert.getText();
//            if (acceptNextAlert) {
//                alert.accept();
//            } else {
//                alert.dismiss();
//            }
//            return alertText;
//        } finally {
//            acceptNextAlert = true;
//        }
//    }
//}
