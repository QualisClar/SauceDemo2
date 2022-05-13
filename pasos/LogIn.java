package pasos;

import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Repositories.Repo_Template;

public class LogIn {
	
	public void ingresar(Reports report, DriverManager DM, int iteration,String name, Repo_Template repo){
	String username = "standard_user";
	String password="secret_sauce";
		
		report.AddLine("Get to the home page");
		report.Screenshot(name);
		report.AddLine("Se ingresa el usuario");
		repo.get_obj_txtUser().sendKeys(username);
		report.AddLine("Se ingresa la contraseña");
		repo.get_obj_txtPass().sendKeys(password);
		report.AddLine("Se hace click en el botón LOGIN");
		report.Screenshot(name);
		repo.get_obj_btnLogin().click();
		report.Screenshot(name);
		
	};

}
