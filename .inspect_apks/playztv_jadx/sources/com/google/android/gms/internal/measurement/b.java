package com.google.android.gms.internal.measurement;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends j {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ int f2895w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(String str, int i) {
        super(str);
        this.f2895w = i;
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final n a(ub.o oVar, List list) {
        switch (this.f2895w) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new g(Double.valueOf(0.0d));
            case 1:
                return n.f3106a;
            case 2:
            case 3:
                return this;
            default:
                return n.f3106a;
        }
    }
}
