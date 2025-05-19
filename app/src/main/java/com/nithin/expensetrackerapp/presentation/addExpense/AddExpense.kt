package com.nithin.expensetrackerapp.presentation.addExpense


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nithin.expensetrackerapp.presentation.theme.expenseCardBlackColor
import com.nithin.expensetrackerapp.presentation.theme.textGreyDarkColor

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
                }
            )
        }
    ) {padding->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 20.dp)
        ) {

            Text(
                text = "Amount",
                color = textGreyDarkColor,
                fontWeight = FontWeight.Bold
            )
            Spacer(
                modifier = Modifier.height(10.dp)
            )

            AmountEditText(

            )

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
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = TextFieldDefaults.colors(

        )
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewAddExpense() {
    AddExpense(

    )
}