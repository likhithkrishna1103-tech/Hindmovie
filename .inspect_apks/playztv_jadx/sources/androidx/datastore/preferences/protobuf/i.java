package androidx.datastore.preferences.protobuf;

import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f1067d;

    public static void U(int i) throws b0 {
        if ((i & 3) != 0) {
            throw b0.e();
        }
    }

    public static void V(int i) throws b0 {
        if ((i & 7) != 0) {
            throw b0.e();
        }
    }

    public Object A(b1 b1Var, n nVar) throws b0 {
        h hVar = (h) this.f1067d;
        int iA = hVar.A();
        if (hVar.f1050a >= 100) {
            throw new b0("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iE = hVar.e(iA);
        Object objI = b1Var.i();
        hVar.f1050a++;
        b1Var.g(objI, this, nVar);
        b1Var.c(objI);
        hVar.a(0);
        hVar.f1050a--;
        hVar.d(iE);
        return objI;
    }

    public Object B(b1 b1Var, n nVar) throws a0 {
        S(2);
        return A(b1Var, nVar);
    }

    public int C() throws a0 {
        S(5);
        return ((h) this.f1067d).v();
    }

    public void D(List list) throws b0 {
        int iZ;
        h hVar = (h) this.f1067d;
        if (list instanceof x) {
            throw new ClassCastException();
        }
        int i = this.f1064a & 7;
        if (i == 2) {
            int iA = hVar.A();
            U(iA);
            int iB = hVar.b() + iA;
            do {
                list.add(Integer.valueOf(hVar.v()));
            } while (hVar.b() < iB);
            return;
        }
        if (i != 5) {
            throw b0.b();
        }
        do {
            list.add(Integer.valueOf(hVar.v()));
            if (hVar.c()) {
                return;
            } else {
                iZ = hVar.z();
            }
        } while (iZ == this.f1064a);
        this.f1066c = iZ;
    }

    public long E() throws a0 {
        S(1);
        return ((h) this.f1067d).w();
    }

    public void F(List list) throws b0 {
        int iZ;
        h hVar = (h) this.f1067d;
        if (list instanceof i0) {
            throw new ClassCastException();
        }
        int i = this.f1064a & 7;
        if (i == 1) {
            do {
                list.add(Long.valueOf(hVar.w()));
                if (hVar.c()) {
                    return;
                } else {
                    iZ = hVar.z();
                }
            } while (iZ == this.f1064a);
            this.f1066c = iZ;
            return;
        }
        if (i != 2) {
            throw b0.b();
        }
        int iA = hVar.A();
        V(iA);
        int iB = hVar.b() + iA;
        do {
            list.add(Long.valueOf(hVar.w()));
        } while (hVar.b() < iB);
    }

    public int G() throws a0 {
        S(0);
        return ((h) this.f1067d).x();
    }

    public void H(List list) throws b0 {
        int iZ;
        h hVar = (h) this.f1067d;
        if (list instanceof x) {
            throw new ClassCastException();
        }
        int i = this.f1064a & 7;
        if (i == 0) {
            do {
                list.add(Integer.valueOf(hVar.x()));
                if (hVar.c()) {
                    return;
                } else {
                    iZ = hVar.z();
                }
            } while (iZ == this.f1064a);
            this.f1066c = iZ;
            return;
        }
        if (i != 2) {
            throw b0.b();
        }
        int iB = hVar.b() + hVar.A();
        do {
            list.add(Integer.valueOf(hVar.x()));
        } while (hVar.b() < iB);
        R(iB);
    }

    public long I() throws a0 {
        S(0);
        return ((h) this.f1067d).y();
    }

    public void J(List list) throws b0 {
        int iZ;
        h hVar = (h) this.f1067d;
        if (list instanceof i0) {
            throw new ClassCastException();
        }
        int i = this.f1064a & 7;
        if (i == 0) {
            do {
                list.add(Long.valueOf(hVar.y()));
                if (hVar.c()) {
                    return;
                } else {
                    iZ = hVar.z();
                }
            } while (iZ == this.f1064a);
            this.f1066c = iZ;
            return;
        }
        if (i != 2) {
            throw b0.b();
        }
        int iB = hVar.b() + hVar.A();
        do {
            list.add(Long.valueOf(hVar.y()));
        } while (hVar.b() < iB);
        R(iB);
    }

    public String K() throws a0 {
        S(2);
        h hVar = (h) this.f1067d;
        byte[] bArr = hVar.f1053d;
        int iS = hVar.s();
        if (iS > 0) {
            int i = hVar.f1054e;
            int i10 = hVar.f1055g;
            if (iS <= i - i10) {
                String str = new String(bArr, i10, iS, z.f1147a);
                hVar.f1055g += iS;
                return str;
            }
        }
        if (iS == 0) {
            return "";
        }
        if (iS > hVar.f1054e) {
            return new String(hVar.n(iS), z.f1147a);
        }
        hVar.D(iS);
        String str2 = new String(bArr, hVar.f1055g, iS, z.f1147a);
        hVar.f1055g += iS;
        return str2;
    }

    public void L(List list, boolean z2) throws a0 {
        int iZ;
        int iZ2;
        h hVar = (h) this.f1067d;
        if ((this.f1064a & 7) != 2) {
            throw b0.b();
        }
        if (!(list instanceof e0) || z2) {
            do {
                list.add(z2 ? M() : K());
                if (hVar.c()) {
                    return;
                } else {
                    iZ = hVar.z();
                }
            } while (iZ == this.f1064a);
            this.f1066c = iZ;
            return;
        }
        e0 e0Var = (e0) list;
        do {
            e0Var.m(g());
            if (hVar.c()) {
                return;
            } else {
                iZ2 = hVar.z();
            }
        } while (iZ2 == this.f1064a);
        this.f1066c = iZ2;
    }

    public String M() throws a0 {
        S(2);
        h hVar = (h) this.f1067d;
        byte[] bArrN = hVar.f1053d;
        int iS = hVar.s();
        int i = hVar.f1055g;
        int i10 = hVar.f1054e;
        if (iS <= i10 - i && iS > 0) {
            hVar.f1055g = i + iS;
        } else {
            if (iS == 0) {
                return "";
            }
            i = 0;
            if (iS <= i10) {
                hVar.D(iS);
                hVar.f1055g = iS;
            } else {
                bArrN = hVar.n(iS);
            }
        }
        return v1.f1143a.e(bArrN, i, iS);
    }

    public int N() throws a0 {
        S(0);
        return ((h) this.f1067d).A();
    }

    public void O(List list) throws b0 {
        int iZ;
        h hVar = (h) this.f1067d;
        if (list instanceof x) {
            throw new ClassCastException();
        }
        int i = this.f1064a & 7;
        if (i == 0) {
            do {
                list.add(Integer.valueOf(hVar.A()));
                if (hVar.c()) {
                    return;
                } else {
                    iZ = hVar.z();
                }
            } while (iZ == this.f1064a);
            this.f1066c = iZ;
            return;
        }
        if (i != 2) {
            throw b0.b();
        }
        int iB = hVar.b() + hVar.A();
        do {
            list.add(Integer.valueOf(hVar.A()));
        } while (hVar.b() < iB);
        R(iB);
    }

    public long P() throws a0 {
        S(0);
        return ((h) this.f1067d).B();
    }

    public void Q(List list) throws b0 {
        int iZ;
        h hVar = (h) this.f1067d;
        if (list instanceof i0) {
            throw new ClassCastException();
        }
        int i = this.f1064a & 7;
        if (i == 0) {
            do {
                list.add(Long.valueOf(hVar.B()));
                if (hVar.c()) {
                    return;
                } else {
                    iZ = hVar.z();
                }
            } while (iZ == this.f1064a);
            this.f1066c = iZ;
            return;
        }
        if (i != 2) {
            throw b0.b();
        }
        int iB = hVar.b() + hVar.A();
        do {
            list.add(Long.valueOf(hVar.B()));
        } while (hVar.b() < iB);
        R(iB);
    }

    public void R(int i) throws b0 {
        if (((h) this.f1067d).b() != i) {
            throw b0.f();
        }
    }

    public void S(int i) throws a0 {
        if ((this.f1064a & 7) != i) {
            throw b0.b();
        }
    }

    public boolean T() {
        int i;
        h hVar = (h) this.f1067d;
        if (hVar.c() || (i = this.f1064a) == this.f1065b) {
            return false;
        }
        return hVar.E(i);
    }

    public void a(t4.f fVar) {
        Object[] objArr = (Object[]) this.f1067d;
        int i = this.f1065b;
        objArr[i] = fVar;
        int i10 = this.f1066c & (i + 1);
        this.f1065b = i10;
        int i11 = this.f1064a;
        if (i10 == i11) {
            int length = objArr.length;
            int i12 = length - i11;
            int i13 = length << 1;
            if (i13 < 0) {
                throw new RuntimeException("Max array capacity exceeded");
            }
            Object[] objArr2 = new Object[i13];
            od.h.T(0, i11, length, objArr, objArr2);
            od.h.T(i12, 0, this.f1064a, (Object[]) this.f1067d, objArr2);
            this.f1067d = objArr2;
            this.f1064a = 0;
            this.f1065b = length;
            this.f1066c = i13 - 1;
        }
    }

    public void b() {
        View view = (View) this.f1067d;
        int top = this.f1066c - (view.getTop() - this.f1064a);
        WeakHashMap weakHashMap = q0.o0.f10475a;
        view.offsetTopAndBottom(top);
        view.offsetLeftAndRight(0 - (view.getLeft() - this.f1065b));
    }

    public int c() {
        int i = this.f1066c;
        if (i != 0) {
            this.f1064a = i;
            this.f1066c = 0;
        } else {
            this.f1064a = ((h) this.f1067d).z();
        }
        int i10 = this.f1064a;
        if (i10 == 0 || i10 == this.f1065b) {
            return Integer.MAX_VALUE;
        }
        return i10 >>> 3;
    }

    public int d() {
        return this.f1064a;
    }

    public boolean e() throws a0 {
        S(0);
        return ((h) this.f1067d).f();
    }

    public void f(List list) throws b0 {
        int iZ;
        h hVar = (h) this.f1067d;
        if (list instanceof d) {
            throw new ClassCastException();
        }
        int i = this.f1064a & 7;
        if (i == 0) {
            do {
                list.add(Boolean.valueOf(hVar.f()));
                if (hVar.c()) {
                    return;
                } else {
                    iZ = hVar.z();
                }
            } while (iZ == this.f1064a);
            this.f1066c = iZ;
            return;
        }
        if (i != 2) {
            throw b0.b();
        }
        int iB = hVar.b() + hVar.A();
        do {
            list.add(Boolean.valueOf(hVar.f()));
        } while (hVar.b() < iB);
        R(iB);
    }

    public g g() throws a0 {
        S(2);
        h hVar = (h) this.f1067d;
        byte[] bArr = hVar.f1053d;
        int iS = hVar.s();
        int i = hVar.f1054e;
        int i10 = hVar.f1055g;
        if (iS <= i - i10 && iS > 0) {
            g gVarB = g.b(bArr, i10, iS);
            hVar.f1055g += iS;
            return gVarB;
        }
        if (iS == 0) {
            return g.f1043w;
        }
        byte[] bArrO = hVar.o(iS);
        if (bArrO != null) {
            return g.b(bArrO, 0, bArrO.length);
        }
        int i11 = hVar.f1055g;
        int i12 = hVar.f1054e;
        int length = i12 - i11;
        hVar.i += i12;
        hVar.f1055g = 0;
        hVar.f1054e = 0;
        ArrayList arrayListP = hVar.p(iS - length);
        byte[] bArr2 = new byte[iS];
        System.arraycopy(bArr, i11, bArr2, 0, length);
        int size = arrayListP.size();
        int i13 = 0;
        while (i13 < size) {
            Object obj = arrayListP.get(i13);
            i13++;
            byte[] bArr3 = (byte[]) obj;
            System.arraycopy(bArr3, 0, bArr2, length, bArr3.length);
            length += bArr3.length;
        }
        g gVar = g.f1043w;
        return new g(bArr2);
    }

    public void h(List list) throws a0 {
        int iZ;
        h hVar = (h) this.f1067d;
        if ((this.f1064a & 7) != 2) {
            throw b0.b();
        }
        do {
            list.add(g());
            if (hVar.c()) {
                return;
            } else {
                iZ = hVar.z();
            }
        } while (iZ == this.f1064a);
        this.f1066c = iZ;
    }

    public double i() throws a0 {
        S(1);
        return ((h) this.f1067d).g();
    }

    public void j(List list) throws b0 {
        int iZ;
        h hVar = (h) this.f1067d;
        if (list instanceof l) {
            throw new ClassCastException();
        }
        int i = this.f1064a & 7;
        if (i == 1) {
            do {
                list.add(Double.valueOf(hVar.g()));
                if (hVar.c()) {
                    return;
                } else {
                    iZ = hVar.z();
                }
            } while (iZ == this.f1064a);
            this.f1066c = iZ;
            return;
        }
        if (i != 2) {
            throw b0.b();
        }
        int iA = hVar.A();
        V(iA);
        int iB = hVar.b() + iA;
        do {
            list.add(Double.valueOf(hVar.g()));
        } while (hVar.b() < iB);
    }

    public int k() throws a0 {
        S(0);
        return ((h) this.f1067d).h();
    }

    public void l(List list) throws b0 {
        int iZ;
        h hVar = (h) this.f1067d;
        if (list instanceof x) {
            throw new ClassCastException();
        }
        int i = this.f1064a & 7;
        if (i == 0) {
            do {
                list.add(Integer.valueOf(hVar.h()));
                if (hVar.c()) {
                    return;
                } else {
                    iZ = hVar.z();
                }
            } while (iZ == this.f1064a);
            this.f1066c = iZ;
            return;
        }
        if (i != 2) {
            throw b0.b();
        }
        int iB = hVar.b() + hVar.A();
        do {
            list.add(Integer.valueOf(hVar.h()));
        } while (hVar.b() < iB);
        R(iB);
    }

    public Object m(a2 a2Var, Class cls, n nVar) throws a0 {
        switch (a2Var.ordinal()) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return Double.valueOf(i());
            case 1:
                return Float.valueOf(r());
            case 2:
                return Long.valueOf(y());
            case 3:
                return Long.valueOf(P());
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return Integer.valueOf(w());
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return Long.valueOf(p());
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return Integer.valueOf(n());
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return Boolean.valueOf(e());
            case 8:
                return M();
            case 9:
            default:
                throw new RuntimeException("unsupported field type.");
            case 10:
                S(2);
                return A(y0.f1144c.a(cls), nVar);
            case 11:
                return g();
            case 12:
                return Integer.valueOf(N());
            case 13:
                return Integer.valueOf(k());
            case 14:
                return Integer.valueOf(C());
            case 15:
                return Long.valueOf(E());
            case 16:
                return Integer.valueOf(G());
            case 17:
                return Long.valueOf(I());
        }
    }

    public int n() throws a0 {
        S(5);
        return ((h) this.f1067d).i();
    }

    public void o(List list) throws b0 {
        int iZ;
        h hVar = (h) this.f1067d;
        if (list instanceof x) {
            throw new ClassCastException();
        }
        int i = this.f1064a & 7;
        if (i == 2) {
            int iA = hVar.A();
            U(iA);
            int iB = hVar.b() + iA;
            do {
                list.add(Integer.valueOf(hVar.i()));
            } while (hVar.b() < iB);
            return;
        }
        if (i != 5) {
            throw b0.b();
        }
        do {
            list.add(Integer.valueOf(hVar.i()));
            if (hVar.c()) {
                return;
            } else {
                iZ = hVar.z();
            }
        } while (iZ == this.f1064a);
        this.f1066c = iZ;
    }

    public long p() throws a0 {
        S(1);
        return ((h) this.f1067d).j();
    }

    public void q(List list) throws b0 {
        int iZ;
        h hVar = (h) this.f1067d;
        if (list instanceof i0) {
            throw new ClassCastException();
        }
        int i = this.f1064a & 7;
        if (i == 1) {
            do {
                list.add(Long.valueOf(hVar.j()));
                if (hVar.c()) {
                    return;
                } else {
                    iZ = hVar.z();
                }
            } while (iZ == this.f1064a);
            this.f1066c = iZ;
            return;
        }
        if (i != 2) {
            throw b0.b();
        }
        int iA = hVar.A();
        V(iA);
        int iB = hVar.b() + iA;
        do {
            list.add(Long.valueOf(hVar.j()));
        } while (hVar.b() < iB);
    }

    public float r() throws a0 {
        S(5);
        return ((h) this.f1067d).k();
    }

    public void s(List list) throws b0 {
        int iZ;
        h hVar = (h) this.f1067d;
        if (list instanceof s) {
            throw new ClassCastException();
        }
        int i = this.f1064a & 7;
        if (i == 2) {
            int iA = hVar.A();
            U(iA);
            int iB = hVar.b() + iA;
            do {
                list.add(Float.valueOf(hVar.k()));
            } while (hVar.b() < iB);
            return;
        }
        if (i != 5) {
            throw b0.b();
        }
        do {
            list.add(Float.valueOf(hVar.k()));
            if (hVar.c()) {
                return;
            } else {
                iZ = hVar.z();
            }
        } while (iZ == this.f1064a);
        this.f1066c = iZ;
    }

    public Object t(b1 b1Var, n nVar) {
        int i = this.f1065b;
        this.f1065b = ((this.f1064a >>> 3) << 3) | 4;
        try {
            Object objI = b1Var.i();
            b1Var.g(objI, this, nVar);
            b1Var.c(objI);
            if (this.f1064a == this.f1065b) {
                return objI;
            }
            throw b0.e();
        } finally {
            this.f1065b = i;
        }
    }

    public Object u(b1 b1Var, n nVar) throws a0 {
        S(3);
        return t(b1Var, nVar);
    }

    public void v(List list, b1 b1Var, n nVar) throws a0 {
        int iZ;
        h hVar = (h) this.f1067d;
        int i = this.f1064a;
        if ((i & 7) != 3) {
            throw b0.b();
        }
        do {
            list.add(t(b1Var, nVar));
            if (hVar.c() || this.f1066c != 0) {
                return;
            } else {
                iZ = hVar.z();
            }
        } while (iZ == i);
        this.f1066c = iZ;
    }

    public int w() throws a0 {
        S(0);
        return ((h) this.f1067d).l();
    }

    public void x(List list) throws b0 {
        int iZ;
        h hVar = (h) this.f1067d;
        if (list instanceof x) {
            throw new ClassCastException();
        }
        int i = this.f1064a & 7;
        if (i == 0) {
            do {
                list.add(Integer.valueOf(hVar.l()));
                if (hVar.c()) {
                    return;
                } else {
                    iZ = hVar.z();
                }
            } while (iZ == this.f1064a);
            this.f1066c = iZ;
            return;
        }
        if (i != 2) {
            throw b0.b();
        }
        int iB = hVar.b() + hVar.A();
        do {
            list.add(Integer.valueOf(hVar.l()));
        } while (hVar.b() < iB);
        R(iB);
    }

    public long y() throws a0 {
        S(0);
        return ((h) this.f1067d).m();
    }

    public void z(List list) throws b0 {
        int iZ;
        h hVar = (h) this.f1067d;
        if (list instanceof i0) {
            throw new ClassCastException();
        }
        int i = this.f1064a & 7;
        if (i == 0) {
            do {
                list.add(Long.valueOf(hVar.m()));
                if (hVar.c()) {
                    return;
                } else {
                    iZ = hVar.z();
                }
            } while (iZ == this.f1064a);
            this.f1066c = iZ;
            return;
        }
        if (i != 2) {
            throw b0.b();
        }
        int iB = hVar.b() + hVar.A();
        do {
            list.add(Long.valueOf(hVar.m()));
        } while (hVar.b() < iB);
        R(iB);
    }
}
