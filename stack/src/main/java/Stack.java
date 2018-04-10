import java.util.LinkedList;

/**
 * Implementation of Stack
 * @param <T>
 */
class Stack<T>{
    private LinkedList <T> list = new LinkedList<>();

    /**
     * Add element to stack
     * @param element
     */
    void push(T element) {
        //list.add(0, element);
        list.addFirst(element);
    }

    /**
     * Get and remove element from stack
     * @return
     */
    T poll(){
        /*T t = list.get(0);
        list.remove(0);*/
        return list.removeFirst();
    }

    /**
     * Print elements in stack
     */
    void printStack(){
        System.out.println(list);
    }
}
