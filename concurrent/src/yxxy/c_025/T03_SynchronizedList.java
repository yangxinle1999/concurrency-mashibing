package yxxy.c_025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T03_SynchronizedList {
    List<String> srts=new ArrayList<>();
    List<String> strsSync= Collections.synchronizedList(srts);//为每个方法上面加了一个Synchronized，使他成为并发安全的
}
