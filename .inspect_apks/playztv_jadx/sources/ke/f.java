package ke;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements ae.q {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f7688u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f7689v;

    public /* synthetic */ f(int i, Object obj) {
        this.f7688u = i;
        this.f7689v = obj;
    }

    @Override // ae.q
    public final Object h(Object obj, Object obj2, Object obj3) throws Exception {
        switch (this.f7688u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((he.i) this.f7689v).a((Throwable) obj);
                break;
            case 1:
                se.c cVar = (se.c) this.f7689v;
                se.c.B.set(cVar, null);
                cVar.a(null);
                break;
            default:
                ((se.g) this.f7689v).c();
                break;
        }
        return nd.k.f8990a;
    }

    public /* synthetic */ f(se.c cVar, se.b bVar) {
        this.f7688u = 1;
        this.f7689v = cVar;
    }
}
