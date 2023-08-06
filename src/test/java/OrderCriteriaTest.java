import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import builder.Order;

class OrderCriteriaTest {
	@Test
	void Order빌더_조건1개_테스트() {
		Order order = Order.builder()
			.asc("age")
			.build();

		System.out.println(order.getQuery());
	}

	@Test
	void Order빌더_조건여러개_테스트() {
		Order order = Order.builder()
			.asc("age")
			.desc("name")
			.desc("no")
			.build();

		Assertions.assertEquals("age ASC, name DESC, no DESC", order.getQuery());
		System.out.println(order.getQuery());
	}
}
