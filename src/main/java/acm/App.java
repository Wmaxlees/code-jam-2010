package acm;

import java.util.ArrayList;
import acm.Pair;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int credit = 0;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("A-large-practice.in"));
            int cases = Integer.parseInt(bufferedReader.readLine());

            for (int j = 1; j <= cases; ++j) {
                // System.out.println( j );
                ArrayList<Pair> list = new ArrayList<Pair>();
                credit = Integer.parseInt(bufferedReader.readLine());
                bufferedReader.readLine();

                String prices = bufferedReader.readLine();
                String[] splitPrices = prices.split(" ");

                for (int i = 0; i < splitPrices.length; ++i) {
                    list.add(new Pair(i + 1, Integer.parseInt(splitPrices[i])));

                    // System.out.println("New: " + (i + 1) + " - " + splitPrices[i]);
                }

                Collections.sort(list);

//                for (Pair i : list) {
//                    System.out.println(i.getPrice());
//                }

                for (int i = 0; i < list.size(); ++i) {
                    Pair target = new Pair(0, credit - list.get(i).getPrice());
                    int index = Collections.binarySearch(list.subList(i+1, list.size()), target);
                    if (index >= 0) {
                        int index1 = list.get(i).getIndex();
                        int index2 = list.subList(i+1, list.size()).get(index).getIndex();

                        if (index1 < index2) {
                            System.out.println("Case #" + j + ": " + index1 + " " + index2);
                        } else {
                            System.out.println("Case #" + j + ": " + index2 + " " + index1);
                        }
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }
}
