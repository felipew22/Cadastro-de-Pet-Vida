package models;

public class Animal {
    private int id;
    private String nome_pet;
    private String porte;
    private Double peso;
    private char sexo;
    private String especie;
    private int idade;
    private Tutor animal_tutor;

    public Animal(){
    }

    public Animal(int id ,String nome_pet, String porte, Double peso, char sexo, String especie, int idade, Tutor animal_tutor) {
       this.id = id;
        this.nome_pet = nome_pet;
        this.porte = porte;
        this.peso = peso;
        this.sexo = sexo;
        this.especie = especie;
        this.idade = idade;
        this.animal_tutor = animal_tutor;
    }

    public String getNome_pet() {
        return nome_pet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome_pet(String nome_pet) {
        this.nome_pet = nome_pet;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Tutor getAnimal_tutor() {
        return animal_tutor;
    }

    public void setAnimal_tutor(Tutor animal_tutor) {
        this.animal_tutor = animal_tutor;
    }
}
