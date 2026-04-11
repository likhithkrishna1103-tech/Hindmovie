package v4;

import android.util.SparseArray;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SparseArray f13303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set f13305c;

    public final l0 a(int i) {
        SparseArray sparseArray = this.f13303a;
        l0 l0Var = (l0) sparseArray.get(i);
        if (l0Var != null) {
            return l0Var;
        }
        l0 l0Var2 = new l0();
        sparseArray.put(i, l0Var2);
        return l0Var2;
    }
}
