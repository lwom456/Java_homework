package third_class;

public class PizzaStore {
	private SimplePizzaFactory spf;
	public static void main(String args[]) {
		PizzaStore ps = new PizzaStore(new SimplePizzaFactory());//Instance a SimplePizzaFactory.
		System.out.println("I want to have a CalmPizza!");
		ps.orderPizza("CalmPizza");
		System.out.println("\nI want to have a CheesePizza!");
		ps.orderPizza("CheesePizza");
		System.out.println("\nI want to have a PepperoniPizza!");
		ps.orderPizza("PepperoniPizza");
		System.out.println("\nI want to have a ChocolatePizza!");
		ps.orderPizza("ChocolatePiza");
	}
	public PizzaStore(SimplePizzaFactory spf) {
		this.spf=spf;
	}
	public Pizza orderPizza(String type) {
		Pizza pizza = spf.createPizza(type);//Ask for a type of the Pizza from the factory. 
		if(pizza==null) {
			System.out.println("We havn't got this kind of pizza!");
			return null;
		}
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
	
