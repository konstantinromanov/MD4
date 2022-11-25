import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

class LielsSkaitlis {
    private String skaitlis;
    //Varat pievienot savus laukus, ja tas ir nepieciesams

    private int[] _intArray;
    private String _sign = "";
    private boolean _IsAvailableForOperation = true;

    LielsSkaitlis(String str) {
        skaitlis = str;
        _intArray = createIntArray(skaitlis);
    }

    public void add(LielsSkaitlis sk) {

        if (!sk.isAvailableForOperation()) {
            skaitlis = sk.getLielsSkaitlis();
            _IsAvailableForOperation = false;
        } else if (_IsAvailableForOperation) {
            String res = "";
            if ((sk.getSign() + _sign).length() % 2 == 0) {
                res = processAdd(sk);
            } else {
                res = processSub(this._intArray, sk.getLielsSkaitlisArray());
            }
            skaitlis = _sign + res;
            reverse();
        }
    }

    public void sub(LielsSkaitlis sk) {

        if (!sk.isAvailableForOperation()) {
            skaitlis = sk.getLielsSkaitlis();
            _IsAvailableForOperation = false;
        } else if (_IsAvailableForOperation) {
            String res = "";
            if ((sk.getSign() + _sign).length() % 2 != 0) {
                res = processAdd(sk);
            } else {
                res = processSub(this._intArray, sk.getLielsSkaitlisArray());
            }
            skaitlis = _sign + res;
            reverse();
        }
    }

    public void reverse() {

        if (_IsAvailableForOperation) {

            if (_sign.length() == 1) {
                skaitlis = skaitlis.substring(1);
            }

            skaitlis = new StringBuffer(skaitlis).reverse().toString().replaceFirst("^0+(?!$)", "");

            if (skaitlis.equals("0")) {
                _sign = "";
            }

            skaitlis = _sign + skaitlis;
            _intArray = createIntArray(skaitlis);
        }
    }

    //Varat pievienot savas metodes, ja tas ir nepieciesams

    private int[] createIntArray(String sk) {

        if (isResultValid()) {
            char[] charArr = sk.toCharArray();
            _sign = (charArr[0] != '-') ? "" : "-";
            int[] intArray = new int[_sign.equals("") ? charArr.length : charArr.length - 1];

            for (int i = (_sign.equals("") ? 0 : 1), j = 0; i < charArr.length; i++, j++) {
                intArray[j] = Integer.parseInt(String.valueOf(charArr[i]));
            }

            return intArray;
        }

        return null;
    }

    private String processAdd(LielsSkaitlis sk) {

        int longestArrLength = (_intArray.length <= sk.getLielsSkaitlisArray().length) ? sk.getLielsSkaitlisArray().length : _intArray.length;
        String result = "";
        int carry = 0;
        for (int i = 0; i < longestArrLength; i++) {
            int n1 = _intArray.length - i <= 0 ? 0 : _intArray[_intArray.length - 1 - i];
            int n2 = sk.getLielsSkaitlisArray().length <= i ? 0 : sk.getLielsSkaitlisArray()[sk.getLielsSkaitlisArray().length - 1 - i];
            int sum = n1 + n2 + carry;
            carry = sum < 10 ? 0 : 1;
            result += sum % 10;
        }

        result += carry;

        return result;
    }

    private String processSub(int[] sk1, int[] sk) {

        int[] smallestArr;
        int[] biggestArr;
        String result = "";
        int carry = 0;

        if (hasGreaterAbsoluteValue(sk1, sk)) {
            biggestArr = sk1;
            smallestArr = sk;
            if (_sign.length() == 1) {
                _sign = "-";
            } else {
                _sign = "";
            }
        } else {
            biggestArr = sk;
            smallestArr = sk1;
        }

        for (int i = 0; i < biggestArr.length; i++) {

            int n1 = biggestArr[biggestArr.length - 1 - i];
            int n2 = smallestArr.length <= i ? 0 : smallestArr[smallestArr.length - 1 - i];
            int sum = 0;

            if (n1 >= n2 + carry) {
                sum = n1 - (n2 + carry);
                carry = 0;
            } else {
                sum = 10 + n1 - (n2 + carry);
                carry = 1;
            }

            result += sum;
        }

        return result;
    }

    public void multiply(LielsSkaitlis sk) {

        String result = processMultiply(this._intArray, sk.getLielsSkaitlisArray());

        this.skaitlis = result;
        this._intArray = this.createIntArray(result);
    }

    private String processMultiply(int[] a, int[] b) {

        // a = a.replaceFirst("^0+(?!$)", "");
        //b = b.replaceFirst("^0+(?!$)", "");
        Vector<Vector<Integer>> multVecPar = new Vector<>();

        for (int i = b.length - 1; i >= 0; i--) {

            Vector<Integer> multArrCh = new Vector<>();
            int multCarr = 0;

            for (int j = a.length - 1; j >= 0; j--) {

                int multRes = b[i] * a[j] + multCarr;
                multCarr = 0;

                if (j == a.length - 1) {
                    for (int k = 1; k < b.length - i; k++) {
                        multArrCh.add(0);
                    }
                }

                if (String.valueOf(multRes).length() > 1 && j != 0) {
                    multCarr = multRes / 10;
                    multRes -= multCarr * 10;
                }

                multArrCh.add(multRes);
            }
            multVecPar.add(multArrCh);
        }

        Vector<Integer> sumVec = new Vector<>();
        int sumCarr = 0;

        for (int i = 0; i < multVecPar.elementAt(multVecPar.size() - 1).size(); i++) {

            int sumRes = 0;

            for (int j = multVecPar.size() - 1; j >= 0; j--) {
                if (i == multVecPar.elementAt(j).size()) {
                    break;
                }
                sumRes += multVecPar.elementAt(j).elementAt(i);
            }

            sumRes += sumCarr;
            sumCarr = 0;

            if (String.valueOf(sumRes).length() > 1 && i != multVecPar.elementAt(multVecPar.size() - 1).size() - 1) {
                sumCarr = sumRes / 10;
                sumRes -= sumCarr * 10;
            }

            sumVec.add(sumRes);
        }

        Collections.reverse(sumVec);

        return new StringBuffer(sumVec.toString().replaceAll("\\[|\\]|,|\\s", ""))
                .toString().replaceFirst("^0+(?!$)", "");
    }

