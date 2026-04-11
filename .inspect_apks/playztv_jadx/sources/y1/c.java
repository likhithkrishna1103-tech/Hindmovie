package y1;

import android.media.MediaCodec;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f14458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f14459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f14461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f14462e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f14463g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14464h;
    public final MediaCodec.CryptoInfo i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final pb.c f14465j;

    public c() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.i = cryptoInfo;
        this.f14465j = Build.VERSION.SDK_INT >= 24 ? new pb.c(cryptoInfo) : null;
    }
}
