package modelo;


public class Apartamento extends Financiamento {
    private int vagasGaragem;
    private int numAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagasGaragem, int numAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.numAndar = numAndar;
    }

    public double calcularPagamentoTotal(){
        return calcularPagamentoMensal() * (prazoFinanciamento * 12);
    }

    public double calcularPagamentoMensal(){
        // return (valorImovel / (prazoFinanciamento * 12)) * (1 + (taxaJurosAnual / 12));
        //return (valorImovel * Math.pow((1 + (taxaJurosAnual / 12)), prazoFinanciamento * 12))/Math.pow((1 + (taxaJurosAnual / 12)), (taxaJurosAnual / 12) - 1);
        return (valorImovel * (taxaJurosAnual / 12)) / (1 - Math.pow(1 + (taxaJurosAnual / 12), -(prazoFinanciamento * 12)));
    }

    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append("\n" + "***********************************" + "\n" + "\n" );
        sb.append("Valor do imóvel: " + valorImovel + "\n");
        sb.append("Prazo do financiamento: " + prazoFinanciamento + "\n");
        sb.append("Taxa de juros anual: " + taxaJurosAnual + "\n");
        sb.append("Vagas de garagem: " + vagasGaragem + "\n");
        sb.append("Numero do andar: " + numAndar + "\n");
        sb.append("Pagamento mensal: " + calcularPagamentoMensal() + "\n");
        sb.append("Pagamento total: " + calcularPagamentoTotal() + "\n");
        sb.append("\n" + "***********************************" + "\n" + "\n");
        return sb.toString();
    }

}
