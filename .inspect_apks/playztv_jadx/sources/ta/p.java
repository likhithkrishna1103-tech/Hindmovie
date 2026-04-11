package ta;

import a2.l0;
import a2.o0;
import androidx.media3.decoder.DecoderInputBuffer;
import s1.b0;
import u2.c0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f12400u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f12401v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ long f12402w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f12403x;

    public /* synthetic */ p(pb.c cVar, Object obj, long j5) {
        this.f12400u = 2;
        this.f12401v = cVar;
        this.f12403x = obj;
        this.f12402w = j5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f12400u;
        long j5 = this.f12402w;
        Object obj = this.f12403x;
        Object obj2 = this.f12401v;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                q qVar = (q) obj2;
                qVar.f12416o.f12824b.a(new p(qVar, this.f12402w, (String) obj, 1));
                break;
            case 1:
                String str = (String) obj;
                m mVar = ((q) obj2).f12409g;
                s sVar = mVar.f12392n;
                if (sVar == null || !sVar.f12427e.get()) {
                    ((va.c) mVar.i.f13443v).d(str, j5);
                }
                break;
            default:
                c0 c0Var = (c0) ((pb.c) obj2).f10311w;
                int i10 = b0.f11647a;
                o0 o0Var = ((l0) c0Var).f312u;
                b2.h hVar = o0Var.N;
                b2.a aVarV = hVar.V();
                hVar.W(aVarV, 26, new b2.e(aVarV, obj, j5));
                if (o0Var.f352k0 == obj) {
                    o0Var.H.e(26, new a2.s(3));
                }
                break;
        }
    }

    public /* synthetic */ p(q qVar, long j5, String str, int i) {
        this.f12400u = i;
        this.f12401v = qVar;
        this.f12402w = j5;
        this.f12403x = str;
    }
}
