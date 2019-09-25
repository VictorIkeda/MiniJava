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
        AnalisadorLexicoExemplo analisador = new AnalisadorLexicoExemplo();

        try {
            System.out.println("Digite o caminho dos diretórios do arquivo .txt: ");
            String arquivo = teclado.nextLine();
            entrada = new Scanner(new BufferedReader(new FileReader(arquivo)));

            System.out.println();

            int linha = 1;
            while (entrada.hasNextLine()) {
                List<String> strings = analisador.converterEmFluxoDeTokens(entrada.nextLine().trim(), linha);

                if (strings.size() == 1) {
                    System.out.print(linha + "- " + strings.get(0));
                    System.out.println();
                } else {
                    System.out.print(linha + "- " + strings.get(0) + ", ");
                }

                for (int i = 1; i < strings.size(); i++) {
                    if (i == strings.size()-1) {
                        System.out.println(strings.get(i));
                    } else {
                        System.out.print(strings.get(i) + ", ");
                    }
                }

                analisador.limparLista();
                linha++;
            }

//            System.out.println(analisador.getResultado());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
