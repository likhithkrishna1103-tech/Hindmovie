package e2;

import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import p1.n0;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class e extends DefaultHandler implements s2.o {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Pattern f4315v = Pattern.compile("(\\d+)(?:/(\\d+))?");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Pattern f4316w = Pattern.compile("CC([1-4])=.*");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Pattern f4317x = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int[] f4318y = {2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 1, 1, 1, 2, 1, 1, 2, 2, 2};

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int[] f4319z = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final XmlPullParserFactory f4320u;

    public e() {
        try {
            this.f4320u = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e10) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e10);
        }
    }

    public static long a(ArrayList arrayList, long j5, long j8, int i, long j10) {
        int i10;
        if (i >= 0) {
            i10 = i + 1;
        } else {
            int i11 = b0.f11647a;
            i10 = (int) ((((j10 - j5) + j8) - 1) / j8);
        }
        for (int i12 = 0; i12 < i10; i12++) {
            arrayList.add(new q(j5, j8));
            j5 += j8;
        }
        return j5;
    }

    public static void b(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() == 2) {
            int i = 1;
            while (i != 0) {
                xmlPullParser.next();
                if (xmlPullParser.getEventType() == 2) {
                    i++;
                } else if (xmlPullParser.getEventType() == 3) {
                    i--;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0093 A[PHI: r13
      0x0093: PHI (r13v30 int) = (r13v5 int), (r13v8 int), (r13v33 int) binds: [B:128:0x01ae, B:120:0x019b, B:47:0x008f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(org.xmlpull.v1.XmlPullParser r12, java.lang.String r13) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 536
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.e.c(org.xmlpull.v1.XmlPullParser, java.lang.String):int");
    }

    public static long d(XmlPullParser xmlPullParser, long j5) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return j5;
        }
        if ("INF".equals(attributeValue)) {
            return Long.MAX_VALUE;
        }
        return (long) (Float.parseFloat(attributeValue) * 1000000.0f);
    }

    public static ArrayList f(XmlPullParser xmlPullParser, ArrayList arrayList, boolean z2) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "dvb:priority");
        int i = attributeValue != null ? Integer.parseInt(attributeValue) : z2 ? 1 : Integer.MIN_VALUE;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "dvb:weight");
        int i10 = attributeValue2 != null ? Integer.parseInt(attributeValue2) : 1;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "serviceLocation");
        String text = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                text = xmlPullParser.getText();
            } else {
                b(xmlPullParser);
            }
        } while (!s1.d.l(xmlPullParser, "BaseURL"));
        if (text != null && s1.b.j(text)[0] != -1) {
            if (attributeValue3 == null) {
                attributeValue3 = text;
            }
            return aa.q.o(new b(i, i10, text, attributeValue3));
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            b bVar = (b) arrayList.get(i11);
            String strN = s1.b.n(bVar.f4295a, text);
            String str = attributeValue3 == null ? strN : attributeValue3;
            if (z2) {
                i = bVar.f4297c;
                i10 = bVar.f4298d;
                str = bVar.f4296b;
            }
            arrayList2.add(new b(i, i10, strN, str));
        }
        return arrayList2;
    }

    public static int h(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        if ("text".equals(attributeValue)) {
            return 3;
        }
        return "image".equals(attributeValue) ? 4 : -1;
    }

    public static f i(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "schemeIdUri");
        if (attributeValue == null) {
            attributeValue = "";
        }
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "value");
        if (attributeValue2 == null) {
            attributeValue2 = null;
        }
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "id");
        String str2 = attributeValue3 != null ? attributeValue3 : null;
        do {
            xmlPullParser.next();
        } while (!s1.d.l(xmlPullParser, str));
        return new f(attributeValue, attributeValue2, str2);
    }

    public static long j(XmlPullParser xmlPullParser, String str, long j5) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return j5;
        }
        Matcher matcher = b0.f.matcher(attributeValue);
        if (!matcher.matches()) {
            return (long) (Double.parseDouble(attributeValue) * 3600.0d * 1000.0d);
        }
        boolean zIsEmpty = TextUtils.isEmpty(matcher.group(1));
        String strGroup = matcher.group(3);
        double d10 = strGroup != null ? Double.parseDouble(strGroup) * 3.1556908E7d : 0.0d;
        String strGroup2 = matcher.group(5);
        double d11 = d10 + (strGroup2 != null ? Double.parseDouble(strGroup2) * 2629739.0d : 0.0d);
        String strGroup3 = matcher.group(7);
        double d12 = d11 + (strGroup3 != null ? Double.parseDouble(strGroup3) * 86400.0d : 0.0d);
        String strGroup4 = matcher.group(10);
        double d13 = d12 + (strGroup4 != null ? Double.parseDouble(strGroup4) * 3600.0d : 0.0d);
        String strGroup5 = matcher.group(12);
        double d14 = d13 + (strGroup5 != null ? Double.parseDouble(strGroup5) * 60.0d : 0.0d);
        String strGroup6 = matcher.group(14);
        long j8 = (long) ((d14 + (strGroup6 != null ? Double.parseDouble(strGroup6) : 0.0d)) * 1000.0d);
        return !zIsEmpty ? -j8 : j8;
    }

    public static float k(XmlPullParser xmlPullParser, float f) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue != null) {
            Matcher matcher = f4315v.matcher(attributeValue);
            if (matcher.matches()) {
                int i = Integer.parseInt(matcher.group(1));
                return !TextUtils.isEmpty(matcher.group(2)) ? i / Integer.parseInt(r2) : i;
            }
        }
        return f;
    }

    public static j m(XmlPullParser xmlPullParser, String str, String str2) {
        long j5;
        long j8;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] strArrSplit = attributeValue2.split("-");
            j5 = Long.parseLong(strArrSplit[0]);
            if (strArrSplit.length == 2) {
                j8 = (Long.parseLong(strArrSplit[1]) - j5) + 1;
            }
            return new j(j5, j8, attributeValue);
        }
        j5 = 0;
        j8 = -1;
        return new j(j5, j8, attributeValue);
    }

    public static int n(String str) {
        if (str != null) {
            switch (str) {
                case "subtitle":
                case "forced_subtitle":
                case "forced-subtitle":
                    return 128;
                case "description":
                    return 512;
                case "enhanced-audio-intelligibility":
                    return 2048;
                case "alternate":
                    return 2;
                case "dub":
                    return 16;
                case "main":
                    return 1;
                case "sign":
                    return 256;
                case "caption":
                    return 64;
                case "commentary":
                    return 8;
                case "emergency":
                    return 32;
                case "supplementary":
                    return 4;
            }
        }
        return 0;
    }

    public static int o(ArrayList arrayList) {
        int i = 0;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            if (com.bumptech.glide.d.j("http://dashif.org/guidelines/trickmode", ((f) arrayList.get(i10)).f4321a)) {
                i = 16384;
            }
        }
        return i;
    }

    public static r p(XmlPullParser xmlPullParser, r rVar) throws XmlPullParserException, IOException {
        long j5 = rVar != null ? rVar.f4361b : 1L;
        String attributeValue = xmlPullParser.getAttributeValue(null, "timescale");
        if (attributeValue != null) {
            j5 = Long.parseLong(attributeValue);
        }
        long j8 = j5;
        long j10 = rVar != null ? rVar.f4362c : 0L;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "presentationTimeOffset");
        if (attributeValue2 != null) {
            j10 = Long.parseLong(attributeValue2);
        }
        long j11 = j10;
        long j12 = rVar != null ? rVar.f4358d : 0L;
        long j13 = rVar != null ? rVar.f4359e : 0L;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue3 != null) {
            String[] strArrSplit = attributeValue3.split("-");
            j12 = Long.parseLong(strArrSplit[0]);
            j13 = (Long.parseLong(strArrSplit[1]) - j12) + 1;
        }
        long j14 = j13;
        long j15 = j12;
        j jVarM = rVar != null ? rVar.f4360a : null;
        while (true) {
            xmlPullParser.next();
            if (s1.d.m(xmlPullParser, "Initialization")) {
                jVarM = m(xmlPullParser, "sourceURL", "range");
            } else {
                b(xmlPullParser);
            }
            j jVar = jVarM;
            if (s1.d.l(xmlPullParser, "SegmentBase")) {
                return new r(jVar, j8, j11, j15, j14);
            }
            jVarM = jVar;
        }
    }

    public static o q(XmlPullParser xmlPullParser, o oVar, long j5, long j8, long j10, long j11, long j12) throws XmlPullParserException, IOException {
        long j13 = oVar != null ? oVar.f4361b : 1L;
        List arrayList = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, "timescale");
        if (attributeValue != null) {
            j13 = Long.parseLong(attributeValue);
        }
        long j14 = j13;
        long j15 = oVar != null ? oVar.f4362c : 0L;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "presentationTimeOffset");
        if (attributeValue2 != null) {
            j15 = Long.parseLong(attributeValue2);
        }
        long j16 = j15;
        long j17 = oVar != null ? oVar.f4349e : -9223372036854775807L;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "duration");
        if (attributeValue3 != null) {
            j17 = Long.parseLong(attributeValue3);
        }
        long j18 = j17;
        long j19 = oVar != null ? oVar.f4348d : 1L;
        String attributeValue4 = xmlPullParser.getAttributeValue(null, "startNumber");
        if (attributeValue4 != null) {
            j19 = Long.parseLong(attributeValue4);
        }
        long j20 = j19;
        long j21 = j11 == -9223372036854775807L ? j10 : j11;
        long j22 = j21 == Long.MAX_VALUE ? -9223372036854775807L : j21;
        j jVarM = null;
        List listS = null;
        do {
            xmlPullParser.next();
            if (s1.d.m(xmlPullParser, "Initialization")) {
                jVarM = m(xmlPullParser, "sourceURL", "range");
            } else if (s1.d.m(xmlPullParser, "SegmentTimeline")) {
                listS = s(xmlPullParser, j14, j8);
            } else if (s1.d.m(xmlPullParser, "SegmentURL")) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(m(xmlPullParser, "media", "mediaRange"));
            } else {
                b(xmlPullParser);
            }
        } while (!s1.d.l(xmlPullParser, "SegmentList"));
        if (oVar != null) {
            if (jVarM == null) {
                jVarM = oVar.f4360a;
            }
            if (listS == null) {
                listS = oVar.f;
            }
            if (arrayList == null) {
                arrayList = oVar.f4352j;
            }
        }
        return new o(jVarM, j14, j16, j20, j18, listS, j22, arrayList, b0.O(j12), b0.O(j5));
    }

    public static p r(XmlPullParser xmlPullParser, p pVar, List list, long j5, long j8, long j10, long j11, long j12) throws XmlPullParserException, IOException {
        long j13;
        long j14 = pVar != null ? pVar.f4361b : 1L;
        j jVarM = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, "timescale");
        if (attributeValue != null) {
            j14 = Long.parseLong(attributeValue);
        }
        long j15 = j14;
        long j16 = pVar != null ? pVar.f4362c : 0L;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "presentationTimeOffset");
        if (attributeValue2 != null) {
            j16 = Long.parseLong(attributeValue2);
        }
        long j17 = j16;
        long j18 = pVar != null ? pVar.f4349e : -9223372036854775807L;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "duration");
        if (attributeValue3 != null) {
            j18 = Long.parseLong(attributeValue3);
        }
        long j19 = j18;
        long j20 = pVar != null ? pVar.f4348d : 1L;
        String attributeValue4 = xmlPullParser.getAttributeValue(null, "startNumber");
        if (attributeValue4 != null) {
            j20 = Long.parseLong(attributeValue4);
        }
        long j21 = j20;
        int i = 0;
        while (true) {
            if (i >= list.size()) {
                j13 = -1;
                break;
            }
            f fVar = (f) list.get(i);
            if (com.bumptech.glide.d.j("http://dashif.org/guidelines/last-segment-number", fVar.f4321a)) {
                j13 = Long.parseLong(fVar.f4322b);
                break;
            }
            i++;
        }
        long j22 = j13;
        long j23 = j11 == -9223372036854775807L ? j10 : j11;
        long j24 = j23 == Long.MAX_VALUE ? -9223372036854775807L : j23;
        a7.b bVarT = t(xmlPullParser, "media", pVar != null ? pVar.f4354k : null);
        a7.b bVarT2 = t(xmlPullParser, "initialization", pVar != null ? pVar.f4353j : null);
        List listS = null;
        do {
            xmlPullParser.next();
            if (s1.d.m(xmlPullParser, "Initialization")) {
                jVarM = m(xmlPullParser, "sourceURL", "range");
            } else if (s1.d.m(xmlPullParser, "SegmentTimeline")) {
                listS = s(xmlPullParser, j15, j8);
            } else {
                b(xmlPullParser);
            }
        } while (!s1.d.l(xmlPullParser, "SegmentTemplate"));
        if (pVar != null) {
            if (jVarM == null) {
                jVarM = pVar.f4360a;
            }
            if (listS == null) {
                listS = pVar.f;
            }
        }
        return new p(jVarM, j15, j17, j21, j22, j19, listS, j24, bVarT2, bVarT, b0.O(j12), b0.O(j5));
    }

    public static ArrayList s(XmlPullParser xmlPullParser, long j5, long j8) throws XmlPullParserException, IOException {
        long j10;
        ArrayList arrayList = new ArrayList();
        long jA = 0;
        long j11 = -9223372036854775807L;
        boolean z2 = false;
        int i = 0;
        do {
            xmlPullParser.next();
            if (s1.d.m(xmlPullParser, "S")) {
                String attributeValue = xmlPullParser.getAttributeValue(null, "t");
                long j12 = attributeValue == null ? -9223372036854775807L : Long.parseLong(attributeValue);
                if (z2) {
                    int i10 = i;
                    j10 = j12;
                    jA = a(arrayList, jA, j11, i10, j10);
                } else {
                    j10 = j12;
                }
                if (j10 != -9223372036854775807L) {
                    jA = j10;
                }
                String attributeValue2 = xmlPullParser.getAttributeValue(null, "d");
                j11 = attributeValue2 == null ? -9223372036854775807L : Long.parseLong(attributeValue2);
                String attributeValue3 = xmlPullParser.getAttributeValue(null, "r");
                i = attributeValue3 == null ? 0 : Integer.parseInt(attributeValue3);
                z2 = true;
            } else {
                b(xmlPullParser);
            }
        } while (!s1.d.l(xmlPullParser, "SegmentTimeline"));
        if (z2) {
            int i11 = b0.f11647a;
            a(arrayList, jA, j11, i, b0.W(j8, j5, 1000L, RoundingMode.DOWN));
        }
        return arrayList;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:30:0x00ff. Please report as an issue. */
    public static a7.b t(XmlPullParser xmlPullParser, String str, a7.b bVar) {
        String strSubstring;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return bVar;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        arrayList.add("");
        int length = 0;
        while (length < attributeValue.length()) {
            int iIndexOf = attributeValue.indexOf("$", length);
            if (iIndexOf == -1) {
                arrayList.set(arrayList2.size(), ((String) arrayList.get(arrayList2.size())) + attributeValue.substring(length));
                length = attributeValue.length();
            } else if (iIndexOf != length) {
                arrayList.set(arrayList2.size(), ((String) arrayList.get(arrayList2.size())) + attributeValue.substring(length, iIndexOf));
                length = iIndexOf;
            } else if (attributeValue.startsWith("$$", length)) {
                arrayList.set(arrayList2.size(), ((String) arrayList.get(arrayList2.size())) + "$");
                length += 2;
            } else {
                arrayList3.add("");
                int i = length + 1;
                int iIndexOf2 = attributeValue.indexOf("$", i);
                String strSubstring2 = attributeValue.substring(i, iIndexOf2);
                if (strSubstring2.equals("RepresentationID")) {
                    arrayList2.add(1);
                } else {
                    int iIndexOf3 = strSubstring2.indexOf("%0");
                    if (iIndexOf3 != -1) {
                        strSubstring = strSubstring2.substring(iIndexOf3);
                        if (!strSubstring.endsWith("d") && !strSubstring.endsWith("x") && !strSubstring.endsWith("X")) {
                            strSubstring = strSubstring.concat("d");
                        }
                        strSubstring2 = strSubstring2.substring(0, iIndexOf3);
                    } else {
                        strSubstring = "%01d";
                    }
                    strSubstring2.getClass();
                    switch (strSubstring2) {
                        case "Number":
                            arrayList2.add(2);
                            break;
                        case "Time":
                            arrayList2.add(4);
                            break;
                        case "Bandwidth":
                            arrayList2.add(3);
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid template: ".concat(attributeValue));
                    }
                    arrayList3.set(arrayList2.size() - 1, strSubstring);
                }
                arrayList.add("");
                length = iIndexOf2 + 1;
            }
        }
        return new a7.b(arrayList, arrayList2, arrayList3, 12);
    }

    @Override // s2.o
    public final Object e(Uri uri, v1.k kVar) throws n0 {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f4320u.newPullParser();
            xmlPullParserNewPullParser.setInput(kVar, null);
            if (xmlPullParserNewPullParser.next() == 2 && "MPD".equals(xmlPullParserNewPullParser.getName())) {
                return l(xmlPullParserNewPullParser, uri);
            }
            throw n0.b("inputStream does not contain a valid media presentation description", null);
        } catch (XmlPullParserException e10) {
            throw n0.b(null, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0162  */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v4, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.util.Pair g(org.xmlpull.v1.XmlPullParser r15) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.e.g(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0936  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x097e  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0987  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0990  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x09a6  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x09ea  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0a0f  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0a3d  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0a47  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x0ab7  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x0b2b  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x0b34  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x0b39  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x0b42  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0b4b  */
    /* JADX WARN: Removed duplicated region for block: B:433:0x0b59  */
    /* JADX WARN: Removed duplicated region for block: B:471:0x0c17  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x0c1a  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x0c33  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x0c3a  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x0c52  */
    /* JADX WARN: Removed duplicated region for block: B:488:0x0c7f A[LOOP:11: B:248:0x069b->B:488:0x0c7f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:586:0x0f72 A[LOOP:5: B:159:0x0412->B:586:0x0f72, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:712:0x134f A[LOOP:1: B:45:0x00cd->B:712:0x134f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:720:0x131b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:724:0x0e0b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:743:0x08eb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:759:0x0b03 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final e2.c l(org.xmlpull.v1.XmlPullParser r165, android.net.Uri r166) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 5018
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e2.e.l(org.xmlpull.v1.XmlPullParser, android.net.Uri):e2.c");
    }
}
