import java.util.Arrays;

public class Main{

    public static String reverseString(String string){
        int n;
        n = string.length();
        char[] storageArray = new char[n];
        for (int i = 0; i < storageArray.length; i++) {
            storageArray[i] = string.charAt(n-1);
            n--;
        }
        string = "";
        for (int i = 0; i < storageArray.length; i++) {
            string +=  storageArray[i];
        }
        return string;
    }


    public static int mostRepeatedNumber(int[] numberList){
        int finalMostRepeated = 0;
        int biggestNumber = 0;
        int counter;
        int answer = 0;

        for (int i = 1; i < numberList.length; i++) {
            if (numberList[i] > biggestNumber) {
                biggestNumber = numberList[i];
            }
        }

        for (int i = 0; i <= biggestNumber; i++) {
            counter = 0;
            for (int j = 0; j < numberList.length; j++) {
                if(i == numberList[j]){
                counter++;
                }
            }
            if( counter > finalMostRepeated ) {
                finalMostRepeated = counter;
                answer = i;
            }
        }
      return answer;
    }


    public static boolean checkPrimeNumber(int number){
        if (number <= 1) return false;
        if (number == 2) return true; 
        if ( number % 2 == 0) return false;
        boolean answer = true;
        int radicalNumber;
        radicalNumber = (int)Math.sqrt(number);
        for (int i = 3 ; i <= radicalNumber ; i+= 2) {
            if( number % i == 0){
                answer = false;
                break;
            }
        }
        return answer;
    }


    public static int calculateMatrix(int[][] matrix) {
        int answer=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if ( i == j) {
                    answer += matrix[i][j];
                }
            }
        }
        return answer;
    }


    public static String changeSentence(String sentence){
        int wordCounter=1;
        for (int i = 0; i < sentence.length() ; i++) {
            if(sentence.charAt(i) == ' ') {
                wordCounter++;
            }   
        }

        String[] sentenceWords = new String[wordCounter];
        int j = 0;
        int z = 0;

        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ' ) {
                sentenceWords[z] = sentence.substring(j, i);
                j = i+1;
                z++;
            }
            if(sentence.charAt(i) == sentence.charAt(sentence.length()-1)){  //this part is for last letter because we don't have space after last letter
                sentenceWords[z] = sentence.substring(j, sentence.length());
            }
        }

        // Till now i made our array of all words in this sentence now i want to make this array in order of alphabet
        
        Arrays.sort(sentenceWords);
        sentence = "";
        for (int i = 0; i < sentenceWords.length; i++) {
            sentence += (sentenceWords[i] + " ");
        }
        return sentence;
    }



    public static void main(String[] args){
        System.out.println("1)  "  +  reverseString("hello")); 
        System.out.println("2)  "  +  mostRepeatedNumber(new int[] {1,1,2,3,4,5,5,6,6,6,7,2,9,9,9,9,10,12,18,20,21,21,21,21,21,21}));
        System.out.println("3)  "  +  checkPrimeNumber(7));
        System.out.println("4)  "  +  calculateMatrix(new int[][] {{9,8,7} , {6,5,4} , {3,2,1}}));
        System.out.println("5)  "  + changeSentence("machine learning is fun"));
    }
}