package da;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends AbstractList implements RandomAccess, Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int[] f4114u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f4115v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f4116w;

    public b(int i, int i10, int[] iArr) {
        this.f4114u = iArr;
        this.f4115v = i;
        this.f4116w = i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (obj instanceof Integer) {
            return q1.c.E(this.f4114u, ((Integer) obj).intValue(), this.f4115v, this.f4116w) != -1;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return super.equals(obj);
        }
        b bVar = (b) obj;
        int size = size();
        if (bVar.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (this.f4114u[this.f4115v + i] != bVar.f4114u[bVar.f4115v + i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        q1.c.i(i, size());
        return Integer.valueOf(this.f4114u[this.f4115v + i]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i10 = this.f4115v; i10 < this.f4116w; i10++) {
            i = (i * 31) + this.f4114u[i10];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i = this.f4116w;
        int[] iArr = this.f4114u;
        int i10 = this.f4115v;
        int iE = q1.c.E(iArr, iIntValue, i10, i);
        if (iE >= 0) {
            return iE - i10;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int i;
        if (obj instanceof Integer) {
            int iIntValue = ((Integer) obj).intValue();
            int i10 = this.f4116w;
            while (true) {
                i10--;
                i = this.f4115v;
                if (i10 < i) {
                    i10 = -1;
                    break;
                }
                if (this.f4114u[i10] == iIntValue) {
                    break;
                }
            }
            if (i10 >= 0) {
                return i10 - i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        Integer num = (Integer) obj;
        q1.c.i(i, size());
        int i10 = this.f4115v + i;
        int[] iArr = this.f4114u;
        int i11 = iArr[i10];
        num.getClass();
        iArr[i10] = num.intValue();
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4116w - this.f4115v;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i, int i10) {
        q1.c.l(i, i10, size());
        if (i == i10) {
            return Collections.EMPTY_LIST;
        }
        int i11 = this.f4115v;
        return new b(i + i11, i11 + i10, this.f4114u);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb2 = new StringBuilder(size() * 5);
        sb2.append('[');
        int[] iArr = this.f4114u;
        int i = this.f4115v;
        sb2.append(iArr[i]);
        while (true) {
            i++;
            if (i >= this.f4116w) {
                sb2.append(']');
                return sb2.toString();
            }
            sb2.append(", ");
            sb2.append(iArr[i]);
        }
    }
}
