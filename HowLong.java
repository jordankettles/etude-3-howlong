import java.util.*;
import java.lang.StrictMath;

public class HowLong{

  static ArrayList<PieceOfString> strings = new ArrayList<PieceOfString>();

  public static int findIndex(char c) {
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

  public static int findLength(PieceOfString p, char parent) {
    if(p.getValue() > -1) {
      return p.getValue();
    }
    else {
      String s = p.getForm();
      if(s.contains(Character.toString(parent))) {
        return -1;
      }
      int result = 0;
      while(s.length() > 0) {
        int next_p = findIndex(s.charAt(s.length()-1));
        if(next_p == -1) {
          return -1;
        }
        int rr = findLength(strings.get(next_p), p.getName());
        if(rr  > -1) {
          try {
            result = StrictMath.addExact(result, rr);
            s = s.substring(0, s.length()-1);
          }
          catch(Exception e) {
            return -1;
          }
        } else {
          return -1;
        }
      }
      p.setValue(result);
      strings.set(findIndex(p.getName()), p);
      return result;
    }
  }

  public static void findLengths() {
    for(PieceOfString p : strings) {
      int val = findLength(p, p.getName());
      System.out.print(p.getName() + " ");
      if(val == -1) {
        System.out.println("NaN");
      } else {
        System.out.println(Integer.toString(val));
      }
    }
    strings.clear();
  }


  public static void main(String[]args) {
    Scanner scan = new Scanner(System.in);
    while(scan.hasNext()) {
      String line = scan.nextLine();
      if(line.equals("") && strings.size() > 0) {
        findLengths();
        System.out.println();
      }
      line = line.trim();
      String[] split_line = line.split(" ");
      if(split_line.length > 1) {
        strings.add(new PieceOfString(split_line[0].charAt(0), split_line[1]));
      }
    }
    findLengths();
  }
}
