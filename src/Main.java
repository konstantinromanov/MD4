public class Main {
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
}

class DALSKAITLIS {

    private String skait;
    private String sauc;

    public DALSKAITLIS(String skait, String sauc){
        this.skait = skait;
        this.sauc = sauc;
    }

    public DALSKAITLIS(String sk){
        this.skait = sk;
        this.sauc = "1";
    }

    public boolean isEqual(DALSKAITLIS d){
        return true;
    }

    public boolean isGreater(DALSKAITLIS d){
        return true;
    }

    public void add(DALSKAITLIS d){

    }
    public void divide(DALSKAITLIS d){

    }

    public void display(DALSKAITLIS d){

    }

}