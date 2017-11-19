package java_io_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ObjectSerialization implements Serializable{
	private static final long serialVersionUID = 1234L;
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
			FileInputStream fins = new FileInputStream("list.txt");
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
			
			//save Object
			FileOutputStream fouts = new FileOutputStream("student.bin");
			ObjectOutputStream out = new ObjectOutputStream(fouts);
			out.writeObject(os);
			out.close();
			//read OBject
			fins = new FileInputStream("student.bin");
			ObjectInputStream in = new ObjectInputStream(fins);
			ObjectSerialization oin = (ObjectSerialization)in.readObject();
			in.close();
			oin.print();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
