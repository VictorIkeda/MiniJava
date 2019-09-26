package br.com.unifil.analisadorLexico.modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class LeituraArquivo {

    public static void main(String[] args) {
        Scanner entrada;
        Scanner teclado = new Scanner(System.in);
        /*AnalisadorLexicoExemplo analisador = new AnalisadorLexicoExemplo();*/
        AnalisadorLexico2 analisador = new AnalisadorLexico2();

        try {
            System.out.println("Digite o caminho dos diretórios do arquivo .txt: ");
            String arquivo = teclado.nextLine();
            entrada = new Scanner(new BufferedReader(new FileReader(arquivo)));

            System.out.println();

            int linha = 1;
            while (entrada.hasNextLine()) {
                List<String> strings = analisador.converterEmFluxoDeTokens(entrada.nextLine().trim());
                System.out.print(linha + "- ");
                for (int i = 0; i < strings.size(); i++) {
                    System.out.print(strings.get(i));
                }
                linha++;
                System.out.println();
                analisador.limparLista();
            }

//            System.out.println(analisador.getResultado());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
