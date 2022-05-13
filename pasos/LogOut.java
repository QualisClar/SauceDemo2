package pasos;

import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Repositories.Repo_Template;

public class LogOut {
	public void salir(Reports report, DriverManager DM, int iteration,String name, Repo_Template repo) {
		repo.get_obj_btnBurger().click();
		repo.get_obj_linkLogOut().click();
		report.Screenshot(name);
}

public class LogOut12341234123412341234 {
	public void salir(Reports report, DriverManager DM, int iteration,String name, Repo_Template repo) {
		repo.get_obj_btnBurger().click();
		repo.get_obj_linkLogOut().click();
		report.Screenshot(name);
}
};
