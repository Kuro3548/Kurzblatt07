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
     * void main(String[] args)
     * Bekommt einen Parameter welcher die Rucksackkapazität bestimmt. Außerdem werden
     * die Gewichte sowie Gegenstandswerte als zwei Listen mit Leerzeile getrennt übergeben (s.
     * Beispieldatei B7A2Input1.txt). Das Programm soll danach überprüfen, ob auch wirklich
     * das Ende des Eingabestreams erreicht wurde und ansonsten eine entsprechende Meldung
     * ausgeben und terminieren (s. Beispiele). Ausgegeben werden soll der Wert der optimalen
     * Lösung des Rucksackproblems, also die Summe der eingepackten Gegenstandwerte.
     * [(1,10) -> 14; (2,12) -> Did not end after 2nd list; (3,12) -> Number of values != number of weights]
     * @param args
     */
    public static void main(String[] args){
        //TODO: main --Error--
        int[] weights;
        int[] values;
        int capacity;
        try {
            Scanner scanner = new Scanner(System.in);
            weights = getInput(scanner);
            values = getInput(scanner);
            if(scanner.hasNextLine()){
                System.out.println("Number of values does not match the number of weights.");
                return;
            }
            capacity = Integer.parseInt(args[0]);
        }catch(NumberFormatException e){
            System.out.println("Error: Encountered problem parsing argument, required: number");
            return;
        }
        int[][] out = knapsack(values, weights, capacity);
        int max = 0;
        for(int i = 0; i < out.length; i++){
            for(int j = 0; j < out[i].length; j++){
                //if(out[i][j] > max){
                    max += out[i][j];
                //}
            }
        }
        System.out.println(max);
    }

    /**
     * int[] getInput(Scanner scanner) throws NumberFormatException
     * Liest aus dem Scanner die nächsten zusammenhängenden Zeilen aus Ganzzahlen ein.
     * Sollte bis zu der nächsten Leerzeile oder bis zum Ende des Scanners eine Zeile aus einer
     * Nicht-Ganzzahl bestehen, soll die NumberFormatException weitergereicht werden. Die
     * gelesenen Ganzzahlen sollen als Array zurückgegeben werden.
     * @param scanner
     * @return
     * @throws NumberFormatException
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
     * [(1,10) -> 14; (2,12) -> Did not end after 2nd list; (3,12) -> Number of values != number of weights]
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
