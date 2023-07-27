import org.junit.jupiter.api.Test;

import builder.Insert;
import builder.Tables;

class InsertBuilderTest {

	@Test
	void insertBuilder_test() {
		Insert insert = Insert.builder(Tables.USER)
			.column("id", "name", "age")
			.values("99", "뉴사람", "1")
			.build();

		System.out.println(insert.getQuery());
	}
}
