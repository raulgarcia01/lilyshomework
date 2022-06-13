import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Result {

    /*
     * Complete the 'lilysHomework' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int lilysHomework(List<Integer> arr) {
                
        List<Integer> sortedArr = new ArrayList<>(arr);
        Collections.sort(sortedArr);
        int ascSwap = swapCounter(arr, sortedArr);
        Collections.reverse(sortedArr);
        int descSwap = swapCounter(arr, sortedArr);
                        
        return (ascSwap < descSwap) ? ascSwap : descSwap;
    }
    
    /* Clase que obtiene el valor de las veces de intercambios */
    private static int swapCounter(List<Integer> ori, List<Integer> sorted){
        HashMap<Integer, Integer> mapArr = new HashMap<Integer, Integer>();
        for(int i = 0; i < ori.size(); i++) {
            mapArr.put(ori.get(i), i);
        }
        
        int tempIndex = 0;
        int countSwaps = 0;
        
        for(int i = 0; i < sorted.size(); i++) {
            if(i != mapArr.get(sorted.get(i))){
                tempIndex =  mapArr.get(sorted.get(i));
                mapArr.replace(sorted.get(i), i);
                mapArr.replace(ori.get(i), tempIndex);
                countSwaps++;
            }
        }
        
        return countSwaps;
    }
}