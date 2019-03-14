package customListWithSorter;


public class Sorter  {

    public static <T extends Comparable<T>> void sort(CustomList<T> customList){

        for (int i = 0; i <customList.size() ; i++) {
            for (int j = i+1; j <customList.size(); j++) {
                if (customList.get(i).compareTo(customList.get(j))>0){
                    customList.swap(i,j);
                }
            }
            
        }

    }
}
