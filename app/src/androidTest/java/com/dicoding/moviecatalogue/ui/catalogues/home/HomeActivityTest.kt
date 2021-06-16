package com.dicoding.moviecatalogue.ui.catalogues.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.helper.EspressoIdlingResource
import org.hamcrest.Matchers.not
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest{

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResourceForMainActivity())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResourceForMainActivity())
    }

    @Test
    fun loadMovies(){
        onView(withId(R.id.recyclerview_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerview_movie)).perform(swipeUp())
    }

    @Test
    fun loadTvShows(){
        onView(withId(R.id.viewpager_moviedb)).check(matches(isDisplayed()))
        onView(withId(R.id.viewpager_moviedb)).perform(swipeLeft())
        onView(withId(R.id.recyclerview_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerview_tvshow)).perform(swipeUp())
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.recyclerview_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerview_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.textview_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_title)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_score)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_score)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_genres)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_genres)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_release)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_release)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_cast)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_cast)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_overview)).check(matches(not(withText(""))))
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.img_detail_poster)).perform(click())
        onView(withId(R.id.img_show)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withId(R.id.viewpager_moviedb)).check(matches(isDisplayed()))
        onView(withId(R.id.viewpager_moviedb)).perform(swipeLeft())
        onView(withId(R.id.recyclerview_tvshow)).check(matches(isDisplayed()))
        Thread.sleep(2000)
        onView(withId(R.id.recyclerview_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.textview_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_title)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_score)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_score)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_genres)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_genres)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_release)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_release)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_cast)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_cast)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_overview)).check(matches(not(withText(""))))
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.img_detail_poster)).perform(click())
        onView(withId(R.id.img_show)).check(matches(isDisplayed()))
    }

    @Test
    fun insertDeleteMovieFavorite() {
        onView(withId(R.id.recyclerview_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerview_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.textview_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_title)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_score)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_score)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_genres)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_genres)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_release)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_release)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_cast)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_cast)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_overview)).check(matches(not(withText(""))))
        onView(withId(R.id.img_detail_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.img_detail_favorite)).perform(click())
        onView(isRoot()).perform(pressBack())
        onView(withId(R.id.navigation_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.navigation_favorite)).perform(click())
        onView(withId(R.id.recyclerview_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerview_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.textview_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_title)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_score)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_score)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_genres)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_genres)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_release)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_release)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_cast)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_cast)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_overview)).check(matches(not(withText(""))))
        onView(withId(R.id.img_detail_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.img_detail_favorite)).perform(click())
        onView(isRoot()).perform(pressBack())
    }

    @Test
    fun insertDeleteTvShowFavorite() {
        onView(withId(R.id.viewpager_moviedb)).check(matches(isDisplayed()))
        onView(withId(R.id.viewpager_moviedb)).perform(swipeLeft())
        onView(withId(R.id.recyclerview_tvshow)).check(matches(isDisplayed()))
        Thread.sleep(2000)
        onView(withId(R.id.recyclerview_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.textview_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_title)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_score)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_score)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_genres)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_genres)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_release)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_release)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_cast)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_cast)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_overview)).check(matches(not(withText(""))))
        onView(withId(R.id.img_detail_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.img_detail_favorite)).perform(click())
        onView(isRoot()).perform(pressBack())
        onView(withId(R.id.navigation_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.navigation_favorite)).perform(click())
        onView(withId(R.id.viewpager_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.viewpager_favorite)).perform(swipeLeft())
        onView(withId(R.id.recyclerview_tvshow)).check(matches(isDisplayed()))
        Thread.sleep(2000)
        onView(withId(R.id.recyclerview_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.textview_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_title)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_score)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_score)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_genres)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_genres)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_release)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_release)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_cast)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_cast)).check(matches(not(withText(""))))
        onView(withId(R.id.textview_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.textview_detail_overview)).check(matches(not(withText(""))))
        onView(withId(R.id.img_detail_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.img_detail_favorite)).perform(click())
        onView(isRoot()).perform(pressBack())
    }
}