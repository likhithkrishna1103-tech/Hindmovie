package p1;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g1 {
    public static final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f9761g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q[] f9765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9766e;

    static {
        int i = s1.b0.f11647a;
        f = Integer.toString(0, 36);
        f9761g = Integer.toString(1, 36);
    }

    public g1(String str, q... qVarArr) {
        s1.d.b(qVarArr.length > 0);
        this.f9763b = str;
        this.f9765d = qVarArr;
        this.f9762a = qVarArr.length;
        int i = m0.i(qVarArr[0].f10023n);
        this.f9764c = i == -1 ? m0.i(qVarArr[0].f10022m) : i;
        String str2 = qVarArr[0].f10015d;
        str2 = (str2 == null || str2.equals("und")) ? "" : str2;
        int i10 = qVarArr[0].f | 16384;
        for (int i11 = 1; i11 < qVarArr.length; i11++) {
            String str3 = qVarArr[i11].f10015d;
            if (!str2.equals((str3 == null || str3.equals("und")) ? "" : str3)) {
                b("languages", qVarArr[0].f10015d, qVarArr[i11].f10015d, i11);
                return;
            } else {
                if (i10 != (qVarArr[i11].f | 16384)) {
                    b("role flags", Integer.toBinaryString(qVarArr[0].f), Integer.toBinaryString(qVarArr[i11].f), i11);
                    return;
                }
            }
        }
    }

    public static void b(String str, String str2, String str3, int i) {
        s1.b.h("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i + ")"));
    }

    public final int a(q qVar) {
        int i = 0;
        while (true) {
            q[] qVarArr = this.f9765d;
            if (i >= qVarArr.length) {
                return -1;
            }
            if (qVar == qVarArr[i]) {
                return i;
            }
            i++;
        }
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        q[] qVarArr = this.f9765d;
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(qVarArr.length);
        int length = qVarArr.length;
        int i = 0;
        while (i < length) {
            q qVar = qVarArr[i];
            List list = qVar.f10026q;
            Bundle bundle2 = new Bundle();
            bundle2.putString(q.R, qVar.f10012a);
            bundle2.putString(q.S, qVar.f10013b);
            String str = q.f10008w0;
            aa.j0 j0Var = qVar.f10014c;
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(j0Var.size());
            int size = j0Var.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = j0Var.get(i10);
                i10++;
                t tVar = (t) obj;
                tVar.getClass();
                Bundle bundle3 = new Bundle();
                q[] qVarArr2 = qVarArr;
                String str2 = tVar.f10061a;
                int i11 = length;
                if (str2 != null) {
                    bundle3.putString(t.f10059c, str2);
                }
                bundle3.putString(t.f10060d, tVar.f10062b);
                arrayList2.add(bundle3);
                qVarArr = qVarArr2;
                length = i11;
            }
            q[] qVarArr3 = qVarArr;
            int i12 = length;
            bundle2.putParcelableArrayList(str, arrayList2);
            bundle2.putString(q.T, qVar.f10015d);
            bundle2.putInt(q.U, qVar.f10016e);
            bundle2.putInt(q.V, qVar.f);
            int i13 = qVar.f10017g;
            if (i13 != q.Q.f10017g) {
                bundle2.putInt(q.f10009x0, i13);
            }
            bundle2.putInt(q.W, qVar.f10018h);
            bundle2.putInt(q.X, qVar.i);
            bundle2.putString(q.Y, qVar.f10020k);
            bundle2.putString(q.Z, qVar.f10022m);
            bundle2.putString(q.f9987a0, qVar.f10023n);
            bundle2.putInt(q.f9988b0, qVar.f10024o);
            for (int i14 = 0; i14 < list.size(); i14++) {
                bundle2.putByteArray(q.f9989c0 + "_" + Integer.toString(i14, 36), (byte[]) list.get(i14));
            }
            bundle2.putParcelable(q.f9990d0, qVar.f10027r);
            bundle2.putLong(q.f9991e0, qVar.f10028s);
            bundle2.putInt(q.f9992f0, qVar.f10030u);
            bundle2.putInt(q.f9993g0, qVar.f10031v);
            bundle2.putInt(q.f10011z0, qVar.f10032w);
            bundle2.putInt(q.A0, qVar.f10033x);
            bundle2.putFloat(q.f9994h0, qVar.f10034y);
            bundle2.putInt(q.f9995i0, qVar.f10035z);
            bundle2.putFloat(q.f9996j0, qVar.A);
            bundle2.putByteArray(q.f9997k0, qVar.B);
            bundle2.putInt(q.l0, qVar.C);
            h hVar = qVar.D;
            if (hVar != null) {
                String str3 = q.f9998m0;
                Bundle bundle4 = new Bundle();
                bundle4.putInt(h.i, hVar.f9773a);
                bundle4.putInt(h.f9768j, hVar.f9774b);
                bundle4.putInt(h.f9769k, hVar.f9775c);
                bundle4.putByteArray(h.f9770l, hVar.f9776d);
                bundle4.putInt(h.f9771m, hVar.f9777e);
                bundle4.putInt(h.f9772n, hVar.f);
                bundle2.putBundle(str3, bundle4);
            }
            bundle2.putInt(q.f10010y0, qVar.E);
            bundle2.putInt(q.f9999n0, qVar.F);
            bundle2.putInt(q.f10000o0, qVar.G);
            bundle2.putInt(q.f10001p0, qVar.H);
            bundle2.putInt(q.f10002q0, qVar.I);
            bundle2.putInt(q.f10003r0, qVar.J);
            bundle2.putInt(q.f10004s0, qVar.K);
            bundle2.putInt(q.f10006u0, qVar.M);
            bundle2.putInt(q.f10007v0, qVar.N);
            bundle2.putInt(q.f10005t0, qVar.O);
            arrayList.add(bundle2);
            i++;
            qVarArr = qVarArr3;
            length = i12;
        }
        bundle.putParcelableArrayList(f, arrayList);
        bundle.putString(f9761g, this.f9763b);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && g1.class == obj.getClass()) {
            g1 g1Var = (g1) obj;
            if (this.f9763b.equals(g1Var.f9763b) && Arrays.equals(this.f9765d, g1Var.f9765d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f9766e == 0) {
            this.f9766e = Arrays.hashCode(this.f9765d) + e6.j.h(527, 31, this.f9763b);
        }
        return this.f9766e;
    }

    public final String toString() {
        return this.f9763b + ": " + Arrays.toString(this.f9765d);
    }
}
