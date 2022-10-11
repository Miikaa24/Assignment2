package SecondAssignment;

//import com.github.javafaker.Faker;
import com.github.javafaker.Faker;
import javafx.beans.property.adapter.JavaBeanBooleanPropertyBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class automation2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/baigalmisheel/Desktop/selenium /chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //1. Launch Chrome browser
        driver.get("https://www.google.com/");
        Thread.sleep(500);

        //2.Navigate to http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        //3. Login using username Tester and password test
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        //4. Click on Order link
        //driver.findElement(By.xpath("//a[@href='/Process.aspx")).sendKeys(Keys.ENTER);

        Thread.sleep(500);
       // driver.findElement(By.className("selected")).click();
       // Thread.sleep(500);
       driver.findElement(By.xpath("//a[text()='Order']")).click();

        //5. Enter a random product quantity between 1 and 100
        Random n= new Random();

        int products= n.nextInt(100);
        products= products+1;
        System.out.println(products);

       driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(String.valueOf(products));
      // driver.quit();

       //6. Click on Calculate and verify that the Total value is correct.

        Thread.sleep(500);
        driver.findElement(By.className("btn_dark")).click();








        //7. Generate and enter random first name and last name.
        //8.Generate and Enter random street address
        //9. Generate and Enter random city
        //10. Generate and Enter random state
        //11. Generate and Enter a random 5 digit zip code


        Faker fake= new Faker();
        String fullName= fake.name().fullName();
        String streetAddress= fake.address().streetAddress();
        String city=fake.address().city();
        String state=fake.address().state();

//        String[] firstName ={"Akmal", "Bek", "Zaya", "Murad", "Michelle", "Saraa", "Naraa", "Adika", "Hatice", "Epsone", "John"};
//        String[] lastName ={"Doe", "Dior", "Kadirov", "Daniel", "Simpson", "Sherwood", "Igor", "Mikheil", "Mirjalol", "Sadova", "Bold"};
//
//        String[] streetAddresses= {"300 Pleasant meadow", "1800 W Hawthorne", "2206 S Geobbert", "3287 E Chicago", "1208 Hunter Ct", "300 E Southern"};
//        String[] cities={"Los Angeles", "Chicago", "Vernon Hills", "Arlington Height", "West Chicago", "Naperville", "Glenview"};
//        String[] states= {"CA", "VA", "IL", "DC", "OH", "FL", "MN", "CT", "NE", "HW"};


        Random random= new Random();
//        String firstRealName=firstName[random.nextInt(firstName.length)];
//        String lastRealName=lastName[random.nextInt(lastName.length)];
//        String fullName= firstRealName+" "+lastRealName;
//
//        String streetAddress= streetAddresses[random.nextInt(streetAddresses.length)];
//        String city=cities[random.nextInt(cities.length)];
//        String state=states[random.nextInt(states.length)];
        int zip= random.nextInt(99999);
        System.out.println(zip);


        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(fullName, Keys.TAB, streetAddress,Keys.TAB, city, Keys.TAB, state);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(String.valueOf(zip));

        Random credit= new Random();
        String visaCard= "4"+ (long)(Math.random()*1000000000000000L);
        String masterCard= "5"+ (long)(Math.random()*1000000000000000L);
        String amex= "3"+ (long)(Math.random()*100000000000000L);

        List<WebElement> elements = driver.findElements(By.xpath("//input[@type='radio']"));

        int selectedType= random.nextInt(elements.size());
        elements.get(selectedType).click();

        // if the certain type of card selected:


        if (selectedType == 0){
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(visaCard);
        }

        else if (selectedType==1){
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(masterCard);

        } else if (selectedType ==2) {
            driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(amex);
        }

        // 13. Enter a valid expiration date (newer than the current date)


        String [] month={"01/","02/","03/","04/","05/","06/","07/","08/","09/","10/","11/","12/"};
        String [] year={"23","24","25","26","27","28","29","30"};
        Random ran= new Random();
        String validMonth=month[ran.nextInt(month.length)];
        String validYear=year[ran.nextInt(year.length)];
        String expDate= validMonth+validYear;


          driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(expDate);


        // 14. Click on Process

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

        //Verify that “New order has been successfully added” message appeared on the page.

        if(driver.getPageSource().contains("New order has been successfully added.")){
            System.out.println("Text appears on the screen");
        }else{
            System.out.println("Text is not on the screen");}
        //driver.quit();

            //16. Click on View All Orders link.

            System.out.println(driver.getCurrentUrl());

            driver.findElement(By.linkText("View all orders")).click();

            //17. The placed order details appears on the first row of the orders table. Verify that the entire
            // information contained on the row (Name, Product, Quantity, etc) matches the previously entered information in previous steps.


//            WebElement orderTable= driver.findElement(By.id("ctl00_MainContent_orderGrid"));
//            List<WebElement> tableRows= orderTable.findElements()


        // I DID NOT KNOW HOW TO GRAB THE VALUES THAT I NEEDED TO VERIFY
        String actualFullName=driver.findElement(By.xpath("//table[@class='SampleTable']//tr[2]//td[2]")).getText();
        String expectedFullName= fullName;
        Assert.assertEquals(actualFullName, expectedFullName);
//        List<String> expectedRowValues= Arrays.asList(new String[]{fullName, streetAddress, city, state, String.valueOf(zip), String.valueOf(selectedType), expDate});
//        List <WebElement> elements1= driver.findElements(By.xpath("//table[@class='SampleTable']//tr[2]//td[2]//td[6]//td[7]//td[8]//td[9]//td[10]//td[12]"));
//
//        List<String> actualRowValues= new ArrayList<>();
//
//        for (WebElement element : elements1){
//            actualRowValues.add(element.getText());
//        }
//
//        Assert.assertEquals(actualRowValues, expectedRowValues);

           // 18. Log out of the application.

            driver.findElement(By.id("ctl00_logout")).click();

    }}
