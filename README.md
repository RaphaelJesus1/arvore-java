# arvore-java   <img align="right" src="https://img.shields.io/badge/Java-orange?style=for-the-badge&logo=java">
Pequeno sistema de cadastro de veículos em java. O intuito do projeto é praticar a implementação de árvores binárias. :evergreen_tree:

## Tema
O sistema foi baseado em um exercício que exemplifica a necessidade do <b>DETRAN</b> (Departamento Estadual de Trânsito) em armazenar seus dados em uma estrutura
de dados eficiente para busca. Para esse problema, a solução escolhida foi utilizar árvores binárias. 

As classes Árvore e Nó utilizam o método compareTo(), nativo da linguagem, para organizar os objetos em ordem alfabética. Os veículos são armazenados em nós. Cada nó
possui sua informação - no caso desse projeto um veículo - e dois Nós filhos. Para cada Árvore existe um nó raiz. Os elementos são inseridos através do método de
inserir dentro da classe Nó. Pelas regras de negócio, os elementos são ordenados pela placa do veículo.

## Interface
Ao executar o programa, é possível realizar as seguintes operações:
- Cadastrar um novo veículo no sistema;
- Pesquisar veículo por placa;
- Atualizar pontuação referente a multas atreladas ao veículo;
- Listar todos os veículos ordenados pela placa.
- Listar todos os veículos ordenados pelo nome do proprietário.
