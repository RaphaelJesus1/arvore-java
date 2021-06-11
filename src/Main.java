import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        int opcao = 0;
        boolean rodando = true;

        // Aplicação
        while(rodando) {
            do {
                System.out.println("-------------------------");
                System.out.println(gerarMenu());
                System.out.print("Opção: ");

                // Tratamento de erro para opções não inteiras
                try {
                    opcao = input.nextInt();
                } catch (Exception e) {
                    System.out.println("Opção inválida.");
                }
                input.nextLine(); // Limpar o "\n" que sobrou dentro do scanner
            } while(opcao == 0);

            switch (opcao) {
                // CADASTRAR VEÍCULO
                case 1:
                    cadastrarVeiculo(arvore);
                    break;
                // PESQUISAR
                case 2:
                    pesquisar(arvore);
                    break;
                // MUDAR PONTUAÇÃO
                case 3:
                    mudarPontuacao(arvore);
                    break;
                // IMPRIMIR VEÍCULOS - PLACA
                case 4:
                    imprimirPorPlaca(arvore);
                    break;
                // IMPRIMIR VEÍCULOS - PROPRIETÁRIO
                case 5:
                    imprimirPorProprietario(arvore);
                    break;
                // ENCERRAR PROGRAMA
                case 6:
                    rodando = false;
                    break;
                // OUTRAS OPÇÕES
                default:
                    System.out.println("Opção inválida.");
            }
        }

        input.close();
    }

    public static void imprimirPorProprietario(Arvore arvore) {
        if(!arvore.isEmpty()) {
            // Insere os dados atuais em uma nova árvore ordenados pelo nome do proprietário
            Arvore arvoreProprietario = arvore.geraArvoreProprietario();
            arvoreProprietario.imprimir();
        } else {
            System.out.println("*Não existem registros no sistema*");
        }
    }

    public static void imprimirPorPlaca(Arvore arvore) {
        if(arvore.isEmpty()) {
            System.out.println("*Não existem registros no sistema*");
        } else {
            arvore.imprimir();
        }
    }

    public static void mudarPontuacao(Arvore arvore) {
        if(!arvore.isEmpty()) {
            System.out.println("-- MUDAR PONTUAÇÃO DE VEÍCULO --");
            Veiculo veiculo = pesquisar_aux(arvore);

            if (veiculo == null) {
                System.out.println("*Veículo não encontrado*");
            } else {
                System.out.println("Pontuação atual: " + veiculo.getPontos());
                System.out.print("Nova pontuação: ");
                veiculo.setPontos(input.nextInt());
                System.out.println("Operação efetuada com sucesso!");
            }

        } else {
            System.out.println("*Não existem registros no sistema*");
        }
    }

    private static Veiculo pesquisar_aux(Arvore arvore) {
        String placa;
        System.out.print("Placa: ");
        placa = input.nextLine();

        return arvore.pesquisar(placa);
    }

    public static void pesquisar(Arvore arvore) {
        if(!arvore.isEmpty()) {
            System.out.println("-- PESQUISAR VEÍCULOS --");
            Veiculo resultado = pesquisar_aux(arvore);

            if (resultado == null) {
                System.out.println("*Veículo não encontrado*");
            } else {
                System.out.print("Dados:");
                System.out.println(resultado);
            }
        } else {
            System.out.println("*Não existem registros no sistema*");
        }
    }

    public static void cadastrarVeiculo(Arvore arvore) {
        Veiculo aux = new Veiculo();
        System.out.println("-- CADASTRO DE VEÍCULOS --");
        System.out.print("Placa: ");
        aux.setPlaca(input.nextLine());

        System.out.print("Marca: ");
        aux.setMarca(input.nextLine());

        System.out.print("Nome do proprietário: ");
        aux.setProprietario(input.nextLine());

        System.out.print("Pontos referentes à multa: ");
        aux.setPontos(input.nextInt());

        arvore.inserir(aux);
    }

    public static String gerarMenu() {
        return "DETRAN-SP - VEÍCULOS\n" +
                "1. cadastrar novo veículo\n" +
                "2. pesquisar veículo nos registros\n" +
                "3. atualizar pontos referentes à multa de um veículo\n" +
                "4. imprimir lista de veículos ordenados por placa\n" +
                "5. imprimir lista de veículos ordenados por nome do proprietário\n"+
                "6. finalizar programa";
    }
}
