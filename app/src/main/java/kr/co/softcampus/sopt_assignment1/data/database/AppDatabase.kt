package kr.co.softcampus.sopt_assignment1.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kr.co.softcampus.sopt_assignment1.data.datasource.local.UserDao
import kr.co.softcampus.sopt_assignment1.data.model.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        fun getInstance(context: Context): AppDatabase = Room
            .databaseBuilder(context, AppDatabase::class.java, "seminar.db")
            .build()
    }
}