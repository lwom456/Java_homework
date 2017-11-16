package java_io_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ObjectSerialization {

	public static void main(String[] args){
		try {
			File fin = new File("list.txt");
			FileInputStream fins = new FileInputStream(fin);
			Scanner sc;
			sc = new Scanner(fins);
			while(sc.hasNext()) {
				System.out.print(sc.nextLong()+"  ");
				System.out.print(sc.next()+"      ");
				System.out.println(sc.next());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
