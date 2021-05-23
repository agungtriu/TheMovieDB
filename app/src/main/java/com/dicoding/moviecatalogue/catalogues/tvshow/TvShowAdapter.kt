package com.dicoding.moviecatalogue.catalogues.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.catalogues.detail.DetailActivity
import com.dicoding.moviecatalogue.data.CatalogueEntity
import com.dicoding.moviecatalogue.databinding.ItemsCatalogueBinding

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private val listTvShow = ArrayList<CatalogueEntity>()
    fun setTvShow(tvShows: List<CatalogueEntity>?) {
        if (tvShows.isNullOrEmpty()) return
        this.listTvShow.clear()
        this.listTvShow.addAll(tvShows)
    }

    class TvShowViewHolder(private val binding: ItemsCatalogueBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShows: CatalogueEntity) {
            with(binding) {
                textviewItemscatalogueTitle.text = tvShows.catalogueTitle
                textviewItemscatalogueRelease.text = tvShows.catalogueRelease
                textviewItemscatalogueOverview.text = tvShows.catalogueOverview
                Glide.with(itemView.context)
                    .load(tvShows.cataloguePoster)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgItemscataloguePoster)

                itemView.setOnClickListener {
                    val intent = Intent(it.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_TV_SHOW, tvShows.catalogueId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemsTvShowBinding = ItemsCatalogueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShows = listTvShow[position]
        holder.bind(tvShows)
    }

    override fun getItemCount(): Int = listTvShow.size
}