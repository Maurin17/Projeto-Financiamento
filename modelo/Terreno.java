package modelo;

public class Terreno extends Financiamento {
    private String tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona){
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    public double calcularPagamentoTotal(){
        return calcularPagamentoMensal() * (prazoFinanciamento * 12);
    }

    public double calcularPagamentoMensal(){
        return super.calcularPagamentoMensal() * 1.02;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n" + "***********************************" + "\n" + "\n");
        sb.append("Valor do imóvel: " + valorImovel + "\n");
        sb.append("Prazo do financiamento: " + prazoFinanciamento + "\n");
        sb.append("Taxa de juros anual: " + taxaJurosAnual + "\n");
        sb.append("Zona: " + tipoZona + "\n");
        sb.append("Pagamento mensal: " + calcularPagamentoMensal() + "\n");
        sb.append("Pagamento total: " + calcularPagamentoTotal() + "\n");
        sb.append("\n" + "***********************************" + "\n" + "\n");
        return sb.toString();
    }

}
