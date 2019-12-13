import java.util.ArrayList;

public class Tower {

    private int numberOfDiscs;
    private Disc[] allDiscsArray;
    private Peg pegA, pegB, pegC;

    public static int step = 0;

    public Tower(int numberOfDiscs) {
        this.numberOfDiscs = numberOfDiscs;
        this.allDiscsArray = new Disc[numberOfDiscs];
        pegA = new Peg(0, numberOfDiscs);
        pegB = new Peg(1, 0);
        pegC = new Peg(2, 0);
        createALLDiscArray();
    }

    public void displayTower() {
        System.out.println(pegA.getDiscArrayList());
        System.out.println(pegB.getDiscArrayList());
        System.out.println(pegC.getDiscArrayList());
        System.out.println("\n");
    }

    public Disc getLowestDisc() {
        return allDiscsArray[numberOfDiscs - 1];
    }

    public Disc getDiscOfWeight(int weight) {
        return allDiscsArray[weight - 1];
    }

    private void createALLDiscArray() {
        int i;
        for (i = 0; i < allDiscsArray.length; i++) {
            allDiscsArray[i] = new Disc(pegA, (i + 1));
        }
    }

    public void changePeg(Disc disc) {
        step = step + 1;
        System.out.println("STEP " + step);
        if (disc.getPeg().getPosition() == pegA.getPosition()) {
            Peg x = getBestPeg(disc, pegB, pegC);
            disc.setPeg(x);
        }
        else if (disc.getPeg().getPosition() == pegB.getPosition()) {
            Peg x = getBestPeg(disc, pegA, pegC);
            disc.setPeg(x);
        }
        else if (disc.getPeg().getPosition() == pegC.getPosition()) {
            Peg x = getBestPeg(disc, pegA, pegB);
            disc.setPeg(x);
        }
        displayTower();
        if(disc.getWeight() != 1) {
            for(int i=1; i<disc.getWeight(); i++) {
                changePeg(getDiscOfWeight(i));
            }
        }
    }

    private Peg getBestPeg(Disc discToChangePosition, Peg option0, Peg option1) {



        boolean even = (discToChangePosition.getWeight() % 2) == 0;


        if (option1.getDiscArrayList().isEmpty()) {
            if (!option0.getDiscArrayList().isEmpty()) {
                if (option0.getDiscAt(0).getWeight() > discToChangePosition.getWeight()) {
                    if (even != ((option0.getDiscAt(0).getWeight() % 2) == 0)) {
                        return option0;
                    }
                    else {
                        return option1;
                    }
                }
                else {
                    return option1;
                }
            }
            else {
                return option1;
            }
        }


        else if (option0.getDiscArrayList().isEmpty()) {
            if (!option1.getDiscArrayList().isEmpty()) {
                if (option1.getDiscAt(0).getWeight() > discToChangePosition.getWeight()) {
                    if (even != ((option1.getDiscAt(0).getWeight() % 2) == 0)) {
                        return option1;
                    }
                    else {
                        return option0;
                    }
                }
                else {
                    return option0;
                }
            }
            else {
                return option0;
            }
        }


        else if (!(option0.getDiscArrayList().isEmpty() && option1.getDiscArrayList().isEmpty())) {
            if (option0.getDiscAt(0).getWeight() < discToChangePosition.getWeight()) {
                return option1;
            }
            else if (option1.getDiscAt(0).getWeight() < discToChangePosition.getWeight()) {
                return option0;
            }
            else if (even != ((option0.getDiscAt(0).getWeight() % 2) == 0)) {
                return option0;
            }
            else if (even != ((option1.getDiscAt(0).getWeight() % 2) == 0)) {
                return option1;
            }
        }
        return option1;
    }
}
