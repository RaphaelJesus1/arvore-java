public class No {
    Veiculo veiculo;
    No esq, dir;

    public No(Veiculo v) {
        veiculo = v;
        esq = dir = null;
    }

    // Método recursivo para a inserção de novos nós
    public void inserirNo(Veiculo v) {
        // Verifica se o novo veículo tem placa menor ou maior que a atual
        // (Strings são transformadas em números e comparadas duas a duas)
        if(v.getPlaca().compareTo(veiculo.getPlaca()) > 0) { // Placa maior
            if(dir == null) {
                dir = new No(v);
            } else {
                dir.inserirNo(v);
            }
        } else if(v.getPlaca().compareTo(veiculo.getPlaca()) < 0){ // Placa menor
            if(esq == null) {
                esq = new No(v);
            } else {
                esq.inserirNo(v);
            }
        }
        // Se for a mesma placa o sistema não insere o veículo.
    }

    public void inserirNoProprietario(Veiculo v) {
        // Se tiver proprietários com nomes iguais ele também adiciona (como maior)
        if(v.getProprietario().compareToIgnoreCase(veiculo.getProprietario()) >= 0) { // Placa maior
            if(dir == null) {
                dir = new No(v);
            } else {
                dir.inserirNoProprietario(v);
            }
        } else if(v.getProprietario().compareToIgnoreCase(veiculo.getProprietario()) < 0){ // Placa menor
            if(esq == null) {
                esq = new No(v);
            } else {
                esq.inserirNoProprietario(v);
            }
        }
    }

}
