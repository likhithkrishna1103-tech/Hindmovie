package v1;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g1 {
    public static final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f12701g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p[] f12705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12706e;

    static {
        int i = y1.a0.f14551a;
        f = Integer.toString(0, 36);
        f12701g = Integer.toString(1, 36);
    }

    public g1(String str, p... pVarArr) {
        y1.d.b(pVarArr.length > 0);
        this.f12703b = str;
        this.f12705d = pVarArr;
        this.f12702a = pVarArr.length;
        int i = m0.i(pVarArr[0].f12946n);
        this.f12704c = i == -1 ? m0.i(pVarArr[0].f12945m) : i;
        String str2 = pVarArr[0].f12938d;
        str2 = (str2 == null || str2.equals("und")) ? "" : str2;
        int i10 = pVarArr[0].f | 16384;
        for (int i11 = 1; i11 < pVarArr.length; i11++) {
            String str3 = pVarArr[i11].f12938d;
            if (!str2.equals((str3 == null || str3.equals("und")) ? "" : str3)) {
                b("languages", pVarArr[0].f12938d, pVarArr[i11].f12938d, i11);
                return;
            } else {
                if (i10 != (pVarArr[i11].f | 16384)) {
                    b("role flags", Integer.toBinaryString(pVarArr[0].f), Integer.toBinaryString(pVarArr[i11].f), i11);
                    return;
                }
            }
        }
    }

    public static void b(String str, String str2, String str3, int i) {
        y1.b.h("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i + ")"));
    }

    public final int a(p pVar) {
        int i = 0;
        while (true) {
            p[] pVarArr = this.f12705d;
            if (i >= pVarArr.length) {
                return -1;
            }
            if (pVar == pVarArr[i]) {
                return i;
            }
            i++;
        }
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        p[] pVarArr = this.f12705d;
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(pVarArr.length);
        int length = pVarArr.length;
        int i = 0;
        while (i < length) {
            p pVar = pVarArr[i];
            List list = pVar.f12949q;
            Bundle bundle2 = new Bundle();
            bundle2.putString(p.R, pVar.f12935a);
            bundle2.putString(p.S, pVar.f12936b);
            String str = p.f12931w0;
            ua.i0 i0Var = pVar.f12937c;
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(i0Var.size());
            int size = i0Var.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = i0Var.get(i10);
                i10++;
                s sVar = (s) obj;
                sVar.getClass();
                Bundle bundle3 = new Bundle();
                p[] pVarArr2 = pVarArr;
                String str2 = sVar.f12986a;
                int i11 = length;
                if (str2 != null) {
                    bundle3.putString(s.f12984c, str2);
                }
                bundle3.putString(s.f12985d, sVar.f12987b);
                arrayList2.add(bundle3);
                pVarArr = pVarArr2;
                length = i11;
            }
            p[] pVarArr3 = pVarArr;
            int i12 = length;
            bundle2.putParcelableArrayList(str, arrayList2);
            bundle2.putString(p.T, pVar.f12938d);
            bundle2.putInt(p.U, pVar.f12939e);
            bundle2.putInt(p.V, pVar.f);
            int i13 = pVar.f12940g;
            if (i13 != p.Q.f12940g) {
                bundle2.putInt(p.f12932x0, i13);
            }
            bundle2.putInt(p.W, pVar.f12941h);
            bundle2.putInt(p.X, pVar.i);
            bundle2.putString(p.Y, pVar.f12943k);
            bundle2.putString(p.Z, pVar.f12945m);
            bundle2.putString(p.f12910a0, pVar.f12946n);
            bundle2.putInt(p.f12911b0, pVar.f12947o);
            for (int i14 = 0; i14 < list.size(); i14++) {
                bundle2.putByteArray(p.f12912c0 + "_" + Integer.toString(i14, 36), (byte[]) list.get(i14));
            }
            bundle2.putParcelable(p.f12913d0, pVar.f12950r);
            bundle2.putLong(p.f12914e0, pVar.f12951s);
            bundle2.putInt(p.f12915f0, pVar.f12953u);
            bundle2.putInt(p.f12916g0, pVar.f12954v);
            bundle2.putInt(p.f12934z0, pVar.f12955w);
            bundle2.putInt(p.A0, pVar.f12956x);
            bundle2.putFloat(p.f12917h0, pVar.f12957y);
            bundle2.putInt(p.f12918i0, pVar.f12958z);
            bundle2.putFloat(p.f12919j0, pVar.A);
            bundle2.putByteArray(p.f12920k0, pVar.B);
            bundle2.putInt(p.f12921l0, pVar.C);
            g gVar = pVar.D;
            if (gVar != null) {
                String str3 = p.f12922m0;
                Bundle bundle4 = new Bundle();
                bundle4.putInt(g.i, gVar.f12684a);
                bundle4.putInt(g.f12679j, gVar.f12685b);
                bundle4.putInt(g.f12680k, gVar.f12686c);
                bundle4.putByteArray(g.f12681l, gVar.f12687d);
                bundle4.putInt(g.f12682m, gVar.f12688e);
                bundle4.putInt(g.f12683n, gVar.f);
                bundle2.putBundle(str3, bundle4);
            }
            bundle2.putInt(p.f12933y0, pVar.E);
            bundle2.putInt(p.f12923n0, pVar.F);
            bundle2.putInt(p.o0, pVar.G);
            bundle2.putInt(p.f12924p0, pVar.H);
            bundle2.putInt(p.f12925q0, pVar.I);
            bundle2.putInt(p.f12926r0, pVar.J);
            bundle2.putInt(p.f12927s0, pVar.K);
            bundle2.putInt(p.f12929u0, pVar.M);
            bundle2.putInt(p.f12930v0, pVar.N);
            bundle2.putInt(p.f12928t0, pVar.O);
            arrayList.add(bundle2);
            i++;
            pVarArr = pVarArr3;
            length = i12;
        }
        bundle.putParcelableArrayList(f, arrayList);
        bundle.putString(f12701g, this.f12703b);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && g1.class == obj.getClass()) {
            g1 g1Var = (g1) obj;
            if (this.f12703b.equals(g1Var.f12703b) && Arrays.equals(this.f12705d, g1Var.f12705d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f12706e == 0) {
            this.f12706e = Arrays.hashCode(this.f12705d) + l0.e.e(527, 31, this.f12703b);
        }
        return this.f12706e;
    }

    public final String toString() {
        return this.f12703b + ": " + Arrays.toString(this.f12705d);
    }
}
