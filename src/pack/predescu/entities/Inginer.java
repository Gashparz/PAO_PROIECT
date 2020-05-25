package pack.predescu.entities;

import pack.predescu.Salariu;

public class Inginer extends Mecanic implements Salariu {

    private int nrSubalterni;
    public Inginer(String nume, int varsta, int vechime, int contract) {
        super(nume, varsta, vechime, 0, contract);
        nrMecanici--;
        this.nrSubalterni = nrMecanici;
    }

    public Inginer() {
        super();
    }

    @Override
    public void descreireJob() {
        System.out.println(this.getNume() + " in varsta de " + this.getVarsta() + " cu vechimea in firma de " + this.getVechime() + " si salariul de "  + this.getSalariu()
                + " mai are " + this.getContract() + " acesta lucreaza ca: " + this.getClass().getSimpleName() + " si are un numar de: " + this.nrSubalterni + " subalterni");
    }

    @Override
    public Integer CalculSalariu() {
        int salariu = 3000 + (nrSubalterni * 280) ;
        setSalariu(salariu);
        return salariu;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
