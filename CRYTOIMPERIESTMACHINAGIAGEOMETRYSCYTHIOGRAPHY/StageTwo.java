
import java.io.*;
public class StageTwo
{
    final int LENGTH = 10;
    final int LENGTHW = 15;
    final int HEIGHT = 7;
    
    int[] splitLength;
    
    String textValue;
    String pathStuff ="";
    
    String finalText = "";
    
    public StageTwo(String pathFILE, String text){
        textValue = text;
        pathStuff = pathFILE;
        splitLength = new int[7];
    }
    
    public void newText(String text){
        textValue = text;
        finalText ="";
    }
    
    private BufferedReader constructStuffs(String pathFILE){
        
        try{ 
            return new BufferedReader(new InputStreamReader(new FileInputStream(pathStuff+"/" + pathFILE + ".txt")));
         }catch(IOException ex){
            System.out.println(ex);
            return null;
        }
        
    }
    
    public String Encrypt(){
            finalText = "";
            BufferedReader bi;
            String newStuffs  ="";
            
            
            int sumValue = 0;
            try{ 
                for(int a = 1; a<= 7; a++){
                    sumValue = 0;
                    for(int i = 0; i<textValue.length() ; i++){
                        bi = constructStuffs(textValue.substring(i,i+1));
                        
                        for(int b = 0; b<a; b++){
                            newStuffs = bi.readLine() + " ";
                        }
                        finalText +=newStuffs;
                        sumValue += newStuffs.length();
                    }
                    splitLength[a-1] = sumValue; 
                }
            
             }catch(IOException ex){
                System.out.println(ex);
                return null;
            }
        
            
        
        return finalText;
        
    }
    
    
    public void printEncryptionScreen(){
        int startPoint = 0;
        for(int i = 0; i<splitLength.length;i++)
        {
            System.out.println(finalText.substring(startPoint,startPoint+splitLength[i]));
            startPoint += splitLength[i];
        }
        
    }
    
    public String Decrypt(){
        int letterLength = 0;
        String tempTest = textValue;
        int lineLength = textValue.length()/7;
        String checkText;
        String testValue;
        BufferedReader bi;
        int letterStart = 0;
        finalText = "";
        
        for(int b = 0; tempTest.indexOf("= ")!= -1;b=b){
            
            checkText = "";
            testValue = "";
            
            
            tempTest = tempTest.substring(tempTest.indexOf("="));
            letterLength = tempTest.indexOf("= ");
            
            tempTest = tempTest.substring(letterLength+2);
            
            
            for(int i = 0; i<6; i++){
                
                checkText += textValue.substring(letterStart+i*lineLength, letterStart+i*lineLength+letterLength+1);
                
            }
            for(int i = 0; i<36; i++)
            {
                testValue = "";
                try{
                    
                    if(i<10){
                        testValue += (char)(i+48);
                        
                        bi = constructStuffs(testValue);
                        testValue = bi.readLine() +bi.readLine()+bi.readLine()+bi.readLine()+bi.readLine()+bi.readLine();
                        
                        if(testValue.equals(checkText)){
                            finalText += (char)(i+48);
                            
                        }
                    }
                    else{
                        testValue += (char)(i+55);
                        
                        bi = constructStuffs(testValue);
                        testValue = bi.readLine() +bi.readLine()+bi.readLine()+bi.readLine()+bi.readLine()+bi.readLine();
                        
                        
                        if(testValue.equals(checkText)){
                            finalText += (char)(i+55);
                            
                        }
                    } 
                    
                 }catch(IOException ex){
                     System.out.println(ex);
                     return null;
                 }   
            }
            letterStart += letterLength+2;
        }
        return finalText;
        
        
        
        
    }
    public void printDecryptScreen(){
        System.out.println(finalText);
    }
}
