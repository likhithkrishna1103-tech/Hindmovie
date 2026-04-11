package g4;

import android.util.SparseBooleanArray;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final n1 f5178e;
    public static final p1.s0 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n1 f5179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p1.s0 f5180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final aa.j0 f5181c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final aa.j0 f5182d;

    static {
        HashSet hashSet = new HashSet();
        aa.c1 c1Var = m1.f5130d;
        for (int i = 0; i < c1Var.f652x; i++) {
            hashSet.add(new m1(((Integer) c1Var.get(i)).intValue()));
        }
        f5178e = new n1(hashSet);
        HashSet hashSet2 = new HashSet();
        aa.c1 c1Var2 = m1.f5131e;
        for (int i10 = 0; i10 < c1Var2.f652x; i10++) {
            hashSet2.add(new m1(((Integer) c1Var2.get(i10)).intValue()));
        }
        for (int i11 = 0; i11 < c1Var.f652x; i11++) {
            hashSet2.add(new m1(((Integer) c1Var.get(i11)).intValue()));
        }
        new n1(hashSet2);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        for (int i12 : p1.r0.f10044b) {
            s1.d.g(!false);
            sparseBooleanArray.append(i12, true);
        }
        s1.d.g(!false);
        f = new p1.s0(new p1.o(sparseBooleanArray));
    }

    public q(n1 n1Var, p1.s0 s0Var, aa.j0 j0Var, aa.j0 j0Var2) {
        this.f5179a = n1Var;
        this.f5180b = s0Var;
        this.f5181c = j0Var;
        this.f5182d = j0Var2;
    }
}
