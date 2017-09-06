package com.reemii.com.testformiximgtxt;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private EditText editText;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    private TextView textView11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = (TextView) findViewById(R.id.tv_text1);
        textView2 = (TextView) findViewById(R.id.tv_text2);
        textView3 = (TextView) findViewById(R.id.tv_text3);
        textView4 = (TextView) findViewById(R.id.tv_text4);
        textView5 = (TextView) findViewById(R.id.tv_text5);
        textView6 = (TextView) findViewById(R.id.tv_text6);
        textView7 = (TextView) findViewById(R.id.tv_text7);
        textView8 = (TextView) findViewById(R.id.tv_text8);
        textView9 = (TextView) findViewById(R.id.tv_text9);
        textView10 = (TextView) findViewById(R.id.tv_text10);
        textView11 = (TextView) findViewById(R.id.tv_text11);
        editText = (EditText) findViewById(R.id.et_text1);


        setSpan();
        setSpan2();
        setMoreLikers();
        setUrlSpan();
        setUrlSpan2();
        setHtmlSpan();
    }

    private void setSpan() {
        SpannableString spannableString = new SpannableString("君不见黄河之水天上来，");
        SpannableString spannableString2 = new SpannableString("奔流到海不复回。");
        SpannableString spannableString3 = new SpannableString("君不见高堂明镜悲白发，");
        SpannableString spannableString4 = new SpannableString("朝如青丝暮成雪。");
        SpannableString spannableString5 = new SpannableString("人生得意须尽欢。");
        SpannableString spannableString6 = new SpannableString("莫使金樽空对月。");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.GREEN);
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.CYAN);// 同ForegroundColorSpan应用一样
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(32, true);// 32dp
        UnderlineSpan underlineSpan = new UnderlineSpan();
        // 文本字体格式，加粗，倾斜
        StyleSpan styleSpan = new StyleSpan(Typeface.BOLD_ITALIC);
        // 这四种flags的显示效果是一样的，包前不包后
        spannableString.setSpan(foregroundColorSpan, 1, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(styleSpan, 1, 5, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        spannableString2.setSpan(underlineSpan, 1, 5, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        spannableString3.setSpan(absoluteSizeSpan, 1, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString4.setSpan(backgroundColorSpan, 1, 5, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        ImageSpan imageSpan = new ImageSpan(this, R.mipmap.ic_launcher);
        spannableString5.setSpan(imageSpan, 1, 4, Spanned.SPAN_COMPOSING);
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth() / 3, drawable.getIntrinsicHeight() / 3);//缩小为1/3
        ImageSpan imageSpan1 = new ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM);
        spannableString6.setSpan(imageSpan1, 1, 5, Spanned.SPAN_COMPOSING);
        textView1.setText(spannableString);
        textView2.setText(spannableString2);
        textView3.setText(spannableString3);
        textView4.setText(spannableString4);
        textView5.setText(spannableString5);
        textView6.setText(spannableString6);
        // 以上四种span对于新增加的文字有效果
//        editText.setText(spannableString);// Spanned.SPAN_EXCLUSIVE_EXCLUSIVE 在span的文字前后新加文字都不会有span设置的效果
//        editText.setText(spannableString2);// Spanned.SPAN_EXCLUSIVE_INCLUSIVE 在span的文字前后新加文字，前边无效果，后边会复用效果
//        editText.setText(spannableString3);// Spanned.SPAN_INCLUSIVE_EXCLUSIVE 在span的文字前后新加文字，前边会复用效果，后边无效果
        editText.setText(spannableString4);// Spanned.SPAN_INCLUSIVE_INCLUSIVE 在span的文字前后新加文字，前边和后边都会复用效果
    }

    private void setSpan2() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("天生我材必有用，");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.RED);
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        spannableStringBuilder.setSpan(foregroundColorSpan, 0, 3, Spanned.SPAN_COMPOSING);
        spannableStringBuilder.append("千金散尽还复来。");
        spannableStringBuilder.setSpan(strikethroughSpan, 3, 12, Spanned.SPAN_COMPOSING);
        textView7.setText(spannableStringBuilder);
    }

    private void setMoreLikers() {
        // 构造多个超链接的html, 通过选中的位置来获取用户名
        StringBuilder sbBuilder = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            sbBuilder.append("liker" + i + "、");
        }
        String likers = sbBuilder.substring(0, sbBuilder.lastIndexOf("、")).toString();
        textView8.setMovementMethod(LinkMovementMethod.getInstance());//
        textView8.setText(addClickablePart(likers), TextView.BufferType.SPANNABLE);
    }

    /**
     * ClickableSpan 可点击的文本
     *
     * @param str
     * @return
     */
    private SpannableStringBuilder addClickablePart(String str) {
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        drawable.setBounds(0, 0, 30, 30);// 设置大小
        // 赞的图标
        ImageSpan span = new ImageSpan(drawable, DynamicDrawableSpan.ALIGN_BASELINE);
        SpannableString spanStr = new SpannableString("l");// 被替换的
        spanStr.setSpan(span, 0, 1, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        // 将赞的图标和赞的人名拼接
        SpannableStringBuilder ssb = new SpannableStringBuilder(spanStr);
        ssb.append(str);
        String[] likers = str.split("、");
        if (likers.length > 0) {
            for (int i = 0; i < likers.length; i++) {
                final String name = likers[i];
                final int start = str.indexOf(name) + spanStr.length();
                ssb.setSpan(new ClickableSpan() {
                    @Override
                    public void onClick(View widget) {
                        Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void updateDrawState(TextPaint ds) {
                        super.updateDrawState(ds);
                        // 设置文本颜色
                        ds.setColor(Color.RED);
                        // 去掉下划线
                        ds.setUnderlineText(false);
                        ds.setTextSize(30.0f);
                    }
                }, start, start + name.length(), Spanned.SPAN_COMPOSING);
            }
        }
        return ssb.append("赞了您.");
    }

    /**
     * 点击电话超链接，拨打电话
     */
    private void setUrlSpan() {
        SpannableString spannableString = new SpannableString("电话");
        final URLSpan urlSpan = new URLSpan("tel:10086");
        spannableString.setSpan(urlSpan, 0, 2, Spanned.SPAN_COMPOSING);
        textView9.setMovementMethod(LinkMovementMethod.getInstance());
        textView9.setText(spannableString);
    }

    /**
     * 网址超链接 默认是可点击跳转的
     */
    private void setUrlSpan2() {
        SpannableString spannableString = new SpannableString("网址");
        final URLSpan urlSpan2 = new URLSpan("http://www.csdn.net");
        spannableString.setSpan(urlSpan2, 0, 2, Spanned.SPAN_COMPOSING);
        textView10.setMovementMethod(LinkMovementMethod.getInstance());
        textView10.setText(spannableString);
    }


    /**
     * 加载html格式数据
     */
    private void setHtmlSpan() {
        URLImageParser urlImageParser = new URLImageParser(MainActivity.this, textView11);

        String str = "<strong>强调</strong><br>";
        str += "<em>斜体</em><br>";
        str += "<b>加粗</b><br>";
        str += "<h1>标题1</h1><br>";
        str += "<h2>标题2</h2><br>";
        str += "<h3>标题3</h3><br>";
        str += "<h4>标题4</h4><br>";
        str += "<h5>标题5</h5><br>";
        str += "<font color='#FF6A6A'>设置红色</font><br>";
        str += "<a href=\"https://www.baidu.com\">百度链接</a><br>";
        str += "<img src='https://img.alicdn.com/imgextra/i3/2454452051/TB2DH1acYFkpuFjy1XcXXclapXa_!!2454452051.jpg'/>";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            // flags
            // FROM_HTML_MODE_COMPACT：html块元素之间使用一个换行符分隔
            // FROM_HTML_MODE_LEGACY：html块元素之间使用两个换行符分隔
            textView11.setText(
                    Html.fromHtml(str, Html.FROM_HTML_MODE_COMPACT, urlImageParser, null));
        } else {
            textView11.setText(Html.fromHtml(str, urlImageParser, null));
        }
        textView11.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
