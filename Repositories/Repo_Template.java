package Repositories;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CentaJava.Core.Datasources;

public class Repo_Template {
	WebDriver driver = null;
	WebDriverWait waitt;

	public void setDriver(WebDriver d) {
		driver = d;
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}

	//Botón LogIn
	public String[] get_def_btnLogin() {
		return new String[] {"id","//input[@id='login-button']"};
	}
	public WebElement get_obj_btnLogin() {
		return driver.findElement(By.xpath("//input[@id='login-button']"));
	}
	//Username
	public String[] get_def_txtUser() {
		return new String[] {"id","//input[@id='user-name']"};
	}
	public WebElement get_obj_txtUser() {
		return driver.findElement(By.xpath("//input[@id='user-name']"));
	}
	//Password
	public String[] get_def_txtPass() {
		return new String[] {"id","//input[@id='password']"};
	}
	public WebElement get_obj_txtPass() {
		return driver.findElement(By.xpath("//input[@id='password']"));
	}
	
	//Botón menú hamburguesa
	public WebElement get_obj_btnBurger() {
		return driver.findElement(By.xpath("//button[contains(@id,'react-burger-menu-btn')]"));
	}
	
	//Link LogOut
	public WebElement get_obj_linkLogOut() {
		return driver.findElement(By.xpath("//nav//a[@id='logout_sidebar_link']"));
	}
	
	//Add to cart
	//1
	/*public String get_def_btnAddToCart(String data) {
		return "//button[contains(text(),'"+data+"']";
	}*/
	public String get_def_btnRemoveToCart(String nombreProd) {
		return "//button[@id='remove-"+nombreProd+"']";
	}
	public WebElement get_obj_btnRemoveToCart(String nombreProd) {
		return driver.findElement(By.xpath("//button[@id='remove-"+nombreProd+"']"));
	}
	
//Argumento
	public WebElement get_obj_btnAddToCart(String nombreProd) {
		return driver.findElement(By.xpath("//button[@id='add-to-cart-"+nombreProd+"']"));
	}
//Datasource
	public WebElement get_obj_btnAddToCart3(String nombreProd) {
		return driver.findElement(By.xpath("//button[@id='add-to-cart-"+nombreProd+"']"));
	}
	
	//div[text()='"+nombreProd+"']/../../..//button

}











