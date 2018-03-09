 
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
	String value;
	StageOne O;
	StageTwo T;
	String Exchange;
	boolean newStuff;
	public Main(String input){
    	value = input;
    	O = new StageOne("");
    	T = new StageTwo("Letters", "");
    	newStuff = true;
	}
	
	public void newString(String input){
    	value = input;
    	newStuff = true;
	}
	
	public String Encrypt(){
    	if(newStuff)
        	O.newText(value);
    	else
        	O.newText(Exchange);
    	T.newText(O.Encrypt());
    	Exchange = T.Encrypt();
    	
    	newStuff = false;
    	return Exchange;
	}
	public String Decrypt(){
    	if(newStuff)
        	T.newText(value);
    	else
        	T.newText(Exchange);
    	O.newText(T.Decrypt());
    	Exchange = O.Decrypt();
    	
    	newStuff = false;
    	return Exchange;
	}
	
	public void PrintSlip(){
    	T.printEncryptionScreen();
	}
}

