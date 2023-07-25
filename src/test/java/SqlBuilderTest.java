import static builder.Operator.Type.GT;
import static builder.Operator.Type.LTE;

import org.junit.jupiter.api.Test;

import builder.Operator;
import builder.Where;

class SqlBuilderTest {

	@Test
	void Where빌더_조건1개_테스트() {
		Where where = new Where.Builder()
			.and(new Operator("age", GT, 11))
			.build();

		System.out.println(where.toQuery());
	}

	@Test
	void Where빌더_조건여러개_테스트() {
		Where where = new Where.Builder()
			.and(new Operator("age", GT, 11))
			.or(new Operator("no", LTE, 22))
			.build();

		System.out.println(where.toQuery());
	}
}
