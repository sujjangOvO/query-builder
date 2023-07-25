package builder;

public class Operator {
	private final String column;
	private final Type type;
	private final Object value;

	public Operator(String column, Type type, Object value) {
		this.column = column;
		this.type = type;
		this.value = value;
	}

	public String toQuery() {
		return "%s %s %s".formatted(column, type.getSymbol(), value);
	}

	public enum Type {
		EQ("="),
		NEQ("!="),
		GT(">"),
		GTE(">="),
		LT("<"),
		LTE("<=");

		private String symbol;

		Type(String symbol) {
			this.symbol = symbol;
		}

		public String getSymbol() {
			return symbol;
		}
	}
}
