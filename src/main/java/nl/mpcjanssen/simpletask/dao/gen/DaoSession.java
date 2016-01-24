package nl.mpcjanssen.simpletask.dao.gen;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import nl.mpcjanssen.simpletask.dao.gen.TodoFile;
import nl.mpcjanssen.simpletask.dao.gen.LogItem;
import nl.mpcjanssen.simpletask.dao.gen.TodoListItem;

import nl.mpcjanssen.simpletask.dao.gen.TodoFileDao;
import nl.mpcjanssen.simpletask.dao.gen.LogItemDao;
import nl.mpcjanssen.simpletask.dao.gen.TodoListItemDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig todoFileDaoConfig;
    private final DaoConfig logItemDaoConfig;
    private final DaoConfig todoListItemDaoConfig;

    private final TodoFileDao todoFileDao;
    private final LogItemDao logItemDao;
    private final TodoListItemDao todoListItemDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        todoFileDaoConfig = daoConfigMap.get(TodoFileDao.class).clone();
        todoFileDaoConfig.initIdentityScope(type);

        logItemDaoConfig = daoConfigMap.get(LogItemDao.class).clone();
        logItemDaoConfig.initIdentityScope(type);

        todoListItemDaoConfig = daoConfigMap.get(TodoListItemDao.class).clone();
        todoListItemDaoConfig.initIdentityScope(type);

        todoFileDao = new TodoFileDao(todoFileDaoConfig, this);
        logItemDao = new LogItemDao(logItemDaoConfig, this);
        todoListItemDao = new TodoListItemDao(todoListItemDaoConfig, this);

        registerDao(TodoFile.class, todoFileDao);
        registerDao(LogItem.class, logItemDao);
        registerDao(TodoListItem.class, todoListItemDao);
    }
    
    public void clear() {
        todoFileDaoConfig.getIdentityScope().clear();
        logItemDaoConfig.getIdentityScope().clear();
        todoListItemDaoConfig.getIdentityScope().clear();
    }

    public TodoFileDao getTodoFileDao() {
        return todoFileDao;
    }

    public LogItemDao getLogItemDao() {
        return logItemDao;
    }

    public TodoListItemDao getTodoListItemDao() {
        return todoListItemDao;
    }

}