public class AufgabeB7A1 {

    /**
     * Calculates the n-th number of the fibonacci-sequence and prints it.
     * @Runtime O(n) - n is the parsed integer value of the first string in the argument
     * @param args Command-Line Arguments, expected one non-negative integer in first string
     */
    public static void main(String[] args){
        //TODO: main
        if(args.length != 1){
            System.out.println("Error: Expected command-line argument");
            return;
        }
        int n;
        try {
            n = Integer.parseInt(args[0]);
        }catch(NumberFormatException e){
            System.out.println("Error: Encountered problem parsing commandline-argument, required: number.");
            return;
        }
        if(n < 0){
            System.out.println("Error: Received negative number where non-negative was expected.");
        }
        System.out.println(fibDyn(n));
    }

    /**
     * Calculates the n-th number of the fibonacci-sequence.
     * @Runtime O(n)
     * @param n A non-negative integer
     * @return The value of the n-th number in the fibonacci-sequence
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
