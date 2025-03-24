import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Test {
  static public void testMyArrayList(){
    MyArrayList<Number> myArrayList = new MyArrayList<Number>(8);

    myArrayList.add(9);
    myArrayList.add(8);
    myArrayList.add(7);
    myArrayList.add(6);
    myArrayList.add(5);
    myArrayList.add(4);
    myArrayList.add(3);
    myArrayList.add(2);
    myArrayList.add(1);
    boolean isRemoved = myArrayList.remove(Integer.valueOf(2));
    out.println("isRemoved: " + isRemoved);
    Number removedElement = myArrayList.remove(1);
    myArrayList.add(3, 10);

    out.println("removedElement: " + removedElement);
    out.println("myArrayList: " + myArrayList);
    out.println("myArrayList size: " + myArrayList.size());
    out.println("myArrayList[1]: " + myArrayList.get(1));

    MyArrayList<Object> myArrayList2 = new MyArrayList<Object>();
    out.println("myArrayList2: " + myArrayList2);

    MyArrayList<Object> myArrayList3 = new MyArrayList<Object>(List.of(1, 2, 3, 4));
    out.println("myArrayList3: " + myArrayList3);
  }
}
