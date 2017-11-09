package danaya58070042.kmitl.moneyflow.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.util.StringUtil;
import android.widget.EditText;

/**
 * Created by HP_PC01 on 8/11/2560.
 */

@Entity(tableName = "MONEY_FLOW")
public class MoneyFlow {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "TYPE")
    private String type;

    @ColumnInfo(name = "DESCRIBE")
    private String describe;

    @ColumnInfo(name = "AMOUNT")
    private String amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String detail) {
        this.describe = detail;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
