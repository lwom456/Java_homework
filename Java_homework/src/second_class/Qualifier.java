package second_class;

/**
 * ��дһ������public��private��protected��default����Ȩ�޵����ݳ�Ա�ͳ�Ա������class��
 * Ϊ������һ�����󲢽��йۣ����㳢��ȡ������class��Աʱ�������ʲô���͵ı�����Ϣ��
 * */
public class Qualifier {
	//��������
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