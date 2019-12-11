import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RunnableTimerEx extends JFrame {
	JLabel k = new JLabel();
	JLabel timerLabel = new JLabel();
	JLabel la = new JLabel("<html>동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리 나라 만세 <br/>무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세</html>");
	JTextField tf = new JTextField();
	public RunnableTimerEx() {
		setTitle("30초 안에 글 따라쓰기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		tf.addKeyListener(new MyKeyListener());
		
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		timerLabel.setSize(500,100);
		timerLabel.setLocation(450,50);
		c.add(timerLabel); 
		
		la.setFont(new Font("Gothic", Font.ITALIC, 20));
		la.setSize(800,300);
		la.setLocation(100,300);
		c.add(la);
				
		c.add(k);
		
		tf.setFont(new Font("Gothic", Font.ITALIC, 20));
		tf.setSize(800,100);
		tf.setLocation(100,150);
		c.add(tf);
		
		TimerRunnable runnable = new TimerRunnable(timerLabel);
		Thread th = new Thread(runnable); 
		setSize(1000,600);
		setVisible(true);
		th.start(); 
		
		tf.setFocusable(true);
		tf.requestFocus();
		
		
	}
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch(keyCode) {
			case KeyEvent.VK_ENTER:
				String s = tf.getText();					
				switch(s) {
				case "동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리 나라 만세 무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세":
					k.setFont(new Font("Gothic", Font.ITALIC, 90));
					k.setText("성공");
					k.setSize(1000,600);
					k.setLocation(350,0);
					tf.setFocusable(false);
					break;
				default:
					k.setFont(new Font("Gothic", Font.ITALIC, 90));
					k.setText("실패");
					k.setSize(1000,600);
					k.setLocation(350,0);
					break;
				}
				break;				
			}
		}
	}
	class TimerRunnable implements Runnable {
		private JLabel timerLabel;
		public TimerRunnable(JLabel timerLabel) {
			this.timerLabel = timerLabel;
		}
		public void run() {
			int n=30; 
			
			while(n>0) { 
				timerLabel.setText(Integer.toString(n));
				n--;
				try {
					Thread.sleep(1000); 
				}
				catch(InterruptedException e) { return; }	
				String copy = k.getText();
				if (copy=="성공") {
					break;
				}
				else if (n==0&&copy!="성공") {
					timerLabel.setText(Integer.toString(n));
					k.setFont(new Font("Gothic", Font.ITALIC, 90));
					k.setText("실패");
					k.setSize(1000,600);
					k.setLocation(350,0);
					tf.setFocusable(false);
					break;
				}
			}
			
		
		}
	}
	
}
public class game {

	public static void main(String[] args) {
		new RunnableTimerEx();
	
	}
}
