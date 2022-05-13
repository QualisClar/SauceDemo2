package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Repositories.Repo_Template;

import pasos.Btn_AddToCartALL;
import pasos.LogIn;
import pasos.LogOut;

 
public class CartFunctionALL2 {
	WebDriver driver;

	public boolean Test(Datasources data,Reports report, DriverManager DM, int iteration,String name) {
		//validation var
		boolean result = true;
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
			
			WebDriverWait waitFor = new WebDriverWait(driver, 15);
			
			Btn_AddToCartALL agregarAlCarro= new Btn_AddToCartALL();
			for(int x=0;x<data.getTotalIterations();x++) {
				agregarAlCarro.Btn_AddToCart3(data, report, DM, x , name, repo);
				waitFor.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath(repo.get_def_btnRemoveToCart(data.getValueFromDataSource("nombreProd", x)))));
				result = this.validarBtnRemove(data, report, x , name, repo);
								
			}
		
			
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

		private boolean validarBtnRemove(Datasources data, Reports report, int x, String name, Repo_Template repo) {
			return report.validateObjectIsDisplayable(
					repo.get_obj_btnRemoveToCart(data.getValueFromDataSource("nombreProd", x)));

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
