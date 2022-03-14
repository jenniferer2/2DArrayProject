public class Shifting {
    private String[][] array;
    private int numRows;
    private int numCols;
    private String own;

    public Shifting (int r, int c, String own) {
        array = new String[r][c];
        numRows = r;
        numCols = c;
        this.own = own;

    }
    public String[][] getArray()
    {
        return array;
    }


    public String changeLetter () {
        own = own.toLowerCase();
        String res = "";
        String alpha = "abcdefghijklmnopqrstuvwxyz"; {
            for (int i = 0; i < own.length(); i ++) {
               String keep = own.substring(i , i +1);
               if (keep.equals("z")) {
                   String g = "a";
                   res = res + g ;
               }
               else {
                   int track = alpha.indexOf(keep) + 1;
                   res = res + alpha.substring(track, track + 1);
               }


            }
        }
        own = res;
        return own;

    }
    public void fillBlock () {
        int i = 0;
        for (int r = 0; r < numRows; r++) {
                for (int c = 0; c < numCols; c++) {
                if (i != own.length()) {
                    array[r][c] = own.substring(i, i + 1);
                    i++;
                }
                else {
                    array[r][c] = "Z";
                }
            }
        }

    }

    public void shiftArray () {
        for (int i = 0; i < numRows-1; i ++) {
            for (int k = 0; k < numCols-1; k ++) {
                String temp = array[i][k];
                String temp2 = array [i+1][k+1];
                array [i+1][k+1] = temp;
                array[i][k] = temp2;
            }
        }
    }
    public void printAll() {
        for (String [] x : array) {
            for (String d : x) {
                System.out.print(d);
            }
        }
    }
    public String encryptBlock() {
      // use otehr method this isnt done

        String result = "";
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                result = result + array[r][c];


            }
        }
        return result;
    }
}


    public String removeZ(String d) {
        int g =0;
        String newn = d;
        String hold = newn.substring(newn.length()-1);

        while(hold.equals("Z")) {
            hold = newn.substring(newn.length() -1);
            if (hold.equals("Z")) {
                newn = newn.substring(0, newn.length()-1);
            }

        }
        return newn;
    }


}
