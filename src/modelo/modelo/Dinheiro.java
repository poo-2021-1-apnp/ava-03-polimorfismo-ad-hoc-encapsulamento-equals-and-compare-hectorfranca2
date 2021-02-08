package modelo;

import java.text.DecimalFormat;
import java.math.RoundingMode;

public class Dinheiro implements Comparable<Dinheiro> {

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
    DecimalFormat df = new DecimalFormat("#,##0.00");
    df.setRoundingMode(RoundingMode.DOWN);
    String numero_texto = df.format(reais).replace(".", ",");
    String valor[] = numero_texto.split(",");
    this.centavos = (Integer.parseInt(valor[0]) * 100) + Integer.parseInt(valor[1]);
  }

  public Dinheiro(String reais) {
    String numero_texto = reais.replace("R$ ", "");
    String valor[] = numero_texto.split(",");
    this.centavos = (Integer.parseInt(valor[0]) * 100)
        + Integer.parseInt(valor[1].length() > 1 ? valor[1].substring(0, 2) : valor[1]);
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
    DecimalFormat df = new DecimalFormat("#,##0.00");
    df.setRoundingMode(RoundingMode.DOWN);
    String numero_texto = df.format(d).replace(".", ",");
    String valor[] = numero_texto.split(",");
    this.centavos += (Integer.parseInt(valor[0]) * 100) + Integer.parseInt(valor[1]);
  }

  public void somar(String d) {
    String numero_texto = d.replace("R$ ", "");
    String valor[] = numero_texto.split(",");
    this.centavos += (Integer.parseInt(valor[0]) * 100)
        + Integer.parseInt(valor[1].length() > 1 ? valor[1].substring(0, 2) : valor[1]);
  }

  public void imprimir() { // Não é ilegal imprimir Dinheiro? 😏
    System.out.println(String.format("R$ %d,%02d", this.getReais(), this.getCentavos()));
  }

  @Override
  public boolean equals(Object outroObjeto) {
    if (this == outroObjeto)
      return true;
    if (null == outroObjeto)
      return false;
    if (outroObjeto instanceof Dinheiro) {
      Dinheiro outroDinheiro = (Dinheiro) outroObjeto;
      if (this.centavos == outroDinheiro.centavos)
        return true;
    }
    return false;
  }

  @Override
  public int compareTo(Dinheiro outroDinheiro) {
    return this.centavos - outroDinheiro.centavos;
  }

}
