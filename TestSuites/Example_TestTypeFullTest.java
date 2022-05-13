package TestSuites;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import CentaJava.Core.Datasources;
import CentaJava.Core.DriverManager;
import CentaJava.Core.Reports;

import org.junit.jupiter.api.Tag;

import TestCases.LogIn_Out;
import TestCases.CartFunction1;
import TestCases.CartFunctionALL;
import TestCases.CartFunctionALL2;



public class Example_TestTypeFullTest 
{
	static 
	
	//Init
	DriverManager DM;
	static Datasources data;
	static Reports report;
	
	@BeforeAll
    static void initAll() {
    	//DriverManager
    	DM = new DriverManager();
    	//DataSource
    	data = new Datasources();
		//Reports
		report = new Reports();
    }
 
    @BeforeEach
    void init() {
    }
 
    @Test
    @Tag("Smoke")
    @Tag("TestCase1")
    @Tag("TestSuite1")
    
    void TC1() {
    	//Test Case LogIn-Out
    	LogIn_Out tc1 = new LogIn_Out();
    	boolean result;

    	//SET INDIVIDUAL DATASOURCE
		/*data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase1.xlsx");*/
		String name = "LogIn_Out";
		
		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
			result = tc1.Test(report,DM,x,name+"_Iteracion_"+x);
			report.addTestCaseToGeneralReport(result, name+"_Iteracion_"+x, "");
			report.saveTestCaseReport(name+"_Iteracion_"+x);
		}
    }
 

    @Test
    @Tag("Smoke")
    @Tag("TestCase2")
    @Tag("TestSuite2")
   
    void TC2() {
      	//Test Case Btn Carrito sin datasources//
     	CartFunction1 tc2 = new CartFunction1();
  	String name = "Add-to-Cart";
  	
  	for(int x=0;x<1;x++) {
  		//SET THE EXECUTION PLAN
  	report.addTestCaseToGeneralReport(tc2.Test(report,DM,x,name+"_Iteracion_"+x), name+"_Iteracion_"+x, "");
  	report.saveTestCaseReport(name+"_Iteracion_"+x);
  		}
    }
	
	  	@Test
	    @Tag("Smoke")
	    @Tag("TestCase3")
	    @Tag("TestSuite3")
	  void TC3() {
	    	//Boton carrito con Datasources
	    	CartFunctionALL  tc3 = new CartFunctionALL();
	    	
	    	//SET INDIVIDUAL DATASOURCE
			data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase2.xlsx");
		String name = "Add-to-Cart ALL";
		
		for(int x=0;x<data.getTotalIterations();x++) {
			//SET THE EXECUTION PLAN
		report.addTestCaseToGeneralReport(tc3.Test(data,report,DM,x,name+"_Iteracion_"+x), name+"_Iteracion_"+x, "");
		report.saveTestCaseReport(name+"_Iteracion_"+x);
		}
	
  }
	  
	  @Test
	    @Tag("Smoke")
	    @Tag("TestCase4")
	    @Tag("TestSuite4")
	  void TC4() {
	    	//Boton carrito con Datasources
	    	CartFunctionALL2  tc4 = new CartFunctionALL2();
	    	
	    	//SET INDIVIDUAL DATASOURCE
			data.setDataSourceType(data.ExcelType);
		data.setDataSourceFile("testcase2.xlsx");
		String name = "Add-to-Cart ALL";
		
		for(int x=0;x<1;x++) {
			//SET THE EXECUTION PLAN
		report.addTestCaseToGeneralReport(tc4.Test(data,report,DM,x,name+"_Iteracion_"+x), name+"_Iteracion_"+x, "");
		report.saveTestCaseReport(name+"_Iteracion_"+x);
		}
	
}
 
    @AfterEach
    void tearDown() {
    	
    }
 
    @AfterAll
    static void tearDownAll() {
    	System.out.println("Execution finished");
        report.saveGeneralReport();   
    }

}

