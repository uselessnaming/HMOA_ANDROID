package com.hmoa.feature_userinfo.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hmoa.core_common.ErrorUiState
import com.hmoa.core_designsystem.component.AppLoadingScreen
import com.hmoa.core_designsystem.component.Button
import com.hmoa.core_designsystem.component.ErrorUiSetView
import com.hmoa.core_designsystem.component.RadioButtonList
import com.hmoa.core_designsystem.component.TopBar
import com.hmoa.feature_userinfo.viewModel.MyGenderUiState
import com.hmoa.feature_userinfo.viewModel.MyGenderViewModel

@Composable
fun MyGenderRoute(
    navBack: () -> Unit,
    viewModel: MyGenderViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val errorState = viewModel.errorUiState.collectAsStateWithLifecycle()
    val saveGender = remember<(gender: String)->Unit>{{ viewModel.saveGender(it, navBack)}}

    MyGenderPage(
        uiState = uiState.value,
        errorState = errorState.value,
        saveGender = saveGender,
        navBack = navBack
    )
}

@Composable
fun MyGenderPage(
    uiState: MyGenderUiState,
    errorState: ErrorUiState,
    saveGender: (gender: String) -> Unit,
    navBack: () -> Unit,
) {
    when (uiState) {
        MyGenderUiState.Loading -> AppLoadingScreen()
        is MyGenderUiState.Success -> {
            SelectGenderContent(
                initGender = uiState.defaultGender,
                saveGender = saveGender,
                navBack = navBack
            )
        }

        MyGenderUiState.Error -> {
            ErrorUiSetView(
                onLoginClick = navBack,
                errorUiState = errorState,
                onCloseClick = navBack
            )
        }
    }
}

@Composable
private fun SelectGenderContent(
    initGender: String,
    saveGender: (gender: String) -> Unit,
    navBack: () -> Unit
) {
    var currentGender by remember{mutableStateOf(initGender)}
    val isEnabled by remember{derivedStateOf{initGender != currentGender}}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        TopBar(
            navIcon = painterResource(com.hmoa.core_designsystem.R.drawable.ic_back),
            onNavClick = navBack,
            title = "성별"
        )
        Spacer(Modifier.height(38.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(28.dp)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButtonList(
                initValue = currentGender,
                radioOptions = listOf("남성", "여성"),
                onButtonClick = { currentGender = it }
            )
        }
        Spacer(Modifier.weight(1f))
        Button(
            buttonModifier = Modifier
                .fillMaxWidth()
                .height(78.dp),
            isEnabled = isEnabled,
            btnText = "변경",
            onClick = { saveGender(currentGender) }
        )
    }
}
