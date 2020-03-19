//Line
import java.util.*;

import sun.security.krb5.internal.crypto.crc32;
class Question6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String sort = sc.next();

        int[] width = new int[n];
        int[][] number = new int[n][];
        int max = 0;
        int col = 0;
        int line = 0;
        int row = 0;

        char[][] answer;

        for(int i = 0 ; i < n ; i++){
            width[i] = sc.nextInt();
            if(max < width[i])
                max = width[i];
            number[i] = Arrays.stream(sc.next().split("")).mapToInt(Integer::parseInt).toArray();
            col += (number[i].length * width[i]) + number[i].length;
        }
        // col--;

        answer = new char[2*max-1][col];
        for(int i = 0 ; i < answer.length ; i++)
            for(int j = 0 ; j < answer[i].length ; j++)
                answer[i][j] = '.';
        

        for(int i = 0 ; i < n ; i++) {
            if(sort.equals("TOP"))
                row = 0;
            else if(sort.equals("MIDDLE"))
                row = max - width[i];
            else if(sort.equals("BOTTOM"))
                row = 2 * (max - width[i]);

            for(int j = 0 ; j < number[i].length ; j++) {
                printnumber(number[i][j], answer, line, width[i], row);
                line += width[i];
                for(int k = 0 ; k < answer.length ; k++)
                    answer[k][line] = ' ';
                line++;
            }
        }

        for(char[] c : answer) {
            for(char d : c)
                System.out.print(d);
            System.out.println();
        }
    }

    static void printnumber(int number, char[][] answer, int column, int width, int row) {
        switch(number) {
            case 0 :
                printZero(number, answer, column, width, row);
                break;
            case 1 :
                printOne(number, answer, column, width, row);
                break;
            case 2 :
                printTwo(number, answer, column, width, row);
                break;
            case 3 :
                printThree(number, answer, column, width, row);
                break;
            case 4 :
                printFour(number, answer, column, width, row);
                break;
            case 5 :
                printFive(number, answer, column, width, row);
                break;
            case 6 :
                printSix(number, answer, column, width, row);
                break;
            case 7 :
                printSeven(number, answer, column, width, row);
                break;
            case 8 :
                printEight(number, answer, column, width, row);
                break;
            case 9 :
                printNine(number, answer, column, width, row);
                break;
            default :
                break;

        }
    }

    static void printZero(int number, char[][] answer, int column, int width, int row) {
        for(int i = 0; i < width*2-1 ; i++){
            for(int j = 0 ; j < width ; j++) {
                if(i == 0 || i == width*2-2)
                    answer[i+row][j+column] = '#';
                else {
                    if(j == 0 || j == width-1)
                        answer[i+row][j+column] = '#';
                }
            }
        }
    }

    static void printOne(int number, char[][] answer, int column, int width, int row) {
        for(int i = 0; i < width*2-1 ; i++){
            for(int j = 0 ; j < width ; j++) {
                if(j == width - 1)
                    answer[i+row][j+column] = '#';
            }
        }
    }

    static void printTwo(int number, char[][] answer, int column, int width, int row) {
        for(int i = 0; i < width*2-1 ; i++){
            for(int j = 0 ; j < width ; j++) {
                if(i == 0 || i == width - 1 || i == width*2-2)
                    answer[i+row][j+column] = '#';
                else {
                    if((i > 0 && i < width - 1) && j == width - 1)
                        answer[i+row][j+column] = '#';
                    else if((i > width - 1 && i < width*2 - 2) && j == 0)
                        answer[i+row][j+column] = '#';
                }
            }
        }
    }

    static void printThree(int number, char[][] answer, int column, int width, int row) {
        for(int i = 0; i < width*2-1 ; i++){
            for(int j = 0 ; j < width ; j++) {
                if(i == 0 || i == width - 1 || i == width*2-2)
                    answer[i+row][j+column] = '#';
                else {
                    if(j == width - 1)
                        answer[i+row][j+column] = '#';
                }
            }
        }
    }

    static void printFour(int number, char[][] answer, int column, int width, int row) {
        for(int i = 0; i < width*2-1 ; i++){
            for(int j = 0 ; j < width ; j++) {
                if(i == width - 1)
                    answer[i+row][j+column] = '#';
                else {
                    if((i < width - 1) && (j == 0))
                        answer[i+row][j+column] = '#';
                    else if(j == width - 1)
                        answer[i+row][j+column] = '#';
                }
            }
        }
    }

    static void printFive(int number, char[][] answer, int column, int width, int row) {
        for(int i = 0; i < width*2-1 ; i++){
            for(int j = 0 ; j < width ; j++) {
                if(i == 0 || i == width - 1 || i == width*2-2)
                    answer[i+row][j+column] = '#';
                else {
                    if((i > 0 && i < width - 1) && j == 0)
                        answer[i+row][j+column] = '#';
                    else if((i > width - 1 && i < width*2 - 2) && j == width - 1)
                        answer[i+row][j+column] = '#';
                }
            }
        }
    }

    static void printSix(int number, char[][] answer, int column, int width, int row) {
        for(int i = 0; i < width*2-1 ; i++){
            for(int j = 0 ; j < width ; j++) {
                if(i == width - 1 || i == width*2-2)
                    answer[i+row][j+column] = '#';
                else {
                    if(j == 0)
                        answer[i+row][j+column] = '#';
                    else if((i > width - 1 && i < width*2 - 2) && j == width - 1)
                        answer[i+row][j+column] = '#';
                }
            }
        }
    }

    static void printSeven(int number, char[][] answer, int column, int width, int row) {
        for(int i = 0; i < width*2-1 ; i++){
            for(int j = 0 ; j < width ; j++) {
                if(i == 0)
                    answer[i+row][j+column] = '#';
                else {
                    if(j == width - 1)
                        answer[i+row][j+column] = '#';
                }
            }
        }
    }

    static void printEight(int number, char[][] answer, int column, int width, int row) {
        for(int i = 0; i < width*2-1 ; i++){
            for(int j = 0 ; j < width ; j++) {
                if(i == 0 || i == width - 1 || i == width*2-2)
                    answer[i+row][j+column] = '#';
                else {
                    if(j == 0 || j == width-1)
                        answer[i+row][j+column] = '#';
                }
            }
        }
    }

    static void printNine(int number, char[][] answer, int column, int width, int row) {
        for(int i = 0; i < width*2-1 ; i++){
            for(int j = 0 ; j < width ; j++) {
                if(i == width - 1 || i == 0)
                    answer[i+row][j+column] = '#';
                else {
                    if(j == width - 1)
                        answer[i+row][j+column] = '#';
                    else if((i > 0 && i < width - 1) && j == 0)
                        answer[i+row][j+column] = '#';
                }
            }
        }
    }
}