package com.example.composetdaapp.ui.compose.login
/*TODO Will reference once compose matures a little more
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@ExperimentalAnimationApi
@Composable
fun LoginScreen(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    navController: NavController
) {


    var visible by remember { mutableStateOf(true) }
    val color by animateColorAsState(if (visible) MaterialTheme.colors.primary else Color.Gray)
    val text = ("Log in")


    //Surface is like layout in xml
    Surface(modifier = Modifier.fillMaxSize()) {
        //Call URL ahead of time
        WebView(
            urlToRender = "https://auth.tdameritrade.com/auth?response_type=code&redirect_uri=http%3A%2F%2Flocalhost&client_id=LZBWODC3GHH1XMA5IMHFOFU2DNA81W6N%40AMER.OAUTHAP",
            navigateTo = { navController.navigate("home") })
        //Our "Curtain"
        AnimatedVisibility(visible = visible) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
            ) {
            }
            shrinkOut() + fadeOut()
        }
    }
    //Align button
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AnimatedVisibility(visible = visible) {
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = color),
                onClick = {
                    onClick.invoke()
                    visible = !visible
                },
                modifier = modifier,
                shape = RoundedCornerShape(20.dp),
            ) {
                Text(text = text)
            }
            shrinkHorizontally() + fadeOut()
        }
    }

}



*/