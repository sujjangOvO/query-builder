package Builder.where;

import java.util.ArrayList;
import java.util.List;

public class Where {
	private List<Condition> conditions;

	public Where(List<Condition> conditions) {
		this.conditions = conditions;
	}

	@Override
	public String toString() {
		String str = "";
		for(Condition c : conditions) {
			str += c.toString();
		}
		return str;
	}

	public static class WhereBuilder {
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
}
