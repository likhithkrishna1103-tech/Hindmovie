package u2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import androidx.fragment.app.f1;
import androidx.media3.decoder.DecoderInputBuffer;
import g2.b0;
import g2.d0;
import g2.g0;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Objects;
import l4.c0;
import s2.a1;
import ua.i0;
import ua.z0;
import v1.m0;
import v1.p;
import x3.h;
import x3.i;
import x3.l;
import x3.m;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends g2.e implements Handler.Callback {
    public final x3.a N;
    public final DecoderInputBuffer O;
    public a P;
    public final d Q;
    public boolean R;
    public int S;
    public h T;
    public l U;
    public m V;
    public m W;
    public int X;
    public final Handler Y;
    public final d0 Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final c0 f12071a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f12072b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f12073c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public p f12074d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public long f12075e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public long f12076f0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d0 d0Var, Looper looper) {
        Handler handler;
        super(3);
        m2.e eVar = d.f12070s;
        this.Z = d0Var;
        if (looper == null) {
            handler = null;
        } else {
            int i = a0.f14551a;
            handler = new Handler(looper, this);
        }
        this.Y = handler;
        this.Q = eVar;
        this.N = new x3.a();
        this.O = new DecoderInputBuffer(1);
        this.f12071a0 = new c0(22, false);
        this.f12076f0 = -9223372036854775807L;
        this.f12075e0 = -9223372036854775807L;
    }

    @Override // g2.e
    public final int A(p pVar) {
        boolean zEquals = Objects.equals(pVar.f12946n, "application/x-media3-cues");
        String str = pVar.f12946n;
        if (!zEquals) {
            m2.e eVar = (m2.e) this.Q;
            eVar.getClass();
            if (!((x3.e) eVar.f8050v).e(pVar) && !Objects.equals(str, "application/cea-608") && !Objects.equals(str, "application/x-mp4-cea-608") && !Objects.equals(str, "application/cea-708")) {
                return m0.n(str) ? q4.a.d(1, 0, 0, 0) : q4.a.d(0, 0, 0, 0);
            }
        }
        return q4.a.d(pVar.O == 0 ? 4 : 2, 0, 0, 0);
    }

    public final void C() {
        y1.d.f("Legacy decoding is disabled, can't handle " + this.f12074d0.f12946n + " samples (expected application/x-media3-cues).", Objects.equals(this.f12074d0.f12946n, "application/cea-608") || Objects.equals(this.f12074d0.f12946n, "application/x-mp4-cea-608") || Objects.equals(this.f12074d0.f12946n, "application/cea-708"));
    }

    public final long D() {
        if (this.X == -1) {
            return Long.MAX_VALUE;
        }
        this.V.getClass();
        if (this.X >= this.V.j()) {
            return Long.MAX_VALUE;
        }
        return this.V.e(this.X);
    }

    public final long E(long j4) {
        y1.d.g(j4 != -9223372036854775807L);
        return j4 - this.F;
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
            r7.R = r0
            v1.p r1 = r7.f12074d0
            r1.getClass()
            u2.d r2 = r7.Q
            m2.e r2 = (m2.e) r2
            java.lang.Object r2 = r2.f8050v
            x3.e r2 = (x3.e) r2
            java.lang.String r3 = r1.f12946n
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
            y3.f r0 = new y3.f
            java.util.List r1 = r1.f12949q
            r0.<init>(r4, r1)
            goto L6e
        L4a:
            y3.c r0 = new y3.c
            r0.<init>(r4, r3)
            goto L6e
        L50:
            boolean r0 = r2.e(r1)
            if (r0 == 0) goto L76
            x3.p r0 = r2.c(r1)
            u2.b r1 = new u2.b
            java.lang.Class r2 = r0.getClass()
            java.lang.String r2 = r2.getSimpleName()
            java.lang.String r3 = "Decoder"
            java.lang.String r2 = r2.concat(r3)
            r1.<init>(r2, r0)
            r0 = r1
        L6e:
            r7.T = r0
            long r1 = r7.G
            r0.setOutputStartTimeUs(r1)
            return
        L76:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Attempted to create decoder for unsupported MIME type: "
            java.lang.String r1 = q4.a.n(r1, r3)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.e.F():void");
    }

    public final void G(x1.c cVar) {
        z0 z0Var = cVar.f14268a;
        d0 d0Var = this.Z;
        d0Var.f4651v.I.e(27, new b0(0, z0Var));
        g0 g0Var = d0Var.f4651v;
        g0Var.f4710w0 = cVar;
        g0Var.I.e(27, new f1(11, cVar));
    }

    public final void H() {
        this.U = null;
        this.X = -1;
        m mVar = this.V;
        if (mVar != null) {
            mVar.release();
            this.V = null;
        }
        m mVar2 = this.W;
        if (mVar2 != null) {
            mVar2.release();
            this.W = null;
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 1) {
            throw new IllegalStateException();
        }
        G((x1.c) message.obj);
        return true;
    }

    @Override // g2.e
    public final String j() {
        return "TextRenderer";
    }

    @Override // g2.e
    public final boolean l() {
        return this.f12073c0;
    }

    @Override // g2.e
    public final boolean m() {
        p pVar = this.f12074d0;
        if (pVar != null) {
            if (Objects.equals(pVar.f12946n, "application/x-media3-cues")) {
                a aVar = this.P;
                aVar.getClass();
                if (aVar.b(this.f12075e0) == Long.MIN_VALUE) {
                    try {
                        a1 a1Var = this.D;
                        a1Var.getClass();
                        a1Var.c();
                        return true;
                    } catch (IOException unused) {
                        return false;
                    }
                }
            } else {
                if (this.f12073c0) {
                    return false;
                }
                if (this.f12072b0) {
                    m mVar = this.V;
                    long j4 = this.f12075e0;
                    if (mVar == null || mVar.j() <= 0 || mVar.e(mVar.j() - 1) <= j4) {
                        m mVar2 = this.W;
                        long j7 = this.f12075e0;
                        if ((mVar2 == null || mVar2.j() <= 0 || mVar2.e(mVar2.j() - 1) <= j7) && this.U != null) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override // g2.e
    public final void o() {
        this.f12074d0 = null;
        this.f12076f0 = -9223372036854775807L;
        x1.c cVar = new x1.c(E(this.f12075e0), z0.f12413z);
        Handler handler = this.Y;
        if (handler != null) {
            handler.obtainMessage(1, cVar).sendToTarget();
        } else {
            G(cVar);
        }
        this.f12075e0 = -9223372036854775807L;
        if (this.T != null) {
            H();
            h hVar = this.T;
            hVar.getClass();
            hVar.release();
            this.T = null;
            this.S = 0;
        }
    }

    @Override // g2.e
    public final void q(boolean z10, long j4) {
        this.f12075e0 = j4;
        a aVar = this.P;
        if (aVar != null) {
            aVar.clear();
        }
        x1.c cVar = new x1.c(E(this.f12075e0), z0.f12413z);
        Handler handler = this.Y;
        if (handler != null) {
            handler.obtainMessage(1, cVar).sendToTarget();
        } else {
            G(cVar);
        }
        this.f12072b0 = false;
        this.f12073c0 = false;
        this.f12076f0 = -9223372036854775807L;
        p pVar = this.f12074d0;
        if (pVar == null || Objects.equals(pVar.f12946n, "application/x-media3-cues")) {
            return;
        }
        if (this.S == 0) {
            H();
            h hVar = this.T;
            hVar.getClass();
            hVar.flush();
            hVar.setOutputStartTimeUs(this.G);
            return;
        }
        H();
        h hVar2 = this.T;
        hVar2.getClass();
        hVar2.release();
        this.T = null;
        this.S = 0;
        F();
    }

    @Override // g2.e
    public final void v(p[] pVarArr, long j4, long j7, s2.c0 c0Var) {
        p pVar = pVarArr[0];
        this.f12074d0 = pVar;
        if (Objects.equals(pVar.f12946n, "application/x-media3-cues")) {
            this.P = this.f12074d0.L == 1 ? new c() : new m6.c(2);
            return;
        }
        C();
        if (this.T != null) {
            this.S = 1;
        } else {
            F();
        }
    }

    @Override // g2.e
    public final void x(long j4, long j7) {
        boolean z10;
        long jE;
        if (this.I) {
            long j10 = this.f12076f0;
            if (j10 != -9223372036854775807L && j4 >= j10) {
                H();
                this.f12073c0 = true;
            }
        }
        if (this.f12073c0) {
            return;
        }
        p pVar = this.f12074d0;
        pVar.getClass();
        boolean zEquals = Objects.equals(pVar.f12946n, "application/x-media3-cues");
        Handler handler = this.Y;
        c0 c0Var = this.f12071a0;
        boolean zD = false;
        if (zEquals) {
            this.P.getClass();
            if (!this.f12072b0) {
                DecoderInputBuffer decoderInputBuffer = this.O;
                if (w(c0Var, decoderInputBuffer, 0) == -4) {
                    if (decoderInputBuffer.isEndOfStream()) {
                        this.f12072b0 = true;
                    } else {
                        decoderInputBuffer.flip();
                        ByteBuffer byteBuffer = decoderInputBuffer.data;
                        byteBuffer.getClass();
                        long j11 = decoderInputBuffer.timeUs;
                        byte[] bArrArray = byteBuffer.array();
                        int iArrayOffset = byteBuffer.arrayOffset();
                        int iLimit = byteBuffer.limit();
                        this.N.getClass();
                        Parcel parcelObtain = Parcel.obtain();
                        parcelObtain.unmarshall(bArrArray, iArrayOffset, iLimit);
                        parcelObtain.setDataPosition(0);
                        Bundle bundle = parcelObtain.readBundle(Bundle.class.getClassLoader());
                        parcelObtain.recycle();
                        ArrayList parcelableArrayList = bundle.getParcelableArrayList("c");
                        parcelableArrayList.getClass();
                        x3.c cVar = new x3.c(j11, bundle.getLong("d"), y1.d.j(new v1.b0(13), parcelableArrayList));
                        decoderInputBuffer.clear();
                        zD = this.P.d(cVar, j4);
                    }
                }
            }
            long jB = this.P.b(this.f12075e0);
            if (jB == Long.MIN_VALUE && this.f12072b0 && !zD) {
                this.f12073c0 = true;
            }
            if (jB != Long.MIN_VALUE && jB <= j4) {
                zD = true;
            }
            if (zD) {
                i0 i0VarA = this.P.a(j4);
                long jC = this.P.c(j4);
                x1.c cVar2 = new x1.c(E(jC), i0VarA);
                if (handler != null) {
                    handler.obtainMessage(1, cVar2).sendToTarget();
                } else {
                    G(cVar2);
                }
                this.P.e(jC);
            }
            this.f12075e0 = j4;
            return;
        }
        C();
        this.f12075e0 = j4;
        if (this.W == null) {
            h hVar = this.T;
            hVar.getClass();
            hVar.a(j4);
            try {
                h hVar2 = this.T;
                hVar2.getClass();
                this.W = (m) hVar2.dequeueOutputBuffer();
            } catch (i e9) {
                y1.b.h("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.f12074d0, e9);
                x1.c cVar3 = new x1.c(E(this.f12075e0), z0.f12413z);
                if (handler != null) {
                    handler.obtainMessage(1, cVar3).sendToTarget();
                } else {
                    G(cVar3);
                }
                H();
                h hVar3 = this.T;
                hVar3.getClass();
                hVar3.release();
                this.T = null;
                this.S = 0;
                F();
                return;
            }
        }
        if (this.C != 2) {
            return;
        }
        if (this.V != null) {
            long jD = D();
            z10 = false;
            while (jD <= j4) {
                this.X++;
                jD = D();
                z10 = true;
            }
        } else {
            z10 = false;
        }
        m mVar = this.W;
        if (mVar != null) {
            if (mVar.isEndOfStream()) {
                if (!z10 && D() == Long.MAX_VALUE) {
                    if (this.S == 2) {
                        H();
                        h hVar4 = this.T;
                        hVar4.getClass();
                        hVar4.release();
                        this.T = null;
                        this.S = 0;
                        F();
                    } else {
                        H();
                        this.f12073c0 = true;
                    }
                }
            } else if (mVar.timeUs <= j4) {
                m mVar2 = this.V;
                if (mVar2 != null) {
                    mVar2.release();
                }
                this.X = mVar.a(j4);
                this.V = mVar;
                this.W = null;
                z10 = true;
            }
        }
        if (z10) {
            this.V.getClass();
            int iA = this.V.a(j4);
            if (iA == 0 || this.V.j() == 0) {
                jE = this.V.timeUs;
            } else if (iA == -1) {
                m mVar3 = this.V;
                jE = mVar3.e(mVar3.j() - 1);
            } else {
                jE = this.V.e(iA - 1);
            }
            x1.c cVar4 = new x1.c(E(jE), this.V.i(j4));
            if (handler != null) {
                handler.obtainMessage(1, cVar4).sendToTarget();
            } else {
                G(cVar4);
            }
        }
        if (this.S == 2) {
            return;
        }
        while (!this.f12072b0) {
            try {
                l lVar = this.U;
                if (lVar == null) {
                    h hVar5 = this.T;
                    hVar5.getClass();
                    lVar = (l) hVar5.dequeueInputBuffer();
                    if (lVar == null) {
                        return;
                    } else {
                        this.U = lVar;
                    }
                }
                if (this.S == 1) {
                    lVar.setFlags(4);
                    h hVar6 = this.T;
                    hVar6.getClass();
                    hVar6.queueInputBuffer(lVar);
                    this.U = null;
                    this.S = 2;
                    return;
                }
                int iW = w(c0Var, lVar, 0);
                if (iW == -4) {
                    if (lVar.isEndOfStream()) {
                        this.f12072b0 = true;
                        this.R = false;
                    } else {
                        p pVar2 = (p) c0Var.f7706x;
                        if (pVar2 == null) {
                            return;
                        }
                        lVar.f14310v = pVar2.f12951s;
                        lVar.flip();
                        this.R &= !lVar.isKeyFrame();
                    }
                    if (!this.R) {
                        h hVar7 = this.T;
                        hVar7.getClass();
                        hVar7.queueInputBuffer(lVar);
                        this.U = null;
                    }
                } else if (iW == -3) {
                    return;
                }
            } catch (i e10) {
                y1.b.h("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.f12074d0, e10);
                x1.c cVar5 = new x1.c(E(this.f12075e0), z0.f12413z);
                if (handler != null) {
                    handler.obtainMessage(1, cVar5).sendToTarget();
                } else {
                    G(cVar5);
                }
                H();
                h hVar8 = this.T;
                hVar8.getClass();
                hVar8.release();
                this.T = null;
                this.S = 0;
                F();
                return;
            }
        }
    }
}
