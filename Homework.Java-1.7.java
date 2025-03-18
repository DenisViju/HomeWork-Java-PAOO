import java.util.ArrayList;
import java.util.List;

class Adresa {
    private String strada;
    private String oras;
    private String codPostal;

    public Adresa(String strada, String oras, String codPostal) {
        this.strada = strada;
        this.oras = oras;
        this.codPostal = codPostal;
    }

    public String getStrada() {
        return strada;
    }

    public String getOras() {
        return oras;
    }

    public String getCodPostal() {
        return codPostal;
    }

    @Override
    public String toString() {
        return "Strada: " + strada + ", Oras: " + oras + ", Cod Postal: " + codPostal;
    }
}

class Persoana {
    private String nume;
    private int varsta;

    public Persoana(String nume, int varsta) {
        this.nume = nume;
        this.varsta = varsta;
    }

    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        return varsta;
    }
}

class Angajat extends Persoana {
    private Companie companie;

    public Angajat(String nume, int varsta, Companie companie) {
        super(nume, varsta);
        this.companie = companie;
    }

    public Companie getCompanie() {
        return companie;
    }

    public void mutaAngajat(Companie nouaCompanie) {
        this.companie = nouaCompanie;
    }
}


class Companie {
    private String nume;
    private Adresa adresa;
    private List<Angajat> angajati;

    public Companie(String nume, Adresa adresa) {
        this.nume = nume;
        this.adresa = adresa;
        this.angajati = new ArrayList<>();
    }

    public void addAngajat(Angajat angajat) {
        angajati.add(angajat);
    }

    public void afiseazaAdreseAngajati() {
        for (Angajat angajat : angajati) {
            System.out.println(angajat.getCompanie().adresa);
        }
    }

    public List<Angajat> getAngajati() {
        return angajati;
    }

    public String getNume() {
        return nume;
    }

    public static Companie cautaCompanie(List<Companie> companii, String numeCompanie) {
        for (Companie companie : companii) {
            if (companie.getNume().equalsIgnoreCase(numeCompanie)) {
                return companie;
            }
        }
        return null;
    }
}




public class Main {
    public static void main(String[] args) {
        
        Adresa adresa1 = new Adresa("Strada A", "Oras A", "12345");
        Adresa adresa2 = new Adresa("Strada B", "Oras B", "54321");

        
        Companie companie1 = new Companie("Compania 1", adresa1);
        Companie companie2 = new Companie("Compania 2", adresa2);

        
        Angajat angajat1 = new Angajat("Bildea Andrei", 30, companie1);
        Angajat angajat2 = new Angajat("Denis Viju", 28, companie1);
        Angajat angajat3 = new Angajat("Rijnita Adriana", 35, companie2);

        
        companie1.addAngajat(angajat1);
        companie1.addAngajat(angajat2);
        companie2.addAngajat(angajat3);

        
        angajat1.mutaAngajat(companie2);

     
        System.out.println("Angajatii din Compania 2:");
        companie2.afiseazaAdreseAngajati();

        
        List<Companie> companii = new ArrayList<>();
        companii.add(companie1);
        companii.add(companie2);
        
        Companie cautata = Companie.cautaCompanie(companii, "Compania 1");
        if (cautata != null) {
            System.out.println("Compania gasita: " + cautata.getNume());
        } else {
            System.out.println("Compania nu a fost găsita.");
        }
    }
}



