import org.junit.jupiter.api.Test;

import builder.Delete;
import builder.Operator;
import builder.Tables;
import builder.Where;

class DeleteBuilderTest {
	@Test
	void deleteBuilder_test() {
		Delete delete = Delete.builder()
			.from(Tables.USER)
			.build();

		System.out.println(delete.getQuery());
	}

	@Test
	void deleteBuilder_where_test() {
		Delete delete = Delete.builder()
			.from(Tables.USER)
			.where(
				Where.builder("age", Operator.Type.GT, 12)
					.or("no", Operator.Type.LTE, 100)
					.build()
			)
			.build();

		System.out.println(delete.getQuery());
	}
}
