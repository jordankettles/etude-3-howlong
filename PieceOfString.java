public class PieceOfString{

  private char name;
  private int value; //if this is -1 then it is represented by other POS.
  private String form;

  PieceOfString(char name, String form) {
    this.name = name;
    try {
      this.value = Integer.parseInt(form);
      this.form = "";
    }

    catch(Exception e) {
      value = -1;
      this.form = form;
      //this piece of string is defined as other pieces of string.
    }
  }

  public int getValue() {
      return value;
  }

  public String getForm() {
    return form;
  }

  public char getName() {
    return name;
  }

  public String toString() {
    if (value > -1) {
    return name + " " + Integer.toString(value);
    }

    return name + " " + form;
  }
}
