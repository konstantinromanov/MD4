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

            if ((sk.getSign() + _sign).length() % 2 == 0) {
                _intArray = processAdd(_intArray, sk.getLielsSkaitlisArray());
            } else {

                if (!hasGreaterAbsoluteValue(_intArray, sk.getLielsSkaitlisArray())) {
                    _sign = sk.getSign();
                    _intArray = processSub(sk.getLielsSkaitlisArray(), this._intArray);
                } else {
                    _intArray = processSub(this._intArray, sk.getLielsSkaitlisArray());
                }
            }

            skaitlis = _sign + arrayToString(_intArray);

            if (!isResultValid()) {
                invalidateResult();
            }
        }
    }

    private String arrayToString(int[] arr) {
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

            if ((sk.getSign() + _sign).length() % 2 != 0) {
                _intArray = processAdd(_intArray, sk.getLielsSkaitlisArray());

            } else {

                if (hasGreaterAbsoluteValue(_intArray, sk.getLielsSkaitlisArray())) {
                    _intArray = processSub(this._intArray, sk.getLielsSkaitlisArray());
                } else {
                    _sign = "-";
                    _intArray = processSub(sk.getLielsSkaitlisArray(), this._intArray);
                }
            }

            skaitlis = _sign + arrayToString(_intArray);

            if (!isResultValid()) {
                invalidateResult();
            }
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

    private int[] processSub(int[] a, int[] b) {

        int carry = 0;

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

    public void multiply(LielsSkaitlis sk) {

        int[] result = processMultiply(this._intArray, sk.getLielsSkaitlisArray());
        this._intArray = result;
        this._sign = (this._sign + sk.getSign()).length() % 2 != 0 ? "-" : "";
        this.skaitlis = this._sign + arrayToString(result);
    }

    private int[] processMultiply(int[] a, int[] b) {

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
        // split last element if it has more than 1 digit in it
        if (sumVec.lastElement() > 9){
            int lastEl1 = sumVec.lastElement() / 10;
            int lastEl2 = sumVec.lastElement() % 10;
            sumVec.removeElementAt(sumVec.size() - 1);
            sumVec.add(lastEl2);
            sumVec.add(lastEl1);
        }

        return reverseVectorToArray(sumVec);
    }

    public String getRemainder(LielsSkaitlis sk) {

        int[] arr1 = this._intArray;

        while (hasGreaterAbsoluteValue(arr1, sk.getLielsSkaitlisArray()) || hasEqualAbsoluteValues(arr1, sk.getLielsSkaitlisArray())) {
            arr1 = this.processSub(arr1, sk.getLielsSkaitlisArray());
        }

        return arrayToString(arr1);
    }

    public void divide(LielsSkaitlis dal) {
        String remainder = checkDivisorAndHandleDivisionResult(dal);
    }

    public String divideAndGetRemainder(LielsSkaitlis dal) {
        return checkDivisorAndHandleDivisionResult(dal);
    }

    private String checkDivisorAndHandleDivisionResult(LielsSkaitlis dal){

        if (dal.getLielsSkaitlis().equals("0")){
            return "0";
        }

        if (hasGreaterAbsoluteValue(dal.getLielsSkaitlisArray(), this._intArray)) {
            this.skaitlis = "0";
            this._intArray = new int[]{0};
        }

        int[][] result = processDivide(_intArray, dal.getLielsSkaitlisArray());
        this._intArray = result[0];
        this._sign = (this._sign + dal.getSign()).length() % 2 != 0 ? "-" : "";
        this.skaitlis = this._sign + arrayToString(this._intArray);

        return arrayToString(result[1]);
    }

    private int[][] processDivide(int[] divident, int[] divisor) {

        Vector<Integer> resultVec = new Vector<Integer>(divident.length);
        int[] tempDivident = new int[divisor.length];

        for (int i = 0; i < tempDivident.length; i++) {
            tempDivident[i] = divident[i];
        }

        if (hasGreaterAbsoluteValue(divisor, tempDivident)) {
            tempDivident = new int[divisor.length + 1];
            for (int i = 0; i < tempDivident.length; i++) {
                tempDivident[i] = divident[i];
            }
        }

        int position = tempDivident.length;

        while (true) {

            int counter = 0;

            while (hasGreaterAbsoluteValue(tempDivident, divisor) || hasEqualAbsoluteValues(tempDivident, divisor)) {
                tempDivident = this.processSub(tempDivident, divisor);
                counter++;
            }

            resultVec.add(counter);

            if (position == divident.length) {
                break;
            }

            tempDivident = Arrays.copyOf(tempDivident, tempDivident.length + 1);
            tempDivident[tempDivident.length - 1] = divident[position];
            position++;
        }

        int[] resultArr = new int[resultVec.size()];

        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = resultVec.elementAt(i);
        }

        int[][] result = new int[][]{resultArr, tempDivident.length > 0 ? tempDivident : new int[]{0}};

        return result;
    }

    public LielsSkaitlis findLcm(LielsSkaitlis sk) {

        int[] arr1 = this._intArray;
        int[] arr2 = sk.getLielsSkaitlisArray();
        String gcd = this.findGcd(sk);
        int[] lcmDiv = processDivide(arr1, this.createIntArray(gcd))[0];
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

        if (this._sign.length() < sk.getSign().length()
                || this._sign.length() == 1 && this.hasGreaterAbsoluteValue(sk.getLielsSkaitlisArray(), this._intArray)
                || this._sign.length() == 0 && this.hasGreaterAbsoluteValue(this._intArray, sk.getLielsSkaitlisArray())) {
            return true;
        } else {
            return false;
        }
    }

    public String findGcd(LielsSkaitlis dal) {

        int[] arr1;
        int[] arr2;

        if (hasGreaterAbsoluteValue(this._intArray, dal.getLielsSkaitlisArray())){
            arr1 = this._intArray;
            arr2 = dal.getLielsSkaitlisArray();
        } else {
            arr2 = this._intArray;
            arr1 = dal.getLielsSkaitlisArray();
        }

        while (!hasEqualAbsoluteValues(arr2, new int[]{0})) {

            int[] t = arr2;
            arr2 = processDivide(arr1, arr2)[1];
            arr1 = t;
        }

        return arrayToString(arr1);
    }

    public String getAbs() {
        return this._sign.length() > 0 ? this.skaitlis.substring(1) : this.skaitlis;
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