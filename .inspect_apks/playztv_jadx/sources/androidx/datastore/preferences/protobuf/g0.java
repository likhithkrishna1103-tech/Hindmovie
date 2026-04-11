package androidx.datastore.preferences.protobuf;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g0 extends h0 {
    @Override // androidx.datastore.preferences.protobuf.h0
    public final void a(long j5, Object obj) {
        ((b) ((y) s1.f1128d.i(j5, obj))).f1011u = false;
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final void b(Object obj, long j5, Object obj2) {
        r1 r1Var = s1.f1128d;
        y yVarK = (y) r1Var.i(j5, obj);
        y yVar = (y) r1Var.i(j5, obj2);
        int size = yVarK.size();
        int size2 = yVar.size();
        if (size > 0 && size2 > 0) {
            if (!((b) yVarK).f1011u) {
                yVarK = yVarK.k(size2 + size);
            }
            yVarK.addAll(yVar);
        }
        if (size > 0) {
            yVar = yVarK;
        }
        s1.o(obj, j5, yVar);
    }

    @Override // androidx.datastore.preferences.protobuf.h0
    public final List c(long j5, Object obj) {
        y yVar = (y) s1.f1128d.i(j5, obj);
        if (((b) yVar).f1011u) {
            return yVar;
        }
        int size = yVar.size();
        y yVarK = yVar.k(size == 0 ? 10 : size * 2);
        s1.o(obj, j5, yVarK);
        return yVarK;
    }
}
