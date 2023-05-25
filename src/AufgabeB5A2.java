import java.util.ArrayList;
import java.util.Scanner;

/**
 * Das Rucksackproblem ist ein bekanntes kombinatorisches Optimierungsproblem. Es geht darum, aus einer gegebenen Menge von Gegenständen eine Teilmenge auszuwählen, die in einen
 * Rucksack passt und dabei den größtmöglichen Gesamtwert hat.
 * Gegeben sei:
 * • n: Anzahl der Gegenstände
 * • C: Kapazität des Rucksacks
 * • wi
 * : Gewicht des Gegenstands i
 * • vi
 * : Wert des Gegenstands i
 * Gesucht ist:
 * • Eine Teilmenge S ⊆ {1, . . . , n} der Gegenstände, sodass die folgenden Bedingungen erfüllt
 * sind: X
 * i∈S
 * wi ≤ C (Gewichtsbeschränkung)
 * maximiereX
 * i∈S
 * vi (Wertmaximierung)
 * Dabei kann das Problem unterteilt werden in Teilprobleme. T[i][j] repräsentiert den maximalen
 * Gesamtwert, der erreicht werden kann, wenn wir die ersten i Gegenstände betrachten und den
 * Rucksack mit einer Kapazität von j füllen möchten. So kann T wie folgt berechnet werden:
 * T[i][j] =
 * 
 * 
 * 
 * 0 wenn i = 0 oder j = 0
 * max(werte[i − 1] + T[i − 1][j − gewichte[i − 1]], T[i − 1][j]) wenn gewichte[i − 1] ≤ j
 * tabelle[i − 1][j] sonst
 * Nutzen Sie diese Definition von T um das Rucksackproblem mithilfe der dynamischen Porgrammierung zu lösen
 */
public class AufgabeB5A2 {
    /**
     * void main(String[] args)
     * Bekommt einen Parameter welcher die Rucksackkapazität bestimmt. Außerdem werden
     * die Gewichte sowie Gegenstandswerte als zwei Listen mit Leerzeile getrennt übergeben (s.
     * Beispieldatei B7A2Input1.txt). Das Programm soll danach überprüfen, ob auch wirklich
     * das Ende des Eingabestreams erreicht wurde und ansonsten eine entsprechende Meldung
     * ausgeben und terminieren (s. Beispiele). Ausgegeben werden soll der Wert der optimalen
     * Lösung des Rucksackproblems, also die Summe der eingepackten Gegenstandwerte
     * @param args
     */
    public static void main(String[] args){
        //TODO: main
        int[] array_input;
        int k;
        try {
            array_input = getInput(new Scanner(System.in));
            k = Integer.parseInt(args[0]);
        }catch(NumberFormatException e){
            System.out.println("Error: Encountered problem parsing argument, required: number");
            return;
        }
        //int[] weights;
        //int[] values;
        //int[][] out = knapsack(values, weights, k);
        
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
        //TODO: getInput --Copied--
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        try {
            while (in.hasNextLine()) {
                int current = Integer.parseInt(in.nextLine());
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
     *  int[][] knapsack(int[] values, int[] weights, int capacity)
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
        return null;
    }

}
