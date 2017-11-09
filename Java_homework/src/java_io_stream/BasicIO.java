package java_io_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class BasicIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File inFile = new File("src.txt");
			File outFile = new File("dest.txt");
			FileInputStream finS = new FileInputStream(inFile);
			FileOutputStream foutS = new FileOutputStream(outFile);
			int c;
			while ((c = finS.read())!=-1) {
				foutS.write(c);
			}
			finS.close();
			foutS.close();
			inFile = new File("dest.txt");
			Scanner sc = new Scanner(inFile);
			while (sc.hasNext()) {
				System.out.println(sc.nextLine());
			}
			sc.close();
 		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
