package CodingTest.BAEKJOON.Silver.S5_10814;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void solution() throws IOException {
        int N = Integer.parseInt(br.readLine());

        People[] people = new People[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i] = new People(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        Arrays.sort(people);
        for (People p : people) {
            bw.write(p.age + " " + p.name + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
        bw.flush();
        bw.close();
    }
}

class People implements Comparable<People>{
    int age;
    String name;

    public People(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(People p) {
        return this.age - p.age;
    }
}

