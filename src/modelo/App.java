import modelo.Dinheiro;

class App {
  public static void main(String[] args) {

    Dinheiro d1 = new Dinheiro(2, 30);
    Dinheiro d2 = new Dinheiro(5, 80);
    d1.somar(d2);
    System.out.println(d1.getReais() == 8);
    System.out.println(d1.getCentavos() == 10);

    Dinheiro bufunfa = new Dinheiro(1, 1);
    bufunfa.imprimir(); // R$ 1,01

    // ETAPA 1 - TORNAR DINHEIRO POLIMÓRFICO

    System.out.println("---------------------------------------");
    System.out.println(" Etapa 1 - Tornar Dinheiro Polimórfico");
    System.out.println("---------------------------------------");

    Dinheiro d3 = new Dinheiro(3, 45);
    System.out.println(d3.getReais() == 3);
    System.out.println(d3.getCentavos() == 45);

    Dinheiro d4 = new Dinheiro(200);
    System.out.println(d4.getReais() == 200);
    System.out.println(d4.getCentavos() == 0);

    Dinheiro d5 = new Dinheiro("R$ 345,75");
    System.out.println(d5.getReais() == 345);
    System.out.println(d5.getCentavos() == 75);

    Dinheiro d6 = new Dinheiro("R$ 1000000,11");
    System.out.println(d6.getReais() == 1000000);
    System.out.println(d6.getCentavos() == 11);

    Dinheiro d7 = new Dinheiro("R$ 2567,89");
    System.out.println(d7.getReais() == 2567);
    System.out.println(d7.getCentavos() == 89);
  }
}
