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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public final class StudentSignup extends JFrame implements ActionListener {

    private Container c;

    private ImageIcon img;
    private JLabel imglabel, ul, naml, pl, cpl, bdl, genl, eml, mbl, depl, levl, seml, sesl, lb, lb1, lb2, d, m, y;
    private JTextField uf, namf, bdf, emf, mbf, depf;
    private JPasswordField pf, cpf;

    private Font f, f1, f2;
    private JButton login, clear, signup;

    private File dir, file1;
    String loc;

    private JRadioButton rb1, rb2;
    private ButtonGroup grp;

    private String[] level = {"1", "2", "3", "4"};
    private String[] semester = {"i", "ii"};
    private String[] session, dd, mm, yy;

    private JComboBox cbl, cbsm, cbss, cbd, cbm, cby;

    StudentSignup() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(10, 10, 1340, 720);
        this.setTitle("          Student Sign Up           ");
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

        ul = new JLabel("Student ID : ");
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

        bdl = new JLabel("Date of Birth : ");
        bdl.setBounds(100, 210, 400, 50);
        bdl.setFont(f);
        imglabel.add(bdl);

        genl = new JLabel("Gender : ");
        genl.setBounds(100, 260, 400, 50);
        genl.setFont(f);
        imglabel.add(genl);

        eml = new JLabel("Email : ");
        eml.setBounds(100, 310, 400, 50);
        eml.setFont(f);
        imglabel.add(eml);

        mbl = new JLabel("Contact no : ");
        mbl.setBounds(100, 360, 400, 50);
        mbl.setFont(f);
        imglabel.add(mbl);

        depl = new JLabel("Department : ");
        depl.setBounds(100, 410, 400, 50);
        depl.setFont(f);
        imglabel.add(depl);

        levl = new JLabel("Level : ");
        levl.setBounds(100, 460, 400, 50);
        levl.setFont(f);
        imglabel.add(levl);

        seml = new JLabel("Semester : ");
        seml.setBounds(100, 510, 400, 50);
        seml.setFont(f);
        imglabel.add(seml);

        sesl = new JLabel("Session : ");
        sesl.setBounds(100, 560, 400, 50);
        sesl.setFont(f);
        imglabel.add(sesl);

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

        //-----------------------------------------birthdate
        d = new JLabel("DD:");
        d.setBounds(400, 210, 50, 40);
        d.setFont(f1);
        imglabel.add(d);

        dd = new String[31];

        for (int i = 1; i <= 31; i++) {
            if (i <= 9) {
                dd[i - 1] = "0" + Integer.toString(i);
            } else {
                dd[i - 1] = Integer.toString(i);
            }
        }

        cbd = new JComboBox(dd);
        cbd.setBounds(445, 210, 60, 35);
        cbd.setFont(f1);
        imglabel.add(cbd);
        

        m = new JLabel("MM:");
        m.setBounds(510, 210, 50, 40);
        m.setFont(f1);
        imglabel.add(m);

        mm = new String[12];
        for (int i = 1; i <= 12; i++) {
            if (i <= 9) {
                mm[i - 1] = "0" + Integer.toString(i);
            } else {
                mm[i - 1] = Integer.toString(i);
            }
        }

        cbm = new JComboBox(mm);
        cbm.setBounds(565, 210, 60, 35);
        cbm.setFont(f1);
        imglabel.add(cbm);

        y = new JLabel("YYYY:");
        y.setBounds(635, 210, 65, 40);
        y.setFont(f1);
        imglabel.add(y);

        yy = new String[71];

        for (int i = 1960, j = 0; i <= 2030; i++, j++) {
            yy[j] = Integer.toString(i);
        }

        cby = new JComboBox(yy);
        cby.setBounds(700, 210, 90, 35);
        cby.setFont(f1);
        imglabel.add(cby);

        //---------------------------------gender
        rb1 = new JRadioButton("Male");
        rb1.setBounds(400, 260, 190, 40);
        rb1.setFont(f1);
        rb1.setSelected(true);
        imglabel.add(rb1);

        rb2 = new JRadioButton("Female");
        rb2.setBounds(600, 260, 190, 40);
        rb2.setFont(f1);
        imglabel.add(rb2);

        grp = new ButtonGroup();
        grp.add(rb1);
        grp.add(rb2);

        emf = new JTextField();
        emf.setBounds(400, 310, 400, 40);
        emf.setFont(f1);
        imglabel.add(emf);

        mbf = new JTextField();
        mbf.setBounds(400, 360, 400, 40);
        mbf.setFont(f1);
        imglabel.add(mbf);

        depf = new JTextField();
        depf.setBounds(400, 410, 400, 40);
        depf.setFont(f1);
        imglabel.add(depf);

        //----------------combobox for level semester session
        cbl = new JComboBox(level);
        cbl.setBounds(400, 460, 400, 40);
        cbl.setFont(f1);
        imglabel.add(cbl);

        cbsm = new JComboBox(semester);
        cbsm.setBounds(400, 510, 400, 40);
        cbsm.setFont(f1);
        imglabel.add(cbsm);

        session = new String[22];

        for (int i = 1999, j = 0; i <= 2020; i++, j++) {
            session[j] = Integer.toString(i);
        }
        cbss = new JComboBox(session);
        cbss.setBounds(400, 560, 400, 40);
        cbss.setFont(f1);
        imglabel.add(cbss);

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
        signup.setBounds(1050, 620, 250, 50);
        signup.setFont(f);
        imglabel.add(signup);

        login = new JButton("Back to Log In");
        login.setBounds(750, 620, 250, 50);
        login.setFont(f);
        imglabel.add(login);

        signup.addActionListener(this);
        login.addActionListener(this);
        rb1.addActionListener(this);
        rb2.addActionListener(this);
        cbl.addActionListener(this);
        cbsm.addActionListener(this);
        cbss.addActionListener(this);
        cbd.addActionListener(this);
        cbm.addActionListener(this);
        cby.addActionListener(this);

        /*-----------------file-------------------------------------------------------*/
        dir = new File("Data");
        dir.mkdir();

        loc = dir.getAbsolutePath();

        file1 = new File(loc + "/signup.txt");

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
                        if (s.equals(un) && (i % 11) == 1) {
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

                    String nam, bd, gen = "", em, mb, dep, lev, sem, ses;

                    nam = namf.getText();

                    String d, m, y;
                    d = cbd.getSelectedItem().toString();
                    m = cbm.getSelectedItem().toString();
                    y = cby.getSelectedItem().toString();

                    bd = d + "/" + m + "/" + y;

                    if (rb1.isSelected()) {
                        gen = "Male";
                    } else if (rb2.isSelected()) {
                        gen = "Female";
                    }

                    em = emf.getText();
                    mb = mbf.getText();
                    dep = depf.getText();
                    lev = cbl.getSelectedItem().toString();
                    sem = cbsm.getSelectedItem().toString();
                    ses = cbss.getSelectedItem().toString();

                    try {

                        // Open given file in append mode. 
                        BufferedWriter out = new BufferedWriter(
                                new FileWriter(file1, true));

                        out.write(un + "\r\n");
                        out.write(pass + "\r\n");
                        out.write(nam + "\r\n");
                        out.write(bd + "\r\n");
                        out.write(gen + "\r\n");
                        out.write(em + "\r\n");
                        out.write(mb + "\r\n");
                        out.write(dep + "\r\n");
                        out.write(lev + "\r\n");
                        out.write(sem + "\r\n");
                        out.write(ses + "\r\n");

                        lb.setVisible(false);
                        lb1.setVisible(false);
                        out.close();

                        dispose();
                        Profile fr = new Profile(un);
                        fr.setVisible(true);

                    } catch (IOException ee) {
                        System.out.println("exception occoured" + ee);
                    }

                }

            } else {
                lb.setText("Password not matched ");
                lb.setVisible(true);
            }
        } else if (e.getSource() == login) {

            dispose();
            StudentLogin fr = new StudentLogin();
            fr.setVisible(true);
        }

    }

    public static void main(String[] args) {
        StudentSignup fr = new StudentSignup();
        fr.setVisible(true);
    }

}
