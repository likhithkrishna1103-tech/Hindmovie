package e3;

import aa.c1;
import aa.g0;
import aa.j0;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f4386a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f4387b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f4388c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c8, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static af.a a(java.lang.String r19) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e3.e.a(java.lang.String):af.a");
    }

    public static c1 b(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        g0 g0VarN = j0.n();
        String strConcat = str.concat(":Item");
        String strConcat2 = str.concat(":Directory");
        do {
            xmlPullParser.next();
            if (s1.d.m(xmlPullParser, strConcat)) {
                String strConcat3 = str2.concat(":Mime");
                String strConcat4 = str2.concat(":Semantic");
                String strConcat5 = str2.concat(":Length");
                String strConcat6 = str2.concat(":Padding");
                String strK = s1.d.k(xmlPullParser, strConcat3);
                String strK2 = s1.d.k(xmlPullParser, strConcat4);
                String strK3 = s1.d.k(xmlPullParser, strConcat5);
                String strK4 = s1.d.k(xmlPullParser, strConcat6);
                if (strK == null || strK2 == null) {
                    return c1.f650y;
                }
                g0VarN.a(new c(strK3 != null ? Long.parseLong(strK3) : 0L, strK4 != null ? Long.parseLong(strK4) : 0L, strK));
            }
        } while (!s1.d.l(xmlPullParser, strConcat2));
        return g0VarN.g();
    }
}
