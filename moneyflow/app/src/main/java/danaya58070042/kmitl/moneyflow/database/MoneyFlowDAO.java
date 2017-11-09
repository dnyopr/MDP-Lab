package danaya58070042.kmitl.moneyflow.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import danaya58070042.kmitl.moneyflow.model.MoneyFlow;

/**
 * Created by HP_PC01 on 8/11/2560.
 */

@Dao
public interface MoneyFlowDAO {
    @Insert
    void insert(MoneyFlow moneyFlow);

    @Query("SELECT * FROM MONEY_FLOW")
    List<MoneyFlow> findAll();

//    @Query("SELECT type FROM MONEY_FLOW")
//    List<MoneyFlow> getType();
//
//    @Query("SELECT detail FROM MONEY_FLOW")
//    List<MoneyFlow> getDetail();
//
//    @Query("SELECT amount FROM MONEY_FLOW")
//    List<MoneyFlow> getAmount();

}
