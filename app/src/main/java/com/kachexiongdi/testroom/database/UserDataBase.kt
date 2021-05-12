package com.kachexiongdi.testroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kachexiongdi.testroom.bean.ChildUser
import com.kachexiongdi.testroom.bean.User
import com.kachexiongdi.testroom.dao.ChildUserDao
import com.kachexiongdi.testroom.dao.UserDao

/**
 *   author : qiukailong
 *   date   : 2020/12/4  2:19 PM
 *   desc   :
 */
@Database(entities = [ChildUser::class, User::class], version = 1, exportSchema = false)
abstract class UserDataBase : RoomDatabase() {

    //    abstract fun studentDao(): StudentDao

    //第一种方式
//    companion object {
//       val instance = Single.sin
//    }
//
//    private object Single {
//        val sin: StudentDatabase =
//            Room.databaseBuilder(MyApplication.getInstance(), StudentDatabase::class.java, "student.db").build()
//    }

    //第二种方式
//    companion object {
//        @Volatile
//        private var instance: StudentDatabase? = null
//        fun getDBInstance(): StudentDatabase {
//            if (instance == null) {
//                synchronized(StudentDatabase::class) {
//                    if (instance == null) {
//                        instance = Room.databaseBuilder(
//                            MyApplication.getInstance(),
//                            StudentDatabase::class.java,
//                            "student.db"
//                        ).build()
//                    }
//                }
//            }
//            return instance!!
//        }
//    }

    companion object {
        @Volatile
        private var sInstance: UserDataBase? = null
        private const val DATA_BASE_NAME = "jetpack_movie.db"

        @JvmStatic
        fun getInstance(context: Context): UserDataBase? {
            if (sInstance == null) {
                synchronized(UserDataBase::class.java) {
                    if (sInstance == null) {
                        sInstance = createInstance(context)
                    }
                }
            }
            return sInstance
        }

        private fun createInstance(context: Context): UserDataBase {
            return Room.databaseBuilder(
                context.applicationContext,
                UserDataBase::class.java,
                DATA_BASE_NAME
            )
                .build()
        }
    }

//    companion object {
//        var dataBase: StudentDatabase
//
//        init {
//            //如果databaseBuilder改为inMemoryDatabaseBuilder则创建一个内存数据库（进程销毁后，数据丢失）
//            dataBase = Room.databaseBuilder(MyApplication.getInstance(), StudentDatabase::class.java, "db_user")
//                //是否允许在主线程进行查询
//                .allowMainThreadQueries()
//                //数据库创建和打开后的回调，可以重写其中的方法
//                .addCallback(object : Callback() {
//                    override fun onCreate(db: SupportSQLiteDatabase) {
//                        super.onCreate(db)
//                        Log.d("TAG", "onCreate: db_user")
//                    }
//                })
//                //数据库升级异常之后的回滚
//                .fallbackToDestructiveMigration()
//                .build()
//        }
//
//    }
}