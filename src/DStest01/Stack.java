package DStest01;

import java.util.EmptyStackException;

public class Stack {
    private int maxTop;      // Stack'in maksimum büyüklüğü
    private int top;          // Stack'in en üstündeki elemanın indeksi
    private char[] values;    // Stack'in elemanlarını içeren dizi

    // Stack constructor
    public Stack(int size) {
        maxTop = size - 1;
        values = new char[size];
        top = -1;  // Başlangıçta stack boş olduğu için top -1
    }

    // Stack boş mu kontrolü
    public boolean isEmpty() {
        return top == -1;
    }

    // Stack dolu mu kontrolü
    public boolean isFull() {
        return top == maxTop;
    }

    // Stack'in en üstündeki elemanı döndürme
    public char top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return values[top];
        }
    }

    // Stack'e eleman ekleme
    public void push(char x) {
        if (isFull()) {
            System.out.println("Error: Stack is full.");
        } else {
            top++;
            values[top] = x;
        }
    }

    // Stack'ten eleman çıkarma
    public char pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            char temp = values[top];
            top--;
            return temp;
        }
    }

    // Stack'teki tüm elemanları ekrana bastırma
    public void displayStack() {
        System.out.print("top -->");
        for (int i = top; i >= 0; i--) {
            System.out.print("\t|\t" + values[i] + "\t|\n");
        }
        System.out.println("\t|---------------|");
    }

    public static void main(String[] args) {
        // Örnek kullanım

        // Stack oluşturma
        Stack stack = new Stack(5);

        // Stack'e eleman ekleme
        stack.push('[');
        stack.push('(');
        stack.push(')');
        stack.push(']');

        // Stack'teki elemanları ekrana bastırma
        stack.displayStack();

        // Stack'in en üstündeki elemanı ekrana yazdırma
        System.out.println("Top: " + stack.top());

        // Stack'ten eleman çıkarma
        stack.pop();

        // Stack'in güncellenmiş hali
        stack.displayStack();
    }
}
