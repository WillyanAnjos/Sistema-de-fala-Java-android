//Implemente código juntamente ao que é necessário
// TextView - > id - > txtresult


private void falar()
    {

	//Abre uma nova tela com o sistema captando a voz
        Intent tela = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        tela.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
           RecognizerIntent.LANGUAGE_MODEL_FREE_FORM );
		
	//Caso ocorra algum erro de abertura, ele não abre
        try{
            startActivityForResult(tela, REQUEST_CODE_SPEECH_INPUT);
        }
        catch (Exception e) {
	//Mostra uma mensagem contendo o erro
            Toast.makeText(this,"" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
	
	//Método para pegar os resultados da Activity do sistema de fala
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
		//Faz o pedido para vê se está tudo OK, se tiver, começa a captar
            case REQUEST_CODE_SPEECH_INPUT : {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			//Tudo que for captado será passado para uma textView
                    txtresult.setText(result.get(0));

                }
                break;
            }
        }
    }