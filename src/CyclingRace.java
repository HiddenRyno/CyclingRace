import javax.swing.JFrame;
import java.awt.*;

public class CyclingRace extends JFrame {
    private int position;
    private Cyclist[] cyclists;
    private InRaceCyclist[] inRaceCyclists;
    private CyclingRace cyclingRace;
    private Graphics offscreen;
    private Image virtualBuffer;

    public CyclingRace() {
        super("Cycling Race");
        setSize(1000, 645);
        setLocation(10, 40);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        cyclingRace = new CyclingRace();
        cyclists = new Cyclist[6];
        inRaceCyclists = new InRaceCyclist[6];

        position = 1;
        int start = 15;

        for (int i = 0; i < 6; i++) {
            cyclists[i] = new Cyclist(start, i + 1);
            inRaceCyclists[i] = new InRaceCyclist(cyclists[i], cyclingRace);
            start += 100;
        }
        this.add(cyclingRace);
        setVisible(true);
    }

    public synchronized void checkArrivals() {
        boolean arrived = true;
        for (int i = 0; i < 6; i++) {
            if (inRaceCyclists[i].getPosition() == 0)
                arrived = false;
        }
        if (arrived)
            showLeaderboard();
    }

    public synchronized int getPosition() {
        return this.position;
    }
}
