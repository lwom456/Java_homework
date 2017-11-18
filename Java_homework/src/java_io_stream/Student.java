package java_io_stream;

public class Student implements Comparable<Student>{
	long id;
	String name;
	String sex;
	public Student(long id,String name,String sex) {
		this.id=id;
		this.name=name;
		this.sex=sex;
	}
	@Override
	public int compareTo(Student stu) {
		int result = id > stu.id ? 1 : (id == stu.id ? 0 : -1);
		return result;
	}
	@Override
	public String toString() {
		return id + "  " + name + "     " + sex;
	}
	
	
}
