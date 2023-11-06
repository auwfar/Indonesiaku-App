package com.auwfar.indonesiaku.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import com.auwfar.indonesiaku.R
import com.auwfar.indonesiaku.databinding.ItemProvinceBinding
import com.auwfar.indonesiaku.network.model.ProvinceModel

class ProvinceAdapter(
    private val onCheckLocation : (ProvinceModel?) -> Unit
) : RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder>() {

    private var _items = listOf<ProvinceModel>()

    fun setItems(items: List<ProvinceModel>) {
        _items = items
        notifyItemRangeInserted(0, items.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder {
        return ProvinceViewHolder(
            ItemProvinceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = _items.size

    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) {
        val item = _items.getOrNull(position)
        holder.bind(item)
    }

    inner class ProvinceViewHolder(
        private val binding: ItemProvinceBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProvinceModel?) {
            with(binding) {
                val imageLoader = ImageLoader.Builder(itemView.context)
                    .components { add(SvgDecoder.Factory()) }.build()
                ivLogo.load(item?.logoUrl, imageLoader) {
                    placeholder(R.drawable.img_placeholder_logo)
                }

                tvName.text = item?.name
                tvAddress.text = item?.address
                tvPhone.text = item?.phone
                tvEmail.text = item?.email
                tvWebsite.text = item?.websiteUrl

                tvEmail.isVisible = !item?.email.isNullOrBlank()

                btnCheckLocation.setOnClickListener {
                    onCheckLocation(item)
                }
            }
        }
    }
}