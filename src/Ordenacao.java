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




}
