package br.edu.puc.experimentofirebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.edu.puc.experimentofirebase.ui.theme.ExperimentoFirebaseTheme
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.initialize
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize

class WelcomeActivity : ComponentActivity() {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this) //Inicializando o Firebase
        enableEdgeToEdge()
        setContent {
            ExperimentoFirebaseTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    ExperimentoApp(db)
                }
            }
        }
    }
}

@Composable
fun ExperimentoApp(db: FirebaseFirestore){
    WelcomePage(
        db = db,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )


}

@Composable
fun WelcomePage(db: FirebaseFirestore, modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =   Alignment.CenterHorizontally
    ){
        Text("Bem-vindo ao programa experimental Firebase")

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {

            },
            modifier = Modifier.fillMaxWidth()


        ) {
            Text("Faça seu cadastro")
        }


        Button(
            onClick = {

            },
            modifier = Modifier.fillMaxWidth()
        ){
            Text("Entrar")
        }
    }
}