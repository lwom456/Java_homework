package fourth_class;

import java.io.IOException;

//≤‚ ‘≥Ã–Ú
public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N =100;
		MakeTestFile.makeTestFile(N);
		int[][] data=InPutData.inputData("testData.txt",N);
		DoubleFCFS sFCFS = new DoubleFCFS(data);
		sFCFS.startService();
		Task[] task=sFCFS.getTask();
		for(int i=0;i<task.length;i++) {
			System.out.println(task[i]);
		}
	}

}
