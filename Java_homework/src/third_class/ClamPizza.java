package third_class;

public class ClamPizza extends Pizza{

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		System.out.println("Preparing ClamPizza's raw material...");
	}

	@Override
	public void bake() {
		// TODO Auto-generated method stub
		System.out.println("Baking ClamPizza...");
	}

	@Override
	public void cut() {
		// TODO Auto-generated method stub
		System.out.println("Cutting ClamPizza...");
	}

	@Override
	public void box() {
		// TODO Auto-generated method stub
		System.out.println("Boxing ClamPizza...");
	}

}
