package com.example.textracerapp.Screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.textracerapp.R


@Composable
fun RoundedButton(text: String) {
    Button(
        onClick = { /* Handle button click */ },
        shape = RoundedCornerShape(percent = 50),
        colors = ButtonDefaults.buttonColors(Color.Gray)
    ) {
        Text(text = text)
    }
}

@Composable
fun UploadButton(
    navController: NavHostController,
    context: Context,
) {
    Button(
        onClick = { navController.navigate("upload_evidence") },
        shape = RoundedCornerShape(percent = 50),
        colors = ButtonDefaults.buttonColors(Color.Magenta)
    ) {
        Text(text = "Start Uploading Order Evidence")
    }
}

@Composable
fun EnabledCheckbox() {
    val isChecked = remember { mutableStateOf(true) }

    Checkbox(checked = isChecked.value, onCheckedChange = { isChecked.value = it }, enabled = true)
}

@Composable
fun GroupedCheckbox(mItemsList: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        mItemsList.forEach { items ->
            val isChecked = remember { mutableStateOf(true) }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = isChecked.value,
                    onCheckedChange = { isChecked.value = it },
                    enabled = true,
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.DarkGray,
                        uncheckedColor = Color.DarkGray,
                        checkmarkColor = Color.White
                    )
                )
                Spacer(modifier = Modifier.width(8.dp)) // Add some spacing between checkbox and text
                Text(text = items)

            }
        }
    }
}

@Composable
fun OrderEvidencePage(
    navController: NavHostController,
    context: Context,
) {
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Please tap on the checkmark to upload order evidence for the selected step(s)",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 20.dp)
        )
//            Image(
//                painter = painterResource(id = R.drawable.uploadimagee),
//                contentDescription = stringResource(id = R.string.uploadpicture)
//            )

        GroupedCheckbox(
            mItemsList = listOf(
                "Dyeing",
                "Tanning",
                "Fabric Trading",
                "Design & Development"
            )
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Choose the steps that share the same order evidence:",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        // Grouped Rounded Buttons
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RoundedButton("Dyeing   +")
                RoundedButton("Tanning   +")
            }

            // Rounded Buttons
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                itemsIndexed(
                    listOf(
                        "Fabric Trading   +",
                        "Design & Development   +"
                    )
                ) { index, buttonText ->
                    RoundedButton(buttonText)
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        UploadButton(navController = navController, context = context)
    }
}


