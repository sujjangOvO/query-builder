package gyuhyeon;


import builder.Order;
import builder.Where;
import domain.SimpleUser;
import domain.User;
import org.junit.jupiter.api.Test;

import static builder.Operator.Type.EQ;
import static builder.Operator.Type.GT;

class SelectBuilderTest {
	@Test
	void sample() {
		Select select = Select.builder()
			.select(SimpleUser.class)
			.from(User.class)
//			.from(SimpleUser.class) // Entity 타입이 아니라 컴파일 오류
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
