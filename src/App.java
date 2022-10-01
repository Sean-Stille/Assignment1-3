public class App {
    public static void main(String[] args) throws Exception {
        FileReader setup = new FileReader(20); //FileReader class demo
        
        String[] array = setup.getInputArray();

        System.out.println(findMajority(0, array.length-1, array));

        
    }

    public static String findMajority(int low, int high, String[] array){
        if (low >= high){
            return array[low];
        }
        else{
            int mid = (high+low)/2;
            String left = findMajority(low, mid, array);
            String right = findMajority(mid+1, high, array);

            if (left.compareTo(right) == 0){
                return left;
            }
            else if( isMajorityCount(low, high, array, left)){
                return left;
            }
            else if (isMajorityCount(low, high, array, right) ){
                return right;
            }
            else{
                return "No favorite tree :(";
            }

            
        }
    }

    public static boolean isMajorityCount(int low, int high, String[] array, String majority){
        int count = 0;
        for(int i = low; i <= high; i++ ){
            if( array[i].compareTo(majority) == 0 ){
                count++;
            }
        }
        
        if ( count > (high-low)/2 + 1){         // If the count is greater than 51% of the surveyed elements
            return true;
        }
        return false;
    }
}
