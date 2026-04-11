package ke;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class a implements Iterable, he.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f7418v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f7419w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f7420x;

    public a(int i, int i10, int i11) {
        if (i11 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i11 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f7418v = i;
        this.f7419w = com.bumptech.glide.c.r(i, i10, i11);
        this.f7420x = i11;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        if (isEmpty() && ((a) obj).isEmpty()) {
            return true;
        }
        a aVar = (a) obj;
        return this.f7418v == aVar.f7418v && this.f7419w == aVar.f7419w && this.f7420x == aVar.f7420x;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f7418v * 31) + this.f7419w) * 31) + this.f7420x;
    }

    public boolean isEmpty() {
        int i = this.f7420x;
        int i10 = this.f7419w;
        int i11 = this.f7418v;
        return i > 0 ? i11 > i10 : i11 < i10;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new b(this.f7418v, this.f7419w, this.f7420x);
    }

    public String toString() {
        StringBuilder sb;
        int i = this.f7419w;
        int i10 = this.f7418v;
        int i11 = this.f7420x;
        if (i11 > 0) {
            sb = new StringBuilder();
            sb.append(i10);
            sb.append("..");
            sb.append(i);
            sb.append(" step ");
            sb.append(i11);
        } else {
            sb = new StringBuilder();
            sb.append(i10);
            sb.append(" downTo ");
            sb.append(i);
            sb.append(" step ");
            sb.append(-i11);
        }
        return sb.toString();
    }
}
