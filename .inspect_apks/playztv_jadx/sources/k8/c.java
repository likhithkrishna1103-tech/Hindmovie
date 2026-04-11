package k8;

import android.util.Pair;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f7102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f7103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f7104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Serializable f7105d = new LinkedList();

    public c(c cVar, String str, String str2) {
        this.f7104c = cVar;
        this.f7102a = str;
        this.f7103b = str2;
    }

    public static int g(XmlPullParser xmlPullParser, String str) throws p1.n0 {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return -1;
        }
        try {
            return Integer.parseInt(attributeValue);
        } catch (NumberFormatException e10) {
            throw p1.n0.b(null, e10);
        }
    }

    public static long h(XmlPullParser xmlPullParser, String str, long j5) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            return j5;
        }
        try {
            return Long.parseLong(attributeValue);
        } catch (NumberFormatException e10) {
            throw p1.n0.b(null, e10);
        }
    }

    public static int i(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (attributeValue == null) {
            throw new c3.d(str, 1);
        }
        try {
            return Integer.parseInt(attributeValue);
        } catch (NumberFormatException e10) {
            throw p1.n0.b(null, e10);
        }
    }

    public static Boolean n(Boolean bool, boolean z2) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Boolean o(String str, com.google.android.gms.internal.measurement.d2 d2Var, p0 p0Var) {
        List listR;
        t7.v.h(d2Var);
        if (str != null && d2Var.v() && d2Var.o() != 1 && (d2Var.o() != 7 ? d2Var.u() : d2Var.n() != 0)) {
            int iO = d2Var.o();
            boolean zS = d2Var.s();
            String strQ = (zS || iO == 2 || iO == 7) ? d2Var.q() : d2Var.q().toUpperCase(Locale.ENGLISH);
            if (d2Var.n() == 0) {
                listR = null;
            } else {
                listR = d2Var.r();
                if (!zS) {
                    ArrayList arrayList = new ArrayList(listR.size());
                    Iterator it = listR.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((String) it.next()).toUpperCase(Locale.ENGLISH));
                    }
                    listR = Collections.unmodifiableList(arrayList);
                }
            }
            String str2 = iO == 2 ? strQ : null;
            if (iO != 7 ? strQ != null : listR != null && !listR.isEmpty()) {
                if (!zS && iO != 2) {
                    str = str.toUpperCase(Locale.ENGLISH);
                }
                switch (k4.f7292a[v.e.c(iO)]) {
                    case 1:
                        if (str2 != null) {
                            try {
                                return Boolean.valueOf(Pattern.compile(str2, zS ? 0 : 66).matcher(str).matches());
                            } catch (PatternSyntaxException unused) {
                                p0Var.D.c(str2, "Invalid regular expression in REGEXP audience filter. expression");
                            }
                        }
                        break;
                    case 2:
                        return Boolean.valueOf(str.startsWith(strQ));
                    case 3:
                        return Boolean.valueOf(str.endsWith(strQ));
                    case b1.j.LONG_FIELD_NUMBER /* 4 */:
                        return Boolean.valueOf(str.contains(strQ));
                    case b1.j.STRING_FIELD_NUMBER /* 5 */:
                        return Boolean.valueOf(str.equals(strQ));
                    case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                        if (listR != null) {
                            return Boolean.valueOf(listR.contains(str));
                        }
                        break;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Boolean p(java.math.BigDecimal r8, com.google.android.gms.internal.measurement.a2 r9, double r10) {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.c.p(java.math.BigDecimal, com.google.android.gms.internal.measurement.a2, double):java.lang.Boolean");
    }

    public abstract Object b();

    public Object c(String str) {
        LinkedList linkedList = (LinkedList) this.f7105d;
        for (int i = 0; i < linkedList.size(); i++) {
            Pair pair = (Pair) linkedList.get(i);
            if (((String) pair.first).equals(str)) {
                return pair.second;
            }
        }
        c cVar = (c) this.f7104c;
        if (cVar == null) {
            return null;
        }
        return cVar.c(str);
    }

    public boolean d(String str) {
        return false;
    }

    public Object e(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        boolean z2 = false;
        int i = 0;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            c gVar = null;
            if (eventType == 1) {
                return null;
            }
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (((String) this.f7103b).equals(name)) {
                    j(xmlPullParser);
                    z2 = true;
                } else if (z2) {
                    if (i > 0) {
                        i++;
                    } else if (d(name)) {
                        j(xmlPullParser);
                    } else {
                        String str = (String) this.f7102a;
                        if ("QualityLevel".equals(name)) {
                            gVar = new n2.e(this, str, "QualityLevel");
                        } else if ("Protection".equals(name)) {
                            gVar = new n2.d(this, str, "Protection");
                        } else if ("StreamIndex".equals(name)) {
                            gVar = new n2.g(this, str);
                        }
                        if (gVar == null) {
                            i = 1;
                        } else {
                            a(gVar.e(xmlPullParser));
                        }
                    }
                }
            } else if (eventType != 3) {
                if (eventType == 4 && z2 && i == 0) {
                    k(xmlPullParser);
                }
            } else if (!z2) {
                continue;
            } else if (i > 0) {
                i--;
            } else {
                String name2 = xmlPullParser.getName();
                f(xmlPullParser);
                if (!d(name2)) {
                    return b();
                }
            }
            xmlPullParser.next();
        }
    }

    public abstract void j(XmlPullParser xmlPullParser);

    public void l(Object obj, String str) {
        ((LinkedList) this.f7105d).add(Pair.create(str, obj));
    }

    public abstract int m();

    public abstract boolean q();

    public abstract boolean r();

    public void a(Object obj) {
    }

    public void f(XmlPullParser xmlPullParser) {
    }

    public void k(XmlPullParser xmlPullParser) {
    }
}
