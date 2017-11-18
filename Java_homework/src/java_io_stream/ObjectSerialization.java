package java_io_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ObjectSerialization {
	private LinkedList<Student> stus;
	
	public ObjectSerialization() {
		stus = new LinkedList<Student>();
	}
	
	public void add(long id,String name,String sex) {
		stus.add(new Student(id,name,sex));
	}
	
	public void sort() {
		Collections.sort(stus);
	}
	
	public void print() {
		for(Student stu:stus) {
			System.out.println(stu);
		}
	}
	
	public LinkedList<Student> getLink(){
		return stus;
	}
	
	public static void main(String[] args){
		try {
			File fin = new File("list.txt");
			FileInputStream fins = new FileInputStream(fin);
			Scanner sc;
			sc = new Scanner(fins);
			
			//instantiation a ObjectSerialization Object
			ObjectSerialization os = new ObjectSerialization();
			while(sc.hasNext()) {
				//input data
				os.add(sc.nextLong(),sc.next(),sc.next());
			}
			sc.close();
			os.sort();
			System.out.println("排序后输出：");
			os.print();
			
			//save Object
			File fout = new File("student.bin");
			//ObjectOutputStream 
			//read OBject
			fin = new File("student.bin");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
