package builder.operator;

public abstract class Operator {

	private final String column;
	private final String operator;
	private final Object value;

	protected Operator(String column, String operator, Object value) {
		this.column = column;
		this.operator = operator;
		this.value = value;
	}

	public String toQuery() {
		return String.format("%s %s %s", column, operator, value);
	}
}
