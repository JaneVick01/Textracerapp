package com.example.textracerapp.Screens

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Notifications
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
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
                    Text(text = "Tasks")
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle navigation icon clicked */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Navigation menu")
                    }
                },
            )
        }
    ) {

//        MyList(listItems = listItems)
        MyUI()
    }

}

@Composable
fun MyUI() {
    val optionsList = prepareOptionsList()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(space = 24.dp), // gap between items
        contentPadding = PaddingValues(all = 22.dp) // padding for LazyColumn layout
    ) {
        items(optionsList) { item ->
            ItemLayout(optionsList = item)
        }
    }
}

// single item layout
@Composable
private fun ItemLayout(
    optionsList: OptionsList,
    context: Context = LocalContext.current.applicationContext
) {
    Card(
        shape = RoundedCornerShape(size = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    Toast
                        .makeText(context, optionsList.option, Toast.LENGTH_SHORT)
                        .show()
                }
                .padding(vertical = 10.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(size = 36.dp),
                imageVector = optionsList.icon,
                contentDescription = null,
                tint = Color(0xFF6650a4)
            )
            Spacer(modifier = Modifier.width(width = 12.dp))
            Text(
                text = optionsList.option,
                fontSize = 16.sp
            )
        }
    }
}

// prepare the list
private fun prepareOptionsList(): MutableList<OptionsList> {
    val optionsList = mutableListOf<OptionsList>()

    optionsList.add(OptionsList(icon = Icons.Outlined.Favorite, option = "Upload order evidence"))
    optionsList.add(OptionsList(icon = Icons.Outlined.Notifications, option = "Upload order evidence"))
    optionsList.add(OptionsList(icon = Icons.Outlined.Notifications, option = "Upload order evidence"))
    optionsList.add(OptionsList(icon = Icons.Outlined.Notifications, option = "Upload order evidence"))
    optionsList.add(OptionsList(icon = Icons.Outlined.Notifications, option = "Upload order evidence"))
    optionsList.add(OptionsList(icon = Icons.Outlined.Notifications, option = "Upload order evidence"))
    optionsList.add(OptionsList(icon = Icons.Outlined.Notifications, option = "Upload order evidence"))
    optionsList.add(OptionsList(icon = Icons.Outlined.Notifications, option = "Upload order evidence"))
    optionsList.add(OptionsList(icon = Icons.Outlined.Notifications, option = "Upload order evidence"))
    optionsList.add(OptionsList(icon = Icons.Outlined.Notifications, option = "Upload order evidence"))
    return optionsList
}

data class OptionsList(val icon: ImageVector, val option: String)

//
//@Composable
//fun MyList(listItems: List<ListItem>) {
//    LazyColumn {
//        items(listItems) { item ->
//            ListItem(item)
//        }
//    }
//}
//
//@Composable
//fun ListItem(item: ListItem) {
//    Card(
//        modifier = Modifier.padding(10.dp),
//        shape = RoundedCornerShape(15.dp)
//    ) {
//        Row(
//            modifier = Modifier
//                .padding(16.dp)
//                .fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Column(
//                modifier = Modifier
//                    .padding(horizontal = 20.dp)
//                    .weight(1f)
//            ) {
//                Text(
//                    text = item.title,
//                    style = TextStyle(
//                        color = Color(0xFF2b2b2b),
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 16.sp
//                    )
//                )
//                Text(text = item.subtitle, style = MaterialTheme.typography.bodyMedium)
//            }
//            IconButton(
//                onClick = {}
//            ) {
//                Icon(imageVector = Icons.Outlined.Phone, contentDescription = "")
//            }
//        }
//    }
//}
