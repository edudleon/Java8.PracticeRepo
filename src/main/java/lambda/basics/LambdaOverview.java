package lambda.basics;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaOverview {

    public static void main(String[] args) throws InterruptedException {
        //La forma tradicional de instanciar una clase anonima es implementandola directamente en el codigo
        FileFilter traditional = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        };

        //Se puede instanciar la clase anonima con Lambda
        // Se copia el bloque de argumentos del metodo accept
        // Se agrega el indicador de lambda function y se agrega el return
        FileFilter filterLambda = (File file) -> file.getName().endsWith(".java");

        File dir = new File("E:\\00.Capacitacion\\java-workspace\\java-8-practice\\java8-practice\\src\\main\\java\\lambda\\basics");

        File[] files = dir.listFiles(traditional);
        File[] filesLambda = dir.listFiles(filterLambda);

        for (File f : files){
            System.out.println(f);
        }
        for (File f : filesLambda){
            System.out.println(f);
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };

        //Comparator test
        Comparator<String> comparatorLambda = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());

        List<String> list = Arrays.asList("***", "**", "****", "**");
        Collections.sort(list, comparatorLambda);
        for (String s : list) {
            System.out.println(s);
        }


        //Runnable Test
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Hello world from thread [" + Thread.currentThread().getName() + "]");
                }
            }
        };

        Runnable runnableLambda = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Hello world from thread [" + Thread.currentThread().getName() + "]");
            }
        };

        Thread t = new Thread(runnable);
        t.start();
        t.join();
        Thread t2 = new Thread(runnableLambda);
        t2.start();
        t2.join();
    }
}
