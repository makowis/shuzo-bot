package db.migration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;

import org.springframework.jdbc.core.JdbcTemplate;

public class V3_2__insert_word_positive_negative implements SpringJdbcMigration {

    @Override
    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream("db/migration/seed/wago.121808.pn")))) {

            String str;
            while ((str = br.readLine()) != null) {
                String[] split = str.split("\t"); // タブで分割
                if (split.length > 1) {
                    String sql = "REPLACE INTO WordPositiveNegative(word, score) VALUES (?,?)";

                    String emotion = split[0].trim(); // p or e or n
                    String word = split[1].replace(" ", "");
                    if (emotion.contains("ポジ")) {
                        jdbcTemplate.update(sql, word, 1);
                    } else if (emotion.contains("ネガ")) {
                        jdbcTemplate.update(sql, word, -1);
                    }
                }
            }
        }
    }
}
