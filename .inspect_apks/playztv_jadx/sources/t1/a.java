package t1;

import java.util.ArrayList;
import java.util.Arrays;
import p1.i0;
import p1.k0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f11995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11997d;

    public a(String str, byte[] bArr, int i, int i10) {
        boolean z2;
        byte b10;
        str.getClass();
        switch (str) {
            case "com.android.capture.fps":
                if (i10 == 23 && bArr.length == 4) {
                    z2 = true;
                }
                s1.d.b(z2);
                break;
            case "auxiliary.tracks.interleaved":
                if (i10 == 75 && bArr.length == 1 && ((b10 = bArr[0]) == 0 || b10 == 1)) {
                    z2 = true;
                }
                s1.d.b(z2);
                break;
            case "auxiliary.tracks.length":
            case "auxiliary.tracks.offset":
                if (i10 == 78 && bArr.length == 8) {
                    z2 = true;
                }
                s1.d.b(z2);
                break;
            case "auxiliary.tracks.map":
                s1.d.b(i10 == 0);
                break;
        }
        this.f11994a = str;
        this.f11995b = bArr;
        this.f11996c = i;
        this.f11997d = i10;
    }

    @Override // p1.k0
    public final /* synthetic */ p1.q b() {
        return null;
    }

    @Override // p1.k0
    public final /* synthetic */ byte[] c() {
        return null;
    }

    public final ArrayList d() {
        s1.d.f("Metadata is not an auxiliary tracks map", this.f11994a.equals("auxiliary.tracks.map"));
        byte[] bArr = this.f11995b;
        byte b10 = bArr[1];
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < b10; i++) {
            arrayList.add(Integer.valueOf(bArr[i + 2]));
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f11994a.equals(aVar.f11994a) && Arrays.equals(this.f11995b, aVar.f11995b) && this.f11996c == aVar.f11996c && this.f11997d == aVar.f11997d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.f11995b) + e6.j.h(527, 31, this.f11994a)) * 31) + this.f11996c) * 31) + this.f11997d;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.a.toString():java.lang.String");
    }

    @Override // p1.k0
    public final /* synthetic */ void a(i0 i0Var) {
    }
}
