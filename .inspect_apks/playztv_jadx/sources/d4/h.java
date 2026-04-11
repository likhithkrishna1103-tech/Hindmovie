package d4;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Collections;
import java.util.List;
import p1.m0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3883e;
    public final Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f3884g;

    public h(List list) {
        this.f3879a = 0;
        this.f = list;
        this.f3884g = new w2.h0[list.size()];
        this.f3881c = -9223372036854775807L;
    }

    @Override // d4.i
    public final void a() {
        switch (this.f3879a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f3880b = false;
                this.f3881c = -9223372036854775807L;
                break;
            default:
                this.f3880b = false;
                this.f3881c = -9223372036854775807L;
                break;
        }
    }

    @Override // d4.i
    public final void d(s1.u uVar) {
        boolean z2;
        boolean z10;
        switch (this.f3879a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (this.f3880b) {
                    if (this.f3882d == 2) {
                        if (uVar.a() == 0) {
                            z10 = false;
                        } else {
                            if (uVar.x() != 32) {
                                this.f3880b = false;
                            }
                            this.f3882d--;
                            z10 = this.f3880b;
                        }
                        if (!z10) {
                        }
                    }
                    if (this.f3882d == 1) {
                        if (uVar.a() == 0) {
                            z2 = false;
                        } else {
                            if (uVar.x() != 0) {
                                this.f3880b = false;
                            }
                            this.f3882d--;
                            z2 = this.f3880b;
                        }
                        if (!z2) {
                        }
                    }
                    int i = uVar.f11710b;
                    int iA = uVar.a();
                    for (w2.h0 h0Var : (w2.h0[]) this.f3884g) {
                        uVar.J(i);
                        h0Var.f(iA, uVar);
                    }
                    this.f3883e += iA;
                }
                break;
            default:
                s1.u uVar2 = (s1.u) this.f;
                s1.d.h((w2.h0) this.f3884g);
                if (this.f3880b) {
                    int iA2 = uVar.a();
                    int i10 = this.f3883e;
                    if (i10 < 10) {
                        int iMin = Math.min(iA2, 10 - i10);
                        System.arraycopy(uVar.f11709a, uVar.f11710b, uVar2.f11709a, this.f3883e, iMin);
                        if (this.f3883e + iMin == 10) {
                            uVar2.J(0);
                            if (73 == uVar2.x() && 68 == uVar2.x() && 51 == uVar2.x()) {
                                uVar2.K(3);
                                this.f3882d = uVar2.w() + 10;
                            } else {
                                s1.b.p("Id3Reader", "Discarding invalid ID3 tag");
                                this.f3880b = false;
                            }
                        }
                    }
                    int iMin2 = Math.min(iA2, this.f3882d - this.f3883e);
                    ((w2.h0) this.f3884g).f(iMin2, uVar);
                    this.f3883e += iMin2;
                    break;
                }
                break;
        }
    }

    @Override // d4.i
    public final void e(boolean z2) {
        int i;
        switch (this.f3879a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (this.f3880b) {
                    s1.d.g(this.f3881c != -9223372036854775807L);
                    for (w2.h0 h0Var : (w2.h0[]) this.f3884g) {
                        h0Var.a(this.f3881c, 1, this.f3883e, 0, null);
                    }
                    this.f3880b = false;
                }
                break;
            default:
                s1.d.h((w2.h0) this.f3884g);
                if (this.f3880b && (i = this.f3882d) != 0 && this.f3883e == i) {
                    s1.d.g(this.f3881c != -9223372036854775807L);
                    ((w2.h0) this.f3884g).a(this.f3881c, 1, this.f3882d, 0, null);
                    this.f3880b = false;
                    break;
                }
                break;
        }
    }

    @Override // d4.i
    public final void f(int i, long j5) {
        switch (this.f3879a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if ((i & 4) != 0) {
                    this.f3880b = true;
                    this.f3881c = j5;
                    this.f3883e = 0;
                    this.f3882d = 2;
                    break;
                }
                break;
            default:
                if ((i & 4) != 0) {
                    this.f3880b = true;
                    this.f3881c = j5;
                    this.f3882d = 0;
                    this.f3883e = 0;
                    break;
                }
                break;
        }
    }

    @Override // d4.i
    public final void g(w2.q qVar, h0 h0Var) {
        switch (this.f3879a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                w2.h0[] h0VarArr = (w2.h0[]) this.f3884g;
                for (int i = 0; i < h0VarArr.length; i++) {
                    g0 g0Var = (g0) ((List) this.f).get(i);
                    h0Var.a();
                    h0Var.b();
                    w2.h0 h0VarQ = qVar.q(h0Var.f3888d, 3);
                    p1.p pVar = new p1.p();
                    h0Var.b();
                    pVar.f9957a = h0Var.f3889e;
                    pVar.f9966l = m0.p("video/mp2t");
                    pVar.f9967m = m0.p("application/dvbsubs");
                    pVar.f9970p = Collections.singletonList(g0Var.f3878b);
                    pVar.f9960d = g0Var.f3877a;
                    e6.j.s(pVar, h0VarQ);
                    h0VarArr[i] = h0VarQ;
                }
                break;
            default:
                h0Var.a();
                h0Var.b();
                w2.h0 h0VarQ2 = qVar.q(h0Var.f3888d, 5);
                this.f3884g = h0VarQ2;
                p1.p pVar2 = new p1.p();
                h0Var.b();
                pVar2.f9957a = h0Var.f3889e;
                pVar2.f9966l = m0.p("video/mp2t");
                pVar2.f9967m = m0.p("application/id3");
                e6.j.s(pVar2, h0VarQ2);
                break;
        }
    }

    public h() {
        this.f3879a = 1;
        this.f = new s1.u(10);
        this.f3881c = -9223372036854775807L;
    }
}