    public LielsSkaitlis findLcm(LielsSkaitlis sk) {
        int[] arr1 = this._intArray;
        int[] arr2 = sk.getLielsSkaitlisArray();
        String gcd = this.findGcd(sk);
        String lcmDiv = processDivide(arr1, this.createIntArray(gcd));
        String lcm = this.processMultiply(arr2, this.createIntArray(lcmDiv));

        return new LielsSkaitlis(lcm);
    }

    private boolean isResultValid() {

        boolean result = false;

        if ((skaitlis.length() > 20 || skaitlis.length() < 1)) {

            skaitlis = _sign.length() == 0 ? "SKAITLIS PAR LIELU" : "SKAITLIS PAR MAZU";
            _IsAvailableForOperation = false;

        } else {
            result = true;
        }

        return result;
    }

    private boolean hasEqualAbsoluteValues(int[] sk2, int[] sk1) {

        if (sk1.length == sk2.length) {
            for (int i = 0; i < sk1.length; i++) {
                if (sk1[i] != sk2[i]) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    private boolean hasGreaterAbsoluteValue(int[] sk1, int[] sk2) {

        if (sk1.length > sk2.length) {
            return true;
        } else if (sk1.length == sk2.length) {

            for (int i = 0; i < sk1.length; i++) {

                if (sk1[i] < sk2[i]) {
                    return false;
                } else if (sk1[i] > sk2[i]) {
                    return true;
                }
            }

            return false;
        }

        return false;
    }

    public boolean isEqual(LielsSkaitlis sk) {
        return this._sign.length() == sk.getSign().length() && this.hasEqualAbsoluteValues(this._intArray, sk.getLielsSkaitlisArray());
    }

    public boolean isGreater(LielsSkaitlis sk) {

        if (this._sign.length() < sk.getSign().length()) {
            return true;
        } else if (this._sign.length() == 1 && this.hasGreaterAbsoluteValue(sk.getLielsSkaitlisArray(), this._intArray)) {
            return true;
        } else if (this._sign.length() == 0 && this.hasGreaterAbsoluteValue(this._intArray, sk.getLielsSkaitlisArray())) {
            return true;
        } else {
            return false;
        }
    }

    public String findGcd(LielsSkaitlis dal) {

        int[] arr1 = this._intArray;
        int[] arr2 = dal.getLielsSkaitlisArray();

        while (!hasEqualAbsoluteValues(arr1, arr2)) {
            if (hasGreaterAbsoluteValue(arr1, arr2)) {
                String dif = new StringBuffer(processSub(arr1, arr2)).reverse().toString().replaceFirst("^0+(?!$)", "");
                arr1 = createIntArray(dif);
            } else {
                String dif = new StringBuffer(processSub(arr2, arr1)).reverse().toString().replaceFirst("^0+(?!$)", "");
                arr2 = createIntArray(dif);
            }
        }

        return Arrays.toString(arr1).replaceAll("\\[|\\]|,|\\s", "");
    }

    public LielsSkaitlis divide(LielsSkaitlis dal) {

        if (hasGreaterAbsoluteValue(dal.getLielsSkaitlisArray(), this._intArray)) {
            return new LielsSkaitlis("0");
        }

        LielsSkaitlis counter = new LielsSkaitlis("1");

        while (hasGreaterAbsoluteValue(this._intArray, dal.getLielsSkaitlisArray())) {
            this.sub(dal);
            counter.add(new LielsSkaitlis("1"));
        }

        return counter;
    }

    private String processDivide(int[] sk1, int[] sk2) {

        int[] arr1 = sk1;
        int[] arr2 = sk2;
        LielsSkaitlis counter = new LielsSkaitlis("1");

        while (hasGreaterAbsoluteValue(arr1, arr2)) {
            arr1 = this.createIntArray(new StringBuffer(this.processSub(arr1, arr2)).reverse().toString().replaceFirst("^0+(?!$)", ""));
            counter.add(new LielsSkaitlis("1"));
        }

        return Arrays.toString(counter.getLielsSkaitlisArray()).replaceAll("\\[|\\]|,|\\s", "");
    }

    public String getLielsSkaitlis() {
        return skaitlis;
    }

    public int[] getLielsSkaitlisArray() {
        return _intArray;
    }

    public String getSign() {
        return _sign;
    }

    public boolean isAvailableForOperation() {
        return _IsAvailableForOperation;
    }


    // ================= Metodi display() modificet aizliegts!
    public void display() {
        System.out.println(skaitlis);
    }
}