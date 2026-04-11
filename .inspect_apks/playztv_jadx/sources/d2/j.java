package d2;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j extends p2.b {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ int f3734x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Object f3735y;

    public j(n2.b bVar, int i) {
        super(i, bVar.f8649k - 1);
        this.f3735y = bVar;
    }

    @Override // p2.n
    public final long b() {
        switch (this.f3734x) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a();
                return ((i) this.f3735y).e(this.f10128w);
            default:
                return ((n2.b) this.f3735y).b((int) this.f10128w) + e();
        }
    }

    @Override // p2.n
    public final long e() {
        switch (this.f3734x) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                a();
                return ((i) this.f3735y).f(this.f10128w);
            default:
                a();
                n2.b bVar = (n2.b) this.f3735y;
                return bVar.f8653o[(int) this.f10128w];
        }
    }

    public j(i iVar, long j5, long j8) {
        super(j5, j8);
        this.f3735y = iVar;
    }
}
