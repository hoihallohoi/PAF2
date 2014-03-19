package userInterface;

import java.util.ArrayList;

import domain.Context;
import domain.Controller;
import domain.Pattern;
import domain.Problem;
import domain.TextExporter;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Context classScope = Controller.createNewContext("Class");
		Context objectScope = Controller.createNewContext("Object");
		
		Context creational = Controller.createNewContext("Creational");
		Context behavioral = Controller.createNewContext("Behavioral");
		Context structural = Controller.createNewContext("Structural");
		
		Context scope = new Context("Scope");
		Context purpose = new Context("Purpose");
		
		scope.addComponent(classScope);
		scope.addComponent(objectScope);
		purpose.addComponent(creational);
		purpose.addComponent(behavioral);
		purpose.addComponent(structural);
		
		Problem strategyProblem = new Problem("TestProb1", "TestSolu1");
		Problem builderProblem = new Problem("TestProb2", "TestSolu2");
		Problem decoratorProblem = new Problem("TestProb3", "TestSolu3");
		Problem adapterClassProblem = new Problem("TestProb4", "TestSolu4");
		
		Pattern strategy = Controller.createNewPattern("Strategy", "summary", "testCon", objectScope, behavioral);
		scope.addPattern(strategy);
		purpose.addPattern(strategy);
		Pattern builder = Controller.createNewPattern("Builder", "summary", "testCon", objectScope, behavioral);
		scope.addPattern(builder);
		purpose.addPattern(builder);
		Pattern decorator = Controller.createNewPattern("Decorator", "summary", "testCon", objectScope, behavioral);
		scope.addPattern(decorator);
		purpose.addPattern(decorator);
		Pattern adapterClass = Controller.createNewPattern("AdapterClass", "summary", "testCon", objectScope, behavioral);
		scope.addPattern(adapterClass);
		purpose.addPattern(adapterClass);
		
		strategy.addProblem(strategyProblem);
		builder.addProblem(builderProblem);
		decorator.addProblem(decoratorProblem);
		adapterClass.addProblem(adapterClassProblem);
		//TextExporter te = new TextExporter();
		//te.ExportAllPatterns();
		//Controller.Start();  
		
		System.out.println("Scope: " + scope.showChilds());
		System.out.println("Purpose: " + purpose.showChilds());
		//System.out.println(strategy);
		
		
		    MainFrame mf = new MainFrame();
		  
	}

}
