import java.security.DigestInputStream;
import java.util.Arrays;

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
            int[] intArray = new int[_sign.equals("") ? charArr.length: charArr.length - 1];

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

        if (hasBiggerAbsoluteValue(sk1, sk)) {
            biggestArr = sk1;
            smallestArr = sk;
            if (_sign.length() == 1) {
                _sign = "";
            } else {
                _sign = "-";
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
                sum =  10 + n1 - (n2 + carry);
                carry = 1;
            }

            result += sum;
        }

        return result;
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

        if (sk1.length == sk2.length){
            for (int i = 0; i < sk1.length; i++) {
                if (sk1[i] != sk2[i]) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    private boolean hasBiggerAbsoluteValue(int[] sk2, int[] sk1) {

        boolean isThisBigger = false;

        if (sk1.length < sk2.length) {

            isThisBigger = true;

        } else if (sk1.length == sk2.length) {

            for (int i = 0; i < sk1.length; i++) {

                if (sk1[i] < sk2[i]) {
                    isThisBigger = true;

                    break;
                }
            }
        }

        return isThisBigger;
    }

    public String findGcd(String sk, String dal){

        int[] arr1 = createIntArray(sk);
        int[] arr2 = createIntArray(dal);

        while(!hasEqualAbsoluteValues(arr1, arr2)){
            if (hasBiggerAbsoluteValue(arr1, arr2)){
                String dif = new StringBuffer(processSub(arr1, arr2)).reverse().toString().replaceFirst("^0+(?!$)", "");
                arr1 = createIntArray(dif);
            }else{
                String dif = new StringBuffer(processSub(arr2, arr1)).reverse().toString().replaceFirst("^0+(?!$)", "");
                arr2 = createIntArray(dif);
            }
        }
        String strOfInts = Arrays.toString(arr1).replaceAll("\\[|\\]|,|\\s", "");
        return strOfInts;
    }

    public String[] divide(String sk, String dal){

        String remainder = "";
        int counter = 0;
        int[] skArr = createIntArray(sk);
        int[] dalArr = createIntArray(dal);
        while(hasBiggerAbsoluteValue(skArr, dalArr) || hasEqualAbsoluteValues(skArr, dalArr)){
            remainder = new StringBuffer(processSub(skArr, dalArr)).reverse().toString().replaceFirst("^0+(?!$)", "");
            skArr = createIntArray(remainder);
            counter++;
        }

        return new String[]{String.valueOf(counter), remainder};
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
    public void display() {System.out.println(skaitlis);}
}