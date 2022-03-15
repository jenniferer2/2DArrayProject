public class Shifting {
    private String[][] array;
    private int numRows;
    private int numCols;


    public Shifting(int r, int c) {
        array = new String[r][c];
        numRows = r;
        numCols = c;

    }

    public String[][] getArray() {
        return array;
    }


    public String changeLetter(String message) {
        message = message.toLowerCase();
        String res = "";
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        {
            for (int i = 0; i < message.length(); i++) {
                String keep = message.substring(i, i + 1);
                if (keep.equals("z")) {
                    String g = "a";
                    res = res + g;
                } else {
                    int track = alpha.indexOf(keep) + 1;
                    res = res + alpha.substring(track, track + 1);
                }


            }
        }
        return res;

    }

    public void fillBlock(String n) {
        int i = 0;
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                if (i != n.length()) {
                    array[r][c] = n.substring(i, i + 1);
                    i++;
                } else {
                    array[r][c] = "!";
                }
            }
        }

    }


    public void printAll() {
        for (String[] x : array) {
            for (String d : x) {
                System.out.print(d);
            }
        }
    }

    public String encryptMessage(String message) {

        String result = "";
        for (int i = 0; i < message.length(); i = numRows * numCols + i) {
            fillBlock(message.substring(i));
            result = result + encryptBlock();

        }

        return result;

    }
    // shifting each element two to the left

    public String encryptBlock() {
            String result = "";

           shiftRight();

            for (int i = 0; i < numRows; i++) {
                for (int k = 0; k < numCols; k++) {
                    result = result + array[i][k];
                }
            }
            changeLetter(result);
            return result;


        }
        // shift right by 1
        public void shiftRight() {

        for (int i = 0; i < numRows; i++){
            String temp = array[i][numCols-1];
            for (int k = numCols-1; k >= 1; k--) {
                array[i][k] = array [i][k-1];
            }
        }
        }



        public String removed (String d){
            String newn = d;
            String hold = newn.substring(newn.length() - 1);

            while (hold.equals("!")) {
                hold = newn.substring(newn.length() - 1);
                if (hold.equals("!")) {
                    newn = newn.substring(0, newn.length() - 1);
                }

            }
            return newn;
        }
    public String decrypt2 (String en) {
        String x [][] = new String [numRows][numCols] ;
        int i = 0;
        for (int r = 1; r < numRows; r++) {
            for (int c = 1; c < numCols ; c++) {

                x[r-1][c-1] = en.substring(i, i + 1);
                i++;

            }
        }
        String res = "";

        for (int r = 0; r < x.length;r++) {
            for (int c = 0; c < x[0].length; c++) {

                res = res + x[r][c];


            }
        }

        return res;

    }




    public String decryptMessage(String encryptedMessage)
    {
        String result = "";
        String h = encryptedMessage;
        for (int i = 0; i < encryptedMessage.length(); i =  numRows*numCols + i) {


            String s = encryptedMessage.substring(i, numRows*numCols + i);
            result = result + decrypt2(s);

        }
        result = removed(result);


        return result;

    }


    }
