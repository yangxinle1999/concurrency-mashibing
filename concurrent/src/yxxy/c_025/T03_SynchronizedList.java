package yxxy.c_025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T03_SynchronizedList {
    List<String> srts=new ArrayList<>();
    List<String> strsSync= Collections.synchronizedList(srts);
}
