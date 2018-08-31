package jads.two.home;

public class Second {
    public static void main(String[] args) {
        Array arr = new Array(20);
        arr.append(1); arr.append(7);
        arr.append(-5); arr.append(2);
        arr.append(7); arr.append(3);
        arr.append(7); arr.append(0);
        System.out.println(arr);
        arr.deleteAll(7);
        arr.pigeon();
        System.out.println(arr);
    }
}
