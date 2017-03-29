package com.thedionisio.util;

/**
 * Created by jonathan on 3/29/17.
 */
import java.io.*;
import java.util.ArrayList;

public class LocalShell {

    //execução do comando ls no Linux
    public static void main(String[] args) throws IOException {
        final LocalShell shell = new LocalShell();
        shell.executeCommand("ls");
    }

    public void executeCommand(final String command) throws IOException {

        final ArrayList<String> commands = new ArrayList<String>();

        commands.add("/bin/bash");
        commands.add("-c");
        commands.add(command);
        BufferedReader br = null;
        try {

            final ProcessBuilder p = new ProcessBuilder(commands);
            final Process process = p.start();
            final InputStream is = process.getInputStream();
            final InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Retorno do comando = [" + line + "]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            secureClose(br);
        }
    }

    private void secureClose(final Closeable resource) {
        try {
            if (resource != null) {
                resource.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}