package counter;

public class IncrementCommand implements ICommand {

	Counter counter;

	public IncrementCommand(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void execute() {
		counter.increment();
	}

	@Override
	public void unExecute() {
		counter.decrement();
	}

}
