import modelo.Dinheiro;
import modelo.Veiculo;
import modelo.Data;
import java.util.Arrays;

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

    Dinheiro d8 = new Dinheiro(9.75);
    System.out.println(d8.getReais() == 9);
    System.out.println(d8.getCentavos() == 75);

    Dinheiro d9 = new Dinheiro(17.569); // é truncado nas duas casas, não arredondado!
    System.out.println(d9.getReais() == 17);
    System.out.println(d9.getCentavos() == 56);

    d3.somar(d4);
    System.out.println(d3.getReais() == 203);
    System.out.println(d3.getCentavos() == 45);

    d5.somar(100);
    System.out.println(d5.getReais() == 445);
    System.out.println(d5.getCentavos() == 75);

    d6.somar(1.90);
    System.out.println(d6.getReais() == 1000002);
    System.out.println(d6.getCentavos() == 01);

    d7.somar("R$ 998817,86986");
    System.out.println(d7.getReais() == 1001385);
    System.out.println(d7.getCentavos() == 75);

    // ETAPA 2 - AVALIAR EQUIVALÊNCIA DE DINHEIRO COM EQUALS

    System.out.println("---------------------------------------");
    System.out.println(" Etapa 2 - Avaliar a equivalência de Dinheiro com equals");
    System.out.println("---------------------------------------");

    d8 = new Dinheiro(8, 98);
    d9 = new Dinheiro(8, 99);
    Dinheiro d10 = null;
    Dinheiro d11 = new Dinheiro(8, 98);
    Dinheiro d12 = d8;

    System.out.println(d8.equals(d9) == false);
    System.out.println(d8.equals(d10) == false);
    System.out.println(d8.equals(d11) == true);
    System.out.println(d8.equals(d12) == true);

    System.out.println(new Dinheiro(3.43).equals(new Dinheiro(3, 43)));
    System.out.println(new Dinheiro("R$ 8,97").equals(new Dinheiro(8, 97)));
    System.out.println(!new Dinheiro("R$ 5,43").equals(null));

    // ETAPA 3 - TORNAR DINHEIRO COMPARÁVEL

    System.out.println("---------------------------------------");
    System.out.println(" Etapa 3 - Tornar Dinheiro comparável");
    System.out.println("---------------------------------------");

    d12 = new Dinheiro(4, 30);
    Dinheiro d13 = new Dinheiro(987, 14);
    Dinheiro d14 = new Dinheiro(0, 1);
    Dinheiro d15 = new Dinheiro(17, 9);
    Dinheiro d16 = new Dinheiro(4, 30);

    System.out.println(d12.compareTo(d13) < 0);
    System.out.println(d12.compareTo(d14) > 0);
    System.out.println(d12.compareTo(d15) < 0);
    System.out.println(d12.compareTo(d16) == 0);

    Comparable d17 = new Dinheiro(8);
    Comparable d18 = new Dinheiro(9);
    Comparable d19 = new Dinheiro(8);
    System.out.println(d17.compareTo(d18) < 0);
    System.out.println(d17.compareTo(d19) == 0);
    System.out.println(d18.compareTo(d17) > 0);

    Dinheiro[] dindin = { d12, d13, d14, d15, d16 };

    // Classifique em ordem crescente através de java.util.Arrays

    Arrays.sort(dindin);

    System.out.println(dindin[0].equals(d14));
    System.out.println(dindin[1].equals(d12));
    System.out.println(dindin[2].equals(d12));
    System.out.println(dindin[3].equals(d15));
    System.out.println(dindin[4].equals(d13));

    // ETAPA 4 - IMPLEMENTE DATA

    System.out.println("---------------------------------------");
    System.out.println(" Etapa 4 - Implemente Data");
    System.out.println("---------------------------------------");

    Data data = new Data(5, 3, 1999);
    System.out.println(data.getDia() == 5);
    System.out.println(data.getMes() == 3);
    System.out.println(data.getAno() == 1999);

    data = new Data("04/02/2000");
    System.out.println(data.getDia() == 4);
    System.out.println(data.getMes() == 02);
    System.out.println(data.getAno() == 2000);

    data = new Data("04-02-2000");
    System.out.println(data.getDia() == 4);
    System.out.println(data.getMes() == 02);
    System.out.println(data.getAno() == 2000);

    data.somarDia(15);
    System.out.println(data.getDia() == 19);
    System.out.println(data.getMes() == 02);
    System.out.println(data.getAno() == 2000);

    data.somarMes(15);
    System.out.println(data.getDia() == 19);
    System.out.println(data.getMes() == 05);
    System.out.println(data.getAno() == 2001);

    data.somarAno(500);
    System.out.println(data.getDia() == 19);
    System.out.println(data.getMes() == 05);
    System.out.println(data.getAno() == 2501);

    // TRY CATCH
    try {
      data = new Data(-1, 2, 1999);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

    try {
      data = new Data(5, 2, 9999999); // erro: ano entre 1 e 3000
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

    // EQUALS
    Data date1 = new Data("05/05/2006");
    Data date2 = new Data(18, 4, 2002);
    Data date3 = new Data(5, 5, 2006);

    System.out.println(!date1.equals(date2));
    System.out.println(date1.equals(date3));
    System.out.println(!date2.equals(date3));

    System.out.println(new Data("01-04-1998").equals(new Data("01/04/1998")));

    // COMPARE TO
    Data data1 = new Data("04/05/2000");
    Data data2 = new Data(13, 5, 1888);
    Data data3 = new Data(4, 5, 2000);

    System.out.println(data1.compareTo(data2) > 0);
    System.out.println(data2.compareTo(data3) < 0);
    System.out.println(data3.compareTo(data1) == 0);

    Comparable da1 = new Data("09/10/1455");
    Comparable da2 = new Data(12, 3, 2001);
    Comparable da3 = da1;

    System.out.println(da1.compareTo(da2) < 0);
    System.out.println(da1.compareTo(da1) == 0);

    // ETAPA 5 - IMPLEMENTAR EQUALS EM VEICULO

    System.out.println("---------------------------------------");
    System.out.println(" Etapa 5 - Implementar equals em Veiculo");
    System.out.println("---------------------------------------");

    Veiculo a1 = new Veiculo("FTH4R58", "Renault", "Duster", 16);
    Veiculo a2 = new Veiculo("WEH4R42", "Ford", "Fiesta", 16);
    Veiculo a3 = new Veiculo("FTH4R58", "Volkswagen", "Gol", 10);
    Veiculo a4 = new Veiculo("LKI5H48", "Renault", "Duster", 16);

    System.out.println(!a1.equals(a2));
    System.out.println(!a1.equals(a4));
    System.out.println(!a2.equals(a4));
    System.out.println(a1.equals(a3)); // true - placa clonada

    System.out.println(new Veiculo("WEH4R42", "Ford", "Fiesta", 16).equals(a2));
    System.out.println(!new Veiculo("LKI8H48", "Renault", "Duster", 16).equals(a4));
  }
}
