package practica1.ejercicio4;

public class TestBalanceo {
    public static void main(String[] args) {
        String s1 = "(T)";
        String s2 = "[T]";
        String s3 = "{T}";
        String s4 = "{(T)]";

        System.out.println(estaBalanceado(s1));
        System.out.println(estaBalanceado(s2));
        System.out.println(estaBalanceado(s3));
        System.out.println(estaBalanceado(s4));
    }

    public static boolean estaBalanceado(String s) {
        PilaGenerica<Character> pila = new PilaGenerica<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                pila.apilar(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (pila.esVacia()) {
                    return false;
                }
                char tope = pila.desapilar();
                if (!coinciden(tope, c)) {
                    return false;
                }
            }
        }

        return pila.esVacia();
    }

    public static boolean coinciden(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
}
