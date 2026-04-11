package i2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f6063v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ k f6064w;

    public /* synthetic */ i(k kVar, int i, long j4, long j7) {
        this.f6063v = 8;
        this.f6064w = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f6063v;
        int i10 = 2;
        k kVar = this.f6064w;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                l lVar = (l) kVar.f6086w;
                int i11 = y1.a0.f14551a;
                h2.f fVar = ((g2.d0) lVar).f4651v.O;
                fVar.W(fVar.V(), 1029, new h2.b(2));
                break;
            case 1:
                l lVar2 = (l) kVar.f6086w;
                int i12 = y1.a0.f14551a;
                h2.f fVar2 = ((g2.d0) lVar2).f4651v.O;
                fVar2.W(fVar2.V(), 1031, new h2.e(4));
                break;
            case 2:
                l lVar3 = (l) kVar.f6086w;
                int i13 = y1.a0.f14551a;
                h2.f fVar3 = ((g2.d0) lVar3).f4651v.O;
                fVar3.W(fVar3.V(), 1008, new a3.m(19));
                break;
            case 3:
                l lVar4 = (l) kVar.f6086w;
                int i14 = y1.a0.f14551a;
                h2.f fVar4 = ((g2.d0) lVar4).f4651v.O;
                fVar4.W(fVar4.V(), 1012, new h2.e(5));
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                l lVar5 = (l) kVar.f6086w;
                int i15 = y1.a0.f14551a;
                h2.f fVar5 = ((g2.d0) lVar5).f4651v.O;
                fVar5.W(fVar5.V(), 1007, new h2.b(8));
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                l lVar6 = (l) kVar.f6086w;
                int i16 = y1.a0.f14551a;
                h2.f fVar6 = ((g2.d0) lVar6).f4651v.O;
                fVar6.W(fVar6.V(), 1014, new h2.b(25));
                break;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                l lVar7 = (l) kVar.f6086w;
                int i17 = y1.a0.f14551a;
                h2.f fVar7 = ((g2.d0) lVar7).f4651v.O;
                fVar7.W(fVar7.V(), 1009, new h2.b(21));
                break;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                l lVar8 = (l) kVar.f6086w;
                int i18 = y1.a0.f14551a;
                h2.f fVar8 = ((g2.d0) lVar8).f4651v.O;
                fVar8.W(fVar8.V(), 1010, new h2.b(10));
                break;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                l lVar9 = (l) kVar.f6086w;
                int i19 = y1.a0.f14551a;
                h2.f fVar9 = ((g2.d0) lVar9).f4651v.O;
                fVar9.W(fVar9.V(), 1011, new h2.b(26));
                break;
            default:
                l lVar10 = (l) kVar.f6086w;
                int i20 = y1.a0.f14551a;
                h2.f fVar10 = ((g2.d0) lVar10).f4651v.O;
                fVar10.W(fVar10.V(), 1032, new h2.e(i10));
                break;
        }
    }

    public /* synthetic */ i(k kVar, long j4) {
        this.f6063v = 7;
        this.f6064w = kVar;
    }

    public /* synthetic */ i(k kVar, Object obj, int i) {
        this.f6063v = i;
        this.f6064w = kVar;
    }

    public /* synthetic */ i(k kVar, String str, long j4, long j7) {
        this.f6063v = 2;
        this.f6064w = kVar;
    }

    public /* synthetic */ i(k kVar, v1.p pVar, g2.g gVar) {
        this.f6063v = 6;
        this.f6064w = kVar;
    }
}
