import java.io.*;
import java.util.Scanner;

public class compiller {
    String inst[] = { "add", "nand", "lw", "sw", "beq", "jalr" };
    String inst2[] = { "halt", "noop", ".fill" };
    int[][] mem = new int[50][];
    String[] pc = new String[50];
    String path;

    public compiller(String file) throws Exception {
        path = file;

        File fr = new File(path);
        Scanner sc = new Scanner(fr);

        for (int i = 0; sc.hasNextLine(); i++) {
            pc[i] = sc.nextLine();
            // pc[i] = pc[i].substring(0, pc[i].length() - 1);
            // System.out.println(pc[i]);
        }
        for (int i = 0; i < pc.length; i++) {
            if(pc[i] == null) break;
            pc[i] = toBinary(pc[i], i);
        }
    }

    private String toBinary(String str, int index) {
        String[] array = str.split(" ");

        // normal form
        if (matchinstruc(array[0])) {
            for (int i = 1; i < array.length; i++) {
                try {
                    Integer.parseInt(array[i]);
                    int temp = Integer.parseInt(array[i]);
                    array[i] = Integer.toBinaryString(temp);
                } catch (Exception e) {
                    for (int j = 0; j < pc.length; j++) {
                        if(pc[j] == null) break;
                        //System.out.println(i +" "+ j + " " +array[i]);
                        if(pc[j].matches(array[i] + "(.*)")){
                            System.out.println(array[i] + " :: " + pc[j]);
                            System.out.println(pc[index]);
                            pc[index] = pc[index].replaceAll(array[i], findValue(array[i]));
                            System.out.println(pc[index]);
                        }
                    }
                }
            }

            /*switch (array[0]) {
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
            }*/
        }

        /*if (array.length >= 2) {
            if (matchinstruc(array[1])) {
                System.out.println(array[1]);
            } else {
                System.out.println("not");
            }
        }*/

        String temp = "";
        /*for (int i = 0; i < array.length; i++) {
            temp += array[i] + " ";
        }*/
        return str;
    }

    private String findValue(String str) {
        for (int i = 0; i < pc.length; i++) {
            if(pc[i]==null) break;
            if(pc[i].matches(str+ " .fill(.*)")){
                String[] array = pc[i].split(" ");
                System.out.println(str + " = " + array[2]);
                return array[2];
            }
        }
        return "xx";
    }

    private boolean matchinstruc(String str) {
        for (String s : inst) {
            if (str.matches(s)) {
                return true;
            }
        }
        return false;
    }
}
