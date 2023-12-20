package com.example.textracerapp.Screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import com.example.textracerapp.data.ListItem
import com.example.textracerapp.data.listItems


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TasksPage(
    navController: NavHostController,
    context: Context,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "List Screen")
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle navigation icon clicked */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Navigation menu")
                    }
                },
            )
        }
    ) {

        MyList(listItems = listItems)
    }

}

@Composable
fun MyList(listItems: List<ListItem>) {
    LazyColumn {
        items(listItems) { item ->
            ListItem(item)
        }
    }
}

@Composable
fun ListItem(item: ListItem) {
    Card(
        modifier = Modifier.padding(10.dp),
        shape = RoundedCornerShape(15.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .weight(1f)
            ) {
                Text(
                    text = item.title,
                    style = TextStyle(
                        color = Color(0xFF2b2b2b),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
                Text(text = item.subtitle, style = MaterialTheme.typography.bodyMedium)
            }
            IconButton(
                onClick = {}
            ) {
                Icon(imageVector = Icons.Outlined.Phone, contentDescription = "")
            }
        }
    }
}
