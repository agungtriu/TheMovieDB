package com.dicoding.moviecatalogue.catalogues.movie

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

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private val listMovie = ArrayList<CatalogueEntity>()
    fun setMovie(catalogues: List<CatalogueEntity>?) {
        if (catalogues.isNullOrEmpty()) return
        this.listMovie.clear()
        this.listMovie.addAll(catalogues)
    }

    class MovieViewHolder(private val binding: ItemsCatalogueBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: CatalogueEntity) {
            with(binding) {
                textviewItemscatalogueTitle.text = movies.catalogueTitle
                textviewItemscatalogueRelease.text = movies.catalogueRelease
                textviewItemscatalogueOverview.text = movies.catalogueOverview
                Glide.with(itemView.context)
                    .load(movies.cataloguePoster)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgItemscataloguePoster)

                itemView.setOnClickListener {
                    val intent = Intent(it.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE, movies.catalogueId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsMovieBinding = ItemsCatalogueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movies = listMovie[position]
        holder.bind(movies)
    }

    override fun getItemCount(): Int = listMovie.size
}