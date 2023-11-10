import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Track extends JPanel {
  public void paint(Graphics g) {
    g.setColor(Color.GREEN);
    g.fillRect(0, 0, 1000, 645);

    g.setColor(Color.WHITE);
    for (int i = 0; i < 7; i++) {
      g.fillRect(0, i * 100, 1000, 10);
    }

    g.fillRect(960, 0, 5, 645);
    g.fillRect(970, 0, 5, 645);
    g.fillRect(980, 0, 5, 645);
  }
}
