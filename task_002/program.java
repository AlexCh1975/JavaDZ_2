/*
 * К калькулятору из предыдущего дз добавить логирование.
 */

package task_002;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.io.FileWriter;

public class program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number: ");
        double num1 = sc.nextDouble();

        
        double res = 0;
        while (true){ 
    
            System.out.print("Input operator: ");
            String op = sc.next();

            if ("=".equals(op)) {
                System.out.print(res);
                logger("Вывод результата " + res);
                break;
            }
            System.out.print("Input number: ");
            double num2 = sc.nextDouble();
            String str = "";
            switch(op){
                case "+":
                    res = num1 + num2;
                    num1 = res;
                    str = num1 + "+" + num2 + "=" + res;
                    logger(str);
                    break;
                case "-":
                    res = num1 - num2;
                    num1 = res;
                    str = num1 + "-" + num2 + "=" + res;
                    logger(str);
                    break;
                case "*":
                    res = num1 * num2;
                    num1 = res;
                    str = num1 + "*" + num2 + "=" + res;
                    logger(str);
                    break;
                case "/":
                    res = num1 / num2;
                    num1 = res;
                    str = num1 + "/" + num2 + "=" + res;
                    logger(str);
                    break;
                }
            System.out.print(res);    
            System.out.print("\n"); 
        }
        sc.close();
    }

    public static void logger(String text){
        try {
            FileWriter log = new FileWriter("log_calc.txt", true);
            log.write(LocalDateTime.now() + " " + text + "\n");
            log.flush();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
