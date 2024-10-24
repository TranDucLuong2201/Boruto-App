package com.example.boruto.presentation.screen.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.boruto.R
import com.example.boruto.domain.model.OnBoardingPage
import com.example.boruto.ui.theme.EXTRA_LARGE_PADDING
import com.example.boruto.ui.theme.MEDIUM_PADDING
import com.example.boruto.ui.theme.SMALL_PADDING
import com.example.boruto.ui.theme.activeIndicatorColor
import com.example.boruto.ui.theme.buttonBackgroundColor
import com.example.boruto.ui.theme.descriptionColor
import com.example.boruto.ui.theme.inactiveIndicatorColor
import com.example.boruto.ui.theme.titleColor
import com.example.boruto.ui.theme.welcomeScreenBackGroundColor
import com.example.boruto.util.Constant.LAST_ON_BOARDING_PAGE
import com.example.boruto.util.Constant.ON_BOARDING_PAGE_COUNT

@Composable
fun WelcomeScreen(navController: NavHostController) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third,
    )

    val pagerState = rememberPagerState(pageCount = {ON_BOARDING_PAGE_COUNT})

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.welcomeScreenBackGroundColor)
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerState,
            verticalAlignment = Alignment.Top,
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        Row(
            Modifier
                .weight(1f)
                .fillMaxWidth()
                .align(Alignment.End),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration)
                    MaterialTheme.colorScheme.activeIndicatorColor
                else MaterialTheme.colorScheme.inactiveIndicatorColor
                Box(
                    modifier = Modifier
                        .padding(5.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(16.dp)
                )
            }
        }
        FinishButton(
            modifier = Modifier.weight(2f),
            pagerState = pagerState
        ) { }
    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = stringResource(R.string.on_boarding_image)
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = onBoardingPage.title,
            color = MaterialTheme.colorScheme.titleColor,
            fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
                .padding(top = MEDIUM_PADDING)
                .padding(bottom = SMALL_PADDING),
            text = onBoardingPage.description,
            color = MaterialTheme.colorScheme.descriptionColor,
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun FinishButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () ->Unit
) {
    Row(
        modifier = modifier.padding(all= MEDIUM_PADDING),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == LAST_ON_BOARDING_PAGE
        ) {
            ElevatedButton(
                onClick = onClick,
                colors = ButtonDefaults.elevatedButtonColors(
                    contentColor = Color.White,
                    containerColor = MaterialTheme.colorScheme.buttonBackgroundColor
                )) {
                Text("Finish")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FirstOnBoardingScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.First)
    }
}
@Preview(showBackground = true)
@Composable
private fun SecondOnBoardingScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.Second)
    }
}
@Preview(showBackground = true)
@Composable
private fun ThirdOnBoardingScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.Third)
    }
}