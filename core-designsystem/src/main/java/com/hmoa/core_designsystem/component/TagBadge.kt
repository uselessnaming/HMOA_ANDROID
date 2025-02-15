package com.hmoa.core_designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hmoa.core_designsystem.theme.CustomColor
import com.hmoa.core_designsystem.theme.pretendard

@Composable
fun TagBadge(
    height : Dp = 28.dp,
    tag : String,
    isClickable : Boolean = false,
    isSelected:Boolean? = false,
    onClick : (String) -> Unit = {},
){
    val backgroundColor = if (isSelected?:true) Color.Black else Color.White
    val borderColor = if (isSelected?:true) Color.Black else CustomColor.gray3
    val textColor = if (isSelected?:true) Color.White else Color.Black
    Text(
        modifier = Modifier
            .wrapContentWidth()
            .height(height)
            .background(color = backgroundColor, shape = RoundedCornerShape(14.dp))
            .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(14.dp))
            .then(
                if (isClickable) {
                    Modifier.clickable{onClick(tag)}
                } else {
                    Modifier
                }
            )
            .padding(horizontal = 14.dp).padding(top = 8.dp, bottom = 8.dp),
        text = tag,
        fontSize = 12.sp,
        fontFamily = pretendard,
        fontWeight = FontWeight.Normal,
        color = textColor,
        textAlign = TextAlign.Center,
    )
}

@Preview
@Composable
fun TestMagazineTag(){
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ){
        TagBadge(tag = "#매거진", isClickable = true)
        TagBadge(tag = "#HBTI", isClickable = false, isSelected = true)
        TagBadge(tag = "#HBTI", isClickable = false, isSelected = false)
    }
}