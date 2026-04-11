package androidx.emoji2.text;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray f901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c0 f902b;

    public z(int i) {
        this.f901a = new SparseArray(i);
    }

    public final void a(c0 c0Var, int i, int i10) {
        int iA = c0Var.a(i);
        SparseArray sparseArray = this.f901a;
        z zVar = sparseArray == null ? null : (z) sparseArray.get(iA);
        if (zVar == null) {
            zVar = new z(1);
            sparseArray.put(c0Var.a(i), zVar);
        }
        if (i10 > i) {
            zVar.a(c0Var, i + 1, i10);
        } else {
            zVar.f902b = c0Var;
        }
    }
}
