package com.wajahatkarim3.composecodelab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.ModifierInfo
import androidx.ui.core.setContent
import androidx.ui.foundation.*
import androidx.ui.foundation.lazy.LazyColumnItems
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Surface
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp

class GmailDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmailItemView()
        }
    }
}

@Preview(widthDp = 320)
@Composable
fun EmailItemView()
{
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxWidth().padding(top = 8.dp, start = 8.dp, end = 8.dp)
    ) {
        Row(
            verticalGravity = Alignment.Top
        ) {
            EmailItemAvatarView()

            Spacer(modifier = Modifier.size(10.dp))

            Column(modifier = Modifier.weight(1f)) {
                EmailItemSenderView()
                EmailItemTitleView()
                EmailItemSummaryView()
            }
        }
    }
}

@Composable
fun EmailItemSenderView()
{
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalGravity = Alignment.Top
    ) {
        Icon(
            asset = vectorResource(id = R.drawable.ic_baseline_label_important_24),
            tint = Color(0xFFFFE229)
        )

        Spacer(
            modifier = Modifier.size(5.dp)
        )

        Text(
            text = "Android Weekly",
            style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.weight(1f)
        )

        Text(
            text = "Jul 15",
            style = TextStyle(
                color = Color.DarkGray,
                fontSize = 14.sp
            )
        )
    }
}

@Composable
fun EmailItemTitleView()
{
    Text(
        text = "Android Weekly # 182",
        style = TextStyle(
            color = Color.DarkGray,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
    )
}

@Composable
fun EmailItemSummaryView()
{
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalGravity = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "View in browser the latest issue of Android Weekly # 182",
            style = TextStyle(
                color = Color.Gray,
                fontSize = 14.sp
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f)
        )

        Icon(
            asset = vectorResource(id = R.drawable.ic_baseline_star_24),
            tint = Color.LightGray
        )
    }
}

@Composable
fun EmailItemAvatarView()
{
    Box(
        backgroundColor = Color.Blue,
        shape = CircleShape,
        modifier = Modifier.size(40.dp),
        gravity = Alignment.Center
    ) {
        Text(
            text = "A",
            style = TextStyle(
                color = Color.White,
                fontSize = 15.sp
            )
        )
    }
}