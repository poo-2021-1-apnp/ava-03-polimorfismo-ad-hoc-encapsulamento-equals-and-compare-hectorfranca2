package modelo;

public class Veiculo {
  final String placa, marca, modelo;
  final int cilindrada;

  public Veiculo(String placa, String marca, String modelo, int cilindrada) {
    this.placa = placa;
    this.marca = marca;
    this.modelo = modelo;
    this.cilindrada = cilindrada;
  }

  @Override
  public boolean equals(Object outroObjeto) {
    if (this == outroObjeto)
      return true;
    if (null == outroObjeto)
      return false;
    if (outroObjeto instanceof Veiculo) {
      Veiculo outroVeiculo = (Veiculo) outroObjeto;
      if (this.placa == outroVeiculo.placa)
        return true;
    }
    return false;
  }

}
