package socket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class MyTcpServer extends JFrame {
	private static final long serialVersionUID = 1L;
	private BufferedReader reader;
	private PrintWriter writer;
	private ServerSocket server;
	private Socket socket;
	private JTextPane tp = new JTextPane();
	private JTextField tf = new JTextField();
	private Document doc = tp.getStyledDocument();  
	SimpleAttributeSet setBlack = new SimpleAttributeSet();
	SimpleAttributeSet setRed = new SimpleAttributeSet();
	SimpleAttributeSet setBlue = new SimpleAttributeSet();
	Container cc;
	
	public MyTcpServer(String title) {		    //构造函数
		super(title);							//UI标题
		setTextColor();		//设置字体
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//实例化对象
		cc=this.getContentPane();
		final JScrollPane scrollPane=new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(tp);
		cc.add(tf, "South");					//将文本框放在窗体的下部;
		tf.addActionListener(new ActionListener(){
			//绑定事件
			@Override
			public void actionPerformed(ActionEvent e) {
				writer.println(tf.getText());//将文本框中的信息写入流
				try {
					doc.insertString(doc.getLength(),"我:"+tf.getText()+'\n', setBlue);
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//将文本框中的信息显示在文本域中
				tf.setText("");//将文本框清空
			}
		});
	}
	
	public void setTextColor() {
		StyleConstants.setForeground(setRed,Color.RED);
		StyleConstants.setForeground(setBlue,Color.BLUE);
		StyleConstants.setForeground(setBlack,Color.BLACK);
	}
	
	public void getServer() {
		try {
			server = new ServerSocket(6666);	     //实例化Socket对象
			doc.insertString(doc.getLength(),"服务器套接字已经创建成功\n", setBlack);
			while(true) {
				doc.insertString(doc.getLength(),"等待客户机的连接\n", setBlack);
				socket=server.accept();
				doc.insertString(doc.getLength(),"客户机已连接\n", setBlack);
				reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer=new PrintWriter(socket.getOutputStream(),true);
				getClientMessage();
			}
		} catch (IOException | BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getClientMessage() {
		try {
			while(true) {			//如果套接字是连接状态
				String recv = reader.readLine();
				doc.insertString(doc.getLength(),"客户机:"+recv+"\n", setRed);
			}
		} catch (IOException | BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(reader!=null) {		//关闭流
				reader.close();
			}
			if(socket!=null) {		//关闭套接字
				socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MyTcpServer server = new MyTcpServer("服务器");
		server.setSize(300,300);
		server.setVisible(true);
		server.getServer();
	}
}
