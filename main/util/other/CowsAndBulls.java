public class CowsAndBulls{

  //Constants
  public final static int NUM_DIGITS = 4;
  public final static int MAX_VALUE = 9876;
  public final static int MIN_VALUE = 1234;
  public final static int MAX_GUESSES = 10;
  //


  // instances
  private NumberPicker randomNumber;
  private int answer;
  private int guessesCopy;
  private int bullStored;
  private int cowStored;
  //

  public CowsAndBulls(int seed){
        randomNumber = new NumberPicker(seed, MIN_VALUE, MAX_VALUE);
        answer = randomNumber.nextInt();
        guessesCopy = MAX_GUESSES;
        }

  ////////////////////////////////////////////////////////
  //Stuff between the comments is from a previous question that needs to be used in CowsAndBulls (not in a package) - I know it works as it's supposed to.
  public static int[] toArray(int number){

        String numString = Integer.toString(number);
        int[] someArray = new int[numString.length()];

        for (int i = 0; i < numString.length(); i++){
              char c = numString.charAt(i);

              int cVal = Character.getNumericValue(c);

              someArray[i] = cVal;
              }
        return someArray;
              }

  public static int countMatches(int a, int b){ //Bulls

        String stringA = Integer.toString(a);
        int lengthAB = stringA.length();
        int count = 0;

        int[] arrayOutA = toArray(a);
        int[] arrayOutB = toArray(b);

        for (int i = 0; i < lengthAB; i++){
              if (arrayOutA[i] == arrayOutB[i])
                    count += 1;     
                          }                   
        return count;
        } 


  public static int countIntersect(int numA, int numB){ //Cows
        String stringA = Integer.toString(numA);
        int lengthAB = stringA.length();
        int count = 0;

        int[] arrayOutA = toArray(numA);
        int[] arrayOutB = toArray(numB);

        for (int i = 0; i < lengthAB; i++){

              for (int j = 0; j < lengthAB; j++){

                    if ( arrayOutA[i] == arrayOutB[j]){
                             count += 1;
                             }
                          }

                    }
                    return count;
                    } 
  //////////////////////////////////////////////////////////////////                        






  public int guessesRemaining(){
        return guessesCopy;
        }



  public Result guess(int guessNumber){

        int bulls = countMatches(answer, guessNumber);
        bullStored = bulls;
        int cows = countIntersect(answer, guessNumber);
        cowStored = cows;

        guessesCopy--;
        return (new Result(cows, bulls));
        }

  public int giveUp(){
        return (answer);
        }

  public boolean gameOver(){
        if (guessesCopy == 0 || bullStored == 4)
              return true;
        else
              return false;                  
        }
