import java.util.Scanner;

public class xifrat_cesar {
    static  final int minimumLowercaseValue = 97;
    static final int maximumLowercaseValue = 122;
    static final int lowercaseRangeValue = 26;

    public static void main(String[] args) {

        Scanner inputText = new Scanner(System.in);

        System.out.print("Introduce un texto:");

        String message = inputText.nextLine();
        char[] characterInMessage = message.toCharArray();

        System.out.print("Introduce valor numérico para la clave de cifrado:");
        int encodingKey = getEncodingKey();

        encodeMessage(encodingKey,characterInMessage);

    }
    static int getEncodingKey(){
        Scanner codeKey = new Scanner(System.in);
        boolean valid = false;
        int increase = 0 ;
        while (!valid){
            try {
                increase = codeKey.nextInt();
                valid = true;
            } catch (Exception e){
                System.out.println("se esperaba un número entero");
                codeKey.next();
            }
            //los siguientes while ajustan los enteros fuera del rango de -26 a 26 para que no salgan de rango
        }while (increase < Math.negateExact(lowercaseRangeValue)){
            increase+=lowercaseRangeValue;
        }while (increase > lowercaseRangeValue){
            increase-=lowercaseRangeValue;
        }
        return increase;
    }

    static void encodeMessage( int increase,char[] characterInMessage){
        for (int i = 0; i < characterInMessage.length; i++ ){

            if (characterInMessage[i] >= minimumLowercaseValue && characterInMessage[i] <= maximumLowercaseValue) {

                characterInMessage[i] += (char) increase;
                //Los siguientes if ajustan los valores de los caracteres para que no salgan del rango deseado
                if (characterInMessage[i] > maximumLowercaseValue) characterInMessage[i]-=lowercaseRangeValue;
                if (characterInMessage[i] < minimumLowercaseValue) characterInMessage[i]+=lowercaseRangeValue;

            }
            System.out.print(characterInMessage[i]);
        }
    }
}