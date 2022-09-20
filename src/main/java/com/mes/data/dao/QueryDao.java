package com.mes.data.dao;

public class QueryDao {
    protected String where(String column, String value) {
        String where = "";
        if (value != null && value.trim().length() > 0) {
            where += " and " + column + " = '" + value + "' ";
        }
        return where;
    }

    protected String whereLike(String column, String value) {
        String where = "";
        if (value != null && value.trim().length() > 0) {
            where += " and " + column + " like '%" + value + "%' ";
        }
        return where;
    }

    protected String regexp(String column, String value ){
        String where = "";
        if (value != null && value.trim().length() > 0) {
            where += " or " + column + " regexp (" + value + ") ";
        }
        return where;
    }

    protected String orderBy(String column, String direction) {
        if (direction == null) {
            direction = " desc";
        }
        return " order by " + column + " " + direction;
    }

    protected String minValue(String column, String minValue) {
        String where = "";
        if (minValue != null && minValue.trim().length() > 0) {
            where += " and " + column + " >= CAST('" + minValue + "' AS UNSIGNED) ";
        }
        return where;
    }

    protected String maxValue(String column, String maxValue) {
        String where = "";
        if (maxValue != null && maxValue.trim().length() > 0) {
            where += " and " + column + " <= CAST('" + maxValue + "' AS UNSIGNED) ";
        }
        return where;
    }

    protected String startDate(String column, String startDate) {
        String where = "";
        if (startDate != null && startDate.trim().length() > 0) {
            where += " and DATE(" + column + ") >= DATE('"+ startDate + "')";
        }
        return where;
    }

    protected String endDate(String column, String endDate) {
        String where = "";
        if (endDate != null && endDate.trim().length() > 0) {
            where += " and DATE(" + column + ") <= DATE('"+ endDate + "')";
        }
        return where;
    }

    protected String deleteByIds(String table,String[] ids) {
        String selectedIds = "";
        for (int i = 0; i < ids.length; i++) {
            selectedIds += "'" + ids[i] + "'";
            if (i < ids.length - 1) {
                selectedIds += ",";
            }
        }

        String sql = "DELETE FROM "+ table +" WHERE id IN (" + selectedIds + ")";

        return sql;
    }

    protected String deleteChildrenTableByParentTableId(String childrenTable,String fk,String[] ids){
        String selectedIds = "";
        for (int i = 0; i < ids.length; i++) {
            selectedIds += "'" + ids[i] + "'";
            if (i < ids.length - 1) {
                selectedIds += ",";
            }
        }

        String sql = "DELETE FROM "+childrenTable+ " WHERE "+fk+" IN (" +  selectedIds + ")";

        return sql;
    }


}
