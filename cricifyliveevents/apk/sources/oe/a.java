package oe;

import com.bumptech.glide.d;
import com.bumptech.glide.f;
import ge.i;
import ne.h;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Comparable {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final long f9765w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final long f9766x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f9767y = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f9768v;

    static {
        int i = b.f9769a;
        f9765w = d.n(4611686018427387903L);
        f9766x = d.n(-4611686018427387903L);
    }

    public static final long a(long j4, long j7) {
        long j10 = 1000000;
        long j11 = j7 / j10;
        long j12 = j4 + j11;
        if (-4611686018426L > j12 || j12 >= 4611686018427L) {
            return d.n(f.h(j12));
        }
        return d.o((j12 * j10) + (j7 - (j11 * j10)));
    }

    public static final void b(StringBuilder sb, int i, int i10, int i11, String str, boolean z10) {
        sb.append(i);
        if (i10 != 0) {
            sb.append('.');
            String strN0 = h.n0(i11, String.valueOf(i10));
            int i12 = -1;
            int length = strN0.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i13 = length - 1;
                    if (strN0.charAt(length) != '0') {
                        i12 = length;
                        break;
                    } else if (i13 < 0) {
                        break;
                    } else {
                        length = i13;
                    }
                }
            }
            int i14 = i12 + 1;
            if (z10 || i14 >= 3) {
                sb.append((CharSequence) strN0, 0, ((i12 + 3) / 3) * 3);
            } else {
                sb.append((CharSequence) strN0, 0, i14);
            }
        }
        sb.append(str);
    }

    public static int c(long j4, long j7) {
        long j10 = j4 ^ j7;
        if (j10 < 0 || (((int) j10) & 1) == 0) {
            return i.g(j4, j7);
        }
        int i = (((int) j4) & 1) - (((int) j7) & 1);
        return j4 < 0 ? -i : i;
    }

    public static final boolean d(long j4) {
        return j4 == f9765w || j4 == f9766x;
    }

    public static final long e(long j4, c cVar) {
        i.e(cVar, "unit");
        if (j4 == f9765w) {
            return Long.MAX_VALUE;
        }
        if (j4 == f9766x) {
            return Long.MIN_VALUE;
        }
        long j7 = j4 >> 1;
        c cVar2 = (((int) j4) & 1) == 0 ? c.NANOSECONDS : c.MILLISECONDS;
        i.e(cVar2, "sourceUnit");
        return cVar.f9774v.convert(j7, cVar2.f9774v);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return c(this.f9768v, ((a) obj).f9768v);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f9768v == ((a) obj).f9768v;
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f9768v;
        return (int) (j4 ^ (j4 >>> 32));
    }

    public final String toString() {
        long j4;
        int iE;
        int i;
        long j7;
        int i10;
        int i11;
        long j10 = this.f9768v;
        if (j10 == 0) {
            return "0s";
        }
        if (j10 == f9765w) {
            return "Infinity";
        }
        if (j10 == f9766x) {
            return "-Infinity";
        }
        boolean z10 = j10 < 0;
        StringBuilder sb = new StringBuilder();
        if (z10) {
            sb.append('-');
        }
        if (j10 < 0) {
            j10 = ((long) (((int) j10) & 1)) + ((-(j10 >> 1)) << 1);
            int i12 = b.f9769a;
        }
        long jE = e(j10, c.DAYS);
        int iE2 = d(j10) ? 0 : (int) (e(j10, c.HOURS) % ((long) 24));
        if (d(j10)) {
            j4 = 0;
            iE = 0;
        } else {
            j4 = 0;
            iE = (int) (e(j10, c.MINUTES) % ((long) 60));
        }
        int iE3 = d(j10) ? 0 : (int) (e(j10, c.SECONDS) % ((long) 60));
        if (d(j10)) {
            i = 1;
            i10 = 0;
        } else {
            if ((((int) j10) & 1) == 1) {
                i = 1;
                j7 = ((j10 >> 1) % ((long) 1000)) * ((long) 1000000);
            } else {
                i = 1;
                j7 = (j10 >> 1) % ((long) 1000000000);
            }
            i10 = (int) j7;
        }
        int i13 = jE != j4 ? i : 0;
        int i14 = iE2 != 0 ? i : 0;
        int i15 = iE != 0 ? i : 0;
        int i16 = (iE3 == 0 && i10 == 0) ? 0 : i;
        if (i13 != 0) {
            sb.append(jE);
            sb.append('d');
            i11 = i;
        } else {
            i11 = 0;
        }
        if (i14 != 0 || (i13 != 0 && (i15 != 0 || i16 != 0))) {
            int i17 = i11 + 1;
            if (i11 > 0) {
                sb.append(' ');
            }
            sb.append(iE2);
            sb.append('h');
            i11 = i17;
        }
        if (i15 != 0 || (i16 != 0 && (i14 != 0 || i13 != 0))) {
            int i18 = i11 + 1;
            if (i11 > 0) {
                sb.append(' ');
            }
            sb.append(iE);
            sb.append('m');
            i11 = i18;
        }
        if (i16 != 0) {
            int i19 = i11 + 1;
            if (i11 > 0) {
                sb.append(' ');
            }
            if (iE3 != 0 || i13 != 0 || i14 != 0 || i15 != 0) {
                b(sb, iE3, i10, 9, "s", false);
            } else if (i10 >= 1000000) {
                b(sb, i10 / 1000000, i10 % 1000000, 6, "ms", false);
            } else if (i10 >= 1000) {
                b(sb, i10 / 1000, i10 % 1000, 3, "us", false);
            } else {
                sb.append(i10);
                sb.append("ns");
            }
            i11 = i19;
        }
        if (z10 && i11 > i) {
            sb.insert(i, '(').append(')');
        }
        return sb.toString();
    }
}
