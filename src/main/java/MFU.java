public class MFU extends Thread{

    private int docPagesToPrint;
    private int docPagesToScan;


    public MFU(int docPagesTo, String typeTask) {
        if(typeTask.equalsIgnoreCase("print")){
            this.docPagesToPrint = docPagesTo;
            this.docPagesToScan = 0;
        } else {
            this.docPagesToPrint = 0;
            this.docPagesToScan = docPagesTo;
        }
    }

    public MFU(int docPagesToPrint, int docPagesToScan) {
        this.docPagesToPrint = docPagesToPrint;
        this.docPagesToScan = docPagesToScan;
    }

    @Override
    public void run() {
        print(docPagesToPrint);
        scan(docPagesToScan);
    }

    public static synchronized void print(int pagesToPrint){

        if (pagesToPrint == 0){
            System.out.println("Заданий на печать нет");
        } else {
            System.out.print("Отпечатано страниц: ");
            for (int i = 1; i <= pagesToPrint; i++) {
                try{
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(i + "/ ");
            }
            System.out.println();
        }
    }

    public static synchronized void scan(int pagesToScan){

        if (pagesToScan <= 0){
            System.out.println("Заданий на сканирование нет");
        } else {
            System.out.print("Отсканировано страниц: ");
            for (int i = 1; i <= pagesToScan; i++) {
                try{
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(i + "/ ");
            }
            System.out.println();
        }

    }
}
