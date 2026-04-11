package g2;

import android.media.MediaFormat;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 implements y2.u, z2.a, k1 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public y2.u f4662v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public z2.a f4663w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public y2.u f4664x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public z2.a f4665y;

    @Override // z2.a
    public final void a(long j4, float[] fArr) {
        z2.a aVar = this.f4665y;
        if (aVar != null) {
            aVar.a(j4, fArr);
        }
        z2.a aVar2 = this.f4663w;
        if (aVar2 != null) {
            aVar2.a(j4, fArr);
        }
    }

    @Override // g2.k1
    public final void b(int i, Object obj) {
        if (i == 7) {
            this.f4662v = (y2.u) obj;
            return;
        }
        if (i == 8) {
            this.f4663w = (z2.a) obj;
            return;
        }
        if (i != 10000) {
            return;
        }
        z2.k kVar = (z2.k) obj;
        if (kVar == null) {
            this.f4664x = null;
            this.f4665y = null;
        } else {
            this.f4664x = kVar.getVideoFrameMetadataListener();
            this.f4665y = kVar.getCameraMotionListener();
        }
    }

    @Override // z2.a
    public final void c() {
        z2.a aVar = this.f4665y;
        if (aVar != null) {
            aVar.c();
        }
        z2.a aVar2 = this.f4663w;
        if (aVar2 != null) {
            aVar2.c();
        }
    }

    @Override // y2.u
    public final void d(long j4, long j7, v1.p pVar, MediaFormat mediaFormat) {
        long j10;
        long j11;
        v1.p pVar2;
        MediaFormat mediaFormat2;
        y2.u uVar = this.f4664x;
        if (uVar != null) {
            uVar.d(j4, j7, pVar, mediaFormat);
            mediaFormat2 = mediaFormat;
            pVar2 = pVar;
            j11 = j7;
            j10 = j4;
        } else {
            j10 = j4;
            j11 = j7;
            pVar2 = pVar;
            mediaFormat2 = mediaFormat;
        }
        y2.u uVar2 = this.f4662v;
        if (uVar2 != null) {
            uVar2.d(j10, j11, pVar2, mediaFormat2);
        }
    }
}
