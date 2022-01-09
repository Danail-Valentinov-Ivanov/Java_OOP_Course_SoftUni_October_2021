package E7_Reflection.P2_Black_Box_Integer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Field fieldInnerValue = clazz.getDeclaredField("innerValue");
        fieldInnerValue.setAccessible(true);

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] methodData = input.split("_");
            String methodName = methodData[0];
            int methodParam = Integer.parseInt(methodData[1]);

            Method method = clazz.getDeclaredMethod(methodName, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, methodParam);
            System.out.println(fieldInnerValue.get(blackBoxInt));

            input = scanner.nextLine();
        }
    }
}
