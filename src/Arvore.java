public class Arvore {
    private No raiz;

    // Método para inserir novos veículos por placa
    public void inserir(Veiculo veiculo) {
        if(raiz == null) {
            raiz = new No(veiculo);
        } else {
            raiz.inserirNo(veiculo);
        }
    }

    // Método para inserir novos veículos por proprietario
    public void inserirPorProprietario(Veiculo veiculo) {
        if(raiz == null) {
            raiz = new No(veiculo);
        } else {
            raiz.inserirNoProprietario(veiculo);
        }
    }

    public Veiculo pesquisar(String placa) {
        No resultado;
        Veiculo aux = new Veiculo();
        aux.setPlaca(placa);

        resultado = pesquisar_aux(aux, raiz);

        if(resultado == null) {
            return null;
        }

        return resultado.veiculo;
    }

    // Método recursivo para pesquisar os veículos dentro da árvore
    private static No pesquisar_aux(Veiculo veiculo, No raiz) {
        if(raiz == null) { // ACABOU OS ELEMENTOS DISPONÍVEIS
            return null;
        }
        int comparacao = veiculo.getPlaca().compareTo(raiz.veiculo.getPlaca());

        // comparar o nó atual (raiz) com o veiculo que está sendo procurado
        if(comparacao == 0) { // É IGUAL!
            return raiz;
        } else if(comparacao < 1) { // É MENOR!
            return pesquisar_aux(veiculo, raiz.esq);
        } else { // É MAIOR!
            return pesquisar_aux(veiculo, raiz.dir);
        }
    }

    public void imprimir() {
        imprimirEmOrdem_aux(raiz);
    }

    // Método recursivo para imprimir no vídeo os veículos em ordem
    private void imprimirEmOrdem_aux(No raiz) {
        if(raiz == null) {
            return;
        }

        imprimirEmOrdem_aux(raiz.esq);
        System.out.println(raiz.veiculo.toString());
        imprimirEmOrdem_aux(raiz.dir);
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    public Arvore geraArvoreProprietario() {
        Arvore novaArvore = new Arvore();

        geraArvoreProprietario_aux(raiz, novaArvore);
        return novaArvore;
    }

    private void geraArvoreProprietario_aux(No raiz, Arvore novaArvore) {
        if(raiz == null) {
            return;
        }

        geraArvoreProprietario_aux(raiz.esq, novaArvore);
        novaArvore.inserirPorProprietario(raiz.veiculo);
        geraArvoreProprietario_aux(raiz.dir, novaArvore);
    }
}
