package fe;

import cf.d;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class a implements Iterable, ce.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f4817u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f4818v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f4819w;

    public a(int i, int i10, int i11) {
        if (i11 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i11 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f4817u = i;
        this.f4818v = d.o(i, i10, i11);
        this.f4819w = i11;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        if (isEmpty() && ((a) obj).isEmpty()) {
            return true;
        }
        a aVar = (a) obj;
        return this.f4817u == aVar.f4817u && this.f4818v == aVar.f4818v && this.f4819w == aVar.f4819w;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f4817u * 31) + this.f4818v) * 31) + this.f4819w;
    }

    public boolean isEmpty() {
        int i = this.f4819w;
        int i10 = this.f4818v;
        int i11 = this.f4817u;
        return i > 0 ? i11 > i10 : i11 < i10;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new b(this.f4817u, this.f4818v, this.f4819w);
    }

    public String toString() {
        StringBuilder sb2;
        int i = this.f4818v;
        int i10 = this.f4817u;
        int i11 = this.f4819w;
        if (i11 > 0) {
            sb2 = new StringBuilder();
            sb2.append(i10);
            sb2.append("..");
            sb2.append(i);
            sb2.append(" step ");
            sb2.append(i11);
        } else {
            sb2 = new StringBuilder();
            sb2.append(i10);
            sb2.append(" downTo ");
            sb2.append(i);
            sb2.append(" step ");
            sb2.append(-i11);
        }
        return sb2.toString();
    }
}
