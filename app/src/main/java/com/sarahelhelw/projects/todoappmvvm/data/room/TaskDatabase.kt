package com.sarahelhelw.projects.todoappmvvm.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sarahelhelw.projects.todoappmvvm.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

// this annotation is to trigger Room code generation
// if your app is still in testing phase and not deployed to production
// if you changed the Room database schema, you don't have to change
// the version, you delete the app from your phone and install it again
@Database(entities = [Task::class], version = 1, exportSchema = true)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    //this is called a nested class
    //we implemented this database callback
    //to add initial dummy values in Room database
    //@Inject -> constructor injection
    //Provider<> -> lazy or optional retrieval of an instance.
    //Provider<> -> used for breaking circular dependencies.
    class Callback @Inject constructor(
        private val database: Provider<TaskDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            // Called when the database is created for the first time.
            // This is called after all the tables are created.
            val dao = database.get().taskDao()
            applicationScope.launch {
                dao.insertTask(Task("Unstoppable"))
                dao.insertTask(Task("Positive"))
                dao.insertTask(Task("Keep it up"))
                dao.insertTask(Task("Keep up the hard work"))
                dao.insertTask(Task("Positive"))
            }
        }
    }
}