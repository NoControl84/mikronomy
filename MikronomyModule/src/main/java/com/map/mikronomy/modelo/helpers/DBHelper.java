package com.map.mikronomy.modelo.helpers;

/**
 * Created by Mikel on 31/07/2014.
 */
public class DBHelper {
    public static final String ASCENDING_SORT = "ASC";
    public static final String DESCENDING_SORT = "ASC";

    public static String orderByColumn(String columnName, String typeSort) {
        return String.format("%s %s", columnName, typeSort);
    }
}
