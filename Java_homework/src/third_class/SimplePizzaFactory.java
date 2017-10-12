package third_class;

public class SimplePizzaFactory {
	public SimplePizzaFactory(){}
	public Pizza createPizza(String type) {
		switch(type) {
		case "CheesePizza":
			return new CheesePizza();
		case "CalmPizza":
			return new ClamPizza();
		case "PepperoniPizza":
			return new PepperoniPizza();
		default:
			return null;
		}
	}
}
