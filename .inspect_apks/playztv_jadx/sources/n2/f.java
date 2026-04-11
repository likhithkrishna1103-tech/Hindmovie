package n2;

import java.math.RoundingMode;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;
import p1.l;
import p1.m;
import p1.n0;
import p1.p;
import p1.q;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends k8.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedList f8665e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f8667h;
    public long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f8668j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8669k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f8670l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f8671m;

    public f(String str) {
        super(null, str, "SmoothStreamingMedia");
        this.f8669k = -1;
        this.f8671m = null;
        this.f8665e = new LinkedList();
    }

    @Override // k8.c
    public final void a(Object obj) {
        if (obj instanceof b) {
            this.f8665e.add((b) obj);
        } else if (obj instanceof a) {
            s1.d.g(this.f8671m == null);
            this.f8671m = (a) obj;
        }
    }

    @Override // k8.c
    public final Object b() {
        a aVar;
        long jW;
        LinkedList linkedList = this.f8665e;
        int size = linkedList.size();
        b[] bVarArr = new b[size];
        linkedList.toArray(bVarArr);
        a aVar2 = this.f8671m;
        if (aVar2 != null) {
            m mVar = new m(new l(aVar2.f8638a, null, "video/mp4", aVar2.f8639b));
            for (int i = 0; i < size; i++) {
                b bVar = bVarArr[i];
                int i10 = bVar.f8641a;
                if (i10 == 2 || i10 == 1) {
                    q[] qVarArr = bVar.f8648j;
                    for (int i11 = 0; i11 < qVarArr.length; i11++) {
                        p pVarA = qVarArr[i11].a();
                        pVarA.f9971q = mVar;
                        qVarArr[i11] = new q(pVarA);
                    }
                }
            }
        }
        int i12 = this.f;
        int i13 = this.f8666g;
        long j5 = this.f8667h;
        long j8 = this.i;
        long j10 = this.f8668j;
        int i14 = this.f8669k;
        boolean z2 = this.f8670l;
        a aVar3 = this.f8671m;
        long jW2 = -9223372036854775807L;
        if (j8 == 0) {
            aVar = aVar3;
            jW = -9223372036854775807L;
        } else {
            int i15 = b0.f11647a;
            aVar = aVar3;
            jW = b0.W(j8, 1000000L, j5, RoundingMode.DOWN);
        }
        if (j10 != 0) {
            int i16 = b0.f11647a;
            jW2 = b0.W(j10, 1000000L, j5, RoundingMode.DOWN);
        }
        return new c(i12, i13, jW, jW2, i14, z2, aVar, bVarArr);
    }

    @Override // k8.c
    public final void j(XmlPullParser xmlPullParser) throws n0 {
        this.f = k8.c.i(xmlPullParser, "MajorVersion");
        this.f8666g = k8.c.i(xmlPullParser, "MinorVersion");
        this.f8667h = k8.c.h(xmlPullParser, "TimeScale", 10000000L);
        String attributeValue = xmlPullParser.getAttributeValue(null, "Duration");
        if (attributeValue == null) {
            throw new c3.d("Duration", 1);
        }
        try {
            this.i = Long.parseLong(attributeValue);
            this.f8668j = k8.c.h(xmlPullParser, "DVRWindowLength", 0L);
            this.f8669k = k8.c.g(xmlPullParser, "LookaheadCount");
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "IsLive");
            this.f8670l = attributeValue2 != null ? Boolean.parseBoolean(attributeValue2) : false;
            l(Long.valueOf(this.f8667h), "TimeScale");
        } catch (NumberFormatException e10) {
            throw n0.b(null, e10);
        }
    }
}
