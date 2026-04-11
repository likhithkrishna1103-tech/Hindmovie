package i2;

import android.media.AudioTrack;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f6111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p6.c f6113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f6115e;
    public long f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f6116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f6117h;
    public long i;

    public u(AudioTrack audioTrack, p6.c cVar) {
        this.f6111a = new t(audioTrack);
        this.f6112b = audioTrack.getSampleRate();
        this.f6113c = cVar;
        a(0);
    }

    public final void a(int i) {
        this.f6114d = i;
        if (i == 0) {
            this.f6116g = 0L;
            this.f6117h = -1L;
            this.i = -9223372036854775807L;
            this.f6115e = System.nanoTime() / 1000;
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
