package com.dicoding.moviecatalogue.utils

import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity
import com.dicoding.moviecatalogue.data.source.local.entity.CreditEntity
import com.dicoding.moviecatalogue.data.source.local.entity.DetailMovieEntity
import com.dicoding.moviecatalogue.data.source.local.entity.DetailTvShowEntity
import com.dicoding.moviecatalogue.data.source.remote.response.*

object DataDummy {
    fun generateDummyListMovies(): List<CatalogueEntity> {
        val listMovies = ArrayList<CatalogueEntity>()
        listMovies.add(
            CatalogueEntity(
                578701,
                "Those Who Wish Me Dead",
                "05 May 2021",
                "A young boy finds himself pursued by two assassins in the Montana wilderness with a survival expert determined to protecting him - and a forest fire threatening to consume them all.",
                "72%",
                "https://image.tmdb.org/t/p/w500/xCEg6KowNISWvMh8GvPSxtdf9TO.jpg"
            )
        )

        listMovies.add(
            CatalogueEntity(
                460465,
                "Mortal Kombat",
                "07 April 2021",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "76%",
                "https://image.tmdb.org/t/p/w500/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg"
            )
        )

        listMovies.add(
            CatalogueEntity(
                567189,
                "Tom Clancy's Without Remorse",
                "29 April 2021",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "72%",
                "https://image.tmdb.org/t/p/w500/rEm96ib0sPiZBADNKBHKBv5bve9.jpg"
            )
        )

        listMovies.add(
            CatalogueEntity(
                399566,
                "Godzilla vs. Kong",
                "24 March 2021",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "81%",
                "https://image.tmdb.org/t/p/w500/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg"
            )
        )

        listMovies.add(
            CatalogueEntity(
                615457,
                "Nobody",
                "26 March 2021",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "84%",
                "https://image.tmdb.org/t/p/w500/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg"
            )
        )

        return listMovies
    }

    fun generateDummyDetailMovies(): DetailMovieEntity {
        return DetailMovieEntity(
            "Those Who Wish Me Dead",
            "Thriller, Drama, Action, Mystery",
            578701,
            "A young boy finds himself pursued by two assassins in the Montana wilderness with a survival expert determined to protecting him - and a forest fire threatening to consume them all.",
            "https://image.tmdb.org/t/p/w500/xCEg6KowNISWvMh8GvPSxtdf9TO.jpg",
            "05 May 2021",
            "71%"
        )
    }

    fun generateDummyMoviesCredit(): CreditEntity {
        return CreditEntity(
            "Angelina Jolie, Finn Little, Jon Bernthal, Aidan Gillen, Nicholas Hoult, Jake Weber, Medina Senghore, Tyler Perry, Boots Southerland, Tory Kittles, James Jordan, Lora Martinez-Cunningham, Howard Ferguson Jr., Ryan Jason Cook, Laura Niemi, Dylan Kenin, Sofia Embid, Jacob Browne, Rene Herrera, Alison Grainger, Alma Sisneros, David Phyfer, David Hight, Jesus Cris Acosta, James Rishe, Matt Medrano, Stephanie Hill",
            578701,
            "Taylor Sheridan"
        )
    }

    fun generateDummyListTvShows(): List<CatalogueEntity> {
        val listTvShows = ArrayList<CatalogueEntity>()
        listTvShows.add(
            CatalogueEntity(
                120168,
                "Who Killed Sara?",
                "24 March 2021",
                "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                "78%",
                "https://image.tmdb.org/t/p/w500/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg"
            )
        )

        listTvShows.add(
            CatalogueEntity(
                60735,
                "The Flash",
                "07 October 2014",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "77%",
                "https://image.tmdb.org/t/p/w500/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"
            )
        )

        listTvShows.add(
            CatalogueEntity(
                71712,
                "The Good Doctor",
                "25 September 2017",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "86%",
                "https://image.tmdb.org/t/p/w500/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg"
            )
        )

        listTvShows.add(
            CatalogueEntity(
                88396,
                "The Falcon and the Winter Soldier",
                "19 March 2021",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "79%",
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg"
            )
        )

        listTvShows.add(
            CatalogueEntity(
                1416,
                "Grey's Anatomy",
                "27 March 2005",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "82%",
                "https://image.tmdb.org/t/p/w500/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg"
            )
        )

        return listTvShows
    }

