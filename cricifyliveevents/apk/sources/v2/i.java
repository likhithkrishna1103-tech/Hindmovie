package v2;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import v1.b0;
import v1.k1;
import v1.l1;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i extends l1 {
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
    public static final i f13094y0 = new i(new h());

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final String f13095z0;
    public final boolean o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final boolean f13096p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final boolean f13097q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final boolean f13098r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final boolean f13099s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final boolean f13100t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final boolean f13101u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final boolean f13102v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final SparseArray f13103w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final SparseBooleanArray f13104x0;

    static {
        int i = a0.f14551a;
        f13095z0 = Integer.toString(1000, 36);
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

    public i(h hVar) {
        super(hVar);
        this.o0 = hVar.F;
        this.f13096p0 = hVar.G;
        this.f13097q0 = hVar.H;
        this.f13098r0 = hVar.I;
        this.f13099s0 = hVar.J;
        this.f13100t0 = hVar.K;
        this.f13101u0 = hVar.L;
        this.f13102v0 = hVar.M;
        this.f13103w0 = hVar.N;
        this.f13104x0 = hVar.O;
    }

    @Override // v1.l1
    public final k1 a() {
        return new h(this);
    }

    @Override // v1.l1
    public final Bundle c() {
        Bundle bundleC = super.c();
        bundleC.putBoolean(f13095z0, this.o0);
        bundleC.putBoolean(A0, this.f13096p0);
        bundleC.putBoolean(B0, this.f13097q0);
        bundleC.putBoolean(N0, false);
        bundleC.putBoolean(C0, this.f13098r0);
        bundleC.putBoolean(D0, false);
        bundleC.putBoolean(E0, false);
        bundleC.putBoolean(F0, false);
        bundleC.putBoolean(O0, false);
        bundleC.putBoolean(R0, this.f13099s0);
        bundleC.putBoolean(P0, this.f13100t0);
        bundleC.putBoolean(G0, this.f13101u0);
        bundleC.putBoolean(H0, false);
        bundleC.putBoolean(I0, this.f13102v0);
        bundleC.putBoolean(Q0, false);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        int i = 0;
        while (true) {
            SparseArray sparseArray2 = this.f13103w0;
            if (i >= sparseArray2.size()) {
                SparseBooleanArray sparseBooleanArray = this.f13104x0;
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
                arrayList2.add((s2.l1) entry.getKey());
                arrayList.add(Integer.valueOf(iKeyAt));
            }
            bundleC.putIntArray(J0, com.bumptech.glide.d.C(arrayList));
            bundleC.putParcelableArrayList(K0, y1.d.p(arrayList2, new b0(6)));
            SparseArray<? extends Parcelable> sparseArray3 = new SparseArray<>(sparseArray.size());
            if (sparseArray.size() > 0) {
                sparseArray.keyAt(0);
                q4.a.u(sparseArray.valueAt(0));
                throw null;
            }
            bundleC.putSparseParcelableArray(L0, sparseArray3);
            i++;
        }
    }

    @Override // v1.l1
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.class == obj.getClass()) {
            i iVar = (i) obj;
            if (super.equals(iVar) && this.o0 == iVar.o0 && this.f13096p0 == iVar.f13096p0 && this.f13097q0 == iVar.f13097q0 && this.f13098r0 == iVar.f13098r0 && this.f13099s0 == iVar.f13099s0 && this.f13100t0 == iVar.f13100t0 && this.f13101u0 == iVar.f13101u0 && this.f13102v0 == iVar.f13102v0) {
                SparseBooleanArray sparseBooleanArray = iVar.f13104x0;
                SparseBooleanArray sparseBooleanArray2 = this.f13104x0;
                int size = sparseBooleanArray2.size();
                if (sparseBooleanArray.size() == size) {
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            SparseArray sparseArray = iVar.f13103w0;
                            SparseArray sparseArray2 = this.f13103w0;
                            int size2 = sparseArray2.size();
                            if (sparseArray.size() == size2) {
                                for (int i10 = 0; i10 < size2; i10++) {
                                    int iIndexOfKey = sparseArray.indexOfKey(sparseArray2.keyAt(i10));
                                    if (iIndexOfKey >= 0) {
                                        Map map = (Map) sparseArray2.valueAt(i10);
                                        Map map2 = (Map) sparseArray.valueAt(iIndexOfKey);
                                        if (map2.size() == map.size()) {
                                            for (Map.Entry entry : map.entrySet()) {
                                                s2.l1 l1Var = (s2.l1) entry.getKey();
                                                if (!map2.containsKey(l1Var) || !Objects.equals(entry.getValue(), map2.get(l1Var))) {
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

    @Override // v1.l1
    public final int hashCode() {
        return (((((((((((((((((super.hashCode() + 31) * 31) + (this.o0 ? 1 : 0)) * 31) + (this.f13096p0 ? 1 : 0)) * 31) + (this.f13097q0 ? 1 : 0)) * 961) + (this.f13098r0 ? 1 : 0)) * 28629151) + (this.f13099s0 ? 1 : 0)) * 31) + (this.f13100t0 ? 1 : 0)) * 31) + (this.f13101u0 ? 1 : 0)) * 961) + (this.f13102v0 ? 1 : 0)) * 31;
    }
}
