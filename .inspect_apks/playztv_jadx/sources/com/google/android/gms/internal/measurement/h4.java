package com.google.android.gms.internal.measurement;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z9.l f3036b;

    public h4(Context context, z9.l lVar) {
        this.f3035a = context;
        this.f3036b = lVar;
    }

    public final boolean equals(Object obj) {
        z9.l lVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof h4) {
            h4 h4Var = (h4) obj;
            z9.l lVar2 = h4Var.f3036b;
            if (this.f3035a.equals(h4Var.f3035a) && ((lVar = this.f3036b) != null ? lVar.equals(lVar2) : lVar2 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f3035a.hashCode() ^ 1000003) * 1000003;
        z9.l lVar = this.f3036b;
        return iHashCode ^ (lVar == null ? 0 : lVar.hashCode());
    }

    public final String toString() {
        return "FlagsContext{context=" + String.valueOf(this.f3035a) + ", hermeticFileOverrides=" + String.valueOf(this.f3036b) + "}";
    }
}
