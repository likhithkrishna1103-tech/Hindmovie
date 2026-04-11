package g2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c0 implements y1.m {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f4637v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ v1.r1 f4638w;

    public /* synthetic */ c0(h2.a aVar, v1.r1 r1Var) {
        this.f4638w = r1Var;
    }

    @Override // y1.m
    public final void a(Object obj) {
        switch (this.f4637v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((v1.u0) obj).a(this.f4638w);
                break;
            default:
                h2.k kVar = (h2.k) obj;
                f3.a aVar = kVar.f5525p;
                v1.r1 r1Var = this.f4638w;
                if (aVar != null) {
                    v1.p pVar = (v1.p) aVar.f3936x;
                    if (pVar.f12954v == -1) {
                        v1.o oVarA = pVar.a();
                        oVarA.f12900t = r1Var.f12981a;
                        oVarA.f12901u = r1Var.f12982b;
                        kVar.f5525p = new f3.a(new v1.p(oVarA), aVar.f3935w, (String) aVar.f3937y, 2);
                    }
                }
                int i = r1Var.f12981a;
                break;
        }
    }

    public /* synthetic */ c0(v1.r1 r1Var) {
        this.f4638w = r1Var;
    }
}
