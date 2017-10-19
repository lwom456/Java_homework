package fourth_class;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//从文件中读取数据
public class InPutData {
	public static int[][] inputData(String name,int n) throws FileNotFoundException{
		Scanner sc = new Scanner(new FileInputStream(name));
		int[][] data = new int[n][3];
		for(int i=0;i<n;i++) {
			data[i][0]=sc.nextInt();
			data[i][1]=sc.nextInt();
			data[i][2]=sc.nextInt();
		}
		sc.close();
		return data;
	}	
}
