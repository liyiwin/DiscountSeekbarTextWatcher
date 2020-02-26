package com.example.discountseekbartextwatcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var pg =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText.setText("0")

        seekBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar?) {

                   }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                   }

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                discount.setText(progress.toString()+"%")
                after.setText("${editText.text.toString().toFloat()*progress/100}")

                pg = progress


                //pg 為外部自定義變數，用來儲存 progress 供其他地方使用

           }


        }

      )

      editText.addTextChangedListener(object:TextWatcher{
          override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
              }

          override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
             }

          override fun afterTextChanged(s: Editable?) {

              if (editText.text.toString()!= "" )
                  after.setText("${editText.text.toString().toFloat()*pg/100}")

                  else

                  after.setText("0")

         }

       }

      )

    }
  }
