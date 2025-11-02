import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Logic implements ActionListener, KeyListener {
    //lebar dan tinggi
    int frameWidth = 360;
    int frameHeight = 640;

    //posisi awal dan ukuran burung
    int playerStartPosX = frameWidth / 2;
    int playerStartPosY = frameHeight / 2;
    int playerWidth = 34;
    int playerHeight = 24;

    //poisisi awal dan ukuran pipa
    int pipeStartPosX = frameWidth;
    int pipeStartPosY = 0;
    int pipeWidth = 64;
    int pipeHeight = 512;

    View view;
    JFrame frame;
    Image birdImage;
    Player player;

    Image lowerPipeImage;
    Image upperPipeImage;
    ArrayList<Pipe> pipes;


    Timer gameLoop;
    Timer pipesCooldown;
    int gravity = 1;
    int pipeVelocityX = -2;

    private boolean gameOver = false; //untuk pengecekan gameOver
    private int score = 0; //untuk score
    private JLabel scoreLabel;

    public Logic(){

        birdImage = new ImageIcon(getClass().getResource("assets/bird.png")).getImage();
        player = new Player(playerStartPosX, playerStartPosY, playerWidth, playerHeight, birdImage);

        lowerPipeImage = new ImageIcon(getClass().getResource("assets/lowerPipe.png")).getImage();
        upperPipeImage = new ImageIcon(getClass().getResource("assets/upperPipe.png")).getImage();
        pipes = new ArrayList<Pipe>();

        //mneambahkan pipa setiap 1,5 detik
        pipesCooldown = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Pipa");
                placePipes();
            }
        });
        pipesCooldown.start();

        //gamelopop
        gameLoop = new Timer(1000/60, this);
        gameLoop.start();

        //untuk score di layar
        scoreLabel = new JLabel("Score : 0");
        scoreLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        scoreLabel.setForeground(Color.white);
    }

    public void setView(View view) {
        this.view = view;
    }

    public Player getPlayer() {
        return player;
    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public void setScoreLabel(JLabel scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    public int getScore() {
        return score;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void move(){
        //cek apakah game over
        if (gameOver)
            return;

        player.setVelocityY(player.getVelocityY() + gravity);
        player.setPosY(player.getPosY() + player.getVelocityY());
        player.setPosY(Math.max(player.getPosY(), 0));

        for (int i = 0; i < pipes.size(); i++){
            Pipe pipe = pipes.get(i);
            pipe.setPosX(pipe.getPosX() + pipeVelocityX);

            //hanya menghitung satu pipa per pasangan(atas bawah)
            if (i % 2 == 0 ){
                //jika melewati pipa
                if (pipe.getPosX() + pipe.getWidth() == player.getPosX()){
                    score++; //tambah scorenya
                    System.out.println("Score: " + score);
                    scoreLabel.setText("Score :" + score);
                }
            }
        }


        cekgame(); //pangil metode cek game
    }

    //cek kondisi
    private void cekgame(){
    //cek burung jika burung jatuh ke bawah
        if (player.getPosY() + player.getHeight() >= frameHeight){
            gameOver = true; //tandai game selesai
            gameLoop.stop(); //menghentikan pergerakan burung
            pipesCooldown.stop(); //menghentikan pegerakan pipa
            System.out.println("GAME OVER");
            return;
        }
        //cek tabrak dengan pipa
        for (int i = 0; i < pipes.size(); i++){
            Pipe pipe = pipes.get(i);

            int playerX = player.getPosX();
            int playerY = player.getPosY();
            int width = player.getWidth();
            int height = player.getHeight();

            int pipeX = pipe.getPosX();
            int pipeY = pipe.getPosY();
            int pwidth = pipe.getWidth();
            int pHeight = pipe.getHeight();

            //cek apakah bertabrakn dengan pipa
            boolean xTbk = playerX + width > pipeX && playerX < pipeX + pwidth;
            boolean yTbk = playerY + height > pipeY && playerY < pipeY + pHeight;
            //jika benar
            if (xTbk && yTbk){
                gameOver = true; //tandai game selesai
                gameLoop.stop(); //hentikan pergerakan burung dan pipa
                pipesCooldown.stop();
                System.out.println("GAME OVER");
                return;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        move();
        if (view != null){
            view.repaint();
        }
    }
    @Override
    public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            player.setVelocityY(-10);
        }

        //untuk tombol restart jika mati
        if (e.getKeyCode() == KeyEvent.VK_R && gameOver){
            restartGame();
        }

        //untuk tombol kembali ke menu jika mati
        if (e.getKeyCode() == KeyEvent.VK_M && gameOver) {
            menuGame();
        }

    }
    public void keyReleased(KeyEvent e){}

    public ArrayList<Pipe> getPipes() {
        return pipes;
    }

    public void placePipes(){
    int randomPosY = (int) (pipeStartPosY - pipeHeight/4 - Math.random() * (pipeHeight / 2));
    int openingSpace = frameHeight / 4;

    Pipe upperPipe = new Pipe(pipeStartPosX, randomPosY, pipeWidth, pipeHeight, upperPipeImage);
    pipes.add(upperPipe);

    Pipe lowerPipe = new Pipe(pipeStartPosX, (randomPosY + openingSpace + pipeHeight), pipeWidth, pipeHeight, lowerPipeImage);
    pipes.add(lowerPipe);
    }

    //restart game
    public void restartGame(){
        System.out.println("Game Restart");
        gameOver = false; //menandai game sudah bukan game over lagi

        //mengembalikan posisi burung ke tengah layar
        player.setPosX(playerStartPosX);
        player.setPosY(playerStartPosY);
        player.setVelocityY(0); //menghentikan semua gerakan player agar tidak langsung jatuh

        //hapus semua pipa
        pipes.clear();

        //mulai ulang
        gameLoop.start(); //melakukan ulang loop utama game
        pipesCooldown.start(); //melakukan ulang timer pipa
        score = 0; //reset score ke 0
        scoreLabel.setText("Score : 0"); //memperbaru tampilan skor
        scoreLabel.setVisible(true); //memastikan label skor muncul kembali
    }

    //kembali ke menu game
    public void menuGame(){
        System.out.println("Kembali ke menu utama");
        gameLoop.stop(); //menghentikan timer utama
        pipesCooldown.stop(); //menghetikan timer pipa
        gameOver = true; //menandakan status game sudah selesai

        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(view); //mencari jframe tempat view berada

        if (frame != null){
            //hapus tampilan game
            frame.getContentPane().removeAll();

            //membuat objek menu baru
            Menu menu = new Menu(frame);
            frame.add(menu); // menambahkan tampilan menu ke fram

            //refresh agar menu langsung muncul
            frame.revalidate();
            frame.repaint();
        }else { //jika frame tidak ditemukan
            System.out.println("ERROR: frame not found");
        }
    }
}
