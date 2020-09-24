package javaproject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public final class Homepage extends JFrame implements ActionListener {

    private Container c;
 
    private ImageIcon  img;
    private JLabel  imglabel;
 
    private Font f, f1, f2;
    private JButton btn1, btn2, btn3;

    Homepage() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(10, 10, 1340, 720);
        this.setTitle("          University Student Management           ");
        this.setResizable(true);

        f = new Font("Algerian", Font.BOLD, 35);

        c = new Container();
        c = this.getContentPane();
        c.setBackground(Color.BLUE);
        c.setLayout(null);

        img = new ImageIcon(getClass().getResource("pic.jpg"));
        imglabel = new JLabel(img);
        imglabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        c.add(imglabel);

        btn1 = new JButton("Student Login");
        btn1.setBounds(425,100,500,50);
        btn1.setFont(f);
        imglabel.add(btn1);
        
        
        btn2 = new JButton("Teacher Login");
        btn2.setBounds(425,200,500,50);
        btn2.setFont(f);
        imglabel.add(btn2);
        
        btn3 = new JButton("Administrative Login");
        btn3.setBounds(425,300,500,50);
        btn3.setFont(f);
        imglabel.add(btn3);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==btn1){
            dispose();
            StudentLogin fr=new StudentLogin();
            fr.setVisible(true);
        }
        
        else if(e.getSource()==btn2){
            dispose();
            TeacherLogin fr = new TeacherLogin();
            fr.setVisible(true);
            
        }
        
        else if(e.getSource()==btn3){
            dispose();
            AdminLogin fr=new AdminLogin();
            fr.setVisible(true);
        }

    }

    public static void main(String[] args) {
        Homepage fr = new Homepage();
        fr.setVisible(true);
    }

}
