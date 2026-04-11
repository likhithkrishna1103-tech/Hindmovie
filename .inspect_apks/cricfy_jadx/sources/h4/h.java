package h4;

import a3.i0;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Collections;
import java.util.List;
import v1.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5651e;
    public final Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f5652g;

    public h(List list) {
        this.f5647a = 0;
        this.f = list;
        this.f5652g = new i0[list.size()];
        this.f5649c = -9223372036854775807L;
    }

    @Override // h4.i
    public final void a() {
        switch (this.f5647a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f5648b = false;
                this.f5649c = -9223372036854775807L;
                break;
            default:
                this.f5648b = false;
                this.f5649c = -9223372036854775807L;
                break;
        }
    }

    @Override // h4.i
    public final void b(y1.t tVar) {
        boolean z10;
        boolean z11;
        switch (this.f5647a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (this.f5648b) {
                    if (this.f5650d == 2) {
                        if (tVar.a() == 0) {
                            z11 = false;
                        } else {
                            if (tVar.x() != 32) {
                                this.f5648b = false;
                            }
                            this.f5650d--;
                            z11 = this.f5648b;
                        }
                        if (!z11) {
                        }
                    }
                    if (this.f5650d == 1) {
                        if (tVar.a() == 0) {
                            z10 = false;
                        } else {
                            if (tVar.x() != 0) {
                                this.f5648b = false;
                            }
                            this.f5650d--;
                            z10 = this.f5648b;
                        }
                        if (!z10) {
                        }
                    }
                    int i = tVar.f14610b;
                    int iA = tVar.a();
                    for (i0 i0Var : (i0[]) this.f5652g) {
                        tVar.J(i);
                        i0Var.a(iA, tVar);
                    }
                    this.f5651e += iA;
                }
                break;
            default:
                y1.t tVar2 = (y1.t) this.f;
                y1.d.h((i0) this.f5652g);
                if (this.f5648b) {
                    int iA2 = tVar.a();
                    int i10 = this.f5651e;
                    if (i10 < 10) {
                        int iMin = Math.min(iA2, 10 - i10);
                        System.arraycopy(tVar.f14609a, tVar.f14610b, tVar2.f14609a, this.f5651e, iMin);
                        if (this.f5651e + iMin == 10) {
                            tVar2.J(0);
                            if (73 == tVar2.x() && 68 == tVar2.x() && 51 == tVar2.x()) {
                                tVar2.K(3);
                                this.f5650d = tVar2.w() + 10;
                            } else {
                                y1.b.p("Id3Reader", "Discarding invalid ID3 tag");
                                this.f5648b = false;
                            }
                        }
                    }
                    int iMin2 = Math.min(iA2, this.f5650d - this.f5651e);
                    ((i0) this.f5652g).a(iMin2, tVar);
                    this.f5651e += iMin2;
                    break;
                }
                break;
        }
    }

    @Override // h4.i
    public final void c(boolean z10) {
        int i;
        switch (this.f5647a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (this.f5648b) {
                    y1.d.g(this.f5649c != -9223372036854775807L);
                    for (i0 i0Var : (i0[]) this.f5652g) {
                        i0Var.e(this.f5649c, 1, this.f5651e, 0, null);
                    }
                    this.f5648b = false;
                }
                break;
            default:
                y1.d.h((i0) this.f5652g);
                if (this.f5648b && (i = this.f5650d) != 0 && this.f5651e == i) {
                    y1.d.g(this.f5649c != -9223372036854775807L);
                    ((i0) this.f5652g).e(this.f5649c, 1, this.f5650d, 0, null);
                    this.f5648b = false;
                    break;
                }
                break;
        }
    }

    @Override // h4.i
    public final void d(int i, long j4) {
        switch (this.f5647a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if ((i & 4) != 0) {
                    this.f5648b = true;
                    this.f5649c = j4;
                    this.f5651e = 0;
                    this.f5650d = 2;
                    break;
                }
                break;
            default:
                if ((i & 4) != 0) {
                    this.f5648b = true;
                    this.f5649c = j4;
                    this.f5650d = 0;
                    this.f5651e = 0;
                    break;
                }
                break;
        }
    }

    @Override // h4.i
    public final void e(a3.r rVar, g0 g0Var) {
        switch (this.f5647a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                i0[] i0VarArr = (i0[]) this.f5652g;
                for (int i = 0; i < i0VarArr.length; i++) {
                    f0 f0Var = (f0) ((List) this.f).get(i);
                    g0Var.a();
                    g0Var.b();
                    i0 i0VarP = rVar.p(g0Var.f5645d, 3);
                    v1.o oVar = new v1.o();
                    g0Var.b();
                    oVar.f12883a = g0Var.f5646e;
                    oVar.f12892l = m0.p("video/mp2t");
                    oVar.f12893m = m0.p("application/dvbsubs");
                    oVar.f12896p = Collections.singletonList(f0Var.f5626b);
                    oVar.f12886d = f0Var.f5625a;
                    l0.e.s(oVar, i0VarP);
                    i0VarArr[i] = i0VarP;
                }
                break;
            default:
                g0Var.a();
                g0Var.b();
                i0 i0VarP2 = rVar.p(g0Var.f5645d, 5);
                this.f5652g = i0VarP2;
                v1.o oVar2 = new v1.o();
                g0Var.b();
                oVar2.f12883a = g0Var.f5646e;
                oVar2.f12892l = m0.p("video/mp2t");
                oVar2.f12893m = m0.p("application/id3");
                l0.e.s(oVar2, i0VarP2);
                break;
        }
    }

    public h() {
        this.f5647a = 1;
        this.f = new y1.t(10);
        this.f5649c = -9223372036854775807L;
    }
}
