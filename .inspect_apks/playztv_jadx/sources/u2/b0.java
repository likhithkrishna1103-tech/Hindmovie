package u2;

import a2.l0;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b0 implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f12555u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ pb.c f12556v;

    public /* synthetic */ b0(int i, Object obj, pb.c cVar) {
        this.f12555u = i;
        this.f12556v = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f12555u;
        pb.c cVar = this.f12556v;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                c0 c0Var = (c0) cVar.f10311w;
                int i10 = s1.b0.f11647a;
                b2.h hVar = ((l0) c0Var).f312u.N;
                hVar.W(hVar.V(), 1016, new a2.s(25));
                break;
            case 1:
                c0 c0Var2 = (c0) cVar.f10311w;
                int i11 = s1.b0.f11647a;
                b2.h hVar2 = ((l0) c0Var2).f312u.N;
                hVar2.W(hVar2.V(), 1030, new a2.s(7));
                break;
            case 2:
                c0 c0Var3 = (c0) cVar.f10311w;
                int i12 = s1.b0.f11647a;
                b2.h hVar3 = ((l0) c0Var3).f312u.N;
                hVar3.W(hVar3.V(), 1019, new a2.s(13));
                break;
            case 3:
                c0 c0Var4 = (c0) cVar.f10311w;
                int i13 = s1.b0.f11647a;
                b2.h hVar4 = ((l0) c0Var4).f312u.N;
                hVar4.W(hVar4.S((o2.d0) hVar4.f1745x.f), 1018, new b2.d(3));
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                c0 c0Var5 = (c0) cVar.f10311w;
                int i14 = s1.b0.f11647a;
                b2.h hVar5 = ((l0) c0Var5).f312u.N;
                hVar5.W(hVar5.S((o2.d0) hVar5.f1745x.f), 1021, new b2.d(4));
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                c0 c0Var6 = (c0) cVar.f10311w;
                int i15 = s1.b0.f11647a;
                b2.h hVar6 = ((l0) c0Var6).f312u.N;
                hVar6.W(hVar6.V(), 1015, new b2.d(14));
                break;
            default:
                c0 c0Var7 = (c0) cVar.f10311w;
                int i16 = s1.b0.f11647a;
                b2.h hVar7 = ((l0) c0Var7).f312u.N;
                hVar7.W(hVar7.V(), 1017, new b2.d(10));
                break;
        }
    }

    public /* synthetic */ b0(pb.c cVar, int i, long j5) {
        this.f12555u = 3;
        this.f12556v = cVar;
    }

    public /* synthetic */ b0(pb.c cVar, long j5, int i) {
        this.f12555u = 4;
        this.f12556v = cVar;
    }

    public /* synthetic */ b0(pb.c cVar, String str, long j5, long j8) {
        this.f12555u = 0;
        this.f12556v = cVar;
    }

    public /* synthetic */ b0(pb.c cVar, p1.q qVar, a2.i iVar) {
        this.f12555u = 6;
        this.f12556v = cVar;
    }
}
