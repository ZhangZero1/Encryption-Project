
/**
 * Write a description of class StageOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class StageOne
{
    String textValue;
    ArrayList<Character> Zero;
    ArrayList<Character> One;
    ArrayList<Character> Two;
    ArrayList<Character> Three;
    ArrayList<Character> Four;
    ArrayList<Character> Five;
    ArrayList<Character> Six;
    
    
    int currentBase;
    
    String finalText = "";
    
    public StageOne(String inputString){
        textValue = inputString;
        
        Zero = new ArrayList<Character>();
        One = new ArrayList<Character>();
        Two = new ArrayList<Character>();
        Three = new ArrayList<Character>();
        Four = new ArrayList<Character>();
        Five = new ArrayList<Character>();
        Six = new ArrayList<Character>();
            
        
        
        
        
    }
    
    public void newText(String inputString){
        textValue = inputString;
    }
    
    private void resetArrayList(){
        Zero.clear();
        One.clear();
        Two.clear();
        Three.clear();
        Four.clear();
        Five.clear();
        Six.clear();
    }
    
    public String Encrypt(){
        int a;
        int currentValue = 0;
        String newTrail = "";
        finalText = "";
        
        for(int x = 0; x<textValue.length(); x++){
            resetArrayList();
            currentBase = (int)(Math.random()*6)+2;
            
            finalText += currentBase;
            a = 0;
            newTrail = "";
            
            for(int i = 0; i<26; i++){
    
                switch(a){
                    case 0: Zero.add((char)(i+65));
                           break;
                    case 1: One.add((char)(i+65));
                           break;
                    case 2: Two.add((char)(i+65));
                           break;
                    case 3: Three.add((char)(i+65));
                           break;
                    case 4: Four.add((char)(i+65));
                           break;
                    case 5: Five.add((char)(i+65));
                           break;
                    case 6: Six.add((char)(i+65));
                           break;
                }
                if(a==currentBase-1){
                    a = -1;
                }
                a++;
            }
            
            currentValue = textValue.codePointAt(x);
            
            
            while(currentValue>0){
                switch(currentValue%currentBase){
                        case 0: newTrail += Zero.get((int)(Math.random()*Zero.size()));
                               break;
                        case 1: newTrail += One.get((int)(Math.random()*One.size()));
                               break;
                        case 2: newTrail += Two.get((int)(Math.random()*Two.size()));
                               break;
                        case 3: newTrail += Three.get((int)(Math.random()*Three.size()));
                               break;
                        case 4: newTrail += Four.get((int)(Math.random()*Four.size()));
                               break;
                        case 5: newTrail += Five.get((int)(Math.random()*Five.size()));
                               break;
                        case 6: newTrail += Six.get((int)(Math.random()*Six.size()));
                               break;
                }
                currentValue = (int)(currentValue/currentBase);
            }
            for(int y = newTrail.length()-1; y>=0; y--){
                finalText += newTrail.substring(y,y+1);
            }
            
        
        }
        
        return finalText;
        
    }
    
    public String Decrypt(){
        int a = 0;
        String StringStuffs = "";
        int finalValue = 0;
        finalText = "";
        String test = "";
        for(int i = 0; i<textValue.length(); i++){
            
            
            if(textValue.codePointAt(i)<65){
                resetArrayList();
                if(StringStuffs!= ""){
                    
                    for(int y=0; y<StringStuffs.length(); y++){
                        finalValue += (int)(StringStuffs.codePointAt(y)-48)*Math.pow(currentBase,(StringStuffs.length()-1-y));
                        
                    }
                    
                    
                    finalText += (char)(finalValue);
                    finalValue = 0;
                }
                
                currentBase = (int)(textValue.codePointAt(i)-48);
                a = 0;
                    for(int j = 0; j<26; j++){
            
                        switch(a){
                            case 0: Zero.add((char)(j+65));
                                   break;
                            case 1: One.add((char)(j+65));
                                   break;
                            case 2: Two.add((char)(j+65));
                                   break;
                            case 3: Three.add((char)(j+65));
                                   break;
                            case 4: Four.add((char)(j+65));
                                   break;
                            case 5: Five.add((char)(j+65));
                                   break;
                            case 6: Six.add((char)(j+65));
                                   break;
                        }
                        if(a==currentBase-1){
                            a = -1;
                        }
                        a++;
                    }
                StringStuffs = "";
            }
            else{
                
                for(int d = 0; d<Zero.size(); d++){
                    test += Zero.get(d);
                    
                    if(test.equals(textValue.substring(i,i+1))){
                        StringStuffs += 0;
                    }
                    test = "";
                }
                for(int d = 0; d<One.size(); d++){
                    test += One.get(d);
                    if(test.equals(textValue.substring(i,i+1))){
                        StringStuffs += 1;
                    }
                    test = "";
                }
                for(int d = 0; d<Two.size(); d++){
                    test += Two.get(d);
                    if(test.equals(textValue.substring(i,i+1))){
                        StringStuffs += 2;
                    }
                    test = "";
                }
                for(int d = 0; d<Three.size(); d++){
                    test += Three.get(d);
                    if(test.equals(textValue.substring(i,i+1))){
                        StringStuffs += 3;
                    }
                    test = "";
                }
                for(int d = 0; d<Four.size(); d++){
                    test += Four.get(d);
                    if(test.equals(textValue.substring(i,i+1))){
                        StringStuffs += 4;
                    }
                    test = "";
                }
                for(int d = 0; d<Five.size(); d++){
                    test += Five.get(d);
                    if(test.equals(textValue.substring(i,i+1))){
                        StringStuffs += 5;
                    }
                    test = "";
                }
                for(int d = 0; d<Six.size(); d++){
                    test += Six.get(d);
                    if(test.equals(textValue.substring(i,i+1))){
                        StringStuffs += 6;
                    }
                    test = "";
                }
                
            }
            
        }
        
        if(StringStuffs!= ""){
            
            for(int y=0; y<StringStuffs.length(); y++){
                finalValue += (int)(StringStuffs.codePointAt(y)-48)*Math.pow(currentBase,(StringStuffs.length()-1-y));
                
            }
            
            
            finalText += (char)(finalValue);
            finalValue = 0;
        }
        return finalText;
    }
    
    public void printEncryption(){
        System.out.println(finalText);
    }
    
    public void printDecryption(){
        System.out.println(finalText);
    }
    
}
