package Unidad1;

import java.io.*;

class Model {

    private View v;
    private String content;
    private String Name;
    final char shiftup = (char) 3;
    final char shiftdown = (char) 1;

    public Model(View v) {
        this.v = v;
    }

    void setFileName(String fileName) {
        Name = fileName;
    }

    void setContenido(String text) {
        content = text;
    }

    public String getContenido() {
        return content;
    }

    void encript() {
        v.setText(Model.encriptar(v.getFileName().toCharArray()));
    }

    void decript() {
        v.setText(Model.desencriptar(v.getFileName().toCharArray()));
    }

    public void SaveFile(String archive) {
        try {
            FileWriter writer = new FileWriter("Vigenère cipher.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String textToPrint = archive;
            bufferedWriter.write(textToPrint);
            bufferedWriter.close();
            System.out.println("Save file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String read(String textSearched) {
        String chain;
        String content = "";
        File file = new File("C:\\Users\\Leslie\\OneDrive\\Documentos\\NetBeansProjects\\Topicos" + textSearched);
        try {
            if (file.exists()) {
                BufferedReader b = new BufferedReader(new FileReader(file));
                while ((chain = b.readLine()) != null) {
                    content = content + chain + '\n';
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println(" Error .");
        } catch (IOException ioException) {
            System.err.println(" Error .");
        }
        content = content;
        return content;
    }

    static String encriptar(char array[]) {
        String me = "";
        for (int i = 0; i < array.length; i++) {
            if ((array[i] >= 65 && array[i] <= 90) || (array[i] >= 97 && array[i] <= 122)) {
                array[i] += 3;
            }
        }
        array = invertir(array);
        int partido = Math.round(array.length / 2);
        for (int i = partido; i < array.length; i++) {
            if ((array[i] >= 65 && array[i] <= 90) || (array[i] >= 97 && array[i] <= 122)) {
                array[i] -= 1;
            }
        }
        for (int i = 0; i < array.length; i++) {
            me = me + "" + array[i];
        }
        return me;
    }

    static String desencriptar(char array[]) {
        String md = "";
        int partido = Math.round(array.length / 2);
        for (int i = partido; i < array.length; i++) {
            if ((array[i] >= 65 && array[i] <= 90) || (array[i] >= 97 && array[i] <= 122)) {
                array[i] += 1;
            }
        }
        array = invertir(array);
        for (int i = 0; i < array.length; i++) {
            if ((array[i] >= 65 && array[i] <= 90) || (array[i] >= 97 && array[i] <= 122)) {
                array[i] -= 3;
            }
        }
        for (int i = 0; i < array.length; i++) {
            md = md + "" + array[i];
        }
        return md;
    }

    public static char[] invertir(char array[]) {
        char[] invertido = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            invertido[i] = array[array.length - 1 - i];
        }
        return invertido;
    }

    char[] chars(String mensaje) {
        char[] temporal = new char[mensaje.length()];
        for (int i = 0; i < mensaje.length(); i++) {
            temporal[i] = mensaje.charAt(i);
        }
        return temporal;
    }
}
