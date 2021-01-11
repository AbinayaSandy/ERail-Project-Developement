package seleniumLearning;
//Author: Abinaya
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ERailProject {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://erail.in");
		driver.manage().window().maximize();
		WebElement fromStation = driver.findElement(By.id("txtStationFrom"));
		fromStation.clear();
		fromStation.sendKeys("Delhi");
		WebElement toStation = driver.findElement(By.id("txtStationTo"));
		toStation.clear();
		toStation.sendKeys("Mumbai Central");
		WebElement sortOnDate = driver.findElement(By.id("chkSelectDateOnly"));
		if (sortOnDate.isSelected()) {
			sortOnDate.click();
			System.out.println("checkbox is toggled off");
		}

		WebElement departureDate = driver
				.findElement(By.xpath("//input[@title='Select Departure date for availability']"));
		departureDate.click();

		WebElement dateSelected = driver
				.findElement(By.xpath("//td[text()='Mar-21']/following::tr[4]//td[text()='11']"));
		dateSelected.click();
		WebElement stnSeats = driver.findElement(By.id("chkFirstLast"));					
		if (stnSeats.isSelected()) {
			System.out.println("Stn Seats is already selected");
		} else {
			stnSeats.click();
			System.out.println("Stn Seats is selected now");
		}
		WebElement Quota = driver.findElement(By.id("cmbQuota"));
		Quota.click();
		Select quotaDropDown=new Select(Quota);
		quotaDropDown.selectByValue("LD");
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		WebElement trainType = driver.findElement(By.id("selectTrainType"));
		Select trainTypeSelect=new Select(trainType);
		trainTypeSelect.selectByVisibleText("Special - 14");
		WebElement classSelect=driver.findElement(By.id("selectClassFilter"));
		Select classSelection=new Select(classSelect);
		classSelection.selectByIndex(1);
		WebElement getTrainButton = driver.findElement(By.id("buttonFromTo"));
		getTrainButton.click();
		
		WebElement advViewBlink = driver.findElement(By.className("blink"));
		advViewBlink.click();
		String parentWindow = driver.getWindowHandle();
		System.out.println("parentWindow:::"+parentWindow);
		Set<String> advViewNewWindow = driver.getWindowHandles();
		System.out.println("advViewNewWindow::"+advViewNewWindow);
		
		for (String allWindows : advViewNewWindow) {
			if(!parentWindow.equals(allWindows))
			{
				driver.switchTo().window(allWindows);
				 WebElement collapeOption=driver.findElement(By.linkText("Collapse All"));
				collapeOption.click();
				driver.close();
			}
			
		}
			
		 
		  driver.switchTo().window(parentWindow);
		  
		  
		 
	}

}
