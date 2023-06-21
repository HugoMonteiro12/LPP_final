package projetofinal;


public class Produto {
    protected String nome;
    protected float preco;
    protected int quant;
    protected String fornecedor;
    
    //construtor com parâmetros
    public Produto(String nome, float preco, int quant, String fornecedor) {
        this.nome = nome;
        this.preco = preco;
        this.quant = quant;
        this.fornecedor = fornecedor;
    }
    //construtor sem parâmetros
    public Produto() {
        this("", 0, 0, "");
    }

    //métodos de acesso get
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
    
    //métodos de acesso set
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

    //outros métodos
    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", preco=" + preco + ", quant=" + quant + ", fornecedor=" + fornecedor + '}';
    }
    
    //cria clone
    public Produto clone() {
        return new Produto(nome, preco, quant, fornecedor);
    }
    
    public static void equals(Produto f1, Produto f2){
        if (f1.getNome().equals(f2.getNome()) && f1.getPreco() == f2.getPreco() && f1.getQuant() == f2.getQuant()){
            System.out.println("As datas são iguais.");
        }
        else{
            System.out.println("As datas são diferentes.");
        }
    }
    
    public static void print(Produto f1){
        
    }
    
}
