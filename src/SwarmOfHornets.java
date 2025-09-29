package assignment1;

public class SwarmOfHornets {
    private Hornet[] hornets;
    private int numOfHornets;
    public static double QUEEN_BOOST = 10.0;

    public SwarmOfHornets() {
        this.hornets = new Hornet[4];
        this.numOfHornets = 0;
    }

    public int sizeOfSwarm() {
        return numOfHornets;
    }


    public Hornet[] getHornets() {
        Hornet[] out = new Hornet[numOfHornets];
        for (int i = 0; i < numOfHornets; i++) out[i] = hornets[i];
        return out;
    }

    public Hornet getFirstHornet() {
        if (numOfHornets == 0) return null;
        return hornets[0];
    }


    public void addHornet(Hornet h) {
        if (h == null) return;
        if (numOfHornets == hornets.length) {
            // resize doubling
            Hornet[] tmp = new Hornet[hornets.length * 2];
            for (int i = 0; i < hornets.length; i++) tmp[i] = hornets[i];
            hornets = tmp;
        }
        hornets[numOfHornets++] = h;

        // if h.isTheQueen() is true, apply queen boost to others (sketch).
        // TODO: apply QUEEN_BOOST to other hornets' health when a queen is added.
    }

    public boolean removeHornet(Hornet h) {
        if (h == null || numOfHornets == 0) return false;
        int idx = -1;
        for (int i = 0; i < numOfHornets; i++) {
            if (hornets[i] == h) {
                idx = i;
                break;
            }
        }
        if (idx == -1) return false;
        // shift left
        for (int j = idx; j < numOfHornets - 1; j++) hornets[j] = hornets[j + 1];
        hornets[numOfHornets - 1] = null;
        numOfHornets--;
        return true;
    }
}

