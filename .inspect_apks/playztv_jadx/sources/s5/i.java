package s5;

import androidx.media3.decoder.DecoderInputBuffer;
import l5.w;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11830a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f11831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r5.b f11832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f11833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r5.e f11834e;
    public final Object f;

    public i(String str, r5.b bVar, r5.b bVar2, r5.d dVar, boolean z2) {
        this.f11831b = str;
        this.f11832c = bVar;
        this.f11834e = bVar2;
        this.f = dVar;
        this.f11833d = z2;
    }

    @Override // s5.b
    public final n5.c a(w wVar, l5.j jVar, t5.b bVar) {
        switch (this.f11830a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new n5.o(wVar, bVar, this);
            default:
                return new n5.p(wVar, bVar, this);
        }
    }

    public String toString() {
        switch (this.f11830a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return "RectangleShape{position=" + this.f11834e + ", size=" + ((r5.e) this.f) + '}';
            default:
                return super.toString();
        }
    }

    public i(String str, r5.e eVar, r5.a aVar, r5.b bVar, boolean z2) {
        this.f11831b = str;
        this.f11834e = eVar;
        this.f = aVar;
        this.f11832c = bVar;
        this.f11833d = z2;
    }
}
