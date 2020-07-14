package kodman.isyourpenisbig;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;



/**
 * Created by DI1 on 19.03.2018.
 */

public class AdapterCategories extends RecyclerView.Adapter<AdapterCategories.ViewHolder> {

    private List<String> items;
    private Context context;
    LayoutInflater inflater;

    public AdapterCategories(Context context, LayoutInflater inflater, final List<String> items) {
        this.context=context;
        this.items = items;
    }


    @Override
    public AdapterCategories.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        inflater= LayoutInflater.from(viewGroup.getContext());
        View v = inflater.inflate(R.layout.item_country, viewGroup, false);

        return new AdapterCategories.ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(AdapterCategories.ViewHolder viewHolder, int i) {

        String category = items.get(i);
        viewHolder.tv.setText(category);
        viewHolder.position=i;

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        private int position;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tv = (TextView) itemView.findViewById(R.id.tvCategory);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

//                    AlertDialog.Builder builder=new AlertDialog.Builder(context);
//                    final View view=inflater.inflate(R.layout.dialog_category,null);
//                    final EditText et=view.findViewById(R.id.etCategory);
//                    et.setText(tv.getText());
//                    builder
//                            .setCancelable(true)
//                            .setView(view)
//                            .setTitle(R.string.newCategory)
//                            .setPositiveButton(R.string.changeCategory, new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//
//                            long res= DatabaseHelper.getInstance(context).updateCategory(et.getText().toString(),tv.getText().toString());
//                            tv.setText(et.getText());
//                            Toast.makeText(context,context.getResources().getString(R.string.deleted), Toast.LENGTH_SHORT).show();
//
//                            dialog.cancel();
//                            categories.add(position,tv.getText().toString());
//                            categories.remove(position+1);
//                            AdapterCategories.this.notifyDataSetChanged();
//                        }
//                    })
//                            .setNeutralButton(R.string.buttonCancel,new DialogInterface.OnClickListener()
//                    { @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                       // Toast.makeText(context,"Cancel",Toast.LENGTH_SHORT).show();
//                        dialog.cancel();
//                    }
//                    })
//                            .setNegativeButton(R.string.buttonDeleteCategory,new DialogInterface.OnClickListener()
//                            { @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                long res= DatabaseHelper.getInstance(context).removeCategory(et.getText().toString());
//                                Toast.makeText(context,context.getResources().getString(R.string.deleted), Toast.LENGTH_SHORT).show();
//                                dialog.cancel();
//                                categories.remove(position);
//                                AdapterCategories.this.notifyDataSetChanged();
//                            }
//                            })
//
//
//                    .create().show();
                }
            });
        }
    }
}
