/*
 * Реализуйте алгоритм сортировки пузырьком числового массива, 
 * результат после каждой итерации запишите в лог-файл.
 */

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class program{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int length = sc.nextInt();
        sc.close();

        // int[] array = new int[]{4, 7, 8, 1, 5, 6};
        int[] array = new int[length];
        for (int i = 0; i < length; i++){
            array[i] = new Random().nextInt(0, 100);
        }
        print(array, "Исходный массив:");
        logger(Arrays.toString(array), "исходный массив");
        
        int maxNum = getMaxNum(array, length); 
        int[] newArray = new int[length]; 
    
        for (int i = 0; i < array.length; i++){
            newArray = changeArray(array, maxNum, length);
            length--;
            maxNum = getMaxNum(array, length);
        }

        print(newArray, "Сортированный массив:");
        
       
    }

    public static int getMaxNum(int[] array, int length){
        int maxNum = array[0];
        for (int i = 0; i < length; i++)
            if (array[i] > maxNum) maxNum = array[i];
        return maxNum;
    }

    public static int[] changeArray(int[] array, int maxNum, int length){
        String str = "";
        for (int i = 0; i < length - 1; i++){
            if (array[i] == maxNum){ 
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                str = Arrays.toString(array);
                logger(str, "сортировка");
            }
        }
        return array; 
               
    }

    public static void logger(String str, String text){
        try{
            FileWriter log = new FileWriter("log.txt", true);
            log.write(LocalDateTime.now() + " " + str + text + "\n");
            log.flush();
        }
        catch (Exception ex){
            System.out.print(ex);
        }
    }

    public static void print(int[] array, String text){
        System.out.println(text);
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.print("\n");
    }
} 