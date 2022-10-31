
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;





public class Iris {
    public static WebDriver driver;



   public static void main(String[] args) throws Throwable {  



   System.setProperty("webdriver.chrome.driver",
            System.getProperty("user.dir") + "\\src\\test\\resources\\Driver\\chromedriver.exe");



   DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
    ChromeOptions options = new ChromeOptions();
    options.addArguments("incognito");
    options.addArguments("--lang= locale-of-choice");
    capabilities.setCapability(ChromeOptions.CAPABILITY, options);



   driver = new ChromeDriver(capabilities);
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.get("https://osa-web.t-cg.co.uk");
    System.out.println("Launch the application");
    driver.manage().window().maximize();
    System.out.println("Welcome to OurSchoolsApp");
    Thread.sleep(2000);
    WebElement search = driver.findElement(By.xpath("//input[@id='main']"));
    search.click();
    search.sendKeys("B16 8PE");
    WebElement button = driver.findElement(By.id("searchPostcodeButton"));
    button.click();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true);",button);
    driver.findElement(By.xpath("//ol[@class='w-50 pl-0']/li[20]")).click();
    WebElement news = driver.findElement(By.xpath("(//ol[@class='list-group list-group-horizontal flex-wrap'])[3]"));
    String news_Nov = news.getText();
    System.out.println(news_Nov);
    
    WebElement nov_validate = driver.findElement(By.xpath("(//div[@class='col ml-1 p-0'])[3]"));
    nov_validate.click();
    driver.navigate().back();
    Thread.sleep(2000);
    driver.navigate().to("https://osa-web.t-cg.co.uk/qatest");
    WebElement text = driver.findElement(By.xpath("//div[@class='bg-light']/p"));
    String QA_Test = text.getText();
    System.out.println("***********"+QA_Test+ "*************");  
    driver.findElement(By.xpath("//div[@class='bg-light']/p/a")).click();
    Thread.sleep(2000);
    driver.navigate().back();
    } }