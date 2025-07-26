package counter;

public class DecrementCommand implements ICommand {

	Counter counter;

	public DecrementCommand(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void execute() {
		counter.decrement();
	}

	@Override
	public void unExecute() {
		counter.increment();
	}

}
