package Builder.where;

import java.util.ArrayList;
import java.util.List;

public class WhereBuilder {

	private List<Condition> conditions;

	public WhereBuilder() {
		this.conditions = new ArrayList<>();
	}

	public WhereBuilder and(String col, String operation, String value) {
		conditions.add(new Condition(col, operation, value, "AND"));
		return this;
	}

	public WhereBuilder or(String col, String operation, String value) {
		conditions.add(new Condition(col, operation, value, "OR"));
		return this;
	}

	public Where build() {
		return new Where(conditions);
	}
}
