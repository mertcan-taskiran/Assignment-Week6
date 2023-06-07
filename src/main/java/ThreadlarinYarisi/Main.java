package ThreadlarinYarisi;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        // 1'den 10000'e kadar olan sayılar ArrayList'e eklendi
        for (int i = 1; i <= 10000; i++) {
            numbers.add(i);
        }

        // 4 eşit parçaya ayırma
        int pieceSize = numbers.size() / 4;
        ArrayList<Integer> piece1 = new ArrayList<>(numbers.subList(0, pieceSize));
        ArrayList<Integer> piece2 = new ArrayList<>(numbers.subList(pieceSize, pieceSize * 2));
        ArrayList<Integer> piece3 = new ArrayList<>(numbers.subList(pieceSize * 2, pieceSize * 3));
        ArrayList<Integer> piece4 = new ArrayList<>(numbers.subList(pieceSize * 3, numbers.size()));

        // Thread oluşturma ve çalıştırma
        Thread t1 = new Thread(new CiftSayilar(piece1));
        Thread t2 = new Thread(new TekSayilar(piece2));
        Thread t3 = new Thread(new CiftSayilar(piece3));
        Thread t4 = new Thread(new CiftSayilar(piece4));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Ortak ArrayList'leri almak
        ArrayList<Integer> ciftSayilar = CiftSayilar.getCiftSayilar();
        ArrayList<Integer> tekSayilar = TekSayilar.getTekSayilar();

        // Çıktıları kontrol etmek
        System.out.println("Çift sayılar: " + ciftSayilar.toString());
        System.out.println("Tek sayılar: " + tekSayilar.toString());

    }
}
