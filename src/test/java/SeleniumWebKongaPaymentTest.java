import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SeleniumWebKongaPaymentTest {
    private WebDriver driver;

        @BeforeTest
        public void start() throws InterruptedException {
            // locate the chromeDriver
            System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
            // 1. Open your Chrome browser

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");


            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            Actions act = new Actions(driver);
        }

        @Test (priority = 0)
    public void loginFlow() throws InterruptedException {

            // 2. visit the URL website
            driver.get("https://www.konga.com/");
            Thread.sleep(10000);
            // 3. maximize screen
            driver.manage().window().maximize();
            // 4. sign in to konga successfully
            driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/nav/div[2]/div[1]/div/div/div[4]/a")).click();
            // 5. add username
            driver.findElement(By.id("username")).sendKeys("testmail@gmail.com");
            // 6. add password
            driver.findElement(By.id("password")).sendKeys("weareafricans");
            // 7. click on the login button
            driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
            Thread.sleep(10000);
        }
        @Test (priority = 1)
        public void selectCategoryFlow() throws InterruptedException {
            // 8. click on the computer and accessories link
            driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/nav/div[2]/div[2]/div/a[2]")).click();
            Thread.sleep(10000);
            // 9. click on laptops
            driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a")).click();
            Thread.sleep(10000);
            // 10. click on Apple MacBooks
            driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a")).click();
            Thread.sleep(10000);
        }
        @Test(priority = 2)
        public void addItemFlow() throws InterruptedException {
            //11 add an item to cart
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/section[1]/div[3]/section[1]/main[1]/section[3]/section[1]/section[1]/section[1]/section[1]/ul[1]/li[1]/div[1]/div[1]/div[2]/form[1]/div[3]/button[1]")).click();
        //12 . Go to carts
            driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/nav/div[2]/div[1]/div/div/a[2]/span[1]")).click();
            Thread.sleep(5000);
        }
        @Test(priority = 3)
        public void checkOutWithPaymentFlow() throws InterruptedException {
            // 13. click on checkout
            driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        //14. click on pay now
            driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
            // 15 click on continue to payment
            driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
            Thread.sleep(100000);
        }
        @Test (priority = 4)
        public void AddCardFlow() throws InterruptedException {
            // 16 click on the card option
            Thread.sleep(10000);
            WebElement ele = driver.findElement(By.xpath("//html[1]/body[1]/section[1]/section[1]/section[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[2]/button[1]"));
            act.doubleClick(ele).perform();
            System.out.println("Double click operation performed");
            // 17.Add card number
            driver.findElement(By.id("card-number")).sendKeys("12345678901234");
            // 18. click on pay now
            driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[3]/div/form[1]/div[2]/div[2]/button")).click();
            // 19. find error message
            WebElement e = driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[3]/div/form[1]/div[2]/div[1]/div[1]/div[2]/label"));
            System.out.println(e.getText());
        }
        @Test (priority = 5)
        public void EndPaymentFlow() throws InterruptedException {
            // 20. close the iFrame that displays the input card modal
            driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
            // 21. go back to konga
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/nav/a/img")).click();
        }
        @Test (priority = 6)
        public void LogOutFlow() throws InterruptedException {
            // 22.  go to log out from my account
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a")).click();
            // 23. click log out
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a")).click();
        }
        try {}catch (Exception e){
            }
                if (e.getClass() == NoSuchElementException.class ){
                    Thread.sleep(10000);
                    start();
                } else {
                    System.out.println(e.getClass());
                }
            }
        @AfterTest
        public void closeBrowser() {
        // 35. quit the browser
        driver.quit();
    }
    }

