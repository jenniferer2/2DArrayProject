import java.util.Arrays;

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
        String res = "";
        String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        {
            for (int i = 0; i < message.length(); i++) {
                String keep = message.substring(i, i + 1);
                if (keep.equals("z")) {
                    String g = "a";
                    res = res + g;
                }
                else if (keep.equals("Z")) {
                    String g = "A";
                    res = res + g;
                }
                else if (alpha.indexOf(keep)==-1) {
                    res = res + keep;
                }

                else {
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

    public String encryptMessage(String message) {

        String result = "";

        for (int i = 0; i < message.length(); i = numRows * numCols + i) {
            fillBlock(message.substring(i));
            result = result + encryptOne();

            }
        result = changeLetter(result);
        return result;



        }

    public String encryptOne () {
        String[][] lin = new String[numRows][numCols];
        String res = "";
        for (int r = 0; r < numRows - 1; r++) {
            for (int c = 0; c < numCols - 1; c++) {
                lin[r + 1][c + 1] = array[r][c];
            }
        }


            for (int c = 0; c < numCols - 1; c++) {
                lin[0][c + 1] = array[numRows - 1][c];

            }

            for (int r = 0; r < numRows - 1; r++) {
                lin[r + 1][0] = array[r][numCols - 1];


            }
            lin[0][0] = array[numRows - 1][numCols - 1];

            for (int r = 0; r < numRows; r++) {
                for (int c = 0; c < numCols; c++) {
                    res = res + lin[r][c];

                }
            }
            array = lin;



        return res;

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
    public String decrypt2 (String s) {
        String res = "";
        String lin[][] = new String[numRows][numCols];
        int i = 0;
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                if (i != s.length()) {
                    lin[r][c] = s.substring(i, i + 1);
                    i++;

                }
            }
        }

        String save = "";
        for (int c = 1; c < numCols; c++ ) {
            save = save +lin[0][c];
        }
        save = save +lin[0][0];
        int col = 1;
        for (int z = 1; z < numRows; z++) {
            for (int d = 1; d < numCols; d++) {
                res = res + lin [z][d];
            }
            res = res + lin [z][0];

        }
        res = res + save;


        return res;
    }




    public String returnToLetter(String message) {
        String res = "";
        String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        {
            for (int i = 0; i < message.length(); i++) {
                String keep = message.substring(i, i + 1);
                if (keep.equals("a")) {
                    String g = "z";
                    res = res + g;
                }
                else if (keep.equals("A")) {
                    String g = "z";
                    res = res + g;
                }
                else if (alpha.indexOf(keep)==-1) {
                    res = res + keep;
                }

                else {
                    int track = alpha.indexOf(keep) - 1 ;
                    res = res + alpha.substring(track, track + 1);
                }


            }
        }
        return res;

    }




    public String decryptMessage(String encryptedMessage)
    {
        String result = "";
        for (int i = 0; i < encryptedMessage.length(); i =  numRows*numCols + i) {


            String s = encryptedMessage.substring(i, numRows*numCols + i);
            result = result + decrypt2(s);

        }
        result = removed(result);
        result = returnToLetter(result);


        return result;

    }


    }
