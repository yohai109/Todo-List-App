package com.yohai.todolistapp

import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.yohai.todolistapp.models.Task

@Preview
@Composable
fun TaskListItem(
    item: Task = Task(title = "click", order = 1),
    onCompleteChange: (Task) -> Unit = {}
) {
    ConstraintLayout {
        val (title, subTitle, checkbox) = createRefs()

        Text(
            text = item.title,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top)
            },
            fontSize = 16.sp
        )

        Text(
            text = item.id,
            modifier = Modifier.constrainAs(subTitle) { top.linkTo(title.bottom) },
            fontSize = 12.sp
        )

        Checkbox(
            checked = item.isCompleted,
            modifier = Modifier.constrainAs(checkbox) {
                top.linkTo(title.top)
                bottom.linkTo(subTitle.bottom)
                end.linkTo(parent.end)
            },
            onCheckedChange = { onCompleteChange(item.copy(isCompleted = it)) }
        )
    }

}