package r2;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import o2.n1;
import p1.k1;
import p1.l1;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends l1 {
    public static final String A0;
    public static final String B0;
    public static final String C0;
    public static final String D0;
    public static final String E0;
    public static final String F0;
    public static final String G0;
    public static final String H0;
    public static final String I0;
    public static final String J0;
    public static final String K0;
    public static final String L0;
    public static final String M0;
    public static final String N0;
    public static final String O0;
    public static final String P0;
    public static final String Q0;
    public static final String R0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final j f11320y0 = new j(new i());

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final String f11321z0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public final boolean f11322o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final boolean f11323p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final boolean f11324q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final boolean f11325r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final boolean f11326s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final boolean f11327t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final boolean f11328u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final boolean f11329v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final SparseArray f11330w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final SparseBooleanArray f11331x0;

    static {
        int i = b0.f11647a;
        f11321z0 = Integer.toString(1000, 36);
        A0 = Integer.toString(1001, 36);
        B0 = Integer.toString(1002, 36);
        C0 = Integer.toString(1003, 36);
        D0 = Integer.toString(1004, 36);
        E0 = Integer.toString(1005, 36);
        F0 = Integer.toString(1006, 36);
        G0 = Integer.toString(1007, 36);
        H0 = Integer.toString(1008, 36);
        I0 = Integer.toString(1009, 36);
        J0 = Integer.toString(1010, 36);
        K0 = Integer.toString(1011, 36);
        L0 = Integer.toString(1012, 36);
        M0 = Integer.toString(1013, 36);
        N0 = Integer.toString(1014, 36);
        O0 = Integer.toString(1015, 36);
        P0 = Integer.toString(1016, 36);
        Q0 = Integer.toString(1017, 36);
        R0 = Integer.toString(1018, 36);
    }

    public j(i iVar) {
        super(iVar);
        this.f11322o0 = iVar.F;
        this.f11323p0 = iVar.G;
        this.f11324q0 = iVar.H;
        this.f11325r0 = iVar.I;
        this.f11326s0 = iVar.J;
        this.f11327t0 = iVar.K;
        this.f11328u0 = iVar.L;
        this.f11329v0 = iVar.M;
        this.f11330w0 = iVar.N;
        this.f11331x0 = iVar.O;
    }

    @Override // p1.l1
    public final k1 a() {
        return new i(this);
    }

    @Override // p1.l1
    public final Bundle c() {
        Bundle bundleC = super.c();
        bundleC.putBoolean(f11321z0, this.f11322o0);
        bundleC.putBoolean(A0, this.f11323p0);
        bundleC.putBoolean(B0, this.f11324q0);
        bundleC.putBoolean(N0, false);
        bundleC.putBoolean(C0, this.f11325r0);
        bundleC.putBoolean(D0, false);
        bundleC.putBoolean(E0, false);
        bundleC.putBoolean(F0, false);
        bundleC.putBoolean(O0, false);
        bundleC.putBoolean(R0, this.f11326s0);
        bundleC.putBoolean(P0, this.f11327t0);
        bundleC.putBoolean(G0, this.f11328u0);
        bundleC.putBoolean(H0, false);
        bundleC.putBoolean(I0, this.f11329v0);
        bundleC.putBoolean(Q0, false);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        int i = 0;
        while (true) {
            SparseArray sparseArray2 = this.f11330w0;
            if (i >= sparseArray2.size()) {
                SparseBooleanArray sparseBooleanArray = this.f11331x0;
                int[] iArr = new int[sparseBooleanArray.size()];
                for (int i10 = 0; i10 < sparseBooleanArray.size(); i10++) {
                    iArr[i10] = sparseBooleanArray.keyAt(i10);
                }
                bundleC.putIntArray(M0, iArr);
                return bundleC;
            }
            int iKeyAt = sparseArray2.keyAt(i);
            for (Map.Entry entry : ((Map) sparseArray2.valueAt(i)).entrySet()) {
                if (entry.getValue() != null) {
                    throw new ClassCastException();
                }
                arrayList2.add((n1) entry.getKey());
                arrayList.add(Integer.valueOf(iKeyAt));
            }
            bundleC.putIntArray(J0, q1.c.S(arrayList));
            bundleC.putParcelableArrayList(K0, s1.d.p(arrayList2, new h(0)));
            SparseArray<? extends Parcelable> sparseArray3 = new SparseArray<>(sparseArray.size());
            if (sparseArray.size() > 0) {
                sparseArray.keyAt(0);
                l4.a.t(sparseArray.valueAt(0));
                throw null;
            }
            bundleC.putSparseParcelableArray(L0, sparseArray3);
            i++;
        }
    }

    @Override // p1.l1
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && j.class == obj.getClass()) {
            j jVar = (j) obj;
            if (super.equals(jVar) && this.f11322o0 == jVar.f11322o0 && this.f11323p0 == jVar.f11323p0 && this.f11324q0 == jVar.f11324q0 && this.f11325r0 == jVar.f11325r0 && this.f11326s0 == jVar.f11326s0 && this.f11327t0 == jVar.f11327t0 && this.f11328u0 == jVar.f11328u0 && this.f11329v0 == jVar.f11329v0) {
                SparseBooleanArray sparseBooleanArray = jVar.f11331x0;
                SparseBooleanArray sparseBooleanArray2 = this.f11331x0;
                int size = sparseBooleanArray2.size();
                if (sparseBooleanArray.size() == size) {
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            SparseArray sparseArray = jVar.f11330w0;
                            SparseArray sparseArray2 = this.f11330w0;
                            int size2 = sparseArray2.size();
                            if (sparseArray.size() == size2) {
                                for (int i10 = 0; i10 < size2; i10++) {
                                    int iIndexOfKey = sparseArray.indexOfKey(sparseArray2.keyAt(i10));
                                    if (iIndexOfKey >= 0) {
                                        Map map = (Map) sparseArray2.valueAt(i10);
                                        Map map2 = (Map) sparseArray.valueAt(iIndexOfKey);
                                        if (map2.size() == map.size()) {
                                            for (Map.Entry entry : map.entrySet()) {
                                                n1 n1Var = (n1) entry.getKey();
                                                if (!map2.containsKey(n1Var) || !Objects.equals(entry.getValue(), map2.get(n1Var))) {
                                                }
                                            }
                                        }
                                    }
                                }
                                return true;
                            }
                        } else {
                            if (sparseBooleanArray.indexOfKey(sparseBooleanArray2.keyAt(i)) < 0) {
                                break;
                            }
                            i++;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // p1.l1
    public final int hashCode() {
        return (((((((((((((((((super.hashCode() + 31) * 31) + (this.f11322o0 ? 1 : 0)) * 31) + (this.f11323p0 ? 1 : 0)) * 31) + (this.f11324q0 ? 1 : 0)) * 961) + (this.f11325r0 ? 1 : 0)) * 28629151) + (this.f11326s0 ? 1 : 0)) * 31) + (this.f11327t0 ? 1 : 0)) * 31) + (this.f11328u0 ? 1 : 0)) * 961) + (this.f11329v0 ? 1 : 0)) * 31;
    }
}
