package je;

import be.h;
import e6.j;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Comparable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final long f6956v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final long f6957w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f6958x = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f6959u;

    static {
        int i = b.f6960a;
        f6956v = a.a.g(4611686018427387903L);
        f6957w = a.a.g(-4611686018427387903L);
    }

    public /* synthetic */ a(long j5) {
        this.f6959u = j5;
    }

    public static final long a(long j5, long j8) {
        long j10 = 1000000;
        long j11 = j8 / j10;
        long j12 = j5 + j11;
        if (-4611686018426L > j12 || j12 >= 4611686018427L) {
            return a.a.g(ga.b.d(j12));
        }
        long j13 = ((j12 * j10) + (j8 - (j11 * j10))) << 1;
        int i = b.f6960a;
        return j13;
    }

    public static final void b(StringBuilder sb2, int i, int i10, int i11, String str) {
        CharSequence charSequenceSubSequence;
        sb2.append(i);
        if (i10 != 0) {
            sb2.append('.');
            String strValueOf = String.valueOf(i10);
            h.e(strValueOf, "<this>");
            if (i11 < 0) {
                throw new IllegalArgumentException(j.j(i11, "Desired length ", " is less than zero."));
            }
            if (i11 <= strValueOf.length()) {
                charSequenceSubSequence = strValueOf.subSequence(0, strValueOf.length());
            } else {
                StringBuilder sb3 = new StringBuilder(i11);
                int length = i11 - strValueOf.length();
                int i12 = 1;
                if (1 <= length) {
                    while (true) {
                        sb3.append('0');
                        if (i12 == length) {
                            break;
                        } else {
                            i12++;
                        }
                    }
                }
                sb3.append((CharSequence) strValueOf);
                charSequenceSubSequence = sb3;
            }
            String string = charSequenceSubSequence.toString();
            int i13 = -1;
            int length2 = string.length() - 1;
            if (length2 >= 0) {
                while (true) {
                    int i14 = length2 - 1;
                    if (string.charAt(length2) != '0') {
                        i13 = length2;
                        break;
                    } else if (i14 < 0) {
                        break;
                    } else {
                        length2 = i14;
                    }
                }
            }
            int i15 = i13 + 1;
            if (i15 < 3) {
                sb2.append((CharSequence) string, 0, i15);
            } else {
                sb2.append((CharSequence) string, 0, ((i13 + 3) / 3) * 3);
            }
        }
        sb2.append(str);
    }

    public static final boolean c(long j5) {
        return j5 == f6956v || j5 == f6957w;
    }

    public static final long d(long j5, c cVar) {
        h.e(cVar, "unit");
        if (j5 == f6956v) {
            return Long.MAX_VALUE;
        }
        if (j5 == f6957w) {
            return Long.MIN_VALUE;
        }
        long j8 = j5 >> 1;
        c cVar2 = (((int) j5) & 1) == 0 ? c.NANOSECONDS : c.MILLISECONDS;
        h.e(cVar2, "sourceUnit");
        return cVar.f6966u.convert(j8, cVar2.f6966u);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j5 = ((a) obj).f6959u;
        long j8 = this.f6959u;
        long j10 = j8 ^ j5;
        if (j10 >= 0 && (((int) j10) & 1) != 0) {
            int i = (((int) j8) & 1) - (((int) j5) & 1);
            return j8 < 0 ? -i : i;
        }
        if (j8 < j5) {
            return -1;
        }
        return j8 == j5 ? 0 : 1;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f6959u == ((a) obj).f6959u;
        }
        return false;
    }

    public final int hashCode() {
        long j5 = this.f6959u;
        return (int) (j5 ^ (j5 >>> 32));
    }

    public final String toString() {
        long j5;
        int iD;
        int i;
        long j8;
        int i10;
        int i11;
        long j10 = this.f6959u;
        if (j10 == 0) {
            return "0s";
        }
        if (j10 == f6956v) {
            return "Infinity";
        }
        if (j10 == f6957w) {
            return "-Infinity";
        }
        boolean z2 = j10 < 0;
        StringBuilder sb2 = new StringBuilder();
        if (z2) {
            sb2.append('-');
        }
        if (j10 < 0) {
            j10 = ((long) (((int) j10) & 1)) + ((-(j10 >> 1)) << 1);
            int i12 = b.f6960a;
        }
        long jD = d(j10, c.DAYS);
        int iD2 = c(j10) ? 0 : (int) (d(j10, c.HOURS) % ((long) 24));
        if (c(j10)) {
            j5 = 0;
            iD = 0;
        } else {
            j5 = 0;
            iD = (int) (d(j10, c.MINUTES) % ((long) 60));
        }
        int iD3 = c(j10) ? 0 : (int) (d(j10, c.SECONDS) % ((long) 60));
        if (c(j10)) {
            i = 1;
            i10 = 0;
        } else {
            if ((((int) j10) & 1) == 1) {
                i = 1;
                j8 = ((j10 >> 1) % ((long) 1000)) * ((long) 1000000);
            } else {
                i = 1;
                j8 = (j10 >> 1) % ((long) 1000000000);
            }
            i10 = (int) j8;
        }
        int i13 = jD != j5 ? i : 0;
        int i14 = iD2 != 0 ? i : 0;
        int i15 = iD != 0 ? i : 0;
        int i16 = (iD3 == 0 && i10 == 0) ? 0 : i;
        if (i13 != 0) {
            sb2.append(jD);
            sb2.append('d');
            i11 = i;
        } else {
            i11 = 0;
        }
        if (i14 != 0 || (i13 != 0 && (i15 != 0 || i16 != 0))) {
            int i17 = i11 + 1;
            if (i11 > 0) {
                sb2.append(' ');
            }
            sb2.append(iD2);
            sb2.append('h');
            i11 = i17;
        }
        if (i15 != 0 || (i16 != 0 && (i14 != 0 || i13 != 0))) {
            int i18 = i11 + 1;
            if (i11 > 0) {
                sb2.append(' ');
            }
            sb2.append(iD);
            sb2.append('m');
            i11 = i18;
        }
        if (i16 != 0) {
            int i19 = i11 + 1;
            if (i11 > 0) {
                sb2.append(' ');
            }
            if (iD3 != 0 || i13 != 0 || i14 != 0 || i15 != 0) {
                b(sb2, iD3, i10, 9, "s");
            } else if (i10 >= 1000000) {
                b(sb2, i10 / 1000000, i10 % 1000000, 6, "ms");
            } else if (i10 >= 1000) {
                b(sb2, i10 / 1000, i10 % 1000, 3, "us");
            } else {
                sb2.append(i10);
                sb2.append("ns");
            }
            i11 = i19;
        }
        if (z2 && i11 > i) {
            sb2.insert(i, '(').append(')');
        }
        return sb2.toString();
    }
}
