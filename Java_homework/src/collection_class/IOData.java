package collection_class;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class IOData {
	//���ļ��ж�ȡ����
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
	//������ݵ��ļ�
	public static void outputData(Task[] data,String oname) throws IOException {
		FileWriter fout = new FileWriter(oname);
		for(int i=0;i<data.length;i++) {
			fout.write(data[i].toString()+"\r\n");
		}
		fout.close();
	}
	//���ɲ����ļ�
	public static void makeTestFile(int N,String fname) throws IOException {
		int[] stime= {6,2,1,3,9};
		Random rand = new Random(System.currentTimeMillis());
		FileWriter fout = new FileWriter(fname);
		for(int i=0;i<N;i++) {
			int r = rand.nextInt(5);
			fout.write((i+1)+" "+i+" "+stime[r]+"\r\n");//id,����ʱ��,����ʱ��
		}
		fout.close();
	}
}
