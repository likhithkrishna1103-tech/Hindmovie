package q2;

import a2.f0;
import a2.g;
import a2.j0;
import a2.l0;
import a2.o0;
import aa.c1;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Objects;
import k8.z;
import o2.d0;
import p1.m0;
import p1.q;
import r2.h;
import s1.b0;
import t3.i;
import t3.j;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends g implements Handler.Callback {
    public final z M;
    public final DecoderInputBuffer N;
    public a O;
    public final e P;
    public boolean Q;
    public int R;
    public t3.e S;
    public i T;
    public j U;
    public j V;
    public int W;
    public final Handler X;
    public final l0 Y;
    public final h4.z Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f10593a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f10594b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public q f10595c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public long f10596d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public long f10597e0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(l0 l0Var, Looper looper) {
        Handler handler;
        super(3);
        u5.d dVar = e.f10592q;
        this.Y = l0Var;
        if (looper == null) {
            handler = null;
        } else {
            int i = b0.f11647a;
            handler = new Handler(looper, this);
        }
        this.X = handler;
        this.P = dVar;
        this.M = new z(27);
        this.N = new DecoderInputBuffer(1);
        this.Z = new h4.z(1, false);
        this.f10597e0 = -9223372036854775807L;
        this.f10596d0 = -9223372036854775807L;
    }

    @Override // a2.g
    public final int A(q qVar) {
        boolean zEquals = Objects.equals(qVar.f10023n, "application/x-media3-cues");
        String str = qVar.f10023n;
        if (!zEquals) {
            u5.d dVar = (u5.d) this.P;
            dVar.getClass();
            if (!((k8.b0) dVar.f12784v).d(qVar) && !Objects.equals(str, "application/cea-608") && !Objects.equals(str, "application/x-mp4-cea-608") && !Objects.equals(str, "application/cea-708")) {
                return m0.n(str) ? l4.a.g(1, 0, 0, 0) : l4.a.g(0, 0, 0, 0);
            }
        }
        return l4.a.g(qVar.O == 0 ? 4 : 2, 0, 0, 0);
    }

    public final void C() {
        s1.d.f("Legacy decoding is disabled, can't handle " + this.f10595c0.f10023n + " samples (expected application/x-media3-cues).", Objects.equals(this.f10595c0.f10023n, "application/cea-608") || Objects.equals(this.f10595c0.f10023n, "application/x-mp4-cea-608") || Objects.equals(this.f10595c0.f10023n, "application/cea-708"));
    }

    public final long D() {
        if (this.W == -1) {
            return Long.MAX_VALUE;
        }
        this.U.getClass();
        if (this.W >= this.U.j()) {
            return Long.MAX_VALUE;
        }
        return this.U.f(this.W);
    }

    public final long E(long j5) {
        s1.d.g(j5 != -9223372036854775807L);
        return j5 - this.E;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F() {
        /*
            r7 = this;
            r0 = 1
            r7.Q = r0
            p1.q r1 = r7.f10595c0
            r1.getClass()
            q2.e r2 = r7.P
            u5.d r2 = (u5.d) r2
            java.lang.Object r2 = r2.f12784v
            k8.b0 r2 = (k8.b0) r2
            java.lang.String r3 = r1.f10023n
            int r4 = r1.K
            if (r3 == 0) goto L50
            int r5 = r3.hashCode()
            r6 = -1
            switch(r5) {
                case 930165504: goto L34;
                case 1566015601: goto L2b;
                case 1566016562: goto L20;
                default: goto L1e;
            }
        L1e:
            r0 = r6
            goto L3e
        L20:
            java.lang.String r0 = "application/cea-708"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L29
            goto L1e
        L29:
            r0 = 2
            goto L3e
        L2b:
            java.lang.String r5 = "application/cea-608"
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L3e
            goto L1e
        L34:
            java.lang.String r0 = "application/x-mp4-cea-608"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L3d
            goto L1e
        L3d:
            r0 = 0
        L3e:
            switch(r0) {
                case 0: goto L4a;
                case 1: goto L4a;
                case 2: goto L42;
                default: goto L41;
            }
        L41:
            goto L50
        L42:
            u3.f r0 = new u3.f
            java.util.List r1 = r1.f10026q
            r0.<init>(r4, r1)
            goto L6e
        L4a:
            u3.c r0 = new u3.c
            r0.<init>(r3, r4)
            goto L6e
        L50:
            boolean r0 = r2.d(r1)
            if (r0 == 0) goto L76
            t3.m r0 = r2.f(r1)
            q2.b r1 = new q2.b
            java.lang.Class r2 = r0.getClass()
            java.lang.String r2 = r2.getSimpleName()
            java.lang.String r3 = "Decoder"
            java.lang.String r2 = r2.concat(r3)
            r1.<init>(r2, r0)
            r0 = r1
        L6e:
            r7.S = r0
            long r1 = r7.F
            r0.setOutputStartTimeUs(r1)
            return
        L76:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Attempted to create decoder for unsupported MIME type: "
            java.lang.String r1 = l4.a.m(r1, r3)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.f.F():void");
    }

    public final void G(r1.c cVar) {
        c1 c1Var = cVar.f11272a;
        l0 l0Var = this.Y;
        l0Var.f312u.H.e(27, new j0(0, c1Var));
        o0 o0Var = l0Var.f312u;
        o0Var.f362v0 = cVar;
        o0Var.H.e(27, new f0(2, cVar));
    }

    public final void H() {
        this.T = null;
        this.W = -1;
        j jVar = this.U;
        if (jVar != null) {
            jVar.release();
            this.U = null;
        }
        j jVar2 = this.V;
        if (jVar2 != null) {
            jVar2.release();
            this.V = null;
        }
    }

    @Override // a2.g
    public final String g() {
        return "TextRenderer";
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 1) {
            throw new IllegalStateException();
        }
        G((r1.c) message.obj);
        return true;
    }

    @Override // a2.g
    public final boolean l() {
        return this.f10594b0;
    }

    @Override // a2.g
    public final boolean m() {
        q qVar = this.f10595c0;
        if (qVar != null) {
            if (Objects.equals(qVar.f10023n, "application/x-media3-cues")) {
                a aVar = this.O;
                aVar.getClass();
                if (aVar.b(this.f10596d0) == Long.MIN_VALUE) {
                    try {
                        o2.c1 c1Var = this.C;
                        c1Var.getClass();
                        c1Var.b();
                        return true;
                    } catch (IOException unused) {
                        return false;
                    }
                }
            } else {
                if (this.f10594b0) {
                    return false;
                }
                if (this.f10593a0) {
                    j jVar = this.U;
                    long j5 = this.f10596d0;
                    if (jVar == null || jVar.j() <= 0 || jVar.f(jVar.j() - 1) <= j5) {
                        j jVar2 = this.V;
                        long j8 = this.f10596d0;
                        if ((jVar2 == null || jVar2.j() <= 0 || jVar2.f(jVar2.j() - 1) <= j8) && this.T != null) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override // a2.g
    public final void o() {
        this.f10595c0 = null;
        this.f10597e0 = -9223372036854775807L;
        r1.c cVar = new r1.c(E(this.f10596d0), c1.f650y);
        Handler handler = this.X;
        if (handler != null) {
            handler.obtainMessage(1, cVar).sendToTarget();
        } else {
            G(cVar);
        }
        this.f10596d0 = -9223372036854775807L;
        if (this.S != null) {
            H();
            t3.e eVar = this.S;
            eVar.getClass();
            eVar.release();
            this.S = null;
            this.R = 0;
        }
    }

    @Override // a2.g
    public final void q(boolean z2, long j5) {
        this.f10596d0 = j5;
        a aVar = this.O;
        if (aVar != null) {
            aVar.clear();
        }
        r1.c cVar = new r1.c(E(this.f10596d0), c1.f650y);
        Handler handler = this.X;
        if (handler != null) {
            handler.obtainMessage(1, cVar).sendToTarget();
        } else {
            G(cVar);
        }
        this.f10593a0 = false;
        this.f10594b0 = false;
        this.f10597e0 = -9223372036854775807L;
        q qVar = this.f10595c0;
        if (qVar == null || Objects.equals(qVar.f10023n, "application/x-media3-cues")) {
            return;
        }
        if (this.R == 0) {
            H();
            t3.e eVar = this.S;
            eVar.getClass();
            eVar.flush();
            eVar.setOutputStartTimeUs(this.F);
            return;
        }
        H();
        t3.e eVar2 = this.S;
        eVar2.getClass();
        eVar2.release();
        this.S = null;
        this.R = 0;
        F();
    }

    @Override // a2.g
    public final void v(q[] qVarArr, long j5, long j8, d0 d0Var) {
        q qVar = qVarArr[0];
        this.f10595c0 = qVar;
        if (Objects.equals(qVar.f10023n, "application/x-media3-cues")) {
            this.O = this.f10595c0.L == 1 ? new c() : new d(0);
            return;
        }
        C();
        if (this.S != null) {
            this.R = 1;
        } else {
            F();
        }
    }

    @Override // a2.g
    public final void x(long j5, long j8) {
        boolean z2;
        long jF;
        if (this.H) {
            long j10 = this.f10597e0;
            if (j10 != -9223372036854775807L && j5 >= j10) {
                H();
                this.f10594b0 = true;
            }
        }
        if (this.f10594b0) {
            return;
        }
        q qVar = this.f10595c0;
        qVar.getClass();
        boolean zEquals = Objects.equals(qVar.f10023n, "application/x-media3-cues");
        Handler handler = this.X;
        h4.z zVar = this.Z;
        boolean zC = false;
        if (zEquals) {
            this.O.getClass();
            if (!this.f10593a0) {
                DecoderInputBuffer decoderInputBuffer = this.N;
                if (w(zVar, decoderInputBuffer, 0) == -4) {
                    if (decoderInputBuffer.isEndOfStream()) {
                        this.f10593a0 = true;
                    } else {
                        decoderInputBuffer.flip();
                        ByteBuffer byteBuffer = decoderInputBuffer.data;
                        byteBuffer.getClass();
                        long j11 = decoderInputBuffer.timeUs;
                        byte[] bArrArray = byteBuffer.array();
                        int iArrayOffset = byteBuffer.arrayOffset();
                        int iLimit = byteBuffer.limit();
                        this.M.getClass();
                        Parcel parcelObtain = Parcel.obtain();
                        parcelObtain.unmarshall(bArrArray, iArrayOffset, iLimit);
                        parcelObtain.setDataPosition(0);
                        Bundle bundle = parcelObtain.readBundle(Bundle.class.getClassLoader());
                        parcelObtain.recycle();
                        ArrayList parcelableArrayList = bundle.getParcelableArrayList("c");
                        parcelableArrayList.getClass();
                        t3.a aVar = new t3.a(j11, bundle.getLong("d"), s1.d.j(new h(2), parcelableArrayList));
                        decoderInputBuffer.clear();
                        zC = this.O.c(aVar, j5);
                    }
                }
            }
            long jB = this.O.b(this.f10596d0);
            if (jB == Long.MIN_VALUE && this.f10593a0 && !zC) {
                this.f10594b0 = true;
            }
            if (jB != Long.MIN_VALUE && jB <= j5) {
                zC = true;
            }
            if (zC) {
                aa.j0 j0VarA = this.O.a(j5);
                long jD = this.O.d(j5);
                r1.c cVar = new r1.c(E(jD), j0VarA);
                if (handler != null) {
                    handler.obtainMessage(1, cVar).sendToTarget();
                } else {
                    G(cVar);
                }
                this.O.e(jD);
            }
            this.f10596d0 = j5;
            return;
        }
        C();
        this.f10596d0 = j5;
        if (this.V == null) {
            t3.e eVar = this.S;
            eVar.getClass();
            eVar.a(j5);
            try {
                t3.e eVar2 = this.S;
                eVar2.getClass();
                this.V = (j) eVar2.dequeueOutputBuffer();
            } catch (t3.f e10) {
                s1.b.h("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.f10595c0, e10);
                r1.c cVar2 = new r1.c(E(this.f10596d0), c1.f650y);
                if (handler != null) {
                    handler.obtainMessage(1, cVar2).sendToTarget();
                } else {
                    G(cVar2);
                }
                H();
                t3.e eVar3 = this.S;
                eVar3.getClass();
                eVar3.release();
                this.S = null;
                this.R = 0;
                F();
                return;
            }
        }
        if (this.B != 2) {
            return;
        }
        if (this.U != null) {
            long jD2 = D();
            z2 = false;
            while (jD2 <= j5) {
                this.W++;
                jD2 = D();
                z2 = true;
            }
        } else {
            z2 = false;
        }
        j jVar = this.V;
        if (jVar != null) {
            if (jVar.isEndOfStream()) {
                if (!z2 && D() == Long.MAX_VALUE) {
                    if (this.R == 2) {
                        H();
                        t3.e eVar4 = this.S;
                        eVar4.getClass();
                        eVar4.release();
                        this.S = null;
                        this.R = 0;
                        F();
                    } else {
                        H();
                        this.f10594b0 = true;
                    }
                }
            } else if (jVar.timeUs <= j5) {
                j jVar2 = this.U;
                if (jVar2 != null) {
                    jVar2.release();
                }
                this.W = jVar.a(j5);
                this.U = jVar;
                this.V = null;
                z2 = true;
            }
        }
        if (z2) {
            this.U.getClass();
            int iA = this.U.a(j5);
            if (iA == 0 || this.U.j() == 0) {
                jF = this.U.timeUs;
            } else if (iA == -1) {
                j jVar3 = this.U;
                jF = jVar3.f(jVar3.j() - 1);
            } else {
                jF = this.U.f(iA - 1);
            }
            r1.c cVar3 = new r1.c(E(jF), this.U.i(j5));
            if (handler != null) {
                handler.obtainMessage(1, cVar3).sendToTarget();
            } else {
                G(cVar3);
            }
        }
        if (this.R == 2) {
            return;
        }
        while (!this.f10593a0) {
            try {
                i iVar = this.T;
                if (iVar == null) {
                    t3.e eVar5 = this.S;
                    eVar5.getClass();
                    iVar = (i) eVar5.dequeueInputBuffer();
                    if (iVar == null) {
                        return;
                    } else {
                        this.T = iVar;
                    }
                }
                if (this.R == 1) {
                    iVar.setFlags(4);
                    t3.e eVar6 = this.S;
                    eVar6.getClass();
                    eVar6.queueInputBuffer(iVar);
                    this.T = null;
                    this.R = 2;
                    return;
                }
                int iW = w(zVar, iVar, 0);
                if (iW == -4) {
                    if (iVar.isEndOfStream()) {
                        this.f10593a0 = true;
                        this.Q = false;
                    } else {
                        q qVar2 = (q) zVar.f5868w;
                        if (qVar2 == null) {
                            return;
                        }
                        iVar.f12089u = qVar2.f10028s;
                        iVar.flip();
                        this.Q &= !iVar.isKeyFrame();
                    }
                    if (!this.Q) {
                        t3.e eVar7 = this.S;
                        eVar7.getClass();
                        eVar7.queueInputBuffer(iVar);
                        this.T = null;
                    }
                } else if (iW == -3) {
                    return;
                }
            } catch (t3.f e11) {
                s1.b.h("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.f10595c0, e11);
                r1.c cVar4 = new r1.c(E(this.f10596d0), c1.f650y);
                if (handler != null) {
                    handler.obtainMessage(1, cVar4).sendToTarget();
                } else {
                    G(cVar4);
                }
                H();
                t3.e eVar8 = this.S;
                eVar8.getClass();
                eVar8.release();
                this.S = null;
                this.R = 0;
                F();
                return;
            }
        }
    }
}
