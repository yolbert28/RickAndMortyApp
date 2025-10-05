package com.yolbertdev.rickandmortyapp.ui.core.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.yolbertdev.rickandmortyapp.ui.character.CharacterScreen
import com.yolbertdev.rickandmortyapp.ui.characterDetail.CharacterDetailScreen
import com.yolbertdev.rickandmortyapp.ui.episode.EpisodeScreen
import com.yolbertdev.rickandmortyapp.ui.episodeDetail.EpisodeDetailScreen
import com.yolbertdev.rickandmortyapp.ui.home.HomeScreen
import com.yolbertdev.rickandmortyapp.ui.location.LocationScreen
import com.yolbertdev.rickandmortyapp.ui.locationDetail.LocationDetailScreen

@Composable
fun NavigationWrapper(
    onChangeTheme: () -> Unit,
    isDarkTheme: Boolean
) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home) {
        composable<Home>(
            enterTransition = {
                fadeIn()
            },
            exitTransition = {
                fadeOut()
            }
        ) {
            HomeScreen(
                onChangeTheme = onChangeTheme,
                isDarkTheme = isDarkTheme,
                navigateToCharacter = {
                    navController.navigate(Character)
                },
                navigateToEpisode = {
                    navController.navigate(Episode)
                },
                navigateToLocation = {
                    navController.navigate(Location)
                },
            )
        }
        composable<Character>(
            enterTransition = {
                fadeIn()
            },
            exitTransition = {
                fadeOut()
            }
        ) {
            CharacterScreen(
                onChangeTheme = onChangeTheme,
                isDarkTheme = isDarkTheme,
                navigateToDetails = { id: Int ->
                    navController.navigate(CharacterDetail(id))
                }
            ) {
                navController.popBackStack(route = Home, inclusive = false)
            }
        }
        composable<Episode>(
            enterTransition = {
                fadeIn()
            },
            exitTransition = {
                fadeOut()
            }
        ) {
            EpisodeScreen(
                onChangeTheme = onChangeTheme,
                isDarkTheme = isDarkTheme,
                navigateToDetail = { id: Int ->
                    navController.navigate(EpisodeDetail(id))
                }
            ) {
                navController.popBackStack(route = Home, inclusive = false)
            }
        }
        composable<Location>(
            enterTransition = {
                fadeIn()
            },
            exitTransition = {
                fadeOut()
            }
        ) {
            LocationScreen(
                onChangeTheme = onChangeTheme,
                isDarkTheme = isDarkTheme,
                navigateToLocation = { id: Int ->
                    navController.navigate(LocationDetail(id))
                }
            ) {
                navController.popBackStack(route = Home, inclusive = false)
            }
        }
        composable<CharacterDetail>(
            enterTransition = {
                fadeIn()
            },
            exitTransition = {
                fadeOut()
            }
        ) { navBackStackEntry ->
            val characterDetail: CharacterDetail = navBackStackEntry.toRoute()
            CharacterDetailScreen(
                id = characterDetail.id,
                navigateToHome = {
                    navController.popBackStack(route = Home, inclusive = false)
                }, navigateToLocation = { id: Int ->
                    navController.navigate(LocationDetail(id))
                },
                navigateToEpisode = { id: Int ->
                    navController.navigate(EpisodeDetail(id))
                }
            ) {
                navController.popBackStack()
            }
        }
        composable<EpisodeDetail>(
            enterTransition = {
                fadeIn()
            },
            exitTransition = {
                fadeOut()
            }
        ) { navBackStackEntry ->
            val episodeDetail: EpisodeDetail = navBackStackEntry.toRoute()

            EpisodeDetailScreen(
                id = episodeDetail.id,
                navigateToCharacter = { id: Int ->
                    navController.navigate(CharacterDetail(id))
                },
                navigateToHome = {
                    navController.popBackStack(route = Home, inclusive = false)
                }
            ) {
                navController.popBackStack()
            }
        }
        composable< LocationDetail>(
            enterTransition = {
                fadeIn()
            },
            exitTransition = {
                fadeOut()
            }
        ) { navBackStackEntry ->
            val locationDetail: LocationDetail = navBackStackEntry.toRoute()

            LocationDetailScreen(
                id = locationDetail.id,
                navigateToCharacter = { id: Int ->
                    navController.navigate(CharacterDetail(id))
                },
                navigateToHome = {
                    navController.popBackStack(route = Home, inclusive = false)
                }
            ) {
                navController.popBackStack()
            }
        }
    }
}