import java.io.*;

public class compiller {
    String inst[] = { "add", "nand", "lw", "sw", "beq", "jalr", "halt", "noop" };
    int mem[][];
    String path;

    public compiller(String file) throws Exception {
        path = file;

        FileReader fr = new FileReader(path);
        int i;
        while ((i = fr.read()) != -1) {
            System.out.print((char) i);
        }
    }

    public void instructionMemory() {
        System.out.println("X2");
    }
}
