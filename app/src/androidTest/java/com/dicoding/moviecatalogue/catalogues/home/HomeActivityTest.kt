package com.dicoding.moviecatalogue.catalogues.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest{
    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvShows()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies(){
        onView(withId(R.id.recyclerview_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerview_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadTvShows(){
        onView(withId(R.id.viewpager_home)).check(matches(isDisplayed()))
        onView(withId(R.id.viewpager_home)).perform(swipeLeft())
        onView(withId(R.id.recyclerview_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerview_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.recyclerview_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.textview_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_title)).check(matches(withText(dummyMovie[0].catalogueTitle)))
        onView(withId(R.id.textview_detail_score)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_score)).check(matches(withText(dummyMovie[0].catalogueScore)))
        onView(withId(R.id.textview_detail_genres)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_genres)).check(matches(withText(dummyMovie[0].catalogueGenres)))
        onView(withId(R.id.textview_detail_release)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_release)).check(matches(withText(dummyMovie[0].catalogueRelease)))
        onView(withId(R.id.textview_detail_director)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_director)).check(matches(withText(dummyMovie[0].catalogueDirector)))
        onView(withId(R.id.textview_detail_cast)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_cast)).check(matches(withText(dummyMovie[0].catalogueCast)))
        onView(withId(R.id.textview_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_overview)).check(matches(withText(dummyMovie[0].catalogueOverview)))
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.img_detail_poster)).perform(click())
        onView(withId(R.id.img_show)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withId(R.id.viewpager_home)).check(matches(isDisplayed()))
        onView(withId(R.id.viewpager_home)).perform(swipeLeft())
        onView(withId(R.id.recyclerview_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.textview_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_title)).check(matches(withText(dummyTvShow[0].catalogueTitle)))
        onView(withId(R.id.textview_detail_score)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_score)).check(matches(withText(dummyTvShow[0].catalogueScore)))
        onView(withId(R.id.textview_detail_genres)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_genres)).check(matches(withText(dummyTvShow[0].catalogueGenres)))
        onView(withId(R.id.textview_detail_release)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_release)).check(matches(withText(dummyTvShow[0].catalogueRelease)))
        onView(withId(R.id.textview_detail_director_subtitle)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_director_subtitle)).check(matches(withText("Creator")))
        onView(withId(R.id.textview_detail_director)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_director)).check(matches(withText(dummyTvShow[0].catalogueDirector)))
        onView(withId(R.id.textview_detail_cast)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_cast)).check(matches(withText(dummyTvShow[0].catalogueCast)))
        onView(withId(R.id.textview_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_overview)).check(matches(withText(dummyTvShow[0].catalogueOverview)))
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.img_detail_poster)).perform(click())
        onView(withId(R.id.img_show)).check(matches(isDisplayed()))
    }
}