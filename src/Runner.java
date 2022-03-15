import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {
    Shifting create = new Shifting (2 , 3);

  System.out.print(create.changeLetter("See you later"));
  create.fillBlock("See you later");

        System.out.println(create.encryptMessage("See you later"));
        System.out.println(Arrays.deepToString(create.getArray()));
        System.out.println(create.decryptMessage("yoe Setelau !!!!r!"));






    }
}
