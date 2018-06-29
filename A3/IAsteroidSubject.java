public interface IAsteroidSubject {

	public void Attach(BoardComponent observer);
	public void Detach(BoardComponent observer);
	public void Notify(BoardComponent observer);
}
