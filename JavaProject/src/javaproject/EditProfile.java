package javaproject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public final class EditProfile extends JFrame implements ActionListener {

    private Container c;

    private ImageIcon img;
    private JLabel imglabel, prof, ul, naml, pl, cpl, bdl, genl, eml, mbl, facl, depl, levl, seml, sesl, lb, lb1, lb2, uf, d, m, y;
    private JTextField namf, bdf, genf, emf, mbf, facf, depf, levf, semf, sesf, pff;
    private JPasswordField pf, cpf;

    private Font f, f1, f2, f3;
    private JButton save, delete;

    private File dir, file1, file2;
    String loc, temp;

    private JRadioButton rb1, rb2;
    private ButtonGroup grp;

    private String[] level = {"1", "2", "3", "4"};
    private String[] semester = {"i", "ii"};
    private String[] session, dd, mm, yy;

    private JComboBox cbl, cbsm, cbss, cbd, cbm, cby;

    EditProfile(String s) {
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

        prof = new JLabel("Edit Profile: ");
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
        genl.setBounds(850, 160, 400, 50);
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
        seml.setBounds(850, 360, 400, 50);
        seml.setFont(f);
        imglabel.add(seml);

        sesl = new JLabel("Session              : ");
        sesl.setBounds(150, 410, 400, 50);
        sesl.setFont(f);
        imglabel.add(sesl);

        pl = new JLabel("Change Password : ");
        pl.setBounds(150, 470, 400, 50);
        pl.setFont(f);
        imglabel.add(pl);

        namf = new JTextField();
        namf.setBounds(400, 60, 400, 50);
        namf.setFont(f1);
        imglabel.add(namf);

        uf = new JLabel();
        uf.setBounds(400, 110, 400, 50);
        uf.setFont(f1);
        imglabel.add(uf);

        //---------------------------------------------birthdate
        d = new JLabel("DD:");
        d.setBounds(400, 160, 50, 40);
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
        cbd.setBounds(445, 160, 60, 35);
        cbd.setFont(f1);
        imglabel.add(cbd);

        m = new JLabel("MM:");
        m.setBounds(510, 160, 50, 40);
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
        cbm.setBounds(565, 160, 60, 35);
        cbm.setFont(f1);
        imglabel.add(cbm);

        y = new JLabel("YYYY:");
        y.setBounds(635, 160, 65, 40);
        y.setFont(f1);
        imglabel.add(y);

        yy = new String[71];

        for (int i = 1960, j = 0; i <= 2030; i++, j++) {
            yy[j] = Integer.toString(i);
        }

        cby = new JComboBox(yy);
        cby.setBounds(700, 160, 90, 35);
        cby.setFont(f1);
        imglabel.add(cby);

        //--------------------------------gender radio---------------
        rb1 = new JRadioButton("Male");
        rb1.setBounds(1030, 160, 100, 40);
        rb1.setFont(f1);
        rb1.setSelected(true);
        imglabel.add(rb1);

        rb2 = new JRadioButton("Female");
        rb2.setBounds(1150, 160, 100, 40);
        rb2.setFont(f1);
        imglabel.add(rb2);

        grp = new ButtonGroup();
        grp.add(rb1);
        grp.add(rb2);

        emf = new JTextField();
        emf.setBounds(400, 210, 400, 50);
        emf.setFont(f1);
        imglabel.add(emf);

        mbf = new JTextField();
        mbf.setBounds(400, 260, 400, 50);
        mbf.setFont(f1);
        imglabel.add(mbf);

        depf = new JTextField();
        depf.setBounds(400, 310, 400, 50);
        depf.setFont(f1);
        imglabel.add(depf);

        //----------------combobox for level semester session
        cbl = new JComboBox(level);
        cbl.setBounds(400, 365, 400, 40);
        cbl.setFont(f1);
        imglabel.add(cbl);

        cbsm = new JComboBox(semester);
        cbsm.setBounds(1030, 360, 200, 40);
        cbsm.setFont(f1);
        imglabel.add(cbsm);

        session = new String[22];

        for (int i = 1999, j = 0; i <= 2020; i++, j++) {
            session[j] = Integer.toString(i);
        }
        cbss = new JComboBox(session);
        cbss.setBounds(400, 415, 400, 40);
        cbss.setFont(f1);
        imglabel.add(cbss);

        pff = new JTextField();
        pff.setBounds(420, 470, 400, 50);
        pff.setFont(f1);
        imglabel.add(pff);

        save = new JButton("Save Profile");
        save.setBounds(1000, 620, 300, 50);
        save.setFont(f);
        imglabel.add(save);

        delete = new JButton("Delete Profile");
        delete.setBounds(650, 620, 300, 50);
        delete.setFont(f);
        imglabel.add(delete);

        save.addActionListener(this);
        delete.addActionListener(this);
        temp = s;

        /*-----------------file-------------------------------------------------------*/
        dir = new File("Data");
        dir.mkdir();

        loc = dir.getAbsolutePath();

        file1 = new File(loc + "/signup.txt");
        file2 = new File(loc + "/temp.txt");

        try {
            Scanner fs = new Scanner(file1);

            int i = 0;
            boolean found = false;

            while (fs.hasNext()) {
                String ss = fs.nextLine();
                i++;

                //System.out.println(ss+" "+i);
                if (ss.equals(s) && (i % 11) == 1) {
                    found = true;

                    uf.setText(ss);
                }
                if (found == true && (i % 11) == 2) {
                    pff.setText(ss);
                }

                if (found == true && (i % 11) == 3) {
                    namf.setText(ss);
                }

                if (found == true && (i % 11) == 4) {
                    //bdf.setText(ss);

                    String d, m, y;
                    d = ss.substring(0, 2);
                    m = ss.substring(3, 5);
                    y = ss.substring(6, 10);

                    cbd.setSelectedItem(d);
                    cbm.setSelectedItem(m);
                    cby.setSelectedItem(y);

                }
                if (found == true && (i % 11) == 5) {
                    //genf.setText(ss);

                    if (ss.equals("Male")) {
                        rb1.setSelected(true);
                    } else if (ss.equals("Female")) {
                        rb2.setSelected(true);
                    }
                }
                if (found == true && (i % 11) == 6) {
                    emf.setText(ss);
                }
                if (found == true && (i % 11) == 7) {
                    mbf.setText(ss);
                }
                if (found == true && (i % 11) == 8) {
                    depf.setText(ss);
                }
                if (found == true && (i % 11) == 9) {
                    cbl.setSelectedItem(ss);
                }
                if (found == true && (i % 11) == 10) {
                    cbsm.setSelectedItem(ss);
                }
                if (found == true && (i % 11) == 0) {
                    cbss.setSelectedItem(ss);
                    break;
                }

            }
            fs.close();

        } catch (Exception ee) {
            System.out.println(ee);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == save) {

            String un = uf.getText();

            String pass, nam, bd, gen = "", em, mb, dep, lev, sem, ses;

            pass = pff.getText();
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
                Scanner fs = new Scanner(file1);

                Formatter fm = new Formatter(loc + "/temp.txt");

                int i = 0;
                boolean found = false;

                while (fs.hasNext()) {
                    String s = fs.nextLine();
                    i++;
                    //System.out.println(s);

                    if (s.equals(un) && (i % 11) == 1) {

                        found = true;

                        fm.format(un + "\r\n");
                    } else if (found == true && (i % 11) == 2) {

                        fm.format(pass + "\r\n");
                    } else if (found == true && (i % 11) == 3) {

                        fm.format(nam + "\r\n");
                    } else if (found == true && (i % 11) == 4) {

                        fm.format(bd + "\r\n");
                    } else if (found == true && (i % 11) == 5) {

                        fm.format(gen + "\r\n");
                    } else if (found == true && (i % 11) == 6) {

                        fm.format(em + "\r\n");
                    } else if (found == true && (i % 11) == 7) {

                        fm.format(mb + "\r\n");
                    } else if (found == true && (i % 11) == 8) {

                        fm.format(dep + "\r\n");
                    } else if (found == true && (i % 11) == 9) {

                        fm.format(lev + "\r\n");
                    } else if (found == true && (i % 11) == 10) {

                        fm.format(sem + "\r\n");
                    } else if (found == true && (i % 11) == 0) {

                        fm.format(ses + "\r\n");
                        found = false;
                    } else {

                        fm.format(s + "\r\n");
                    }

                }
                fs.close();
                fm.close();

            } catch (Exception ee) {
                System.out.println(ee);
            }

            //---------------------------------transfer from temp to signup-----------------------------//
            try {

                Scanner fs = new Scanner(file2);

                Formatter fm = new Formatter(loc + "/signup.txt");

                while (fs.hasNext()) {

                    String s = fs.nextLine();
                    fm.format(s + "\r\n");
                }
                fs.close();
                fm.close();

            } catch (Exception ee) {
                System.out.println(ee);
            }

            /*------------------------------------show profile-------------------------------------*/
            dispose();
            Profile fr = new Profile(un);
            fr.setVisible(true);
        } else if (e.getSource() == delete) {

            int choice = JOptionPane.showConfirmDialog(null, "Do you want to delete", "warning", JOptionPane.YES_NO_OPTION);
            //System.out.println(choice);

            if (choice == 0) {

                String un = uf.getText();

            try {
                Scanner fs = new Scanner(file1);

                Formatter fm = new Formatter(loc + "/temp.txt");

                int i = 0;
                boolean found = false;

                while (fs.hasNext()) {
                    String s = fs.nextLine();
                    i++;
                    //System.out.println(s);

                    if (s.equals(un) && (i % 11) == 1) {

                        found = true;

                    } else if (found == true && (i % 11) == 2) {

                    } else if (found == true && (i % 11) == 3) {

                    } else if (found == true && (i % 11) == 4) {

                    } else if (found == true && (i % 11) == 5) {

                    } else if (found == true && (i % 11) == 6) {

                    } else if (found == true && (i % 11) == 7) {

                    } else if (found == true && (i % 11) == 8) {

                    } else if (found == true && (i % 11) == 9) {

                    } else if (found == true && (i % 11) == 10) {

                    } else if (found == true && (i % 11) == 0) {

                        found = false;
                    } else {

                        fm.format(s + "\r\n");
                    }

                }
                fs.close();
                fm.close();

            } catch (Exception ee) {
                System.out.println(ee);
            }

            //---------------------------------transfer from temp to signup-----------------------------//
            try {

                Scanner fs = new Scanner(file2);

                Formatter fm = new Formatter(loc + "/signup.txt");

                while (fs.hasNext()) {

                    String s = fs.nextLine();
                    fm.format(s + "\r\n");
                }
                fs.close();
                fm.close();

            } catch (Exception ee) {
                System.out.println(ee);
            }

            /*--------------profile deleted---------------------------*/
                dispose();
                StudentLogin fr = new StudentLogin();
                fr.setVisible(true);

            }

        }

    }

    public static void main(String[] args) {
        EditProfile fr = new EditProfile("1702065");
        fr.setVisible(true);
    }

}
