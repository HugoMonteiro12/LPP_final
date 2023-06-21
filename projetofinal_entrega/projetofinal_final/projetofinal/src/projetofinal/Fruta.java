package projetofinal;


public class Fruta extends Produto{
    protected int peso;
    protected int tipo_registo; //peso ou pré-estabelecido

    
    
    public Fruta(int peso, int tipo_registo, String nome, float preco, int quant, String fornecedor) {
        super(nome, preco, quant, fornecedor);
        this.peso = peso;
        this.tipo_registo = tipo_registo;
    }

    public Fruta() {
        //super("", 0, 0, "");
        this(0, 0, "", 0, 0, "");
    }

    public int getPeso() {
        return peso;
    }

    public int getTipo_registo() {
        return tipo_registo;
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

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setTipo_registo(int tipo_registo) {
        this.tipo_registo = tipo_registo;
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
