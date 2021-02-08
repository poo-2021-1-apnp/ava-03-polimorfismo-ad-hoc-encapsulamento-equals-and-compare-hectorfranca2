package modelo;

public class Data implements Comparable<Data> {
  // ESTADO
  private int dia;
  private int mes;
  private int ano;

  // CONSTRUTOR
  public Data(int dia, int mes, int ano) {
    if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || ano < 1 || ano > 3000) {
      throw new IllegalStateException("true: Insira uma data correta. Ex: '01-03-1995'");
    }
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
  }

  // SOBRECARGA DO CONSTRUTOR
  public Data(String data) {
    String data_texto[];
    if (data.substring(2, 3).equals("/")) {
      data_texto = data.split("/");
    } else {
      data_texto = data.split("-");
    }
    int data_int[] = new int[data_texto.length];
    for (int c = 0; c < data_texto.length; c++) {
      data_int[c] = Integer.parseInt(data_texto[c]);
    }
    if (data_int[0] < 1 || data_int[0] > 31 || data_int[1] < 1 || data_int[1] > 12 || data_int[2] < 1
        || data_int[2] > 3000) {
      throw new IllegalStateException("true: Insira uma data correta. Ex: '01-03-1995'");
    }
    this.dia = data_int[0];
    this.mes = data_int[1];
    this.ano = data_int[2];
  }

  // COMPORTAMENTO
  // CONSULTAS
  public int getDia() {
    return this.dia;
  }

  public int getMes() {
    return this.mes;
  }

  public int getAno() {
    return this.ano;
  }

  // COMANDOS
  public void somarDia(int dia) {
    if ((dia / 30) < 1) {
      this.dia += dia;
    } else {
      this.dia += (this.dia + dia) % 30;
      this.mes += dia / 30;
    }
  }

  public void somarMes(int mes) {
    if ((mes / 12) < 1) {
      this.mes += mes;
    } else {
      this.mes += mes % 12;
      this.ano += mes / 12;
    }
  }

  public void somarAno(int ano) {
    this.ano += ano;
  }

  @Override
  public boolean equals(Object outroObjeto) {
    if (this == outroObjeto)
      return true;
    if (null == outroObjeto)
      return false;
    if (outroObjeto instanceof Data) {
      Data outraData = (Data) outroObjeto;
      if (this.dia == outraData.dia && this.mes == outraData.mes && this.ano == outraData.ano)
        return true;
    }
    return false;
  }

  @Override
  public int compareTo(Data outroObjeto) {
    if (this.ano > outroObjeto.ano) {
      return 1;
    } else if (this.ano < outroObjeto.ano) {
      return -1;
    } else if (this.ano > outroObjeto.ano && this.mes > outroObjeto.mes) {
      return 1;
    } else if (this.ano < outroObjeto.ano && this.mes < outroObjeto.mes) {
      return -1;
    } else if (this.dia > outroObjeto.dia) {
      return 1;
    } else if (this.dia < outroObjeto.dia) {
      return -1;
    }
    return 0;
  }
}
