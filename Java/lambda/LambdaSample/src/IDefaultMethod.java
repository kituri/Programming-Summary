/**
 * Created by athrun on 2015/10/24.
 */
@FunctionalInterface
public interface IDefaultMethod {
    String getString();


    /*下面两个方法在java8才可以定义*/
    default int getInt(){
        return 1024;
    }
    static boolean isTrue(){
        return true;
    }
}
