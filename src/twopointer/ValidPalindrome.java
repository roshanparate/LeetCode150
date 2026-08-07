package twopointer;

public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        boolean result = validPalindrome.isPalindrome(s);
        System.out.println("Is the string a valid palindrome? " + result);
    }

    public boolean isPalindrome(String s) {
        int left=0;
        int right = s.length()-1;
        while(left <= right){
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));
            if(!Character.isLetterOrDigit(leftChar)){
                left++;
            }else if(!Character.isLetterOrDigit(rightChar)){
                right--;
            }else if(leftChar == rightChar){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
