package com.example.myapplication;

/*        Entidade
       Responsável por 'mapear' uma tabela,
       Um tipo de modelo!!!
           S2
     */

public class Usuario
{

    //Atributos
    private String nome;
    private String endereco;
    private String cpf;
    private String cargo;

    //Método Construtor I
    public Usuario()
    {

    }

    //Método Construtor II
    public Usuario(String nome, String endereco, String cpf, String cargo)
    {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.cargo = cargo;
    }

    //Getter & Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    //ToString
    @Override
    public String toString() {
        return   nome + '\'' +
                 endereco + '\'' +
                 cpf + '\'' +
                 cargo + '\'' ;
    }
}
