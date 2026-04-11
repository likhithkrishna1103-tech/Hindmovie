package y2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b0 implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f14634v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ vb.b f14635w;

    public /* synthetic */ b0(vb.b bVar, int i, long j4) {
        this.f14634v = 3;
        this.f14635w = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f14634v;
        vb.b bVar = this.f14635w;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                c0 c0Var = (c0) bVar.f13552x;
                int i10 = y1.a0.f14551a;
                h2.f fVar = ((g2.d0) c0Var).f4651v.O;
                fVar.W(fVar.V(), 1016, new h2.b(3));
                break;
            case 1:
                c0 c0Var2 = (c0) bVar.f13552x;
                int i11 = y1.a0.f14551a;
                h2.f fVar2 = ((g2.d0) c0Var2).f4651v.O;
                fVar2.W(fVar2.V(), 1030, new a3.m(15));
                break;
            case 2:
                c0 c0Var3 = (c0) bVar.f13552x;
                int i12 = y1.a0.f14551a;
                h2.f fVar3 = ((g2.d0) c0Var3).f4651v.O;
                fVar3.W(fVar3.V(), 1019, new a3.m(21));
                break;
            case 3:
                c0 c0Var4 = (c0) bVar.f13552x;
                int i13 = y1.a0.f14551a;
                h2.f fVar4 = ((g2.d0) c0Var4).f4651v.O;
                fVar4.W(fVar4.S((s2.c0) fVar4.f5497y.f), 1018, new h2.b(11));
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                c0 c0Var5 = (c0) bVar.f13552x;
                int i14 = y1.a0.f14551a;
                h2.f fVar5 = ((g2.d0) c0Var5).f4651v.O;
                fVar5.W(fVar5.S((s2.c0) fVar5.f5497y.f), 1021, new h2.b(12));
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                c0 c0Var6 = (c0) bVar.f13552x;
                int i15 = y1.a0.f14551a;
                h2.f fVar6 = ((g2.d0) c0Var6).f4651v.O;
                fVar6.W(fVar6.V(), 1015, new h2.b(22));
                break;
            default:
                c0 c0Var7 = (c0) bVar.f13552x;
                int i16 = y1.a0.f14551a;
                h2.f fVar7 = ((g2.d0) c0Var7).f4651v.O;
                fVar7.W(fVar7.V(), 1017, new h2.b(18));
                break;
        }
    }

    public /* synthetic */ b0(vb.b bVar, long j4, int i) {
        this.f14634v = 4;
        this.f14635w = bVar;
    }

    public /* synthetic */ b0(vb.b bVar, Object obj, int i) {
        this.f14634v = i;
        this.f14635w = bVar;
    }

    public /* synthetic */ b0(vb.b bVar, String str, long j4, long j7) {
        this.f14634v = 0;
        this.f14635w = bVar;
    }

    public /* synthetic */ b0(vb.b bVar, v1.p pVar, g2.g gVar) {
        this.f14634v = 6;
        this.f14635w = bVar;
    }
}