    fun generateDummyDetailTvShows(): DetailTvShowEntity {
        return DetailTvShowEntity(
            "Drama, Crime, Mystery",
            120168,
            "24 March 2021",
            "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
            "José Ignacio Valenzuela",
            "https://image.tmdb.org/t/p/w500/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
            "78%",
            "Who Killed Sara?"
        )
    }

    fun generateDummyTvShowsCredit(): CreditEntity {
        return CreditEntity(
            "Manolo Cardona, Carolina Miranda, Ginés García Millán, Claudia Ramírez, Eugenio Siller, Alejandro Nones",
            120168,
            ""
        )
    }

    fun getRemoteMovies(): List<MovieItem> {
        return listOf(
            MovieItem(
                genreIds = listOf(14, 28, 12),
                id = 464052,
                overview = "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
                posterPath = "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                releaseDate = "2020-12-16",
                title = "Wonder Woman 1984",
                voteAverage = 7.2
            ),
            MovieItem(
                genreIds = listOf(16, 35, 18, 10402, 14),
                id = 508442,
                overview = "Joe Gardner is a middle school teacher with a love for jazz music. After a successful gig at the Half Note Club, he suddenly gets into an accident that separates his soul from his body and is transported to the You Seminar, a center in which souls develop and gain passions before being transported to a newborn child. Joe must enlist help from the other souls-in-training, like 22, a soul who has spent eons in the You Seminar, in order to get back to Earth.",
                posterPath = "/hm58Jw4Lw8OIeECIq5qyPYhAeRJ.jpg",
                releaseDate = "2020-12-25",
                title = "Soul",
                voteAverage = 8.4
            ),
            MovieItem(
                genreIds = listOf(878, 12),
                id = 517096,
                overview = "Cosmoball is a mesmerizing intergalactic game of future played between humans and aliens at the giant extraterrestrial ship hovering in the sky over Earth. A young man with enormous power of an unknown nature joins the team of hot-headed superheroes in exchange for a cure for his mother’s deadly illness. The Four from Earth will fight not only to defend the honor of their home planet in the spectacular game, but to face the unprecedented threat to the Galaxy and embrace their own destiny.",
                posterPath = "/eDJYDXRoWoUzxjd52gtz5ODTSU1.jpg",
                releaseDate = "2020-08-27",
                title = "Cosmoball",
                voteAverage = 5.5
            )
        )
    }

    fun getRemoteDetailMovie(): DetailMovieResponse {
        return DetailMovieResponse(
            adult = false,
            backdropPath = "/srYya1ZlI97Au4jUYAktDe3avyA.jpg",
            budget = 200000000,
            genres = listOf(
                GenresItem(
                    id = 14,
                    name = "Fantasy"
                ),
                GenresItem(
                    id = 28,
                    name = "Action"
                ),
                GenresItem(
                    id = 12,
                    name = "Adventure"
                )
            ),
            homepage = "https://www.warnerbros.com/movies/wonder-woman-1984",
            id = 464052,
            imdbId = "tt7126948",
            originalLanguage = "en",
            originalTitle = "Wonder Woman 1984",
            overview = "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
            popularity = 3342.686,
            posterPath = "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
            productionCompanies = listOf(
                ProductionCompaniesItem(
                    id = 9993,
                    logoPath = "/2Tc1P3Ac8M479naPp1kYT3izLS5.png",
                    name = "DC Entertainment",
                    originCountry = "US"
                ),
                ProductionCompaniesItem(
                    id = 174,
                    logoPath = "/ky0xOc5OrhzkZ1N6KyUxacfQsCk.png",
                    name = "Warner Bros. Pictures",
                    originCountry = "US"
                ),
                ProductionCompaniesItem(
                    id = 114152,
                    logoPath = null,
                    name = "The Stone Quarry",
                    originCountry = "US"
                ),
                ProductionCompaniesItem(
                    id = 128064,
                    logoPath = "/13F3Jf7EFAcREU0xzZqJnVnyGXu.png",
                    name = "DC Films",
                    originCountry = "US"
                ),
                ProductionCompaniesItem(
                    id = 507,
                    logoPath = "/z7H707qUWigbjHnJDMfj6QITEpb.png",
                    name = "Atlas Entertainment",
                    originCountry = "US"
                ),
                ProductionCompaniesItem(
                    id = 429,
                    logoPath = "/2Tc1P3Ac8M479naPp1kYT3izLS5.png",
                    name = "DC Comics",
                    originCountry = "US"
                )
            ),
            productionCountries = listOf(
                ProductionCountriesItem(
                    iso31661 = "US",
                    name = "United States of America"
                )
            ),
            releaseDate = "2020-12-16",
            revenue = 131400000,
            runtime = 151,
            spokenLanguages = listOf(
                SpokenLanguagesItem(
                    englishName = "English",
                    iso6391 = "en",
                    name = "English"
                )
            ),
            status = "Released",
            tagline = "A new era of wonder begins.",
            title = "Wonder Woman 1984",
            video = false,
            voteAverage = 7.2,
            voteCount = 2654

        )
    }

