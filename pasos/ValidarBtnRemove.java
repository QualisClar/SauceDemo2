package pasos;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;
import Repositories.Repo_Template;

public class ValidarBtnRemove {
	
public void validarRemove(Datasources data, Reports report, DriverManager DM, int iteration, String name,
		Repo_Template repo) {
	
repo.get_def_btnRemoveToCart(data.getValueFromDataSource("nombreProd", iteration));

}
}


