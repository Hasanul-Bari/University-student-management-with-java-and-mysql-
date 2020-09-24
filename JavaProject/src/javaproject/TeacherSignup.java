package javaproject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public final class TeacherSignup extends JFrame implements ActionListener {

    private Container c;

    private ImageIcon img;
    private JLabel imglabel, ul, naml, pl, cpl, eml, depl, lb, lb1, lb2;
    private JTextField uf, namf,emf,  depf;
    private JPasswordField pf, cpf;

    private Font f, f1, f2;
    private JButton login, clear, signup;

    private File dir, file1;
    String loc;

    TeacherSignup() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(10, 10, 1340, 720);
        this.setTitle("          Teacher Sign Up           ");
        this.setResizable(true);

        f = new Font("Roboto", Font.BOLD, 25);
        f1 = new Font("Roboto", Font.PLAIN, 22);
        f2 = new Font("Arial", Font.BOLD, 18);

        c = new Container();
        c = this.getContentPane();
        c.setBackground(Color.BLUE);
        c.setLayout(null);

        img = new ImageIcon(getClass().getResource("pic.jpg"));
        imglabel = new JLabel(img);
        imglabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        c.add(imglabel);

        ul = new JLabel("Username : ");
        ul.setBounds(100, 10, 400, 50);
        ul.setFont(f);
        imglabel.add(ul);

        naml = new JLabel("Name : ");
        naml.setBounds(100, 60, 400, 50);
        naml.setFont(f);
        imglabel.add(naml);

        pl = new JLabel("Password : ");
        pl.setBounds(100, 110, 400, 50);
        pl.setFont(f);
        imglabel.add(pl);

        cpl = new JLabel("Confirm Password : ");
        cpl.setBounds(100, 160, 400, 50);
        cpl.setFont(f);
        imglabel.add(cpl);


        eml = new JLabel("Email : ");
        eml.setBounds(100, 210, 400, 50);
        eml.setFont(f);
        imglabel.add(eml);

  
        depl = new JLabel("Department : ");
        depl.setBounds(100, 260, 400, 50);
        depl.setFont(f);
        imglabel.add(depl);

       
        /*---------------------fields--------------------------*/
        uf = new JTextField();
        uf.setBounds(400, 10, 400, 40);
        uf.setFont(f1);
        imglabel.add(uf);

        namf = new JTextField();
        namf.setBounds(400, 60, 400, 40);
        namf.setFont(f1);
        imglabel.add(namf);

        pf = new JPasswordField();
        pf.setBounds(400, 110, 400, 40);
        //pf.setFont(f1);
        c.add(pf);

        cpf = new JPasswordField();
        cpf.setBounds(400, 160, 400, 40);
        //cpf.setFont(f1);
        c.add(cpf);

        

        emf = new JTextField();
        emf.setBounds(400, 210, 400, 40);
        emf.setFont(f1);
        imglabel.add(emf);

        
        depf = new JTextField();
        depf.setBounds(400, 260, 400, 40);
        depf.setFont(f1);
        imglabel.add(depf);

      

        lb = new JLabel("*Password doesn't match");
        lb.setBounds(810, 160, 400, 50);
        lb.setForeground(Color.RED);
        lb.setVisible(false);
        lb.setFont(f2);
        imglabel.add(lb);

        lb1 = new JLabel("*ID already exists");
        lb1.setBounds(810, 10, 400, 50);
        lb1.setForeground(Color.RED);
        lb1.setVisible(false);
        lb1.setFont(f2);
        imglabel.add(lb1);

        signup = new JButton("Sign Up");
        signup.setBounds(1000, 620, 200, 50);
        signup.setFont(f);
        imglabel.add(signup);
        
        login = new JButton("Back to Log In");
        login.setBounds(700, 620, 250, 50);
        login.setFont(f);
        imglabel.add(login);

        signup.addActionListener(this);
        login.addActionListener(this);

        /*-----------------file-------------------------------------------------------*/
        dir = new File("Data");
        dir.mkdir();

        loc = dir.getAbsolutePath();
        System.out.println(loc);

        file1 = new File(loc + "/teacherinfo.txt");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == signup) {

            String pass = pf.getText();
            String cpass = cpf.getText();

            if (pass.equals(cpass)) {

                String un = uf.getText();

                boolean dupli = false;

                try {
                    Scanner fs = new Scanner(file1);

                    int i = 0;

                    while (fs.hasNext()) {
                        String s = fs.nextLine();
                        i++;
                        //System.out.println(s);
                        if (s.equals(un) && (i % 5) == 1) {
                            lb1.setText("ID already exists");
                            lb1.setVisible(true);
                            dupli = true;

                            break;
                        }

                    }
                    fs.close();

                } catch (Exception ee) {
                    System.out.println(ee);
                }

                //write
                if (dupli == false) {

                    String nam,em, dep;

                    nam = namf.getText();
                    em = emf.getText(); 
                    dep = depf.getText();
                   

                    try {

                        // Open given file in append mode. 
                        BufferedWriter out = new BufferedWriter(
                                new FileWriter(file1, true));

                        out.write(un + "\r\n");
                        out.write(pass + "\r\n");
                        out.write(nam + "\r\n"); 
                        out.write(em + "\r\n");     
                        out.write(dep + "\r\n");
                        

                        lb.setVisible(false);
                        lb1.setVisible(false);
                        out.close();

                        dispose();
                        TProfile fr = new TProfile(un);
                        fr.setVisible(true);
                        
                        
                    } catch (IOException ee) {
                        System.out.println("exception occoured" + ee);
                    }

                }

            } else {
                lb.setText("Password not matched ");
                lb.setVisible(true);
            }
        }
        else if(e.getSource()==login){
            
            dispose();
            TeacherLogin fr = new TeacherLogin();
            fr.setVisible(true);
        }

    }

    public static void main(String[] args) {
        TeacherSignup fr = new TeacherSignup();
        fr.setVisible(true);
    }

}
