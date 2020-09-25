package javaproject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public final class Profile extends JFrame implements ActionListener {

    private Container c;

    private ImageIcon img;
    private JLabel imglabel, prof, ul, naml, pl, cpl, bdl, genl, eml, mbl, facl, depl, levl, seml, sesl, lb, lb1, lb2;
    private JLabel uf, namf, bdf, genf, emf, mbf, facf, depf, levf, semf, sesf;
    private JPasswordField pf, cpf;

    private Font f, f1, f2, f3;
    private JButton logout, edit, showm;
    private JTextArea ta;
    private JScrollPane sp;

    private File dir, file1, file2;
    String loc, tmp;

    Profile(String id) {

        tmp = id;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(10, 10, 1340, 720);
        this.setTitle("          Profile          ");
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

        prof = new JLabel("Student Profile: ");
        prof.setBounds(100, 10, 400, 50);
        prof.setFont(f3);
        imglabel.add(prof);

        naml = new JLabel("Name                   : ");
        naml.setBounds(150, 60, 400, 50);
        naml.setFont(f);
        imglabel.add(naml);

        ul = new JLabel("Student ID         : ");
        ul.setBounds(150, 110, 400, 50);
        ul.setFont(f);
        imglabel.add(ul);

        bdl = new JLabel("Date of Birth  : ");
        bdl.setBounds(150, 160, 400, 50);
        bdl.setFont(f);
        imglabel.add(bdl);

        genl = new JLabel("Gender     : ");
        genl.setBounds(800, 160, 400, 50);
        genl.setFont(f);
        imglabel.add(genl);

        eml = new JLabel("Email                  : ");
        eml.setBounds(150, 210, 400, 50);
        eml.setFont(f);
        imglabel.add(eml);

        mbl = new JLabel("Contact no       : ");
        mbl.setBounds(150, 260, 400, 50);
        mbl.setFont(f);
        imglabel.add(mbl);

        depl = new JLabel("Department     : ");
        depl.setBounds(150, 310, 400, 50);
        depl.setFont(f);
        imglabel.add(depl);

        levl = new JLabel("Level                  : ");
        levl.setBounds(150, 360, 400, 50);
        levl.setFont(f);
        imglabel.add(levl);

        seml = new JLabel("Semester : ");
        seml.setBounds(800, 360, 400, 50);
        seml.setFont(f);
        imglabel.add(seml);

        sesl = new JLabel("Session              : ");
        sesl.setBounds(150, 410, 400, 50);
        sesl.setFont(f);
        imglabel.add(sesl);

        namf = new JLabel();
        namf.setBounds(400, 60, 400, 50);
        namf.setFont(f1);
        imglabel.add(namf);

        uf = new JLabel();
        uf.setBounds(400, 110, 400, 50);
        uf.setFont(f1);
        imglabel.add(uf);

        bdf = new JLabel();
        bdf.setBounds(400, 160, 400, 50);
        bdf.setFont(f1);
        imglabel.add(bdf);

        genf = new JLabel();
        genf.setBounds(980, 160, 400, 50);
        genf.setFont(f1);
        imglabel.add(genf);

        emf = new JLabel();
        emf.setBounds(400, 210, 400, 50);
        emf.setFont(f1);
        imglabel.add(emf);

        mbf = new JLabel();
        mbf.setBounds(400, 260, 400, 50);
        mbf.setFont(f1);
        imglabel.add(mbf);

        depf = new JLabel();
        depf.setBounds(400, 310, 400, 50);
        depf.setFont(f1);
        imglabel.add(depf);

        levf = new JLabel();
        levf.setBounds(400, 360, 400, 50);
        levf.setFont(f1);
        imglabel.add(levf);

        semf = new JLabel();
        semf.setBounds(980, 360, 400, 50);
        semf.setFont(f1);
        imglabel.add(semf);

        sesf = new JLabel();
        sesf.setBounds(400, 410, 400, 50);
        sesf.setFont(f1);
        imglabel.add(sesf);

        logout = new JButton("Log Out");
        logout.setBounds(1050, 620, 250, 50);
        logout.setFont(f);
        imglabel.add(logout);

        edit = new JButton("Edit Profile");
        edit.setBounds(780, 620, 250, 50);
        edit.setFont(f);
        imglabel.add(edit);

        showm = new JButton("Show Messages");
        showm.setBounds(50, 470, 250, 50);
        showm.setFont(f);
        imglabel.add(showm);

        ta = new JTextArea();
        ta.setFont(f1);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        ta.enableInputMethods(false);

        sp = new JScrollPane(ta);
        sp.setVisible(false);
        sp.setBounds(320, 470, 450, 200);

        imglabel.add(sp);

        logout.addActionListener(this);
        edit.addActionListener(this);
        showm.addActionListener(this);

        /*--------------------------------sql----------------------------------*/
        try {

            String url = "jdbc:mysql://localhost/ums";
            String userName = "root";
            String Password = "";

            Class.forName("com.mysql.jdbc.Driver");

            String query = "SELECT * from students where sid=" + id;

            Connection con = DriverManager.getConnection(url, userName, Password);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            rs.next();

            String name = rs.getString("name");
            String dob = rs.getString("dob");
            String gender = rs.getString("gender");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            String dept = rs.getString("dept");
            String level = rs.getString("level");
            String semester = rs.getString("semester");
            String session = rs.getString("session");

            //System.out.println("profile  "+name);
            uf.setText(id);
            namf.setText(name);
            bdf.setText(dob);
            genf.setText(gender);
            emf.setText(email);
            mbf.setText(phone);
            depf.setText(dept);
            levf.setText(level);
            semf.setText(semester);
            sesf.setText(session);

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

        } else if (e.getSource() == edit) {

            dispose();
            EditProfile fr = new EditProfile(tmp);
            fr.setVisible(true);
        } else if (e.getSource() == showm) {

            sp.setVisible(true);
            String ses = sesf.getText();
            String dep = depf.getText();
            String t;

            try {

                String url = "jdbc:mysql://localhost/ums";
                String userName = "root";
                String Password = "";

                Class.forName("com.mysql.jdbc.Driver");

                String query = "SELECT * from messages where session='" +ses+ "' and dept='"+dep+"'";

                Connection con = DriverManager.getConnection(url, userName, Password);
                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery(query);
                
                while (rs.next()){
                    
                    //System.out.println(rs.getString("msgbody"));
                    
                    ta.append("Message from "+rs.getString("tname")+" on "+rs.getString("date")+"\n");
                    
                    ta.append(rs.getString("msgbody")+"\r\n");
                    
                    ta.append("\r\n");
                    
                    
                }
                

            } catch (Exception ee) {
                System.out.println(ee);
            }

        }

    }

    public static void main(String[] args) {
        Profile fr = new Profile("1702065");
        fr.setVisible(true);
    }

}
