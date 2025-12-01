public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String encrypt(String message){        
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            int i0 = rotors[0].indexOf(c);
            char cOuter1 = rotors[2].charAt(i0);

            int i1 = rotors[1].indexOf(cOuter1);
            char enc = rotors[2].charAt(i1);

            out.append(enc);
            rotate();
        }
        return out.toString();
    }


    
    public String decrypt(String message){
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            int i0 = rotors[2].indexOf(c);
            char cMid = rotors[1].charAt(i0);

            int i1 = rotors[2].indexOf(cMid);
            char dec = rotors[0].charAt(i1);

            out.append(dec);
            rotate(); 
        }
        return out.toString();
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}