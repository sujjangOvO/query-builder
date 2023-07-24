package Builder;

import Builder.order.Order;
import Builder.where.Where;

public class SqlBuilder {
	public static void main(String[] args) {

		// where
		Where where = new Where.WhereBuilder()
			.and("id", "=", "2")
			.or("age", ">", "11")
			.build();

		System.out.println(where);


		// order
		Order order = new Order.OrderBuilder()
			.asc("age")
			.desc("name")
			.build();

		System.out.println(order);

	}
}
