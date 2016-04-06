package com.vonzhou.spitter.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SimpleJdbcTemplateSpitterDao implements SpitterDao {

    private SimpleJdbcTemplate jdbcTemplate;


    private static final String SQL_INSERT_SPITTER =
            "insert into spitter (username, password, fullname, email, update_by_email) values (?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE_SPITTER =
            "update spitter set username = ?, password = ?, fullname = ?, set email=?"
            + "where id = ?";

    private static final String SQL_SELECT_SPITTER = ""
            + "select id, username, password, fullname from spitter";

    private static final String SQL_SELECT_SPITTER_BY_ID = SQL_SELECT_SPITTER
            + " where id=?";


    public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Spitter getSpitterById(long id) {
        return jdbcTemplate.queryForObject(
                SQL_SELECT_SPITTER_BY_ID,
                new ParameterizedRowMapper<Spitter>() {
                    public Spitter mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        Spitter spitter = new Spitter();
                        spitter.setId(rs.getLong(1));
                        spitter.setUsername(rs.getString(2));
                        spitter.setPassword(rs.getString(3));
                        spitter.setFullName(rs.getString(4));
                        return spitter;
                    }
                },
                id
        );
    }

    public void addSpitter(Spitter spitter) {
        jdbcTemplate.update(SQL_INSERT_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail(),
                spitter.isUpdateByEmail());
        System.out.println("Counts:" + queryForIdentity());
//        spitter.setId(queryForIdentity());
    }

    public void saveSpitter(Spitter spitter) {
        jdbcTemplate.update(SQL_UPDATE_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail(),
                spitter.getId());
    }

    public List<Spittle> getRecentSpittle() {
        // TODO Auto-generated method stub
        return null;
    }

    public void saveSpittle(Spittle spittle) {
        // TODO Auto-generated method stub

    }


    // queryForLong的参数是一sql语句
    private long queryForIdentity() {
        return jdbcTemplate.queryForLong("select count(*) from spitter;");
    }

    public List<Spittle> getSpittlesForSpitter(
            Spitter spitter) {
        // TODO Auto-generated method stub
        return null;
    }


    public Spitter getSpitterByUsername(String username) {
        // TODO Auto-generated method stub
        return null;
    }

    public void deleteSpittle(long id) {
        throw new UnsupportedOperationException();
    }

    public Spittle getSpittleById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Spitter> findAllSpitters() {
        // TODO Auto-generated method stub
        return null;
    }
}
