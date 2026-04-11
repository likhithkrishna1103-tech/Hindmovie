package kf;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m extends x {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s f7505d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f7506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f7507c;

    static {
        ne.g gVar = s.f7522c;
        f7505d = t1.g("application/x-www-form-urlencoded");
    }

    public m(ArrayList arrayList, ArrayList arrayList2) {
        ge.i.e(arrayList, "encodedNames");
        ge.i.e(arrayList2, "encodedValues");
        this.f7506b = lf.f.i(arrayList);
        this.f7507c = lf.f.i(arrayList2);
    }

    @Override // kf.x
    public final long a() {
        return e(null, true);
    }

    @Override // kf.x
    public final s b() {
        return f7505d;
    }

    @Override // kf.x
    public final void d(ag.p pVar) throws EOFException {
        e(pVar, false);
    }

    public final long e(ag.p pVar, boolean z10) throws EOFException {
        ag.e eVar;
        if (z10) {
            eVar = new ag.e();
        } else {
            ge.i.b(pVar);
            eVar = pVar.f457w;
        }
        List list = this.f7506b;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                eVar.i0(38);
            }
            eVar.o0((String) list.get(i));
            eVar.i0(61);
            eVar.o0((String) this.f7507c.get(i));
        }
        if (!z10) {
            return 0L;
        }
        long j4 = eVar.f429w;
        eVar.a();
        return j4;
    }
}
