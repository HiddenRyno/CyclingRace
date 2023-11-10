import java.awt.*;
import javax.swing.*;

public class Cyclist extends JPanel {
  private int cordX;
  private int cordY;
  private Image image;

  public Cyclist(int cordX, int cordY) {
    this.cordX = cordX;
    this.cordY = cordY;
    setPreferredSize(new Dimension(80, 80));
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    switch (cordX) {
      case 1:
        image = toolkit.getImage("src/img/cyclist1.png");
        break;
      case 2:
        image = toolkit.getImage("src/img/cyclist2.png");
        break;
      case 3:
        image = toolkit.getImage("src/img/cyclist3.png");
        break;
      case 4:
        image = toolkit.getImage("src/img/cyclist4.png");
        break;
      case 5:
        image = toolkit.getImage("src/img/cyclist5.png");
        break;
      case 6:
        image = toolkit.getImage("src/img/cyclist6.png");
        break;
      default:
        break;
    }
    MediaTracker mediaTracker = new MediaTracker(this);
    mediaTracker.addImage(image, 1);
    try {
      mediaTracker.waitForID(1);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String getName() {
    return "Cyclist " + this.cordY / 100;
  }

  public int getCordX() {
    return this.cordX;
  }

  public int getCordY() {
    return this.cordY;
  }

  public void setCordX(int cordX) {
    this.cordX = cordX;
  }

  public void setCordY(int cordY) {
    this.cordY = cordY;
  }

  public void paint(Graphics g) {
    g.drawImage(image, cordX, cordY, this);
  }
}
