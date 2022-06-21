package com.example.composetdaapp.ui.compose.orders

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.composetdaapp.R
import com.example.composetdaapp.data.entities.orders.get.GetOrderItem
import com.example.composetdaapp.utils.EXPAND_ANIMATION_DURATION

@ExperimentalAnimationApi
@Composable
fun ExpandableList(
    //pass viewModelHilts
    order: GetOrderItem,
    onCardArrowClick: () -> Unit,
    expanded: Boolean,
) {
    val transitionState = remember {
        MutableTransitionState(expanded).apply {
            targetState = !expanded
        }
    }
    val transition = updateTransition(transitionState, label = "")
    val cardBgColor by transition.animateColor({
        tween(durationMillis = EXPAND_ANIMATION_DURATION)
    }, label = "") {
        if (expanded == it) Color.White else Color.White
    }
    val cardPaddingHorizontal by transition.animateDp({
        tween(durationMillis = EXPAND_ANIMATION_DURATION)
    }, label = "") {
        if (expanded == it) 24.dp else 48.dp
    }
    val cardElevation by transition.animateDp({
        tween(durationMillis = EXPAND_ANIMATION_DURATION)
    }, label = "") {
        if (expanded == it) 24.dp else 4.dp
    }

    val arrowRotationDegree by transition.animateFloat({
        tween(durationMillis = EXPAND_ANIMATION_DURATION)
    }, label = "")
    {
        if (expanded == it) 180f else 0f
    }

    Card(
        backgroundColor = cardBgColor,
        contentColor = Color(
            ContextCompat.getColor(
                LocalContext.current,
                R.color.cardview_dark_background
            )
        ),
        elevation = cardElevation,
        shape = RoundedCornerShape(Dp(16f)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = cardPaddingHorizontal,
                vertical = 8.dp
            )
    ) {
        Column {
            Box(
               modifier = Modifier
            ) {
                OrderArrow(
                    degrees = arrowRotationDegree,
                    onClick = onCardArrowClick
                )
                CardTitle(
                    title = (order.orderLegCollection[0].instruction)
                            + " " + order.quantity + " SHARE OF " +
                            order.orderLegCollection[0].instrument.symbol + " (" + order.status + ")"
                )
            }
            ExpandableContent(visible = expanded, initialVisibility = expanded, orders = order)

        }
    }
}

@ExperimentalAnimationApi
@Composable
fun OrderBtn(
    visible: Boolean = true,
    text: String = ""
) {
    if (visible) {

        // below line is use to create a button.
        Button(
            // below line is use to add onclick
            // parameter for our button onclick
            onClick = {
                // when user is clicking the button
                // we are displaying a toast message.
                println("Welcome to Geeks for Geeks")
            },
            // in below line we are using modifier
            // which is use to add padding to our button
            modifier = Modifier
                .padding(horizontal = Dp(20f))
                .width(Dp(100f)),

            // below line is use to set or
            // button as enable or disable.
            enabled = true,


            // below line is use to add shape for our button.
            shape = MaterialTheme.shapes.medium,
        )
        // below line is use to
        // add text on our button
        {
            Text(text = text, color = Color.White)
        }
    }

}


@Composable
fun CardTitle(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        textAlign = TextAlign.Center,
    )
}


@Composable
fun OrderArrow(
    degrees: Float,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        content = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_expand_more_24),
                contentDescription = "Expandable Arrow",
                modifier = Modifier.rotate(degrees),
            )
        }
    )
}

