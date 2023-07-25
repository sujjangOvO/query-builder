package builder;

import java.util.ArrayList;
import java.util.List;


public class Order {
	private static final String DESC = "DESC";
	private static final String ASC = "ASC";
	private final List<SortCondition> sortConditions;

	private Order(List<SortCondition> sortConditions) {
		this.sortConditions = sortConditions;
	}

	public String toQuery() {
		List<String> queries = new ArrayList<>();
		for(SortCondition sortCondition: sortConditions) {
			queries.add(sortCondition.toQuery());
		}

		return String.join(", ", queries);
	}

	public static class Builder {
		private final List<SortCondition> sortConditions;

		public Builder() {
			this.sortConditions = new ArrayList<>();
		}

		public Builder asc(String column) {
			SortCondition asc = SortCondition.asc(column);
			sortConditions.add(asc);
			return this;
		}

		public Builder desc(String column) {
			SortCondition desc = SortCondition.desc(column);
			sortConditions.add(desc);
			return this;
		}

		public Order build() {
			return new Order(sortConditions);
		}
	}
}
