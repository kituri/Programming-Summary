/**
 * Created by athrun on 2015/10/24.
 */
@FunctionalInterface
public interface IDefaultMethod {
    String getString();


    /*��������������java8�ſ��Զ���*/
    default int getInt(){
        return 1024;
    }
    static boolean isTrue(){
        return true;
    }
}
