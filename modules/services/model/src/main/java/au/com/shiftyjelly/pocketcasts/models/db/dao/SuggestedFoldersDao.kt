package au.com.shiftyjelly.pocketcasts.models.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import au.com.shiftyjelly.pocketcasts.models.entity.SuggestedFolder

@Dao
abstract class SuggestedFoldersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insert(folder: SuggestedFolder)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun insertAll(folders: List<SuggestedFolder>)

    @Query("SELECT * FROM suggested_folders WHERE folder_name = :folderName")
    abstract suspend fun findAllFolderPodcasts(folderName: String): List<SuggestedFolder>

    @Query("SELECT * FROM suggested_folders")
    abstract suspend fun findAll(): List<SuggestedFolder>

    @Query("DELETE FROM suggested_folders")
    protected abstract suspend fun deleteAll()

    @Transaction
    open suspend fun deleteAndInsertAll(folders: List<SuggestedFolder>) {
        deleteAll()
        insertAll(folders)
    }
}
