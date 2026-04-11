package z1;

import java.util.ArrayList;
import java.util.Arrays;
import v1.i0;
import v1.k0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f15062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f15064d;

    public a(String str, byte[] bArr, int i, int i10) {
        boolean z10;
        byte b8;
        str.getClass();
        switch (str) {
            case "com.android.capture.fps":
                if (i10 == 23 && bArr.length == 4) {
                    z10 = true;
                }
                y1.d.b(z10);
                break;
            case "auxiliary.tracks.interleaved":
                if (i10 == 75 && bArr.length == 1 && ((b8 = bArr[0]) == 0 || b8 == 1)) {
                    z10 = true;
                }
                y1.d.b(z10);
                break;
            case "auxiliary.tracks.length":
            case "auxiliary.tracks.offset":
                if (i10 == 78 && bArr.length == 8) {
                    z10 = true;
                }
                y1.d.b(z10);
                break;
            case "auxiliary.tracks.map":
                y1.d.b(i10 == 0);
                break;
        }
        this.f15061a = str;
        this.f15062b = bArr;
        this.f15063c = i;
        this.f15064d = i10;
    }

    @Override // v1.k0
    public final /* synthetic */ v1.p a() {
        return null;
    }

    @Override // v1.k0
    public final /* synthetic */ byte[] b() {
        return null;
    }

    public final ArrayList d() {
        y1.d.f("Metadata is not an auxiliary tracks map", this.f15061a.equals("auxiliary.tracks.map"));
        byte[] bArr = this.f15062b;
        byte b8 = bArr[1];
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < b8; i++) {
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
            if (this.f15061a.equals(aVar.f15061a) && Arrays.equals(this.f15062b, aVar.f15062b) && this.f15063c == aVar.f15063c && this.f15064d == aVar.f15064d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.f15062b) + l0.e.e(527, 31, this.f15061a)) * 31) + this.f15063c) * 31) + this.f15064d;
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
        throw new UnsupportedOperationException("Method not decompiled: z1.a.toString():java.lang.String");
    }

    @Override // v1.k0
    public final /* synthetic */ void c(i0 i0Var) {
    }
}
