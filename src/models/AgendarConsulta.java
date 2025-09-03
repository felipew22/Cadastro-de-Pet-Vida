package models;


import java.util.Date;

public class AgendarConsulta {
    private Date datahora;
    private int tutor;
    private int veterinario;
    private int animal;
    private int id;

    private String datahorastr;
    private String tutorname;
    private String veterinarioname;
    private String animalname;
    private boolean existe;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }

    public int getTutor() {
        return tutor;
    }

    public void setTutor(int tutor) {
        this.tutor = tutor;
    }

    public int getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(int veterinario) {
        this.veterinario = veterinario;
    }

    public int getAnimal() {
        return animal;
    }

    public void setAnimal(int animal) {
        this.animal = animal;
    }

    public String getDatahorastr() {
        return datahorastr;
    }

    public void setDatahorastr(String datahorastr) {
        this.datahorastr = datahorastr;
    }

    public String getTutorname() {
        return tutorname;
    }

    public void setTutorname(String tutorname) {
        this.tutorname = tutorname;
    }

    public String getVeterinarioname() {
        return veterinarioname;
    }

    public void setVeterinarioname(String veterinarioname) {
        this.veterinarioname = veterinarioname;
    }

    public String getAnimalname() {
        return animalname;
    }

    public void setAnimalname(String animalname) {
        this.animalname = animalname;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }


}
