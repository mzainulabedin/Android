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

import com.sandz.mshopping.beans.Category;

import com.sandz.mshopping.beans.Item;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table ITEMS.
*/
public class ItemDao extends AbstractDao<Item, Long> {

    public static final String TABLENAME = "ITEMS";

    /**
     * Properties of entity Item.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Description = new Property(2, String.class, "description", false, "DESCRIPTION");
        public final static Property Tags = new Property(3, String.class, "tags", false, "TAGS");
        public final static Property PictureId = new Property(4, String.class, "pictureId", false, "PICTURE_ID");
        public final static Property IsOptional = new Property(5, Boolean.class, "isOptional", false, "IS_OPTIONAL");
        public final static Property CreatedOn = new Property(6, java.util.Date.class, "createdOn", false, "CREATED_ON");
        public final static Property ModifiedOn = new Property(7, java.util.Date.class, "modifiedOn", false, "MODIFIED_ON");
        public final static Property CategoryId = new Property(8, Long.class, "categoryId", false, "CATEGORY_ID");
    };

    private DaoSession daoSession;

    private Query<Item> category_ItemsQuery;

    public ItemDao(DaoConfig config) {
        super(config);
    }
    
    public ItemDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'ITEMS' (" + //
                "'_id' INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "'NAME' TEXT NOT NULL ," + // 1: name
                "'DESCRIPTION' TEXT," + // 2: description
                "'TAGS' TEXT," + // 3: tags
                "'PICTURE_ID' TEXT," + // 4: pictureId
                "'IS_OPTIONAL' INTEGER," + // 5: isOptional
                "'CREATED_ON' INTEGER NOT NULL ," + // 6: createdOn
                "'MODIFIED_ON' INTEGER NOT NULL ," + // 7: modifiedOn
                "'CATEGORY_ID' INTEGER);"); // 8: categoryId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'ITEMS'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Item entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(3, description);
        }
 
        String tags = entity.getTags();
        if (tags != null) {
            stmt.bindString(4, tags);
        }
 
        String pictureId = entity.getPictureId();
        if (pictureId != null) {
            stmt.bindString(5, pictureId);
        }
 
        Boolean isOptional = entity.getIsOptional();
        if (isOptional != null) {
            stmt.bindLong(6, isOptional ? 1l: 0l);
        }
        stmt.bindLong(7, entity.getCreatedOn().getTime());
        stmt.bindLong(8, entity.getModifiedOn().getTime());
 
        Long categoryId = entity.getCategoryId();
        if (categoryId != null) {
            stmt.bindLong(9, categoryId);
        }
    }

    @Override
    protected void attachEntity(Item entity) {
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
    public Item readEntity(Cursor cursor, int offset) {
        Item entity = new Item( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // description
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // tags
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // pictureId
            cursor.isNull(offset + 5) ? null : cursor.getShort(offset + 5) != 0, // isOptional
            new java.util.Date(cursor.getLong(offset + 6)), // createdOn
            new java.util.Date(cursor.getLong(offset + 7)), // modifiedOn
            cursor.isNull(offset + 8) ? null : cursor.getLong(offset + 8) // categoryId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Item entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setDescription(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTags(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPictureId(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setIsOptional(cursor.isNull(offset + 5) ? null : cursor.getShort(offset + 5) != 0);
        entity.setCreatedOn(new java.util.Date(cursor.getLong(offset + 6)));
        entity.setModifiedOn(new java.util.Date(cursor.getLong(offset + 7)));
        entity.setCategoryId(cursor.isNull(offset + 8) ? null : cursor.getLong(offset + 8));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Item entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Item entity) {
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
    
    /** Internal query to resolve the "items" to-many relationship of Category. */
    public List<Item> _queryCategory_Items(Long categoryId) {
        synchronized (this) {
            if (category_ItemsQuery == null) {
                QueryBuilder<Item> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.CategoryId.eq(null));
                queryBuilder.orderRaw("NAME ASC");
                category_ItemsQuery = queryBuilder.build();
            }
        }
        Query<Item> query = category_ItemsQuery.forCurrentThread();
        query.setParameter(0, categoryId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getCategoryDao().getAllColumns());
            builder.append(" FROM ITEMS T");
            builder.append(" LEFT JOIN CATEGORIES T0 ON T.'CATEGORY_ID'=T0.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Item loadCurrentDeep(Cursor cursor, boolean lock) {
        Item entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Category category = loadCurrentOther(daoSession.getCategoryDao(), cursor, offset);
        entity.setCategory(category);

        return entity;    
    }

    public Item loadDeep(Long key) {
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
    public List<Item> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Item> list = new ArrayList<Item>(count);
        
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
    
    protected List<Item> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Item> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
