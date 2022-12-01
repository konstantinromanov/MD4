public class Tests {

    public void runTests(){

        // addition tests
        LielsSkaitlis lielsSkaitlis11 = new LielsSkaitlis("0");
        LielsSkaitlis lielsSkaitlis21 = new LielsSkaitlis("56");
        lielsSkaitlis11.add(lielsSkaitlis21);
        System.out.println("test1: " + lielsSkaitlis11.getLielsSkaitlis().equals("56"));
        LielsSkaitlis lielsSkaitlis12 = new LielsSkaitlis("89");
        LielsSkaitlis lielsSkaitlis22 = new LielsSkaitlis("0");
        lielsSkaitlis12.add(lielsSkaitlis22);
        System.out.println("test2: " + lielsSkaitlis12.getLielsSkaitlis().equals("89"));
        LielsSkaitlis lielsSkaitlis13 = new LielsSkaitlis("-9");
        LielsSkaitlis lielsSkaitlis23 = new LielsSkaitlis("78");
        lielsSkaitlis13.add(lielsSkaitlis23);
        System.out.println("test3: " + lielsSkaitlis13.getLielsSkaitlis().equals("69"));
        LielsSkaitlis lielsSkaitlis14 = new LielsSkaitlis("9");
        LielsSkaitlis lielsSkaitlis24 = new LielsSkaitlis("-78");
        lielsSkaitlis14.add(lielsSkaitlis24);
        System.out.println("test4: " + lielsSkaitlis14.getLielsSkaitlis().equals("-69"));
        LielsSkaitlis lielsSkaitlis15 = new LielsSkaitlis("78");
        LielsSkaitlis lielsSkaitlis25 = new LielsSkaitlis("-9");
        lielsSkaitlis15.add(lielsSkaitlis25);
        System.out.println("test5: " + lielsSkaitlis15.getLielsSkaitlis().equals("69"));
        LielsSkaitlis lielsSkaitlis16 = new LielsSkaitlis("-78");
        LielsSkaitlis lielsSkaitlis26 = new LielsSkaitlis("9");
        lielsSkaitlis16.add(lielsSkaitlis26);
        System.out.println("test6: " + lielsSkaitlis16.getLielsSkaitlis().equals("-69"));
        LielsSkaitlis lielsSkaitlis17 = new LielsSkaitlis("-78");
        LielsSkaitlis lielsSkaitlis27 = new LielsSkaitlis("-9");
        lielsSkaitlis17.add(lielsSkaitlis27);
        System.out.println("test7: " + lielsSkaitlis17.getLielsSkaitlis().equals("-87"));

        // substraction tests
        LielsSkaitlis lielsSkaitlis18 = new LielsSkaitlis("0");
        LielsSkaitlis lielsSkaitlis28 = new LielsSkaitlis("56");
        lielsSkaitlis18.sub(lielsSkaitlis28);
        System.out.println("test8: " + lielsSkaitlis18.getLielsSkaitlis().equals("-56"));
        LielsSkaitlis lielsSkaitlis19 = new LielsSkaitlis("89");
        LielsSkaitlis lielsSkaitlis29 = new LielsSkaitlis("0");
        lielsSkaitlis19.sub(lielsSkaitlis29);
        System.out.println("test9: " + lielsSkaitlis19.getLielsSkaitlis().equals("89"));
        LielsSkaitlis lielsSkaitlis110 = new LielsSkaitlis("-9");
        LielsSkaitlis lielsSkaitlis210 = new LielsSkaitlis("78");
        lielsSkaitlis110.sub(lielsSkaitlis210);
        System.out.println("test10: " + lielsSkaitlis110.getLielsSkaitlis().equals("-87"));
        LielsSkaitlis lielsSkaitlis111 = new LielsSkaitlis("9");
        LielsSkaitlis lielsSkaitlis211 = new LielsSkaitlis("-78");
        lielsSkaitlis111.sub(lielsSkaitlis211);
        System.out.println("test11: " + lielsSkaitlis111.getLielsSkaitlis().equals("87"));
        LielsSkaitlis lielsSkaitlis112 = new LielsSkaitlis("78");
        LielsSkaitlis lielsSkaitlis212 = new LielsSkaitlis("-9");
        lielsSkaitlis112.sub(lielsSkaitlis212);
        System.out.println("test12: " + lielsSkaitlis112.getLielsSkaitlis().equals("87"));
        LielsSkaitlis lielsSkaitlis113 = new LielsSkaitlis("-78");
        LielsSkaitlis lielsSkaitlis213 = new LielsSkaitlis("9");
        lielsSkaitlis113.sub(lielsSkaitlis213);
        System.out.println("test13: " + lielsSkaitlis113.getLielsSkaitlis().equals("-87"));
        LielsSkaitlis lielsSkaitlis114 = new LielsSkaitlis("-78");
        LielsSkaitlis lielsSkaitlis214 = new LielsSkaitlis("-9");
        lielsSkaitlis114.sub(lielsSkaitlis214);
        System.out.println("test14: " + lielsSkaitlis114.getLielsSkaitlis().equals("-69"));

        //  miscellaneous tests
        LielsSkaitlis lielsSkaitlis115 = new LielsSkaitlis("1530");
        LielsSkaitlis lielsSkaitlis215 = new LielsSkaitlis("1530");
        lielsSkaitlis115.add(lielsSkaitlis215);
        System.out.println("test15: " + lielsSkaitlis115.getLielsSkaitlis().equals("3060"));
        lielsSkaitlis115.reverse();
        System.out.println("test16: " + lielsSkaitlis115.getLielsSkaitlis().equals("603"));
        lielsSkaitlis215.sub(lielsSkaitlis115);
        System.out.println("test17: " + lielsSkaitlis215.getLielsSkaitlis().equals("927"));
        lielsSkaitlis215.reverse();
        System.out.println("test18: " + lielsSkaitlis215.getLielsSkaitlis().equals("729"));

        LielsSkaitlis lielsSkaitlis116 = new LielsSkaitlis("20000000000000000000");
        LielsSkaitlis lielsSkaitlis216 = new LielsSkaitlis("-1");
        lielsSkaitlis116.add(lielsSkaitlis216);
        System.out.println("test19: " + lielsSkaitlis116.getLielsSkaitlis().equals("19999999999999999999"));
        lielsSkaitlis116.reverse();
        System.out.println("test20: " + lielsSkaitlis116.getLielsSkaitlis().equals("99999999999999999991"));
        lielsSkaitlis216.sub(lielsSkaitlis116);
        System.out.println("test21: " + lielsSkaitlis216.getLielsSkaitlis().equals("SKAITLIS PAR MAZU"));
        lielsSkaitlis216.reverse();
        System.out.println("test22: " + lielsSkaitlis216.getLielsSkaitlis().equals("SKAITLIS PAR MAZU"));

        LielsSkaitlis lielsSkaitlis117 = new LielsSkaitlis("99999999999999999995");
        LielsSkaitlis lielsSkaitlis217 = new LielsSkaitlis("5");
        lielsSkaitlis117.add(lielsSkaitlis217);
        System.out.println("test23: " + lielsSkaitlis117.getLielsSkaitlis().equals("SKAITLIS PAR LIELU"));
        lielsSkaitlis117.reverse();
        System.out.println("test24: " + lielsSkaitlis117.getLielsSkaitlis().equals("SKAITLIS PAR LIELU"));
        lielsSkaitlis217.sub(lielsSkaitlis117);
        System.out.println("test25: " + lielsSkaitlis217.getLielsSkaitlis().equals("SKAITLIS PAR LIELU"));
        lielsSkaitlis217.reverse();
        System.out.println("test26: " + lielsSkaitlis217.getLielsSkaitlis().equals("SKAITLIS PAR LIELU"));

        //-------------------------------- DalSkaitlis tests -----------------------------
//
        DALSKAITLIS dalskaitlis11 = new DALSKAITLIS("2", "4");
        DALSKAITLIS dalskaitlis12 = new DALSKAITLIS("1", "8");
        dalskaitlis11.add(dalskaitlis12);
        System.out.println(dalskaitlis11.getSkait().getLielsSkaitlis().equals("5")
                && dalskaitlis11.getSauc().getLielsSkaitlis().equals("8"));
        DALSKAITLIS dalskaitlis21 = new DALSKAITLIS("-1", "2");
        DALSKAITLIS dalskaitlis22 = new DALSKAITLIS("-2", "2");
        dalskaitlis21.add(dalskaitlis22);
        System.out.println(dalskaitlis21.getSkait().getLielsSkaitlis().equals("-3")
                && dalskaitlis21.getSauc().getLielsSkaitlis().equals("2"));
        DALSKAITLIS dalskaitlis31 = new DALSKAITLIS("2", "4");
        DALSKAITLIS dalskaitlis32 = new DALSKAITLIS("1", "8");
        dalskaitlis31.divide(dalskaitlis32);
        System.out.println(dalskaitlis31.getSkait().getLielsSkaitlis().equals("4")
                && dalskaitlis31.getSauc().getLielsSkaitlis().equals("1"));
        DALSKAITLIS dalskaitlis41 = new DALSKAITLIS("2", "4");
        DALSKAITLIS dalskaitlis42 = new DALSKAITLIS("-1", "8");
        dalskaitlis41.divide(dalskaitlis42);
        System.out.println(dalskaitlis41.getSkait().getLielsSkaitlis().equals("-4")
                && dalskaitlis41.getSauc().getLielsSkaitlis().equals("1"));
        DALSKAITLIS dalskaitlis51 = new DALSKAITLIS("2434", "844");
        DALSKAITLIS dalskaitlis52 = new DALSKAITLIS("203", "500");
        dalskaitlis51.add(dalskaitlis52);
        System.out.println(dalskaitlis51.getSkait().getLielsSkaitlis().equals("347083")
                && dalskaitlis51.getSauc().getLielsSkaitlis().equals("105500"));
        DALSKAITLIS dalskaitlis61 = new DALSKAITLIS("16", "-32");
        DALSKAITLIS dalskaitlis62 = new DALSKAITLIS("36", "45");
        dalskaitlis61.divide(dalskaitlis62);
        System.out.println(dalskaitlis61.getSkait().getLielsSkaitlis().equals("-5")
                && dalskaitlis61.getSauc().getLielsSkaitlis().equals("8"));
        DALSKAITLIS dalskaitlis71 = new DALSKAITLIS("36", "45");
        DALSKAITLIS dalskaitlis72 = new DALSKAITLIS("-5", "8");
        dalskaitlis71.add(dalskaitlis72);
        System.out.println(dalskaitlis71.getSkait().getLielsSkaitlis().equals("7")
                && dalskaitlis71.getSauc().getLielsSkaitlis().equals("40"));
        DALSKAITLIS dalskaitlis81 = new DALSKAITLIS("-2");
        DALSKAITLIS dalskaitlis82 = new DALSKAITLIS("7", "40");
        dalskaitlis81.divide(dalskaitlis82);
        System.out.println(dalskaitlis81.getSkait().getLielsSkaitlis().equals("-80")
                && dalskaitlis81.getSauc().getLielsSkaitlis().equals("7"));
//
        DALSKAITLIS dalskaitlis91 = new DALSKAITLIS("-5", "8");
        DALSKAITLIS dalskaitlis92 = new DALSKAITLIS("7", "40");
        System.out.println(!dalskaitlis91.isEqual(dalskaitlis92));
        DALSKAITLIS dalskaitlis101 = new DALSKAITLIS("7", "40");
        DALSKAITLIS dalskaitlis102 = new DALSKAITLIS("-80", "7");
        System.out.println(!dalskaitlis101.isEqual(dalskaitlis102));
        DALSKAITLIS dalskaitlis111 = new DALSKAITLIS("-80", "7");
        DALSKAITLIS dalskaitlis112 = new DALSKAITLIS("-80", "7");
        System.out.println(dalskaitlis111.isEqual(dalskaitlis112));

        DALSKAITLIS dalskaitlis121 = new DALSKAITLIS("80", "-7");
        dalskaitlis121.display();

        DALSKAITLIS dalskaitlis122 = new DALSKAITLIS("1", "2");
        dalskaitlis122.display();

        DALSKAITLIS dalskaitlis123 = new DALSKAITLIS("4", "-2");
        dalskaitlis123.display();

        DALSKAITLIS dalskaitlis131 = new DALSKAITLIS("74983758954", "2");
        DALSKAITLIS dalskaitlis132 = new DALSKAITLIS("40849379489", "7389548");
        dalskaitlis131.add(dalskaitlis132);
        System.out.println(dalskaitlis131.getSkait().getLielsSkaitlis().equals("277048083854885885")
                && dalskaitlis131.getSauc().getLielsSkaitlis().equals("7389548"));
    }
}
