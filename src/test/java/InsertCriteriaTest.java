import domain.User;
import org.junit.jupiter.api.Test;

import builder.Insert;

import java.util.HashMap;
import java.util.Map;

class InsertCriteriaTest {

    @Test
    void insertCriteria_test() {
        Map<String, Object> values = new HashMap<>();
        values.put("id", 99);
        values.put("name", "newName");
        values.put("age", 16);

        Insert insert = Insert.into(User.class)
                .values(values)
                .build();

        System.out.println(insert.getQuery());
    }
}
