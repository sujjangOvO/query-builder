package Builder;

import Builder.Where.Where;
import Builder.Where.WhereBuilder;

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
