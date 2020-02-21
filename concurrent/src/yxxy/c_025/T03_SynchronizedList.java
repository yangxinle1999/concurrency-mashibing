package yxxy.c_025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @version 1.0
 * @create 2020/2/20 13:54
 */
public class T03_SynchronizedList {
    List<String> srts=new ArrayList<>();
    List<String> strsSync= Collections.synchronizedList(srts);
}
