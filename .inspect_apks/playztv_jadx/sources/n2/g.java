package n2;

import java.util.ArrayList;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;
import p1.n0;
import p1.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends k8.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f8672e;
    public final LinkedList f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8673g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f8674h;
    public long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f8675j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f8676k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8677l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f8678m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f8679n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f8680o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f8681p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f8682q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f8683r;

    public g(k8.c cVar, String str) {
        super(cVar, str, "StreamIndex");
        this.f8672e = str;
        this.f = new LinkedList();
    }

    @Override // k8.c
    public final void a(Object obj) {
        if (obj instanceof q) {
            this.f.add((q) obj);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v0 n2.b, still in use, count: 2, list:
          (r3v0 n2.b) from 0x0082: MOVE (r26v0 n2.b) = (r3v0 n2.b) (LINE:131)
          (r3v0 n2.b) from 0x004e: MOVE (r26v4 n2.b) = (r3v0 n2.b) (LINE:79)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    @Override // k8.c
    public final java.lang.Object b() {
        /*
            Method dump skipped, instruction units count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n2.g.b():java.lang.Object");
    }

    @Override // k8.c
    public final boolean d(String str) {
        return "c".equals(str);
    }

    @Override // k8.c
    public final void j(XmlPullParser xmlPullParser) throws n0 {
        int i = 1;
        if (!"c".equals(xmlPullParser.getName())) {
            String attributeValue = xmlPullParser.getAttributeValue(null, "Type");
            if (attributeValue == null) {
                throw new c3.d("Type", 1);
            }
            if (!"audio".equalsIgnoreCase(attributeValue)) {
                if ("video".equalsIgnoreCase(attributeValue)) {
                    i = 2;
                } else {
                    if (!"text".equalsIgnoreCase(attributeValue)) {
                        throw n0.b("Invalid key value[" + attributeValue + "]", null);
                    }
                    i = 3;
                }
            }
            this.f8673g = i;
            l(Integer.valueOf(i), "Type");
            if (this.f8673g == 3) {
                String attributeValue2 = xmlPullParser.getAttributeValue(null, "Subtype");
                if (attributeValue2 == null) {
                    throw new c3.d("Subtype", 1);
                }
                this.f8674h = attributeValue2;
            } else {
                this.f8674h = xmlPullParser.getAttributeValue(null, "Subtype");
            }
            l(this.f8674h, "Subtype");
            String attributeValue3 = xmlPullParser.getAttributeValue(null, "Name");
            this.f8675j = attributeValue3;
            l(attributeValue3, "Name");
            String attributeValue4 = xmlPullParser.getAttributeValue(null, "Url");
            if (attributeValue4 == null) {
                throw new c3.d("Url", 1);
            }
            this.f8676k = attributeValue4;
            this.f8677l = k8.c.g(xmlPullParser, "MaxWidth");
            this.f8678m = k8.c.g(xmlPullParser, "MaxHeight");
            this.f8679n = k8.c.g(xmlPullParser, "DisplayWidth");
            this.f8680o = k8.c.g(xmlPullParser, "DisplayHeight");
            String attributeValue5 = xmlPullParser.getAttributeValue(null, "Language");
            this.f8681p = attributeValue5;
            l(attributeValue5, "Language");
            long jG = k8.c.g(xmlPullParser, "TimeScale");
            this.i = jG;
            if (jG == -1) {
                this.i = ((Long) c("TimeScale")).longValue();
            }
            this.f8682q = new ArrayList();
            return;
        }
        int size = this.f8682q.size();
        long jH = k8.c.h(xmlPullParser, "t", -9223372036854775807L);
        if (jH == -9223372036854775807L) {
            if (size == 0) {
                jH = 0;
            } else {
                if (this.f8683r == -1) {
                    throw n0.b("Unable to infer start time", null);
                }
                jH = this.f8683r + ((Long) this.f8682q.get(size - 1)).longValue();
            }
        }
        this.f8682q.add(Long.valueOf(jH));
        this.f8683r = k8.c.h(xmlPullParser, "d", -9223372036854775807L);
        long jH2 = k8.c.h(xmlPullParser, "r", 1L);
        if (jH2 > 1 && this.f8683r == -9223372036854775807L) {
            throw n0.b("Repeated chunk with unspecified duration", null);
        }
        while (true) {
            long j5 = i;
            if (j5 >= jH2) {
                return;
            }
            this.f8682q.add(Long.valueOf((this.f8683r * j5) + jH));
            i++;
        }
    }
}
