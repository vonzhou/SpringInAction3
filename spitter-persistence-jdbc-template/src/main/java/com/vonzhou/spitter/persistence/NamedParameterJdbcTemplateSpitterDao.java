package com.vonzhou.spitter.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class NamedParameterJdbcTemplateSpitterDao implements SpitterDao {
    private SimpleJdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_INSERT_SPITTER =
            "insert into spitter (username, password, fullname) " +
                    "values (:username, :password, :fullname)";

    private static final String SQL_UPDATE_SPITTER =
            "update spitter set username = :username, " +
                    "password = :password, fullname = :fullname " +
                    "where id = ?";

    private static final String SQL_SELECT_SPITTER =
            "select id, username, password, fullname from spitter";

    private static final String SQL_SELECT_SPITTER_BY_ID =
            SQL_SELECT_SPITTER + " where id=?";

    public Spitter getSpitterById(long id) {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("id", id);

        jdbcTemplate.queryForObject(SQL_SELECT_SPITTER_BY_ID,
                new ParameterizedRowMapper<Spitter>() {
                    public Spitter mapRow(ResultSet rs,
                                          int rowNum) throws SQLException {
                        // TODO Auto-generated method stub
                        return null;
                    }
                },
                args);

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
                }, id);
    }

    public void addSpitter(Spitter spitter) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", spitter.getUsername());
        params.put("password", spitter.getPassword());
        params.put("fullname", spitter.getFullName());

        jdbcTemplate.update(SQL_INSERT_SPITTER, params);
//        spitter.setId(queryForIdentity());
    }

    public void saveSpitter(Spitter spitter) {
        jdbcTemplate.update(SQL_UPDATE_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getId());
    }

    //<start id="java_queryForIdentity" />
    private long queryForIdentity() {
        return jdbcTemplate.queryForLong("call identity()");
    }
    //<end id="java_queryForIdentity" />

    public List<Spittle> getRecentSpittle() {
        // TODO Auto-generated method stub
        return null;
    }

    public void saveSpittle(Spittle spittle) {
        // TODO Auto-generated method stub

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
