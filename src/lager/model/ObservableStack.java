package lager.model;

import java.util.Observable;
import java.util.Observer;
import java.util.Stack;

/**
 * Anpassung eines Stacks zu einem Observable
 */
public class ObservableStack extends Observable {
	private Stack<Command> commandStack = new Stack<Command>();

	public Command pop() {
		Command command = commandStack.pop();
		this.setChanged();
		this.notifyObservers();
		return command;
	}

	public void push(Command command) {
		commandStack.push(command);
		this.setChanged();
		this.notifyObservers();

	}

	public boolean isEmpty() {
		return commandStack.isEmpty();
	}

	@Override
	public void addObserver(Observer o) {
		super.addObserver(o);
		this.setChanged();
		this.notifyObservers();
	}

	public void clear() {
		commandStack.clear();
	}

}
