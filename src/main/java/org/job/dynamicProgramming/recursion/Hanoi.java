package org.job.dynamicProgramming.recursion;

public class Hanoi {
    /**
     * 递归方式一
     */
    public void left2Right(int n){
        if (n == 1) {
            System.out.println("Move " + n + " from left to right");
            return;
        }
        left2Mid(n - 1);
        System.out.println("Move " + n + " from left to right");
        mid2Right(n - 1);
    }

    private void mid2Right(int n) {
        if (n == 1) {
            System.out.println("Move " + n + " from mid to right");
            return;
        }
        mid2Left(n - 1);
        System.out.println("Move " + n + " from mid to right");
        left2Right(n - 1);
    }

    private void mid2Left(int n) {
        if (n == 1) {
            System.out.println("Move " + n + " from mid to left");
            return;
        }
        mid2Right(n - 1);
        System.out.println("Move " + n + " from mid to left");
        right2Left(n - 1);
    }

    private void right2Left(int n) {
        if (n == 1) {
            System.out.println("Move " + n + " from right to left");
            return;
        }
        right2Mid(n - 1);
        System.out.println("Move " + n + " from right to left");
        mid2Left(n - 1);
    }

    private void left2Mid(int n) {
        if (n == 1) {
            System.out.println("Move " + n + " from left to mid");
            return;
        }
        left2Right(n - 1);
        System.out.println("Move " + n + " from left to mid");
        right2Mid(n - 1);
    }

    private void right2Mid(int n) {
        if (n == 1) {
            System.out.println("Move " + n + " from right to mid");
            return;
        }
        right2Left(n - 1);
        System.out.println("Move " + n + " from right to mid");
        left2Mid(n - 1);
    }
    /**
     * 递归方式二
     * @param n
     */
    public void HanoiDemo(int n) {
        if (n > 0){
            Hanoi(n, "left", "right", "mid");
        }
    }

    private void Hanoi(int n, String from, String to, String other) {
        if (n == 1) {
            System.out.println("Move " + n + " from " + from + " to " + to);
            return;
        }
        Hanoi(n - 1, from, other, to);
        System.out.println("Move " + n + " from " + from + " to " + to);
        Hanoi(n - 1, other, to, from);
    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.HanoiDemo(3);
        System.out.println("================");
        hanoi.left2Right(3);
    }
}
