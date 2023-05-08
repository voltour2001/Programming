import java.io.*;

public class Hello2 {
    
    public static void main(String[] args) {
        
        // Need Try/throws because this might cause a system error
        try {
    
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));

        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        br.close();
    
        }catch(Exception ex){
            return;
        }        
    }
}

