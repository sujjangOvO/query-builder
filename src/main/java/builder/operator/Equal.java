package builder.operator;

public class Equal extends Operator {
	private static final String OPERATION = "=";

	public Equal(String column, Object value) {
		super(column, OPERATION, value);
	}

}
