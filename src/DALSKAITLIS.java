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

//
//        // addition tests
//        LielsSkaitlis lielsSkaitlis11 = new LielsSkaitlis("0");
//        LielsSkaitlis lielsSkaitlis21 = new LielsSkaitlis("56");
//        lielsSkaitlis11.add(lielsSkaitlis21);
//        System.out.println("test1: " + lielsSkaitlis11.getLielsSkaitlis().equals("56"));
//        LielsSkaitlis lielsSkaitlis12 = new LielsSkaitlis("89");
//        LielsSkaitlis lielsSkaitlis22 = new LielsSkaitlis("0");
//        lielsSkaitlis12.add(lielsSkaitlis22);
//        System.out.println("test2: " + lielsSkaitlis12.getLielsSkaitlis().equals("89"));
//        LielsSkaitlis lielsSkaitlis13 = new LielsSkaitlis("-9");
//        LielsSkaitlis lielsSkaitlis23 = new LielsSkaitlis("78");
//        lielsSkaitlis13.add(lielsSkaitlis23);
//        System.out.println("test3: " + lielsSkaitlis13.getLielsSkaitlis().equals("69"));
//        LielsSkaitlis lielsSkaitlis14 = new LielsSkaitlis("9");
//        LielsSkaitlis lielsSkaitlis24 = new LielsSkaitlis("-78");
//        lielsSkaitlis14.add(lielsSkaitlis24);
//        System.out.println("test4: " + lielsSkaitlis14.getLielsSkaitlis().equals("-69"));
//        LielsSkaitlis lielsSkaitlis15 = new LielsSkaitlis("78");
//        LielsSkaitlis lielsSkaitlis25 = new LielsSkaitlis("-9");
//        lielsSkaitlis15.add(lielsSkaitlis25);
//        System.out.println("test5: " + lielsSkaitlis15.getLielsSkaitlis().equals("69"));
//        LielsSkaitlis lielsSkaitlis16 = new LielsSkaitlis("-78");
//        LielsSkaitlis lielsSkaitlis26 = new LielsSkaitlis("9");
//        lielsSkaitlis16.add(lielsSkaitlis26);
//        System.out.println("test6: " + lielsSkaitlis16.getLielsSkaitlis().equals("-69"));
//        LielsSkaitlis lielsSkaitlis17 = new LielsSkaitlis("-78");
//        LielsSkaitlis lielsSkaitlis27 = new LielsSkaitlis("-9");
//        lielsSkaitlis17.add(lielsSkaitlis27);
//        System.out.println("test7: " + lielsSkaitlis17.getLielsSkaitlis().equals("-87"));
//
//        // substraction tests
//        LielsSkaitlis lielsSkaitlis18 = new LielsSkaitlis("0");
//        LielsSkaitlis lielsSkaitlis28 = new LielsSkaitlis("56");
//        lielsSkaitlis18.sub(lielsSkaitlis28);
//        System.out.println("test8: " + lielsSkaitlis18.getLielsSkaitlis().equals("-56"));
//        LielsSkaitlis lielsSkaitlis19 = new LielsSkaitlis("89");
//        LielsSkaitlis lielsSkaitlis29 = new LielsSkaitlis("0");
//        lielsSkaitlis19.sub(lielsSkaitlis29);
//        System.out.println("test9: " + lielsSkaitlis19.getLielsSkaitlis().equals("89"));
//        LielsSkaitlis lielsSkaitlis110 = new LielsSkaitlis("-9");
//        LielsSkaitlis lielsSkaitlis210 = new LielsSkaitlis("78");
//        lielsSkaitlis110.sub(lielsSkaitlis210);
//        System.out.println("test10: " + lielsSkaitlis110.getLielsSkaitlis().equals("-87"));
//        LielsSkaitlis lielsSkaitlis111 = new LielsSkaitlis("9");
//        LielsSkaitlis lielsSkaitlis211 = new LielsSkaitlis("-78");
//        lielsSkaitlis111.sub(lielsSkaitlis211);
//        System.out.println("test11: " + lielsSkaitlis111.getLielsSkaitlis().equals("87"));
//        LielsSkaitlis lielsSkaitlis112 = new LielsSkaitlis("78");
//        LielsSkaitlis lielsSkaitlis212 = new LielsSkaitlis("-9");
//        lielsSkaitlis112.sub(lielsSkaitlis212);
//        System.out.println("test12: " + lielsSkaitlis112.getLielsSkaitlis().equals("87"));
//        LielsSkaitlis lielsSkaitlis113 = new LielsSkaitlis("-78");
//        LielsSkaitlis lielsSkaitlis213 = new LielsSkaitlis("9");
//        lielsSkaitlis113.sub(lielsSkaitlis213);
//        System.out.println("test13: " + lielsSkaitlis113.getLielsSkaitlis().equals("-87"));
//        LielsSkaitlis lielsSkaitlis114 = new LielsSkaitlis("-78");
//        LielsSkaitlis lielsSkaitlis214 = new LielsSkaitlis("-9");
//        lielsSkaitlis114.sub(lielsSkaitlis214);
//        System.out.println("test14: " + lielsSkaitlis114.getLielsSkaitlis().equals("-69"));
//
//        //  miscellaneous tests
//        LielsSkaitlis lielsSkaitlis115 = new LielsSkaitlis("1530");
//        LielsSkaitlis lielsSkaitlis215 = new LielsSkaitlis("1530");
//        lielsSkaitlis115.add(lielsSkaitlis215);
//        System.out.println("test15: " + lielsSkaitlis115.getLielsSkaitlis().equals("3060"));
//        lielsSkaitlis115.reverse();
//        System.out.println("test16: " + lielsSkaitlis115.getLielsSkaitlis().equals("603"));
//        lielsSkaitlis215.sub(lielsSkaitlis115);
//        System.out.println("test17: " + lielsSkaitlis215.getLielsSkaitlis().equals("927"));
//        lielsSkaitlis215.reverse();
//        System.out.println("test18: " + lielsSkaitlis215.getLielsSkaitlis().equals("729"));
//
//        LielsSkaitlis lielsSkaitlis116 = new LielsSkaitlis("20000000000000000000");
//        LielsSkaitlis lielsSkaitlis216 = new LielsSkaitlis("-1");
//        lielsSkaitlis116.add(lielsSkaitlis216);
//        System.out.println("test19: " + lielsSkaitlis116.getLielsSkaitlis().equals("19999999999999999999"));
//        lielsSkaitlis116.reverse();
//        System.out.println("test20: " + lielsSkaitlis116.getLielsSkaitlis().equals("99999999999999999991"));
//        lielsSkaitlis216.sub(lielsSkaitlis116);
//        System.out.println("test21: " + lielsSkaitlis216.getLielsSkaitlis().equals("SKAITLIS PAR MAZU"));
//        lielsSkaitlis216.reverse();
//        System.out.println("test22: " + lielsSkaitlis216.getLielsSkaitlis().equals("SKAITLIS PAR MAZU"));
//
//        LielsSkaitlis lielsSkaitlis117 = new LielsSkaitlis("99999999999999999995");
//        LielsSkaitlis lielsSkaitlis217 = new LielsSkaitlis("5");
//        lielsSkaitlis117.add(lielsSkaitlis217);
//        System.out.println("test23: " + lielsSkaitlis117.getLielsSkaitlis().equals("SKAITLIS PAR LIELU"));
//        lielsSkaitlis117.reverse();
//        System.out.println("test24: " + lielsSkaitlis117.getLielsSkaitlis().equals("SKAITLIS PAR LIELU"));
//        lielsSkaitlis217.sub(lielsSkaitlis117);
//        System.out.println("test25: " + lielsSkaitlis217.getLielsSkaitlis().equals("SKAITLIS PAR LIELU"));
//        lielsSkaitlis217.reverse();
//        System.out.println("test26: " + lielsSkaitlis217.getLielsSkaitlis().equals("SKAITLIS PAR LIELU"));

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
////        DALSKAITLIS dalskaitlis = new DALSKAITLIS("243445", "84466");
////        DALSKAITLIS dalskaitlis2 = new DALSKAITLIS("2045443", "558003");
////        dalskaitlis.add(dalskaitlis2);
//        System.out.println("add sk: " + dalskaitlis.getSkait().getLielsSkaitlis());
//        System.out.println("add sauc: " + dalskaitlis.getSauc().getLielsSkaitlis());

