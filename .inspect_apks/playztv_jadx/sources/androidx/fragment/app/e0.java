package androidx.fragment.app;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e0 implements x4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1268b;

    public /* synthetic */ e0(int i, Object obj) {
        this.f1267a = i;
        this.f1268b = obj;
    }

    @Override // x4.c
    public final Bundle a() {
        switch (this.f1267a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((n0) this.f1268b).U();
            default:
                return androidx.lifecycle.h0.a((androidx.lifecycle.h0) this.f1268b);
        }
    }
}
