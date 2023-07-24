package Builder.order;

public class SortCondition {
	String column;
	String sortRule;

	public SortCondition(String column, String sortRule) {
		this.column = column;
		this.sortRule = sortRule;
	}

	@Override
	public String toString() {
		return column + " " + sortRule + " ";
	}
}
