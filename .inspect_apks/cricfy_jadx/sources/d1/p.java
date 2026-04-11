package d1;

import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends xd.h implements fe.p {
    public /* synthetic */ Object A;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f3288z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(int i, vd.c cVar, int i10) {
        super(i, cVar);
        this.f3288z = i10;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) throws Throwable {
        switch (this.f3288z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((p) m((l1) obj, (vd.c) obj2)).o(rd.l.f11003a);
            case 1:
                p pVar = (p) m((String) obj, (vd.c) obj2);
                rd.l lVar = rd.l.f11003a;
                pVar.o(lVar);
                return lVar;
            default:
                return ((p) m((yc.g) obj, (vd.c) obj2)).o(rd.l.f11003a);
        }
    }

    @Override // xd.a
    public final vd.c m(Object obj, vd.c cVar) {
        switch (this.f3288z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                p pVar = new p(2, cVar, 0);
                pVar.A = obj;
                return pVar;
            case 1:
                p pVar2 = new p(2, cVar, 1);
                pVar2.A = obj;
                return pVar2;
            default:
                return new p((yc.g) this.A, cVar);
        }
    }

    @Override // xd.a
    public final Object o(Object obj) throws Throwable {
        switch (this.f3288z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                com.bumptech.glide.c.C(obj);
                return Boolean.valueOf(!(((l1) this.A) instanceof r0));
            case 1:
                com.bumptech.glide.c.C(obj);
                Log.e("FirebaseSessions", "Error failed to fetch the remote configs: " + ((String) this.A));
                return rd.l.f11003a;
            default:
                com.bumptech.glide.c.C(obj);
                return (yc.g) this.A;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(yc.g gVar, vd.c cVar) {
        super(2, cVar);
        this.f3288z = 2;
        this.A = gVar;
    }
}
