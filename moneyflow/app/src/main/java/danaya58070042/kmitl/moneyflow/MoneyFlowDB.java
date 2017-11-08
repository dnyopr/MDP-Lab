package danaya58070042.kmitl.moneyflow;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by HP_PC01 on 8/11/2560.
 */

@Database(entities = {MoneyFlow.class}, version = 1)
public abstract class MoneyFlowDB extends RoomDatabase{
    public abstract MoneyFlowDAO moneyFlowDAO();
}
