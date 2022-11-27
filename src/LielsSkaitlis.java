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
                _intArray = processAdd(_intArray, sk.getLielsSkaitlisArray());
                // res = arrayToString(_intArray);
            } else {
                if (!hasGreaterAbsoluteValue(_intArray, sk.getLielsSkaitlisArray())) {
                    _sign = sk.getSign();
                    _intArray = processSub(sk.getLielsSkaitlisArray(), this._intArray);
                } else {
                    _intArray = processSub(this._intArray, sk.getLielsSkaitlisArray());
                    // res = arrayToString(_intArray);
                }
            }
            skaitlis = _sign + arrayToString(_intArray);
            if (!isResultValid()) {
                invalidateResult();
            }
        }
    }

    private String arrayToString(int[] arr) {
//        String test1 = Arrays.toString(arr).replaceAll("\\[|\\]|,|\\s", "");
        return new StringBuffer(Arrays.toString(arr).replaceAll("\\[|\\]|,|\\s", ""))
                .toString().replaceFirst("^0+(?!$)", "");
    }

    private int[] processAdd(int[] a, int[] b) {

        int longestArrLength = (a.length <= b.length) ? b.length : a.length;
        Vector<Integer> result = new Vector<>(longestArrLength + 1); // +1 is for carry in the end
        int carry = 0;

        for (int i = 0; i < longestArrLength; i++) {
            int n1 = a.length - i <= 0 ? 0 : a[a.length - 1 - i];
            int n2 = b.length <= i ? 0 : b[b.length - 1 - i];
            int sum = n1 + n2 + carry;
            carry = sum < 10 ? 0 : 1;
            result.add(sum % 10);
        }

        result.add(carry);

        return reverseVectorToArray(result);
    }

    private int[] reverseVectorToArray(Vector<Integer> vec) {

        int countTrailingZeros = 0;

        for (int i = vec.size() - 1; i >= 0; i--) {
            if (vec.elementAt(i) == 0) {
                countTrailingZeros++;
            } else {
                break;
            }
        }

        int[] result = new int[vec.size() - countTrailingZeros];

        for (int i = 0; i < result.length; i++) {
            result[result.length - i - 1] = vec.elementAt(i);
        }

        return result;
    }

    public void sub(LielsSkaitlis sk) {

        if (!sk.isAvailableForOperation()) {
            skaitlis = sk.getLielsSkaitlis();
            _IsAvailableForOperation = false;
        } else if (_IsAvailableForOperation) {
            // String res = "";
            if ((sk.getSign() + _sign).length() % 2 != 0) {
                _intArray = processAdd(_intArray, sk.getLielsSkaitlisArray());
                // res = arrayToString(_intArray);
            } else {

                if (hasGreaterAbsoluteValue(_intArray, sk.getLielsSkaitlisArray())) {
                    _intArray = processSub(this._intArray, sk.getLielsSkaitlisArray());
                } else {
                    _sign = "-";
                    _intArray = processSub(sk.getLielsSkaitlisArray(), this._intArray);
                }

//                _intArray = processSub(this._intArray, sk.getLielsSkaitlisArray());
                //res = arrayToString(_intArray);
            }

            skaitlis = _sign + arrayToString(_intArray);

            if (!isResultValid()) {
                invalidateResult();
            }
//            reverse();
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

//    private String processAdd(LielsSkaitlis sk) {
//
//        int longestArrLength = (_intArray.length <= sk.getLielsSkaitlisArray().length) ? sk.getLielsSkaitlisArray().length : _intArray.length;
//        String result = "";
//        int carry = 0;
//        for (int i = 0; i < longestArrLength; i++) {
//            int n1 = _intArray.length - i <= 0 ? 0 : _intArray[_intArray.length - 1 - i];
//            int n2 = sk.getLielsSkaitlisArray().length <= i ? 0 : sk.getLielsSkaitlisArray()[sk.getLielsSkaitlisArray().length - 1 - i];
//            int sum = n1 + n2 + carry;
//            carry = sum < 10 ? 0 : 1;
//            result += sum % 10;
//        }
//
//        result += carry;
//
//        return result;
//    }

    private int[] processSub(int[] a, int[] b) {

//        int[] smallestArr;
//        int[] biggestArr;

        int carry = 0;
//
//        if (hasGreaterAbsoluteValue(sk1, sk)) {
//            biggestArr = sk1;
//            smallestArr = sk;
//            if (_sign.length() == 1) {
//                _sign = "-";
//            } else {
//                _sign = "";
//            }
//        } else {
//            biggestArr = sk;
//            smallestArr = sk1;
//        }

        Vector<Integer> result = new Vector<>(a.length);

        for (int i = 0; i < a.length; i++) {

            int n1 = a[a.length - 1 - i];
            int n2 = b.length <= i ? 0 : b[b.length - 1 - i];
            int sum = 0;

            if (n1 >= n2 + carry) {
                sum = n1 - (n2 + carry);
                carry = 0;
            } else {
                sum = 10 + n1 - (n2 + carry);
                carry = 1;
            }

            result.add(sum);
        }

        return reverseVectorToArray(result);
    }

//    private String processSub(int[] sk1, int[] sk) {
//
//        int[] smallestArr;
//        int[] biggestArr;
//        String result = "";
//        int carry = 0;
//
//        if (hasGreaterAbsoluteValue(sk1, sk)) {
//            biggestArr = sk1;
//            smallestArr = sk;
//            if (_sign.length() == 1) {
//                _sign = "-";
//            } else {
//                _sign = "";
//            }
//        } else {
//            biggestArr = sk;
//            smallestArr = sk1;
//        }
//
//        for (int i = 0; i < biggestArr.length; i++) {
//
//            int n1 = biggestArr[biggestArr.length - 1 - i];
//            int n2 = smallestArr.length <= i ? 0 : smallestArr[smallestArr.length - 1 - i];
//            int sum = 0;
//
//            if (n1 >= n2 + carry) {
//                sum = n1 - (n2 + carry);
//                carry = 0;
//            } else {
//                sum = 10 + n1 - (n2 + carry);
//                carry = 1;
//            }
//
//            result += sum;
//        }
//
//        return result;
//    }

    public void multiply(LielsSkaitlis sk) {

//        String result = processMultiply(this._intArray, sk.getLielsSkaitlisArray());
        int[] result = processMultiply(this._intArray, sk.getLielsSkaitlisArray());


        this._intArray = result;
        this._sign = (this._sign + sk.getSign()).length() % 2 != 0 ? "-" : "";
        this.skaitlis = this._sign + arrayToString(result);
    }

    private int[] processMultiply(int[] a, int[] b) {

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

//        Collections.reverse(sumVec);
        return reverseVectorToArray(sumVec);
//        return new StringBuffer(sumVec.toString().replaceAll("\\[|\\]|,|\\s", ""))
//                .toString().replaceFirst("^0+(?!$)", "");
    }

    public LielsSkaitlis findLcm(LielsSkaitlis sk) {
        int[] arr1 = this._intArray;
        int[] arr2 = sk.getLielsSkaitlisArray();
        String gcd = this.findGcd(sk);
        int[] lcmDiv = processDivide(arr1, this.createIntArray(gcd));
        String lcm = arrayToString(this.processMultiply(arr2, lcmDiv));

        return new LielsSkaitlis(lcm);
    }

    private void invalidateResult() {
        skaitlis = _sign.length() == 0 ? "SKAITLIS PAR LIELU" : "SKAITLIS PAR MAZU";
        _IsAvailableForOperation = false;
    }

    private boolean isResultValid() {

        boolean result = false;

        if ((skaitlis.length() > 20 || skaitlis.length() < 1)) {
            invalidateResult();
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
                //String dif = new StringBuffer(processSub(arr1, arr2)).reverse().toString().replaceFirst("^0+(?!$)", "");
                //String dif = arrayToString()
//                arr1 = createIntArray(dif);
                arr1 = processSub(arr1, arr2);
            } else {
//                String dif = new StringBuffer(processSub(arr2, arr1)).reverse().toString().replaceFirst("^0+(?!$)", "");
//                arr2 = createIntArray(dif);
                arr2 = processSub(arr2, arr1);
            }
        }

        return Arrays.toString(arr1).replaceAll("\\[|\\]|,|\\s", "");
    }

    public void divide(LielsSkaitlis dal) {

        if (hasGreaterAbsoluteValue(dal.getLielsSkaitlisArray(), this._intArray)) {
            //return new LielsSkaitlis("0");
            this.skaitlis = "0";
            this._intArray = new int[]{0};
        }


        this._intArray = processDivide(_intArray, dal.getLielsSkaitlisArray());
        this._sign = (this._sign + dal.getSign()).length() % 2 != 0 ? "-" : "";
        this.skaitlis = this._sign + arrayToString(this._intArray);
        //return new LielsSkaitlis(counter);
    }

    public String getAbs() {
        return this._sign.length() > 0 ? this.skaitlis.substring(1) : this.skaitlis;
    }

    private int[] processDivide(int[] arr1, int[] arr2) {

        if (hasEqualAbsoluteValues(arr1, arr2)) {
            return new int[]{1};
        }

        int[] counter = new int[]{0};

        while (hasGreaterAbsoluteValue(arr1, arr2)) {
            arr1 = this.processSub(arr1, arr2);
            counter = this.processAdd(counter, new int[]{1});
        }

        return counter;
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