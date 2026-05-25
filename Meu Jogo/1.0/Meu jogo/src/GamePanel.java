import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class GamePanel extends JPanel implements KeyListener{
    int x = 100;
    int y = 100;
    boolean cima;
    boolean baixo;
    boolean esquerda;
    boolean direita;

    public void atualizar() {

        if (cima) {
            y -= 5;
        }

        if (baixo) {
            y += 5;
        }

        if (esquerda) {
            x -= 5;
        }

        if (direita) {
            x += 5;
        }

    }
    public GamePanel(){
        setBackground(Color.BLACK);
        addKeyListener(this);
        setFocusable(true);
        //Lambda Expression  ->
        new Thread(() -> {

            while (true) {

                atualizar();

                repaint();

                try {
                    Thread.sleep(16);
                } catch (Exception e) {

                }

            }

        }).start();
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillOval(x, y,50 ,50);
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();

        if (tecla == KeyEvent.VK_W) {
            cima = true;
        }

        if (tecla == KeyEvent.VK_S) {
            baixo = true;
        }

        if (tecla == KeyEvent.VK_A) {
            esquerda = true;
        }

        if (tecla == KeyEvent.VK_D) {
            direita = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int tecla = e.getKeyCode();

        if (tecla == KeyEvent.VK_W) {
            cima = false;
        }

        if (tecla == KeyEvent.VK_S) {
            baixo = false;
        }

        if (tecla == KeyEvent.VK_A) {
            esquerda = false;
        }

        if (tecla == KeyEvent.VK_D) {
            direita = false;
        }
    }
}
