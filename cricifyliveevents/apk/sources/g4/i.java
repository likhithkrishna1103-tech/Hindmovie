package g4;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import y1.a0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f5020a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)((?:.|\\f)*)?$");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f5021b = Pattern.compile("(\\S+?):(\\S+)");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f5022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f5023d;

    static {
        HashMap map = new HashMap();
        map.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f5022c = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        f5023d = Collections.unmodifiableMap(map2);
    }

    public static void a(String str, f fVar, List list, SpannableStringBuilder spannableStringBuilder, List list2) {
        int i;
        int length;
        int i10;
        int i11;
        int i12;
        int i13;
        i = fVar.f5006b;
        length = spannableStringBuilder.length();
        String str2 = fVar.f5005a;
        str2.getClass();
        i10 = -1;
        switch (str2) {
            case "":
            case "lang":
                break;
            case "b":
                spannableStringBuilder.setSpan(new StyleSpan(1), i, length, 33);
                break;
            case "c":
                for (String str3 : fVar.f5008d) {
                    Map map = f5022c;
                    if (map.containsKey(str3)) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(((Integer) map.get(str3)).intValue()), i, length, 33);
                    } else {
                        Map map2 = f5023d;
                        if (map2.containsKey(str3)) {
                            spannableStringBuilder.setSpan(new BackgroundColorSpan(((Integer) map2.get(str3)).intValue()), i, length, 33);
                        }
                    }
                }
                break;
            case "i":
                spannableStringBuilder.setSpan(new StyleSpan(2), i, length, 33);
                break;
            case "u":
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                break;
            case "v":
                spannableStringBuilder.setSpan(new x1.i(fVar.f5007c), i, length, 33);
                break;
            case "ruby":
                int iC = c(list2, str, fVar);
                ArrayList arrayList = new ArrayList(list.size());
                arrayList.addAll(list);
                Collections.sort(arrayList, e.f5002c);
                int i14 = fVar.f5006b;
                int i15 = 0;
                int length2 = 0;
                while (i15 < arrayList.size()) {
                    if ("rt".equals(((e) arrayList.get(i15)).f5003a.f5005a)) {
                        e eVar = (e) arrayList.get(i15);
                        int iC2 = c(list2, str, eVar.f5003a);
                        if (iC2 == i10) {
                            iC2 = iC != i10 ? iC : 1;
                        }
                        int i16 = eVar.f5003a.f5006b - length2;
                        int i17 = eVar.f5004b - length2;
                        CharSequence charSequenceSubSequence = spannableStringBuilder.subSequence(i16, i17);
                        spannableStringBuilder.delete(i16, i17);
                        spannableStringBuilder.setSpan(new x1.g(iC2, charSequenceSubSequence.toString()), i14, i16, 33);
                        length2 = charSequenceSubSequence.length() + length2;
                        i14 = i16;
                    }
                    i15++;
                    i10 = -1;
                }
                break;
            default:
                return;
        }
        ArrayList arrayListB = b(list2, str, fVar);
        for (int i18 = 0; i18 < arrayListB.size(); i18++) {
            b bVar = ((g) arrayListB.get(i18)).f5010w;
            int i19 = bVar.f4992l;
            if (i19 == -1 && bVar.f4993m == -1) {
                i11 = -1;
            } else {
                i11 = (bVar.f4993m == 1 ? (char) 2 : (char) 0) | (i19 == 1 ? (char) 1 : (char) 0);
            }
            if (i11 != -1) {
                int i20 = bVar.f4992l;
                if (i20 == -1 && bVar.f4993m == -1) {
                    i13 = -1;
                    i12 = 1;
                } else {
                    i12 = 1;
                    i13 = (i20 == 1 ? 1 : 0) | (bVar.f4993m == 1 ? 2 : 0);
                }
                w8.e.b(spannableStringBuilder, new StyleSpan(i13), i, length);
            } else {
                i12 = 1;
            }
            if (bVar.f4990j == i12) {
                spannableStringBuilder.setSpan(new StrikethroughSpan(), i, length, 33);
            }
            if (bVar.f4991k == i12) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
            }
            if (bVar.f4988g) {
                if (!bVar.f4988g) {
                    throw new IllegalStateException("Font color not defined");
                }
                w8.e.b(spannableStringBuilder, new ForegroundColorSpan(bVar.f), i, length);
            }
            if (bVar.i) {
                if (!bVar.i) {
                    throw new IllegalStateException("Background color not defined.");
                }
                w8.e.b(spannableStringBuilder, new BackgroundColorSpan(bVar.f4989h), i, length);
            }
            if (bVar.f4987e != null) {
                w8.e.b(spannableStringBuilder, new TypefaceSpan(bVar.f4987e), i, length);
            }
            int i21 = bVar.f4994n;
            if (i21 == 1) {
                w8.e.b(spannableStringBuilder, new AbsoluteSizeSpan((int) bVar.f4995o, true), i, length);
            } else if (i21 == 2) {
                w8.e.b(spannableStringBuilder, new RelativeSizeSpan(bVar.f4995o), i, length);
            } else if (i21 == 3) {
                w8.e.b(spannableStringBuilder, new RelativeSizeSpan(bVar.f4995o / 100.0f), i, length);
            }
            if (bVar.f4997q) {
                spannableStringBuilder.setSpan(new x1.e(), i, length, 33);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5, types: [int] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public static ArrayList b(List list, String str, f fVar) {
        ?? size;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            b bVar = (b) list.get(i);
            String str2 = fVar.f5005a;
            Set set = fVar.f5008d;
            String str3 = fVar.f5007c;
            if (bVar.f4983a.isEmpty() && bVar.f4984b.isEmpty() && bVar.f4985c.isEmpty() && bVar.f4986d.isEmpty()) {
                size = TextUtils.isEmpty(str2);
            } else {
                int iA = b.a(b.a(b.a(0, 1073741824, bVar.f4983a, str), 2, bVar.f4984b, str2), 4, bVar.f4986d, str3);
                size = (iA == -1 || !set.containsAll(bVar.f4985c)) ? 0 : iA + (bVar.f4985c.size() * 4);
            }
            if (size > 0) {
                arrayList.add(new g(size, bVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static int c(List list, String str, f fVar) {
        ArrayList arrayListB = b(list, str, fVar);
        for (int i = 0; i < arrayListB.size(); i++) {
            int i10 = ((g) arrayListB.get(i)).f5010w.f4996p;
            if (i10 != -1) {
                return i10;
            }
        }
        return -1;
    }

    public static c d(String str, Matcher matcher, t tVar, ArrayList arrayList) {
        h hVar = new h();
        try {
            String strGroup = matcher.group(1);
            strGroup.getClass();
            hVar.f5011a = j.c(strGroup);
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            hVar.f5012b = j.c(strGroup2);
            String strGroup3 = matcher.group(3);
            strGroup3.getClass();
            e(strGroup3, hVar);
            StringBuilder sb = new StringBuilder();
            tVar.getClass();
            String strK = tVar.k(StandardCharsets.UTF_8);
            while (!TextUtils.isEmpty(strK)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(strK.trim());
                strK = tVar.k(StandardCharsets.UTF_8);
            }
            hVar.f5013c = f(str, sb.toString(), arrayList);
            return new c(hVar.a().a(), hVar.f5011a, hVar.f5012b);
        } catch (IllegalArgumentException unused) {
            y1.b.p("WebvttCueParser", "Skipping cue with bad header: " + matcher.group());
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void e(String str, h hVar) {
        int i;
        String strSubstring;
        int i10;
        int i11;
        Matcher matcher = f5021b.matcher(str);
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            strGroup.getClass();
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            try {
                if ("line".equals(strGroup)) {
                    g(strGroup2, hVar);
                } else {
                    if ("align".equals(strGroup)) {
                        switch (strGroup2) {
                            case "center":
                            case "middle":
                                i = 2;
                                break;
                            case "end":
                                i = 3;
                                break;
                            case "left":
                                i = 4;
                                break;
                            case "right":
                                i = 5;
                                break;
                            case "start":
                                i = 1;
                                break;
                            default:
                                y1.b.p("WebvttCueParser", "Invalid alignment value: ".concat(strGroup2));
                                i = 2;
                                break;
                        }
                        hVar.f5014d = i;
                    } else if ("position".equals(strGroup)) {
                        int iIndexOf = strGroup2.indexOf(44);
                        if (iIndexOf != -1) {
                            strSubstring = strGroup2.substring(iIndexOf + 1);
                            strSubstring.getClass();
                            switch (strSubstring) {
                                case "line-left":
                                case "start":
                                    i10 = 0;
                                    break;
                                case "center":
                                case "middle":
                                    i10 = 1;
                                    break;
                                case "line-right":
                                case "end":
                                    i10 = 2;
                                    break;
                                default:
                                    y1.b.p("WebvttCueParser", "Invalid anchor value: ".concat(strSubstring));
                                    i10 = Integer.MIN_VALUE;
                                    break;
                            }
                            hVar.i = i10;
                            strGroup2 = strGroup2.substring(0, iIndexOf);
                        }
                        hVar.f5017h = j.b(strGroup2);
                    } else if ("size".equals(strGroup)) {
                        hVar.f5018j = j.b(strGroup2);
                    } else if ("vertical".equals(strGroup)) {
                        if (strGroup2.equals("lr")) {
                            i11 = 2;
                        } else if (strGroup2.equals("rl")) {
                            i11 = 1;
                        } else {
                            y1.b.p("WebvttCueParser", "Invalid 'vertical' value: ".concat(strGroup2));
                            i11 = Integer.MIN_VALUE;
                        }
                        hVar.f5019k = i11;
                    } else {
                        y1.b.p("WebvttCueParser", "Unknown cue setting " + strGroup + ":" + strGroup2);
                    }
                }
            } catch (NumberFormatException unused) {
                y1.b.p("WebvttCueParser", "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    public static SpannedString f(String str, String str2, List list) {
        String str3;
        char c9;
        String strSubstring;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            String strTrim = "";
            if (i >= str2.length()) {
                while (!arrayDeque.isEmpty()) {
                    a(str, (f) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
                }
                a(str, new f("", 0, "", Collections.EMPTY_SET), Collections.EMPTY_LIST, spannableStringBuilder, list);
                return SpannedString.valueOf(spannableStringBuilder);
            }
            char cCharAt = str2.charAt(i);
            if (cCharAt == '&') {
                i++;
                int iIndexOf = str2.indexOf(59, i);
                int iIndexOf2 = str2.indexOf(32, i);
                if (iIndexOf == -1) {
                    iIndexOf = iIndexOf2;
                } else if (iIndexOf2 != -1) {
                    iIndexOf = Math.min(iIndexOf, iIndexOf2);
                }
                if (iIndexOf != -1) {
                    strSubstring = str2.substring(i, iIndexOf);
                    strSubstring.getClass();
                    switch (strSubstring) {
                        case "gt":
                            spannableStringBuilder.append('>');
                            break;
                        case "lt":
                            spannableStringBuilder.append('<');
                            break;
                        case "amp":
                            spannableStringBuilder.append('&');
                            break;
                        case "nbsp":
                            spannableStringBuilder.append(' ');
                            break;
                        default:
                            y1.b.p("WebvttCueParser", "ignoring unsupported entity: '&" + strSubstring + ";'");
                            break;
                    }
                    if (iIndexOf == iIndexOf2) {
                        spannableStringBuilder.append((CharSequence) " ");
                    }
                    i = iIndexOf + 1;
                } else {
                    spannableStringBuilder.append(cCharAt);
                }
            } else if (cCharAt != '<') {
                spannableStringBuilder.append(cCharAt);
                i++;
            } else {
                int length = i + 1;
                if (length < str2.length()) {
                    boolean z10 = str2.charAt(length) == '/';
                    int iIndexOf3 = str2.indexOf(62, length);
                    length = iIndexOf3 == -1 ? str2.length() : iIndexOf3 + 1;
                    int i10 = length - 2;
                    boolean z11 = str2.charAt(i10) == '/';
                    int i11 = i + (z10 ? 2 : 1);
                    if (!z11) {
                        i10 = length - 1;
                    }
                    String strSubstring2 = str2.substring(i11, i10);
                    if (!strSubstring2.trim().isEmpty()) {
                        String strTrim2 = strSubstring2.trim();
                        y1.d.b(!strTrim2.isEmpty());
                        int i12 = a0.f14551a;
                        str3 = strTrim2.split("[ \\.]", 2)[0];
                        str3.getClass();
                        switch (str3) {
                            case "b":
                            case "c":
                            case "i":
                            case "u":
                            case "v":
                            case "rt":
                            case "lang":
                            case "ruby":
                                if (!z10) {
                                    if (!z11) {
                                        int length2 = spannableStringBuilder.length();
                                        String strTrim3 = strSubstring2.trim();
                                        y1.d.b(!strTrim3.isEmpty());
                                        int iIndexOf4 = strTrim3.indexOf(" ");
                                        if (iIndexOf4 == -1) {
                                            c9 = 0;
                                        } else {
                                            strTrim = strTrim3.substring(iIndexOf4).trim();
                                            c9 = 0;
                                            strTrim3 = strTrim3.substring(0, iIndexOf4);
                                        }
                                        String[] strArrSplit = strTrim3.split("\\.", -1);
                                        String str4 = strArrSplit[c9];
                                        HashSet hashSet = new HashSet();
                                        for (int i13 = 1; i13 < strArrSplit.length; i13++) {
                                            hashSet.add(strArrSplit[i13]);
                                        }
                                        arrayDeque.push(new f(str4, length2, strTrim, hashSet));
                                    }
                                    break;
                                } else {
                                    while (!arrayDeque.isEmpty()) {
                                        f fVar = (f) arrayDeque.pop();
                                        a(str, fVar, arrayList, spannableStringBuilder, list);
                                        if (arrayDeque.isEmpty()) {
                                            arrayList.clear();
                                        } else {
                                            arrayList.add(new e(fVar, spannableStringBuilder.length()));
                                        }
                                        if (fVar.f5005a.equals(str3)) {
                                            break;
                                        }
                                    }
                                    break;
                                }
                                break;
                        }
                    }
                }
                i = length;
            }
        }
    }

    public static void g(String str, h hVar) {
        String strSubstring;
        int i;
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            strSubstring = str.substring(iIndexOf + 1);
            strSubstring.getClass();
            i = 2;
            switch (strSubstring) {
                case "center":
                case "middle":
                    i = 1;
                    break;
                case "end":
                    break;
                case "start":
                    i = 0;
                    break;
                default:
                    y1.b.p("WebvttCueParser", "Invalid anchor value: ".concat(strSubstring));
                    i = Integer.MIN_VALUE;
                    break;
            }
            hVar.f5016g = i;
            str = str.substring(0, iIndexOf);
        }
        if (str.endsWith("%")) {
            hVar.f5015e = j.b(str);
            hVar.f = 0;
        } else {
            hVar.f5015e = Integer.parseInt(str);
            hVar.f = 1;
        }
    }
}
