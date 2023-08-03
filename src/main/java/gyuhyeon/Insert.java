package gyuhyeon;

import builder.Tables;

import java.util.Map;

public class Insert {
    private final Tables table;
    private Map<String, Object> values;
    private final String query;

    public Insert(Tables table, Map<String, Object> values) {
        this.table = table;
        this.values = values;
        this.query = generateQuery();
    }

    private String generateQuery() {
        var columSet = this.values.entrySet()
                .stream()
                .map(Map.Entry::getKey)
                .toList();

        var valueSet = this.values.entrySet().stream()
                .map(Map.Entry::getValue)
                .map(value -> {
                    if (value instanceof String) {
                        return String.format("\'%s\'", value);
                    }

                    return value.toString();
                })
                .toList();

        String columns = String.join(", ", columSet);
        String values = String.join(", ", valueSet);

        return "INSERT INTO %s (%s) VALUES (%s)".formatted(this.table.getTableName(), columns, values);
    }

    public String getQuery() {
        return this.query;
    }

    public static InsertCriteria into(Tables table) {
        return new InsertCriteria(table);
    }

    public static class InsertCriteria {
        private final Tables table;

        private InsertCriteria(Tables table) {
            this.table = table;
        }

        public Insert values(Map<String, Object> values) {
            return new Insert(table, values);
        }
    }
}
