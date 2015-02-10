import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class knopki extends JFrame {
	double a, c;
	String p =".";
	String q, w;
	JButton b1, b2;
	JLabel l1, l2, l3, l4;
	JTextField t1, t2;
	Listener list = new Listener();

	public knopki(String f){
		super(f);
		JPanel buttonsPanel = new JPanel(new FlowLayout());
		JPanel TextPannel = new JPanel(new FlowLayout());
		JPanel AnswerPannel = new JPanel(new FlowLayout());
		l1=new JLabel("¬ведите число");
		t1=new JTextField(30);
		b1=new JButton("Bin");
		b2=new JButton("Dec");
		l3=new JLabel("ќтвет");
		l4=new JLabel("");
		TextPannel.add(l1);
		TextPannel.add(t1);
		add(TextPannel, BorderLayout.NORTH);
		buttonsPanel.add(b1);
		buttonsPanel.add(b2);
		add(buttonsPanel, BorderLayout.SOUTH);
		AnswerPannel.add(l3);
		AnswerPannel.add(l4);
		add(AnswerPannel, BorderLayout.CENTER);
		b1.addActionListener(list);
		b2.addActionListener(list);
	}
	public int pow(int x, int y){
		int result=1;
		for(int i=0; i<y;i++){
			result*=x;
		}
		return result;
	}
	public double powDrob(double x, int y){
		double result=0.5;
		for(int i=0; i<y;i++){
			result*=x;
			
		}
		return result;
		
	}
	
	public int BintoDec(String d){
		int res=0, g=0, mult=0;
		char[] symbol = d.toCharArray();
		for(int len=d.length()-1; len>=0; len--){
			int temp=0;
			g = Character.getNumericValue(symbol[len]);
			temp=g*pow(2, mult);
			mult++;
			res+=temp;
		}
		return res;
		
	}
	public double BintoDecDrob(String n1){
		int g=0, mult=0;
		double res=0;
		char[] symbol = n1.toCharArray();
		for(int len=n1.length()-1; len>=0; len--){
			double temp=0;
			g = Character.getNumericValue(symbol[mult]);
			temp=g*powDrob(0.5, mult);
			mult++;
			res+=temp;
		}
		return res;
	}
	public class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//в двоичную
			try{
				if(e.getSource()==b1){
					a = Double.parseDouble(t1.getText());
					int b = (int)a;
					w = Integer.toBinaryString(b);
					q=w+".";
					c=a-b;
				for(int i=0; i<50; i++){
					c = c*2-(int)c*2;
					q = q+(int)c;
					if(c==1.0){
						break;
					}
					}
			
				l3.setText(q);
			}
			}catch(Exception r){JOptionPane.showMessageDialog(null, "¬ведите чиcло");}
			//в дес€тичную
			try{
				if(e.getSource()==b2){
					a = Double.parseDouble(t1.getText());
					int b = (int)a;
					//целое
					String d = String.valueOf(b);
					int h = BintoDec(d);
					w = Integer.toString(h);
					System.out.println(w);
					//дроби
					String n = Double.toString(a);
					int m = d.length()+1;
					String n1 = n.substring(m);
					System.out.println(n1);
					
				
					double l = BintoDecDrob(n1);

					double l1 = h+l;
					System.out.println(l);
					q=String.valueOf(l1);
				
					l3.setText(q);
				}
			}catch(Exception r){JOptionPane.showMessageDialog(null, "¬ведите чиcло");}
		}
	  }
	
}	
		
		
	

