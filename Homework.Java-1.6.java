// Homework.Java-1.6. Proiectați diagramele UML si scrieți cod/eventual metode stub pentru Clasele
// Persoană, Adresă, Profesor, Student, Curs și următoarele metode: addStudentToCourse,
// removeStudentFromCourse, addTeacherToCourse, RemoveTeacherFromCourse,
// changeTeacherAddress, ChangeStudentAddress, createNewCourse from list of students and teacher.
import java.util.ArrayList;

class Persoana{
    private String nume;
    private String adresa;
    
    Persoana(String nume, String adresa) {
        this.nume = nume;
        this.adresa = adresa;
    }
    
    String getNume() { return nume; }
    String getAdresa() { return adresa; }
    void setAdresa(String adresaNoua) { adresa = adresaNoua; }
    
}




class Profesor extends Persoana {
    private String materiePredata; 
    
    
    Profesor(String nume, String adresa, String materiePredata) {
        super(nume, adresa);
        this.materiePredata = materiePredata;
        
    }
    
    String getMateriePredata() { return materiePredata; }
    
    
}

class Student extends Persoana {
    private int anStudiu;
    
    Student(String nume, String adresa, int anStudiu) {
        super(nume, adresa);
        this.anStudiu = anStudiu;
    }
    
    int getAnStudiu() { return anStudiu; }
    
}

class Curs {
    ArrayList<Profesor> profesori = new ArrayList<>();
    ArrayList<Student> studenti = new ArrayList<>();
    
    void addStudentToCourse(Student student) {
        studenti.add(student);
    }
    
    void removeStudentFromCourse(Student student) {
        studenti.remove(student);
    }
    
    void addTeacherToCourse(Profesor profesor) {
        profesori.add(profesor);
    }
    
    void removeTeacherFromCourse(Profesor profesor) {
        profesori.remove(profesor);
    }
    
    void afiseazaProfesori() {
        if (profesori.isEmpty()) {
            System.out.println("Nu exista profesori in acest curs.");
        } else {
            System.out.println("Profesori in curs:");
            for (Profesor profesor : profesori) {
                System.out.println("- Nume: " + profesor.getNume() + 
                                   ", Adresa: " + profesor.getAdresa() + 
                                   ", Materie predata: " + profesor.getMateriePredata());
            }
        }
    }
    
    void afiseazaStudenti() {
        if (studenti.isEmpty()) {
            System.out.println("Nu exista studenti in acest curs.");
        } else {
            System.out.println("Studenti in curs:");
            for (Student student : studenti) {
                System.out.println("- Nume: " + student.getNume() + 
                                   ", Adresa: " + student.getAdresa() + 
                                   ", Anul de studiu: " + student.getAnStudiu());
            }
        }
    }
    
    void changeStudentAddress(String numeStudent, String newAddress) {
        for(Student student : studenti) {
            if(student.getNume().equals(numeStudent)) {
                student.setAdresa(newAddress);
                break;
            }
        }
    }
    
    void changeTeacherAddress(String numeProfesor, String newAddress) {
        for(Profesor profesor : profesori) {
            if(profesor.getNume().equals(numeProfesor)) {
                profesor.setAdresa(newAddress);
                break;
            }
        }
    }
    
    
}

public class Main
{
	public static void main(String[] args) {
		
		
		Curs curs = new Curs();
		Student carlos = new Student("Carlos", "carlos.parlos@gmail.com", 2);
		Profesor profesor = new Profesor("Petrache Poenaru", "petrache.tocilaru27@gmail.com", "Matematica");
		
		curs.addStudentToCourse(carlos);
		curs.afiseazaStudenti();
		
		
		
	}
}