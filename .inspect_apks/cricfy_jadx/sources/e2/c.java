package e2;

import android.media.MediaCodec;
import android.os.Build;
import l4.c0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f3752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f3753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f3755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f3756e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3757g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3758h;
    public final MediaCodec.CryptoInfo i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c0 f3759j;

    public c() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.i = cryptoInfo;
        this.f3759j = Build.VERSION.SDK_INT >= 24 ? new c0(cryptoInfo) : null;
    }
}
