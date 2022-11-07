package fr.efrei;

public class App {
  public static void main(String[] args) {
    var app = new App();
    System.out.format("Hello, world. The answer is %d", app.getAnswer());
  }

  public int getAnswer() {
    return 42;
  }

}
