package org.example.model.dao.impl;

import org.example.db.DB;
import org.example.db.DbException;
import org.example.model.dao.DepartmentDao;
import org.example.model.entities.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBCImpl implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBCImpl(Connection connection) {
        conn = connection;
    }

    @Override
    public void insert(Department obj) {

    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT department.*,department.Name as DepName " +
                            "FROM department " +
                            "WHERE department.Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if (rs.next()) {

                Department dep = instantiateDepartment(rs);

                return dep;
            } else {
                throw new DbException("Error: Id not found");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatment(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public List<Department> findAll() {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {            st = conn.prepareStatement(
                "SELECT department.*,department.Name as DepName " +
                        "FROM  department " +
                        "where department.Id");

            rs = st.executeQuery();

            List<Department> list = new ArrayList<>();
//            Map<Integer, Department> map = new HashMap<>();


            while (rs.next()) {
//                Department dep = map.get(rs.getInt("DepartmentId"));
//                if (Objects.isNull(dep)) {
//
//                    dep = instantiateDepartment(rs);
//                    map.put(rs.getInt("DepartmentId"), dep);
//                }

                Department dep = instantiateDepartment(rs);
                list.add(dep);
            }
            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatment(st);
            DB.closeResultSet(rs);
        }
    }

    private static Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();

        dep.setId(rs.getInt("Id"));
        dep.setName(rs.getString("Name"));
        return dep;
    }
}
