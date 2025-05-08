package modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    // Atributos
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    // Getters
    public double getValorImovel(){
        return valorImovel;
    }

    public int getPrazoFinanciamento(){
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual(){
        return taxaJurosAnual;
    }

    // Construtor
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // Pagamento mensal
    public double calcularPagamentoMensal(){
         return (valorImovel / (prazoFinanciamento * 12)) * (1 + (taxaJurosAnual / 12));
    }

    // Pagamento total
    public abstract double calcularPagamentoTotal();

    // Imprimir informações na tela
    public void imprimir(){
        System.out.println("=================================");
        System.out.println("Valor do imóvel: " + valorImovel);
        System.out.println("Pagamento Mensal: " + calcularPagamentoMensal());
        System.out.println("Pagamento Total: " + calcularPagamentoTotal());
        System.out.println("=================================");
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Valor do imóvel: " + valorImovel + "\n");
        sb.append("Prazo do financiamento: " + prazoFinanciamento + "\n");
        sb.append("Taxa de juros anual: " + taxaJurosAnual + "\n");
        sb.append("Pagamento mensal: " + calcularPagamentoMensal() + "\n");
        sb.append("Pagamento total: " + calcularPagamentoTotal() + "\n");
        return sb.toString();
    }

}
