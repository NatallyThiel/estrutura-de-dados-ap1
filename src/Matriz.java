import java.util.Random;
import java.util.Scanner;

public class Matriz {
    private int[][] dados; //valores da matriz
    private int linhas;
    private int colunas;

    public Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.dados = new int[linhas][colunas];//criado a mtriz com as dimensões
    }

  //preenchendo manualmente
  
public void preencherManual(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Preenchendo manualmente a Matriz: ");
    for (int i = 0; i < linhas; i++) {
        for (int j = 0; j < colunas; j++) {
            System.out.printf("Elemento [%d][%d]: ", i, j);
            dados[i][j] = sc.nextInt();
        }
    }
}



    //preencher aut com valor entre 0 a 99

public void preencherAutomatico(){
    Random rand = new Random();
    for(int i = 0; i < linhas; i++) {
        for (int j = 0; j <colunas; j++){
            dados[i][j] = rand.nextInt(100);
        }
    }
} 

//remover elemnto na posição (linha, coluna) substituindo por 0

public void removerElemento(int linha, int coluna){
    if (linha >=0 && linha < linhas && coluna >= 0 && coluna < colunas) {
        dados[linha][coluna] = 0;
    } else {
        System.out.println("Posição Inválida para remoção");
    }
}

//matriz em formato tabular

public void exibir(){
    System.out.println("Matriz:");
    for (int i = 0; i < linhas; i++) {
        for (int j = 0; j < colunas; j++){
            System.out.printf("%4d", dados[i][j]);
        }
    }

}
 // getters pra linhas, colunas e dados

 public int getLinhas() {
        return linhas;
    }
    public int getColunas() {
        return colunas;
    }
    public int[][] getDados() {
        return dados;
    }

    //setando dados 

public void setDados(int[][] novosDados) {
        if (novosDados.length == linhas && novosDados[0].length == colunas) {
            this.dados = novosDados;
        } else {
            System.out.println("Dimensões incompatíveis para setDados.");
        }
}
}  



