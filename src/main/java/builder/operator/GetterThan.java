package builder.operator;

public class GetterThan extends Operator {
	private static final String OPERATION = "<";

	public GetterThan(String column, Object value) {
		super(column, OPERATION, value);
	}
}
