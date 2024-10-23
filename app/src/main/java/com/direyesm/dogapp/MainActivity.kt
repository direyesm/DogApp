package com.direyesm.dogapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.direyesm.dogapp.screen.DogBreedsScreen
import com.direyesm.dogapp.screen.DogImagesScreen
import com.direyesm.dogapp.ui.theme.DogAppTheme
import com.direyesm.dogapp.viewmodel.DogBreedsViewModel
import com.direyesm.dogapp.viewmodel.DogImagesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val dogBreedsViewModel: DogBreedsViewModel by viewModels()
    private val dogImagesViewModel: DogImagesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DogAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "dogBreeds"
                ) {
                    composable("dogBreeds") {
                        DogBreedsScreen(
                            viewModel = dogBreedsViewModel,
                            onBreedClick = { breed ->
                                navController.navigate("dogImages/$breed")
                            }
                        )
                    }
                    composable("dogImages/{breed}") { backStackEntry ->
                        val breed = backStackEntry.arguments?.getString("breed")
                        breed?.let {
                            DogImagesScreen(
                                viewModel = dogImagesViewModel,
                                breed = it,
                                onBackClick = { navController.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}
