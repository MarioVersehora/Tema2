package com.VersehoraMario.tema2;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore sem = new Semaphore(1);
        MyThread firstDirection = new MyThread(sem, "Nord-South");
        MyThread secondDirection = new MyThread(sem, "West-East");

        firstDirection.start();
        secondDirection.start();

        firstDirection.join();
        secondDirection.join();

        System.out.println("Number of cars that managed to pass: " + Shared.count);
    }
}
