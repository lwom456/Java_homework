package collection_class;

import java.io.IOException;

//单队列FCFS
public class SingleFCFS {
	private Task[] task;
	private int time;
	
	/**
	 * @param
	 * int n 任务数量n
	 * int data 输入数据data[][3]
	 * */
	public SingleFCFS(int[][] data){
		task = new Task[data.length];
		//创建task对象
		for(int i=0;i<data.length;i++) {
			task[i] = new Task(data[i][0],data[i][1],data[i][2]);//id,到达时间，服务时间
		}
	}
	public void startService() {
		for(int N=0;N<task.length;N++) {
			if(time<=task[N].arrivalTime) {//如果之前任务完成时间小于任务到达时间（服务空闲）
				task[N].startService(task[N].arrivalTime);//任务到达即开始服务
				time=task[N].arrivalTime+task[N].serviceTime;//任务完成时间等于任务到达时间+服务时间
			} else {
				task[N].startService(time);//任务在之前任务完成后才开始服务
				time+=task[N].serviceTime;//任务完成时间等于之前任务完成时间+服务时间
			}
		}
	}
	//返回Task对象
	public Task[] getTask() {
		return task;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N =100;
		//IOData.makeTestFile(N,"testData.txt");//随机生成数据到文件，数量为N
		int[][] data=IOData.inputData("input.txt",N);//从文件中读取数据
		SingleFCFS sFCFS = new SingleFCFS(data);//这里可以更改成SingleSJf,SingleFCFS,DoubleSJF,DoubleFCFS
		sFCFS.startService();//开始服务
		Task[] task=sFCFS.getTask();//取出服务数据
		IOData.outputData(task,"outputData.txt");//将数据输出到文件
		for(int i=0;i<task.length;i++) {
			System.out.println(task[i]);
		}
	}
}
