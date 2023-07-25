package builder;

import java.util.ArrayList;
import java.util.List;

public class Where {
	private final List<Condition> conditions;

	private Where(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public String toQuery() {

		if (conditions.isEmpty()) {
			return "";
		}

		List<String> queries = new ArrayList<>();

		Condition firstCondition = conditions.get(0);
		String firstConditionQuery = firstCondition.firstQuery();
		queries.add(firstConditionQuery);

		for (int i = 1; i < conditions.size(); i++) {
			Condition condition = conditions.get(i);
			String str = condition.toQuery();
			queries.add(str);
		}

		return String.join(" ", queries);
	}

	public static class Builder {
		private final List<Condition> conditions;

		public Builder() {
			this.conditions = new ArrayList<>();
		}

		public Builder and(Operator operator) {
			Condition condition = Condition.and(operator);
			conditions.add(condition);
			return this;
		}

		public Builder or(Operator operator) {
			Condition condition = Condition.or(operator);
			conditions.add(condition);
			return this;
		}

		public Where build() {
			return new Where(conditions);
		}
	}
}
