import java.util.ArrayList;

public class Peg {

    private int position;
    private int numberOfDiscs;
    private ArrayList<Disc> discArrayList;

    public Peg(int position, int numberOfDiscs) {
        this.position = position;
        this.numberOfDiscs = numberOfDiscs;
        this.discArrayList = new ArrayList<Disc>();
        if(this.position == 0) {
            for(int i=1; i<=numberOfDiscs; i++) {
                discArrayList.add((i - 1), new Disc(this, i));
            }
        }
    }

    public int getNumberOfDiscs() {
        return numberOfDiscs;
    }

    public ArrayList<Disc> getDiscArrayList() {
        return discArrayList;
    }

    public Disc getDiscAt(int index) {
        return discArrayList.get(index);
    }

    public void remove(Disc disc) {
        discArrayList.remove(0);
    }

    public void add(Disc disc) {
        if(discArrayList.isEmpty()) {
            discArrayList.add(disc);
        }
        else {
            discArrayList.add(0, disc);
        }
    }

    public int getPosition() {
        return position;
    }
}
