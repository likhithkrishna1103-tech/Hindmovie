package androidx.fragment.app;

import android.os.Bundle;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h0 implements b5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f996b;

    public /* synthetic */ h0(int i, Object obj) {
        this.f995a = i;
        this.f996b = obj;
    }

    @Override // b5.d
    public final Bundle a() {
        switch (this.f995a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((r0) this.f996b).X();
            default:
                return androidx.lifecycle.h0.a((androidx.lifecycle.h0) this.f996b);
        }
    }
}
