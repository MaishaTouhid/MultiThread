import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class addremove {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        Runnable addnumber = ()->{
            for( int i = 0 ;i < 100 ; i++){
                list.add(i);
            }

        };
        Runnable removenumber = ()->{
            for(int i = 0; i < 15; i++){
                if(!list.isEmpty()){
                    list.remove(0);
                }
            }

        };
        Thread add = new Thread(addnumber);
        Thread remove = new Thread(removenumber);
        add.start();
        remove.start();
        add.join();
        remove.join();
        System.out.println("list :" + list);
        System.out.println("size :"+ list.size());

    }
}
