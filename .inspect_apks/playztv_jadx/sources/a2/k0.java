package a2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k0 implements s1.m {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f299u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ p1.r1 f300v;

    public /* synthetic */ k0(b2.a aVar, p1.r1 r1Var) {
        this.f300v = r1Var;
    }

    @Override // s1.m
    public final void a(Object obj) {
        switch (this.f299u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((p1.u0) obj).b(this.f300v);
                break;
            default:
                b2.n nVar = (b2.n) obj;
                aa.l0 l0Var = nVar.f1776p;
                p1.r1 r1Var = this.f300v;
                if (l0Var != null) {
                    p1.q qVar = (p1.q) l0Var.f706w;
                    if (qVar.f10031v == -1) {
                        p1.p pVarA = qVar.a();
                        pVarA.f9974t = r1Var.f10049a;
                        pVarA.f9975u = r1Var.f10050b;
                        nVar.f1776p = new aa.l0(new p1.q(pVarA), l0Var.f705v, (String) l0Var.f707x, 1);
                    }
                }
                int i = r1Var.f10049a;
                break;
        }
    }

    public /* synthetic */ k0(p1.r1 r1Var) {
        this.f300v = r1Var;
    }
}
