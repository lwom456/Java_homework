package java_io_stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferIO {
	public static void main(String[] args) {
		try {
			//没有缓冲区复制文件
			File fin = new File("E:\\testin.exe");
			File fout = new File("E:\\testout.exe");
			FileInputStream fins = new FileInputStream(fin);
			FileOutputStream fouts = new FileOutputStream(fout);
			byte[] c=new byte[10];
			long startTime=System.currentTimeMillis();
			int i;
			while ((i=fins.read(c))!=-1) {
				fouts.write(c,0,i);
			}
			long endTime=System.currentTimeMillis();
			System.out.println(endTime-startTime+"ms");
			fins.close();
			fouts.close();
			
			//带缓冲区复制文件
			fins = new FileInputStream(fin);
			fouts = new FileOutputStream(fout);
			BufferedInputStream bfins = new BufferedInputStream(fins);
			BufferedOutputStream bfouts = new BufferedOutputStream(fouts);
			//byte[] c=new byte[8192];
			startTime=System.currentTimeMillis();
			while ((i=bfins.read(c))!=-1) {
				bfouts.write(c,0,i);
			}
			endTime=System.currentTimeMillis();
			System.out.println(endTime-startTime+"ms");
			fins.close();
			fouts.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
