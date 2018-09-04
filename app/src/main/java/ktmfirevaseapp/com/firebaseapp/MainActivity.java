package ktmfirevaseapp.com.firebaseapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    //            getInstance recupera a instancia do firebasedatabase(acesso ao banco de dados)
    private DatabaseReference firebasebaseRefrencia = FirebaseDatabase.getInstance().getReference(); //getReference volta pra o nó raiz do projeto
    //Esse objeto faz referencia a raiz do projeto ou o primeiro nó, e possibilita criar nós apartir dela

    //referencia ao nó filho que esta dentro do nó rais
    private DatabaseReference usuarioReferencia = firebasebaseRefrencia.child("usuarios");
    //Referencia o nó de produtos
    private DatabaseReference produtoReferencia = firebasebaseRefrencia.child("produtos");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //define um novo nó, cria um nó dentro do nó raiz e seta o valor
        //firebasebaseRefrencia.child("usuarios");
        //Cria um outro usuario dentro do nó pai usuarios
        //usuarioReferencia.child("002").child("nome").setValue("Fla");

                /*
        Salvando Produto

        Produto produto = new Produto();
        produto.setCor("branco");
        produto.setFabricante("Apple");
        produto.setNome("Iphone corói");
        */
        //id inc
        /*
        produtoReferencia.child("002").setValue(produto);

        Salvando objeto usuario
        Usuario usuario = new Usuario();
        usuario.setIdade(22);
        usuario.setNome("Ivo");
        usuario.setSexo("F");
        usuario.setSobrenome("Holanda");
        salva o usuário e cria novos campos caso n exista
        usuarioReferencia.child("003").setValue(usuario);
        */


        /*
        RECUPERANDO DADOS para todos do child especificado
             */
        produtoReferencia.addValueEventListener(new ValueEventListener() {
            //Método chamado sempre que os dados do firebase forem modificados
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    //recupera value
                Log.i("firebaseLog",dataSnapshot.getValue().toString());
            }
            //Metodo casa haja algum erro ao recuperar os dados
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

}
