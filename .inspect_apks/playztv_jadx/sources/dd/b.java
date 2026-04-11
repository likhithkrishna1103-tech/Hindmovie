package dd;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements ae.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f4135u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f4136v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f4137w;

    public /* synthetic */ b(Object obj, int i, Object obj2) {
        this.f4135u = i;
        this.f4136v = obj;
        this.f4137w = obj2;
    }

    @Override // ae.a
    public final Object b() {
        switch (this.f4135u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                h hVar = (h) this.f4136v;
                p pVar = (p) this.f4137w;
                a aVar = (a) hVar.f4153c;
                aVar.getClass();
                synchronized (aVar.C) {
                    aVar.C.add(pVar);
                }
                aVar.f4133y.a(aVar.B, pVar);
                aVar.f4132x.b("Added listener " + pVar);
                return nd.k.f8990a;
            default:
                ed.d dVar = (ed.d) this.f4136v;
                String str = (String) this.f4137w;
                if (!dVar.E && !dVar.D && "LibGlobalFetchLib".equals(str)) {
                    dVar.v();
                }
                return nd.k.f8990a;
        }
    }
}
