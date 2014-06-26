package nl.mpcjanssen.simpletask.task;

import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.ArrayAdapter;

import junit.framework.TestCase;

import java.util.ArrayList;

import nl.mpcjanssen.simpletask.ActiveFilter;
import nl.mpcjanssen.simpletask.remote.FileStoreInterface;

/**
 * Created with IntelliJ IDEA.
 * User: Mark Janssen
 * Date: 21-7-13
 * Time: 12:28
 */

public class TaskBagTest extends TestCase {

    public void testInit() {
        ArrayList<String> lines = new ArrayList<String>();
        lines.add("Test");
        lines.add("Test2");
        TestFileStore testFileStore = new TestFileStore(lines);
        TaskBag tb = new TaskBag(null, testFileStore, null);
        tb.reload();
        assertEquals(2, tb.size());
        assertEquals("Test", tb.getTaskAt(0).inFileFormat());
        assertEquals(0, tb.getContexts(false).size());
    }

    public void testSimpleFilter() {
        ArrayList<String> lines = new ArrayList<String>();
        lines.add("Test");
        lines.add("Test2 @Match");
        TestFileStore testFileStore = new TestFileStore(lines);
        TaskBag tb = new TaskBag(null, testFileStore, null);
        tb.reload();
        ActiveFilter filter = new ActiveFilter();
        ArrayList<String> contexts = new ArrayList<String>();
        contexts.add("NoMatch");
        filter.setContexts(contexts);
        ArrayList<Task> visibleTasks = filter.apply(tb.getTasks());
        assertEquals(0, visibleTasks.size());
        contexts.clear();
        contexts.add("Match");
        filter.setContexts(contexts);
        visibleTasks = filter.apply(tb.getTasks());
        assertEquals(1, visibleTasks.size());
    }

    class TestFileStore implements FileStoreInterface {

        private ArrayList<String> mContents;

        public TestFileStore(ArrayList<String> contents) {
            mContents = contents;
        }

        @Override
        public boolean isAuthenticated() {
            return false;
        }

        @Override
        public ArrayList<String> get(String path, TaskBag.Preferences preferences) {
            return mContents;
        }

        @Override
        public void store(String path, String data) {

        }

        @Override
        public boolean append(String path, String data) {
            return false;
        }

        @Override
        public void startLogin(Activity caller, int i) {

        }

        @Override
        public void startWatching(String path) {

        }

        @Override
        public void stopWatching(String path) {

        }

        @Override
        public boolean supportsAuthentication() {
            return false;
        }

        @Override
        public void deauthenticate() {

        }

        @Override
        public boolean isLocal() {
            return false;
        }

        @Override
        public void browseForNewFile(Activity act, String path, FileSelectedListener listener) {

        }

    }
}