package models;

public class Veterinario {
    private int id;
    private int crmv;

    public Veterinario(){
    }

    public Veterinario(int id,int crmv) {
        this.id = id;
        this.crmv = crmv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCrmv() {
        return crmv;
    }

    public void setCrmv(int crmv) {
        this.crmv = crmv;
    }
}

