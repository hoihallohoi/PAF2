package domain;

import java.util.ArrayList;

public class Main 
{
	public static void main(String args[])
	{
		//Controller.Start();
		Scope Class = new Scope("Class");
		Scope Object = new Scope("Object");
		Purpose Creational = new Purpose("Creational");
		Purpose Behavioral = new Purpose("Behavioral");
		Purpose Structural = new Purpose("Structural");
		Problem StrategyProblem = new Problem("TestProb1", "TestSolu1");
		Problem BuilderProblem = new Problem("TestProb2", "TestSolu2");
		Problem DecoraterProblem = new Problem("TestProb3", "TestSolu3");
		Problem AdapterClassProblem = new Problem("TestProb4", "TestSolu4");
		/*Pattern Strategy = Controller.createNewPattern("Strategy", StrategyProblem, "testCon", new ArrayList<String>(){{add("A");add("B");add("C");}}, Object, Behavioral);
		Pattern Builder = Controller.createNewPattern("Builder", BuilderProblem, "testCon", new ArrayList<String>(), Object, Behavioral);
		Pattern Decorator = Controller.createNewPattern("Decorator", DecoraterProblem, "testCon", new ArrayList<String>(), Object, Behavioral);
		Pattern AdapterClass = Controller.createNewPattern("AdapterClass", AdapterClassProblem, "testCon", new ArrayList<String>(), Object, Behavioral);
		TextExporter te = new TextExporter();
		te.ExportAllPatterns();*/
		TextImporter ti = new TextImporter();
		ti.ImportAllPatterns();
		for(Pattern p : Controller.allPatterns){
			System.out.println(p.getPatternName());
		}
		System.out.println("Imported");
	}
}
