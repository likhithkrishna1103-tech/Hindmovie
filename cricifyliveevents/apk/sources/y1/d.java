package y1;

import android.media.MediaFormat;
import android.os.Bundle;
import g2.u0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import ua.f0;
import ua.i0;
import ua.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static void a(String str, boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException(String.valueOf(str));
        }
    }

    public static void b(boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException();
        }
    }

    public static void c(int i, int i10) {
        if (i < 0 || i >= i10) {
            throw new IndexOutOfBoundsException();
        }
    }

    public static void d(u0 u0Var) {
        u0Var.getClass();
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void f(String str, boolean z10) {
        if (!z10) {
            throw new IllegalStateException(String.valueOf(str));
        }
    }

    public static void g(boolean z10) {
        if (!z10) {
            throw new IllegalStateException();
        }
    }

    public static void h(Object obj) {
        if (obj == null) {
            throw new IllegalStateException();
        }
    }

    public static void i(Object obj, String str) {
        if (obj == null) {
            throw new IllegalStateException(str);
        }
    }

    public static z0 j(ta.f fVar, ArrayList arrayList) {
        f0 f0VarJ = i0.j();
        for (int i = 0; i < arrayList.size(); i++) {
            Bundle bundle = (Bundle) arrayList.get(i);
            bundle.getClass();
            f0VarJ.a(fVar.apply(bundle));
        }
        return f0VarJ.g();
    }

    public static String k(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            if (xmlPullParser.getAttributeName(i).equals(str)) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }

    public static boolean l(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getEventType() == 3 && xmlPullParser.getName().equals(str);
    }

    public static boolean m(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getEventType() == 2 && xmlPullParser.getName().equals(str);
    }

    public static void n(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public static void o(MediaFormat mediaFormat, List list) {
        for (int i = 0; i < list.size(); i++) {
            mediaFormat.setByteBuffer(l0.e.g(i, "csd-"), ByteBuffer.wrap((byte[]) list.get(i)));
        }
    }

    public static ArrayList p(Collection collection, ta.f fVar) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add((Bundle) fVar.apply(it.next()));
        }
        return arrayList;
    }
}
