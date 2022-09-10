import java.util.Scanner;

public class RtoI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(rtoi(s));
        System.out.println("Hello world!");
    }


    public static int rtoi(String s){
        char[] symbol = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        String [][] symbols = new String[7][7];
        fillsymbol(symbol,symbols);
        int[] value = {1, 5, 10, 50, 100, 500, 1000};
        int[][] values = new int[7][7];
        fillvalue(value,values);
        int num = 0;
        int x = s.length()%2 == 0 ? 0:1;
        for(int i = (s.length()-x)/2; i > 0; i--){
            for(int j = 0; j < 7; j++){
                for(int k = 0; k < 7; k++){
                    if ((2*i - 1*x>=0) &&((s.charAt(2*i - 1*x) + "" + s.charAt(2*i - 1*(x-1))).compareTo(symbols[j][k]) == 0)){
                        num += values[j][k];
                    }
                }
                if((x == 1)&&(s.charAt(0)==symbol[j])){
                    num += value[j];
                }
            }
        }



        return num;
    }
    public static void fillsymbol(char[] symbol,String[][] symbols){
        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++){
                symbols[i][j] = symbol[i]+""+symbol[j];
            }
        }
    }
    public static void fillvalue(int[] value,int[][] values){
        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++){
                values[i][j] = value[i] < value[j] ? value[j]-value[i]:value[j]+value[i];
            }
        }
    }
}