    fun getRemoteTvShows(): List<TvShowItem> {
        return listOf(
            TvShowItem(
                firstAirDate = "2018-05-02",
                genreIds = listOf(10759, 18),
                id = 77169,
                name = "Cobra Kai",
                overview = "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                posterPath = "/obLBdhLxheKg8Li1qO11r2SwmYO.jpg",
                voteAverage = 8.1
            ),
            TvShowItem(
                firstAirDate = "2019-11-12",
                genreIds = listOf(10765, 10759),
                id = 82856,
                name = "The Mandalorian",
                overview = "After the fall of the Galactic Empire, lawlessness has spread throughout the galaxy. A lone gunfighter makes his way through the outer reaches, earning his keep as a bounty hunter.",
                posterPath = "/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg",
                voteAverage = 8.5
            ),
            TvShowItem(
                firstAirDate = "2013-03-03",
                genreIds = listOf(10759, 18),
                id = 44217,
                name = "Vikings",
                overview = "The adventures of Ragnar Lothbrok, the greatest hero of his age. The series tells the sagas of Ragnar's band of Viking brothers and his family, as he rises to become King of the Viking tribes. As well as being a fearless warrior, Ragnar embodies the Norse traditions of devotion to the gods. Legend has it that he was a direct descendant of Odin, the god of war and warriors.",
                posterPath = "/bQLrHIRNEkE3PdIWQrZHynQZazu.jpg",
                voteAverage = 8.0
            )
        )
    }

