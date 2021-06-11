public class Veiculo {
    private String placa;
    private String marca;
    private String proprietario;
    private int pontos;  // de multa

    public Veiculo(){} // Construtor vazio para criação rápida de um objeto do tipo Veículo

    public Veiculo(String placa, String marca, String proprietario, int pontos) {
        this.placa = placa;
        this.marca = marca;
        this.proprietario = proprietario.trim();
        this.pontos = pontos;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    @Override
    public String toString() {
        return "Veiculo {" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", proprietario='" + proprietario + '\'' +
                ", pontos=" + pontos +
                '}';
    }
}
