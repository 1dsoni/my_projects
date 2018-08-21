import java.util.Scanner;

public class RLE{
    public static void main(String[] a){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String b[] = s.split(" ");

        int val =0;

        for (int i =0; i<b.length; i++){

            Boolean zero = true;

            for (char c : b[i].toCharArray()){

                val = (int)c - 64;
                if (zero){
                    for (int j =0;j<val; j++){
                        System.out.print(0);
                    }

                    zero=false;
                }
                else {
                    for (int j =0;j<val; j++){
                        System.out.print("!");
                    }
                    zero=true;
                }

            }
			System.out.println();
        }

    }
}