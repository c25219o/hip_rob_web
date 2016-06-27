package jp.co.opst.hip_rob.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by YuiIshino on 2016/06/27.
 */
@Repository
public class WordListDao {

    private static final String SELECT_ALL = "select * from word_list";

    @Autowired
    private NamedParameterJdbcTemplate template;

    BeanPropertyRowMapper<String> wordMapper = new BeanPropertyRowMapper<String>() {
        @Override
        public String mapRow(ResultSet rs, int row) throws SQLException {
            return rs.getString("word");
        }
     };

    public List<String> all() {
        return template.query(SELECT_ALL, wordMapper);
    }
}
