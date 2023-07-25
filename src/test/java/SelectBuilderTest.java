import static builder.Operator.Type.*;

import org.junit.jupiter.api.Test;

import builder.Order;
import builder.Select;
import builder.Tables;
import builder.Where;

class SelectBuilderTest {
	@Test
	void selectBuilder_test() {
		Select select = Select.builder()
			.select("age", "no")
			.from(Tables.USER)
			.where(
				Where
					.builder("no", EQ, 2)
					.and("age", GT, 10)
					.build()
			)
			.order(
				Order
					.builder()
					.asc("no")
					.build()
			)
			.build();

		System.out.println(select.getQuery());
	}
}
