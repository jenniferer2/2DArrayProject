import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {
    Shifting create = new Shifting (3 , 2);

  //System.out.println(create.changeLetter("See you"));
create.fillBlock("doremi");
//System.out.print(Arrays.deepToString(create.getArray()));
  System.out.print("\n"  + create.encryptMessage("See you later alligator"));
    //    System.out.print("\n"  + create.returnToLetter("jnpEfs"));
        System.out.print("\n"  + create.decryptMessage("pzfT ffu vbmjm smb!sbhpu"));

        Shifting gerbil = new Shifting (2 , 4);
        System.out.print("\n"  + create.encryptMessage("After a while crocodile"));
        System.out.print("\n"  + create.decryptMessage(" sgBfumj bixdp fsd!fepmj"));
















    }
}
