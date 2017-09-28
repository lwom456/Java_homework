package first_class;

import java.util.Random;

public class ToGradeScore {
	public static void main(String args[]) {
		int N = 100;//模拟数据大小
		int[] data = createData(N);//测试用例获取随机数据
		toGradeScore(data);
	}
	
	//随机创建测试用例
	public static int[] createData(int n) {
		int[] data = new int[n];
		Random rand = new Random();
		for(int i=0;i<n;i++) {
			data[i] = rand.nextInt(100);
		}
		return data;
	}
	
	//数值将成绩转化成等级成绩
	public static void toGradeScore(int[] data) {
		for(int i=0;i<data.length;i++) {
			if(data[i]==100) {
				System.out.println("成绩:"+data[i]+" 等第：优");
				continue;
			}
			switch(data[i]/10%10) {
			case 9:System.out.println("成绩:"+data[i]+" 等第：优");break;
			case 8:System.out.println("成绩:"+data[i]+" 等第：良");break;
			case 7:System.out.println("成绩:"+data[i]+" 等第：中");break;
			case 6:System.out.println("成绩:"+data[i]+" 等第：及格");break;
			default:System.out.println("成绩:"+data[i]+" 等第：不及格");break;
			}
		}
	}
}
