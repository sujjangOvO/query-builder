import domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import builder.Delete;
import builder.Operator;
import builder.Where;

class DeleteCriteriaTest {
    @Test
    void deleteBuilder_test() {
        Delete delete = Delete.from(User.class)
                .build();

        Assertions.assertEquals("DELETE FROM user ", delete.getQuery());
        System.out.println(delete.getQuery());
    }

    @Test
    void deleteBuilder_where_test() {
        Delete delete = Delete.from(User.class)
                .where(
                        Where.builder("age", Operator.Type.GT, 12)
                                .or("no", Operator.Type.LTE, 100)
                                .build()
                )
                .build();

        Assertions.assertEquals("DELETE FROM user WHERE age > 12 OR no <= 100", delete.getQuery());
        System.out.println(delete.getQuery());
    }
}
