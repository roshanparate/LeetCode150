package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber letterCombinations = new LetterCombinationsPhoneNumber();
        String digits = "23";
        System.out.println("Letter combinations for digits " + digits + ": " + letterCombinations.letterCombinations(digits)); // Output: Letter combinations for digits 23: [ad, ae, af, bd, be, bf, cd, ce, cf]
    }

    List<String> keys = List.of("","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");

    public List<String> letterCombinations(String digits) {
        List<String> combination = new ArrayList<>();
        String temp = "";

        backtracking(combination, temp, 0, digits);

        return combination;
    }

    public void backtracking(List<String> combination, String current, int i, String digits){
        if(i == digits.length()){
            combination.add(current);
        }else{
            int digit = digits.charAt(i) - '0';
            String letters =  keys.get(digit);
            for(int j = 0; j < letters.length(); j++){
                backtracking(combination, current + letters.charAt(j), i+1, digits);
            }
        }
    }
}
