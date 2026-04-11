package ie;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class m extends l {
    public static Integer F(String str) {
        boolean z2;
        int i;
        int i10;
        cf.d.e(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i11 = 0;
        char cCharAt = str.charAt(0);
        int i12 = -2147483647;
        if (be.h.f(cCharAt, 48) < 0) {
            i = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z2 = false;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                i12 = Integer.MIN_VALUE;
                z2 = true;
            }
        } else {
            z2 = false;
            i = 0;
        }
        int i13 = -59652323;
        while (i < length) {
            int iDigit = Character.digit((int) str.charAt(i), 10);
            if (iDigit < 0) {
                return null;
            }
            if ((i11 < i13 && (i13 != -59652323 || i11 < (i13 = i12 / 10))) || (i10 = i11 * 10) < i12 + iDigit) {
                return null;
            }
            i11 = i10 - iDigit;
            i++;
        }
        return z2 ? Integer.valueOf(i11) : Integer.valueOf(-i11);
    }

    public static Long G(String str) {
        boolean z2;
        cf.d.e(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i = 0;
        char cCharAt = str.charAt(0);
        long j5 = -9223372036854775807L;
        if (be.h.f(cCharAt, 48) < 0) {
            z2 = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z2 = false;
                i = 1;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                j5 = Long.MIN_VALUE;
                i = 1;
            }
        } else {
            z2 = false;
        }
        long j8 = 0;
        long j10 = -256204778801521550L;
        while (i < length) {
            int iDigit = Character.digit((int) str.charAt(i), 10);
            if (iDigit < 0) {
                return null;
            }
            if (j8 < j10) {
                if (j10 != -256204778801521550L) {
                    return null;
                }
                j10 = j5 / ((long) 10);
                if (j8 < j10) {
                    return null;
                }
            }
            long j11 = j8 * ((long) 10);
            long j12 = iDigit;
            if (j11 < j5 + j12) {
                return null;
            }
            j8 = j11 - j12;
            i++;
        }
        return z2 ? Long.valueOf(j8) : Long.valueOf(-j8);
    }
}
