package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Repositories.Repo_Template;

import pasos.Btn_AddToCart1;
import pasos.LogIn;
import pasos.LogOut;

 
public class CartFunction1 {
	WebDriver driver;

	public boolean Test(Reports report, DriverManager DM, int iteration,String name) {
		//validation var
		boolean result = true;
		String nombreProd="sauce-labs-bike-light";
		
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
			
			Btn_AddToCart1 agregarAlCarro= new Btn_AddToCart1();
			agregarAlCarro.agregarAlCarro(report, DM, iteration, name, repo, nombreProd);
			
			report.AddLine("Se valida que aparezca el botón REMOVE");
			WebDriverWait waitFor = new WebDriverWait(driver, 15);
			waitFor.until(ExpectedConditions.presenceOfElementLocated(By.xpath(repo.get_def_btnRemoveToCart(nombreProd))));
			result=report.validateObjectIsDisplayable(repo.get_obj_btnRemoveToCart(nombreProd));
			report.Screenshot(name);
			
			LogOut salir=new LogOut();
			salir.salir(report, DM, iteration, name, repo);
			
			
		} catch(Exception e){
		        e.printStackTrace();
				report.AddLineAssertionError(e.getMessage());			
				result = false;
				}
			//Try to erase the driver
			try {
				driver.quit();}
				catch(Exception e2){
			//return the test result
				}
			return result;
		}
		
		/*private void WaitTime(int i) {
			try
			{
			    Thread.sleep(i);
			}
			catch(InterruptedException ex){
			    Thread.currentThread().interrupt();
			}*/
		} 
