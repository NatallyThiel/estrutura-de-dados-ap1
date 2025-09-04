import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o número de linhas da matriz: ");
        int linhas = sc.nextInt();
        System.out.print("Digite o número de colunas da matriz: ");
        int colunas = sc.nextInt();

        Matriz matriz = new Matriz(linhas, colunas);

        System.out.println("Escolha o modo de preenchimento:");
        System.out.println("1 - Manual");
        System.out.println("2 - Automático");
        int opcao = sc.nextInt();

        if (opcao == 1) {
            matriz.preencherManual();
        } else {
            matriz.preencherAutomatico();
        }

        System.out.println("\nMatriz original:");
        matriz.exibir();

        System.out.println("\nEscolha o algoritmo de ordenação:");
        System.out.println("1 - Bubble Sort (iterativo)");
        System.out.println("2 - Merge Sort (recursivo)");
        int alg = sc.nextInt();
        boolean usarMergeSort = (alg == 2);

        System.out.println("\nEscolha a forma de ordenação:");
        System.out.println("1 - Por linhas");
        System.out.println("2 - Por colunas");
        System.out.println("3 - Matriz completa");
        int forma = sc.nextInt();

        switch (forma) {
            case 1:
                Ordenacao.ordenarPorLinhas(matriz, usarMergeSort);
                break;
            case 2:
                Ordenacao.ordenarPorColunas(matriz, usarMergeSort);
                break;
            case 3:
                Ordenacao.ordenarMatrizCompleta(matriz, usarMergeSort);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }

        System.out.println("\nMatriz ordenada:");
        matriz.exibir();

        // Exemplo de remoção
        System.out.println("\nDeseja remover algum elemento? (s/n)");
        String resp = sc.next();
        if (resp.equalsIgnoreCase("s")) {
            System.out.print("Digite a linha do elemento a remover: ");
            int l = sc.nextInt();
            System.out.print("Digite a coluna do elemento a remover: ");
            int c = sc.nextInt();
            matriz.removerElemento(l, c);
            System.out.println("Matriz após remoção:");
            matriz.exibir();
        }

        sc.close();
    }
}