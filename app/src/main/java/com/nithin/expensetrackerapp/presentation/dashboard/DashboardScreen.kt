package com.nithin.expensetrackerapp.presentation.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nithin.expensetrackerapp.R
import com.nithin.expensetrackerapp.presentation.theme.AppBackgroundWhiteColor
import com.nithin.expensetrackerapp.presentation.theme.TextGreyColor
import com.nithin.expensetrackerapp.presentation.theme.expenseCardBlackColor
import com.nithin.expensetrackerapp.presentation.theme.textGreyDarkColor

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier
) {
    

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = AppBackgroundWhiteColor
            )
    ) {
        DashboardTitle(
            modifier = Modifier.height(100.dp)
        )
        ExpenseCard(
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            expenseAmount = "18,000"
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        AllExpensesList(

        )

    }

}

@Composable
fun DashboardTitle(
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = Icons.Default.MailOutline,
            contentDescription = "email",
            modifier = Modifier.size(35.dp)
        )
        Spacer(
            modifier = Modifier.width(15.dp)
        )
        Text(
            text = "Dashboard",
            fontSize = 24.sp,
            color = expenseCardBlackColor,
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.Bold
        )

        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Account Circle",
            modifier = Modifier.size(35.dp)
        )
    }

}

@Composable
fun ExpenseCard(
    modifier: Modifier = Modifier,
    expenseAmount : String = ""
) {

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = expenseCardBlackColor,
        ),
        shape = RoundedCornerShape(40.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(
                    R.drawable.rupee,
                ),
                contentDescription = "Rupee icon",
                modifier = Modifier.size(40.dp),
                tint = AppBackgroundWhiteColor
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = expenseAmount,
                fontSize = 38.sp,
                color = AppBackgroundWhiteColor,
                modifier = Modifier.weight(1f),
            )

            Text(
                text = "INR",
                fontSize = 20.sp,
                color = TextGreyColor,
                textAlign = TextAlign.End
            )

        }

    }
    
}

@Composable
fun AllExpensesList(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "All Expenses",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )

            Card(
                modifier = Modifier
            ) {

                Text(
                    text = "View All",
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.CenterHorizontally),
                    color = textGreyDarkColor,
                    fontWeight = FontWeight.Bold
                )

            }

        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier
        ) {

            Text(
                text = "Today",
                fontSize = 18.sp,
                color = textGreyDarkColor,
                fontWeight = FontWeight.Bold
            )

        }

    }
}

@Composable
fun ExpenseCard(
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Circle Check"
            )



        }

    }

}


@Preview
@Composable
private fun PreviewDashboardScreen() {
    DashboardScreen()
}