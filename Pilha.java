package TrabalhoAlest_CalculadoraExpressões;
public class Pilha<E> {
    private java.util.LinkedList<E> list = new java.util.LinkedList<>();
    
        
    public void push(E element) {
        list.addFirst(element);
    }
    
    public E pop() {
        return list.removeFirst();
    }
    
    public E peek() {
        return list.getFirst();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
}

