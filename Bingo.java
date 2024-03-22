import java.util.Random;

public class Bingo {

    public static void main(String[] args) {
        Random random = new Random();
        
        // Criando array de 100 números aleatórios
        Integer[] numbers100 = new Integer[100];
        for (int i = 0; i < 100; i++) {
            numbers100[i] = random.nextInt(100000000) + 1; // Números de 1 a 100 milhões
        }
        
        // Criando array de 1000 números aleatórios
        Integer[] numbers1000 = new Integer[1000];
        for (int i = 0; i < 1000; i++) {
            numbers1000[i] = random.nextInt(100000000) + 1; // Números de 1 a 100 milhões
        }
        
        // Testando com ArrayList
        //testTabelaHash(new TabelaHash_ArrayList(100), numbers100, "ArrayList (100)");
        //testTabelaHash(new TabelaHash_ArrayList(1000), numbers1000, "ArrayList (1000)");
        
        // Testando com LinkedList
        //testTabelaHash(new TabelaHash_LinkedList(100), numbers100, "LinkedList (100)");
        testTabelaHash(new TabelaHash_LinkedList(1000), numbers1000, "LinkedList (1000)");
        
        // Testando com TreeSet
        //testTabelaHash(new TabelaHash_TreeSet(100), numbers100, "TreeSet (100)");
        //testTabelaHash(new TabelaHash_TreeSet(1000), numbers1000, "TreeSet (1000)");
    }

    private static void testTabelaHash(TabelaHash tabela, Integer[] numbers, String nome) {
        long startTime, endTime;
        
        System.out.println("Inserindo números na tabela hash " + nome);
        startTime = System.nanoTime();
        for (Integer number : numbers) {
            tabela.insert(number);
        }
        endTime = System.nanoTime();
        System.out.println("Tempo de inserção: " + (endTime - startTime) + " nanossegundos");
        
        
        System.out.println("Imprimindo tabela hash " + nome);
        startTime = System.nanoTime();
        System.out.println(tabela.print());
        endTime = System.nanoTime();
        System.out.println("Tempo de impressão: " + (endTime - startTime) + " nanossegundos");
        
        System.out.println("Procurando números na tabela hash " + nome);
        startTime = System.nanoTime();
        for (Integer number : numbers) {
            try {
                tabela.search(number);
            } catch (Exception e) {
                System.out.println("Erro ao procurar número na tabela: " + e.getMessage());
            }
        }
        endTime = System.nanoTime();
        System.out.println("Tempo de busca: " + (endTime - startTime) + " nanossegundos");
        
        System.out.println("Removendo números da tabela hash " + nome);
        startTime = System.nanoTime();
        for (Integer number : numbers) {
            try {
                tabela.remove(number);
            } catch (Exception e) {
                System.out.println("Erro ao remover número na tabela: " + e.getMessage());
            }
        }
        endTime = System.nanoTime();
        System.out.println("Tempo de remoção: " + (endTime - startTime) + " nanossegundos");
        
        System.out.println("----------------------------------------");
    }
}
