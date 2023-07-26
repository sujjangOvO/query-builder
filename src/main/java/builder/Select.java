package builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Select {
	private final List<String> columns;
	private final Tables table;
	private final Where where;
	private final Order order;
	private final String query;

	private Select(List<String> columns, Tables table, Where where, Order order) {
		this.columns = columns;
		this.table = table;
		this.where = where;
		this.order = order;
		this.query = generateQuery();
	}

	private String generateQuery() {
		String column = String.join(",", this.columns);
		String whereQuery = this.where == null ? "" : String.format(" WHERE %s", this.where.getQuery());
		String orderQuery = this.order == null ? "" : String.format(" ORDER BY %s", this.order.getQuery());

		return "SELECT %s FROM %s".formatted(column, this.table.getTableName() + whereQuery + orderQuery);
	}

	public String getQuery() {
		return this.query;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private final List<String> columns = new ArrayList<>();
		private Tables tables;
		private Where where;
		private Order order;

		private Builder() {
			where = null;
			order = null;
		}

		public Builder select(String... columns) {
			Collections.addAll(this.columns, columns);
			return this;
		}

		public Builder from(Tables table) {
			this.tables = table;
			return this;
		}

		public Builder where(Where condition) {
			this.where = condition;
			return this;
		}

		public Builder order(Order order) {
			this.order = order;
			return this;
		}

		public Select build() {
			return new Select(columns, tables, where, order);
		}
	}
}
