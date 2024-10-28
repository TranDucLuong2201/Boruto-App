package com.example.boruto.presentation.screen.home

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.boruto.R
import com.example.boruto.ui.theme.topAppBarActionIcons
import com.example.boruto.ui.theme.topAppBarBackGroundColor
import com.example.boruto.ui.theme.topAppBarContentColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(onSearchClicked: () -> Unit) {

    TopAppBar(
        title = { Text("Explore") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.topAppBarBackGroundColor,
            titleContentColor = MaterialTheme.colorScheme.topAppBarContentColor,
            actionIconContentColor = MaterialTheme.colorScheme.topAppBarActionIcons),
        actions = {
            IconButton(onClick = onSearchClicked ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_icon)
                )
            }
        })

}

@Preview
@Composable
private fun HomeTopBarReview() {
    HomeTopBar{}
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun HomeTopBarDarkModeReview() {
    HomeTopBar{}
}