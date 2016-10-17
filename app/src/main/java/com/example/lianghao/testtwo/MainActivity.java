package com.example.lianghao.testtwo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lianghao.testtwo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    /**
     * DataBinding
     * 1.去掉Activity&Fragment 的ui代码
     * 2.xml 变成UI 的真实来源
     * 3.减少定义view id 的主要用途
     * 劣势
     *  1.IDE支持还不那么完善
     *  2.
     * @param savedInstanceState
     */
     Employee mEmployee = new Employee("xiaobaifsdf","xiaoheisdfsd");
    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //xml - layout  之后 databinding 初始化
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
       /* //1.。 不用findviewid
         mainBinding.textFristname.setText(mEmployee.getFirstName());
        mainBinding.textLastname.setText(mEmployee.getLastName());*/

        // 2. ui/事件绑定
        mainBinding.setEmployee(mEmployee);
        mainBinding.setPresenter(new Presenter());

    }

    public   class Presenter{
        //方法引用要求和原來的listenner(監聽器)一样
        public void onTextChanged(CharSequence s,int start,int before,int code){
            mEmployee.setFirstName(s.toString());
//            mainBinding.setEmployee(mEmployee);
        }

       public void  onClick(View view){
           Toast.makeText(MainActivity.this,"你好啊",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this,TwoActivity.class));
       }
        //监听器绑定
        public void onClickListennerBinding(Employee employee){
            Toast.makeText(MainActivity.this,employee.getLastName(),Toast.LENGTH_SHORT).show();
        }
        //表达式要不断实践哦

        //null

        //include <include layout ="@layout/name" bind:user = "@{user}"

        //viewstub



    }

}
