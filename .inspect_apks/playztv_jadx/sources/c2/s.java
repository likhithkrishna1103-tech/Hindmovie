package c2;

import android.media.AudioTrack;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f2375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u5.c f2377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f2379e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f2380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f2381h;
    public long i;

    public s(AudioTrack audioTrack, u5.c cVar) {
        this.f2375a = new r(audioTrack);
        this.f2376b = audioTrack.getSampleRate();
        this.f2377c = cVar;
        a(0);
    }

    public final void a(int i) {
        this.f2378d = i;
        if (i == 0) {
            this.f2380g = 0L;
            this.f2381h = -1L;
            this.i = -9223372036854775807L;
            this.f2379e = System.nanoTime() / 1000;
            this.f = 10000L;
            return;
        }
        if (i == 1) {
            this.f = 10000L;
            return;
        }
        if (i == 2 || i == 3) {
            this.f = 10000000L;
        } else {
            if (i != 4) {
                throw new IllegalStateException();
            }
            this.f = 500000L;
        }
    }
}
