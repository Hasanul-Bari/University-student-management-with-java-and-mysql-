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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
    private JLabel imglabel, mbl, naml, pl, cpl, eml, depl, lb, lb1, lb2;
    private JTextField mbf, namf, emf, depf;
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

        naml = new JLabel("Name : ");
        naml.setBounds(100, 10, 400, 50);
        naml.setFont(f);
        imglabel.add(naml);

        pl = new JLabel("Password : ");
        pl.setBounds(100, 60, 400, 50);
        pl.setFont(f);
        imglabel.add(pl);

        cpl = new JLabel("Confirm Password : ");
        cpl.setBounds(100, 110, 400, 50);
        cpl.setFont(f);
        imglabel.add(cpl);

        eml = new JLabel("Email : ");
        eml.setBounds(100, 160, 400, 50);
        eml.setFont(f);
        imglabel.add(eml);

        mbl = new JLabel("Contact No. : ");
        mbl.setBounds(100, 210, 400, 50);
        mbl.setFont(f);
        imglabel.add(mbl);

        depl = new JLabel("Department : ");
        depl.setBounds(100, 260, 400, 50);
        depl.setFont(f);
        imglabel.add(depl);

        /*---------------------fields--------------------------*/
        namf = new JTextField();
        namf.setBounds(400, 10, 400, 40);
        namf.setFont(f1);
        imglabel.add(namf);

        pf = new JPasswordField();
        pf.setBounds(400, 60, 400, 40);
        //pf.setFont(f1);
        imglabel.add(pf);

        cpf = new JPasswordField();
        cpf.setBounds(400, 110, 400, 40);
        //cpf.setFont(f1);
        c.add(cpf);

        emf = new JTextField();
        emf.setBounds(400, 160, 400, 40);
        emf.setFont(f1);
        c.add(emf);

        mbf = new JTextField();
        mbf.setBounds(400, 210, 400, 40);
        mbf.setFont(f1);
        imglabel.add(mbf);

        depf = new JTextField();
        depf.setBounds(400, 260, 400, 40);
        depf.setFont(f1);
        imglabel.add(depf);

        lb = new JLabel("*Password doesn't match");
        lb.setBounds(810, 110, 400, 50);
        lb.setForeground(Color.RED);
        lb.setVisible(false);
        lb.setFont(f2);
        imglabel.add(lb);

        lb1 = new JLabel("*ID with email already exists");
        lb1.setBounds(810, 160, 400, 50);
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

      
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == signup) {
            
            lb1.setVisible(false);
            lb.setVisible(false);

            String pass = pf.getText();
            String cpass = cpf.getText();
            String email = emf.getText();

            if (email.equals("")) {
                lb1.setText("Enter a valid Email");
                lb1.setVisible(true);
            } else if (pass.equals(cpass)) {

                try {

                    String url = "jdbc:mysql://localhost/ums";
                    String userName = "root";
                    String Password = "";

                    Class.forName("com.mysql.jdbc.Driver");

                    String query = "SELECT COUNT(*) FROM teachers where email='"+email+"'";

                    Connection con = DriverManager.getConnection(url, userName, Password);
                    Statement st = con.createStatement();

                    ResultSet rs = st.executeQuery(query);

                    rs.next();

                    String cnt = rs.getString("COUNT(*)");

                    System.out.println(cnt);

                    if (cnt.equals("1")) {
                        lb1.setText("Email already exists");
                        lb1.setVisible(true);
                    } else {
                        /*------------------------------------------insert data--------------------------*/

                        String query2 = "INSERT INTO teachers VALUES (?,?,?,?,?)";

                        //Connection con2 = DriverManager.getConnection(url, userName, Password);
                        PreparedStatement st2 = con.prepareStatement(query2);

                        /*-------------------------------getting data from textfield-------------*/
                        
                        String nam,phn, dep;

                        nam = namf.getText();
                        phn = mbf.getText(); 
                        dep = depf.getText();

                        /*-------------------------------inserting  data  into statement-------------*/
                        st2.setString(1, nam);
                        st2.setString(2, pass);
                        st2.setString(3, email);
                        st2.setString(4, dep);
                        st2.setString(5, phn);
                        

                        int count = st2.executeUpdate();

                        System.out.println(count + " rows affected");
                        if (count == 1) {
                            dispose();
                            TProfile fr = new TProfile(email);
                            fr.setVisible(true);
                        } else {
                            System.out.println("signup failed");
                        }

                    }

                } catch (Exception ee) {
                    System.out.println(ee);
                }

            } else {
                lb.setText("Password not matched ");
                lb.setVisible(true);
            }
            
            
        } else if (e.getSource() == login) {

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
