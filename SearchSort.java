import java.util.Random;

class SearchSort {

    public static int SIZE = 10;

    public static void main(String[] args) {
        int[] numbers = new int[SIZE];
        int retval;

        loadArray(numbers,200);
        //showArray(numbers);
        numbers[9]=999;
        sortArray(numbers);
        System.out.println();
        //showArray(numbers);
        retval=binSearch(numbers, 999);
        System.out.printf("retval: %d\n",retval);

        
    }


    public static void loadArray(int[] theArray, int max){
        int index;

        Random rand = new Random();
        for(index=0;index<theArray.length;index++){
            theArray[index]=rand.nextInt(max);
        }
    }

    public static void showArray(int[] theArray){
        int index;

        for(index=0;index<theArray.length;index++){
            System.out.printf("[%d]: %d\n",index,theArray[index]);
        }
    }

    public static void sortArray(int[] theArray){
        int index;
        int temp;
        int pass;

        for(pass=0;pass<theArray.length-1;pass++){
            for(index=0;index<theArray.length-1;index++){
                if(theArray[index+1]<theArray[index]){
                    //*** Swap Contents */
                    temp=theArray[index];
                    theArray[index]=theArray[index+1];
                    theArray[index+1]=temp;
                }
            }
        }
    }

    public static int binSearch(int[] theArray, int value){
        int start = 0;
        int retval=-1;
        int mid;
        int end = theArray.length-1;


        while(start<=end){
            mid = (end-start)/2 + start;

            System.out.printf("start: %d  mid: %d  end: %d\n",start,mid,end);
            if(theArray[mid]==value){
                retval=mid;
                break;
            }

            if(theArray[mid] < value){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return retval;
    }
}