public class InRaceCyclist extends Thread {
    private Cyclist cyclist;
    private CyclingRace cyclingRace;
    private Thread thread;
    private int counter;
    private int speed;
    private int position;

    public InRaceCyclist(Cyclist cyclist, CyclingRace cyclingRace) {
        this.cyclist = cyclist;
        this.cyclingRace = cyclingRace;
        thread = new Thread(this);
        counter = 0;
        speed = 2;
        position = 0;
        thread.start();
    }

    public void run() {
        int imgSize = 80;
        int trackSize = 960;

        while ((cyclist.getCordX() + imgSize) < trackSize) {
            if (counter % 10 == 0)
                speed = (int) (Math.random() * 4 + 1);
            cyclist.setCordX(cyclist.getCordX() + speed);
            counter++;
            try {
                Thread.sleep(75);
            } catch (Exception e) {
                e.printStackTrace();
            }
            cyclingRace.repaint();
        }
        position = cyclingRace.getPosition();
        cyclingRace.checkArrivals();
    }

    public int getPosition() {
        return this.position;
    }

    public Cyclist getCyclist() {
        return this.cyclist;
    }
}
