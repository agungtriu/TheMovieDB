package com.dicoding.moviecatalogue.ui.catalogues.home.moviedb.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity
import com.dicoding.moviecatalogue.databinding.ItemsCatalogueBinding
import com.dicoding.moviecatalogue.ui.catalogues.detail.DetailActivity

class TvShowAdapter :
    PagedListAdapter<CatalogueEntity, TvShowAdapter.TvShowViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CatalogueEntity>() {
            override fun areItemsTheSame(
                oldItem: CatalogueEntity,
                newItem: CatalogueEntity
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: CatalogueEntity,
                newItem: CatalogueEntity
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    class TvShowViewHolder(private val binding: ItemsCatalogueBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShows: CatalogueEntity) {
            with(binding) {
                textviewItemscatalogueTitle.text = tvShows.title
                textviewItemscatalogueScore.text = tvShows.score
                textviewItemscatalogueRelease.text = tvShows.release
                textviewItemscatalogueOverview.text = tvShows.overview
                Glide.with(itemView.context)
                    .load(tvShows.poster)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgItemscataloguePoster)

                itemView.setOnClickListener {
                    val intent = Intent(it.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_TV_SHOW, tvShows)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemsTvShowBinding =
            ItemsCatalogueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShows = getItem(position)
        if (tvShows != null) {
            holder.bind(tvShows)
        }
    }
}