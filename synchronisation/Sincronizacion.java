package synchronisation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Sincronizacion implements Runnable{

        private String palabra;
        private Thread hilo;
        private int cant;

        public Sincronizacion(String palabra) {
            this.palabra = palabra;
            hilo = new Thread(this);
            this.cant = 0;
            hilo.start();
            while (hilo.isAlive());
            System.out.println("La palabra " + palabra + " se encuentra contenida en " +
                                cant + " archivos");
        }

        @Override
        public void run() {
            File ar = new File("C:\\Users\\User\\Desktop\\");
            String[] directorio = ar.list();
            for (String arch : directorio) {
                if (tiene(arch))
                    cant++;
            }
        }

        private synchronized boolean tiene(String archivo) {
            boolean existe = false;
            try {
                FileReader fr = new FileReader("C:\\Users\\User\\Desktop\\" + archivo);
                BufferedReader br = new BufferedReader(fr);
                String linea = br.readLine();
                while (linea != null) {
                    if (linea.indexOf(palabra) != -1) {
                    	existe = true;
                    	break;
                    }
                    linea = br.readLine();
                }
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println(e.toString());
            }
            return existe;
        }

        public static void main(String[] ar) {
            new Sincronizacion("rojo");
            new Sincronizacion("verde");
            new Sincronizacion("amazon");

        }

    }
