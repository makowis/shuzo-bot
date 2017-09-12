package db.migration;

import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class V3_1__insert_word_positive_negative implements SpringJdbcMigration {


    @Override
    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream("db/migration/seed/pn.csv.m3.120408.trim")))) {

            String str;
            while ((str = br.readLine()) != null) {
                String[] split = str.split("\t"); // タブで分割
                if (split.length > 1) {
                    String sql = "REPLACE INTO WordPositiveNegative(word, score) VALUES (?,?)";

                    String emotion = split[1].trim(); // p or e or n
                    if (emotion.equals("p")) {
                        jdbcTemplate.update(sql,split[0].trim(),1);
                    } else if (emotion.equals("n")) {
                        jdbcTemplate.update(sql,split[0].trim(),-1);
                    }
                }
            }
        }
    }
}
