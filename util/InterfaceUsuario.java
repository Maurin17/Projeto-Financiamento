package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    Scanner sc = new Scanner(System.in);

    // Input para o valor do imóvel
    public double valorImovelInterface(){
        double valor = -1;
        do {
            try {
                System.out.println("Digite o valor do imovel: ");
                valor = sc.nextDouble();
            } catch (InputMismatchException e){
                sc.next();
            }
        }
        while (!validarDadosDouble(valor)); // Loop para validação de dados
        return valor;
    }

    // Input para o prazo do financiamento
    public int prazoFinanciamentoInterface(){
        int prazo = -1;
        do {
            try {
                System.out.println("Digite o prazo do financiamento (em anos): ");
                prazo = sc.nextInt();
            } catch (InputMismatchException e){
                sc.next();
            }
        }
        while (!validarDadosInt(prazo)); // Loop para validação de dados
        return prazo;
    }

    // Input para a taxa de juros
    public double taxaJurosInterface(){
        double taxa = -1;
        do {
            try {
                System.out.println("Digite a taxa de juros: ");
                taxa = sc.nextDouble();
            } catch (InputMismatchException e){
                sc.next();
            }
        }
        while (!validarDadosDouble(taxa)); // Loop para validação de dados
        return taxa;
    }

    public double areaConstruidaInterface(){
        double area = -1;
        do {
            try {
                System.out.println("Digite a área construida: ");
                area = sc.nextDouble();
            } catch (InputMismatchException e){
                sc.next();
            }
        }
        while (!validarDadosDouble(area)); // Loop para validação de dados
        return area;
    }

    public double tamanhoTerrenoInterface(){
        double tamanho = -1;
        do {
            try {
                System.out.println("Digite o tamanho do terreno: ");
                tamanho = sc.nextDouble();
            } catch (InputMismatchException e){
                sc.next();
            }
        }
        while (!validarDadosDouble(tamanho)); // Loop para validação de dados
        return tamanho;
    }

    public boolean validarDadosDouble(double dados){
        if (dados < 0){
            System.out.println("Número inválido!");
            return false;
        }
        return true;
    }

    public boolean validarDadosInt(int dados){
        if (dados < 0){
            System.out.println("Número inválido!");
            return false;
        }
        return true;
    }

}
