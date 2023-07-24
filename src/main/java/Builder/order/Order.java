package Builder.order;

import java.util.ArrayList;
import java.util.List;


public class Order {
	List<SortCondition> sortConditions;

	public Order(List<SortCondition> sortConditions) {
		this.sortConditions = sortConditions;
	}

	@Override
	public String toString() {
		String str = "";
		for(SortCondition s : sortConditions) {
			str += s.toString();
		}
		return str;
	}

	public static class OrderBuilder {
		List<SortCondition> sortConditions;

		public OrderBuilder() {
			this.sortConditions = new ArrayList<>();
		}

		public OrderBuilder asc(String column) {
			sortConditions.add(new SortCondition(column, "ASC"));
			return this;
		}

		public OrderBuilder desc(String column) {
			sortConditions.add(new SortCondition(column, "DESC"));
			return this;
		}

		public Order build() {
			return new Order(sortConditions);
		}
	}
}
