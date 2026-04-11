package q2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.f1;
import g2.d0;
import g2.e;
import g2.g0;
import java.util.ArrayList;
import s2.c0;
import v1.i0;
import v1.j0;
import v1.k0;
import v1.l0;
import v1.p;
import y1.a0;
import y1.d;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends e implements Handler.Callback {
    public final a N;
    public final d0 O;
    public final Handler P;
    public final j3.a Q;
    public u8.a R;
    public boolean S;
    public boolean T;
    public long U;
    public l0 V;
    public long W;

    public b(d0 d0Var, Looper looper) {
        Handler handler;
        super(5);
        this.O = d0Var;
        if (looper == null) {
            handler = null;
        } else {
            int i = a0.f14551a;
            handler = new Handler(looper, this);
        }
        this.P = handler;
        this.N = a.f10356a;
        this.Q = new j3.a(1);
        this.W = -9223372036854775807L;
    }

    @Override // g2.e
    public final int A(p pVar) {
        if (this.N.b(pVar)) {
            return q4.a.d(pVar.O == 0 ? 4 : 2, 0, 0, 0);
        }
        return q4.a.d(0, 0, 0, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C(v1.l0 r6, java.util.ArrayList r7) {
        /*
            r5 = this;
            r0 = 0
        L1:
            v1.k0[] r1 = r6.f12828a
            int r2 = r1.length
            if (r0 >= r2) goto L46
            r2 = r1[r0]
            v1.p r2 = r2.a()
            if (r2 == 0) goto L3e
            q2.a r3 = r5.N
            boolean r4 = r3.b(r2)
            if (r4 == 0) goto L3e
            u8.a r2 = r3.a(r2)
            r1 = r1[r0]
            byte[] r1 = r1.b()
            r1.getClass()
            j3.a r3 = r5.Q
            r3.clear()
            int r4 = r1.length
            r3.ensureSpaceForWrite(r4)
            java.nio.ByteBuffer r4 = r3.data
            r4.put(r1)
            r3.flip()
            v1.l0 r1 = r2.o(r3)
            if (r1 == 0) goto L43
            r5.C(r1, r7)
            goto L43
        L3e:
            r1 = r1[r0]
            r7.add(r1)
        L43:
            int r0 = r0 + 1
            goto L1
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.b.C(v1.l0, java.util.ArrayList):void");
    }

    public final long D(long j4) {
        d.g(j4 != -9223372036854775807L);
        d.g(this.W != -9223372036854775807L);
        return j4 - this.W;
    }

    public final void E(l0 l0Var) {
        d0 d0Var = this.O;
        g0 g0Var = d0Var.f4651v;
        j0 j0Var = g0Var.D0;
        y1.p pVar = g0Var.I;
        i0 i0VarA = j0Var.a();
        int i = 0;
        while (true) {
            k0[] k0VarArr = l0Var.f12828a;
            if (i >= k0VarArr.length) {
                break;
            }
            k0VarArr[i].c(i0VarA);
            i++;
        }
        g0Var.D0 = new j0(i0VarA);
        j0 j0VarP1 = g0Var.p1();
        if (!j0VarP1.equals(g0Var.f4698j0)) {
            g0Var.f4698j0 = j0VarP1;
            pVar.c(14, new f1(12, d0Var));
        }
        pVar.c(28, new f1(13, l0Var));
        pVar.b();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 1) {
            throw new IllegalStateException();
        }
        E((l0) message.obj);
        return true;
    }

    @Override // g2.e
    public final String j() {
        return "MetadataRenderer";
    }

    @Override // g2.e
    public final boolean l() {
        return this.T;
    }

    @Override // g2.e
    public final boolean m() {
        return true;
    }

    @Override // g2.e
    public final void o() {
        this.V = null;
        this.R = null;
        this.W = -9223372036854775807L;
    }

    @Override // g2.e
    public final void q(boolean z10, long j4) {
        this.V = null;
        this.S = false;
        this.T = false;
    }

    @Override // g2.e
    public final void v(p[] pVarArr, long j4, long j7, c0 c0Var) {
        this.R = this.N.a(pVarArr[0]);
        l0 l0Var = this.V;
        if (l0Var != null) {
            long j10 = l0Var.f12829b;
            long j11 = (this.W + j10) - j7;
            if (j10 != j11) {
                l0Var = new l0(j11, l0Var.f12828a);
            }
            this.V = l0Var;
        }
        this.W = j7;
    }

    @Override // g2.e
    public final void x(long j4, long j7) {
        boolean z10 = true;
        while (z10) {
            if (!this.S && this.V == null) {
                j3.a aVar = this.Q;
                aVar.clear();
                l4.c0 c0Var = this.f4659x;
                c0Var.q();
                int iW = w(c0Var, aVar, 0);
                if (iW == -4) {
                    if (aVar.isEndOfStream()) {
                        this.S = true;
                    } else if (aVar.timeUs >= this.G) {
                        aVar.f6587v = this.U;
                        aVar.flip();
                        u8.a aVar2 = this.R;
                        int i = a0.f14551a;
                        l0 l0VarO = aVar2.o(aVar);
                        if (l0VarO != null) {
                            ArrayList arrayList = new ArrayList(l0VarO.f12828a.length);
                            C(l0VarO, arrayList);
                            if (!arrayList.isEmpty()) {
                                this.V = new l0(D(aVar.timeUs), (k0[]) arrayList.toArray(new k0[0]));
                            }
                        }
                    }
                } else if (iW == -5) {
                    p pVar = (p) c0Var.f7706x;
                    pVar.getClass();
                    this.U = pVar.f12951s;
                }
            }
            l0 l0Var = this.V;
            if (l0Var == null || l0Var.f12829b > D(j4)) {
                z10 = false;
            } else {
                l0 l0Var2 = this.V;
                Handler handler = this.P;
                if (handler != null) {
                    handler.obtainMessage(1, l0Var2).sendToTarget();
                } else {
                    E(l0Var2);
                }
                this.V = null;
                z10 = true;
            }
            if (this.S && this.V == null) {
                this.T = true;
            }
        }
    }
}
