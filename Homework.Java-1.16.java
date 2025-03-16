import java.util.Scanner;

class NoSolutionException extends Exception {
    public NoSolutionException(String message) {
        super(message);
    }
}


class EquationSolver {
    
    public void solve(double a, double b) throws NoSolutionException {

        if (a != 0) {
            double x = -b / a;
            System.out.println("Solutia ecuatiei este: x = " + x);
        }
        else if (b == 0) {
            System.out.println("Ecuatia are o infinitate de solutii.");
        }
        else {
            throw new NoSolutionException("Ecuatia nu are solutie.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EquationSolver solver = new EquationSolver();

        System.out.println("REZOLVAREA ECUATIEI ax + b = 0");
        double a, b;
        
        try {
            System.out.print("a = ");
            a = scanner.nextDouble();
            
            System.out.print("b = ");
            b = scanner.nextDouble();
            

            solver.solve(a, b);
        } catch (Exception e) {
            System.out.println("Eroare: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
