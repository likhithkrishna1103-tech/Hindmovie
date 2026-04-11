package ff;

import androidx.media3.decoder.DecoderInputBuffer;
import fe.p;
import w4.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e extends ge.h implements p {
    public final /* synthetic */ int D;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i, Object obj, Class cls, String str, String str2, int i10, int i11, int i12) {
        super(i, obj, cls, str, str2, i10, i11);
        this.D = i12;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) {
        switch (this.D) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                bf.d dVar = (bf.d) obj;
                int iIntValue = ((Number) obj2).intValue();
                ge.i.e(dVar, "p0");
                f fVar = (f) this.f5243w;
                fVar.getClass();
                boolean z10 = !dVar.k(iIntValue) && dVar.j(iIntValue).h();
                fVar.f4580b = z10;
                return Boolean.valueOf(z10);
            case 1:
                return com.bumptech.glide.d.m((t) this.f5243w, (fe.l) obj, (vd.c) obj2);
            default:
                return com.bumptech.glide.d.m((t) this.f5243w, (fe.l) obj, (vd.c) obj2);
        }
    }
}
