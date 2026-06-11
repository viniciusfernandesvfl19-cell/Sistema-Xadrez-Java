Sistema de Xadrez em Java ♟️
Sobre o Projeto
Este projeto é uma implementação de um Sistema de Xadrez desenvolvido em Java. O objetivo principal deste sistema não foi apenas criar um jogo funcional, mas servir como um projeto de estudo de lógica de programação e aplicação dos conceitos fundamentais de Programação Orientada a Objetos (POO).

Através deste desenvolvimento, foi possível exercitar a manipulação de matrizes, a criação de interfaces, o uso de coleções (Collections), tratamento de exceções customizadas e a lógica de movimentação de peças complexas (como roque, en passant e promoção de peão).

Objetivos de Aprendizado
Este projeto foi fundamental para solidificar conhecimentos em:

POO: Encapsulamento, herança, polimorfismo e abstração.

Estrutura de Dados: Uso de matrizes bidimensionais para representar o tabuleiro.

Lógica de Algoritmos: Implementação de regras de jogo, detecção de xeque e xeque-mate.

Java APIs: Uso intensivo de Streams para processamento de coleções e filtros.

Tratamento de Exceções: Criação de classes de exceção personalizadas para validar jogadas inválidas.

Funcionalidades Implementadas
Movimentação completa de todas as peças (Peão, Torre, Cavalo, Bispo, Rainha e Rei).

Detecção de estado de Xeque e Xeque-mate.

Movimentos especiais:

Roque (Kingside e Queenside).

En Passant.

Promoção de Peão.

Sistema de turnos com alternância automática entre Branco e Preto.

Interface em linha de comando (CLI) intuitiva para visualização do tabuleiro.

Registro e exibição de peças capturadas.

Como rodar o projeto
Certifique-se de ter o JDK (Java Development Kit) instalado em sua máquina.

Clone este repositório para sua pasta local.

Importe o projeto em sua IDE preferida (IntelliJ IDEA, Eclipse, VS Code).

Execute a classe application.Program para iniciar a partida no console.

Desafios do Desenvolvimento
O maior desafio deste projeto foi gerenciar a complexidade das regras de movimento, garantindo que o Rei nunca ficasse em xeque após um movimento (undoMove e testCheckMate). Compreender como a matriz de posições interage com as listas de peças foi um exercício rigoroso de lógica que, embora complexo, proporcionou uma visão muito mais clara sobre como o software "pensa".

Considerações Finais
Este é um projeto de aprendizado contínuo. Embora funcional, o código é uma excelente base para futuras implementações, como uma interface gráfica (GUI) ou a integração com uma biblioteca de IA para jogar contra o computador.
