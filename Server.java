import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Server  implements ActionListener {
    JTextField textField;
    JPanel a1;
    static JFrame f  = new JFrame();

   static Box vertical = Box.createVerticalBox();
  static DataOutputStream dataOutputStream;
   static DataInputStream dataInputStream;
    Server(){
        f.setLayout(null);
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7,94,82));
        p1.setBounds(0,0,450,70);
        p1.setLayout(null);
        f.add(p1);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(5,20,25,25);
        p1.add(back);

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        ImageIcon i4  = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i5 = i4.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel video= new JLabel(i6);
        video.setBounds(300,20,27,30);
        p1.add(video);


        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i8 = i7.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel phone = new JLabel(i9);
        phone.setBounds(350,17,40,40);
        p1.add(phone);

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i11 = i10.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel d3 = new JLabel(i12);
        d3.setBounds(420,25,5,20);
        p1.add(d3);

        JLabel name = new JLabel("USER1");
        name.setBounds(110,15,100,15);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERTF",Font.BOLD,18));
        p1.add(name);

        JLabel status = new JLabel("Active now");
        status.setBounds(110,35,100,15);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERTF",Font.BOLD,14));
        p1.add(status);

        a1 = new JPanel();
        a1.setBounds(5,70,440,460);
        f.add(a1);

        textField = new JTextField();
        textField.setBounds(5,535,310,35);
        textField.setFont(new Font("SAN_SERTF",Font.PLAIN,16));
        f.add(textField);

        JButton send = new JButton("Send");
        send.setBounds(320,535,110,35);
        send.setBackground(new Color(7,94,84));
        send.setFont(new Font("SAN_SERTF",Font.PLAIN,16));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        f.add(send);


        f.setSize(450,610);
        f.setLocation(200,50);
        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae){
    try {
        String out = textField.getText();


        JPanel p2 = formatLabel(out);
        a1.setLayout(new BorderLayout());

        JPanel right = new JPanel(new BorderLayout());
        right.add(p2, BorderLayout.LINE_END);
        vertical.add(right);
        vertical.add(Box.createHorizontalStrut(16));

        a1.add(vertical, BorderLayout.PAGE_START);

        dataOutputStream.writeUTF(out);

        textField.setText("");

        f.repaint();
        f.invalidate();
        f.validate();
    }
    catch (Exception e){
        e.printStackTrace();
    }

    }

    public static JPanel formatLabel(String out){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        JLabel output = new JLabel(out);
        panel.add(output);
        output.setFont(new Font("Tahoma",Font.PLAIN,16));
        output.setBackground(new Color(37,211,102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15,15,15,50));

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));

        panel.add(time);


        return panel;
    }
    public static void main(String[] args) {
        new Server();
        try{
            ServerSocket skt = new ServerSocket(999);
            while(true){
                Socket s = skt.accept();
                 dataInputStream = new DataInputStream(s.getInputStream());
                dataOutputStream = new DataOutputStream(s.getOutputStream());
                while (true){
                    String msg = dataInputStream.readUTF();
                    JPanel panel = formatLabel(msg);

                    JPanel left = new JPanel(new BorderLayout());
                    left.add(panel,BorderLayout.LINE_START);
                    vertical.add(left);
                    f.validate();
                }

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
