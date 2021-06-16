package com.dicoding.moviecatalogue.utils

import com.dicoding.moviecatalogue.data.source.local.entity.CatalogueEntity
import com.dicoding.moviecatalogue.data.source.local.entity.FavoriteEntity

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
                "https://image.tmdb.org/t/p/w500/xCEg6KowNISWvMh8GvPSxtdf9TO.jpg",
                "movie",
                "Thriller, Drama, Action, Mystery",
                "Taylor Sheridan",
                "Angelina Jolie, Finn Little, Jon Bernthal, Aidan Gillen, Nicholas Hoult, Jake Weber, Medina Senghore, Tyler Perry, Boots Southerland, Tory Kittles, James Jordan, Lora Martinez-Cunningham, Howard Ferguson Jr., Ryan Jason Cook, Laura Niemi, Dylan Kenin, Sofia Embid, Jacob Browne, Rene Herrera, Alison Grainger, Alma Sisneros, David Phyfer, David Hight, Jesus Cris Acosta, James Rishe, Matt Medrano, Stephanie Hill"
            )
        )

        listMovies.add(
            CatalogueEntity(
                460465,
                "Mortal Kombat",
                "07 April 2021",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "76%",
                "https://image.tmdb.org/t/p/w500/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                "movie",
                "Action, Fantasy, Adventure",
                "Simon McQuoid",
                "Lewis Tan, Jessica McNamee, Josh Lawson, Tadanobu Asano, Mehcad Brooks, Ludi Lin, Ng Chin Han, Joe Taslim, Hiroyuki Sanada"
            )
        )

        listMovies.add(
            CatalogueEntity(
                567189,
                "Tom Clancy's Without Remorse",
                "29 April 2021",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "72%",
                "https://image.tmdb.org/t/p/w500/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "movie",
            "Action, Thriller, War",
                "Stefano Sollima",
                "Michael B. Jordan, Jamie Bell, Jodie Turner-Smith, Lauren London, Brett Gelman, Jacob Scipio, Jack Kesy, Colman Domingo, Guy Pearce"

            )
        )

        listMovies.add(
            CatalogueEntity(
                399566,
                "Godzilla vs. Kong",
                "24 March 2021",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "81%",
                "https://image.tmdb.org/t/p/w500/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "movie",
                "Action, Science Fiction, Adventure",
                "Adam Wingard",
                "Alexander Skarsgård, Millie Bobby Brown, Rebecca Hall, Brian Tyree Henry, Shun Oguri, Eiza González, Julian Dennison, Lance Reddick, Kyle Chandler"
            )
        )

        listMovies.add(
            CatalogueEntity(
                615457,
                "Nobody",
                "26 March 2021",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "84%",
                "https://image.tmdb.org/t/p/w500/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                "movie",
                "Crime, Action, Thriller, Comedy",
                "Ilya Naishuller",
                "Bob Odenkirk, Aleksey Serebryakov, Connie Nielsen, Christopher Lloyd, Michael Ironside, RZA, Colin Salmon, Billy MacLellan, Araya Mengesha"
            )
        )

        return listMovies
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
                "https://image.tmdb.org/t/p/w500/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                "tv",
                "Drama, Crime, Mystery",
                "José Ignacio Valenzuela",
                "Manolo Cardona, Carolina Miranda, Ginés García Millán, Claudia Ramírez, Eugenio Siller, Alejandro Nones, Ela Velden, Luis Roberto Guzmán, Ana Lucía Domínguez"
            )
        )

        listTvShows.add(
            CatalogueEntity(
                60735,
                "The Flash",
                "07 October 2014",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "77%",
                "https://image.tmdb.org/t/p/w500/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "tv",
                "Drama, Sci-Fi & Fantasy",
                "Greg Berlanti, Geoff Johns, Andrew Kreisberg",
                "Grant Gustin, Candice Patton, Danielle Panabaker, Jesse L. Martin, Carlos Valdes, Tom Cavanagh, Danielle Nicolet, Hartley Sawyer, Keiynan Lonsdale"
            )
        )

        listTvShows.add(
            CatalogueEntity(
                71712,
                "The Good Doctor",
                "25 September 2017",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "86%",
                "https://image.tmdb.org/t/p/w500/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "tv",
                "Drama",
                "David Shore",
                "Freddie Highmore, Antonia Thomas, Hill Harper, Richard Schiff, Christina Chang, Paige Spara, Fiona Gubelmann, Will Yun Lee, Nicholas Gonzalez"
            )
        )

        listTvShows.add(
            CatalogueEntity(
                88396,
                "The Falcon and the Winter Soldier",
                "19 March 2021",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "79%",
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "tv",
                "Sci-Fi & Fantasy, Action & Adventure, Drama, War & Politics",
                "Malcolm Spellman",
                "Anthony Mackie, Sebastian Stan, Emily VanCamp, Wyatt Russell, Daniel Brühl, Erin Kellyman, Danny Ramirez, Adepero Oduye, Indya Bussey"
            )
        )

        listTvShows.add(
            CatalogueEntity(
                1416,
                "Grey's Anatomy",
                "27 March 2005",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "82%",
                "https://image.tmdb.org/t/p/w500/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "tv",
                "Drama",
                "Shonda Rhimes",
                "Ellen Pompeo, James Pickens Jr., Chandra Wilson, Justin Chambers, Kevin McKidd, Jesse Williams, Patrick Dempsey, Sara Ramirez, Jessica Capshaw"
            )
        )

        return listTvShows
    }

    fun generateDummyListMovieFavorites(): List<FavoriteEntity> {
        val listMovies = ArrayList<FavoriteEntity>()
        listMovies.add(
            FavoriteEntity(
                578701,
                "Those Who Wish Me Dead",
                "05 May 2021",
                "A young boy finds himself pursued by two assassins in the Montana wilderness with a survival expert determined to protecting him - and a forest fire threatening to consume them all.",
                "72%",
                "https://image.tmdb.org/t/p/w500/xCEg6KowNISWvMh8GvPSxtdf9TO.jpg",
                "movie",
                "Thriller, Drama, Action, Mystery",
                "Taylor Sheridan",
                "Angelina Jolie, Finn Little, Jon Bernthal, Aidan Gillen, Nicholas Hoult, Jake Weber, Medina Senghore, Tyler Perry, Boots Southerland, Tory Kittles, James Jordan, Lora Martinez-Cunningham, Howard Ferguson Jr., Ryan Jason Cook, Laura Niemi, Dylan Kenin, Sofia Embid, Jacob Browne, Rene Herrera, Alison Grainger, Alma Sisneros, David Phyfer, David Hight, Jesus Cris Acosta, James Rishe, Matt Medrano, Stephanie Hill"
            )
        )

        listMovies.add(
            FavoriteEntity(
                460465,
                "Mortal Kombat",
                "07 April 2021",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "76%",
                "https://image.tmdb.org/t/p/w500/nkayOAUBUu4mMvyNf9iHSUiPjF1.jpg",
                "movie",
                "Action, Fantasy, Adventure",
                "Simon McQuoid",
                "Lewis Tan, Jessica McNamee, Josh Lawson, Tadanobu Asano, Mehcad Brooks, Ludi Lin, Ng Chin Han, Joe Taslim, Hiroyuki Sanada"
            )
        )

        listMovies.add(
            FavoriteEntity(
                567189,
                "Tom Clancy's Without Remorse",
                "29 April 2021",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "72%",
                "https://image.tmdb.org/t/p/w500/rEm96ib0sPiZBADNKBHKBv5bve9.jpg",
                "movie",
                "Action, Thriller, War",
                "Stefano Sollima",
                "Michael B. Jordan, Jamie Bell, Jodie Turner-Smith, Lauren London, Brett Gelman, Jacob Scipio, Jack Kesy, Colman Domingo, Guy Pearce"

            )
        )

        listMovies.add(
            FavoriteEntity(
                399566,
                "Godzilla vs. Kong",
                "24 March 2021",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "81%",
                "https://image.tmdb.org/t/p/w500/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "movie",
                "Action, Science Fiction, Adventure",
                "Adam Wingard",
                "Alexander Skarsgård, Millie Bobby Brown, Rebecca Hall, Brian Tyree Henry, Shun Oguri, Eiza González, Julian Dennison, Lance Reddick, Kyle Chandler"
            )
        )

        listMovies.add(
            FavoriteEntity(
                615457,
                "Nobody",
                "26 March 2021",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "84%",
                "https://image.tmdb.org/t/p/w500/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                "movie",
                "Crime, Action, Thriller, Comedy",
                "Ilya Naishuller",
                "Bob Odenkirk, Aleksey Serebryakov, Connie Nielsen, Christopher Lloyd, Michael Ironside, RZA, Colin Salmon, Billy MacLellan, Araya Mengesha"
            )
        )

        return listMovies
    }

    fun generateDummyListTvShowFavorites(): List<FavoriteEntity> {
        val listTvShows = ArrayList<FavoriteEntity>()
        listTvShows.add(
            FavoriteEntity(
                120168,
                "Who Killed Sara?",
                "24 March 2021",
                "Hell-bent on exacting revenge and proving he was framed for his sister's murder, Álex sets out to unearth much more than the crime's real culprit.",
                "78%",
                "https://image.tmdb.org/t/p/w500/o7uk5ChRt3quPIv8PcvPfzyXdMw.jpg",
                "tv",
                "Drama, Crime, Mystery",
                "José Ignacio Valenzuela",
                "Manolo Cardona, Carolina Miranda, Ginés García Millán, Claudia Ramírez, Eugenio Siller, Alejandro Nones, Ela Velden, Luis Roberto Guzmán, Ana Lucía Domínguez"
            )
        )

        listTvShows.add(
            FavoriteEntity(
                60735,
                "The Flash",
                "07 October 2014",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "77%",
                "https://image.tmdb.org/t/p/w500/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "tv",
                "Drama, Sci-Fi & Fantasy",
                "Greg Berlanti, Geoff Johns, Andrew Kreisberg",
                "Grant Gustin, Candice Patton, Danielle Panabaker, Jesse L. Martin, Carlos Valdes, Tom Cavanagh, Danielle Nicolet, Hartley Sawyer, Keiynan Lonsdale"
            )
        )

        listTvShows.add(
            FavoriteEntity(
                71712,
                "The Good Doctor",
                "25 September 2017",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "86%",
                "https://image.tmdb.org/t/p/w500/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                "tv",
                "Drama",
                "David Shore",
                "Freddie Highmore, Antonia Thomas, Hill Harper, Richard Schiff, Christina Chang, Paige Spara, Fiona Gubelmann, Will Yun Lee, Nicholas Gonzalez"
            )
        )

        listTvShows.add(
            FavoriteEntity(
                88396,
                "The Falcon and the Winter Soldier",
                "19 March 2021",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "79%",
                "https://image.tmdb.org/t/p/w500/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "tv",
                "Sci-Fi & Fantasy, Action & Adventure, Drama, War & Politics",
                "Malcolm Spellman",
                "Anthony Mackie, Sebastian Stan, Emily VanCamp, Wyatt Russell, Daniel Brühl, Erin Kellyman, Danny Ramirez, Adepero Oduye, Indya Bussey"
            )
        )

        listTvShows.add(
            FavoriteEntity(
                1416,
                "Grey's Anatomy",
                "27 March 2005",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "82%",
                "https://image.tmdb.org/t/p/w500/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                "tv",
                "Drama",
                "Shonda Rhimes",
                "Ellen Pompeo, James Pickens Jr., Chandra Wilson, Justin Chambers, Kevin McKidd, Jesse Williams, Patrick Dempsey, Sara Ramirez, Jessica Capshaw"
            )
        )

        return listTvShows
    }
}