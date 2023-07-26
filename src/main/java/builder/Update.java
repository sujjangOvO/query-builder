package builder;

public class Update {
	private final Tables table;
	private final Operator operator;
	private final Where where;
	private final String query;

	public Update(Tables table, Operator operator, Where where) {
		this.table = table;
		this.operator = operator;
		this.where = where;
		this.query = generateQuery();
	}

	private String generateQuery() {
		String whereQuery = where == null ? "" : String.format(" WHERE %s", where.getQuery());
		return "UPDATE %s SET %s".formatted(this.table.getTableName(), operator.getQuery()) + whereQuery;
	}

	public String getQuery() {
		return this.query;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private Tables table;
		private Operator operator;
		private Where where;

		private Builder() {
			this.where = null;
		}

		public Builder update(Tables table) {
			this.table = table;
			return this;
		}

		public Builder set(String column, Object value) {
			this.operator = new Operator(column, Operator.Type.EQ, value);
			return this;
		}

		public Builder where(Where where) {
			this.where = where;
			return this;
		}

		public Update build() {
			return new Update(table, operator, where);
		}
	}
}
