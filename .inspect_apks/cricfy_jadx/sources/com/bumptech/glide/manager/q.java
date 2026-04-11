package com.bumptech.glide.manager;

import android.net.ConnectivityManager;
import android.net.Network;
import androidx.media3.decoder.DecoderInputBuffer;
import i2.x;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2278b;

    public /* synthetic */ q(int i, Object obj) {
        this.f2277a = i;
        this.f2278b = obj;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        switch (this.f2277a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                s7.m.f().post(new p(this, true, 0));
                break;
            default:
                ge.i.e(network, "network");
                x.a((x) this.f2278b);
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        switch (this.f2277a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                s7.m.f().post(new p(this, false, 0));
                break;
            default:
                ge.i.e(network, "network");
                x.a((x) this.f2278b);
                break;
        }
    }
}
