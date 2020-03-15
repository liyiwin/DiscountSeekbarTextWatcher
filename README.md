# DiscountSeekbarTextWatcher
## 基本說明

### 主要練習項目：
#### SeekBar / SeekBarChangeListener
#### editText / addTextChangedListener

### 說明：
![](https://i.imgur.com/S7SI2BO.png)

#### 1.折扣TextView的部分： 折扣TextView 的 text文字 代表 SeekBar的 拖曳的進度

  
        seekBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar?) {

                   }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                   }

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            
            
                //折扣TextView
                discount.setText(progress.toString()+"%")

           }

        }

      )

#### 2.原價 edittext 輸入 Seekbar 與 結算 TextView 的關係：

 > Seekbar 拖曳時
 
 

        seekBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar?) {

                   }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                   }

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                after.setText("${editText.text.toString().toFloat()*progress/100}")
                
                 pg = progress
                //pg 為全域變數，用來儲存 progress 供其他地方使用


           }


        }

      )

 > 當Edittext 輸入 不一樣的價格
 
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

