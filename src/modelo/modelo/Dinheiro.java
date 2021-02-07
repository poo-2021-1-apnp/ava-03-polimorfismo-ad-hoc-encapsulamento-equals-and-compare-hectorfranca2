package modelo;

import java.text.DecimalFormat;

public class Dinheiro {

  private int centavos;

  // COMPORTAMENTO
  // CONTRUTOR
  public Dinheiro(int reais, int centavos) {
    this.centavos = reais * 100 + centavos;
  }

  // SOBRECARGA DO CONSTRUTOR
  public Dinheiro(int reais) {
    this.centavos = reais * 100;
  }

  public Dinheiro(double reais) {
    String centavos[] = Double.toString(reais).split(".");
    this.centavos = (((int) reais) * 100) + Integer.parseInt(centavos[1]);
  }

  public Dinheiro(String reais) {
    String reais_numero = reais.replaceAll("[\\D]", "");
    String centavos[] = reais.split(",");
    String numero_real = reais_numero.substring(0, reais_numero.length() - 2);
    this.centavos = (Integer.parseInt(numero_real) * 100) + Integer.parseInt(centavos[1]);
  }

  // CONSULTA
  public int getReais() {
    return this.centavos / 100;
  }

  public int getCentavos() {
    return this.centavos % 100;
  }

  // COMANDOS
  public void somar(Dinheiro d) {
    this.centavos += d.centavos;
  }

  // SOBRECARGA DO MÉTODO SOMAR
  public void somar(int d) {
    this.centavos += d * 100;
  }

  public void somar(double d) {
    String centavos[] = Double.toString(d).split(".");
    this.centavos += (((int) d) * 100) + Integer.parseInt(centavos[1]);
  }

  public void somar(String d) {
    String d_numero = d.replaceAll("[\\D]", "");
    String centavos[] = d.split(",");
    String numero_real = d_numero.substring(0, d_numero.length() - 2);
    this.centavos += (Integer.parseInt(numero_real) * 100) + Integer.parseInt(centavos[1]);
  }

  public void imprimir() { // Não é ilegal imprimir Dinheiro? 😏
    System.out.println(String.format("R$ %d,%02d", this.getReais(), this.getCentavos()));
  }

}
