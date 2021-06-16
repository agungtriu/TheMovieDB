package com.dicoding.moviecatalogue.ui.catalogues.home.favorite

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.data.source.local.entity.FavoriteEntity
import com.dicoding.moviecatalogue.databinding.ItemsCatalogueBinding
import com.dicoding.moviecatalogue.ui.catalogues.detail.DetailActivity

class FavoriteAdapter :
    PagedListAdapter<FavoriteEntity, FavoriteAdapter.FavoriteViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FavoriteEntity>() {
            override fun areItemsTheSame(
                oldItem: FavoriteEntity,
                newItem: FavoriteEntity
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: FavoriteEntity,
                newItem: FavoriteEntity
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    class FavoriteViewHolder(private val binding: ItemsCatalogueBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(Favorites: FavoriteEntity) {
            with(binding) {
                textviewItemscatalogueTitle.text = Favorites.title
                textviewItemscatalogueScore.text = Favorites.score
                textviewItemscatalogueRelease.text = Favorites.release
                textviewItemscatalogueOverview.text = Favorites.overview
                Glide.with(itemView.context)
                    .load(Favorites.poster)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgItemscataloguePoster)

                itemView.setOnClickListener {
                    val intent = Intent(it.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_FAVORITE, Favorites)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val itemsFavoriteBinding =
            ItemsCatalogueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(itemsFavoriteBinding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val favorites = getItem(position)
        if (favorites != null) {
            holder.bind(favorites)
        }
    }
}