package builder;

public class Condition {
	private static final String OR = "OR";
	private static final String AND = "AND";

	private final String logicOperation;
	private final Operator operator;

	public String getLogicOperation() {
		return logicOperation;
	}

	private Condition(String logicOperation, Operator operator) {
		this.logicOperation = logicOperation;
		this.operator = operator;
	}

	public static Condition or(Operator operator) {
		return new Condition(OR, operator);
	}

	public static Condition and(Operator operator) {
		return new Condition(AND, operator);
	}

	public String firstQuery() {
		return operator.toQuery();
	}

	public String toQuery() {
		return "%s %s".formatted(logicOperation, operator.toQuery());
	}


}
