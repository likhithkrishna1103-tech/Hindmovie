package androidx.datastore.preferences.protobuf;

import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.charset.Charset;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f736d;

    public k(View view) {
        this.f736d = view;
    }

    public void a() {
        View view = (View) this.f736d;
        int top = this.f735c - (view.getTop() - this.f733a);
        WeakHashMap weakHashMap = t0.m0.f11777a;
        view.offsetTopAndBottom(top);
        view.offsetLeftAndRight(0 - (view.getLeft() - this.f734b));
    }

    public int b() {
        int i = this.f735c;
        if (i != 0) {
            this.f733a = i;
            this.f735c = 0;
        } else {
            this.f733a = ((j) this.f736d).u();
        }
        int i10 = this.f733a;
        if (i10 == 0 || i10 == this.f734b) {
            return Integer.MAX_VALUE;
        }
        return i10 >>> 3;
    }

    public void c(Object obj, u0 u0Var, n nVar) {
        int i = this.f734b;
        this.f734b = ((this.f733a >>> 3) << 3) | 4;
        try {
            u0Var.g(obj, this, nVar);
            if (this.f733a == this.f734b) {
            } else {
                throw new z("Failed to parse the message.");
            }
        } finally {
            this.f734b = i;
        }
    }

    public void d(Object obj, u0 u0Var, n nVar) throws z {
        j jVar = (j) this.f736d;
        int iV = jVar.v();
        if (jVar.f729a >= 100) {
            throw new z("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iE = jVar.e(iV);
        jVar.f729a++;
        u0Var.g(obj, this, nVar);
        jVar.a(0);
        jVar.f729a--;
        jVar.d(iE);
    }

    public void e(w wVar) throws z {
        int iU;
        j jVar = (j) this.f736d;
        int i = this.f733a & 7;
        if (i == 0) {
            do {
                ((s0) wVar).add(Boolean.valueOf(jVar.f()));
                if (jVar.c()) {
                    return;
                } else {
                    iU = jVar.u();
                }
            } while (iU == this.f733a);
            this.f735c = iU;
            return;
        }
        if (i != 2) {
            throw z.b();
        }
        int iB = jVar.b() + jVar.v();
        do {
            ((s0) wVar).add(Boolean.valueOf(jVar.f()));
        } while (jVar.b() < iB);
        w(iB);
    }

    public g f() throws y {
        x(2);
        return ((j) this.f736d).g();
    }

    public void g(w wVar) throws y {
        int iU;
        j jVar = (j) this.f736d;
        if ((this.f733a & 7) != 2) {
            throw z.b();
        }
        do {
            ((s0) wVar).add(f());
            if (jVar.c()) {
                return;
            } else {
                iU = jVar.u();
            }
        } while (iU == this.f733a);
        this.f735c = iU;
    }

    public void h(w wVar) throws z {
        int iU;
        j jVar = (j) this.f736d;
        int i = this.f733a & 7;
        if (i == 1) {
            do {
                ((s0) wVar).add(Double.valueOf(jVar.h()));
                if (jVar.c()) {
                    return;
                } else {
                    iU = jVar.u();
                }
            } while (iU == this.f733a);
            this.f735c = iU;
            return;
        }
        if (i != 2) {
            throw z.b();
        }
        int iV = jVar.v();
        if ((iV & 7) != 0) {
            throw new z("Failed to parse the message.");
        }
        int iB = jVar.b() + iV;
        do {
            ((s0) wVar).add(Double.valueOf(jVar.h()));
        } while (jVar.b() < iB);
    }

    public void i(w wVar) throws z {
        int iU;
        j jVar = (j) this.f736d;
        int i = this.f733a & 7;
        if (i == 0) {
            do {
                ((s0) wVar).add(Integer.valueOf(jVar.i()));
                if (jVar.c()) {
                    return;
                } else {
                    iU = jVar.u();
                }
            } while (iU == this.f733a);
            this.f735c = iU;
            return;
        }
        if (i != 2) {
            throw z.b();
        }
        int iB = jVar.b() + jVar.v();
        do {
            ((s0) wVar).add(Integer.valueOf(jVar.i()));
        } while (jVar.b() < iB);
        w(iB);
    }

    public Object j(p1 p1Var, Class cls, n nVar) throws z {
        j jVar = (j) this.f736d;
        switch (p1Var.ordinal()) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                x(1);
                return Double.valueOf(jVar.h());
            case 1:
                x(5);
                return Float.valueOf(jVar.l());
            case 2:
                x(0);
                return Long.valueOf(jVar.n());
            case 3:
                x(0);
                return Long.valueOf(jVar.w());
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                x(0);
                return Integer.valueOf(jVar.m());
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                x(1);
                return Long.valueOf(jVar.k());
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                x(5);
                return Integer.valueOf(jVar.j());
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                x(0);
                return Boolean.valueOf(jVar.f());
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                x(2);
                return jVar.t();
            case 9:
            default:
                throw new IllegalArgumentException("unsupported field type.");
            case 10:
                x(2);
                u0 u0VarA = r0.f786c.a(cls);
                v vVarI = u0VarA.i();
                d(vVarI, u0VarA, nVar);
                u0VarA.d(vVarI);
                return vVarI;
            case 11:
                return f();
            case 12:
                x(0);
                return Integer.valueOf(jVar.v());
            case 13:
                x(0);
                return Integer.valueOf(jVar.i());
            case 14:
                x(5);
                return Integer.valueOf(jVar.o());
            case 15:
                x(1);
                return Long.valueOf(jVar.p());
            case 16:
                x(0);
                return Integer.valueOf(jVar.q());
            case 17:
                x(0);
                return Long.valueOf(jVar.r());
        }
    }

    public void k(w wVar) throws z {
        int iU;
        j jVar = (j) this.f736d;
        int i = this.f733a & 7;
        if (i == 2) {
            int iV = jVar.v();
            if ((iV & 3) != 0) {
                throw new z("Failed to parse the message.");
            }
            int iB = jVar.b() + iV;
            do {
                ((s0) wVar).add(Integer.valueOf(jVar.j()));
            } while (jVar.b() < iB);
            return;
        }
        if (i != 5) {
            throw z.b();
        }
        do {
            ((s0) wVar).add(Integer.valueOf(jVar.j()));
            if (jVar.c()) {
                return;
            } else {
                iU = jVar.u();
            }
        } while (iU == this.f733a);
        this.f735c = iU;
    }

    public void l(w wVar) throws z {
        int iU;
        j jVar = (j) this.f736d;
        int i = this.f733a & 7;
        if (i == 1) {
            do {
                ((s0) wVar).add(Long.valueOf(jVar.k()));
                if (jVar.c()) {
                    return;
                } else {
                    iU = jVar.u();
                }
            } while (iU == this.f733a);
            this.f735c = iU;
            return;
        }
        if (i != 2) {
            throw z.b();
        }
        int iV = jVar.v();
        if ((iV & 7) != 0) {
            throw new z("Failed to parse the message.");
        }
        int iB = jVar.b() + iV;
        do {
            ((s0) wVar).add(Long.valueOf(jVar.k()));
        } while (jVar.b() < iB);
    }

    public void m(w wVar) throws z {
        int iU;
        j jVar = (j) this.f736d;
        int i = this.f733a & 7;
        if (i == 2) {
            int iV = jVar.v();
            if ((iV & 3) != 0) {
                throw new z("Failed to parse the message.");
            }
            int iB = jVar.b() + iV;
            do {
                ((s0) wVar).add(Float.valueOf(jVar.l()));
            } while (jVar.b() < iB);
            return;
        }
        if (i != 5) {
            throw z.b();
        }
        do {
            ((s0) wVar).add(Float.valueOf(jVar.l()));
            if (jVar.c()) {
                return;
            } else {
                iU = jVar.u();
            }
        } while (iU == this.f733a);
        this.f735c = iU;
    }

    public void n(w wVar) throws z {
        int iU;
        j jVar = (j) this.f736d;
        int i = this.f733a & 7;
        if (i == 0) {
            do {
                ((s0) wVar).add(Integer.valueOf(jVar.m()));
                if (jVar.c()) {
                    return;
                } else {
                    iU = jVar.u();
                }
            } while (iU == this.f733a);
            this.f735c = iU;
            return;
        }
        if (i != 2) {
            throw z.b();
        }
        int iB = jVar.b() + jVar.v();
        do {
            ((s0) wVar).add(Integer.valueOf(jVar.m()));
        } while (jVar.b() < iB);
        w(iB);
    }

    public void o(w wVar) throws z {
        int iU;
        j jVar = (j) this.f736d;
        int i = this.f733a & 7;
        if (i == 0) {
            do {
                ((s0) wVar).add(Long.valueOf(jVar.n()));
                if (jVar.c()) {
                    return;
                } else {
                    iU = jVar.u();
                }
            } while (iU == this.f733a);
            this.f735c = iU;
            return;
        }
        if (i != 2) {
            throw z.b();
        }
        int iB = jVar.b() + jVar.v();
        do {
            ((s0) wVar).add(Long.valueOf(jVar.n()));
        } while (jVar.b() < iB);
        w(iB);
    }

    public void p(w wVar) throws z {
        int iU;
        j jVar = (j) this.f736d;
        int i = this.f733a & 7;
        if (i == 2) {
            int iV = jVar.v();
            if ((iV & 3) != 0) {
                throw new z("Failed to parse the message.");
            }
            int iB = jVar.b() + iV;
            do {
                ((s0) wVar).add(Integer.valueOf(jVar.o()));
            } while (jVar.b() < iB);
            return;
        }
        if (i != 5) {
            throw z.b();
        }
        do {
            ((s0) wVar).add(Integer.valueOf(jVar.o()));
            if (jVar.c()) {
                return;
            } else {
                iU = jVar.u();
            }
        } while (iU == this.f733a);
        this.f735c = iU;
    }

    public void q(w wVar) throws z {
        int iU;
        j jVar = (j) this.f736d;
        int i = this.f733a & 7;
        if (i == 1) {
            do {
                ((s0) wVar).add(Long.valueOf(jVar.p()));
                if (jVar.c()) {
                    return;
                } else {
                    iU = jVar.u();
                }
            } while (iU == this.f733a);
            this.f735c = iU;
            return;
        }
        if (i != 2) {
            throw z.b();
        }
        int iV = jVar.v();
        if ((iV & 7) != 0) {
            throw new z("Failed to parse the message.");
        }
        int iB = jVar.b() + iV;
        do {
            ((s0) wVar).add(Long.valueOf(jVar.p()));
        } while (jVar.b() < iB);
    }

    public void r(w wVar) throws z {
        int iU;
        j jVar = (j) this.f736d;
        int i = this.f733a & 7;
        if (i == 0) {
            do {
                ((s0) wVar).add(Integer.valueOf(jVar.q()));
                if (jVar.c()) {
                    return;
                } else {
                    iU = jVar.u();
                }
            } while (iU == this.f733a);
            this.f735c = iU;
            return;
        }
        if (i != 2) {
            throw z.b();
        }
        int iB = jVar.b() + jVar.v();
        do {
            ((s0) wVar).add(Integer.valueOf(jVar.q()));
        } while (jVar.b() < iB);
        w(iB);
    }

    public void s(w wVar) throws z {
        int iU;
        j jVar = (j) this.f736d;
        int i = this.f733a & 7;
        if (i == 0) {
            do {
                ((s0) wVar).add(Long.valueOf(jVar.r()));
                if (jVar.c()) {
                    return;
                } else {
                    iU = jVar.u();
                }
            } while (iU == this.f733a);
            this.f735c = iU;
            return;
        }
        if (i != 2) {
            throw z.b();
        }
        int iB = jVar.b() + jVar.v();
        do {
            ((s0) wVar).add(Long.valueOf(jVar.r()));
        } while (jVar.b() < iB);
        w(iB);
    }

    public void t(w wVar, boolean z10) throws y {
        String strS;
        int iU;
        j jVar = (j) this.f736d;
        if ((this.f733a & 7) != 2) {
            throw z.b();
        }
        do {
            if (z10) {
                x(2);
                strS = jVar.t();
            } else {
                x(2);
                strS = jVar.s();
            }
            ((s0) wVar).add(strS);
            if (jVar.c()) {
                return;
            } else {
                iU = jVar.u();
            }
        } while (iU == this.f733a);
        this.f735c = iU;
    }

    public void u(w wVar) throws z {
        int iU;
        j jVar = (j) this.f736d;
        int i = this.f733a & 7;
        if (i == 0) {
            do {
                ((s0) wVar).add(Integer.valueOf(jVar.v()));
                if (jVar.c()) {
                    return;
                } else {
                    iU = jVar.u();
                }
            } while (iU == this.f733a);
            this.f735c = iU;
            return;
        }
        if (i != 2) {
            throw z.b();
        }
        int iB = jVar.b() + jVar.v();
        do {
            ((s0) wVar).add(Integer.valueOf(jVar.v()));
        } while (jVar.b() < iB);
        w(iB);
    }

    public void v(w wVar) throws z {
        int iU;
        j jVar = (j) this.f736d;
        int i = this.f733a & 7;
        if (i == 0) {
            do {
                ((s0) wVar).add(Long.valueOf(jVar.w()));
                if (jVar.c()) {
                    return;
                } else {
                    iU = jVar.u();
                }
            } while (iU == this.f733a);
            this.f735c = iU;
            return;
        }
        if (i != 2) {
            throw z.b();
        }
        int iB = jVar.b() + jVar.v();
        do {
            ((s0) wVar).add(Long.valueOf(jVar.w()));
        } while (jVar.b() < iB);
        w(iB);
    }

    public void w(int i) throws z {
        if (((j) this.f736d).b() != i) {
            throw z.e();
        }
    }

    public void x(int i) throws y {
        if ((this.f733a & 7) != i) {
            throw z.b();
        }
    }

    public boolean y() {
        int i;
        j jVar = (j) this.f736d;
        if (jVar.c() || (i = this.f733a) == this.f734b) {
            return false;
        }
        return jVar.x(i);
    }

    public k(j jVar) {
        this.f735c = 0;
        Charset charset = x.f808a;
        this.f736d = jVar;
        jVar.f730b = this;
    }
}
