package modelo;

import util.AcrescimoMaiorDoQueJurosException;

public class Casa extends Financiamento {
    private double areaConstruida;
    private double tamanhoTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    private void validarAcrescimo(double valorJuros, double valorAcrescimo) throws AcrescimoMaiorDoQueJurosException{
        if (valorJuros < valorAcrescimo) {
            throw new AcrescimoMaiorDoQueJurosException("O acréscimo é maior do que o juros");
        }
    }

    public double calcularPagamentoTotal(){
        return calcularPagamentoMensal() * (prazoFinanciamento * 12);
    }

    public double calcularPagamentoMensal(){

        double valorAcrescimo = 80;
        try {
            validarAcrescimo(valorImovel, valorAcrescimo);
        }catch (AcrescimoMaiorDoQueJurosException e){
            valorAcrescimo = valorImovel;
        }
        return super.calcularPagamentoMensal() + valorAcrescimo;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n" + "***********************************" + "\n" + "\n" );
        sb.append("Valor do imóvel: " + valorImovel + "\n");
        sb.append("Prazo do financiamento: " + prazoFinanciamento + "\n");
        sb.append("Taxa de juros anual: " + taxaJurosAnual + "\n");
        sb.append("Área Construida: " + areaConstruida + "\n");
        sb.append("Area do terreno: " + tamanhoTerreno + "\n");
        sb.append("Pagamento mensal: " + calcularPagamentoMensal() + "\n");
        sb.append("Pagamento total: " + calcularPagamentoTotal() + "\n");
        sb.append("\n" + "***********************************" + "\n" + "\n");
        return sb.toString();
    }

}
