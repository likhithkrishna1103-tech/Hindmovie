package i3;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import ua.f0;
import ua.i0;
import ua.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f6178a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f6179b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f6180c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c8, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static f9.s0 a(java.lang.String r19) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.e.a(java.lang.String):f9.s0");
    }

    public static z0 b(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        f0 f0VarJ = i0.j();
        String strConcat = str.concat(":Item");
        String strConcat2 = str.concat(":Directory");
        do {
            xmlPullParser.next();
            if (y1.d.m(xmlPullParser, strConcat)) {
                String strConcat3 = str2.concat(":Mime");
                String strConcat4 = str2.concat(":Semantic");
                String strConcat5 = str2.concat(":Length");
                String strConcat6 = str2.concat(":Padding");
                String strK = y1.d.k(xmlPullParser, strConcat3);
                String strK2 = y1.d.k(xmlPullParser, strConcat4);
                String strK3 = y1.d.k(xmlPullParser, strConcat5);
                String strK4 = y1.d.k(xmlPullParser, strConcat6);
                if (strK == null || strK2 == null) {
                    return z0.f12413z;
                }
                f0VarJ.a(new c(strK3 != null ? Long.parseLong(strK3) : 0L, strK4 != null ? Long.parseLong(strK4) : 0L, strK));
            }
        } while (!y1.d.l(xmlPullParser, strConcat2));
        return f0VarJ.g();
    }
}
