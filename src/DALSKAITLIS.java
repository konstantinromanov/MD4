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

        DALSKAITLIS dalskaitlis = new DALSKAITLIS("256", "22");


    }

    private String skait = "";
    private String sauc = "";
    private String sign = "";

    public DALSKAITLIS(String skait, String sauc) {

        LielsSkaitlis lielsSkaitlis = new LielsSkaitlis(skait);
        String gcd = lielsSkaitlis.findGcd(skait, sauc);

        this.skait = lielsSkaitlis.divide(lielsSkaitlis.getLielsSkaitlis(), gcd)[0];
        this.sauc = lielsSkaitlis.divide(sauc, gcd)[0];

        if (skait.charAt(0) == '-' && sauc.charAt(0) != '-' || skait.charAt(0) != '-' && sauc.charAt(0) == '-') {
            sign = "-";
        }
    }

    public DALSKAITLIS(String sk) {
        this.skait = sk;
        this.sauc = "1";

        if (sk.charAt(0) == '-') {
            sign = "-";
        }
    }

    private String getLcd(String number1, String number2){



        return "";
    }
    public boolean isEqual(DALSKAITLIS d) {
        return d.getDalSkaitlis()[0] == this.skait && d.getDalSkaitlis()[1] == this.sauc;
    }

    public boolean isGreater(DALSKAITLIS d) {

        return d.getDalSkaitlis()[0] == this.skait && d.getDalSkaitlis()[1] == this.sauc;
    }

    public void add(DALSKAITLIS d) {

    }

    public void divide(DALSKAITLIS d) {

    }

    public void display(DALSKAITLIS d) {

    }

    public String[] getDalSkaitlis() {
        return new String[]{this.skait, this.sauc};
    }
}
//
//class DALSKAITLIS {
//
//    private String skait;
//    private String sauc;
//    private String sign;
//
//    public DALSKAITLIS(String skait, String sauc){
//        this.skait = skait;
//        this.sauc = sauc;
//        if (skat[0] == "-"){
//
//        }
//    }
//
//    public DALSKAITLIS(String sk){
//        this.skait = sk;
//        this.sauc = "1";
//    }
//
//    public boolean isEqual(DALSKAITLIS d){
//        return true;
//    }
//
//    public boolean isGreater(DALSKAITLIS d){
//        return true;
//    }
//
//    public void add(DALSKAITLIS d){
//
//    }
//    public void divide(DALSKAITLIS d){
//
//    }
//
//    public void display(DALSKAITLIS d){
//
//    }
//
//}