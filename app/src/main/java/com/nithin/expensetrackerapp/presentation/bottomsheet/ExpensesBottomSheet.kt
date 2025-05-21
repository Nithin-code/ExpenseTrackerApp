package com.nithin.expensetrackerapp.presentation.bottomsheet

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nithin.expensetrackerapp.presentation.theme.iosDarkBlueColor
import com.nithin.expensetrackerapp.presentation.theme.iosWhiteTextBoxColor
import com.nithin.expensetrackerapp.presentation.theme.textGreyDarkColor


val expenseReasonList = listOf(
    "Snacks & Tea" ,
    "Zomato",
    "Swiggy",
    "Restaurant",
    "Uber",
    "Ola",
    "Rapido",
    "Travel",
    "Trip",
    "Team Lunch",
    "Other",
    "Vegetables" ,
    "Non-veg"
)

@Composable
fun ExpensesBottomSheet(
    modifier: Modifier = Modifier,
    isVisible : Boolean = false,
    shouldShowBottomSheet : (Boolean) -> Unit
) {



    val animateValue = animateOffsetAsState(
        targetValue = if(isVisible) Offset(0f,0f) else Offset(600f,600f),
        animationSpec = tween(durationMillis = 1000)
    )

    Box(
        modifier = Modifier
            .clickable{
                shouldShowBottomSheet.invoke(false)
            }
            .fillMaxSize()
            .background(
                color = Color.Transparent
            )
    ){

        Box(modifier = Modifier
            .offset(
                x = animateValue.value.x.dp,
                y = animateValue.value.y.dp
            ).height(
                300.dp
            )
            .align(Alignment.BottomCenter)
            .fillMaxWidth()
            .height(300.dp)
        ){
            Card(
                shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                colors = CardDefaults.cardColors(
                    containerColor = iosWhiteTextBoxColor
                )
            ) {

                LazyColumn(
                    modifier = Modifier.fillMaxWidth()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    items(Int.MAX_VALUE) {index->
                        val pos = index % expenseReasonList.size

                        Text(
                            text = expenseReasonList[pos],
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                                .height(30.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }


            }

            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "left",
                modifier = Modifier.align(
                    Alignment.CenterEnd
                ).size(
                    28.dp
                )
            )

        }

    }




}

@Preview(showBackground = true)
@Composable
private fun Prev() {
    ExpensesBottomSheet(

    ){

    }
}