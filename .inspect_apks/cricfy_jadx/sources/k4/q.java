package k4;

import android.util.SparseBooleanArray;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l1 f7135e;
    public static final v1.s0 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l1 f7136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v1.s0 f7137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ua.i0 f7138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ua.i0 f7139d;

    static {
        HashSet hashSet = new HashSet();
        ua.z0 z0Var = k1.f7051d;
        for (int i = 0; i < z0Var.f12415y; i++) {
            hashSet.add(new k1(((Integer) z0Var.get(i)).intValue()));
        }
        f7135e = new l1(hashSet);
        HashSet hashSet2 = new HashSet();
        ua.z0 z0Var2 = k1.f7052e;
        for (int i10 = 0; i10 < z0Var2.f12415y; i10++) {
            hashSet2.add(new k1(((Integer) z0Var2.get(i10)).intValue()));
        }
        for (int i11 = 0; i11 < z0Var.f12415y; i11++) {
            hashSet2.add(new k1(((Integer) z0Var.get(i11)).intValue()));
        }
        new l1(hashSet2);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        for (int i12 : v1.r0.f12976b) {
            y1.d.g(!false);
            sparseBooleanArray.append(i12, true);
        }
        y1.d.g(!false);
        f = new v1.s0(new v1.n(sparseBooleanArray));
    }

    public q(l1 l1Var, v1.s0 s0Var, ua.i0 i0Var, ua.i0 i0Var2) {
        this.f7136a = l1Var;
        this.f7137b = s0Var;
        this.f7138c = i0Var;
        this.f7139d = i0Var2;
    }
}
