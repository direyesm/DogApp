package com.direyesm.dogapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.direyesm.dogapp.viewmodel.DogImagesViewModel


@Composable
fun DogImagesScreen(
    viewModel: DogImagesViewModel,
    breed: String,
    onBackClick: () -> Unit
) {
    val dogImage by viewModel.image.collectAsState()

    LaunchedEffect(breed) {
        viewModel.fetchBreedImage(breed)
    }

    Scaffold(
        topBar = {
            TopBar(breed, onBackClick)
        },
        content = { paddingValues ->
            AnimatedVisibility(
                visible = dogImage.isNotEmpty(),
                enter = fadeIn() + expandIn(),
                exit = fadeOut() + shrinkOut()
            ) {
                DogImage(dogImage = dogImage, paddingValues = paddingValues)
            }
        }
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(breed: String, onBackClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = breed.capitalize()) },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        }
    )
}

@Composable
fun DogImage(dogImage: String, paddingValues: PaddingValues) {
    if (dogImage.isEmpty()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        AsyncImage(
            model = dogImage,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Fit
        )
    }
}