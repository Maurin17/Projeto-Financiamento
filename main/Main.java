package main;
import util.InterfaceUsuario;
import modelo.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuarioObj = new InterfaceUsuario();
        List<Financiamento> listaDeFinanciamento = new ArrayList<Financiamento>();
        double somarValorImovel = 0.0;
        double somarFinanciamento = 0.0;
        int i = 1;
        int j = 1;
        int s = 1;

        double valorImovelCasa1 = interfaceUsuarioObj.valorImovelInterface();
        int prazoFinanciamentoCasa1 = interfaceUsuarioObj.prazoFinanciamentoInterface();
        double taxaJurosCasa1 = interfaceUsuarioObj.taxaJurosInterface();
        double areaConstruida1 = interfaceUsuarioObj.areaConstruidaInterface();
        double tamanhoTerreno1 = interfaceUsuarioObj.tamanhoTerrenoInterface();


        listaDeFinanciamento.add(new modelo.Casa(valorImovelCasa1,prazoFinanciamentoCasa1,taxaJurosCasa1,areaConstruida1, tamanhoTerreno1));
        listaDeFinanciamento.add(new modelo.Casa(500000,10,0.1,100,150));
        listaDeFinanciamento.add(new modelo.Apartamento(450000,15,0.2,2,3));
        listaDeFinanciamento.add(new modelo.Apartamento(500000,10,0.1, 1,2));
        listaDeFinanciamento.add(new modelo.Terreno(500000,10,0.1,"residencial"));

        // Imprimir informações
        for (Financiamento financiamento : listaDeFinanciamento) {
            somarValorImovel += financiamento.getValorImovel();
            somarFinanciamento += financiamento.calcularPagamentoTotal();
            System.out.println("Financiamento " + i);
            i++;
            financiamento.imprimir();
        }
        System.out.println("=================================");
        System.out.println("Valor total dos imóveis: " + somarValorImovel);
        System.out.println("Valor total dos financiamentos: " + somarFinanciamento);
        System.out.println("=================================");

        //Escrita

        FileWriter escritor = null;

        try{
            escritor = new FileWriter("financiamento.txt");

            for (Financiamento financiamento : listaDeFinanciamento) {
                escritor.write(" Financiamento " + String.valueOf(s));
                s++;
                escritor.write(financiamento.toString());
            }



            escritor.flush();
            escritor.close();
        } catch (FileNotFoundException e){
            System.out.println("O arquivo não foi encontrado");
        } catch (IOException e){
            e.printStackTrace();
        }

        //Leitura
        FileReader leitor = null;

        try{
            leitor = new FileReader("financiamento.txt");
            int caractereLido;
            while((caractereLido = leitor.read()) != -1){
                System.out.print((char)caractereLido);
            }


            leitor.close();
        } catch (FileNotFoundException e){
            System.out.println("O arquivo não foi encontrado");
        } catch (IOException e){
            e.printStackTrace();
        }


        // Serializar

        ObjectOutputStream outputStream = null;

        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("financiamentoserie.data"));

            outputStream.writeObject(listaDeFinanciamento);

            outputStream.flush();
            outputStream.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        // Desserializar

        ObjectInputStream inputStream= null;
        List<Financiamento> listaDesserializada = new ArrayList<Financiamento>();

        try {
            inputStream = new ObjectInputStream(new FileInputStream("financiamentoserie.data"));

            Object objeto = null;

            objeto = inputStream.readObject();

            listaDesserializada = (List<Financiamento>)objeto;

            for (Financiamento financiamento : listaDesserializada) {
                System.out.println("Financiamento " + j);
                j++;
                financiamento.imprimir();
            }


            inputStream.close();
        } catch (EOFException e){
            System.out.println("Fim do arquivo alcançado!");
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
