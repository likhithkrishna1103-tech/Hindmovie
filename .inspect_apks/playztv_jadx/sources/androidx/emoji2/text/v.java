package androidx.emoji2.text;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray f1205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f1206b;

    public v(int i) {
        this.f1205a = new SparseArray(i);
    }

    public final void a(y yVar, int i, int i10) {
        int iA = yVar.a(i);
        SparseArray sparseArray = this.f1205a;
        v vVar = sparseArray == null ? null : (v) sparseArray.get(iA);
        if (vVar == null) {
            vVar = new v(1);
            sparseArray.put(yVar.a(i), vVar);
        }
        if (i10 > i) {
            vVar.a(yVar, i + 1, i10);
        } else {
            vVar.f1206b = yVar;
        }
    }
}
