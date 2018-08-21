public class ForWriteThread extends Thread{
    String str;//строка для записи в файл

    //Конструктор для имени:
    public ForWriteThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            str = this.getName() + " запись_" + i;//формирую строку из имени нити и номера записи
            MainClass.writerToFile(str);//записываю строку из имени нити и номера записи
            try {
                Thread.sleep(20); //засыпает на 20 мс.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
