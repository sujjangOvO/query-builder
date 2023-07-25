package builder;

public class SortCondition {
	private final String column;
	private final SortType sortRule;

	public SortCondition(String column, SortType sortRule) {
		this.column = column;
		this.sortRule = sortRule;
	}

	public static SortCondition asc(String column) {
		return new SortCondition(column, SortType.ASC);
	}

	public static SortCondition desc(String column) {
		return new SortCondition(column, SortType.DESC);
	}

	public String toQuery() {
		return "%s %s".formatted(column, sortRule.name());
	}

	public enum SortType {
		ASC,
		DESC
		;
	}
}
