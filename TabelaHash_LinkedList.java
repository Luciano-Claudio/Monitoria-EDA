import java.util.LinkedList;
import java.util.List;

public class TabelaHash_LinkedList implements TabelaHash {

    private int m;
    private List<Integer>[] tabela;

    public TabelaHash_LinkedList(int m) {
        this.m = m;
        this.tabela = new List[m];

        for (int i = 0; i < m; i++) {
            tabela[i] = new LinkedList<Integer>();
        }
    }

    private int hash(Integer key) {
        return key % m;
    }

    public void insert(Integer element) {
        int hashValue = hash(element);
        tabela[hashValue].add(element);
    }

    public void remove(Integer element) throws Exception {
        int hashValue = hash(element);
        if(!tabela[hashValue].contains(element)){
            throw new Exception("Element not found");
        }
        tabela[hashValue].remove(element);
    }

    public Integer search(Integer element) throws Exception {
        int hashValue = hash(element);
            if (tabela[hashValue].contains(element)) {
                return element;
            }

        throw new Exception("Element not found");
    }

    public String print() {
        String result = "";
        for (int i = 0; i < m; i++) {
            result += i + ": ";
            if (!tabela[i].isEmpty()) {
                Object[] elements = tabela[i].toArray();
                for (int j = 0; j < elements.length; j++) {
                    result += elements[j];
                    if (j < elements.length - 1) {
                        result += ", ";
                    }
                }
            }
            result += "\n";
        }
        return result;
    }
    
}
