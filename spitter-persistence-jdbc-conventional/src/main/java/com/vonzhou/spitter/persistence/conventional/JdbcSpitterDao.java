package com.vonzhou.spitter.persistence.mybatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;


public class JdbcSpitterDao implements
        SpitterDao {
    private DataSource dataSource;

    private static final String SQL_INSERT_SPITTER =
            "insert into spitter (username, password, fullname, email) values (?, ?, ?, ?)";

    private static final String SQL_UPDATE_SPITTER =
            "update spitter set username = ?, password = ?, fullname = ?"
                    + "where id = ?";

    private static final String SQL_SELECT_SPITTER =
            "select id, username, fullname from spitter where id = ?";


    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addSpitter(Spitter spitter) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = dataSource.getConnection();

            stmt = conn.prepareStatement(SQL_INSERT_SPITTER); //<co id="co_createStatement"/>

            stmt.setString(1, spitter.getUsername());//<co id="co_bindParameters"/>
            stmt.setString(2, spitter.getPassword());
            stmt.setString(3, spitter.getFullName());
            stmt.setString(4, spitter.getEmail());

            stmt.execute();//<co id="co_executeStatement"/>
        } catch (SQLException e) {
            // do something...not sure what, though
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {//<co id="co_cleanUp"/>
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // I'm even less sure about what to do here
            }
        }
    }


    /**
     * 如果从ResultSet中获取不存在的字段会发生异常,java.sql.SQLException: Column 'password' not found.
     */
    public Spitter getSpitterById(long id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = dataSource.getConnection();//<co id="co_openConnection"/>

            stmt = conn.prepareStatement(SQL_SELECT_SPITTER);//<co id="co_createStatement"/>

            stmt.setLong(1, id);//<co id="co_bindParameter"/>

            rs = stmt.executeQuery();//<co id="co_executeQuery"/>

            System.out.println(rs);

            Spitter spitter = null;
            if (rs.next()) {
                spitter = new Spitter();
                spitter.setId(rs.getLong("id"));
                spitter.setUsername(rs.getString("username"));
                spitter.setPassword(rs.getString("password"));
                spitter.setFullName(rs.getString("fullname"));
            }
            return spitter;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {//<co id="co_cleanUp"/>
                    rs.close();
                } catch (SQLException e) {
                }
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }

        return null;
    }

    public void saveSpitter(Spitter spitter) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = dataSource.getConnection();

            stmt = conn.prepareStatement(SQL_UPDATE_SPITTER);

            stmt.setString(1, spitter.getUsername());
            stmt.setString(2, spitter.getPassword());
            stmt.setString(3, spitter.getFullName());
            stmt.setLong(4, spitter.getId());

            stmt.execute();
        } catch (SQLException e) {
            // Still not sure what I'm supposed to do here   <co id="co_handleExceptions"/>
        } finally {
            try {
                if (stmt != null) {//<co id="co_cleanUp"/>
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // or here
            }
        }
    }


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
