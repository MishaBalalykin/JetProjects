public class Test{
    public static void main(String[] args) {
        Singleton.class.getAnnotations();
        OneNodeList oneNodeList = new OneNodeList();
        oneNodeList.invertAll(oneNodeList);
        oneNodeList.invertAll(oneNodeList);
        System.out.println(oneNodeList.toString());
    }

}
