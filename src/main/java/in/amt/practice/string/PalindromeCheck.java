package in.amt.practice.string;

/**
 * Created by amit.sharma5 on 14/11/18.
 */
public class PalindromeCheck {

    boolean isPalindrom(String str){
        char[] strArr = str.toCharArray();
        int lastIndex = strArr.length-1;
        for(int i=0,j=lastIndex; i<lastIndex;i++,lastIndex--){
            if (strArr[i] == strArr[lastIndex]){

            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeCheck palindromeCheck = new PalindromeCheck();
        System.out.println(palindromeCheck.isPalindrom("amitima"));
        System.out.println(palindromeCheck.isPalindrom("amittima"));
        System.out.println(palindromeCheck.isPalindrom("abbccbba"));
        System.out.println(palindromeCheck.isPalindrom("amit"));
    }

}
