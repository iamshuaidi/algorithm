import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public interface TT {

    default void f(){
        System.out.printf("JJJ");
        CopyOnWriteArrayList<Integer> a = new CopyOnWriteArrayList<>();
        HashMap t =  new HashMap();
    }
}
