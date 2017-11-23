package collection_class;

import java.io.IOException;

//单队列SJF
public class SingleSJF {
	private Task[] task;
	int time;//服务总时间
	boolean[] isServ;//任务是否被服务过
	
	
	public SingleSJF(int[][] data) {
		task = new Task[data.length];
		isServ = new boolean[data.length];
		for(int i=0;i<data.length;i++) {
			task[i] = new Task(data[i][0],data[i][1],data[i][2]);//id,到达时间，服务时间
		}
	}
	
	public void startService() {
		int min = 0;//最短作业所在序号
		int lmin = min;//标记队列最前方未服务任务的序号
		for(int N=0;N<task.length;N++) {
			for(int i=lmin;i<task.length;i++) {//找到队列最前面的已到达任务
				if(isServ[i]==false) {
					min=i;
					break;
				}
			}
			lmin = min;//标记，下次查找时不用从头开始
			for(int i=min+1;i<task.length&&i<=time;i++) {//找到已到达任务中最短任务
				if(isServ[i]==true) {continue;}
				if(task[min].serviceTime>task[i].serviceTime) {min=i;}
			}			
			if(time<=task[min].arrivalTime) {//如果之前任务完成时间小于任务到达时间（服务空闲）
				task[min].startService(task[min].arrivalTime);//任务到达即开始服务
				time=task[min].arrivalTime+task[min].serviceTime;//任务完成时间等于任务到达时间+服务时间
			} else {
				task[min].startService(time);//任务在之前任务完成后才开始服务
				time+=task[min].serviceTime;//任务完成时间等于之前任务完成时间+服务时间
			}
			isServ[min]=true;//将该任务标记为已服务
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
		SingleSJF sSJF = new SingleSJF(data);//这里可以更改成SingleSJf,SingleFCFS,DoubleSJF,DoubleFCFS
		sSJF.startService();//开始服务
		Task[] task=sSJF.getTask();//取出服务数据
		IOData.outputData(task,"outputData.txt");//将数据输出到文件
		for(int i=0;i<task.length;i++) {
			System.out.println(task[i]);
		}
	}
}
