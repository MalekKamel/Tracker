package tracker.common.core.util

import tracker.common.core.CoreApp

/**
 * Created by Sha on 11/14/17.
 */

class StringBuilderUtil {
    private val sb = StringBuilder()

    fun append(any: Any): StringBuilderUtil {
        sb.append(any)
        return this
    }

    fun appendRes(res: Int): StringBuilderUtil {
        sb.append(CoreApp.string(res))
        return this
    }

    fun ln(): StringBuilderUtil {
        sb.append("\n")
        return this
    }

    fun comma(): StringBuilderUtil {
        sb.append(",")
        return this
    }

    fun space(): StringBuilderUtil {
        sb.append(" ")
        return this
    }

    fun colon(): StringBuilderUtil {
        sb.append(": ")
        return this
    }

    fun dashSpaced(): StringBuilderUtil {
        sb.append(" - ")
        return this
    }

    fun dash(): StringBuilderUtil {
        sb.append("-")
        return this
    }

    fun openBracket(): StringBuilderUtil {
        sb.append("(")
        return this
    }

    fun closeBracket(): StringBuilderUtil {
        sb.append(")")
        return this
    }

    fun underbar(): StringBuilderUtil {
        sb.append("_")
        return this
    }

    override fun toString(): String {
        return sb.toString()
    }

    fun frontSlash(): StringBuilderUtil {
        sb.append("/")
        return this
    }

    companion object {

        fun withTitle(titleRes: Int, value: Any): String {
            return withTitle(CoreApp.string(titleRes), value)
        }

        fun withTitle(title: String, value: Any): String {
            return StringBuilderUtil()
                    .append(HtmlUtil.textFromHtml("<b>$title</b>"))
                    .colon()
                    .append(value.toString())
                    .toString()
        }

        fun withTitleLn(titleRes: Int, value: Any): String {
            return withTitleLn(CoreApp.string(titleRes), value)
        }

        fun withTitleLn(title: String, value: Any): String {
            return StringBuilderUtil()
                    .append(HtmlUtil.textFromHtml("<b>$title</b>"))
                    .colon()
                    .ln()
                    .append(value.toString())
                    .toString()
        }

        fun withTitleAndUnit(title: String, value: String): String {
            return StringBuilderUtil()
                    .append(HtmlUtil.textFromHtml("<b>$title</b>"))
                    .colon()
                    .append(value)
                    .toString()
        }

        fun withDash(vararg values: String): String {
            val util = StringBuilderUtil()
            for (i in values.indices) {
                util.append(values[i])
                if (i != values.size - 1)
                    util.dashSpaced()
            }
            return util.toString()
        }

        fun joinWithSpace(o1: Any, o2: Any): String {
            return StringBuilder()
                    .append(o1)
                    .append(" ")
                    .append(o2)
                    .toString()
        }
    }

}
