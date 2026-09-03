import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fatura {
    static Scanner sc = new Scanner(System.in);
    // lista de compras global para reter os produtos inseridos
    static List<Compras> listaDeCompras = new ArrayList<>();
    static Cadastro cadastro = new Cadastro();

    public static void main(String[] args) {
        boolean isRuning = true;
        int choice;

        System.out.println("Digite seu nome:");
        String clients = sc.nextLine();

        System.out.println("Digite sua renda mensal: ");
        double rend = sc.nextDouble();

        cadastro.setCliente(clients);
        cadastro.setRenda(rend);
        cadastro.calculoLimite(rend);

        while (isRuning) {
            System.out.println("\n===============***================");
            System.out.println("Customer: " + cadastro.getCliente() + " Limite: " + cadastro.getValorlimite());
            System.out.println("==================================");
            System.out.println("     FATURA CARTÃO DE CRÉDITO");
            System.out.println("==================================");
            System.out.println("1. Realizar compras");
            System.out.println("2. Exibir fatura");
            System.out.println("3. Sair");
            System.out.println("==================================");
            System.out.print("Enter your choice (1-3): ");

            choice = sc.nextInt();
            switch (choice) {
                case 1 -> fazerCompras();
                case 2 -> exibirFatura();
                case 3 -> isRuning = false;
                default -> System.out.println("Invalid choice");
            }
        }

        System.out.println("==================================");
        System.out.println(" Thank you for using our program");
        System.out.println("==================================");
        sc.close();
    }

    static void fazerCompras() {
        sc.nextLine(); //Consome a quebra de linha pendente do sc.nextInt() do menu

        System.out.println("Digite o produto:");
        String produto = sc.nextLine();

        System.out.println("Digite o valor da compra:");
        double valor = sc.nextDouble();

        //Verifica se a compra não ultrapassa o limite disponível
        if (valor <= cadastro.getValorlimite()) {
            Compras compra1 = new Compras();
            compra1.setProduto(produto);
            compra1.setValor(valor);

            listaDeCompras.add(compra1);
            cadastro.deduzLimite(valor); // Deduz o valor do limite do cliente
            System.out.println("Compra realizada com sucesso!");
        } else {
            System.out.println("Erro: Limite insuficiente para esta compra.");
        }
    }

    //Implementação visual da lista de compras da fatura
    static void exibirFatura() {
        System.out.println("\n=== EXTRATO DA FATURA ===");
        if (listaDeCompras.isEmpty()) {
            System.out.println("Nenhuma compra realizada.");
        } else {
            double total = 0;
            for (Compras c : listaDeCompras) {
                System.out.println(c);
                total += c.getValor();
            }
            System.out.println("-----------------------");
            System.out.println("Total da Fatura: R$ " + total);
        }
        System.out.println("=======================");
    }
}
