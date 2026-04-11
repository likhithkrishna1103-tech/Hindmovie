package y1;

import android.graphics.Color;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f14571a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f14572b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f14573c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap f14574d;

    static {
        HashMap map = new HashMap();
        f14574d = map;
        l0.e.q(-984833, map, "aliceblue", -332841, "antiquewhite");
        map.put("aqua", -16711681);
        map.put("aquamarine", -8388652);
        l0.e.q(-983041, map, "azure", -657956, "beige");
        l0.e.q(-6972, map, "bisque", -16777216, "black");
        l0.e.q(-5171, map, "blanchedalmond", -16776961, "blue");
        l0.e.q(-7722014, map, "blueviolet", -5952982, "brown");
        l0.e.q(-2180985, map, "burlywood", -10510688, "cadetblue");
        l0.e.q(-8388864, map, "chartreuse", -2987746, "chocolate");
        l0.e.q(-32944, map, "coral", -10185235, "cornflowerblue");
        l0.e.q(-1828, map, "cornsilk", -2354116, "crimson");
        map.put("cyan", -16711681);
        map.put("darkblue", -16777077);
        l0.e.q(-16741493, map, "darkcyan", -4684277, "darkgoldenrod");
        map.put("darkgray", -5658199);
        map.put("darkgreen", -16751616);
        map.put("darkgrey", -5658199);
        map.put("darkkhaki", -4343957);
        l0.e.q(-7667573, map, "darkmagenta", -11179217, "darkolivegreen");
        l0.e.q(-29696, map, "darkorange", -6737204, "darkorchid");
        l0.e.q(-7667712, map, "darkred", -1468806, "darksalmon");
        l0.e.q(-7357297, map, "darkseagreen", -12042869, "darkslateblue");
        map.put("darkslategray", -13676721);
        map.put("darkslategrey", -13676721);
        map.put("darkturquoise", -16724271);
        map.put("darkviolet", -7077677);
        l0.e.q(-60269, map, "deeppink", -16728065, "deepskyblue");
        map.put("dimgray", -9868951);
        map.put("dimgrey", -9868951);
        map.put("dodgerblue", -14774017);
        map.put("firebrick", -5103070);
        l0.e.q(-1296, map, "floralwhite", -14513374, "forestgreen");
        map.put("fuchsia", -65281);
        map.put("gainsboro", -2302756);
        l0.e.q(-460545, map, "ghostwhite", -10496, "gold");
        map.put("goldenrod", -2448096);
        map.put("gray", -8355712);
        l0.e.q(-16744448, map, "green", -5374161, "greenyellow");
        map.put("grey", -8355712);
        map.put("honeydew", -983056);
        l0.e.q(-38476, map, "hotpink", -3318692, "indianred");
        l0.e.q(-11861886, map, "indigo", -16, "ivory");
        l0.e.q(-989556, map, "khaki", -1644806, "lavender");
        l0.e.q(-3851, map, "lavenderblush", -8586240, "lawngreen");
        l0.e.q(-1331, map, "lemonchiffon", -5383962, "lightblue");
        l0.e.q(-1015680, map, "lightcoral", -2031617, "lightcyan");
        map.put("lightgoldenrodyellow", -329006);
        map.put("lightgray", -2894893);
        map.put("lightgreen", -7278960);
        map.put("lightgrey", -2894893);
        l0.e.q(-18751, map, "lightpink", -24454, "lightsalmon");
        l0.e.q(-14634326, map, "lightseagreen", -7876870, "lightskyblue");
        map.put("lightslategray", -8943463);
        map.put("lightslategrey", -8943463);
        map.put("lightsteelblue", -5192482);
        map.put("lightyellow", -32);
        l0.e.q(-16711936, map, "lime", -13447886, "limegreen");
        map.put("linen", -331546);
        map.put("magenta", -65281);
        l0.e.q(-8388608, map, "maroon", -10039894, "mediumaquamarine");
        l0.e.q(-16777011, map, "mediumblue", -4565549, "mediumorchid");
        l0.e.q(-7114533, map, "mediumpurple", -12799119, "mediumseagreen");
        l0.e.q(-8689426, map, "mediumslateblue", -16713062, "mediumspringgreen");
        l0.e.q(-12004916, map, "mediumturquoise", -3730043, "mediumvioletred");
        l0.e.q(-15132304, map, "midnightblue", -655366, "mintcream");
        l0.e.q(-6943, map, "mistyrose", -6987, "moccasin");
        l0.e.q(-8531, map, "navajowhite", -16777088, "navy");
        l0.e.q(-133658, map, "oldlace", -8355840, "olive");
        l0.e.q(-9728477, map, "olivedrab", -23296, "orange");
        l0.e.q(-47872, map, "orangered", -2461482, "orchid");
        l0.e.q(-1120086, map, "palegoldenrod", -6751336, "palegreen");
        l0.e.q(-5247250, map, "paleturquoise", -2396013, "palevioletred");
        l0.e.q(-4139, map, "papayawhip", -9543, "peachpuff");
        l0.e.q(-3308225, map, "peru", -16181, "pink");
        l0.e.q(-2252579, map, "plum", -5185306, "powderblue");
        l0.e.q(-8388480, map, "purple", -10079335, "rebeccapurple");
        l0.e.q(-65536, map, "red", -4419697, "rosybrown");
        l0.e.q(-12490271, map, "royalblue", -7650029, "saddlebrown");
        l0.e.q(-360334, map, "salmon", -744352, "sandybrown");
        l0.e.q(-13726889, map, "seagreen", -2578, "seashell");
        l0.e.q(-6270419, map, "sienna", -4144960, "silver");
        l0.e.q(-7876885, map, "skyblue", -9807155, "slateblue");
        map.put("slategray", -9404272);
        map.put("slategrey", -9404272);
        map.put("snow", -1286);
        map.put("springgreen", -16711809);
        l0.e.q(-12156236, map, "steelblue", -2968436, "tan");
        l0.e.q(-16744320, map, "teal", -2572328, "thistle");
        l0.e.q(-40121, map, "tomato", 0, "transparent");
        l0.e.q(-12525360, map, "turquoise", -1146130, "violet");
        l0.e.q(-663885, map, "wheat", -1, "white");
        l0.e.q(-657931, map, "whitesmoke", -256, "yellow");
        map.put("yellowgreen", -6632142);
    }

    public static int a(String str, boolean z10) {
        int i;
        d.b(!TextUtils.isEmpty(str));
        String strReplace = str.replace(" ", "");
        if (strReplace.charAt(0) == '#') {
            int i10 = (int) Long.parseLong(strReplace.substring(1), 16);
            if (strReplace.length() == 7) {
                return (-16777216) | i10;
            }
            if (strReplace.length() == 9) {
                return ((i10 & 255) << 24) | (i10 >>> 8);
            }
            throw new IllegalArgumentException();
        }
        if (strReplace.startsWith("rgba")) {
            Matcher matcher = (z10 ? f14573c : f14572b).matcher(strReplace);
            if (matcher.matches()) {
                if (z10) {
                    String strGroup = matcher.group(4);
                    strGroup.getClass();
                    i = (int) (Float.parseFloat(strGroup) * 255.0f);
                } else {
                    String strGroup2 = matcher.group(4);
                    strGroup2.getClass();
                    i = Integer.parseInt(strGroup2, 10);
                }
                String strGroup3 = matcher.group(1);
                strGroup3.getClass();
                int i11 = Integer.parseInt(strGroup3, 10);
                String strGroup4 = matcher.group(2);
                strGroup4.getClass();
                int i12 = Integer.parseInt(strGroup4, 10);
                String strGroup5 = matcher.group(3);
                strGroup5.getClass();
                return Color.argb(i, i11, i12, Integer.parseInt(strGroup5, 10));
            }
        } else if (strReplace.startsWith("rgb")) {
            Matcher matcher2 = f14571a.matcher(strReplace);
            if (matcher2.matches()) {
                String strGroup6 = matcher2.group(1);
                strGroup6.getClass();
                int i13 = Integer.parseInt(strGroup6, 10);
                String strGroup7 = matcher2.group(2);
                strGroup7.getClass();
                int i14 = Integer.parseInt(strGroup7, 10);
                String strGroup8 = matcher2.group(3);
                strGroup8.getClass();
                return Color.rgb(i13, i14, Integer.parseInt(strGroup8, 10));
            }
        } else {
            Integer num = (Integer) f14574d.get(android.support.v4.media.session.b.O(strReplace));
            if (num != null) {
                return num.intValue();
            }
        }
        throw new IllegalArgumentException();
    }
}
