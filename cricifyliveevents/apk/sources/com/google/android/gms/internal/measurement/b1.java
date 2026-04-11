package com.google.android.gms.internal.measurement;

import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b1 extends x implements n0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ya.s f2326d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b1(w0 w0Var, ya.s sVar) {
        super("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
        this.f2326d = sVar;
    }

    @Override // com.google.android.gms.internal.measurement.n0
    public final void a() {
        this.f2326d.run();
    }

    @Override // com.google.android.gms.internal.measurement.x
    public final boolean b(int i, Parcel parcel, Parcel parcel2) {
        if (i != 2) {
            return false;
        }
        a();
        return true;
    }
}
