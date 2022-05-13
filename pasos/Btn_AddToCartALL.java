package pasos;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Repositories.Repo_Template;

public class Btn_AddToCartALL {

	public void Btn_AddToCart3(Datasources data, Reports report, DriverManager DM, int iteration, String name,
			Repo_Template repo) {

		repo.get_obj_btnAddToCart3(data.getValueFromDataSource("nombreProd", iteration)).click();

	}
}