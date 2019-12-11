import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RunnableTimerEx extends JFrame {
	JLabel k = new JLabel();
	JLabel timerLabel = new JLabel();
	JLabel la = new JLabel("<html>���ع��� ��λ��� ������ �⵵�� �ϴ����� �����ϻ� �츮 ���� ���� <br/>����ȭ ��õ�� ȭ������ ���ѻ�� �������� ���� �����ϼ�</html>");
	JTextField tf = new JTextField();
	public RunnableTimerEx() {
		setTitle("30�� �ȿ� �� ���󾲱�");
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
				case "���ع��� ��λ��� ������ �⵵�� �ϴ����� �����ϻ� �츮 ���� ���� ����ȭ ��õ�� ȭ������ ���ѻ�� �������� ���� �����ϼ�":
					k.setFont(new Font("Gothic", Font.ITALIC, 90));
					k.setText("����");
					k.setSize(1000,600);
					k.setLocation(350,0);
					tf.setFocusable(false);
					break;
				default:
					k.setFont(new Font("Gothic", Font.ITALIC, 90));
					k.setText("����");
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
				if (copy=="����") {
					break;
				}
				else if (n==0&&copy!="����") {
					timerLabel.setText(Integer.toString(n));
					k.setFont(new Font("Gothic", Font.ITALIC, 90));
					k.setText("����");
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
