package a2;

import android.media.MediaFormat;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m0 implements u2.u, v2.a, w1 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public u2.u f322u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public v2.a f323v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public u2.u f324w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public v2.a f325x;

    @Override // v2.a
    public final void a(long j5, float[] fArr) {
        v2.a aVar = this.f325x;
        if (aVar != null) {
            aVar.a(j5, fArr);
        }
        v2.a aVar2 = this.f323v;
        if (aVar2 != null) {
            aVar2.a(j5, fArr);
        }
    }

    @Override // a2.w1
    public final void b(int i, Object obj) {
        if (i == 7) {
            this.f322u = (u2.u) obj;
            return;
        }
        if (i == 8) {
            this.f323v = (v2.a) obj;
            return;
        }
        if (i != 10000) {
            return;
        }
        v2.k kVar = (v2.k) obj;
        if (kVar == null) {
            this.f324w = null;
            this.f325x = null;
        } else {
            this.f324w = kVar.getVideoFrameMetadataListener();
            this.f325x = kVar.getCameraMotionListener();
        }
    }

    @Override // u2.u
    public final void c(long j5, long j8, p1.q qVar, MediaFormat mediaFormat) {
        long j10;
        long j11;
        p1.q qVar2;
        MediaFormat mediaFormat2;
        u2.u uVar = this.f324w;
        if (uVar != null) {
            uVar.c(j5, j8, qVar, mediaFormat);
            mediaFormat2 = mediaFormat;
            qVar2 = qVar;
            j11 = j8;
            j10 = j5;
        } else {
            j10 = j5;
            j11 = j8;
            qVar2 = qVar;
            mediaFormat2 = mediaFormat;
        }
        u2.u uVar2 = this.f322u;
        if (uVar2 != null) {
            uVar2.c(j10, j11, qVar2, mediaFormat2);
        }
    }

    @Override // v2.a
    public final void d() {
        v2.a aVar = this.f325x;
        if (aVar != null) {
            aVar.d();
        }
        v2.a aVar2 = this.f323v;
        if (aVar2 != null) {
            aVar2.d();
        }
    }
}
