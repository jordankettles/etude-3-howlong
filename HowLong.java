import java.util.*;

//Use strict math for overflow
public class HowLong{

  static ArrayList<PieceOfString> strings = new ArrayList<PieceOfString>();

  public static int findIndex(char c) {
    //try get index of d.
    int index = 0;
    while(strings.get(index).getName() != c) {
      index++;
      if(index >= strings.size()) {
        index = -1;
        break;
      }
    }
    return index;
  }

  public static String findValue(char c) {
    int index = findIndex(c);
    if(index == -1) {
      return "NaN";
    }
    return Integer.toString(index);
  }

  public static void main(String[]args) {
    //add strings to array list.
    //find each length.
    strings.add(new PieceOfString('j', "Hello"));
    System.out.println(findValue('j'));
    System.out.println(findValue('d'));
    System.out.println(strings);
  }
}
