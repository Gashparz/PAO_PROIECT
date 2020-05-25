package pack.predescu.entities;

import pack.predescu.Salariu;

public class Director_Vanzari extends Vanzator implements Salariu {

    private int nrSubalterni;
    public Director_Vanzari(String nume, int varsta, int vechime, int contract)
    {
        super(nume, varsta, vechime, 0, contract);
        nrVanzatori--;
        this.nrSubalterni = nrVanzatori;
    }

    @Override
    public void descreireJob()
    {
        System.out.println(this.getNume() + " in varsta de " + this.getVarsta() + " cu vechimea in firma de " + this.getVechime() + " si salariul de "  + this.getSalariu()
        + " mai are " + this.getContract() + " acesta lucreaza ca: " + this.getClass().getSimpleName() + " si are un numar de: " + this.nrSubalterni + " subalterni");
    }

    @Override
    public Integer CalculSalariu() {
        int salariu = 2000 + (nrSubalterni * 200);
        setSalariu(salariu);
        return salariu;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
