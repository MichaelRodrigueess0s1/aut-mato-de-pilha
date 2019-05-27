# aut-mato-de-pilha
Introdução a Teoria da Computação           Trabalho Prático Implementação de APD
Conteúdo 
 
ITC  3 
 
1. Introdução  
Este trabalho consiste em implementar um simulador de Autômato de Pilha(AP), onde o usuário poderá construir um autômato de pilha e simular seu funcionamento com uma palavra de entrada, A segunda etapa foi implementar dentro do simulador um modelo de APD com as seguintes definições: 
 
Notação: [] Significa 0 ou mais vezes {} Significa 1 ou mais vezes <> Significa “Opcionalmente” “” Um texto constante 
 
 Gramática: 1) Alfabeto = {0,1,2,3,4,5,6,7,8,9, (,), +, -, *, /, a,...,z} 2) Variáveis auxiliares = {expression., constant, operator, digit, function, func1} 3) Variável de partida = expression. 
 
Regras: expression. : : = constant | (expression) | expression. Operator expression. | function constant :: = [digit]<.{digit}> digit ::= 0|1|2|3|4|5|6|7|8|9 function :: = func1(constant) func1 :: = “abs”| “sqrt”| “sen”| “cos”| “tan” operator :: = +|-|/|* 
 
 Definição de APD:   Um APD é um autômato com estados finitos e utiliza uma memória auxiliar em forma de pilha. Autômatos com pilha diferem da definição normal de máquinas de estados finitos de duas maneiras: Eles podem fazer uso da informação que está no topo da pilha para decidir qual transição deve ser efetuada; Eles podem manipular a pilha ao efetuar uma transição. Autômatos com pilha escolhem uma transição analisando o símbolo atual na cadeia de entrada, o estado atual e o topo da pilha. Autômatos com pilha adicionam a pilha como recurso auxiliar, deste modo, dado um símbolo da cadeia de entrada, o estado atual e um símbolo no topo da pilha, uma transição é selecionada. 
 
ITC  4 
1.1 Objetivos O objetivo deste documento é descrever o trabalho, ambiente utilizado para desenvolvimento, linguagem escolhida, manual de utilização do programa, estruturas de dados utilizada, código fonte e testes realizados 
 
2. Ambiente utilizado para desenvolvimento e testes Os recursos necessários para a desenvolvimento do programa, incluem:  Hardware – memória RAM de 2GB, HD com 320 GB, Core I3 2.3GHz,   IDE de desenvolvimento – Netbeans 8.0, JDK 7 e JRE 7  Software de apoio –Notepad++  Linguagem de desenvolvimento – JAVA 3. Estruturas de dados utilizadas: 
As estruturas utilizadas foram as seguintes:  SimpleStack: Pilha para poder armazenar as variáveis que serão empilhadas e desempilhadas  ArrayList: Classe default do JAVA para armazenar Transições e Estados.  Iterator: Estrutura para percorrer listas filas e pilhas.  List:  O alfabeto de entrada e o alfabeto da pilha são armazenados em uma List.  PriorityQueue: Priority Queue é uma fila de execução, foi utilizada para armazenar a palavra de entrada e para facilitar a leitura dos char.  
 
 
4. Código fonte: 
 
O código fonte foi estruturado na linguagem JAVA com conceitos de POO, foi utilizado estruturas de vetores para simular uma matriz dinâmica onde um array de estados guarda os estados criados e dentro de cada estado há um array de transições. As transições são criadas e guardada dentro do estado de origem configurado. 
 

 
A Primeira linha representa o array de estados Q1, Q2, Q3... e as colunas representam o array de transição (T1, T2, T3,...), dentro de cada Estado.  Ao configurar um estado, o primeiro sempre será inicial, e cabe ao usuário definir se este estado será final ou não. Os próximos estados não poderão ser iniciais, e é definido pelo usuário se ele será final ou não.  Para criar as transições, primeiramente deve se definir o alfabeto de entrada e o alfabeto da pilha e criar os respectivos estados de origem e destino.  Os símbolos do alfabeto de entrada poderá ser qualquer símbolo da tabela ASCII menos o símbolo “#” que foi escolhido para representar lambda no alfabeto da pilha. Lembrando que não pode haver símbolos repetidos e não pode haver símbolos do alfabeto da pilha no alfabeto de entrada, e vice e versa, exemplo: 
 
Alfabeto de entrada: a, b. Alfabeto da pilha: x, y, #. Estados: Q1, Q2. 
 
Após definir o alfabeto de entrada e o alfabeto da pilha e criar os estados de origem e destino, pode se configurar a função de transição da seguinte forma: 
 
Símbolo: deve ser um símbolo do alfabeto de entrada. Estado Origem: pode ser qualquer estado criado. Estado Destino: pode ser qualquer estado criado. Desempilha: deve ser um símbolo do alfabeto da pilha. Empilha: deve ser um símbolo do alfabeto da pilha. 
 
Exemplo de configuração de transição: Símbolo: a Estado Origem: Q1 Estado Destino: Q2 Desempilha: # Empilha: x 
 
Após configurar o autômato, o usuário poderá entrar com uma palavra e o programa irá verificar se está é reconhecida no autômato configurado. 
 
 Ao entrar com uma palavra no simulador o teste de reconhecimento acontecerá da seguinte forma: 
 
O simulador primeiramente procurará por um estado final, após achar o estado final ele procurará pelo estado inicial para começar a ler a palavra passada.  Após achar o estado inicial, ele verificará dentro do estado, no array de transições se há alguma transição que contém o símbolo lido pela palavra, se houver ele verifica nesta transição o símbolo de desempilhar e verifica se este símbolo é o topo da pilha ou é 
ITC  6 
lambda, após isso ele empilha o símbolo que tem para empilhar e chama o próximo estado. O mesmo procedimento acontece até o simulador ler a palavra por completo. Após ler a palavra ela será reconhecida se atender os seguintes critérios: 
 
 Parar em um estado final  A pilha estiver vazia  A palavra for lida por completo 
 
Caso um desses três critérios não forem atendidos será apresentada a mensagem “Não reconhecido!” 
 
