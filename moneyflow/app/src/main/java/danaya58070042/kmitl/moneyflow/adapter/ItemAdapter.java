package danaya58070042.kmitl.moneyflow.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import danaya58070042.kmitl.moneyflow.R;
import danaya58070042.kmitl.moneyflow.model.MoneyFlow;

/**
 * Created by HP_PC01 on 9/11/2560.
 */
class Holder extends RecyclerView.ViewHolder{

    public TextView type, desc, amount;

    public Holder(View itemView) {
        super(itemView);

        type = itemView.findViewById(R.id.txt_type);
        desc = itemView.findViewById(R.id.txt_describe);
        amount = itemView.findViewById(R.id.txt_amount);
    }
}

public class ItemAdapter extends RecyclerView.Adapter<Holder> {

    private Context context;
    private List<MoneyFlow> list;
    private MoneyFlowAdapterListener listener;

    public ItemAdapter(Context context, List<MoneyFlow> list, MoneyFlowAdapterListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_transaction, null, false);
        Holder holder = new Holder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void showList(Holder holder, int position){
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public interface MoneyFlowAdapterListener {
        public void onItemTouched(MoneyFlow moneyFlow);
    }
    
}
