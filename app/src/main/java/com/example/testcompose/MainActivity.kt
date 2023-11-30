package com.example.testcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testcompose.ui.Student
import com.example.testcompose.ui.theme.TestComposeTheme

class MainActivity : ComponentActivity() {
    val list = listOf<Student>(
        Student(1, "Student 1", "Student 1 Descsdafsadffsdfsadfsdfsdffasefsadfsdf"),
        Student(
            2,
            "Student 2",
            "Student 2 Descsadfasdfasdfsadfasdffasdfsdfsdfxcvbsdfgbhsdfgxzcvszdfvsdfgsdfgsdfg4retsagdxcvbbsdgbsdghdsfgergxcvbbcxcvbhbegsdfgxcvbxcfvbdxf"
        ),
        Student(3, "Student 3", "Student 3 Desc"),
        Student(4, "Student 4", "Student 4 Desc"),
        Student(5, "Student 5", "Student 5 Desc"),
        Student(6, "Student 6", "Student 6 Desc"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestComposeTheme {
                // A surface container using the 'background' color from the theme
                Greeting(student = list)

            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier, student: List<Student>) {

    LazyColumn {
        items(student) { student ->
            Surface(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp, start = 10.dp, end = 10.dp),
                tonalElevation = 58.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = CutCornerShape(8.dp),
                border = BorderStroke(1.dp, Color.Black)
            ) {
                var isExpand by remember { mutableStateOf(false) }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clickable { isExpand = !isExpand }
                        .animateContentSize(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessLow
                            )

                        )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "Student Image",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .border(1.dp, Color.Black)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = student.name,
                            style = MaterialTheme.typography.displaySmall
                        )
                        AnimatedVisibility(visible = isExpand) {
                            Text(
                                text = student.desc,
                                style = MaterialTheme.typography.bodySmall,
                                maxLines = if (isExpand) Int.MAX_VALUE else 1
                            )
                        }

                    }
                }
            }
        }
    }


}

