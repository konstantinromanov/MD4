public class DALSKAITLIS {
    // Metodi modificet aizliegts!!!!!
    public static void main(String[] args) {
//        DALSKAITLIS dSk;
//        DALSKAITLIS d[] = new DALSKAITLIS[3];
//
//        d[0] = new DALSKAITLIS(args[0], args[1]);
//        d[1] = new DALSKAITLIS(args[2], args[3]);
//        d[2] = new DALSKAITLIS(args[4]);

//        for (DALSKAITLIS tmpD : d) tmpD.display();
//
//        if (d[0].isGreater(d[1])) {
//            dSk = d[0];
//            d[0] = d[1];
//            d[1] = dSk;
//        }
//
//        d[0].divide(d[1]);
//        d[1].add(d[0]);
//        d[2].divide(d[1]);
//
//        for (DALSKAITLIS tmpD : d) tmpD.display();
//
//        System.out.println(d[0].isEqual(d[1]));
//        System.out.println(d[1].isEqual(d[2]));
//        System.out.println(d[2].isEqual(d[2]));

//        LielsSkaitlis lielsSkaitlis = new LielsSkaitlis("6");
//        String lcd = lielsSkaitlis.findGcd("3", "6");

//        LielsSkaitlis lielsSkaitlis = new LielsSkaitlis("6");
//        String lcd = lielsSkaitlis.findGcd("14444", "24");
//        System.out.println("lcd: " + lcd);
//        int a = 12;
//        int b = 6;
//
//        while (a != b){
//            if (a > b){
//                a = a - b;
//            } else {
//                b = b - a;
//            }
//        }
//
//        System.out.println("a: " + a);

//        DALSKAITLIS dalskaitlis = new DALSKAITLIS("2", "10000000");
//        System.out.println("sk: " + dalskaitlis.getSkait().getLielsSkaitlis());
//        System.out.println("sauc: " + dalskaitlis.getSauc().getLielsSkaitlis());
//        DALSKAITLIS dalskaitlis = new DALSKAITLIS("2", "4");
//        System.out.println("sk: " + dalskaitlis.getSkait().getLielsSkaitlis());
//        System.out.println("sauc: " + dalskaitlis.getSauc().getLielsSkaitlis());
//        DALSKAITLIS dalskaitlis2 = new DALSKAITLIS("4", "8");
//        System.out.println("sk: " + dalskaitlis2.getSkait().getLielsSkaitlis());
//        System.out.println("sauc: " + dalskaitlis2.getSauc().getLielsSkaitlis());
//        System.out.println("equal: " + dalskaitlis.isEqual(dalskaitlis2));
//        DALSKAITLIS dalskaitlis = new DALSKAITLIS("3", "4");
//        DALSKAITLIS dalskaitlis2 = new DALSKAITLIS("-4", "8");
//        System.out.println("greater: " + dalskaitlis2.isGreater(dalskaitlis));
//        DALSKAITLIS dalskaitlis = new DALSKAITLIS("2434", "844");
//        DALSKAITLIS dalskaitlis2 = new DALSKAITLIS("203", "500");
//        dalskaitlis.add(dalskaitlis2);
        DALSKAITLIS dalskaitlis = new DALSKAITLIS("243445", "84466");
        DALSKAITLIS dalskaitlis2 = new DALSKAITLIS("2045443", "558003");
        dalskaitlis.add(dalskaitlis2);
        System.out.println("add sk: " + dalskaitlis.getSkait().getLielsSkaitlis());
        System.out.println("add sauc: " + dalskaitlis.getSauc().getLielsSkaitlis());
    }

    private LielsSkaitlis skait;
    private LielsSkaitlis sauc;
    private String sign = "";

    public DALSKAITLIS(String skait, String sauc) {

        if (skait.charAt(0) == '-' && sauc.charAt(0) == '-') {
            this.skait = new LielsSkaitlis(skait.substring(1));
            this.sauc = new LielsSkaitlis(sauc.substring(1));
        } else if (skait.charAt(0) != '-' && sauc.charAt(0) != '-') {
            this.skait = new LielsSkaitlis(skait);
            this.sauc = new LielsSkaitlis(sauc);
        } else if (skait.charAt(0) == '-' && sauc.charAt(0) != '-') {
            sign = "-";
            this.skait = new LielsSkaitlis(skait.substring(1));
            this.sauc = new LielsSkaitlis(sauc);
        } else {
            sign = "-";
            this.skait = new LielsSkaitlis(skait);
            this.sauc = new LielsSkaitlis(sauc.substring(1));
        }

        this.simplify();
    }

    public DALSKAITLIS(String sk) {

        if (sk.charAt(0) == '-') {
            this.sign = "-";
            this.skait = new LielsSkaitlis(sk.substring(1));
        } else {
            this.skait = new LielsSkaitlis(sk);
        }

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
        return this.sign;
    }

    private void simplify() {

        String gcd = this.skait.findGcd(this.sauc);

        if (!gcd.equals("1")) {
            this.skait = this.skait.divide(new LielsSkaitlis(gcd));
            this.sauc = this.sauc.divide(new LielsSkaitlis(gcd));
        }
    }

    public boolean isEqual(DALSKAITLIS d) {
        return d.getSkait().getLielsSkaitlis().equals(this.skait.getLielsSkaitlis()) && this.sign.equals(d.getSign());
    }

    public boolean isGreater(DALSKAITLIS d) {

        if (this.sign.equals("") && d.getSign().equals("") && this.skait.isGreater(d.skait)
                || this.sign.equals("-") && d.getSign().equals("-") && d.skait.isGreater(this.skait)
                || this.sign.equals("") && d.getSign().equals("-")) {
            return true;
        }

        return false;
    }

    public void add(DALSKAITLIS d) {

        LielsSkaitlis lcm1 = this.sauc.findLcm(d.getSauc());
        LielsSkaitlis lcm2 = new LielsSkaitlis(lcm1.getLielsSkaitlis());
        LielsSkaitlis mult1 = lcm1.divide(this.sauc);
        LielsSkaitlis mult2 = lcm2.divide(d.getSauc());

        this.skait.multiply(mult1);
        this.sauc.multiply(mult1);

        LielsSkaitlis dSkait = d.getSkait();

        dSkait.multiply(mult2);
        this.skait.add(dSkait);
        this.simplify();
    }

    public void divide(DALSKAITLIS d) {

    }

    public void display(DALSKAITLIS d) {

    }

    public String[] getDalSkaitlis() {
        return new String[]{this.skait.getLielsSkaitlis(), this.sauc.getLielsSkaitlis()};
    }
}