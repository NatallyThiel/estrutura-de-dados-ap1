public class Ordenacao {

// Bubble Sort iterativo
    public static void bubbleSort(int[] vetor) {
        int n = vetor.length;
        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    trocou = true;
                }
            }
            if (!trocou) break; //  para se não teve troca
        }
    }

// Merge Sort recursivo
    public static void mergeSort(int[] vetor) {
        if (vetor.length > 1) {
            int meio = vetor.length / 2;
            int[] esquerda = new int[meio];
            int[] direita = new int[vetor.length - meio];
            System.arraycopy(vetor, 0, esquerda, 0, meio);
            System.arraycopy(vetor, meio, direita, 0, vetor.length - meio);
            mergeSort(esquerda);
            mergeSort(direita);
            merge(vetor, esquerda, direita);
        }
    }

private static void merge(int[] vetor, int[] esquerda, int[] direita) {
        int i = 0, j = 0, k = 0;
        while (i < esquerda.length && j < direita.length) {
            if (esquerda[i] <= direita[j]) {
                vetor[k++] = esquerda[i++];
            } else {
                vetor[k++] = direita[j++];
            }
        }
        while (i < esquerda.length) {
            vetor[k++] = esquerda[i++];
        }
        while (j < direita.length) {
            vetor[k++] = direita[j++];
        }
    }

// ordenar por linhas usando (true = mergeSort, false = bubbleSort)
    public static void ordenarPorLinhas(Matriz matriz, boolean usarMergeSort) {
        int[][] dados = matriz.getDados();
        for (int i = 0; i < matriz.getLinhas(); i++) {
            if (usarMergeSort) {
                mergeSort(dados[i]);
            } else {
                bubbleSort(dados[i]);
            }
        }
    }    


    //colunas
    public static void ordenarPorColunas(Matriz matriz, boolean usarMergeSort) {
        int linhas = matriz.getLinhas();
        int colunas = matriz.getColunas();
        int[][] dados = matriz.getDados();
        for (int j = 0; j < colunas; j++) {
            int[] coluna = new int[linhas];
            for (int i = 0; i < linhas; i++) {
                coluna[i] = dados[i][j];
            }
            if (usarMergeSort) {
                mergeSort(coluna);
            } else {
                bubbleSort(coluna);
            }
            for (int i = 0; i < linhas; i++) {
                dados[i][j] = coluna[i];
            }
        }
    }


    // matriz completa (achatada em vetor)
    public static void ordenarMatrizCompleta(Matriz matriz, boolean usarMergeSort) {
        int linhas = matriz.getLinhas();
        int colunas = matriz.getColunas();
        int[][] dados = matriz.getDados();
        int[] vetor = new int[linhas * colunas];
        int index = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                vetor[index++] = dados[i][j];
            }
        }
        if (usarMergeSort) {
            mergeSort(vetor);
        } else {
            bubbleSort(vetor);
        }
        index = 0;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                dados[i][j] = vetor[index++];
            }
        }
    }
}
