import static builder.Operator.Type.*;

import domain.User;
import org.junit.jupiter.api.Test;

import builder.Order;
import builder.Select;
import builder.Where;

class SelectCriteriaTest {
	@Test
	void selectBuilder_test() {
		Select select = Select.builder()
			.select("age", "no")
			.from(User.class)
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
