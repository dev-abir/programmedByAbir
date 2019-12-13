public class Disc {

    private Peg peg;
    private int weight;

    public Disc(Peg peg, int weight) {
        this.peg = peg;
        this.weight = weight;
    }

    public void setPeg(Peg peg) {
        this.peg.remove(this);
        peg.add(this);
        this.peg = peg;
    }

    public Peg getPeg() {
        return peg;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return Integer.toString(weight);
    }
}
