import java.nio.file.Files;
import java.nio.file.Paths;

public class Impressora {
    int tipo = 1;
    String modelo = "i9";
    String conexao = "USB";
    int parametro = 0;
    boolean conexaoAberta = false;

    String assQRCode = "Q5DLkpdRijIRGY6YSSNsTWK1TztHL1vD0V1Jc4spo/CEUqICEb9SFy82ym8EhBRZjbh3btsZhF+sjHqEMR159i4agru9x6KsepK/q0"
            + "E2e5xlU5cv3m1woYfgHyOkWDNcSdMsS6bBh2Bpq6s89yJ9Q6qh/J8YHi306ce9Tqb/drKvN2XdE5noRSS32TAWuaQEVd7u+TrvXlOQ"
            + "sE3fHR1D5f1saUwQLPSdIv01NF6Ny7jZwjCwv1uNDgGZONJdlTJ6p0ccqnZvuE70aHOI09elpjEO6Cd+orI7XHHrFCwhFhAcbalc+Z"
            + "fO5b/+vkyAHS6CYVFCDtYR9Hi5qgdk31v23w==";

    void configurarImpressora() {
        System.out.println("Tipo (1 = USB, 2 = Serial, 3 = Rede, 4 = Bluetooth):");
        tipo = Menu.lerNumero();
        System.out.println("Modelo (i8 ou i9):");
        modelo = Menu.lerTexto();
        System.out.println("Conexao (USB, COM2 ou IP):");
        conexao = Menu.lerTexto();
        System.out.println("Parametro (0 para USB):");
        parametro = Menu.lerNumero();
        System.out.println("Conexao configurada!");
    }

    void abrirConexao() {
        try {
            int retorno = ImpressoraDLL.INSTANCE.AbreConexaoImpressora(tipo, modelo, conexao, parametro);
            if (retorno == 0) {
                conexaoAberta = true;
                System.out.println("Conexao aberta com sucesso!");
            } else {
                System.out.println("Erro ao abrir. Codigo: " + retorno);
            }
        } catch (UnsatisfiedLinkError | NoClassDefFoundError e) {
            System.out.println("Nao foi possivel carregar a DLL: " + e.getMessage());
        }
    }

    void fecharConexao() {
        int retorno = ImpressoraDLL.INSTANCE.FechaConexaoImpressora();
        if (retorno == 0) {
            conexaoAberta = false;
        }
        mostrarResultado(retorno, "Fechar conexao");
    }

    void impressaoTexto() {
        System.out.println("Digite o texto:");
        String texto = Menu.lerTexto();
        System.out.println("Quantas copias?");
        int copias = Menu.lerNumero();

        for (int i = 1; i <= copias; i++) {
            int retorno = ImpressoraDLL.INSTANCE.ImpressaoTexto(texto + "\n", 1, 0, 0);
            if (retorno < 0) {
                System.out.println("Erro ao imprimir texto. Codigo: " + retorno);
                return;
            }
            ImpressoraDLL.INSTANCE.Corte(5);
            System.out.println("Copia " + i + " impressa!");
        }
    }

    void impressaoQRCode() {
        System.out.println("Digite o conteudo do QR Code:");
        String dados = Menu.lerTexto();
        int retorno = ImpressoraDLL.INSTANCE.ImpressaoQRCode(dados, 6, 4);
        mostrarResultado(retorno, "QR Code");
        ImpressoraDLL.INSTANCE.Corte(5);
    }

    void impressaoCodigoBarras() {
        System.out.println("Digite os numeros do codigo de barras:");
        String dados = Menu.lerTexto();
        int retorno = ImpressoraDLL.INSTANCE.ImpressaoCodigoBarras(8, "{A" + dados, 100, 2, 3);
        mostrarResultado(retorno, "Codigo de barras");
        ImpressoraDLL.INSTANCE.Corte(5);
    }

    void imprimirXMLSAT() {
        String xml = lerArquivo("XMLSAT.xml");
        if (xml != null) {
            int retorno = ImpressoraDLL.INSTANCE.ImprimeXMLSAT(xml, 0);
            mostrarResultado(retorno, "XML SAT");
            ImpressoraDLL.INSTANCE.Corte(5);
        }
    }

    void imprimirXMLCancelamento() {
        String xml = lerArquivo("CANC_SAT.xml");
        if (xml != null) {
            int retorno = ImpressoraDLL.INSTANCE.ImprimeXMLCancelamentoSAT(xml, assQRCode, 0);
            mostrarResultado(retorno, "XML de cancelamento");
            ImpressoraDLL.INSTANCE.Corte(5);
        }
    }

    void abrirGaveta() {
        int retorno = ImpressoraDLL.INSTANCE.AbreGaveta(1, 5, 10);
        mostrarResultado(retorno, "Abrir gaveta");
    }

    void sinalSonoro() {
        System.out.println("Quantos bips? (1 a 63)");
        int quantidade = Menu.lerNumero();
        int retorno = ImpressoraDLL.INSTANCE.SinalSonoro(quantidade, 50, 5);
        mostrarResultado(retorno, "Sinal sonoro");
    }

    void avancarPapel() {
        System.out.println("Quantas linhas avancar?");
        int linhas = Menu.lerNumero();
        int retorno = ImpressoraDLL.INSTANCE.AvancaPapel(linhas);
        mostrarResultado(retorno, "Avancar papel");
    }

    void statusPapel() {
        int retorno = ImpressoraDLL.INSTANCE.StatusImpressora(3);
        if (retorno == 5) {
            System.out.println("Tem papel.");
        } else if (retorno == 6) {
            System.out.println("Papel acabando.");
        } else if (retorno == 7) {
            System.out.println("Sem papel.");
        } else {
            System.out.println("Erro ao ver status. Codigo: " + retorno);
        }
    }

    void mostrarResultado(int retorno, String acao) {
        if (retorno == 0) {
            System.out.println(acao + ": sucesso!");
        } else {
            System.out.println(acao + ": erro. Codigo: " + retorno);
        }
    }

    String lerArquivo(String nome) {
        try {
            return new String(Files.readAllBytes(Paths.get(nome)));
        } catch (Exception e) {
            System.out.println("Arquivo nao encontrado: " + nome);
            return null;
        }
    }
}
