package pack.predescu.entities;

import pack.predescu.Salariu;

import java.io.Serializable;

public class Vanzator extends Angajat implements Salariu, Serializable{

    private int nrVanzari;
    protected static int nrVanzatori=0;
    public Vanzator(String nume, int varsta, int vechime, int nrVanzari, int contract){
        super(nume, varsta, vechime, contract);
        this.nrVanzari = nrVanzari;
        nrVanzatori++;
    }

    public Vanzator() {
        super();
    }

    public int getNrVanzari() {
        return nrVanzari;
    }

    @Override
    public void descreireJob()
    {
        System.out.println(this.getNume() + " in varsta de " + this.getVarsta() + " cu vechimea in firma de " + this.getVechime() + " si salariul de "  + this.getSalariu()
                + " mai are " + this.getContract() + " acesta lucreaza ca: " + this.getClass().getSimpleName() + " acesta a facut un numar de: " + this.getNrVanzari() + " vanzari ");
    }


    @Override
    public Integer CalculSalariu() {
        int salariu = nrVanzari * 100 + getVechime() * 10;
        setSalariu(salariu);
        return salariu;
    }

    @Override
    public String toString() {
        return super.toString() + "," + nrVanzari;
    }
}
