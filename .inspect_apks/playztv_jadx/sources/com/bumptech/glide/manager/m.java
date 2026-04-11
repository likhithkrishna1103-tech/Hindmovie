package com.bumptech.glide.manager;

import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f2845a;

    public m(s sVar) {
        this.f2845a = sVar;
    }

    @Override // com.bumptech.glide.manager.a
    public final void a(boolean z2) {
        ArrayList arrayList;
        x6.m.a();
        synchronized (this.f2845a) {
            arrayList = new ArrayList((HashSet) this.f2845a.f2861v);
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((a) obj).a(z2);
        }
    }
}
