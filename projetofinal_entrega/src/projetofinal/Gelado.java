package projetofinal;


public class Gelado extends Produto{
    protected String sabor;
    protected String tipo; //caixa ou individual

    public Gelado(String sabor, String tipo, String nome, float preco, int quant, String fornecedor) {
        super(nome, preco, quant, fornecedor);
        this.sabor = sabor;
        this.tipo = tipo;
    }

    public Gelado() {
        this("", "", "", 0, 0, "");
    }

    public String getSabor() {
        return sabor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public int getQuant() {
        return quant;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
    
    
}