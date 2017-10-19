package fourth_class;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

//生成测试数据到文件
public class MakeTestFile {
	public static void makeTestFile(int N) throws IOException {
		int[] stime= {6,2,1,3,9};
		Random rand = new Random(System.currentTimeMillis());
		FileWriter fout = new FileWriter("testData.txt");
		for(int i=0;i<N;i++) {
			int r = rand.nextInt(5);
			fout.write((i+1)+" "+i+" "+stime[r]+"\r\n");//id,到达时间,服务时间
		}
		fout.close();
	}
}
