package com.wajahatkarim3.composecodelab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.*
import androidx.ui.foundation.lazy.LazyColumnItems
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.IconButton
import androidx.ui.material.Scaffold
import androidx.ui.material.Surface
import androidx.ui.material.TopAppBar
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Menu
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.style.TextOverflow
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.wajahatkarim3.composecodelab.model.EmailModel
import com.wajahatkarim3.composecodelab.ui.ComposeCodelabTheme
import kotlin.random.Random

class GmailDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeCodelabTheme {
                Scaffold(
                    backgroundColor = Color.White,
                    topBar = {
                        TopAppBar(
                            backgroundColor = Color.White,
                            title = {
                                Text(text = "Gmail 360Andev")
                            },
                            navigationIcon = {
                                IconButton(onClick = { }) {
                                    Icon(asset = Icons.Default.Menu)
                                }
                            },
                            actions = {
                                EmailItemAvatarView(avatarLetter = 'W')
                            }
                        )
                    }
                ) {
                    EmailsListView()
                }
            }
        }
    }
}

@Composable
fun EmailsListView()
{
    var emailsList = generateEmailList()

    LazyColumnItems(items = emailsList) {email ->
        EmailItemView(email = email)
    }

}

@Composable
fun EmailItemView(email: EmailModel)
{
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxWidth().padding(top = 8.dp, start = 8.dp, end = 8.dp)
    ) {
        Row(
            verticalGravity = Alignment.Top
        ) {
            EmailItemAvatarView(email.sender[0])

            Spacer(modifier = Modifier.size(10.dp))

            Column(modifier = Modifier.weight(1f)) {
                EmailItemSenderView(email.sender, email.isImportant, email.date)
                EmailItemTitleView(email.subject)
                EmailItemSummaryView(email.summary, email.isStarred)
                Spacer(modifier = Modifier.size(10.dp))
            }
        }
    }
}

@Composable
fun EmailItemSenderView(sender: String, important: Boolean, date: String)
{
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalGravity = Alignment.Top
    ) {
        if (important)
        {
            Icon(
                asset = vectorResource(id = R.drawable.ic_baseline_label_important_24),
                tint = Color(0xFFFFE229)
            )

            Spacer(modifier = Modifier.size(5.dp))
        }

        Text(
            text = sender,
            style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.weight(1f)
        )

        Text(
            text = date,
            style = TextStyle(
                color = Color.DarkGray,
                fontSize = 14.sp
            )
        )
    }
}

@Composable
fun EmailItemTitleView(subject: String)
{
    Text(
        text = subject,
        style = TextStyle(
            color = Color.DarkGray,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
    )
}

@Composable
fun EmailItemSummaryView(summary: String, starred: Boolean)
{
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalGravity = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = summary,
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
            tint = if (starred) Color(0xFFFFE229) else Color.LightGray
        )
    }
}

@Composable
fun EmailItemAvatarView(avatarLetter: Char)
{
    Box(
        backgroundColor = generateRandomColor(),
        shape = CircleShape,
        modifier = Modifier.size(40.dp),
        gravity = Alignment.Center
    ) {
        Text(
            text = avatarLetter.toString(),
            style = TextStyle(
                color = Color.White,
                fontSize = 15.sp
            )
        )
    }
}

fun generateEmailList() : List<EmailModel>
{
    var list = arrayOf(
        EmailModel(
            sender = "Wajahat Karim",
            isImportant = true,
            summary = "Demo is developed by Wajahat Karim. \n\n Check his work at wajahatkarim.com \n",
            isStarred = true,
            subject = "Made with ❤ by Wajahat Karim",
            date = "Apr 26"
        ),

        EmailModel(
            sender = "Android Weekly",
            isImportant = true,
            summary = "View in browser Android Weekly #419\nLorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",
            isStarred = false,
            subject = "Android Weekly #419",
            date = "Apr 26"
        ),

        EmailModel(
            sender = "Kotlin Weekly",
            isImportant = false,
            summary = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",
            isStarred = false,
            subject = "Kotlin Weekly #195",
            date = "Apr 19"
        ),

        EmailModel(
            sender = "Google Developers Expert",
            isImportant = true,
            summary = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",
            isStarred = true,
            subject = "\uD83C\uDF89 Welcome to GDE Program \uD83C\uDF7E",
            date = "Feb 25"
        ),

        EmailModel(
            sender = "Slack",
            isImportant = false,
            summary = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",
            isStarred = false,
            subject = "Notifications from the Android Dev Chat workspace",
            date = "Feb 21"
        ),

        EmailModel(
            sender = "Medium Writer Program",
            isImportant = true,
            summary = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",
            isStarred = false,
            subject = "Your story has been recommended in topics on Medium",
            date = "Jan 18"
        ),

        EmailModel(
            sender = "Android Weekly",
            isImportant = true,
            summary = "View in browser Android Weekly #419\nLorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",
            isStarred = false,
            subject = "Android Weekly #419",
            date = "Apr 26"
        ),

        EmailModel(
            sender = "Kotlin Weekly",
            isImportant = false,
            summary = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",
            isStarred = false,
            subject = "Kotlin Weekly #195",
            date = "Apr 19"
        ),

        EmailModel(
            sender = "Google Developers Expert",
            isImportant = true,
            summary = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",
            isStarred = true,
            subject = "\uD83C\uDF89 Welcome to GDE Program \uD83C\uDF7E",
            date = "Feb 25"
        ),

        EmailModel(
            sender = "Slack",
            isImportant = false,
            summary = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",
            isStarred = false,
            subject = "Notifications from the Android Dev Chat workspace",
            date = "Feb 21"
        ),

        EmailModel(
            sender = "Medium Writer Program",
            isImportant = true,
            summary = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",
            isStarred = false,
            subject = "Your story has been recommended in topics on Medium",
            date = "Jan 18"
        )
    )

    return list.toList()
}

fun generateRandomColor() : Color
{
    var colors = arrayOf(
        Color(0xFF9E9E9E),
        Color(0xFF8B8B8B),
        Color(0xFFF17575),
        Color(0xFF1AC01A),
        Color(0xFF7F7FCA),
        Color(0xFFC5C525),
        Color(0xFF4DC0C0),
        Color(0xFFCE52CE)
    )

    var index = Random(System.currentTimeMillis()).nextInt(from = 0, until = colors.size-1)
    return colors[index]

}