package com.wajahatkarim3.composecodelab

import android.os.Bundle
import android.widget.Space
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Spacer
import androidx.ui.layout.fillMaxHeight
import androidx.ui.layout.padding
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.wajahatkarim3.composecodelab.ui.ComposeCodelabTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCodelabTheme {
                MyApp {
                    MyScreenContent()
                }
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable() () -> Unit) {
    Surface(color = Color.Yellow) {
        content()
    }
}

@Composable
fun MyScreenContent(titles: List<String> = arrayListOf<String>("Android", "Kotlin")) {

    val counterState = state { 0 }

    Column(modifier = Modifier.fillMaxHeight()) {
        Surface(color = Color.Blue, modifier = Modifier.weight(1f)) {
            Column() {
                for (name in titles)
                {
                    Greeting(name = name + " ${counterState.value}")
                    Divider(color = Color.Black)
                }
            }
        }

        Spacer(modifier = Modifier.padding(top = 20.dp))
        Counter(count = counterState.value, onCountUpdated = {newCount ->
            counterState.value = newCount
        })
    }
}

@Composable
fun Counter(count: Int, onCountUpdated: (Int) -> Unit)
{
    Button(onClick = { onCountUpdated(count+1) }) {
        Text(text = "Clicked ${count} times")
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        modifier = Modifier.padding(10.dp),
        style = MaterialTheme.typography.h1
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeCodelabTheme {
        MyApp {
            MyScreenContent()
        }
    }
}