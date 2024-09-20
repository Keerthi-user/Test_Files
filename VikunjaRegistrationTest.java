
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VikunjaRegistrationTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://try.vikunja.io/register");
    }

    @Test
    public void testUsernameValidation() {
        // Locate the username field and enter a 2-character username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("ab");

        // Locate the email and password fields and enter dummy data
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("test@example.com");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("testPassword123");

        // Submit the registration form
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        // Wait for the error message to be displayed
        try {
            Thread.sleep(3000); // Not recommended in production. Use WebDriverWait instead.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify if the error message is displayed
        WebElement errorMessage = driver.findElement(By.xpath("//*[contains(text(), 'Username must have at least 3 characters')]"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");

        // Check if the username field is highlighted in red
        String borderColor = usernameField.getCssValue("border-color");
        Assert.assertEquals(borderColor, "rgb(255, 0, 0)", "Username field is not highlighted in red");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}