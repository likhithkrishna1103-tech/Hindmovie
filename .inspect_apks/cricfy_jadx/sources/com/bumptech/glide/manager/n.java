package com.bumptech.glide.manager;

import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f2273a;

    public n(u uVar) {
        this.f2273a = uVar;
    }

    @Override // com.bumptech.glide.manager.a
    public final void a(boolean z10) {
        ArrayList arrayList;
        s7.m.a();
        synchronized (this.f2273a) {
            arrayList = new ArrayList((HashSet) this.f2273a.f2291x);
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((a) obj).a(z10);
        }
    }
}
