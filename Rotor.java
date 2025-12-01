public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while (charAt(0) != startChar) {
            rotate();
        }
            
    }
    
    public boolean rotate(){
        int n = rotorValues.length();
        char last = rotorValues.charAt(n - 1);
        rotorValues = last + rotorValues.substring(0, n - 1);
        return rotorValues.charAt(0) == startChar;
    }
    

    public int indexOf(char c){
        return rotorValues.indexOf(c);
    }

    public char charAt(int idx){
        return rotorValues.charAt(idx);
    }
}
    

