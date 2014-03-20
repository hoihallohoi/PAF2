package userInterface;

import java.io.File;
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
		Problem factoryMethodProblem = new Problem("TestProb4", "TestSolu4");
		Problem abstractFactoryProblem = new Problem("TestProb4", "TestSolu4");
		Problem prototypeProblem = new Problem("TestProb4", "TestSolu4");
		Problem singletonProblem = new Problem("TestProb4", "TestSolu4");
		Problem adaptorObjectProblem = new Problem("TestProb4", "TestSolu4");
		Problem bridgeProblem = new Problem("TestProb4", "TestSolu4");
		Problem compositeProblem = new Problem("TestProb4", "TestSolu4");
		Problem facadeProblem = new Problem("TestProb4", "TestSolu4");
		Problem flyweightProblem = new Problem("TestProb4", "TestSolu4");
		Problem proxyProblem = new Problem("TestProb4", "TestSolu4");
		Problem chainProblem = new Problem("TestProb4", "TestSolu4");
		Problem commandProblem = new Problem("TestProb4", "TestSolu4");
		Problem iteratorProblem = new Problem("TestProb4", "TestSolu4");
		Problem mediatorProblem = new Problem("TestProb4", "TestSolu4");
		Problem mementoProblem = new Problem("TestProb4", "TestSolu4");
		Problem observerProblem = new Problem("TestProb4", "TestSolu4");
		Problem stateProblem = new Problem("TestProb4", "TestSolu4");
		Problem visitorProblem = new Problem("TestProb4", "TestSolu4");
		Problem interpreterProblem = new Problem("TestProb4", "TestSolu4");
		Problem templateProblem = new Problem("TestProb4", "TestSolu4");

		Pattern factoryMethod = Controller.createNewPattern("Factory Method" , "The factory method pattern is an object-oriented creational design pattern to implement the concept of factories and deals with the problem of creating objects (products) without specifying the exact class of object that will be created. The essence of this pattern is to 'Define an interface for creating an object, but let the classes that implement the interface decide which class to instantiate. The Factory method lets a class defer instantiation to subclasses.'[1]Creating an object often requires complex processes not appropriate to include within a composing object. The object's creation may lead to a significant duplication of code, may require information not accessible to the composing object, may not provide a sufficient level of abstraction, or may otherwise not be part of the composing object's concerns. The factory method design pattern handles these problems by defining a separate method for creating the objects, which subclasses can then override to specify the derived type of product that will be created.Some of the processes required in the creation of an object include determining which object to create, managing the lifetime of the object, and managing specialized build-up and tear-down concerns of the object. Outside the scope of design patterns, the term factory method can also refer to a method of a factory whose main purpose is creation of objects.The factory method pattern relies on inheritance, as object creation is delegated to subclasses that implement the factory method to create objects." ,classScope ,creational );
		Pattern abstractFactory= Controller.createNewPattern("Abstract Factory", "The abstract factory pattern provides a way to encapsulate a group of individual factories that have a common theme without specifying their concrete classes.[1] In normal usage, the client software creates a concrete implementation of the abstract factory and then uses the generic interface of the factory to create the concrete objects that are part of the theme. The client doesn't know (or care) which concrete objects it gets from each of these internal factories, since it uses only the generic interfaces of their products. This pattern separates the details of implementation of a set of objects from their general usage and relies on object composition, as object creation is implemented in methods exposed in the factory interface.", objectScope, creational);
		Pattern builder = Controller.createNewPattern("Builder", "The builder pattern is an object creation software design pattern. Unlike the abstract factory pattern and the factory method pattern whose intention is to enable polymorphism, the intention of the builder pattern is to find a solution to the telescoping constructor anti-pattern. The telescoping constructor anti-pattern occurs when the increase of object constructor parameter combination leads to an exponential list of constructors. Instead of using numerous constructors, the builder pattern uses another object, a builder, that receives each initialization parameter step by step and then returns the resulting constructed object at once.The builder pattern has another benefit. It can be used for objects that contain flat data (html code, SQL query, X.509 certificate...), that is to say, data that can't be easily edited. This type of data cannot be edited step by step and must be edited at once. The best way to construct such an object is to use a builder class.", objectScope, creational);
		Pattern prototype = Controller.createNewPattern("Prototype", "The prototype pattern is a creational design pattern in software development. It is used when the type of objects to create is determined by a prototypical instance, which is cloned to produce new objects. This pattern is used to avoid subclasses of an object creator in the client application, like the abstract factory pattern does. and to avoid the inherent cost of creating a new object in the standard way (e.g., using the 'new' keyword) when it is prohibitively expensive for a given application.To implement the pattern, declare an abstract base class that specifies a pure virtual clone() method. Any class that needs a 'polymorphic constructor' capability derives itself from the abstract base class, and implements the clone() operation.", objectScope, creational);
		Pattern singleton = Controller.createNewPattern("Singleton", "the singleton pattern is a design pattern that restricts the instantiation of a class to one object. This is useful when exactly one object is needed to coordinate actions across the system. The concept is sometimes generalized to systems that operate more efficiently when only one object exists, or that restrict the instantiation to a certain number of objects. The term comes from the mathematical concept of a singleton.There is criticism of the use of the singleton pattern, as some consider it an anti-pattern, judging that it is overused, introduces unnecessary restrictions in situations where a sole instance of a class is not actually required, and introduces global state into an application.", objectScope, creational);
		Pattern adaptorObject = Controller.createNewPattern("Adapter(object)", "An adapter helps two incompatible interfaces to work together. This is the real world definition for an adapter. The adapter design pattern is used when you want two different classes with incompatible interfaces to work together. Interfaces may be incompatible but the inner functionality should suit the need. The Adapter pattern allows otherwise incompatible classes to work together by converting the interface of one class into an interface expected by the clients. In this type of adapter pattern, the adapter contains an instance of the class it wraps. In this situation, the adapter makes calls to the instance of the wrapped object.",objectScope, structural);
		Pattern bridge = Controller.createNewPattern("Bridge", "The bridge pattern is a design pattern used in software engineering which is meant to 'decouple an abstraction from its implementation so that the two can vary independently'.[1] The bridge uses encapsulation, aggregation, and can use inheritance to separate responsibilities into different classes. When a class varies often, the features of object-oriented programming become very useful because changes to a program's code can be made easily with minimal prior knowledge about the program. The bridge pattern is useful when both the class as well as what it does vary often. The class itself can be thought of as the implementation and what the class can do as the abstraction. The bridge pattern can also be thought of as two layers of abstraction.",objectScope, structural);
		Pattern composite = Controller.createNewPattern("Composite", "In software engineering, the composite pattern is a partitioning design pattern. The composite pattern describes that a group of objects are to be treated in the same way as a single instance of an object. The intent of a composite is to 'compose' objects into tree structures to represent part-whole hierarchies. Implementing the composite pattern lets clients treat individual objects and compositions uniformly.",objectScope, structural);
		Pattern decorator = Controller.createNewPattern("Decorator", "In object-oriented programming, the decorator pattern (also known as Wrapper, an alternative naming shared with the Adapter pattern) is a design pattern that allows behavior to be added to an individual object, either statically or dynamically, without affecting the behavior of other objects from the same class.",objectScope, structural);
		Pattern facade = Controller.createNewPattern("Facade", "The facade pattern (or façade pattern) is a software design pattern commonly used with object-oriented programming. The name is by analogy to an architectural facade. A facade is an object that provides a simplified interface to a larger body of code, such as a class library.",objectScope, structural);
		Pattern flyweight = Controller.createNewPattern("Flyweight", "n computer programming, flyweight is a software design pattern. A flyweight is an object that minimizes memory use by sharing as much data as possible with other similar objects; it is a way to use objects in large numbers when a simple repeated representation would use an unacceptable amount of memory. Often some parts of the object state can be shared, and it is common practice to hold them in external data structures and pass them to the flyweight objects temporarily when they are used.",objectScope, structural);
		Pattern proxy = Controller.createNewPattern("Proxy", "In computer programming, the proxy pattern is a software design pattern. A proxy, in its most general form, is a class functioning as an interface to something else. The proxy could interface to anything: a network connection, a large object in memory, a file, or some other resource that is expensive or impossible to duplicate. A well-known example of the proxy pattern is a reference counting pointer object. In situations where multiple copies of a complex object must exist, the proxy pattern can be adapted to incorporate the flyweight pattern in order to reduce the application's memory footprint. Typically, one instance of the complex object and multiple proxy objects are created, all of which contain a reference to the single original complex object. Any operations performed on the proxies are forwarded to the original object. Once all instances of the proxy are out of scope, the complex object's memory may be deallocated.",objectScope, structural);
		Pattern chain = Controller.createNewPattern("Chain of Responsibility", "In object-oriented design, the chain-of-responsibility pattern is a design pattern consisting of a source of command objects and a series of processing objects. Each processing object contains logic that defines the types of command objects that it can handle; the rest are passed to the next processing object in the chain. A mechanism also exists for adding new processing objects to the end of this chain.",objectScope, behavioral);
		Pattern command = Controller.createNewPattern("Command", "In object-oriented programming, the command pattern is a behavioral design pattern in which an object is used to represent and encapsulate all the information needed to call a method at a later time. This information includes the method name, the object that owns the method and values for the method parameters. Four terms always associated with the command pattern are command, receiver, invoker and client. A command object has a receiver object and invokes a method of the receiver in a way that is specific to that receiver's class. The receiver then does the work. A command object is separately passed to an invoker object, which invokes the command, and optionally does bookkeeping about the command execution. Any command object can be passed to the same invoker object. Both an invoker object and several command objects are held by a client object. The client contains the decision making about which commands to execute at which points. To execute a command, it passes the command object to the invoker object.",objectScope, behavioral);
		Pattern iterator = Controller.createNewPattern("Iterator", "In object-oriented programming, the iterator pattern is a design pattern in which an iterator is used to traverse a container and access the container's elements. The iterator pattern decouples algorithms from containers; in some cases, algorithms are necessarily container-specific and thus cannot be decoupled.",objectScope, behavioral);
		Pattern mediator = Controller.createNewPattern("Mediator", "In Software Engineering, the mediator pattern defines an object that encapsulates how a set of objects interact. This pattern is considered to be a behavioral pattern due to the way it can alter the program's running behavior. Usually a program is made up of a large number of classes. So the logic and computation is distributed among these classes. However, as more classes are developed in a program, especially during maintenance and/or refactoring, the problem of communication between these classes may become more complex. This makes the program harder to read and maintain. Furthermore, it can become difficult to change the program, since any change may affect code in several other classes.",objectScope, behavioral);
		Pattern memento = Controller.createNewPattern("Memento", "The memento pattern is a software design pattern that provides the ability to restore an object to its previous state (undo via rollback). The memento pattern is implemented with three objects: the originator, a caretaker and a memento. The originator is some object that has an internal state. The caretaker is going to do something to the originator, but wants to be able to undo the change. The caretaker first asks the originator for a memento object. Then it does whatever operation (or sequence of operations) it was going to do. To roll back to the state before the operations, it returns the memento object to the originator. The memento object itself is an opaque object (one which the caretaker cannot, or should not, change). When using this pattern, care should be taken if the originator may change other objects or resources - the memento pattern operates on a single object.",objectScope, behavioral);
		Pattern observer = Controller.createNewPattern("Observer", "The observer pattern is a software design pattern in which an object, called the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their methods. It is mainly used to implement distributed event handling systems. The Observer pattern is also a key part in the familiar Model View Controller (MVC) architectural pattern. [1] In fact the observer pattern was first implemented in Smalltalk's MVC based user interface framework.[2] The observer pattern is implemented in numerous programming libraries and systems, including almost all GUI toolkits.",objectScope, behavioral);
		Pattern state = Controller.createNewPattern("State", "The state pattern, which closely resembles Strategy Pattern, is a behavioral software design pattern, also known as the objects for states pattern. This pattern is used in computer programming to encapsulate varying behavior for the same routine based on an object's state object. This can be a cleaner way for an object to change its behavior at runtime without resorting to large monolithic conditional statements",objectScope, behavioral);
		Pattern strategy = Controller.createNewPattern("Strategy", "In computer programming, the strategy pattern (also known as the policy pattern) is a software design pattern, whereby an algorithm's behaviour can be selected at runtime. Formally speaking, the strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.[1] Strategy is one of the patterns included in the influential book Design Patterns by Gamma et al. that popularized the concept of using patterns in software design.",objectScope, behavioral);
		Pattern visitor = Controller.createNewPattern("Visitor", "In object-oriented programming and software engineering, the visitor design pattern is a way of separating an algorithm from an object structure on which it operates. A practical result of this separation is the ability to add new operations to existing object structures without modifying those structures. It is one way to follow the open/closed principle.In essence, the visitor allows one to add new virtual functions to a family of classes without modifying the classes themselves; instead, one creates a visitor class that implements all of the appropriate specializations of the virtual function. The visitor takes the instance reference as input, and implements the goal through double dispatch.",objectScope, behavioral);
		Pattern interpreter = Controller.createNewPattern("Interpreter", "In computer programming, the interpreter pattern is a design pattern that specifies how to evaluate sentences in a language. The basic idea is to have a class for each symbol (terminal or nonterminal) in a specialized computer language. The syntax tree of a sentence in the language is an instance of the composite pattern and is used to evaluate (interpret) the sentence.",classScope, behavioral);
		Pattern template = Controller.createNewPattern("Template Method", "In software engineering, the template method pattern is a behavioral design pattern that defines the program skeleton of an algorithm in a method, called template method, which defers some steps to subclasses.[1] It lets one redefine certain steps of an algorithm without changing the algorithm's structure.",classScope, behavioral);
		Pattern adapterClass = Controller.createNewPattern("Adaptor(class)", "An adapter helps two incompatible interfaces to work together. This is the real world definition for an adapter. The adapter design pattern is used when you want two different classes with incompatible interfaces to work together. Interfaces may be incompatible but the inner functionality should suit the need. The Adapter pattern allows otherwise incompatible classes to work together by converting the interface of one class into an interface expected by the clients. his type of adapter uses multiple polymorphic interfaces to achieve its goal. The adapter is created by implementing or inheriting both the interface that is expected and the interface that is pre-existing. It is typical for the expected interface to be created as a pure interface class, especially in languages such as Java that do not support multiple inheritance.",classScope, structural);
		scope.addPattern(factoryMethod);
		purpose.addPattern(factoryMethod);
		scope.addPattern(abstractFactory);
		purpose.addPattern(abstractFactory);
		scope.addPattern(prototype);
		purpose.addPattern(prototype);
		scope.addPattern(singleton);
		purpose.addPattern(singleton);
		scope.addPattern(adaptorObject);
		purpose.addPattern(adaptorObject);
		scope.addPattern(bridge);
		purpose.addPattern(bridge);
		scope.addPattern(composite);
		purpose.addPattern(composite);
		scope.addPattern(facade);
		purpose.addPattern(facade);
		scope.addPattern(flyweight);
		purpose.addPattern(flyweight);
		scope.addPattern(proxy);
		purpose.addPattern(proxy);
		scope.addPattern(chain);
		purpose.addPattern(chain);
		scope.addPattern(command);
		purpose.addPattern(command);
		scope.addPattern(iterator);
		purpose.addPattern(iterator);
		scope.addPattern(mediator);
		purpose.addPattern(mediator);
		scope.addPattern(memento);
		purpose.addPattern(memento);
		scope.addPattern(observer);
		purpose.addPattern(observer);
		scope.addPattern(state);
		purpose.addPattern(state);
		scope.addPattern(visitor);
		purpose.addPattern(visitor);
		scope.addPattern(interpreter);
		purpose.addPattern(interpreter);
		scope.addPattern(template);
		purpose.addPattern(template);
		scope.addPattern(strategy);
		purpose.addPattern(strategy);
		scope.addPattern(builder);
		purpose.addPattern(builder);
		scope.addPattern(decorator);
		purpose.addPattern(decorator);
		scope.addPattern(adapterClass);
		purpose.addPattern(adapterClass);

		strategy.addProblem(strategyProblem);
		strategy.addProblem(builderProblem);
		builder.addProblem(builderProblem);
		decorator.addProblem(decoratorProblem);
		adapterClass.addProblem(adapterClassProblem);
		
		File f = new File("Penguins.jpg");
		//Controller.importImage(f, strategy);
		//Controller.Start();
		Controller.Update();
		//TextExporter te = new TextExporter();
		//te.ExportAllPatterns();
		//Controller.Start();  
		
		//System.out.println("Scope: " + scope.showChilds());
		//System.out.println("Purpose: " + purpose.showChilds());
		//System.out.println(strategy);
		
		// TextExporter te = new TextExporter();
		// te.ExportAllPatterns();
		// Controller.Start();

		// System.out.println("Scope: " + scope.showChilds());
		// System.out.println("Purpose: " + purpose.showChilds());
		// System.out.println(strategy);

		MainFrame mf = new MainFrame();

	}

}
