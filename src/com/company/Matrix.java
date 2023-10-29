package com.company;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class Matrix implements Cloneable {
    private int[][] matrix;
    private int row;
    private int clmn;

    public Matrix(int[][] matrix) {
        this.row = matrix.length;
        this.clmn = matrix[0].length;
        this.matrix = matrix.clone();
        for (int i = 0; i < this.row; i++) {
            this.matrix[i] = matrix[i].clone();
        }
    }

    public Matrix(int row, int clmn, char flag) {
        this.row = row;
        this.clmn = clmn;
        this.matrix = new int[row][clmn];


        if (flag == 'r') {

            Random rand = new Random();
            for (int i = 0; i < this.row; i++) {
                for (int j = 0; j < this.clmn; j++) {
                    this.matrix[i][j] = rand.nextInt(10);
                }
            }
        } else if (flag == 'e') {
            Scanner scan = new Scanner(System.in);
            for (int i = 0; i < this.row; i++) {

                System.out.println("enter the " + i + 1 + " line");

                String line = scan.nextLine();
                String[] nums = line.split(" ");

                int[] numsInt = new int[this.clmn];
                for (int j = 0; j < clmn; j++) {
                    numsInt[j] = Integer.parseInt(nums[j]);
                }

                for (int j = 0; j < clmn; j++) {
                    this.matrix[i][j] = numsInt[j];
                }


            }
            scan.close();
        }

    }

    public Matrix(Matrix matrix) {
        this.row = matrix.matrix.length;
        this.clmn = matrix.matrix[0].length;

        this.matrix = matrix.matrix.clone();
        for (int i = 0; i < this.row; i++) {
            this.matrix[i] = matrix.matrix[i].clone();
        }
    }

    public void changeEl(int i, int j, int el) {

        this.matrix[i][j] = el;
    }

    public int det() {
        int s = 0;

        if (this.row == 1 && this.clmn == 1) {
            return this.matrix[0][0];
        } else {
            int[][] newArr = new int[this.row - 1][this.clmn - 1];


            for (int k = 0; k < this.clmn; k++) {
                for (int i = 1; i < this.row; i++) {

                    for (int j = 0; j < this.clmn; j++) {

                        if (j != k) {

                            int z = j;

                            while (z < k) {
                                newArr[i - 1][z] = this.matrix[i][j];
                                z++;
                            }

                            while (z < this.clmn) {
                                newArr[i - 1][z - 1] = this.matrix[i][j];
                                z++;
                            }

                        }
                    }
                }
                Matrix kek = new Matrix(newArr);
                s += Math.pow(-1, k) * this.matrix[0][k] * kek.det();
            }
        }
        return s;
    }

    public void print() {
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.clmn; j++) {
                System.out.print(this.matrix[i][j] + (j == this.clmn - 1 ? "" : " "));
            }
            System.out.println();
        }
    }

    @Override
    public Object clone() {
        Matrix temp = null;
        try {
            temp = (Matrix) super.clone();
            temp.matrix = this.matrix.clone();
            for(int i = 0; i < this.row; i++) {
                temp.matrix[i] = this.matrix[i].clone();
            }

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return temp;
    }
}
