package DStest01;

// Bağlı liste düğümünü temsil eden sınıf
class ListNode {
    int item; // Düğümün içindeki veri
    ListNode next; // Sonraki düğümü gösteren referans
    
    // Parametre almayan yapıcı metod
    public ListNode() {
    }
    
    // Parametre alan yapıcı metod
    public ListNode(int item) {
        this.item = item;
    }
}

// Bağlı listeyi temsil eden sınıf
public class MyLinkedList {
    ListNode head; // Listenin başındaki düğüm

    // Belirli bir indeksteki düğümü bulmayı amaçlayan metot
    private ListNode find(int index) {
        // Bu metotun implementasyonu size bağlı olacak
        // Belirli bir indeksteki düğümü bulma işlemi burada yapılacaktır.
        // Eğer düğüm bulunamazsa null dönebilir.
        // Örnek bir implementasyon:
        // (Dikkat: Bu sadece bir örnektir ve sizin ihtiyaçlarınıza göre uyarlanmalıdır)
        
        ListNode current = head;
        int currentIndex = 0;
        while (current != null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        return current;
    }

    // Belirli bir indekse iki yeni düğüm eklemeyi amaçlayan metot
    public void insert(int index, int newItem1, int newItem2) {
        ListNode newNode1 = new ListNode(newItem1);
        ListNode newNode2 = new ListNode(newItem2);
        
        ListNode node = find(index);

        if (node == null) {
            // Belirli bir indekste düğüm bulunamazsa, yeni düğümler head'in önüne eklenir
            newNode2.next = head;
            newNode1.next = newNode2;
            head = newNode1;
        } else {
            // Belirli bir indekste düğüm bulunursa, yeni düğümler bu indeksin sonrasına eklenir
            newNode2.next = node.next;
            newNode1.next = newNode2;
            node.next = newNode1;
        }
    }

    // Diğer metotlar ve işlemler buraya eklenebilir
}
