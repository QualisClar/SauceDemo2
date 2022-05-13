package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Repositories.Repo_Template;
import pasos.LogIn;
import pasos.LogOut;


public class LogIn_Out {
	WebDriver driver;
			
	public boolean Test(Reports report, DriverManager DM, int iteration,String name) {
		//validation VAR//
		boolean result = true;
		String check_url="https://www.saucedemo.com/inventory.html";
		String url;
		try {			
			System.out.println("Configuring");
			
			//SELECT THE DRIVER AND PATH
			driver = DM.CreateDriver(DM.CHROME);
			report.SetDriver(driver);
			
			//SET THE REPOSITORIES TO USE
			Repo_Template repo = new Repo_Template();
			repo.setDriver(driver);
			
			System.out.println("Initializating test");

			//SET THE URL
			driver.get("https://www.saucedemo.com/");
			
			//ADD THE STEPS BELOW
			LogIn ingresoOk=new LogIn();
			ingresoOk.ingresar(report, DM, iteration, name, repo);	
			
			//ADD VALIDATIONS AT THE END
			report.AddLine("Se valida que ingrese a la url correcta");
			WebDriverWait waitFor = new WebDriverWait(driver, 10);
			waitFor.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));
			url = driver.getCurrentUrl();
			if (url.equals(check_url) ){
				System.out.println( "LogIn exitoso");
				report.AddLine("Login Exitoso");
				report.Screenshot(name);
				
			}else {
					System.out.println("Redirecciona a otra página");
					report.AddLine("Redirecciona a otra página");
					report.Screenshot(name);		
			}
			
			LogOut salirOk=new LogOut();
			salirOk.salir(report, DM, iteration, name, repo);

			
		} catch (Exception e) {
	        e.printStackTrace();
			report.AddLineAssertionError(e.getStackTrace()[0].toString());
			report.AddLineAssertionError(e.getMessage());
			report.Screenshot(name);
			result = false;
			}
		//Try to erase the driver
		try {
			driver.quit();}
			catch(Exception e2) {}
		//return the test result
		return result;
	}

	private void WaitTime(int i) {
		try
		{
			Thread.sleep(i);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}

}
