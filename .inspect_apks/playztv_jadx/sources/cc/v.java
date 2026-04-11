package cc;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class v implements ne.c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f2716u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f2717v;

    public /* synthetic */ v(int i, Object obj) {
        this.f2716u = i;
        this.f2717v = obj;
    }

    @Override // ne.c
    public final Object j(Object obj, rd.c cVar) {
        switch (this.f2716u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((f0) this.f2717v).f2636c.set((n) obj);
                return nd.k.f8990a;
            default:
                ((be.n) this.f2717v).f2045u = obj;
                throw new oe.a(this);
        }
    }
}
