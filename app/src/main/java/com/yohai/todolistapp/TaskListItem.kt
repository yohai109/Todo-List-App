package com.yohai.todolistapp

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.yohai.todolistapp.models.Task

@Preview
@Composable
fun TaskListItem(
    item: Task = Task(title = "click", body = "this is the body", order = 1),
    onCompleteChange: (Task) -> Unit = {}
) {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {
        val (title, subTitle, checkbox) = createRefs()

        Text(
            text = item.title,
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top)
            },
            style = MaterialTheme.typography.h2
        )
        if (item.body.isNotBlank()) {
            Text(
                text = item.body,
                modifier = Modifier.constrainAs(subTitle) { top.linkTo(title.bottom) },
                style = MaterialTheme.typography.body1
            )
        }
        Checkbox(
            checked = item.isCompleted,
            modifier = Modifier.constrainAs(checkbox) {
                top.linkTo(title.top)
                bottom.linkTo(subTitle.bottom)
                end.linkTo(parent.end)
            },
            onCheckedChange = {
                onCompleteChange(item.copy(isCompleted = it))
            }
        )
    }

}