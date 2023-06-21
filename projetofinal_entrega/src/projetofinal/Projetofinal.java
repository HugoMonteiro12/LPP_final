package projetofinal;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//import java.util.List;

public class Projetofinal {


    public static void main(String[] args) throws FileNotFoundException, IOException {

        Scanner ler = new Scanner(System.in);
        String inserir;

        //StringBuilder sb = new StringBuilder();
        String linha;
        String splitBy = ";";
        BufferedReader br = new BufferedReader(new FileReader("dados.csv"));
        List<String[]> dados = new ArrayList<>();


        int cont = 1;
        // Ler os dados do arquivo e armazená-los na lista
        while ((linha = br.readLine()) != null) {
            String[] dataSaved = linha.split(splitBy);
            dados.add(dataSaved);
            System.out.println(cont + ": " + dataSaved[0] + ", " + dataSaved[1] + ", " + dataSaved[2] + ", " + dataSaved[3] + ",  " + dataSaved[4] + ",  " + dataSaved[5] +", " + dataSaved[6]);
            cont++;
        }
        System.out.print("Deseja apagar algum dado? Se sim, insira o índice correspondente: ");
        int indiceApagar = ler.nextInt();
        indiceApagar = indiceApagar - 1;
        if (indiceApagar >= 0 && indiceApagar < dados.size()) {
            // Remover o dado da lista
            dados.remove(indiceApagar);
        } else {
            System.out.println("Erro: Índice inválido");
        }
        Gelado gelado = new Gelado();
        Gelado geladoNovo = new Gelado("chocolate", "caixa", "Magnum", 7, 10, "abcGelado");
        Fruta fruta = new Fruta();
        Fruta frutaNova = new Fruta(1, 0, "Maçã", 7, 10, "abcFruta");

        System.out.print("Inserir o tipo de produto: ");
        inserir = ler.next();
        switch (inserir){
            case "gelado":
                //String sabor, String tipo, String nome, float preco, int quant, String fornecedor
                System.out.print("Introduza o sabor: ");
                String saborGelado = ler.next();
                System.out.print("Introduza o tipo (caixa ou individual): ");
                String tipoGelado = ler.next();
                System.out.print("Introduza o nome/marca: ");
                String nomeGelado = ler.next();
                System.out.print("Introduza o preço: ");
                float precoGelado = ler.nextInt();
                System.out.print("Introduza a quantidade: ");
                int quantGelado = ler.nextInt();
                System.out.print("Introduza o fornecedor: ");
                String fornecedorGelado = ler.next();
                Gelado geladoInserir = new Gelado(saborGelado, tipoGelado, nomeGelado, precoGelado, quantGelado, fornecedorGelado);
                String[] geladoData = {inserir, geladoInserir.getSabor(), geladoInserir.getTipo(), geladoInserir.getNome(), String.valueOf(geladoInserir.getPreco()), String.valueOf(geladoInserir.getQuant()), geladoInserir.getFornecedor()};
                dados.add(geladoData);
                break;
            case "fruta":
                //int peso, boolean tipo_registo, String nome, float preco, int quant, String fornecedor
                System.out.print("Introduza o peso: ");
                int pesoFruta = ler.nextInt();

                int tipoFruta = -1;
                while(tipoFruta == -1){
                    System.out.print("Introduza o tipo (peso[0] ou saco[1]): ");
                    tipoFruta = ler.nextInt();

                    if(tipoFruta != 0 && tipoFruta != 1){
                        tipoFruta = -1;
                    }
                }

                System.out.print("Introduza o nome da fruta: ");
                String nomeFruta = ler.next();
                System.out.print("Introduza o preço: ");
                float precoFruta = ler.nextInt();
                System.out.print("Introduza a quantidade: ");
                int quantFruta = ler.nextInt();
                System.out.print("Introduza o fornecedor: ");
                String fornecedorFruta = ler.next();
                Fruta frutaInserir = new Fruta(pesoFruta, tipoFruta, nomeFruta, precoFruta, quantFruta, fornecedorFruta);
                String[] frutaData = {inserir, String.valueOf(frutaInserir.getPeso()), String.valueOf(frutaInserir.getTipo_registo()), frutaInserir.getNome(), String.valueOf(frutaInserir.getPreco()), String.valueOf(frutaInserir.getQuant()), frutaInserir.getFornecedor()};
                dados.add(frutaData);
                break;
            default:
                System.out.println("Erro no programa: tipo de produto inválido.");
                break;

        }
        System.out.println(Arrays.toString(dados.toArray()));


        try (PrintWriter pw = new PrintWriter(new File("dados.csv"))) {
            for (String[] data : dados) {
                StringBuilder sb = new StringBuilder();
                for (String value : data) {
                    sb.append(value);
                    sb.append(";");
                }
                //sb.append("\n");
                pw.println(sb.toString());
            }
        }

    }

}