    fun getRemoteDetailTvShow(): DetailTvShowResponse {
        return DetailTvShowResponse(
            backdropPath = "/gL8myjGc2qrmqVosyGm5CWTir9A.jpg",
            createdBy = listOf(
                CreatedByItem(
                    name = "Hayden Schlossberg"
                ),
                CreatedByItem(
                    name = "Josh Heald"
                ),
                CreatedByItem(
                    name = "John Hurwitz"
                )
            ),
            episodeRunTime = listOf(30),
            firstAirDate = "2018-05-02",
            genres = listOf(
                GenresItem(
                    id = 10759,
                    name = "Action & Adventure"
                ),
                GenresItem(
                    id = 18,
                    name = "Drama"
                )
            ),
            homepage = "https://www.netflix.com/title/81002370",
            id = 77169,
            inProduction = true,
            languages = listOf("en"),
            lastAirDate = "2021-01-01",
            lastEpisodeToAir = LastEpisodeToAir(
                airDate = "2021-01-01",
                episodeNumber = 10,
                id = 2529899,
                name = "December 19",
                overview = "Old wounds begin to heal at a country club holiday party, but a brutal assault by Kreese's students leads to new betrayals and alliances.",
                productionCode = "",
                seasonNumber = 3,
                stillPath = "/AvnkMnigxqapasWQCFpyXLPdxmG.jpg",
                voteAverage = 7.5,
                voteCount = 2
            ),
            name = "Cobra Kai",
            nextEpisodeToAir = null,
            networks = listOf(
                NetworksItem(
                    name = "Netflix",
                    id = 213,
                    logoPath = "/wwemzKWzjKYJFfCeiB57q3r4Bcm.png",
                    originCountry = ""
                ),
                NetworksItem(
                    name = "YouTube Premium",
                    id = 1436,
                    logoPath = "/3p05CgodUb9gPayuliuhawNj1Wo.png",
                    originCountry = "US"
                )
            ),
            numberOfEpisodes = 30,
            numberOfSeasons = 3,
            originCountry = listOf("US"),
            originalLanguage = "en",
            originalName = "Cobra Kai",
            overview = "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
            popularity = 1132.227,
            posterPath = "/obLBdhLxheKg8Li1qO11r2SwmYO.jpg",
            productionCompanies = listOf(
                ProductionCompaniesItem(
                    id = 101024,
                    logoPath = null,
                    name = "Hurwitz & Schlossberg Productions",
                    originCountry = "US"
                ),
                ProductionCompaniesItem(
                    id = 11073,
                    logoPath = "/wHs44fktdoj6c378ZbSWfzKsM2Z.png",
                    name = "Sony Pictures Television",
                    originCountry = "US"
                ),
                ProductionCompaniesItem(
                    id = 907,
                    logoPath = "/ca5SWI5uvU985f8Kbb4xc8AmVWH.png",
                    name = "Overbrook Entertainment",
                    originCountry = "US"
                ),
            ),
            productionCountries = listOf(
                ProductionCountriesItem(
                    iso31661 = "US",
                    name = "United States of America"
                )
            ),
            seasons = listOf(
                SeasonsItem(
                    airDate = "2018-05-02",
                    episodeCount = 10,
                    id = 99459,
                    name = "Season 1",
                    overview = "Decades after the tournament that changed their lives, the rivalry between Johnny and Daniel reignites.",
                    posterPath = "/lLrKXnM3WPEtrPCd1aTHT6x3hn.jpg",
                    seasonNumber = 1
                ),
                SeasonsItem(
                    airDate = "2019-04-24",
                    episodeCount = 10,
                    id = 120052,
                    name = "Season 2",
                    overview = "Johnny continues building a new life, but a face from his past could disrupt his future. Meanwhile, Daniel opens a Miyagi-Do studio to rival Cobra Kai.",
                    posterPath = "/77kyNXN6yCRjDt9eBMj96vLMx8W.jpg",
                    seasonNumber = 2
                ),
                SeasonsItem(
                    airDate = "2021-01-01",
                    episodeCount = 10,
                    id = 160283,
                    name = "Season 3",
                    overview = "With a new sensei at the helm of the Cobra Kai dojo, a three-way feud takes center stage. Old grudges — like Cobra Kai — never die.",
                    posterPath = "/5DfWqh360sjMxqj3Th3DZdnFk3I.jpg",
                    seasonNumber = 3
                )
            ),
            spokenLanguages = listOf(
                SpokenLanguagesItem(
                    englishName = "English",
                    iso6391 = "en",
                    name = "English"
                )
            ),
            status = "Returning Series",
            tagline = "Cobra Kai never dies.",
            type = "Scripted",
            voteAverage = 8.1,
            voteCount = 1724
        )
    }

