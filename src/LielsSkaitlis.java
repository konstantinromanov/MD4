class LielsSkaitlis {
    private String skaitlis;
    //Varat pievienot savus laukus, ja tas ir nepieciesams

    private int[] _intArray;
    private String _sign = "";
    private boolean _IsAvailableForOperation = true;

    LielsSkaitlis(String str) {
        skaitlis = str;
        createIntArray();
    }

    public void add(LielsSkaitlis sk) {

        if (!sk.isAvailableForOperation()) {
            skaitlis = sk.getLielsSkaitlis();
            _IsAvailableForOperation = false;
        } else if (_IsAvailableForOperation) {
            if ((sk.getSign() + _sign).length() % 2 == 0) {
                processAdd(sk);
            } else {
                processSub(sk);
            }
        }
    }

    public void sub(LielsSkaitlis sk) {

        if (!sk.isAvailableForOperation()) {
            skaitlis = sk.getLielsSkaitlis();
            _IsAvailableForOperation = false;
        } else if (_IsAvailableForOperation) {
            if ((sk.getSign() + _sign).length() % 2 != 0) {
                processAdd(sk);
            } else {
                processSub(sk);
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
            createIntArray();
        }
    }

    //Varat pievienot savas metodes, ja tas ir nepieciesams

    private void createIntArray() {

        if (isResultValid()) {
            char[] charArr = skaitlis.toCharArray();
            _sign = (charArr[0] != '-') ? "" : "-";
            _intArray = new int[_sign.equals("") ? charArr.length: charArr.length - 1];

            for (int i = (_sign.equals("") ? 0 : 1), j = 0; i < charArr.length; i++, j++) {
                _intArray[j] = Integer.parseInt(String.valueOf(charArr[i]));
            }
        }
    }

    private void processAdd(LielsSkaitlis sk) {

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
        skaitlis = _sign + result;
        reverse();
    }

    private void processSub(LielsSkaitlis sk) {

        int[] smallestArr;
        int[] biggestArr;
        String result = "";
        int carry = 0;

        if (hasBiggerAbsoluteValue(sk)) {
            biggestArr = sk.getLielsSkaitlisArray();
            smallestArr = getLielsSkaitlisArray();
            if (_sign.length() == 1) {
                _sign = "";
            } else {
                _sign = "-";
            }
        } else {
            biggestArr = getLielsSkaitlisArray();
            smallestArr = sk.getLielsSkaitlisArray();
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

        skaitlis = _sign + result;
        reverse();
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

    private boolean hasBiggerAbsoluteValue(LielsSkaitlis sk) {

        boolean isThisBigger = false;

        if (_intArray.length < sk.getLielsSkaitlisArray().length) {
            isThisBigger = true;

        } else if (_intArray.length == sk.getLielsSkaitlisArray().length) {

            for (int i = 0; i < _intArray.length; i++) {

                if (_intArray[i] < sk.getLielsSkaitlisArray()[i]) {
                    isThisBigger = true;

                    break;
                }
            }
        }

        return isThisBigger;
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