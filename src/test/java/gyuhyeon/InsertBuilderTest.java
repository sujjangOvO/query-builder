package gyuhyeon;

import builder.Tables;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static java.util.Map.of;

class InsertBuilderTest {

    @Test
    void sample1() {
        Insert insert = Insert.into(Tables.USER)
                .values(of(
                        "id", 99,
                        "name", "홍길동",
                        "age", 20
                ));

        System.out.println(insert.getQuery());
    }

    @Test
    void sample2() {
        Insert insert = Insert.into(Tables.USER)
                .values(
                        new LinkedHashMap() {{
                            put("id", 99);
                            put("name", "홍길동");
                            put("age", 20);
                        }}
                );

        System.out.println(insert.getQuery());
    }
}
