package com.example.yourgames.model;

public class User {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "User{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
