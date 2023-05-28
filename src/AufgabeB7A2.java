import java.util.ArrayList;
import java.util.Scanner;

/**
 * Das Rucksackproblem ist ein bekanntes kombinatorisches Optimierungsproblem. Es geht darum, aus einer gegebenen Menge von Gegenständen eine Teilmenge auszuwählen, die in einen
 * Rucksack passt und dabei den größtmöglichen Gesamtwert hat.
 * Gegeben sei:
 * • n: Anzahl der Gegenstände
 * • C: Kapazität des Rucksacks
 * • w_i: Gewicht des Gegenstands i
 * • v_i: Wert des Gegenstands i
 * Gesucht ist:
 * • Eine Teilmenge S ⊆ {1, . . . , n} der Gegenstände, sodass die folgenden Bedingungen erfüllt sind:
 * SUM_{i∈S} w_i ≤ C (Gewichtsbeschränkung)
 * maximiere SUM_{i ∈ S} v_i (Wertmaximierung)
 * Dabei kann das Problem unterteilt werden in Teilprobleme. T[i][j] repräsentiert den maximalen
 * Gesamtwert, der erreicht werden kann, wenn wir die ersten i Gegenstände betrachten und den
 * Rucksack mit einer Kapazität von j füllen möchten. So kann T wie folgt berechnet werden:
 *              0, wenn i = 0 oder j = 0
 * T[i][j] =    max(werte[i − 1] + T[i − 1][j − gewichte[i − 1]], T[i − 1][j]), wenn gewichte[i − 1] ≤ j
 *              tabelle[i − 1][j] sonst
 */
public class AufgabeB7A2 {

    /**
     * Calculates and prints the optimal solution of the knapsack problem (i.e. the optimal sum of the values). <br>
     * The maximum capacity is the String at the first index of the argument, parsed to an integer. <br>
     * The values are read from the systems' Standard-Input up to an empty line. <br>
     * The weights are read from the systems' Standard-Input after the first empty line. <br>
     * @Runtime O(n * capacity) - n is the number of objects (or number of lines in Standard-In) and capacity is the first string of the argument, parsed to an integer
     * @param args Command-Line arguments, expected: one non-negative integer in first string
     */
    public static void main(String[] args){
        //TODO: main
        int[] weights;
        int[] values;
        int capacity;
        Scanner scanner = new Scanner(System.in);
        try {
            values = getInput(scanner);
            weights = getInput(scanner);
            capacity = Integer.parseInt(args[0]);
        }catch(NumberFormatException e){
            System.out.println("Error: Encountered problem parsing input, required: number");
            return;
        }
        if(scanner.hasNextLine()){
            System.out.println("Error: Input did not end after second list.");
            return;
        }
        if(weights.length != values.length){
            System.out.println("Error: The number of values does not match the number of weights.");
            return;
        }
        if(capacity < 0){
            System.out.println("Error: Capacity received was negative where non-negative was expected.");
        }
        int[][] out = knapsack(values, weights, capacity);
        System.out.println(out[values.length][capacity]);
    }

    /**
     * int[] getInput(Scanner scanner) throws NumberFormatException
     * Liest aus dem Scanner die nächsten zusammenhängenden Zeilen aus Ganzzahlen ein.
     * Sollte bis zu der nächsten Leerzeile oder bis zum Ende des Scanners eine Zeile aus einer
     * Nicht-Ganzzahl bestehen, soll die NumberFormatException weitergereicht werden. Die
     * gelesenen Ganzzahlen sollen als Array zurückgegeben werden.
     * @Runtime O(n) - n is number of lines in the scanners input-stream
     * @param scanner
     * @return
     * @throws NumberFormatException Gets thrown if a line can not be parsed as an integer
     */
    public static int[] getInput(Scanner scanner) throws NumberFormatException{
        //TODO: getInput
        ArrayList<Integer> list = new ArrayList<>();
        try {
            while (scanner.hasNextLine()) {
                String got = scanner.nextLine();
                if(got.equals("")){
                    break;
                }
                int current = Integer.parseInt(got);
                list.add(current);
            }
        }catch(NumberFormatException e){
            System.err.println("Error: Encountered problem parsing the input.");
            throw e;
        }
        int[] arr = new int[list.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }

    /**
     * int[][] knapsack(int[] values, int[] weights, int capacity)
     * Berechnet die optimale Lösung des Rucksackproblems und gibt eine Tabelle mit den
     * Zwischenergebnissen zurück. Die Laufzeit soll in O(values.length · capacity) sein.
     * @Runtime O(weights.length * capacity)
     * @param values
     * @param weights
     * @param capacity
     * @return
     */
    public static int[][] knapsack(int[] values, int[] weights, int capacity){
        //TODO: Knapsack
        int count = weights.length;
        int [][] table = new int[count + 1][capacity + 1];
        for (int elem = 1; elem <= count; elem++){
            for (int cap = 1; cap <= capacity; cap++){
                //include this element
                if (weights[elem - 1] <= cap){
                    //check if it is beneficial to include this element
                    table[elem][cap] = Math.max(table[elem - 1][cap], table[elem - 1][cap - weights[elem - 1]] + values[elem - 1]);
                }
                //dont include this element
                else{
                    table[elem][cap] = table[elem - 1][cap];
                }
            }
        }
        return table;
    }
}
