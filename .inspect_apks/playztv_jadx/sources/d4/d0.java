package d4;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.List;
import p1.m0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f3811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w2.h0[] f3812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n.p f3813d;

    public d0(int i, List list) {
        this.f3810a = i;
        switch (i) {
            case 1:
                this.f3811b = list;
                this.f3812c = new w2.h0[list.size()];
                n.p pVar = new n.p(new a2.f0(14, this));
                this.f3813d = pVar;
                pVar.x(3);
                break;
            default:
                this.f3811b = list;
                this.f3812c = new w2.h0[list.size()];
                this.f3813d = new n.p(new a2.f0(13, this));
                break;
        }
    }

    public void a(long j5, s1.u uVar) {
        if (uVar.a() < 9) {
            return;
        }
        int iJ = uVar.j();
        int iJ2 = uVar.j();
        int iX = uVar.x();
        if (iJ == 434 && iJ2 == 1195456820 && iX == 3) {
            this.f3813d.a(j5, uVar);
        }
    }

    public final void b(w2.q qVar, h0 h0Var) {
        switch (this.f3810a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = 0;
                while (true) {
                    w2.h0[] h0VarArr = this.f3812c;
                    if (i < h0VarArr.length) {
                        h0Var.a();
                        h0Var.b();
                        w2.h0 h0VarQ = qVar.q(h0Var.f3888d, 3);
                        p1.q qVar2 = (p1.q) this.f3811b.get(i);
                        String str = qVar2.f10023n;
                        s1.d.a("Invalid closed caption MIME type provided: " + str, "application/cea-608".equals(str) || "application/cea-708".equals(str));
                        String str2 = qVar2.f10012a;
                        if (str2 == null) {
                            h0Var.b();
                            str2 = h0Var.f3889e;
                        }
                        p1.p pVar = new p1.p();
                        pVar.f9957a = str2;
                        pVar.f9966l = m0.p("video/mp2t");
                        pVar.f9967m = m0.p(str);
                        pVar.f9961e = qVar2.f10016e;
                        pVar.f9960d = qVar2.f10015d;
                        pVar.J = qVar2.K;
                        pVar.f9970p = qVar2.f10026q;
                        e6.j.s(pVar, h0VarQ);
                        h0VarArr[i] = h0VarQ;
                        i++;
                    }
                    break;
                }
                break;
            default:
                int i10 = 0;
                while (true) {
                    w2.h0[] h0VarArr2 = this.f3812c;
                    if (i10 < h0VarArr2.length) {
                        h0Var.a();
                        h0Var.b();
                        w2.h0 h0VarQ2 = qVar.q(h0Var.f3888d, 3);
                        p1.q qVar3 = (p1.q) this.f3811b.get(i10);
                        String str3 = qVar3.f10023n;
                        s1.d.a("Invalid closed caption MIME type provided: " + str3, "application/cea-608".equals(str3) || "application/cea-708".equals(str3));
                        p1.p pVar2 = new p1.p();
                        h0Var.b();
                        pVar2.f9957a = h0Var.f3889e;
                        pVar2.f9966l = m0.p("video/mp2t");
                        pVar2.f9967m = m0.p(str3);
                        pVar2.f9961e = qVar3.f10016e;
                        pVar2.f9960d = qVar3.f10015d;
                        pVar2.J = qVar3.K;
                        pVar2.f9970p = qVar3.f10026q;
                        e6.j.s(pVar2, h0VarQ2);
                        h0VarArr2[i10] = h0VarQ2;
                        i10++;
                    }
                    break;
                }
                break;
        }
    }
}
