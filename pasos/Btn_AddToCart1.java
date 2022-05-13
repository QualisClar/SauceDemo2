package pasos;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Repositories.Repo_Template;

public class Btn_AddToCart1 {
	public void agregarAlCarro(Reports report, DriverManager DM, int iteration,String name, Repo_Template repo, String nombreProd) {
		
		repo.get_obj_btnAddToCart(nombreProd).click();	
		
}

}