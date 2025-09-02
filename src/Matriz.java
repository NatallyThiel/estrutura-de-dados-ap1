public class Matriz {
    private int[][] dados; //valores da matriz
    private int linhas;
    private int colunas;

    public Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.dados = new int[linhas][colunas];//criado a mtriz com as dimensões
    }
}
