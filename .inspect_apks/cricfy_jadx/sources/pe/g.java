package pe;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements fe.q {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f10233v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f10234w;

    public /* synthetic */ g(int i, Object obj) {
        this.f10233v = i;
        this.f10234w = obj;
    }

    @Override // fe.q
    public final Object g(Object obj, Object obj2, Object obj3) {
        switch (this.f10233v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((df.l) this.f10234w).a((Throwable) obj);
                break;
            case 1:
                xe.c cVar = (xe.c) this.f10234w;
                xe.c.C.set(cVar, null);
                cVar.a(null);
                break;
            default:
                ((xe.g) this.f10234w).c();
                break;
        }
        return rd.l.f11003a;
    }

    public /* synthetic */ g(xe.c cVar, xe.b bVar) {
        this.f10233v = 1;
        this.f10234w = cVar;
    }
}
