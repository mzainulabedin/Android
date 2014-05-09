package com.sandz.mshopping.manager;

import android.content.Context;
import com.sandz.mshopping.dao.DalManager;
import com.sandz.mshopping.dao.DaoSession;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by mzain on 4/24/2014.
 */
public abstract class BeanManager<T> {
    private AbstractDao<T, Long> dao;
    private Property defaultSort;

    protected Property getDefaultSort() {
        return defaultSort;
    }

    protected void setDefaultSort(Property defaultSort) {
        this.defaultSort = defaultSort;
    }

    public enum SortOrder {ASCENDING, DESCENDING}

    @SuppressWarnings("unchecked")
    public BeanManager(Context context, Class<T> bean){
        DaoSession daoSession = DalManager.getInstance(context.getApplicationContext()).getDaoSession();

        dao = (AbstractDao<T, Long>) daoSession.getDao(bean);
    }

    public T get(long id){
        return dao.load(id);
    }

    public List<T> get(){
        if(defaultSort==null)   {
            return dao.queryBuilder().list();
        }
        else {
            return dao.queryBuilder().orderAsc(defaultSort).list();
        }

    }

    public List<T> get(String orderBy, SortOrder sortOrder) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        Property p = (Property)Class.forName(dao.getClass().getName() + "$Properties").getField(orderBy).get(null);
        if(sortOrder== SortOrder.ASCENDING) {
            return dao.queryBuilder().orderAsc(p).list();
        }
        else {
            return dao.queryBuilder().orderDesc(p).list();
        }
    }


    public void delete(long id) {
        dao.deleteByKey(id);
    }

    public void delete(T bean){
        dao.delete(bean);
    }

    public long insert(T bean){
        return dao.insert(bean);
    }

    public void update(T bean){
        dao.update(bean);
    }

    protected AbstractDao<T, Long> getDao() {
        return dao;
    }
}
