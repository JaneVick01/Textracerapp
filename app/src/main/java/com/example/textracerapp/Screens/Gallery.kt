package com.example.textracerapp.Screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.textracerapp.R


@Composable
fun RepeatImages(navController: NavHostController) {
    // Repeat the Image ten times in a row
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(3) {
            Image(
                painter = painterResource(id = R.drawable.uploadimagee),
                contentDescription = stringResource(id = R.string.uploadpicture),
                modifier = Modifier
                    .clickable {
                        navController.navigate("upload_evidence")
                    }
                    .padding(8.dp)
            )
        }
    }
}


@Composable
fun GalleryPage(
    navController: NavHostController,
    context: Context,
) {
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Please choose an image",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 50.dp)
        )

        RepeatImages(navController = navController)


        Spacer(modifier = Modifier.height(50.dp))

        }
}
