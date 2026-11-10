import java.util.Scanner;

public class Menu {
    static Scanner input = new Scanner(System.in);
    Impressora impressora = new Impressora();

    void menuImpresso() {
        System.out.println();
        System.out.println("--Menu--");
        System.out.println("1 - Configurar conexao");
        System.out.println("2 - Abrir conexao");
        System.out.println("3 - Fechar conexao");
        System.out.println("4 - Imprimir texto");
        System.out.println("5 - Imprimir QR Code");
        System.out.println("6 - Imprimir codigo de barras");
        System.out.println("7 - Imprimir XML SAT");
        System.out.println("8 - Imprimir XML de cancelamento SAT");
        System.out.println("9 - Abrir gaveta");
        System.out.println("10 - Sinal sonoro");
        System.out.println("11 - Avancar papel");
        System.out.println("12 - Status do papel");
        System.out.println("0 - Sair");
    }

    void menuImpressora() {
        while (true) {
            menuImpresso();
            System.out.println("Digite a opcao desejada:");
            int opc = lerNumero();

            if (opc == 0) {
                if (impressora.conexaoAberta) {
                    impressora.fecharConexao();
                }
                System.out.println("Saindo...");
                break;
            }

            if (opc >= 3 && opc <= 12 && !impressora.conexaoAberta) {
                System.out.println("Conexão fechada. Abra a conexão antes.");
                continue;
            }

            switch (opc) {
                case 1:
                    impressora.configurarImpressora();
                    break;
                case 2:
                    impressora.abrirConexao();
                    break;
                case 3:
                    impressora.fecharConexao();
                    break;
                case 4:
                    impressora.impressaoTexto();
                    break;
                case 5:
                    impressora.impressaoQRCode();
                    break;
                case 6:
                    impressora.impressaoCodigoBarras();
                    break;
                case 7:
                    impressora.imprimirXMLSAT();
                    break;
                case 8:
                    impressora.imprimirXMLCancelamento();
                    break;
                case 9:
                    impressora.abrirGaveta();
                    break;
                case 10:
                    impressora.sinalSonoro();
                    break;
                case 11:
                    impressora.avancarPapel();
                    break;
                case 12:
                    impressora.statusPapel();
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }

    static int lerNumero() {
        while (true) {
            try {
                return Integer.parseInt(input.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas numeros:");
            }
        }
    }

    static String lerTexto() {
        return input.nextLine();
    }
}