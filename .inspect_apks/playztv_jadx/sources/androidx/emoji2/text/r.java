package androidx.emoji2.text;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r implements q, z4.d {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f1192u;

    public /* synthetic */ r(String str, boolean z2) {
        this.f1192u = str;
    }

    public static r b(s1.u uVar) {
        String str;
        uVar.K(2);
        int iX = uVar.x();
        int i = iX >> 1;
        int iX2 = ((uVar.x() >> 3) & 31) | ((iX & 1) << 5);
        if (i == 4 || i == 5 || i == 7 || i == 8) {
            str = "dvhe";
        } else if (i == 9) {
            str = "dvav";
        } else {
            if (i != 10) {
                return null;
            }
            str = "dav1";
        }
        StringBuilder sbB = v.e.b(str);
        sbB.append(i < 10 ? ".0" : ".");
        sbB.append(i);
        sbB.append(iX2 < 10 ? ".0" : ".");
        sbB.append(iX2);
        return new r(sbB.toString(), false);
    }

    @Override // androidx.emoji2.text.q
    public boolean g(CharSequence charSequence, int i, int i10, y yVar) {
        if (!TextUtils.equals(charSequence.subSequence(i, i10), this.f1192u)) {
            return true;
        }
        yVar.f1214c = (yVar.f1214c & 3) | 4;
        return false;
    }

    @Override // z4.d
    public String v() {
        return this.f1192u;
    }

    public r(String str) {
        be.h.e(str, "query");
        this.f1192u = str;
    }

    @Override // androidx.emoji2.text.q
    public Object a() {
        return this;
    }

    @Override // z4.d
    public void d(z4.c cVar) {
    }
}
