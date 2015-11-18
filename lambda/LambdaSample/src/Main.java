import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

    }

    private static void test() {
        /*效果相同*/
        printString(() -> "test");
        printString(() -> {return "test";});

        /*嵌套型*/
        Supplier<Runnable> c1 = () -> () -> { System.out.println("hi"); };
        Supplier<Runnable> c2 = () -> {
            return () -> { System.out.println("hi"); };
        };
    }

    private static void printString(IDefaultMethodSub impl) {
        System.out.println(impl.getString());

        System.out.println(new IDefaultMethodSub() {
            /*default、static方法不需要实现*/
            @Override
            public String getString() {
                return "";
            }
        });
    }



    private static void threeKind() {
        //三种方法效果相同
        List input = Arrays.asList(new String[]{"影票", "饭票", "生活缴费"});
        /*匿名内部类*/
        input.forEach(new Consumer<String>() {
            @Override
            public void accept(String o) {
                System.out.println(o);
            }
        });
        System.out.println("---------");
        /*Lambda表达式------是匿名内部类的缩写*/
        input.forEach((v) -> System.out.println(v));
        System.out.println("---------");
        /*方法引用------是Lambda表达式的缩写*/
        input.forEach(System.out::println);
    }


}
