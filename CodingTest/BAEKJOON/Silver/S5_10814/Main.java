package CodingTest.BAEKJOON.Silver.S5_10814;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<People> p = new ArrayList<>();
        p.add(new People(1));
        p.add(new People(3));
        p.add(new People(2));
        Collections.sort(p);

        "ㅗㅑ".compareTo("2");
        People[] pp = new People[3];
        pp[0] = new People(1);
        pp[1] = new People(3);
        pp[2] = new People(2);
        Arrays.sort(pp);
    }
}

class People implements Comparable<People>{
    // 매개변수들
    int age;

    public People(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(People p){
        // 비교구현 ( 들어온 파라미터 p 에 대해 age 로 정렬)
        return this.age - p.age;
    }
}

