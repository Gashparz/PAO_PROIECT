package pack.predescu.entities;


import pack.predescu.Salariu;

public class Mecanic extends Angajat implements Salariu {

    protected static int nrMecanici=0;
    private int nrLucrari;
    public Mecanic(String nume, int varsta, int vechime, int nrLucrari, int contract) {
        super(nume, varsta, vechime, contract);
        this.nrLucrari = nrLucrari;
        nrMecanici++;
    }

    public Mecanic() {

    }

    public int getNrLucrari() {
        return nrLucrari;
    }

    public void setNrLucrari(int nrLucrari) {
        this.nrLucrari = nrLucrari;
    }

    @Override
    public void descreireJob() {
        System.out.println(this.getNume() + " in varsta de " + this.getVarsta() + " cu vechimea in firma de " + this.getVechime() + " si salariul de "  + this.getSalariu()
                + " mai are " + this.getContract() + " acesta lucreaza ca: " + this.getClass().getSimpleName() + " acesta a facut un numar de: " + this.nrLucrari + " vanzari.");
    }

    @Override
    public Integer CalculSalariu()
    {
        int salariu = nrLucrari * 100 + getVechime() * 20 ;
        setSalariu(salariu);
        return salariu;
    }

    @Override
    public String toString() {
        return super.toString() + "," + nrLucrari;
    }
}
