package javaproject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
    private JButton delete, logout;


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

        try {

            String url = "jdbc:mysql://localhost/ums";
            String userName = "root";
            String Password = "";

            String query = "SELECT * FROM students;";

            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, userName, Password);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                //String name = rs.getString("name");
                //int id = rs.getInt("sid");

                //System.out.println(name+" "+id);
                row[0] = rs.getString("name");
                row[1] = rs.getString("sid");
                row[2] = rs.getString("dob");
                row[3] = rs.getString("gender");
                row[4] = rs.getString("email");
                row[5] = rs.getString("phone");
                row[6] = rs.getString("dept");
                row[7] = rs.getString("level");
                row[8] = rs.getString("semester");
                row[9] = rs.getString("session");

                model.addRow(row);
            }

            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        /*-----------------------------mouselistener----------------------------------*/
        tb.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent me) {

                int rowno = tb.getSelectedRow();

                String nam = model.getValueAt(rowno, 0).toString();
                String id = model.getValueAt(rowno, 1).toString();
                String bd = model.getValueAt(rowno, 2).toString();
                String gen = model.getValueAt(rowno, 3).toString();
                String em = model.getValueAt(rowno, 4).toString();
                String mb = model.getValueAt(rowno, 5).toString();
                String dep = model.getValueAt(rowno, 6).toString();
                String lev = model.getValueAt(rowno, 7).toString();
                String sem = model.getValueAt(rowno, 8).toString();
                String ses = model.getValueAt(rowno, 9).toString();
                
                
                                
                try {

                    String url = "jdbc:mysql://localhost/ums";
                    String userName = "root";
                    String Password = "";

                    Class.forName("com.mysql.jdbc.Driver");
                    
                    
                    /*-----------------make update query--------------------------------------------*/

                    String query = "UPDATE students set name='"+nam+"', dob='"+bd+"', email='"+em+"', phone='"+mb+"', dept='"+dep+"', level='"+lev+"', semester='"+sem+"', session='"+ses+"', gender='"+gen+"' where sid="+id;
                    
                    //System.out.println(id);
                    
                    Connection con=DriverManager.getConnection(url,userName,Password);
                    Statement st=con.createStatement();

                    st.executeUpdate(query);
                    
                    
                
                }catch (Exception ee) {     
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

                int choice = JOptionPane.showConfirmDialog(null, "Do you want to delete", "warning", JOptionPane.YES_NO_OPTION);

                if (choice == 0) {

                    /*--------------------------------------delete profile----------------------*/
                    
                    String id = model.getValueAt(rowno, 1).toString();

                    //System.out.println(id);
                    
                    try {

                        String url = "jdbc:mysql://localhost/ums";
                        String userName = "root";
                        String Password = "";

                        Class.forName("com.mysql.jdbc.Driver");

                        String query = "Delete from students where sid=" +id;

                        Connection con = DriverManager.getConnection(url, userName, Password);
                        Statement st = con.createStatement();

                        st.executeUpdate(query);

                        /*--------------profile deleted---------------------------*/
                        dispose();
                        StudentLogin fr = new StudentLogin();
                        fr.setVisible(true);

                    } catch (Exception ee) {
                        System.out.println(ee);
                    }

                    dispose();
                    LoginRecord fr = new LoginRecord();
                    fr.setVisible(true);

                    /*--------------profile deleted---------------------------*/
                }

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
