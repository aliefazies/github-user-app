import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.bumptech.glide.Glide
import com.ziesapp.githubuserapp.Profile
import com.ziesapp.githubuserapp.R
import de.hdodenhof.circleimageview.CircleImageView

class ProfileAdapter internal constructor(private val context: Context) : BaseAdapter() {

    internal var profiles = arrayListOf<Profile>()

    private inner class ViewHolder internal constructor(view: View) {
        private val txtName = view.findViewById<TextView>(R.id.tv_nama)
        private val imgPhoto = view.findViewById<CircleImageView>(R.id.img_photo)

        internal fun bind(profile: Profile) {
            txtName.text = profile.name
            Glide.with(context)
                .load(profile.avatar)
                .into(imgPhoto)
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.list_profile, parent, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val profile = getItem(position) as Profile
        viewHolder.bind(profile)
        return itemView
    }

    override fun getItem(position: Int): Any = profiles[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = profiles.size
}