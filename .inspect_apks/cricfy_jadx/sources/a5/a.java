package a5;

import androidx.media3.decoder.DecoderInputBuffer;
import fe.l;
import fe.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends xd.h implements p {
    public /* synthetic */ Object A;
    public final /* synthetic */ l B;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f268z = 1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(l lVar, vd.c cVar) {
        super(2, cVar);
        this.B = lVar;
    }

    @Override // fe.p
    public final Object j(Object obj, Object obj2) throws Throwable {
        switch (this.f268z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((a) m((y4.i) obj, (vd.c) obj2)).o(rd.l.f11003a);
            default:
                a aVar = (a) m((h1.b) obj, (vd.c) obj2);
                rd.l lVar = rd.l.f11003a;
                aVar.o(lVar);
                return lVar;
        }
    }

    @Override // xd.a
    public final vd.c m(Object obj, vd.c cVar) {
        switch (this.f268z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a aVar = new a(cVar, this.B);
                aVar.A = obj;
                return aVar;
            default:
                a aVar2 = new a(this.B, cVar);
                aVar2.A = obj;
                return aVar2;
        }
    }

    @Override // xd.a
    public final Object o(Object obj) throws Throwable {
        int i = this.f268z;
        l lVar = this.B;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                com.bumptech.glide.c.C(obj);
                y4.i iVar = (y4.i) this.A;
                ge.i.c(iVar, "null cannot be cast to non-null type androidx.room.coroutines.RawConnectionAccessor");
                return lVar.a(iVar.b());
            default:
                com.bumptech.glide.c.C(obj);
                lVar.a((h1.b) this.A);
                return rd.l.f11003a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(vd.c cVar, l lVar) {
        super(2, cVar);
        this.B = lVar;
    }
}
