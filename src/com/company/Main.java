package com.company;

public class Main {

    public static void main(String[] args) {
        //Matrix kek = new Matrix(2, 3, 'e');
        //kek.print();
        int[][] lol =  {{1, 2, 4, 1}, {4, 5, 6, 2}, {8, 8, 17, 3}, {1, 2, 3, 4}};
        Matrix keklol = new Matrix(lol);
        Matrix newKeklol = new Matrix(keklol);
        //lol[1][1] = 111;
        Matrix kek = (Matrix) keklol.clone();


        keklol.changeEl(1,1,1111);
        keklol.print();



        newKeklol.print();

        System.out.println("clone");
        kek.print();

        System.out.println(keklol.det());
    }
}
