# Sistema de Controle de Impressora Elgin

## Sobre o Projeto
Sistema desenvolvido por quatro alunos para a disciplina de Programação Orientada a Objetos. Permite a comunicação entre Java e impressoras térmicas Elgin por meio da DLL E1_Impressora01 e da biblioteca JNA.

## Tecnologias Utilizadas
- **Java:** Oracle OpenJDK 27.0.1.
- **IntelliJ IDEA:** ambiente de desenvolvimento.
- **JNA:** versão 5.15.0.
- **DLL Elgin:** E1_Impressora01.
- **Impressora:** modelo a confirmar nos testes presenciais.

## Estrutura do Projeto
- `Main.java` – Inicialização e menu principal.
- `Usuario.java` – Cadastro e validação de login.
- `Impressora.java` – Configurações e operações de impressão.
- `ImpressoraDLL.java` – Comunicação com a DLL.
- `Bibliotecas E1 Impressora/` – DLLs para x64 e x86.
- `libs Java/` – Biblioteca JNA.
- `CANC_SAT.xml` e `XMLSAT.xml` – Arquivos para testes SAT.
- `README.md` – Documentação do projeto.

## Instalação e Execução
1. Baixe o projeto pelo GitHub em **Code → Download ZIP**.
2. Extraia os arquivos.
3. Abra a pasta do projeto no IntelliJ IDEA.
4. Adicione `jna-5.15.0.jar` às bibliotecas do projeto.
5. Verifique a localização das DLLs da Elgin.
6. Abra `Main.java` e execute o programa.

## Funcionalidades
O sistema possui cadastro e login de usuários, com limite de três tentativas de acesso, além das seguintes operações:

| Opção | Funcionalidade |
|---|---|
| 1 | Configurar impressora |
| 2 | Abrir conexão |
| 3 | Fechar conexão |
| 4 | Imprimir textos |
| 5 | Imprimir QR Codes |
| 6 | Imprimir códigos de barras |
| 7 | Imprimir XML SAT |
| 8 | Imprimir cancelamento SAT |
| 9 | Abrir gaveta |
| 10 | Emitir sinal sonoro |
| 0 | Encerrar programa |

## Testes
Foram realizados testes de cadastro, login, bloqueio após três tentativas, funcionamento do menu, tratamento de entradas inválidas e encerramento.

**Pendente:** testes com a impressora física, incluindo conexão, impressão, gaveta e sinal sonoro.

## Documentação
- Roteiro disponibilizado pelo professor.
- Documentação oficial do SDK E1_Impressora da Elgin.

## Autores
- Igor dos Reis
- Guilherme Borges de Oliveira
- Gustavo Martins
- Rodolfo Soares Teizen
