package a2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r implements z9.l {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f390u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f391v;

    public /* synthetic */ r(int i, Object obj) {
        this.f390u = i;
        this.f391v = obj;
    }

    @Override // z9.l
    public final Object get() {
        switch (this.f390u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return (gc.d) this.f391v;
            case 1:
                return (s2.g) this.f391v;
            case 2:
                return (r2.p) this.f391v;
            case 3:
                return (o2.q) this.f391v;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return (n) this.f391v;
            default:
                try {
                    return (o2.c0) ((Class) this.f391v).getConstructor(null).newInstance(null);
                } catch (Exception e10) {
                    throw new IllegalStateException(e10);
                }
        }
    }
}
