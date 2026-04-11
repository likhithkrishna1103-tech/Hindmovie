package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h4 extends ContentObserver {
    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        n4.i.incrementAndGet();
    }
}
