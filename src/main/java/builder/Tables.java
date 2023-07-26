package builder;

public enum Tables {
	USER,
	PRODUCT
	;

	public String getTableName() {
		return this.name().toLowerCase();
	}
}
