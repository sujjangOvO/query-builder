import static builder.Operator.Type.EQ;
import static builder.Operator.Type.GT;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import builder.Tables;
import builder.Update;
import builder.Where;

class UpdateBuilderTest {

	@Test
	void 조건없는_updateBuilder_test() {
		Update update = Update.builder()
			.update(Tables.PRODUCT)
			.set("price", 10000)
			.build();

		Assertions.assertEquals("UPDATE product SET price = 10000", update.getQuery());
		System.out.println(update.getQuery());
	}

	@Test
	void 조건1개_updateBuilder_test() {
		Update update = Update.builder()
			.update(Tables.PRODUCT)
			.set("price", 10000)
			.where(
				Where.builder("name", EQ, "의자")
					.build()
			)
			.build();

		Assertions.assertEquals("UPDATE product SET price = 10000 WHERE name = 의자", update.getQuery());
		System.out.println(update.getQuery());
	}

	@Test
	void 조건여러개_updateBuilder_test() {
		Update update = Update.builder()
			.update(Tables.PRODUCT)
			.set("price", 10000)
			.where(
				Where.builder("name", EQ, "의자")
					.and("id", GT, 2)
					.build()
			)
			.build();

		Assertions.assertEquals("UPDATE product SET price = 10000 WHERE name = 의자 AND id > 2", update.getQuery());
		System.out.println(update.getQuery());
	}
}
