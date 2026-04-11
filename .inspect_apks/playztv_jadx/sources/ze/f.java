package ze;

import java.util.ArrayList;
import ue.o;
import ue.p;
import ue.x;
import w1.m;
import ye.h;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f14967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f14968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f14970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b2.g f14971e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f14972g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f14973h;
    public int i;

    public f(h hVar, ArrayList arrayList, int i, m mVar, b2.g gVar, int i10, int i11, int i12) {
        this.f14967a = hVar;
        this.f14968b = arrayList;
        this.f14969c = i;
        this.f14970d = mVar;
        this.f14971e = gVar;
        this.f = i10;
        this.f14972g = i11;
        this.f14973h = i12;
    }

    public static f a(f fVar, int i, m mVar, b2.g gVar, int i10) {
        if ((i10 & 1) != 0) {
            i = fVar.f14969c;
        }
        int i11 = i;
        if ((i10 & 2) != 0) {
            mVar = fVar.f14970d;
        }
        m mVar2 = mVar;
        if ((i10 & 4) != 0) {
            gVar = fVar.f14971e;
        }
        b2.g gVar2 = gVar;
        int i12 = fVar.f;
        int i13 = fVar.f14972g;
        int i14 = fVar.f14973h;
        be.h.e(gVar2, "request");
        return new f(fVar.f14967a, fVar.f14968b, i11, mVar2, gVar2, i12, i13, i14);
    }

    public final x b(b2.g gVar) {
        be.h.e(gVar, "request");
        ArrayList arrayList = this.f14968b;
        int size = arrayList.size();
        int i = this.f14969c;
        if (i >= size) {
            throw new IllegalStateException("Check failed.");
        }
        this.i++;
        m mVar = this.f14970d;
        if (mVar != null) {
            if (!((ye.d) mVar.f13547c).b((o) gVar.f1737b)) {
                throw new IllegalStateException(("network interceptor " + arrayList.get(i - 1) + " must retain the same host and port").toString());
            }
            if (this.i != 1) {
                throw new IllegalStateException(("network interceptor " + arrayList.get(i - 1) + " must call proceed() exactly once").toString());
            }
        }
        int i10 = i + 1;
        f fVarA = a(this, i10, null, gVar, 58);
        p pVar = (p) arrayList.get(i);
        x xVarA = pVar.a(fVarA);
        if (xVarA == null) {
            throw new NullPointerException("interceptor " + pVar + " returned null");
        }
        if (mVar != null && i10 < arrayList.size() && fVarA.i != 1) {
            throw new IllegalStateException(("network interceptor " + pVar + " must call proceed() exactly once").toString());
        }
        if (xVarA.A != null) {
            return xVarA;
        }
        throw new IllegalStateException(("interceptor " + pVar + " returned a response with no body").toString());
    }
}
