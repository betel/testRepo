package lifeSample;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FreeLife extends JFrame
  implements ActionListener, Runnable{	//Threadでコントロールできるようにする
 private static final long serialVersionUID = 1L;
 private JButton button1,button2;
 private LifePanel life1;
 private Thread t;
 private boolean flg,kissOfDeath;		//判定に使う変数

 public static void main(String[] args) {	//実行
  new FreeLife().setVisible(true);
 }
 
 public FreeLife(){						//コンストラクタ
  this.setSize(530, 500);
  setBackground(Color.pink);
  flg = false;
  kissOfDeath = false;
  setLayout(null);
  button1 = new JButton();
  button1.setText("Strat");
  button1.setBounds(10, 420, 70, 20);
  getContentPane().add(button1);
  button2 = new JButton();
  button2.setText("Clear");
  button2.setBounds(440, 420, 70, 20);
  getContentPane().add(button2);
  life1 = new LifePanel(100, 80);
  life1.setBounds(10, 10, 500, 400);
  life1.setBackground(Color.black);
  getContentPane().add(life1);
  button1.addActionListener(this);
  button2.addActionListener(this);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }

 public void actionPerformed(ActionEvent ev){
  if(ev.getSource() == button1){
   if(!flg){
    button1.setText("Stop");
    kissOfDeath = true;
    t = new Thread(this);
    t.start();
   } else {
    kissOfDeath = false;
    button1.setText("Start");
   }
   flg = !flg;
   return;
  } else {
   life1.initialData();
   life1.repaint();
   return;
  }
 }

 public void run(){
  do {
   life1.checkAllLife();
   life1.repaint();
   try {
    Thread.sleep(100L);
   }
   catch(Exception _ex){}
  } while(kissOfDeath);
 }
}