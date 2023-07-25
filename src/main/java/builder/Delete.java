package builder;

public class Delete {
	private Tables table;
	private Where where;
	private String query;

	public Delete(Tables table, Where where) {
		this.table = table;
		this.where = where;
		this.query = generateQuery();
	}

	private String generateQuery() {
		String whereQuery = where == null ? "" : "WHERE %s".formatted(where.getQuery());
		return "DELETE FROM %s %s".formatted(getTableName(),whereQuery);
	}

	private String getTableName() {
		return this.table.name().toLowerCase();
	}

	public String getQuery() {
		return this.query;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private Tables table;
		private Where where;

		 private Builder() {
			where = null;
		}

		public Builder from(Tables table) {
			 this.table = table;
			 return this;
		}

		public Builder where(Where where) {
			 this.where = where;
			 return this;
		}

		public Delete build() {
			 return new Delete(table, where);
		}

	}




}
