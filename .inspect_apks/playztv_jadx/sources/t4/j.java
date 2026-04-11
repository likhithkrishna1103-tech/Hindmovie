package t4;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j implements q, r4.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12134b;

    public /* synthetic */ j(int i, Object obj) {
        this.f12133a = i;
        this.f12134b = obj;
    }

    @Override // r4.l
    public final Object a(String str, ae.l lVar, td.c cVar) {
        switch (this.f12133a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((p) this.f12134b).a(str, lVar, cVar);
            default:
                return ((u4.d) this.f12134b).a(str, lVar, cVar);
        }
    }

    @Override // t4.q
    public final y4.a c() {
        switch (this.f12133a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((p) this.f12134b).f12148a;
            default:
                return ((u4.d) this.f12134b).f12767a;
        }
    }
}
