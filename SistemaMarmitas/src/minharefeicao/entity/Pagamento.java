package minharefeicao.entity;

public class Pagamento {
    private String dadosCartao;
    
    public void registrarPagamento(String dadosCartao) {
        this.dadosCartao = dadosCartao;
    }
}