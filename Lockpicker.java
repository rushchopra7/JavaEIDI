package pgdp;

public class Lockpicker {

    private Mysterybox mbox;

    public Lockpicker(Mysterybox box) {
        this.mbox = box;
    }

    // ---------------------- Teil 1 Methoden ----------------------

    public  String decryptInteger(int ix) {

        int ix2 = ix*ix;
        int mul = ix2 * getMbox().getIntHint();
        int abs = Math.abs(mul) % 26;
        String decrypted = HelperBook.intToAlphabetCharacter(abs);
        System.out.println("integer:  " + abs + "  decrypted integer:   " + decrypted);
        return decrypted;
        //return "";
    }

    public String decryptFloat(float fx) {

        float sum = fx + getMbox().getIntHint();
        float mul = sum * getMbox().getFloatHint();
        double abs =  Math.abs(Math.cos(mul));
        double round =  Math.round(abs*1000.0)/1000.0;
        String decrypted = String.format("%.3f",round);
        String d = decrypted.substring(decrypted.indexOf(".") + 1);
        return d;

    }

    public String decryptNumericalString(String sx) {
        if (sx == null || sx.length() != 8 || !sx.matches("[0-9]{8}")) {
            throw new IllegalArgumentException("Input must be an 8-digit numerical string.");
        }
        String s1 = sx.substring(0,2);
           String s2 = sx.substring(2,4);
          String  s3 = sx.substring(4,6);
           String s4 = sx.substring(6,8);

        int ss1,ss2,ss3,ss4;
        ss1 = Integer.parseInt(s1);
        ss2 = Integer.parseInt(s2);
        ss3 = Integer.parseInt(s3);
        ss4 = Integer.parseInt(s4);
        ss1 = ss1 % 26;
        ss2 = ss2 % 26;
        ss3 = ss3 % 26;
        ss4 = ss4 % 26;

        if (ss1 < 0 || ss1 > 25 || ss2 < 0 || ss2 > 25 || ss3 < 0 || ss3 > 25 || ss4 < 0 || ss4 > 25) {
            throw new IllegalArgumentException("Each number pair must be in the range 0-25.");
        }
        char letter1 = (char) ('A' + ss1);
        char letter2 = (char) ('A' + ss2);
        char letter3 = (char) ('A' + ss3);
        char letter4 = (char) ('A' + ss4);

        return "" + letter1 + letter2 + letter3 + letter4;
    }

    // ---------------------- Teil 2 Methoden ----------------------

    public Float decryptModular(int a, int b) {
        float f1 = (a * mbox.getFloatHint()) % (b / mbox.getFloatHint());
        return f1;
    }

    public String decryptMinimal(float x, float y) {
        float wurzel;
        float mul;
        //String beide;
        if(x>y) {
            wurzel = (float) Math.sqrt((double) x);
            mul = y * mbox.getFloatHint();
        }
        else  {
            wurzel = (float) Math.sqrt((double) y);
            mul = x * mbox.getFloatHint();
    }
        String wurzelStr = String.format("%.4f", wurzel);
        String mulStr = String.format("%.4f", mul);


        String result = wurzelStr.substring(wurzelStr.indexOf('.') + 1, wurzelStr.indexOf('.') + 5) +
                mulStr.substring(mulStr.indexOf('.') + 1, mulStr.indexOf('.') + 5);

        return result;
    }

    public int decryptBytepolar(int i, byte b) {
        int dividend = i * b;
        int divisor = ((i % b) << 1) + 1 ;

        return dividend / divisor ;
    }

    // ---------------------- Teil 3 Methoden ----------------------

    public boolean solve() {
       int a = mbox.getModularVal2();
       byte b = mbox.getPolarVal2();
       int c = mbox.getModularVal2();
       float d = mbox.getMinimalVal1();
       float e = mbox.getMinimalVal2();

       float floatValue = decryptModular(a,c);
       String stringValue = decryptMinimal(d,e);
       int intValue = decryptBytepolar(a,b);

       String decryptedInt = decryptInteger(intValue);
       String decryptedFloat = decryptFloat(floatValue);
       String decryptedString = decryptNumericalString(stringValue);

       String password = decryptedInt + "_" + decryptedFloat + "_" + decryptedString;
       boolean isPasswordRight  = mbox.checkSolution(password);
       return isPasswordRight;
    }

    // ====================== Helper/Getter/Setter ======================


    public Mysterybox getMbox() {
        return mbox;
    }

    public void setMbox(Mysterybox mbox) {
        this.mbox = mbox;
    }

    public static void main(String[] args) {
        // Hier kannst du deine Implementierungen testen

    }
}
