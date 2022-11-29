public class DALSKAITLIS {
    // Metodi modificet aizliegts!!!!!
    public static void main(String[] args) {
        DALSKAITLIS dSk;
        DALSKAITLIS d[] = new DALSKAITLIS[3];

        d[0] = new DALSKAITLIS(args[0], args[1]);
        d[1] = new DALSKAITLIS(args[2], args[3]);
        d[2] = new DALSKAITLIS(args[4]);

        for (DALSKAITLIS tmpD : d) tmpD.display();

        if (d[0].isGreater(d[1])) {
            dSk = d[0];
            d[0] = d[1];
            d[1] = dSk;
        }

        d[0].divide(d[1]);
        d[1].add(d[0]);
        d[2].divide(d[1]);

        for (DALSKAITLIS tmpD : d) tmpD.display();

        System.out.println(d[0].isEqual(d[1]));
        System.out.println(d[1].isEqual(d[2]));
        System.out.println(d[2].isEqual(d[2]));
    }

    private LielsSkaitlis skait;
    private LielsSkaitlis sauc;

    public DALSKAITLIS(String skait, String sauc) {

        if (skait.charAt(0) == '-' && sauc.charAt(0) == '-') {
            this.skait = new LielsSkaitlis(skait.substring(1));
            this.sauc = new LielsSkaitlis(sauc.substring(1));
        } else if (skait.charAt(0) != '-' && sauc.charAt(0) != '-') {
            this.skait = new LielsSkaitlis(skait);
            this.sauc = new LielsSkaitlis(sauc);
        } else if (skait.charAt(0) == '-' && sauc.charAt(0) != '-') {
            this.skait = new LielsSkaitlis(skait);
            this.sauc = new LielsSkaitlis(sauc);
        } else {
            this.skait = new LielsSkaitlis("-" + skait);
            this.sauc = new LielsSkaitlis(sauc.substring(1));
        }

        this.simplify();
    }

    public DALSKAITLIS(String sk) {
        this.skait = new LielsSkaitlis(sk);
        this.sauc = new LielsSkaitlis("1");
        this.simplify();
    }

    public LielsSkaitlis getSkait() {
        return this.skait;
    }

    public LielsSkaitlis getSauc() {
        return this.sauc;
    }

    public String getSign() {
        return this.skait.getSign();
    }

    private void simplify() {

        String gcd = this.skait.findGcd(this.sauc);

        if (!gcd.equals("1")) {
            this.skait.divide(new LielsSkaitlis(gcd));
            this.sauc.divide(new LielsSkaitlis(gcd));
        }
    }

    public boolean isEqual(DALSKAITLIS d) {
        return d.getSkait().getLielsSkaitlis().equals(this.skait.getLielsSkaitlis()) && this.skait.getSign().equals(d.getSkait().getSign());
    }

    public boolean isGreater(DALSKAITLIS d) {

        if (this.getSkait().getSign().equals("") && d.getSkait().getSign().equals("") && this.skait.isGreater(d.skait)
                || this.skait.getSign().equals("-") && d.getSkait().getSign().equals("-") && d.skait.isGreater(this.skait)
                || this.skait.getSign().equals("") && d.getSkait().getSign().equals("-")) {
            return true;
        }

        return false;
    }

    public void add(DALSKAITLIS d) {

        LielsSkaitlis lcm1 = this.sauc.findLcm(d.getSauc());
        LielsSkaitlis lcm2 = new LielsSkaitlis(lcm1.getLielsSkaitlis());
        lcm1.divide(this.sauc);
        lcm2.divide(d.getSauc());

        this.skait.multiply(lcm1);
        this.sauc.multiply(lcm1);

        LielsSkaitlis dSkait = d.getSkait();

        dSkait.multiply(lcm2);
        this.skait.add(dSkait);
        this.simplify();
    }

    public void divide(DALSKAITLIS d) {

        this.skait.multiply(d.getSauc());
        this.sauc.multiply(d.getSkait());
        simplify();

        if (this.sauc.getSign().length() == 1) {
            this.skait = new LielsSkaitlis("-" + this.skait.getLielsSkaitlis());
            String test = this.sauc.getLielsSkaitlis();
            this.sauc = new LielsSkaitlis(this.sauc.getLielsSkaitlis().substring(1));
        }
    }

    public void display() {

        LielsSkaitlis ls = new LielsSkaitlis(this.skait.getAbs());
        String output = "";

        if (this.sauc.getLielsSkaitlis().equals("1")) {
            output = this.skait.getLielsSkaitlis();
        } else if (ls.isGreater(this.sauc)) {
            LielsSkaitlis wholeNumber = new LielsSkaitlis(this.skait.getAbs());
            String modStr =  wholeNumber.divideAndGetRemainder(this.sauc);
            String wholeNumberStr = wholeNumber.getLielsSkaitlis();
            output = this.skait.getSign() + wholeNumberStr + "_" + modStr + "/" + this.sauc.getLielsSkaitlis();
        } else {
            output = this.skait.getLielsSkaitlis() + "/" + this.sauc.getLielsSkaitlis();
        }

        System.out.println(output);
    }

    public String[] getDalSkaitlis() {
        return new String[]{this.skait.getLielsSkaitlis(), this.sauc.getLielsSkaitlis()};
    }
}