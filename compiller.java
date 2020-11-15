import java.io.*;
import java.util.Scanner;

public class compiller {
    String inst[] = { "add", "nand", "lw", "sw", "beq", "jalr", "halt", "noop" };
    int[][] mem = new int[20][];
    String[] pc = new String[20];
    String path;

    public compiller(String file) throws Exception {
        path = file;

        File fr = new File(path);
        Scanner sc = new Scanner(fr);

        for (int i = 0; sc.hasNextLine(); i++) {
            pc[i] = sc.nextLine();
            pc[i] = pc[i].substring(0, pc[i].length() - 1);
            System.out.println(pc[i]);

            pc[i] = tobinary(pc[i]);
        }
    }

    private String tobinary(String str) {
        String[] array = str.split(" ");
        System.out.println(array[0]);

        switch (array[0]) {
            case "add":
                array[0] = "000";
                break;

            case "nand":
                array[0] = "001";
                break;

            case "lw":
                array[0] = "010";
                break;

            case "sw":
                array[0] = "011";
                break;

            case "beq":
                array[0] = "100";
                break;

            case "jalr":
                array[0] = "101";
                break;

            case "halt":
                array[0] = "110";
                break;

            case "noop":
                array[0] = "111";
                break;

            default:
                break;
        }
        return array[0] + array[1] + array[2] + array[3];
    }

    public void instructionMemory() {
        System.out.println("X2");
    }
}
