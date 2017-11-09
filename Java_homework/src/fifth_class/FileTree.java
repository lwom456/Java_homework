package fifth_class;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class FileTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Input a destination:");
		Scanner sysIn = new Scanner(System.in);
		String src = sysIn.nextLine();
		sysIn.close();
		File fileIn = new File(src);
		String[] list = fileIn.list();
		System.out.println("Directory");
		for(int i =0;i<list.length;i++) {
			fileIn = new File(src+list[i]);
			if (fileIn.isDirectory()) {
				Date date = new Date(fileIn.lastModified());
				System.out.println(fileIn.getName()+"     "+date);
			}
		}
		for(int i =0;i<list.length;i++) {
			fileIn = new File(src+list[i]);
			if (!fileIn.isDirectory()) {
				Date date = new Date(fileIn.lastModified());
				System.out.println(fileIn.getName()+"     "+date+"      "+fileIn.length());
			}
		}
	}
}
