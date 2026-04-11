package v1;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f12580c = new b(new a[0]);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f12581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f12582e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a[] f12584b;

    static {
        a aVar = new a(-1, -1, new int[0], new g0[0], new long[0], new String[0]);
        int[] iArr = aVar.f12565e;
        int length = iArr.length;
        int iMax = Math.max(0, length);
        int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
        Arrays.fill(iArrCopyOf, length, iMax, 0);
        long[] jArr = aVar.f;
        int length2 = jArr.length;
        int iMax2 = Math.max(0, length2);
        long[] jArrCopyOf = Arrays.copyOf(jArr, iMax2);
        Arrays.fill(jArrCopyOf, length2, iMax2, -9223372036854775807L);
        f12581d = new a(0, aVar.f12562b, iArrCopyOf, (g0[]) Arrays.copyOf(aVar.f12564d, 0), jArrCopyOf, (String[]) Arrays.copyOf(aVar.f12566g, 0));
        int i = y1.a0.f14551a;
        f12582e = Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
    }

    public b(a[] aVarArr) {
        this.f12583a = aVarArr.length;
        this.f12584b = aVarArr;
    }

    public final a a(int i) {
        return i < 0 ? f12581d : this.f12584b[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f12583a == bVar.f12583a && Arrays.equals(this.f12584b, bVar.f12584b);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f12584b) + (((((this.f12583a * 961) + ((int) 0)) * 31) + ((int) (-9223372036854775807L))) * 961);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AdPlaybackState(adsId=null, adResumePositionUs=0, adGroups=[");
        int i = 0;
        while (true) {
            a[] aVarArr = this.f12584b;
            if (i >= aVarArr.length) {
                sb.append("])");
                return sb.toString();
            }
            sb.append("adGroup(timeUs=0, ads=[");
            aVarArr[i].getClass();
            for (int i10 = 0; i10 < aVarArr[i].f12565e.length; i10++) {
                sb.append("ad(state=");
                int i11 = aVarArr[i].f12565e[i10];
                if (i11 == 0) {
                    sb.append('_');
                } else if (i11 == 1) {
                    sb.append('R');
                } else if (i11 == 2) {
                    sb.append('S');
                } else if (i11 == 3) {
                    sb.append('P');
                } else if (i11 != 4) {
                    sb.append('?');
                } else {
                    sb.append('!');
                }
                sb.append(", durationUs=");
                sb.append(aVarArr[i].f[i10]);
                sb.append(')');
                if (i10 < aVarArr[i].f12565e.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i < aVarArr.length - 1) {
                sb.append(", ");
            }
            i++;
        }
    }
}
