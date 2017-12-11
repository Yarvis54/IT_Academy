package com.jcourse.Evdokimov.s1;

import java.util.Random;

/**
 * Created by Pavel on 25.11.2017.
 */
public class Game {
    public static void main(String[] args) {
        Visualize vis = new Visualize();
        int qInt = new Random().nextInt(99)+1;
        int readInt;
        int step;

        for(step=0;step<8;step++) {
            vis.showMess("Ввдите ваш вариант:");
            readInt = vis.readInt();
            if(readInt == qInt) break;
            else if(qInt < readInt) vis.showMess("Загаданое число меньше.");
            else vis.showMess("Загаданое число больше.");
        }
        if(step == 8)vis.showMess("К сожадению вы не отгадали. Было загадано число: "+qInt);
        else
            vis.showMess("Поздравляем! Вы угадали число!");
    }
}
