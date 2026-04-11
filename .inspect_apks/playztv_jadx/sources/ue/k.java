package ue;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f12992c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f12993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f12994b;

    static {
        Pattern pattern = q.f13015c;
        f12992c = v.i("application/x-www-form-urlencoded");
    }

    public k(ArrayList arrayList, ArrayList arrayList2) {
        be.h.e(arrayList, "encodedNames");
        be.h.e(arrayList2, "encodedValues");
        this.f12993a = ve.b.v(arrayList);
        this.f12994b = ve.b.v(arrayList2);
    }

    @Override // ue.v
    public final long c() {
        return o(null, true);
    }

    @Override // ue.v
    public final q d() {
        return f12992c;
    }

    @Override // ue.v
    public final void n(hf.p pVar) throws EOFException {
        o(pVar, false);
    }

    public final long o(hf.p pVar, boolean z2) throws EOFException {
        hf.f fVar;
        if (z2) {
            fVar = new hf.f();
        } else {
            be.h.b(pVar);
            fVar = pVar.f6138v;
        }
        List list = this.f12993a;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                fVar.j0(38);
            }
            fVar.o0((String) list.get(i));
            fVar.j0(61);
            fVar.o0((String) this.f12994b.get(i));
        }
        if (!z2) {
            return 0L;
        }
        long j5 = fVar.f6113v;
        fVar.a();
        return j5;
    }
}
