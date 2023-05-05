package com.ad_coding.apollographqlcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ad_coding.apollographqlcourse.ui.screen.character_detail.CharacterScreen
import com.ad_coding.apollographqlcourse.ui.screen.character_list.CharacterListScreen
import com.ad_coding.apollographqlcourse.ui.theme.ApolloGraphQLCourseTheme
import com.ad_coding.apollographqlcourse.ui.util.Route
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApolloGraphQLCourseTheme {

            }
        }
    }
}