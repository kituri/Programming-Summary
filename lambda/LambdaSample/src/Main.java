import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("lambda");

        test();
    }

    private static void test() {
        /*Ч����ͬ*/
        printString(() -> "test");
        printString(() -> {return "test";});

        /*Ƕ����*/
        Supplier<Runnable> c1 = () -> () -> { System.out.println("hi"); };
        Supplier<Runnable> c2 = () -> {
            return () -> { System.out.println("hi"); };
        };
    }

    private static void printString(IDefaultMethodSub impl) {
        System.out.println(impl.getString());
    }

    private static void testDefaultMethod() {
        IDefaultMethod defaultMethod = new IDefaultMethod() {
            /*���Բ�ʵ��Default����*/
            @Override
            public String getString() {
                return "getString";
            }
        };
    }

    private static void methodReferenced() {
        //���ַ���Ч����ͬ
        List input = Arrays.asList(new String[]{"apple", "orange", "pear"});
        input.forEach((v) -> System.out.println(v));
        input.forEach(System.out::println);
    }

    public static void runThreadUseLambda() {
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Run!");
        }).start();
    }
}
