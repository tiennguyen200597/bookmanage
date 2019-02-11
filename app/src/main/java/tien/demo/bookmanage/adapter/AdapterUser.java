package tien.demo.bookmanage.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import tien.demo.bookmanage.R;
import tien.demo.bookmanage.model.User;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.UserHolder> {
    private Context context;
    public List<User> users;

    public AdapterUser(Context context, List<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_item, viewGroup, false);
        return new UserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder userHolder, int i) {
        userHolder.user = users.get(i);
        userHolder.tvUsername.setText(userHolder.user.USER_FULL_NAME);
        /*userHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
        userHolder.tvPhongnumber.setText(userHolder.user.USER_PHONE);


    }

    @Override
    public int getItemCount() {
        if (users == null) return 0;
        else return users.size();
    }

    class UserHolder extends RecyclerView.ViewHolder {
        private TextView tvUsername;
        private TextView tvPhongnumber;
        User user;


        public UserHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = (TextView) itemView.findViewById(R.id.tv_username);
            tvPhongnumber = (TextView) itemView.findViewById(R.id.tv_phonenumber);
        }
    }
}
