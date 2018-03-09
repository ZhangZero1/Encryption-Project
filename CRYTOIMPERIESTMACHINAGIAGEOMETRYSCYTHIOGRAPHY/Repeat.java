
/**
 * Write a description of class Repeat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Repeat
{
    public static void main(String[] args){
        Main a = new Main("apples");
        for(int i = 0; i<99; i++){
            a.Encrypt();
            a.PrintSlip();
            a.Decrypt();
        }
            
    }
}
