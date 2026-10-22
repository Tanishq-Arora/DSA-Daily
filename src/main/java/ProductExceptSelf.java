public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        if (nums == null) {
            throw new IllegalArgumentException("Input array must not be null");
        }

        int arrayLength = nums.length;
        int[] resultantArray = new int[arrayLength];

        int prefixProduct = 1;

        for(int i = 0; i < arrayLength; i++){
            resultantArray[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        int suffixProduct = 1;

        for(int i = arrayLength - 1; i >= 0; i--){
            resultantArray[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return resultantArray;
    }
}
