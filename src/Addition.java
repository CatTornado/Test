import javafx.scene.control.ProgressBar;

public class Addition {
    private Counter counter;
    private ProgressBar pbAdd;
    private int step;

    public Addition(int counerMax, ProgressBar pb, int step) {
        counter = new Counter(counerMax);
        pbAdd = pb;
        this.step = step;
    }

    Runnable addition = new Runnable() {
        @Override
        public void run() {
            int i = 0;
            while (i < counter.getN()) {
                i += step;
                pbAdd.setProgress((double) i / counter.getN());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public Runnable getAddition() {
        return addition;
    }
}
