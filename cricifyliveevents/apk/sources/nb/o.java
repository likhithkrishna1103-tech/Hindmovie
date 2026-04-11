package nb;

import androidx.media3.decoder.DecoderInputBuffer;
import g2.d0;
import g2.g0;
import y1.a0;
import y2.c0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f8974v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f8975w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ long f8976x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f8977y;

    public /* synthetic */ o(p pVar, long j4, String str, int i) {
        this.f8974v = i;
        this.f8975w = pVar;
        this.f8976x = j4;
        this.f8977y = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f8974v;
        long j4 = this.f8976x;
        Object obj = this.f8977y;
        Object obj2 = this.f8975w;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                p pVar = (p) obj2;
                pVar.f8990o.f9743b.a(new o(pVar, this.f8976x, (String) obj, 1));
                break;
            case 1:
                String str = (String) obj;
                l lVar = ((p) obj2).f8983g;
                r rVar = lVar.f8966n;
                if (rVar == null || !rVar.f9001e.get()) {
                    ((pb.c) lVar.i.f10157w).s(str, j4);
                }
                break;
            default:
                c0 c0Var = (c0) ((vb.b) obj2).f13552x;
                int i10 = a0.f14551a;
                g0 g0Var = ((d0) c0Var).f4651v;
                h2.f fVar = g0Var.O;
                h2.a aVarV = fVar.V();
                fVar.W(aVarV, 26, new h2.d(aVarV, obj, j4));
                if (g0Var.f4700l0 == obj) {
                    g0Var.I.e(26, new a3.m(11));
                }
                break;
        }
    }

    public /* synthetic */ o(vb.b bVar, Object obj, long j4) {
        this.f8974v = 2;
        this.f8975w = bVar;
        this.f8977y = obj;
        this.f8976x = j4;
    }
}
