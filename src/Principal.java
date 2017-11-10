/*
 * Universidade Federal de Santa Catarina - UFSC
 * Departamento de Informática e Estatística - INE
 * Programa de Pós-Graduação em Ciências da Computação - PROPG
 * Disciplinas: Projeto e Análise de Algoritmos
 * Prof Alexandre Gonçalves da Silva 
 * Baseado nos slides 93 da aula do dia 25/08/2017 
 * Cálculo de Polinômio - Exemplo 3
 *
 * Dada uma sequência de números reais an, an−1, . . . , a1, a0, e um 
 * número real x, calcular o valor do polinômio 
 *   Pn(x) = a(n)x^(n) + a(n−1)x^(n−1) + . . . + a1x + a0.
 */

/**
 * @author Osmar de Oliveira Braz Junior
 */
public class Principal {

    /**
     * Cálcula o resultado do polinômio recursivamente. Terceira solução
     * indutiva, Hipótese de indução mais reforçada: slides 93
     *
     * @param A Coeficientes A = an, an−1,..., a1, a0
     * @param x Um real x.
     * @return O resultado do cálculo do polinômio
     */
    public static float calcularPolinomio(float[] A, float x) {

        //Tamanho do vetor, quantidade de termos do polinomio
        int n = A.length;
        //Variável de retorno
        float P;

        // Quando restar apenas o último coeficiente, 
        // APENAS RETORNA (não é necessário multiplicar - grau de x = 0)		
        if (n == 1) {
            P = A[0];
        } else {
            // Elimina recursivamente o primeiro coeficiente da matriz 
            // até que reste apenas um
            float[] ALinha = new float[n - 1];
            //Eliminando o último termo do Array (o de menor grau)
            for (int i = 0; i < ALinha.length; i++) {
                ALinha[i] = A[i];
            }
            float PLinha = calcularPolinomio(ALinha, x);
            
            System.out.println("n=" + n + " PLinha=" + PLinha + " A[0]=" + A[0]);
            //Realiza a multiplicação e a soma
            P = x * PLinha + A[n - 1];
        }
        return P;
    }

    public static void main(String args[]) {
        //Vetor dos dados    

        float[] A = {2, 3, 1};
        int x = 2;
        // 2 * x^ + 3 * x + 1 * x

        System.out.println(">>> Cálculo de Polinômio - Exemplo 3 <<<");

        float P = calcularPolinomio(A, x);

        System.out.println("P: " + P);
    }
}
