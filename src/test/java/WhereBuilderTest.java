import static builder.Operator.Type.EQ;
import static builder.Operator.Type.GT;
import static builder.Operator.Type.LTE;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import builder.Where;


class WhereBuilderTest {

	@Test
	void Where빌더_조건1개_테스트() {
		Where where = Where.builder("no", EQ, 2)
			.and("age", GT, 11)
			.build();

		Assertions.assertNotEquals("age > 111111", where.getQuery());
		System.out.println(where.getQuery());
	}

	@Test
	void Where빌더_조건여러개_테스트() {
		Where where = Where.builder("age", GT, 11)
			.or("no", LTE, 22)
			.build();

		System.out.println(where.getQuery());
	}

}
