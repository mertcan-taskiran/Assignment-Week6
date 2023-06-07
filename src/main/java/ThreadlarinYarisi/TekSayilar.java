package ThreadlarinYarisi;

import java.util.ArrayList;

public class TekSayilar implements Runnable{
    private ArrayList<Integer> numbers;
    private static ArrayList<Integer> tekSayilar = new ArrayList<>();

    public TekSayilar(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public static ArrayList<Integer> getTekSayilar() {
        return tekSayilar;
    }

    @Override
    public void run() {
        for (Integer number : numbers){
            if (number % 2 == 1){
                synchronized (tekSayilar){
                    tekSayilar.add(number);
                }
            }
        }
    }
}
