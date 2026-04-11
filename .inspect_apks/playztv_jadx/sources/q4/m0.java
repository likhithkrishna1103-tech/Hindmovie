package q4;

import android.util.SparseArray;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SparseArray f10878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set f10880c;

    public final l0 a(int i) {
        SparseArray sparseArray = this.f10878a;
        l0 l0Var = (l0) sparseArray.get(i);
        if (l0Var != null) {
            return l0Var;
        }
        l0 l0Var2 = new l0();
        sparseArray.put(i, l0Var2);
        return l0Var2;
    }
}
