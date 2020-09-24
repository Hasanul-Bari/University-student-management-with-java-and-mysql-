package javaproject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public final class LoginRecord extends JFrame implements ActionListener {

    private Container c;

    private ImageIcon img;
    private JLabel imglabel, lb;

    private Font f, f1, f2;
    private JButton  delete, logout;

    private File dir, file1, file2;
    String loc;

    private String[] col = {"Name", "Student Id", "Date of Birth", "Gender", "E-mail", "Contact number", "Department", "Level", "Semester", "Session"};
    private String[] row = new String[10];

    private JTable tb;
    private DefaultTableModel model;
    private JScrollPane sp;

    LoginRecord() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(10, 10, 1340, 720);
        this.setTitle("          Admin Log In           ");
        this.setResizable(true);

        f = new Font("Algerian", Font.BOLD, 35);
        f1 = new Font("Roboto", Font.BOLD, 20);
        f2 = new Font("Roboto", Font.BOLD, 25);

        c = new Container();
        c = this.getContentPane();
        c.setBackground(Color.BLUE);
        c.setLayout(null);

        img = new ImageIcon(getClass().getResource("pic.jpg"));
        imglabel = new JLabel(img);
        imglabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        c.add(imglabel);

        lb = new JLabel("Log In Record");
        lb.setBounds(100, 20, 400, 50);
        lb.setFont(f);
        imglabel.add(lb);

        tb = new JTable();

        model = new DefaultTableModel();
        model.setColumnIdentifiers(col);
        tb.setModel(model);

        tb.setBackground(Color.WHITE);
        tb.setSelectionBackground(Color.GREEN);
        tb.setFont(f1);
        tb.setRowHeight(20);

        sp = new JScrollPane(tb);
        sp.setBounds(100, 100, 1150, 400);
        imglabel.add(sp);

        delete = new JButton("Delete");
        delete.setBounds(650, 550, 200, 50);
        delete.setFont(f2);
        imglabel.add(delete);

        logout = new JButton("Log Out");
        logout.setBounds(1050, 600, 200, 50);
        logout.setFont(f2);
        imglabel.add(logout);

        delete.addActionListener(this);
        logout.addActionListener(this);

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
                if ((i % 11) == 1) {

                    row[1] = ss;

                }

                if ((i % 11) == 3) {

                    row[0] = ss;
                }

                if ((i % 11) == 4) {

                    row[2] = ss;
                }
                if ((i % 11) == 5) {
                    row[3] = ss;
                }
                if ((i % 11) == 6) {
                    row[4] = ss;
                }
                if ((i % 11) == 7) {
                    row[5] = ss;
                }
                if ((i % 11) == 8) {
                    row[6] = ss;
                }
                if ((i % 11) == 9) {
                    row[7] = ss;
                }
                if ((i % 11) == 10) {
                    row[8] = ss;
                }
                if ((i % 11) == 0) {
                    row[9] = ss;
                    model.addRow(row);

                }

            }
            fs.close();

        } catch (Exception ee) {
            System.out.println(ee);
        }

        /*-----------------------------mouselistener----------------------------------*/
        tb.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent me) {

                int rowno = tb.getSelectedRow();

                String nam = model.getValueAt(rowno, 0).toString();
                String un = model.getValueAt(rowno, 1).toString();
                String bd = model.getValueAt(rowno, 2).toString();
                String gen = model.getValueAt(rowno, 3).toString();
                String em = model.getValueAt(rowno, 4).toString();
                String mb = model.getValueAt(rowno, 5).toString();
                String dep = model.getValueAt(rowno, 6).toString();
                String lev = model.getValueAt(rowno, 7).toString();
                String sem = model.getValueAt(rowno, 8).toString();
                String ses = model.getValueAt(rowno, 9).toString();
                

                /*-----------------------writing all to temp file with edit--------------*/
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

                            fm.format(s + "\r\n");
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

            }

        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == logout) {

            dispose();
            Homepage fr = new Homepage();
            fr.setVisible(true);

        } else if (e.getSource() == delete) {

            int rowno = tb.getSelectedRow();

            if (rowno >= 0) {

                String un = model.getValueAt(rowno, 1).toString();
               

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

                dispose();
                LoginRecord fr = new LoginRecord();
                fr.setVisible(true);

                /*--------------profile deleted---------------------------*/
            } else {
                JOptionPane.showMessageDialog(null, "NO row is selected or NO row exists");
            }

        }

    }

    public static void main(String[] args) {
        LoginRecord fr = new LoginRecord();
        fr.setVisible(true);
    }

}
