/**

 * Write a description of class OK here.

 *

 * @author (your name) erickers

 * @version (a version number or a date)

 */

public class OKCipher

{

    String inputValue;

    int a,b,c,d,e;

    public OKCipher(String input, int[] seed ){

        inputValue = input;

        a = seed[0];

        b = seed[1];

        c = seed[2];

        d = seed[3];

        e = seed[4];

        

    }
    
    public void printCrap(){
        System.out.println(a+"\n"+b+"\n"+c+"\n"+d+"\n"+e);
    }

    

    public String garbageAdder(String input){

        

        String returnStuffs = "";

        

        int counter = d;

        for(int i = 0; i<input.length(); i++)

        {

            for(int w = 0; w<counter; w++){

                returnStuffs += (char)((int)(Math.random()*120)+15);

            }

            counter += e;

        }

        return returnStuffs;

    

    }


    public String garbageSubber(String input){

        String returnStuffs = "";

        for(int i = 0; i<input.length(); i++){

            returnStuffs +=input.substring(i,i+1);

            for(int z= 0;z<8;z++){

                returnStuffs += (char)((int)(Math.random()*120)+15);

            }

        }

        return returnStuffs;

    }

    

    public String shift(String input, int num){

        String finalValue = "";

        for(int i = 0; i<input.length(); i++){

            finalValue += (char)(input.codePointAt(i)+num);

        }

        return finalValue;

    }

    

    public String AlmostEncrypt(String input){

        String oldText = "";
        String newText = "";
        String temp = "";
        int sum = a+c;
        int instaTest = 0;
        int instaTests = 0;
        oldText += (char)(input.codePointAt(0)+a);

            for(int L = 1; L<=b;L++)

            {
                //System.out.println(oldText.length());
                for(int s = 0; s<oldText.length();s++){
                    instaTest=oldText.codePointAt(s);
                    instaTests=(int)(Math.random()*(instaTest-1))+1;
                    System.out.println("--"+instaTest+"--"+instaTests);
                    System.out.print(instaTest-instaTests+" "+instaTests+" /");
                      //temp+=(char)(instaTest-instaTests);
                      //temp+=(char)(instaTests);       
                    temp += (char)(instaTests+sum)+(char)(instaTest-instaTests+sum+c);
                    System.out.println(temp);
                    sum += c+c;
                    newText += temp;
                    temp = "";
                }
                oldText=newText;
                newText="";
                System.out.println("\n KINNNG");
                
            }

            return oldText;

    }

    

   public char almostDecrypt(String input){
    int sum = 0;
    int baseTotal = 0;
    int multiplicity = 0;
    
    for(int i = b; b>0; b--){
        sum += (int)Math.pow(2.0,(double)b);
    }
    for(int i = 1; i<=sum; i++)
    {
        multiplicity += i;
    }
    
    sum = (sum+1)*a+multiplicity*c;
    for(int i = 0; i<input.length(); i++){
        baseTotal+=input.codePointAt(i);
    }
    sum = baseTotal - sum;
    return (char)sum;
    
    //return (char)baseTotal;
    }


    public String Decrypt(String input){

        input = garbageSubber(input);

        String finalValue = "";

        for(int i = 0; i<input.length(); i+= Math.pow(2.0,(double)b)){

                finalValue += almostDecrypt(input.substring(i,i+(int)(Math.pow(2.0,(double)b))));

        }

        return finalValue;

   }

    public String encrypt(String input){

        String all = "";

        for(int i = 0;i<input.length(); i++)

            all += AlmostEncrypt(input.substring(i,i+1));

        all = garbageAdder(all);

        return all;

    }


  

  

}


