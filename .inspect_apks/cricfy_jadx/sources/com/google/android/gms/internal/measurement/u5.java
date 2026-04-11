package com.google.android.gms.internal.measurement;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u5 extends h {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ int f2648x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u5(int i, String str) {
        super(str);
        this.f2648x = i;
    }

    @Override // com.google.android.gms.internal.measurement.h
    public final n e(b6.f fVar, List list) {
        switch (this.f2648x) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return n.f2536b;
            case 1:
            case 2:
                return this;
            case 3:
                return new g(Double.valueOf(0.0d));
            default:
                return n.f2536b;
        }
    }
}
