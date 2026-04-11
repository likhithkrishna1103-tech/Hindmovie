package k2;

import a2.f0;
import a2.g;
import a2.l0;
import a2.o0;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.c;
import h4.z;
import java.util.ArrayList;
import o2.d0;
import p1.i0;
import p1.j0;
import p1.k0;
import p1.q;
import s1.b0;
import s1.d;
import s1.p;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends g implements Handler.Callback {
    public final a M;
    public final l0 N;
    public final Handler O;
    public final f3.a P;
    public c Q;
    public boolean R;
    public boolean S;
    public long T;
    public p1.l0 U;
    public long V;

    public b(l0 l0Var, Looper looper) {
        Handler handler;
        super(5);
        this.N = l0Var;
        if (looper == null) {
            handler = null;
        } else {
            int i = b0.f11647a;
            handler = new Handler(looper, this);
        }
        this.O = handler;
        this.M = a.f6974a;
        this.P = new f3.a(1);
        this.V = -9223372036854775807L;
    }

    @Override // a2.g
    public final int A(q qVar) {
        if (this.M.b(qVar)) {
            return l4.a.g(qVar.O == 0 ? 4 : 2, 0, 0, 0);
        }
        return l4.a.g(0, 0, 0, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C(p1.l0 r6, java.util.ArrayList r7) {
        /*
            r5 = this;
            r0 = 0
        L1:
            p1.k0[] r1 = r6.f9896a
            int r2 = r1.length
            if (r0 >= r2) goto L46
            r2 = r1[r0]
            p1.q r2 = r2.b()
            if (r2 == 0) goto L3e
            k2.a r3 = r5.M
            boolean r4 = r3.b(r2)
            if (r4 == 0) goto L3e
            com.bumptech.glide.c r2 = r3.a(r2)
            r1 = r1[r0]
            byte[] r1 = r1.c()
            r1.getClass()
            f3.a r3 = r5.P
            r3.clear()
            int r4 = r1.length
            r3.ensureSpaceForWrite(r4)
            java.nio.ByteBuffer r4 = r3.data
            r4.put(r1)
            r3.flip()
            p1.l0 r1 = r2.h(r3)
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
        throw new UnsupportedOperationException("Method not decompiled: k2.b.C(p1.l0, java.util.ArrayList):void");
    }

    public final long D(long j5) {
        d.g(j5 != -9223372036854775807L);
        d.g(this.V != -9223372036854775807L);
        return j5 - this.V;
    }

    public final void E(p1.l0 l0Var) {
        l0 l0Var2 = this.N;
        o0 o0Var = l0Var2.f312u;
        j0 j0Var = o0Var.C0;
        p pVar = o0Var.H;
        i0 i0VarA = j0Var.a();
        int i = 0;
        while (true) {
            k0[] k0VarArr = l0Var.f9896a;
            if (i >= k0VarArr.length) {
                break;
            }
            k0VarArr[i].a(i0VarA);
            i++;
        }
        o0Var.C0 = new j0(i0VarA);
        j0 j0VarS1 = o0Var.s1();
        if (!j0VarS1.equals(o0Var.f350i0)) {
            o0Var.f350i0 = j0VarS1;
            pVar.c(14, new f0(3, l0Var2));
        }
        pVar.c(28, new f0(4, l0Var));
        pVar.b();
    }

    @Override // a2.g
    public final String g() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 1) {
            throw new IllegalStateException();
        }
        E((p1.l0) message.obj);
        return true;
    }

    @Override // a2.g
    public final boolean l() {
        return this.S;
    }

    @Override // a2.g
    public final boolean m() {
        return true;
    }

    @Override // a2.g
    public final void o() {
        this.U = null;
        this.Q = null;
        this.V = -9223372036854775807L;
    }

    @Override // a2.g
    public final void q(boolean z2, long j5) {
        this.U = null;
        this.R = false;
        this.S = false;
    }

    @Override // a2.g
    public final void v(q[] qVarArr, long j5, long j8, d0 d0Var) {
        this.Q = this.M.a(qVarArr[0]);
        p1.l0 l0Var = this.U;
        if (l0Var != null) {
            long j10 = l0Var.f9897b;
            long j11 = (this.V + j10) - j8;
            if (j10 != j11) {
                l0Var = new p1.l0(j11, l0Var.f9896a);
            }
            this.U = l0Var;
        }
        this.V = j8;
    }

    @Override // a2.g
    public final void x(long j5, long j8) {
        boolean z2 = true;
        while (z2) {
            if (!this.R && this.U == null) {
                f3.a aVar = this.P;
                aVar.clear();
                z zVar = this.f233w;
                zVar.F();
                int iW = w(zVar, aVar, 0);
                if (iW == -4) {
                    if (aVar.isEndOfStream()) {
                        this.R = true;
                    } else if (aVar.timeUs >= this.F) {
                        aVar.f4757u = this.T;
                        aVar.flip();
                        c cVar = this.Q;
                        int i = b0.f11647a;
                        p1.l0 l0VarH = cVar.h(aVar);
                        if (l0VarH != null) {
                            ArrayList arrayList = new ArrayList(l0VarH.f9896a.length);
                            C(l0VarH, arrayList);
                            if (!arrayList.isEmpty()) {
                                this.U = new p1.l0(D(aVar.timeUs), (k0[]) arrayList.toArray(new k0[0]));
                            }
                        }
                    }
                } else if (iW == -5) {
                    q qVar = (q) zVar.f5868w;
                    qVar.getClass();
                    this.T = qVar.f10028s;
                }
            }
            p1.l0 l0Var = this.U;
            if (l0Var == null || l0Var.f9897b > D(j5)) {
                z2 = false;
            } else {
                p1.l0 l0Var2 = this.U;
                Handler handler = this.O;
                if (handler != null) {
                    handler.obtainMessage(1, l0Var2).sendToTarget();
                } else {
                    E(l0Var2);
                }
                this.U = null;
                z2 = true;
            }
            if (this.R && this.U == null) {
                this.S = true;
            }
        }
    }
}
