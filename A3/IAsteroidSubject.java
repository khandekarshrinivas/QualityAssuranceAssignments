public interface IAsteroidSubject {

	// Subscribe an observer to the subject. The observer will be
	// notified when the subject is notified
	public void Attach(BoardComponent observer);

	// Cancel an observer's subscription to the subject. The observer
	// is no longer interested in being notified.
	public void Detach(BoardComponent observer);

	// Notify all observers of the subject that the subject
	// event has happened.
	public void Notify(BoardComponent observer);
}