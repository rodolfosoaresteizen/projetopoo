Sistema de Controle de Impressora Elgin
Sobre o Projeto
Este projeto foi desenvolvido por quatro alunos como atividade da disciplina de Programação Orientada a Objetos. O sistema permite realizar a comunicação entre Java e uma impressora térmica Elgin utilizando a biblioteca E1_Impressora01.dll, com auxílio da biblioteca JNA. Possui cadastro e login de usuários, configuração de conexão e diferentes operações de impressão por meio de um menu interativo.

Tecnologias Utilizadas
Java: Oracle OpenJDK 27.0.1.
IntelliJ IDEA: ambiente de desenvolvimento.
JNA 5.15.0: biblioteca utilizada para comunicação entre Java e a DLL.
DLL E1_Impressora01: SDK de comunicação da Elgin.
Impressora Elgin: modelo a confirmar durante os testes presenciais.
Estrutura do Projeto
O projeto está organizado da seguinte maneira:

src/ – Pasta que contém os códigos-fonte do sistema.

Main.java – Inicializa o programa, realiza o acesso ao menu e controla suas opções.
Usuario.java – Responsável pelo cadastro e pela validação do login dos usuários.
Impressora.java – Armazena as configurações da impressora e executa os comandos de impressão.
ImpressoraDLL.java – Interface responsável pela comunicação entre Java e a DLL da Elgin.
Bibliotecas E1 Impressora/ – Contém as bibliotecas DLL da Elgin, separadas em versões para sistemas de 64 bits (x64) e 32 bits (x86).

libs Java/ – Contém o arquivo jna-5.15.0.jar, utilizado para permitir a comunicação entre Java e a DLL.

CANC_SAT.xml – Arquivo XML utilizado nos testes de impressão de cancelamento SAT.

XMLSAT.xml – Arquivo XML utilizado nos testes de impressão SAT.

.gitignore – Arquivo que define quais pastas e arquivos devem ser ignorados pelo Git.

README_MODELO.md – Modelo de documentação disponibilizado pelo professor.

README.md – Arquivo que apresenta as informações, funcionalidades e instruções de execução do projeto.

Instalação e Execução
1. Baixar o projeto
Acesse o repositório do projeto no GitHub.
Clique em Code → Download ZIP.
Extraia o arquivo baixado em uma pasta do computador.
2. Abrir no IntelliJ IDEA
Acesse File → Open e selecione a pasta extraída.
Em File → Project Structure → Libraries, confirme se o arquivo jna-5.15.0.jar está adicionado ao projeto.
Verifique se as pastas da DLL da Elgin estão na estrutura correta.
Conecte e ligue a impressora.
Abra o arquivo Main.java e clique em Run para executar o programa.
Login
Ao iniciar o programa, o usuário deverá realizar um cadastro informando um nome de usuário e uma senha. Em seguida, deverá utilizar os dados cadastrados para acessar o sistema. São permitidas até três tentativas de login. Caso todas sejam incorretas, o acesso será bloqueado e o programa será encerrado. Caso os dados estejam corretos, o usuário terá acesso ao menu principal.

Funcionalidades do Menu
Opção	O que faz
1	Configura a conexão com a impressora, informando o tipo, modelo, conexão e parâmetro.
2	Abre a conexão com a impressora.
3	Fecha a conexão com a impressora.
4	Envia textos para impressão.
5	Envia QR Codes para impressão.
6	Envia códigos de barras para impressão.
7	Realiza a impressão de arquivos XML SAT.
8	Realiza a impressão de arquivos XML de cancelamento SAT.
9	Envia o comando para abrir a gaveta.
10	Executa um sinal sonoro na impressora.
0	Encerra o programa.
🧪 Testes Realizados
Foram realizados testes iniciais para verificar o funcionamento do sistema, incluindo:

Cadastro de usuário.
Login com informações corretas.
Login com informações incorretas.
Bloqueio após três tentativas de login.
Exibição e funcionamento do menu principal.
Tratamento de opções inválidas.
Tratamento de entradas não numéricas no menu.
Encerramento do programa pela opção 0.
Os testes de comunicação com a impressora física ainda não foram realizados. Portanto, permanecem pendentes os testes de conexão, impressão de textos, QR Codes, códigos de barras, XML SAT, XML de cancelamento SAT, abertura da gaveta e sinal sonoro.

Documentação Adicional
Roteiro do trabalho fornecido pelo professor.
Documentação do SDK E1_Impressora, disponibilizada pela Elgin.

Autores
Igor dos Reis
Guilherme Borges de Oliveira
Gustavo Martins
Rodolfo Soares Teizen
