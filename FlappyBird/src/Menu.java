import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {
    private JFrame frame;
    private Image bgImage;

    public Menu (JFrame frame){
        this.frame = frame;
        setLayout(null);
        setPreferredSize(new Dimension(360, 640));

        bgImage = new ImageIcon(getClass().getResource("assets/background.png")).getImage(); //menampilkan background

        JLabel title = new JLabel("FLAPPY BIRD", SwingConstants.CENTER); //judul game
        title.setForeground(Color.YELLOW);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
        title.setBounds(50, 150, 260, 50);
        add(title);

        //button mulai
        JButton startButton = new JButton("MULAI");
        startButton.setBounds(130,250,100,40);
        startButton.setFont(new Font("Unispace", Font.BOLD, 18));
        add(startButton);

        //button exit
        JButton ExitButton = new JButton("KELUAR");
        ExitButton.setBounds(130,310,100,40);
        ExitButton.setFont(new Font("Unispace", Font.BOLD, 18));
        add(ExitButton);

        //aksti tombol mulai
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        //aksi tombol keluar
        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    //menampilkan background
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if (bgImage != null){
            g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), null);
        }
    }

    private void startGame(){
        frame.getContentPane().removeAll(); //menghapus tampilan menu
        Logic logic = new Logic(); //membuat objek baru
        View view = new View(logic);
        logic.setView(view); //menghubungkan logika dengan view
        frame.add(view);//menambahkan tampilan
        frame.revalidate();//refresh tampilan jendela agar langsung muncul
        frame.repaint();
        view.requestFocus(); //memastikan keybord listener aktif
    }


}
