public interface TabelaHash {
    public void insert(Integer element);
	public void remove(Integer element) throws Exception;
	public Integer search(Integer element) throws Exception;
	public String print();
}
