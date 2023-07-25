import org.junit.jupiter.api.Test;

import builder.Delete;
import builder.Operator;
import builder.Tables;
import builder.Where;

class DeleteBuilderTest {
	@Test
	void DeleteBuilder_Test() {
		Delete delete = Delete.builder()
			.from(Tables.USER)
			.build();

		System.out.println(delete.getQuery());
	}

	@Test
	void DeleteBuilderWithWhere_Test() {
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
