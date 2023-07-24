package Builder.where;

public class Condition {
	String column;
	String operation;
	String value;
	String logic_operation;

	public Condition(String column, String operation, String value, String logic_operation) {
		this.column = column;
		this.operation = operation;
		this.value = value;
		this.logic_operation = logic_operation;
	}

	@Override
	public String toString() {
		return logic_operation + " " + column + " " + operation + " " + value + " ";
	}
}
