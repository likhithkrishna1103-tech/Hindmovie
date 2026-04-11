package com.google.android.gms.internal.measurement;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements c0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f2877u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ub.o f2878v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f2879w;

    public /* synthetic */ a0(ub.o oVar, String str, int i) {
        this.f2877u = i;
        this.f2878v = oVar;
        this.f2879w = str;
    }

    @Override // com.google.android.gms.internal.measurement.c0
    public final ub.o w(n nVar) {
        switch (this.f2877u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ub.o oVarB0 = this.f2878v.b0();
                String str = this.f2879w;
                oVarB0.d0(str, nVar);
                ((HashMap) oVarB0.f12871y).put(str, Boolean.TRUE);
                return oVarB0;
            default:
                String str2 = this.f2879w;
                ub.o oVar = this.f2878v;
                oVar.d0(str2, nVar);
                return oVar;
        }
    }
}
