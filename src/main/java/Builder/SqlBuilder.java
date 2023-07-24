package Builder;

import Builder.where.Where;
import Builder.where.WhereBuilder;

public class SqlBuilder {
	public static void main(String[] args) {

		// where
		Where where = new WhereBuilder()
			.and("no", "=", "2")
			.or("age", ">", "11")
			.build();

		System.out.println(where);




	}
}
