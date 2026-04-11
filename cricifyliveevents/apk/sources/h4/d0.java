package h4;

import a3.i0;
import androidx.fragment.app.f1;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.List;
import v1.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f5580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i0[] f5581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ff.k f5582d;

    public d0(int i, List list) {
        this.f5579a = i;
        switch (i) {
            case 1:
                this.f5580b = list;
                this.f5581c = new i0[list.size()];
                ff.k kVar = new ff.k(new f1(20, this));
                this.f5582d = kVar;
                kVar.I(3);
                break;
            default:
                this.f5580b = list;
                this.f5581c = new i0[list.size()];
                this.f5582d = new ff.k(new f1(19, this));
                break;
        }
    }

    public void a(long j4, y1.t tVar) {
        if (tVar.a() < 9) {
            return;
        }
        int iJ = tVar.j();
        int iJ2 = tVar.j();
        int iX = tVar.x();
        if (iJ == 434 && iJ2 == 1195456820 && iX == 3) {
            this.f5582d.a(j4, tVar);
        }
    }

    public final void b(a3.r rVar, g0 g0Var) {
        switch (this.f5579a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = 0;
                while (true) {
                    i0[] i0VarArr = this.f5581c;
                    if (i < i0VarArr.length) {
                        g0Var.a();
                        g0Var.b();
                        i0 i0VarP = rVar.p(g0Var.f5645d, 3);
                        v1.p pVar = (v1.p) this.f5580b.get(i);
                        String str = pVar.f12946n;
                        y1.d.a("Invalid closed caption MIME type provided: " + str, "application/cea-608".equals(str) || "application/cea-708".equals(str));
                        String str2 = pVar.f12935a;
                        if (str2 == null) {
                            g0Var.b();
                            str2 = g0Var.f5646e;
                        }
                        v1.o oVar = new v1.o();
                        oVar.f12883a = str2;
                        oVar.f12892l = m0.p("video/mp2t");
                        oVar.f12893m = m0.p(str);
                        oVar.f12887e = pVar.f12939e;
                        oVar.f12886d = pVar.f12938d;
                        oVar.J = pVar.K;
                        oVar.f12896p = pVar.f12949q;
                        l0.e.s(oVar, i0VarP);
                        i0VarArr[i] = i0VarP;
                        i++;
                    }
                    break;
                }
                break;
            default:
                int i10 = 0;
                while (true) {
                    i0[] i0VarArr2 = this.f5581c;
                    if (i10 < i0VarArr2.length) {
                        g0Var.a();
                        g0Var.b();
                        i0 i0VarP2 = rVar.p(g0Var.f5645d, 3);
                        v1.p pVar2 = (v1.p) this.f5580b.get(i10);
                        String str3 = pVar2.f12946n;
                        y1.d.a("Invalid closed caption MIME type provided: " + str3, "application/cea-608".equals(str3) || "application/cea-708".equals(str3));
                        v1.o oVar2 = new v1.o();
                        g0Var.b();
                        oVar2.f12883a = g0Var.f5646e;
                        oVar2.f12892l = m0.p("video/mp2t");
                        oVar2.f12893m = m0.p(str3);
                        oVar2.f12887e = pVar2.f12939e;
                        oVar2.f12886d = pVar2.f12938d;
                        oVar2.J = pVar2.K;
                        oVar2.f12896p = pVar2.f12949q;
                        l0.e.s(oVar2, i0VarP2);
                        i0VarArr2[i10] = i0VarP2;
                        i10++;
                    }
                    break;
                }
                break;
        }
    }
}
