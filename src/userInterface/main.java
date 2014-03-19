package userInterface;

import java.util.ArrayList;

import domain.Controller;
import domain.Pattern;
import domain.Problem;
import domain.Purpose;
import domain.Scope;
import domain.TextExporter;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scope classScope = new Scope("Class");
		Scope objectScope = new Scope("Object");
		Purpose creational = new Purpose("Creational");
		Purpose behavioral = new Purpose("Behavioral");
		Purpose structural = new Purpose("Structural");
		Problem strategyProblem = new Problem("TestProb1", "TestSolu1");
		Problem builderProblem = new Problem("TestProb2", "TestSolu2");
		Problem decoraterProblem = new Problem("TestProb3", "TestSolu3");
		Problem adapterClassProblem = new Problem("TestProb4", "TestSolu4");
		Pattern strategy = Controller.createNewPattern("Strategy", "testCon", objectScope, behavioral);
		Pattern builder = Controller.createNewPattern("Builder", "testCon", objectScope, behavioral);
		Pattern decorator = Controller.createNewPattern("Decorator", "testCon", objectScope, behavioral);
		Pattern adapterClass = Controller.createNewPattern("AdapterClass", "testCon", objectScope, behavioral);
		//TextExporter te = new TextExporter();
		//te.ExportAllPatterns();
		Controller.Start();  
		
		System.out.println(Controller.getProblemByPattern(builder).toString());
		
		
		    MainFrame mf = new MainFrame();
		  
	}

}
