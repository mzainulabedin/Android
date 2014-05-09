package com.sandz.mshopping.dao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import com.sandz.mshopping.beans.Item;

import com.sandz.mshopping.beans.MonthItem;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table MONTH_ITEMS.
*/
public class MonthItemDao extends AbstractDao<MonthItem, Long> {

    public static final String TABLENAME = "MONTH_ITEMS";

    /**
     * Properties of entity MonthItem.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Month = new Property(1, java.util.Date.class, "month", false, "MONTH");
        public final static Property Comment = new Property(2, String.class, "comment", false, "COMMENT");
        public final static Property Quantity = new Property(3, Float.class, "quantity", false, "QUANTITY");
        public final static Property Price = new Property(4, Float.class, "price", false, "PRICE");
        public final static Property Discount = new Property(5, Float.class, "discount", false, "DISCOUNT");
        public final static Property TotalPrice = new Property(6, Float.class, "totalPrice", false, "TOTAL_PRICE");
        public final static Property CreatedOn = new Property(7, java.util.Date.class, "createdOn", false, "CREATED_ON");
        public final static Property ModifiedOn = new Property(8, java.util.Date.class, "modifiedOn", false, "MODIFIED_ON");
        public final static Property ItemId = new Property(9, Long.class, "itemId", false, "ITEM_ID");
    };

    private DaoSession daoSession;

    private Query<MonthItem> item_MonthItemsQuery;

    public MonthItemDao(DaoConfig config) {
        super(config);
    }
    
    public MonthItemDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'MONTH_ITEMS' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'MONTH' INTEGER NOT NULL ," + // 1: month
                "'COMMENT' TEXT," + // 2: comment
                "'QUANTITY' REAL," + // 3: quantity
                "'PRICE' REAL," + // 4: price
                "'DISCOUNT' REAL," + // 5: discount
                "'TOTAL_PRICE' REAL," + // 6: totalPrice
                "'CREATED_ON' INTEGER NOT NULL ," + // 7: createdOn
                "'MODIFIED_ON' INTEGER NOT NULL ," + // 8: modifiedOn
                "'ITEM_ID' INTEGER);"); // 9: itemId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'MONTH_ITEMS'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, MonthItem entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getMonth().getTime());
 
        String comment = entity.getComment();
        if (comment != null) {
            stmt.bindString(3, comment);
        }
 
        Float quantity = entity.getQuantity();
        if (quantity != null) {
            stmt.bindDouble(4, quantity);
        }
 
        Float price = entity.getPrice();
        if (price != null) {
            stmt.bindDouble(5, price);
        }
 
        Float discount = entity.getDiscount();
        if (discount != null) {
            stmt.bindDouble(6, discount);
        }
 
        Float totalPrice = entity.getTotalPrice();
        if (totalPrice != null) {
            stmt.bindDouble(7, totalPrice);
        }
        stmt.bindLong(8, entity.getCreatedOn().getTime());
        stmt.bindLong(9, entity.getModifiedOn().getTime());
 
        Long itemId = entity.getItemId();
        if (itemId != null) {
            stmt.bindLong(10, itemId);
        }
    }

    @Override
    protected void attachEntity(MonthItem entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public MonthItem readEntity(Cursor cursor, int offset) {
        MonthItem entity = new MonthItem( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            new java.util.Date(cursor.getLong(offset + 1)), // month
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // comment
            cursor.isNull(offset + 3) ? null : cursor.getFloat(offset + 3), // quantity
            cursor.isNull(offset + 4) ? null : cursor.getFloat(offset + 4), // price
            cursor.isNull(offset + 5) ? null : cursor.getFloat(offset + 5), // discount
            cursor.isNull(offset + 6) ? null : cursor.getFloat(offset + 6), // totalPrice
            new java.util.Date(cursor.getLong(offset + 7)), // createdOn
            new java.util.Date(cursor.getLong(offset + 8)), // modifiedOn
            cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9) // itemId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, MonthItem entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMonth(new java.util.Date(cursor.getLong(offset + 1)));
        entity.setComment(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setQuantity(cursor.isNull(offset + 3) ? null : cursor.getFloat(offset + 3));
        entity.setPrice(cursor.isNull(offset + 4) ? null : cursor.getFloat(offset + 4));
        entity.setDiscount(cursor.isNull(offset + 5) ? null : cursor.getFloat(offset + 5));
        entity.setTotalPrice(cursor.isNull(offset + 6) ? null : cursor.getFloat(offset + 6));
        entity.setCreatedOn(new java.util.Date(cursor.getLong(offset + 7)));
        entity.setModifiedOn(new java.util.Date(cursor.getLong(offset + 8)));
        entity.setItemId(cursor.isNull(offset + 9) ? null : cursor.getLong(offset + 9));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(MonthItem entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(MonthItem entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "monthItems" to-many relationship of Item. */
    public List<MonthItem> _queryItem_MonthItems(Long itemId) {
        synchronized (this) {
            if (item_MonthItemsQuery == null) {
                QueryBuilder<MonthItem> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.ItemId.eq(null));
                queryBuilder.orderRaw("MONTH ASC");
                item_MonthItemsQuery = queryBuilder.build();
            }
        }
        Query<MonthItem> query = item_MonthItemsQuery.forCurrentThread();
        query.setParameter(0, itemId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getItemDao().getAllColumns());
            builder.append(" FROM MONTH_ITEMS T");
            builder.append(" LEFT JOIN ITEMS T0 ON T.'ITEM_ID'=T0.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected MonthItem loadCurrentDeep(Cursor cursor, boolean lock) {
        MonthItem entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Item item = loadCurrentOther(daoSession.getItemDao(), cursor, offset);
        entity.setItem(item);

        return entity;    
    }

    public MonthItem loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<MonthItem> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<MonthItem> list = new ArrayList<MonthItem>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<MonthItem> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<MonthItem> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}