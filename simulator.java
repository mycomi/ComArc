import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class simulator {
    
    
    String path;
    char[][] mc = new char[32][32];
    String temp[] = new String[32];

    public simulator(String file) throws Exception {
        path = file;

        File fr = new File(path);
        Scanner sc = new Scanner(fr);

        for (int i = 0; sc.hasNextLine(); i++) {
            temp[i] = sc.nextLine();
            for(int j=temp[i].length()-1;j >= 0;j--){
                
                mc[i][j] = temp[i].charAt(j);
                
            }

            

            String op = String.valueOf(mc[i][24]) + String.valueOf(mc[i][23]) + String.valueOf(mc[i][22]);

            Read(op,i);

        }

        

    }


    public void Read(String op,int i){
        // String op = String.valueOf(mc[0][24]) + String.valueOf(mc[0][23]) + String.valueOf(mc[0][22]);
        System.out.println(op);
        switch (op) {
            case "000":
                String rs = String.valueOf(mc[i][21]) + String.valueOf(mc[i][20]) + String.valueOf(mc[i][19]);
                String rt = String.valueOf(mc[i][18]) + String.valueOf(mc[i][17]) + String.valueOf(mc[i][16]);
                String rd = String.valueOf(mc[i][2]) + String.valueOf(mc[i][1]) + String.valueOf(mc[i][0]);

                Add(rs,rt,rd);

                break;

            case "001":
                
                break;
            
            case "010":
                
                break;
                
            case "011":
                
                break;

            case "100":
                
                break;

            case "101":
                
                break;
            
            case "110":
                
                break;
                
            case "111":
                
                break;
            
            default:
                break;
        }
    }


    public void Add(String rs1,String rs2,String rd){
        

    }
}
