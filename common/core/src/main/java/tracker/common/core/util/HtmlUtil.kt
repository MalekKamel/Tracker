package tracker.common.core.util

import android.text.Html
import android.widget.TextView

object HtmlUtil {

    fun show(html: String, textView: TextView) {
        textView.text = textFromHtml(html)
    }

    fun textFromHtml(text: String): CharSequence {
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N)
            Html.fromHtml(text, Html.FROM_HTML_SEPARATOR_LINE_BREAK_DIV)
        else
            Html.fromHtml(text)

    }
}
