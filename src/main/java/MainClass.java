/*/*
Java 3. Многопоточность, часть 1
ДЗ №4:

Студент: Гришин Дмитрий
 */

import java.io.*;

public class MainClass {
    public static void main(String[] args) {
        //Метод с 3-мя потоками построчной записи в файл:
        treeThreadsToFile();

        //Работа МФУ:
        MFU task1 = new MFU(7, 3);
        task1.start();
        MFU task2 = new MFU(3, "print");
        task2.start();
        MFU task3 = new MFU(3, "scan");
        task3.start();

    }

    //метод в котором 3 потока построчно пишут данные в файл:
    public static void treeThreadsToFile(){
        new ForWriteThread("Поток_1").start();
        new ForWriteThread("Поток_2").start();
        new ForWriteThread("Поток_3").start();
    }

    //синхронизированный метод для записи в файл Input.txt
    public synchronized static void writerToFile(String notation){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Input.txt", true))) {
            bw.write(notation + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


