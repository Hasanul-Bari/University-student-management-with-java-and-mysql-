package javaproject;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public final class AdminLogin extends JFrame implements ActionListener {

    private Container c;

    private ImageIcon img;
    private JLabel imglabel, ul, pl, lb1, lb2;
    private JTextField uf;
    private JPasswordField pf;

    private Font f, f1, f2;
    private JButton login, back;

    private File dir, file1;
    String loc;

    AdminLogin() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(10, 10, 1340, 720);
        this.setTitle("          Admin Log In           ");
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

        login = new JButton("Log In");
        login.setBounds(500, 350, 200, 60);
        login.setFont(f);
        imglabel.add(login);

        back = new JButton("Back To Home");
        back.setBounds(950, 600, 350, 60);
        back.setFont(f);
        imglabel.add(back);

        login.addActionListener(this);
        back.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {

            String un = uf.getText();
            String pass = pf.getText();

            if (un.equals("admin") && pass.equals("admin")) {
                dispose();
                LoginRecord fr = new LoginRecord();
                fr.setVisible(true);

            } else {
                lb1.setVisible(true);
            }

        } else if (e.getSource() == back) {

            dispose();
            Homepage fr = new Homepage();
            fr.setVisible(true);
        }

    }

    public static void main(String[] args) {
        AdminLogin fr = new AdminLogin();
        fr.setVisible(true);
    }

}