//        DALSKAITLIS dalskaitlis = new DALSKAITLIS("2", "4");
//        DALSKAITLIS dalskaitlis2 = new DALSKAITLIS("1", "8");
//        dalskaitlis.add(dalskaitlis2); // should be 5/8
//        System.out.println("add sk: " + dalskaitlis.getSkait().getLielsSkaitlis());
//        System.out.println("add sauc: " + dalskaitlis.getSauc().getLielsSkaitlis());


//        LielsSkaitlis lielsSkaitlis1 = new LielsSkaitlis("24");
//        LielsSkaitlis lielsSkaitlis2 = new LielsSkaitlis("12");
//        lielsSkaitlis1.add(lielsSkaitlis2);
//        System.out.println("add l1: " + lielsSkaitlis1.getLielsSkaitlis());

//        LielsSkaitlis lielsSkaitlis1 = new LielsSkaitlis("24");
//        LielsSkaitlis lielsSkaitlis2 = new LielsSkaitlis("12");
//        lielsSkaitlis1.sub(lielsSkaitlis2);
//        System.out.println("add l1: " + lielsSkaitlis1.getLielsSkaitlis());
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
//            this.skait = this.skait.divide(new LielsSkaitlis(gcd));
//            this.sauc = this.sauc.divide(new LielsSkaitlis(gcd));
            this.skait.divide(new LielsSkaitlis(gcd));
            this.sauc.divide(new LielsSkaitlis(gcd));
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

    }

    public void display(DALSKAITLIS d) {

    }

    public String[] getDalSkaitlis() {
        return new String[]{this.skait.getLielsSkaitlis(), this.sauc.getLielsSkaitlis()};
    }
}