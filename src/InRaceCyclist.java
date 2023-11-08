public class InRaceCyclist extends Thread {
    private Cyclist cyclist;
    private CyclingRace cyclingRace;
    private Thread thread;
    private int counter, speed, position;

    public InRaceCyclist(Cyclist cyclist, CyclingRace cyclingRace) {
        this.cyclist = cyclist;
        this.cyclingRace = cyclingRace;
        counter = 0;
        speed = 2;
        position = 0;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        int imgSize = 79;
        int trackSize = 960;

        while ((cyclist.getCordX() + imgSize) < trackSize) {
            if (counter % 10 == 0)
                speed = (int) (Math.random() * 4 + 1);
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
}
