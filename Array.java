public class Array {

    private final int MAX_SIZE = 20;            // the array size
    private int[] data = new int[MAX_SIZE];    
    private int count = 0;                     

    
    private String lastLinearResult = "No Linear Search done yet";
    private String lastBinaryResult = "No Binary Search done yet";

    public int getCount() {
        return count;
    }

    public String getLastLinearResult() {
        return lastLinearResult;
    }

    public String getLastBinaryResult() {
        return lastBinaryResult;
    }