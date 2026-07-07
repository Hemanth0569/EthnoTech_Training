package FileHandling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FH {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting my File");
        String path = "C:\\Users\\heman\\IdeaProjects\\EthnoTech\\src\\FileHandling";
        File f = new File(path);
        FileWriter fw = new FileWriter(f,true);
        BufferedWriter bw = new BufferedWriter(fw);
        //fw.write("Hello");
        Scanner sc =new Scanner(System.in);
        String inp = sc.nextLine();
        bw.newLine();
        bw.write(inp);
        bw.close();
        fw.close();
    }
}
