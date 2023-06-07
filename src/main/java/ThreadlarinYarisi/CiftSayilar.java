package ThreadlarinYarisi;

import java.util.ArrayList;

public class CiftSayilar implements Runnable {
    private ArrayList<Integer> numbers;
    private static ArrayList<Integer> ciftSayilar = new ArrayList<>();

    public CiftSayilar(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public static ArrayList<Integer> getCiftSayilar() {
        return ciftSayilar;
    }

    @Override
    public void run() {
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                synchronized (ciftSayilar) {
                    ciftSayilar.add(number);
                }
            }
        }
    }
}
