public class AufgabeB7A1 {
    /**
     * main(string[] args) verarbeitet wie üblich die Eingaben: Eine Zahl n wird eingegeben und die n-te fibonacci-Zahl berechnet und ausgegegen. Fehler und falsche Eingaben
     * werden abgefangen.
     * @param args
     */
    public static void main(String[] args){
        //TODO: main
        if(args.length != 1){
            System.out.println("Error: Expected command-line argument");
            return;
        }
        int k;
        try {
            k = Integer.parseInt(args[0]);
        }catch(NumberFormatException e){
            System.out.println("Error: Encountered problem parsing commandline-argument, required: number");
            return;
        }
        System.out.println(fibDyn(k));
    }

    /**
     * fibDyn(int n) berechnet die n-te fibonaccizahl in O(n) Schritten für eine nicht-negative
     * Ganzzahl n.
     * @param n
     * @return
     */
    public static int fibDyn(int n){
        //TODO: fibDyn
        int[] fibs = new int[3];
        fibs[0] = 0;
        fibs[1] = 1;
        fibs[2] = fibs[0] + fibs[1];
        if(n <= 1){
            return n;
        }
        for(int i = n - 2; i > 0; i--){
            fibs[0] = fibs[1];
            fibs[1] = fibs[2];
            fibs[2] = fibs[0] + fibs[1];
        }
        return fibs[2];
    }
}
