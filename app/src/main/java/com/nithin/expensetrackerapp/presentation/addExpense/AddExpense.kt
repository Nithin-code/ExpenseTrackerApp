package com.nithin.expensetrackerapp.presentation.addExpense


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastForEachIndexed
import com.nithin.expensetrackerapp.presentation.bottomsheet.ExpensesBottomSheet
import com.nithin.expensetrackerapp.presentation.theme.AppBackgroundWhiteColor
import com.nithin.expensetrackerapp.presentation.theme.TextGreyColor
import com.nithin.expensetrackerapp.presentation.theme.expenseCardBlackColor
import com.nithin.expensetrackerapp.presentation.theme.iosDarkBlueColor
import com.nithin.expensetrackerapp.presentation.theme.iosWhiteTextBoxColor
import com.nithin.expensetrackerapp.presentation.theme.textGreyDarkColor
import java.text.SimpleDateFormat
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddExpense(
    modifier: Modifier = Modifier
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Add Amount",
                        color = expenseCardBlackColor,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = "BackButton",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = iosWhiteTextBoxColor
                )
            )
        }
    ) {padding->

        Box() {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = AppBackgroundWhiteColor)
                    .padding(padding)
                    .padding(horizontal = 20.dp, vertical = 10.dp)
            ) {

                Text(
                    text = "Amount *",
                    color = textGreyDarkColor,
                    fontWeight = FontWeight.Bold
                )
                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                AmountEditText()

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Text(
                    text = "Description",
                    color = textGreyDarkColor,
                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                DescriptionTextFiled(

                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Text(
                    text = "Expenses Made For *",
                    color = textGreyDarkColor,
                    fontWeight = FontWeight.Bold,
                )

                Spacer(
                    modifier = Modifier.height(10.dp)
                )

                ExpenseMadeForView(

                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                ExpenseMadeOnDate()

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ){
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = iosDarkBlueColor
                        )
                    ) {

                        Button(
                            onClick = {

                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = iosDarkBlueColor
                            )
                        ) {

                            Text(
                                text = "Add Expense",
                                color = AppBackgroundWhiteColor,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )

                        }

                    }
                }

            }
        }
    }

}

@Composable
fun ExpenseMadeForView(
    modifier: Modifier = Modifier
) {

    var isDropDownOpened by remember {
        mutableStateOf(false)
    }

    var expenseReasonList = listOf(
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

    var selectedItemPos by remember {
        mutableIntStateOf(0)
    }

    var shouldShowBottomSheet by remember {
        mutableStateOf(false)
    }



    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Card(
            modifier = Modifier
                .weight(1f),
            colors = CardDefaults.cardColors(
                containerColor = iosWhiteTextBoxColor
            )
        ) {



            Box(
                contentAlignment = Alignment.Center
            ){
                TextField(
                    value = expenseReasonList[selectedItemPos],
                    onValueChange = {

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = iosWhiteTextBoxColor,
                        focusedContainerColor = iosWhiteTextBoxColor,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Number,
                        showKeyboardOnFocus = true,
                    ),

                    label = {
                        Text("Select Reason",color = TextGreyColor)
                    }
                )

                ExpensesBottomSheet(
                    isVisible = shouldShowBottomSheet,
                    shouldShowBottomSheet = {
                        shouldShowBottomSheet = false
                    }
                )


            }

        }

        Spacer(
            modifier = Modifier.width(20.dp)
        )

        Card(
            colors = CardDefaults.cardColors(
                containerColor = iosDarkBlueColor
            )
        ) {

            IconButton(
                onClick = {
                    shouldShowBottomSheet = true
                }
            ) {

                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Spinner",
                    tint = AppBackgroundWhiteColor,
                    modifier = Modifier.size(30.dp)
                )

            }
        }



    }

}


@Composable
fun AmountEditText(
    modifier: Modifier = Modifier
) {

    var amountText by remember {
        mutableStateOf("$50")
    }

    TextField(
        value = amountText,
        onValueChange = {
            amountText = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        shape = RoundedCornerShape(20.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = iosWhiteTextBoxColor,
            focusedContainerColor = iosWhiteTextBoxColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Number,
            showKeyboardOnFocus = true,
        ),

        label = {
            Text("INR",color = TextGreyColor)
        }
    )
}


@Composable
fun DescriptionTextFiled(
    modifier: Modifier = Modifier
) {

    var descText by remember {
        mutableStateOf("spent for coffee")
    }

    TextField(
        value = descText,
        onValueChange = {
            descText = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp),
        shape = RoundedCornerShape(20.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = iosWhiteTextBoxColor,
            focusedContainerColor = iosWhiteTextBoxColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Number,
            showKeyboardOnFocus = true,
        ),

        label = {
            Text("Spend purpose", color = TextGreyColor)
        },

    )


}



@Composable
fun ExpenseMadeOnDate(
    modifier: Modifier = Modifier
) {



    var date by remember {
        mutableStateOf(Date(System.currentTimeMillis()))
    }

    val simpleDateText = SimpleDateFormat("dd/MM/YYYY")

    var dateText by remember {
        mutableStateOf(simpleDateText.format(date))
    }

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        TextField(
            value = dateText,
            onValueChange = {
                dateText = simpleDateText.format(date)
            },
            modifier = Modifier
                .height(55.dp)
                .weight(1f),
            shape = RoundedCornerShape(20.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = iosWhiteTextBoxColor,
                focusedContainerColor = iosWhiteTextBoxColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Number,
                showKeyboardOnFocus = true,
            ),

            label = {
                Text("DD/MM/YYYY",color = TextGreyColor)
            }
        )

        Spacer(
            modifier = Modifier.width(20.dp)
        )

        Card(
            colors = CardDefaults.cardColors(
                containerColor = iosDarkBlueColor
            )
        ) {
            IconButton(
                onClick = {

                }
            ) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Calender",
                    tint = AppBackgroundWhiteColor
                )

            }
        }

    }

}

@Preview(showBackground = true)
@Composable
private fun PreviewAddExpense() {
    AddExpense(

    )
}