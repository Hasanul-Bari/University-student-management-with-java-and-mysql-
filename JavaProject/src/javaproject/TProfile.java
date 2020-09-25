package javaproject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public final class TProfile extends JFrame implements ActionListener {

    private Container c;

    private ImageIcon img;
    private JLabel imglabel, prof, ul, naml, pl, cpl, eml, mbl, depl, lb, lb1, lb2, depl2, sesl, datl;
    private JTextField depf2, sesf, datf;
    private JLabel uf, namf, emf, depf, mbf;
    private JPasswordField pf, cpf;
    private JTextArea ta;
    private JScrollPane sp;

    private Font f, f1, f2, f3;
    private JButton logout, writemsg, submit;

    TProfile(String email) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(10, 10, 1340, 720);
        this.setTitle("       Teacher   Profile          ");
        this.setResizable(true);

        f = new Font("Algerian", Font.BOLD, 25);
        f1 = new Font("Roboto", Font.PLAIN, 22);
        f2 = new Font("Arial", Font.BOLD, 18);
        f3 = new Font("Algerian", Font.BOLD, 30);

        c = new Container();
        c = this.getContentPane();
        c.setBackground(Color.BLUE);
        c.setLayout(null);

        img = new ImageIcon(getClass().getResource("pic.jpg"));
        imglabel = new JLabel(img);
        imglabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        c.add(imglabel);

        prof = new JLabel("Teacher Profile: ");
        prof.setBounds(100, 10, 400, 50);
        prof.setFont(f3);
        imglabel.add(prof);

        naml = new JLabel("Name                   : ");
        naml.setBounds(150, 60, 400, 50);
        naml.setFont(f);
        imglabel.add(naml);

        eml = new JLabel("Email                  : ");
        eml.setBounds(150, 110, 400, 50);
        eml.setFont(f);
        imglabel.add(eml);

        mbl = new JLabel("Contact No.            : ");
        mbl.setBounds(150, 160, 400, 50);
        mbl.setFont(f);
        imglabel.add(mbl);

        depl = new JLabel("Department     : ");
        depl.setBounds(150, 210, 400, 50);
        depl.setFont(f);
        imglabel.add(depl);

        namf = new JLabel();
        namf.setBounds(400, 60, 400, 50);
        namf.setFont(f1);
        imglabel.add(namf);

        emf = new JLabel();
        emf.setBounds(400, 110, 400, 50);
        emf.setFont(f1);
        imglabel.add(emf);

        mbf = new JLabel();
        mbf.setBounds(400, 160, 400, 50);
        mbf.setFont(f1);
        imglabel.add(mbf);

        depf = new JLabel();
        depf.setBounds(400, 210, 400, 50);
        depf.setFont(f1);
        imglabel.add(depf);

        depl2 = new JLabel("Department :");
        depl2.setBounds(680, 360, 300, 50);
        depl2.setFont(f);
        imglabel.add(depl2);

        sesl = new JLabel("Session          :");
        sesl.setBounds(680, 420, 300, 50);
        sesl.setFont(f);
        imglabel.add(sesl);

        datl = new JLabel("Date               :");
        datl.setBounds(680, 480, 300, 50);
        datl.setFont(f);
        imglabel.add(datl);

        depf2 = new JTextField();
        depf2.setBounds(880, 360, 250, 50);
        depf2.setFont(f1);
        imglabel.add(depf2);

        sesf = new JTextField();
        sesf.setBounds(880, 420, 250, 50);
        sesf.setFont(f1);
        imglabel.add(sesf);

        datf = new JTextField();
        datf.setBounds(880, 480, 250, 50);
        datf.setFont(f1);
        imglabel.add(datf);

        logout = new JButton("Log Out");
        logout.setBounds(1000, 620, 300, 50);
        logout.setFont(f);
        imglabel.add(logout);

        writemsg = new JButton("Write Message");
        writemsg.setBounds(150, 300, 300, 50);
        writemsg.setFont(f);
        imglabel.add(writemsg);

        submit = new JButton("Submit");
        submit.setBounds(150, 600, 200, 50);
        submit.setFont(f);
        imglabel.add(submit);

        ta = new JTextArea();
        ta.setFont(f1);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);

        sp = new JScrollPane(ta);
        sp.setBounds(150, 360, 400, 200);

        imglabel.add(sp);

        logout.addActionListener(this);
        writemsg.addActionListener(this);
        submit.addActionListener(this);

        /*--------------------------------sql----------------------------------*/
        try {

            String url = "jdbc:mysql://localhost/ums";
            String userName = "root";
            String Password = "";

            Class.forName("com.mysql.jdbc.Driver");

            String query = "SELECT * from teachers where email='" + email + "'";

            Connection con = DriverManager.getConnection(url, userName, Password);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            rs.next();

            String name = rs.getString("name");
            String phone = rs.getString("phone");
            String dept = rs.getString("dept");

            //System.out.println("profile  "+name);
            namf.setText(name);
            emf.setText(email);
            mbf.setText(phone);
            depf.setText(dept);

        } catch (Exception ee) {

            System.out.println(ee);
        }

        /*--------------------------------sql----------------------------------*/
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == logout) {

            dispose();
            Homepage fr = new Homepage();
            fr.setVisible(true);

        }
        if (e.getSource() == submit) {

            String s = ta.getText();
            String ses = sesf.getText();
            String dep = depf2.getText();
            String dat = datf.getText();
            String n = namf.getText();

            try {

                String url = "jdbc:mysql://localhost/ums";
                String userName = "root";
                String Password = "";

                Class.forName("com.mysql.jdbc.Driver");

                String query = "INSERT INTO messages VALUES (?,?,?,?,?)";

                Connection con = DriverManager.getConnection(url, userName, Password);
                PreparedStatement st = con.prepareStatement(query);

                /*-------------------------------inserting  data  into statement-------------*/
                st.setString(1, s);
                st.setString(2, dat);
                st.setString(3, n);
                st.setString(4, ses);
                st.setString(5, dep);

                int count = st.executeUpdate();

                if (count == 1) {
                    JOptionPane.showMessageDialog(null, "Message send successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Message send failed");
                }

                

            } catch (Exception ee) {
                System.out.println("exception occoured" + ee);
            }

            //System.out.println(ta.getText());
        }

    }

    public static void main(String[] args) {
        TProfile fr = new TProfile("hasan@gmail.com");
        fr.setVisible(true);
    }

}
