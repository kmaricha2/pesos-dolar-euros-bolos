package com.devmasterteam.conversaodemoeda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Contém os elementos da tela em questão. Faz o carregamento uma única vez e pode ser usado a qualquer momento dentro da classe.
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Insere o layout na activity
        setContentView(R.layout.activity_main);

        // Busca os elementos da interface
        this.mViewHolder.editReal = (EditText) this.findViewById(R.id.edit_real);
        this.mViewHolder.textDollar = (TextView) this.findViewById(R.id.text_dollar);
        this.mViewHolder.textEuro = (TextView) this.findViewById(R.id.text_euro);
        this.mViewHolder.textBolibar=(TextView) this.findViewById(R.id.text_bolivar);
        this.mViewHolder.buttonCalculate = (Button) this.findViewById(R.id.button_calculate);

        // Limpa os valores iniciais
        this.clearValues();

        // Adiciona evento de click no elemento
        this.mViewHolder.buttonCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        // Verifica se o elemento clicado é o que nos interessa
        if (view.getId() == R.id.button_calculate) {

            // Obtém o valor do EditText
            Double mReal = Double.valueOf(this.mViewHolder.editReal.getText().toString());

            // Converte valores
            this.mViewHolder.textDollar.setText(String.format("%.2f", mReal * 0.00033613445));
            this.mViewHolder.textEuro.setText(String.format("%.2f", mReal * 0.00029052876));
            this.mViewHolder.textBolibar.setText(String.format("%.2f", mReal * 83242.36));
        }
    }

    /**
     * Limpa os valores iniciais
     */
    private void clearValues() {
        this.mViewHolder.textDollar.setText("");
        this.mViewHolder.textEuro.setText("");
        this.mViewHolder.textBolibar.setText("");
    }

    /**
     * Padrão ViewHolder
     */
    private static class ViewHolder {
        private EditText editReal;
        private TextView textDollar;
        private TextView textEuro;
        private TextView textBolibar;
        private Button buttonCalculate;
    }
}