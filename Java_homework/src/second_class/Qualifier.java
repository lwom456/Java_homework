package second_class;

/**
 * 编写一个具有public、private、protected、default访问权限的数据成员和成员函数的class。
 * 为它产生一个对象并进行观：当你尝试取用所有class成员时、会产生什么类型的编译消息。
 * */
public class Qualifier {
	//测试用例
	public static void main(String args[]) {
		QualifierTest q = new QualifierTest();
		System.out.println(q.pub);
		//System.out.println(q.pri);  (This is a problem code!!)
		System.out.println(q.prot);
		System.out.println(q.def);
	}
}

class QualifierTest{
	public String pub;
	private String pri;
	protected String prot;
	String def;
	QualifierTest(){
		pub = "This is public";
		pri = "This is private";
		prot = "This is protect";
		def = "This is default";
	}
}