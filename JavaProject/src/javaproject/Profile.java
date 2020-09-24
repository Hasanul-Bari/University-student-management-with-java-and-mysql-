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

    Profile(String s) {
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

        tmp = s;

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

        /*-----------------file-------------------------------------------------------*/
        dir = new File("Data");
        dir.mkdir();

        loc = dir.getAbsolutePath();

        file1 = new File(loc + "/signup.txt");
        file2 = new File(loc + "/message.txt");

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

                if (found == true && (i % 11) == 3) {
                    namf.setText(ss);

                }

                if (found == true && (i % 11) == 4) {
                    bdf.setText(ss);
                }
                if (found == true && (i % 11) == 5) {
                    genf.setText(ss);
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
                    levf.setText(ss);
                }
                if (found == true && (i % 11) == 10) {
                    semf.setText(ss);
                }
                if (found == true && (i % 11) == 0) {
                    sesf.setText(ss);
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
            String ses=sesf.getText();
            String dep=depf.getText();
            String t;

            try {
                Scanner fs = new Scanner(file2);

                int i = 1;
                boolean fo1=false,fo2=false;

                while (fs.hasNext()) {
                    String s = fs.nextLine();
                    i++;
                    
                    //System.out.println(s);
                    
                    if (s.equals("***") ) {
                        
                        i=1;    
                        fo1=false;
                        fo2=false;
                    }
                    else if(i==2 &&  s.equals(ses)){
                        
                        fo1=true;
                    }
                    else if(i==3 && s.equals(dep)){
                        
                        fo2=true;
                    }
                    else if(fo1==true && fo2==true){
                     
                        ta.append(s+"\r\n");
                    }
                        
                    
                    

                }
                fs.close();

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
