package javaproject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public final class TeacherLogin extends JFrame implements ActionListener {

    private Container c;

    private ImageIcon img;
    private JLabel imglabel, ul, pl, lb1, lb2;
    private JTextField uf;
    private JPasswordField pf;

    private Font f, f1, f2;
    private JButton login, clear, signup,back;

    private File dir, file1;
    String loc;

    TeacherLogin() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(10, 10, 1340, 720);
        this.setTitle("          Teacher Log In           ");
        this.setResizable(true);

        f = new Font("Roboto", Font.BOLD, 35);
        f1 = new Font("Roboto", Font.BOLD, 20);

        c = new Container();
        c = this.getContentPane();
        c.setBackground(Color.BLUE);
        c.setLayout(null);

        img = new ImageIcon(getClass().getResource("pic.jpg"));
        imglabel = new JLabel(img);
        imglabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        c.add(imglabel);

        ul = new JLabel("Username : ");
        ul.setBounds(200, 150, 400, 50);
        ul.setFont(f);
        imglabel.add(ul);

        pl = new JLabel("Password : ");
        pl.setBounds(200, 210, 400, 50);
        pl.setFont(f);
        imglabel.add(pl);

        uf = new JTextField();
        uf.setBounds(500, 150, 400, 50);
        uf.setFont(f1);
        imglabel.add(uf);

        pf = new JPasswordField();
        pf.setBounds(500, 210, 400, 50);
        c.add(pf);

        lb1 = new JLabel("*Invalid Username or password");
        lb1.setBounds(500, 270, 400, 50);
        lb1.setForeground(Color.RED);
        lb1.setVisible(false);
        lb1.setFont(f1);
        imglabel.add(lb1);

        lb2 = new JLabel("Don't have an account, Sign Up now");
        lb2.setBounds(500, 460, 400, 50);
        lb2.setForeground(Color.blue);
        lb2.setVisible(true);
        lb2.setFont(f1);
        imglabel.add(lb2);

        login = new JButton("Log In");
        login.setBounds(500, 350, 200, 60);
        login.setFont(f);
        imglabel.add(login);

        signup = new JButton("Sign Up");
        signup.setBounds(500, 520, 200, 60);
        signup.setFont(f);
        imglabel.add(signup);
        
        back = new JButton("Back To Home");
        back.setBounds(950, 600, 350, 60);
        back.setFont(f);
        imglabel.add(back);

        login.addActionListener(this);
        signup.addActionListener(this);
        back.addActionListener(this);

        /*-----------------file-------------------------------------------------------*/
        dir = new File("Data");
        dir.mkdir();

        loc = dir.getAbsolutePath();
     

        file1 = new File(loc + "/teacherinfo.txt");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {

            String un = uf.getText();
            String pass = pf.getText();

            try {
                Scanner fs = new Scanner(file1);

                int i = 0;
                boolean found = false;

                while (fs.hasNext()) {
                    String s = fs.nextLine();
                    i++;
                    //System.out.println(s);

                    if (s.equals(un) && (i % 5) == 1) {

                        found = true;
                    }
                    if (found == true && (i % 5) == 2) {

                        if (s.equals(pass)) {

                            
                            dispose();
                            TProfile fr = new TProfile(un);
                            fr.setVisible(true);
                            break;
                        }
                        else
                            found=false;

                    }

                }
                fs.close();
                
                if(found==false)
                {
                    lb1.setVisible(true);
                }

            } catch (Exception ee) {
                System.out.println(ee);
            }

        } else if (e.getSource() == signup) {

            dispose();
            TeacherSignup fr = new TeacherSignup();
            fr.setVisible(true);

        }
        else if(e.getSource()==back){
            
            dispose();
            Homepage fr = new Homepage();
            fr.setVisible(true);
        }

    }

    public static void main(String[] args) {
        TeacherLogin fr = new TeacherLogin();
        fr.setVisible(true);
    }

}
