import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View extends JPanel {
    private int width = 360;
    private int height = 640;

    private Logic logic;
    private Image bgImage;

    //constructor
    public View(Logic logic){
        this.logic = logic;
        setPreferredSize(new Dimension(width, height));

        //menyiapkan bg
        bgImage = new ImageIcon(getClass().getResource("assets/background.png")).getImage();

        setLayout(null);

        //untuk menampilkan score ke layar
        JLabel scoreLabel = logic.getScoreLabel();
        scoreLabel.setBounds(130,10,150,30);
        add(scoreLabel);

        //membuat panel bisa menerima input dari keyboard
        setFocusable(true);
        //menghubungkan keyboard dengan class logic
        addKeyListener(logic);
    }

    //untuk mengambar semua elemen
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    //mengambar background
    public void draw(Graphics g){
        if (bgImage != null){
            g.drawImage(bgImage, 0, 0, width, height, null);
        }
        //menggambar player(burung)
        Player player = logic.getPlayer();
        if (player != null){
            g.drawImage(player.getImage(), player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight(), null);
        }
        //menggambar pipa
        ArrayList<Pipe> pipes = logic.getPipes();
        if (pipes != null){
            for (int i = 0; i < pipes.size(); i++){
                Pipe pipe = pipes.get(i);
                g.drawImage(pipe.getImage(), pipe.getPosX(), pipe.getPosY(), pipe.getWidth(), pipe.getHeight(), null);
            }
        }
        //untuk tampilan jika kalah
        if (logic.isGameOver()){
            logic.getScoreLabel().setVisible(false);
            g.setColor(Color.RED);
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
            g.drawString("GAME OVER", 70, 200);

            g.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
            g.setColor(Color.WHITE);
            g.drawString("Final Score : " + logic.getScore(), 85, 240);

            g.setColor(Color.ORANGE);
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
            g.drawString("press R for restart", 85, 280);
            g.drawString("press M for menu", 85, 320);
        }
    }
}
