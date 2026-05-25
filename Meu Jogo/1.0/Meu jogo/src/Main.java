import javax.swing.JFrame;
import javax.swing.JPanel;
public class Main{
    public static void main(String[] args){
        JFrame janela = new JFrame();
        GamePanel painel = new GamePanel();
        janela.add(painel);
        janela.setSize(800,600);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);


    }
}


