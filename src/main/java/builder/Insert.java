package builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Insert {
	private final Tables table;
	private final List<String> columns;
	private final List<String> values;
	private final String query;

	public Insert(Tables table, List<String> columns, List<String> values) {
		this.table = table;
		this.columns = columns;
		this.values = values;
		this.query = generateQuery();
	}

	private String generateQuery() {
		String columns = String.join(",", this.columns);
		String values = String.join(",", this.values);
		return "INSERT INTO %s(%s) VALUES (%s)".formatted(this.table.getTableName(), columns, values);
	}

	public String getQuery() {
		return this.query;
	}

	public static Builder builder(Tables table) {
		return new Builder(table);
	}

	public static class Builder {
		private Tables table;
		private List<String> columns;
		private List<String> values;

		private Builder(Tables table) {
			this.table = table;
			columns = new ArrayList<>();
			values = new ArrayList<>();
		}

		public Builder column(String... columns) {
			Collections.addAll(this.columns, columns);
			return this;
		}

		public Builder values(String... values) {
			Collections.addAll(this.values, values);
			return this;
		}

		public Insert build() {
			return new Insert(table, columns, values);
		}

	}
}
