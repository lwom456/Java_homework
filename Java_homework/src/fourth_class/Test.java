package fourth_class;

import java.io.IOException;

//测试程序
public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N =100;
		IOData.makeTestFile(N,"testData.txt");//随机生成数据到文件，数量为N
		int[][] data=IOData.inputData("testData.txt",N);//从文件中读取数据
		DoubleFCFS sFCFS = new DoubleFCFS(data);
		sFCFS.startService();//开始服务
		Task[] task=sFCFS.getTask();//去除服务数据
		IOData.outputData(task,"outputData.txt");//将数据输出到文件
		for(int i=0;i<task.length;i++) {
			System.out.println(task[i]);
		}
	}

}
