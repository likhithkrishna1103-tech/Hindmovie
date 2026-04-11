package com.google.android.gms.internal.measurement;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ v f2876b;

    public /* synthetic */ a(int i) {
        this.f2875a = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f2875a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                k4 k4Var = this.f2876b.f3216d;
                p5 p5Var = new p5("internal.registerCallback");
                p5Var.f3151x = k4Var;
                return p5Var;
            default:
                return new p5(this.f2876b.f3215c);
        }
    }
}
