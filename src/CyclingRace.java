import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;

public class CyclingRace extends JFrame {
    private int position;
    private Cyclist[] cyclists;
    private InRaceCyclist[] inRaceCyclists;
    private Track track;
    private Graphics offscreen;
    private Image virtualBuffer;

    public CyclingRace() {
        super("Cycling Race");
        setSize(1000, 638);
        setLocation(10, 40);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        track = new Track();
        cyclists = new Cyclist[6];
        inRaceCyclists = new InRaceCyclist[6];

        position = 1;
        int start = 15;
        for (int i = 0; i < 6; i++) {
            cyclists[i] = new Cyclist(i + 1, start);
            inRaceCyclists[i] = new InRaceCyclist(cyclists[i], this);
            start += 100;
        }
        this.add(track);
        setVisible(true);
    }

    public synchronized int getPosition() {
        return this.position++;
    }

    public synchronized void checkArrivals() {
        boolean arrived = true;
        for (int i = 0; i < 6; i++) {
            if (inRaceCyclists[i].getPosition() == 0)
                arrived = false;
        }
        if (arrived) {
            showLeaderboard();
        }
    }

    public void showLeaderboard() {
        JLabel[] arrivals = new JLabel[6];
        JFrame leaderboard = new JFrame("Leaderboard");
        leaderboard.setSize(800, 500);
        leaderboard.setLocation(100, 100);
        leaderboard.setBackground(Color.BLUE);
        leaderboard.setDefaultCloseOperation(EXIT_ON_CLOSE);
        leaderboard.getContentPane().setLayout(new GridLayout(6, 1));

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arrivals[j] = new JLabel((j + 1) + ". " + inRaceCyclists[j].getCyclist().getName());
                arrivals[j].setFont(new Font("Times New Roman", Font.ITALIC, 20));
                arrivals[j].setForeground(Color.BLUE);
                leaderboard.getContentPane().add(arrivals[j]);
            }
        }
        leaderboard.setVisible(true);
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {
        if (cyclists != null) {
            Graphics2D g2d = (Graphics2D) g;
            virtualBuffer = createImage(1000, 645);
            offscreen = virtualBuffer.getGraphics();
            Dimension d = getSize();
            track.paint(offscreen);
            for (int i = 0; i < 6; i++)
                cyclists[i].paint(offscreen);
            g2d.drawImage(virtualBuffer, 0, 20, this);
            offscreen.dispose();
        }
    }
}
