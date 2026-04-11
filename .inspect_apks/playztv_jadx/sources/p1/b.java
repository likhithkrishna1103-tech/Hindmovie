package p1;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f9644c = new b(new a[0]);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f9645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f9646e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a[] f9648b;

    static {
        a aVar = new a(-1, -1, new int[0], new g0[0], new long[0], new String[0]);
        int[] iArr = aVar.f9624e;
        int length = iArr.length;
        int iMax = Math.max(0, length);
        int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
        Arrays.fill(iArrCopyOf, length, iMax, 0);
        long[] jArr = aVar.f;
        int length2 = jArr.length;
        int iMax2 = Math.max(0, length2);
        long[] jArrCopyOf = Arrays.copyOf(jArr, iMax2);
        Arrays.fill(jArrCopyOf, length2, iMax2, -9223372036854775807L);
        f9645d = new a(0, aVar.f9621b, iArrCopyOf, (g0[]) Arrays.copyOf(aVar.f9623d, 0), jArrCopyOf, (String[]) Arrays.copyOf(aVar.f9625g, 0));
        int i = s1.b0.f11647a;
        f9646e = Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
    }

    public b(a[] aVarArr) {
        this.f9647a = aVarArr.length;
        this.f9648b = aVarArr;
    }

    public final a a(int i) {
        return i < 0 ? f9645d : this.f9648b[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f9647a == bVar.f9647a && Arrays.equals(this.f9648b, bVar.f9648b);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f9648b) + (((((this.f9647a * 961) + ((int) 0)) * 31) + ((int) (-9223372036854775807L))) * 961);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("AdPlaybackState(adsId=null, adResumePositionUs=0, adGroups=[");
        int i = 0;
        while (true) {
            a[] aVarArr = this.f9648b;
            if (i >= aVarArr.length) {
                sb2.append("])");
                return sb2.toString();
            }
            sb2.append("adGroup(timeUs=0, ads=[");
            aVarArr[i].getClass();
            for (int i10 = 0; i10 < aVarArr[i].f9624e.length; i10++) {
                sb2.append("ad(state=");
                int i11 = aVarArr[i].f9624e[i10];
                if (i11 == 0) {
                    sb2.append('_');
                } else if (i11 == 1) {
                    sb2.append('R');
                } else if (i11 == 2) {
                    sb2.append('S');
                } else if (i11 == 3) {
                    sb2.append('P');
                } else if (i11 != 4) {
                    sb2.append('?');
                } else {
                    sb2.append('!');
                }
                sb2.append(", durationUs=");
                sb2.append(aVarArr[i].f[i10]);
                sb2.append(')');
                if (i10 < aVarArr[i].f9624e.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("])");
            if (i < aVarArr.length - 1) {
                sb2.append(", ");
            }
            i++;
        }
    }
}
