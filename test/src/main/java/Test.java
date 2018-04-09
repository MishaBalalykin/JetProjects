import java.lang.annotation.Annotation;

public class Test{
    public static void main(String[] args) {
        Class clazz = Singleton.class;

        Annotation[] annotations = clazz.getAnnotations();

        for (Annotation a : annotations)
            System.out.print("@" + a.annotationType().getSimpleName() + " ");
        System.out.println();



        /*OneNodeList oneNodeList = new OneNodeList();
        oneNodeList.invertAll(oneNodeList);
        oneNodeList.invertAll(oneNodeList);
        System.out.println(oneNodeList.toString());*/
    }

}
