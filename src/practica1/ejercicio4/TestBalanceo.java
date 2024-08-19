package practica1.ejercicio4;

public class TestBalanceo {
    public static void main(String[] args) {
        String s1 = "(T)";        // Balanceado
        String s2 = "[T]";        // Balanceado
        String s3 = "{T}";        // Balanceado
        String s4 = "{(T)]";      // Desbalanceado

        System.out.println(estaBalanceado(s1)); // true
        System.out.println(estaBalanceado(s2)); // true
        System.out.println(estaBalanceado(s3)); // true
        System.out.println(estaBalanceado(s4)); // false
    }

    public static boolean estaBalanceado(String s) {
        PilaGenerica<Character> pila = new PilaGenerica<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                pila.apilar(c); // Apilar si es un carácter de apertura
            } else if (c == ')' || c == ']' || c == '}') {
                if (pila.esVacia()) {
                    return false; // Si la pila está vacía, no puede haber un cierre
                }
                char tope = pila.desapilar();
                if (!coinciden(tope, c)) {
                    return false; // Si no coinciden, no está balanceado
                }
            }
        }

        return pila.esVacia(); // Si la pila está vacía al final, está balanceado
    }

    public static boolean coinciden(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
}
