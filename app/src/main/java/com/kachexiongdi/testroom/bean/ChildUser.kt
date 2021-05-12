package com.kachexiongdi.testroom.bean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

/**
 *   author : qiukailong
 *   date   : 2020/12/4  10:55 AM
 *   desc   :
 */
/**
 * @Entity(foreignKeys = @ForeignKey(entity = Company.class,parentColumns = "id",
 * childColumns = "emp_id",onDelete = CASCADE),
indices = @Index(value={"emp_id"},unique = true))
 */
@Entity(tableName = "childuser",
    foreignKeys = [ForeignKey(entity = User::class,parentColumns = ["id"],childColumns = ["parentId"])])
class ChildUser(
    var childName: String = "",
    var childSex: String = "",
    @ColumnInfo(name = "parentId")  var parentId: String
) {
    @PrimaryKey
    var id = 0
}