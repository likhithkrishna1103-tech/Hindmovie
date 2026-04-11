package com.google.android.gms.internal.measurement;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ta.l f2364b;

    public d4(Context context, ta.l lVar) {
        this.f2363a = context;
        this.f2364b = lVar;
    }

    public final boolean equals(Object obj) {
        ta.l lVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof d4) {
            d4 d4Var = (d4) obj;
            ta.l lVar2 = d4Var.f2364b;
            if (this.f2363a.equals(d4Var.f2363a) && ((lVar = this.f2364b) != null ? lVar.equals(lVar2) : lVar2 == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f2363a.hashCode() ^ 1000003;
        ta.l lVar = this.f2364b;
        return (iHashCode * 1000003) ^ (lVar == null ? 0 : lVar.hashCode());
    }

    public final String toString() {
        String string = this.f2363a.toString();
        int length = string.length();
        String strValueOf = String.valueOf(this.f2364b);
        StringBuilder sb = new StringBuilder(length + 45 + strValueOf.length() + 1);
        sb.append("FlagsContext{context=");
        sb.append(string);
        sb.append(", hermeticFileOverrides=");
        sb.append(strValueOf);
        sb.append("}");
        return sb.toString();
    }
}
