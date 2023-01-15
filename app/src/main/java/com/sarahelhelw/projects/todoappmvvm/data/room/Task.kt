package com.sarahelhelw.projects.todoappmvvm.data.room

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.text.DateFormat

@Entity(tableName = "tasks_table") // to generate the table by room database
@Parcelize
data class Task(
    val name: String,
    val important: Boolean = false,
    val completed: Boolean = false,
    val createdAt: Long = System.currentTimeMillis(),
    //a unique identifier for each task object
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
) : Parcelable {
    //calculated property
    //overriding the getter method through get()
    //each time this property is accessed the code
    // in front of the get() will be executed
    val createdAtDateFormatted: String
        get() = DateFormat.getDateTimeInstance().format(createdAt)
}