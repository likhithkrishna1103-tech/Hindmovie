package com.bumptech.glide.manager;

import android.net.ConnectivityManager;
import android.net.Network;
import androidx.media3.decoder.DecoderInputBuffer;
import c2.x;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class p extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2850b;

    public /* synthetic */ p(int i, Object obj) {
        this.f2849a = i;
        this.f2850b = obj;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        switch (this.f2849a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                x6.m.f().post(new o(this, true, 0));
                break;
            default:
                be.h.e(network, "network");
                x.a((x) this.f2850b);
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        switch (this.f2849a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                x6.m.f().post(new o(this, false, 0));
                break;
            default:
                be.h.e(network, "network");
                x.a((x) this.f2850b);
                break;
        }
    }
}