    fun getRemoteCreditMovies(): CreditResponse {
        return CreditResponse(
            cast = listOf(
                CastItem(
                    name = "Nicollette Sheridan",
                    profilePath = "/5jClu0aOq5hLzXa0ic3NoZBuZG4.jpg",
                    character = "Marissa Blumenthal"
                ),
                CastItem(
                    name = "William Devane",
                    profilePath = "/dP8A74H1OIr7aSyOzk8UHDGKbeE.jpg",
                    character = "Dr. Harbuck"
                ),
                CastItem(
                    name = "Stephen Caffrey",
                    profilePath = "/qvrH5yaO6EN04PeqcxTOUdUv04h.jpg",
                    character = "Tad"
                ),
                CastItem(
                    name = "Dakin Matthews",
                    profilePath = "/sIYsLZnEUTeYHnybPumEZ1Zi2CB.jpg",
                    character = "Miguel Diaz"
                ),
                CastItem(
                    name = "Tanner Buchanan",
                    profilePath = "/sIYsLZnEUTeYHnybPumEZ1Zi2CB.jpg",
                    character = "Dr. Dubcheck"
                ),
                CastItem(
                    name = "Kurt Fuller",
                    profilePath = "/kV02XLACLFd1YYQdSOgqy6lFmQ3.jpg",
                    character = "Dr. Williams"
                ),
                CastItem(
                    name = "Barry Corbin",
                    profilePath = "/avNg0rmudSPg30f8Xt9BwkPDC17.jpg",
                    character = "Dr. Clayman"
                ),
                CastItem(
                    name = "William Atherton",
                    profilePath = "/d4ArFBoywyW3yZ3RuD1KAC0fXiA.jpg",
                    character = "Dr. Reginald Holloway",
                ),
                CastItem(
                    name = "Joe Minjares",
                    profilePath = "/dr75CZaDH3hyg1jUREBkyqtXMRx.jpg",
                    character = "Dr. Newman"
                ),
                CastItem(
                    name = "Ritch Brinkley",
                    profilePath = "/x7W7jxIHn9DdJ8RhoZ0ippR3OWw.jpg",
                    character = "Restaurant Host"
                ),
                CastItem(
                    name = "Judith McConnell",
                    profilePath = "/8QYjrcyQIXiA9oaIfrm6C5plQ8O.jpg",
                    character = "Ms. Hopper"
                )
            ),
            id = 77169,
            crew = listOf(
                CrewItem(
                    name = "Armand Mastroianni",
                    profilePath = null,
                    job = "Director",

                    )
            )
        )
    }

    fun getRemoteCreditTvShows(): CreditResponse {
        return CreditResponse(
            cast = listOf(
                CastItem(
                    name = "Ralph Macchio",
                    profilePath = "/8zw5vcKlg05Is12Fww4QxRjO1f3.jpg",
                    character = "Daniel LaRusso"
                ),
                CastItem(
                    name = "William Zabka",
                    profilePath = "/2BqQuz7t4zbmPwKUpzGbyUQLPy3.jpg",
                    character = "Johnny Lawrence"
                ),
                CastItem(
                    name = "Courtney Henggeler",
                    profilePath = "/soNsMFPhOsdW6jR7oJi6SlXsYYT.jpg",
                    character = "Amanda LaRusso"
                ),
                CastItem(
                    name = "Xolo Mariduena",
                    profilePath = "/gIDJUwxXPKVd6Tr4r4PAdtctjdB.jpg",
                    character = "Miguel Diaz"
                ),
                CastItem(
                    name = "Tanner Buchanan",
                    profilePath = "/sjxBAWkL5aSdd6GHozWEAjEA64u.jpg",
                    character = "Robby Keene"
                ),
                CastItem(
                    name = "Mary Mouser",
                    profilePath = "/A5AMjqFB5SqWdZh4gOBGQNXK8vf.jpg",
                    character = "Samantha LaRusso"
                ),
                CastItem(
                    name = "Jacob Bertrand",
                    profilePath = "/j1V1788QXnzZ2Flp5pllqeodjYT.jpg",
                    character = "Eli \"Hawk\" Moskowitz"
                ),
                CastItem(
                    name = "Gianni Decenzo",
                    profilePath = "/aqbQh0hMt5vRbdhErs32bybr7Ah.jpg",
                    character = "Demetri",
                ),
                CastItem(
                    name = "Martin Kove",
                    profilePath = "/vKfS55g6rqldWekNdy4JifuJQsw.jpg",
                    character = "John Kreese"
                )
            ),
            id = 464052,
            crew = listOf(

            )
        )
    }
}