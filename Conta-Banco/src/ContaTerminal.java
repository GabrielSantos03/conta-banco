import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {
        // Configurar o Scanner para usar o Locale US (ponto como separador decimal)
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        // Recebimento de dados do usuário
        int numero = solicitarNumeroConta(scanner);
        String agencia = solicitarAgencia(scanner);
        String nomeCliente = solicitarNomeCliente(scanner);
        double saldo = solicitarSaldo(scanner);

        // Exibir mensagem final formatada
        exibirMensagemFinal(nomeCliente, agencia, numero, saldo);

        scanner.close();
    }

    private static int solicitarNumeroConta(Scanner scanner) {
        int numero = 0;
        boolean entradaValida = false;
        do {
            try {
                System.out.println("Por favor, digite o número da Conta:");
                numero = scanner.nextInt();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, insira um número válido.");
                scanner.next(); // Limpa a entrada inválida
            }
        } while (!entradaValida);
        return numero;
    }

    private static String solicitarAgencia(Scanner scanner) {
        System.out.println("Por favor, digite o número da Agência:");
        return scanner.next();
    }

    private static String solicitarNomeCliente(Scanner scanner) {
        System.out.println("Por favor, digite o seu Nome:");
        scanner.nextLine(); // Consumir quebra de linha pendente
        return scanner.nextLine();
    }

    private static double solicitarSaldo(Scanner scanner) {
        double saldo = 0.0;
        boolean entradaValida = false;
        do {
            try {
                System.out.println("Por favor, digite o Saldo (use ponto para separação decimal):");
                saldo = scanner.nextDouble();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, insira um valor decimal válido (use ponto como separador).");
                scanner.next(); // Limpa a entrada inválida
            }
        } while (!entradaValida);
        return saldo;
    }

    private static void exibirMensagemFinal(String nomeCliente, String agencia, int numero, double saldo) {
        String mensagem = String.format(
            "Olá %s, obrigado por criar uma conta em nosso banco. Sua agência é %s, conta %d, e seu saldo %.2f já está disponível para saque.",
            nomeCliente, agencia, numero, saldo
        );
        System.out.println(mensagem);
    }

    @Override
    public String toString() {
        return "ContaTerminal []";
    }
}

